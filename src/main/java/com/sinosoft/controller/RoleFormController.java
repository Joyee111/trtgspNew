package com.sinosoft.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.frame.model.LabelValue;
import com.sinosoft.role.Role;
import com.sinosoft.role.RoleManager;
import com.sinosoft.util.DisplayGetPage;

@Controller
@RequestMapping("/user/roleform.html")
public class RoleFormController extends BaseFormController {
	private RoleManager rolemgr;
	
	@Autowired
	public void setRoleManager(RoleManager rolemgr) {
		this.rolemgr = rolemgr;
	}

	public RoleFormController() {
		setCancelView("redirect:/shirologin.html");
		setSuccessView("redirect:/user/roleform.html?method=query&operate=select");
	}

	/**
	 * 修改，添加记录的保存操作
	 * @param role
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Role role, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String page = request.getParameter("tz");
		String pagename = DisplayGetPage.getPageName("roles", request);
		String postmethod = request.getParameter("ptmeth");
		if ("".equalsIgnoreCase(page)) {
			page = "1";
		}

		if (request.getParameter("delete") != null) {
			rolemgr.removeRole(role.getRoleid());
			Long roleid = null;
			List<Role> rolelist = (List<Role>) this.getServletContext().getAttribute(Constants.AVAILIST_ROLES);
			for (Role r : rolelist) {
				if(r.getRoleid().equals(role.getRoleid()))
				{
					roleid = r.getRoleid();
					rolelist.remove(r);
					break;
				}
			}
			this.getServletContext().removeAttribute(Constants.AVAILIST_ROLES);
			this.getServletContext().setAttribute(Constants.AVAILIST_ROLES, rolelist);
			
			List<LabelValue> rolelabel = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_ROLES);
			for (LabelValue lv : rolelabel) {
				if(roleid!=null && lv.getLabel().toString().equals(roleid))
				{
					rolelabel.remove(lv);
					break;
				}
			}
			this.getServletContext().removeAttribute(Constants.AVAILABLE_ROLES);
			this.getServletContext().setAttribute(Constants.AVAILABLE_ROLES, rolelabel);
		} else {
			List<Authoriy> plist = (List<Authoriy>) this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			String[] rpermissons = request.getParameter("permissons").split(",");
			if (rpermissons != null) {
				role.getAuthoriy().clear();
				Set<Authoriy> ps = new HashSet<Authoriy>();
				for (String p : rpermissons) {
					for (Authoriy pl : plist) {
						if(p.equals(pl.getAuthoriyid().toString()))
						{
							ps.add(pl);
						}
					}
				}
				role.setAuthoriy(ps);
			}
			String username = SecurityUtils.getSubject().getPrincipal().toString();
			role.setCreateuser(username);
			Role r = rolemgr.saveRole(role);
			if (r != null) {
				UpdateCache(request, r);
				String opera = request.getParameter("operator");
				if(opera.equals("Add"))
				{
					return "redirect:/user/roleform.html?method=query&operate=list";
				}
			} else {
				return "user/roleform";
			}
		}
		if ("select".equalsIgnoreCase(postmethod)) {
			return "redirect:/user/roleform.html?method=query&operate=select&"
					+ pagename + "=" + page;
		} else {
			return "redirect:/user/roleform.html?method=query&operate=list&"
					+ pagename + "=" + page;
		}
	}

	/**
	 * 添加，修改操作，返回给页面显示的对象
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Role showForm(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
		if (!isFormSubmission(request)) {
			String roleId = request.getParameter("id");

			Subject subject = SecurityUtils.getSubject();
			if (subject != null) {
				if (subject.isRemembered()) {
					request.getSession().setAttribute("cookieLogin", "true");
					saveMessage(request, getText("userProfile.cookieLogin",
							request.getLocale()));
				}
			}
			String page = request.getParameter("tz");
			String pagename = DisplayGetPage.getPageName("roles", request);
			model.addAttribute("tzpage", page);
			model.addAttribute("pagename", pagename);
			model.addAttribute("ptmeth", request.getParameter("ptmeth"));
			Role role = null;
			if (roleId == null && !isAdd(request)) {
				role = new Role();
			} else if (!StringUtils.isBlank(roleId)) {
				role = rolemgr.getRoleById(Long.parseLong(roleId));
			} else {
				role = new Role();
			}
			//查询所有的父资源
			List<Authoriy> pauthoriylist = new ArrayList<Authoriy>(); 
				//pmgr.getParentAuthoriyList();
			List<Authoriy> authoriylist = (List<Authoriy>) this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			for (Authoriy a : authoriylist) {
				if(a.getParentid()!=null && a.getParentid()==-1)
				{
					pauthoriylist.add(a);
				}
			}
			model.addAttribute("pauthoriylist",pauthoriylist);
			return role;
		} else {
			return rolemgr.getRole(request.getParameter("name"));
		}
	}
	
	//角色查询
	@RequestMapping(params="method=query")
	public ModelAndView handleRequest(@RequestParam(required=false,value="rolename") String query,Model model,HttpServletRequest request)
	{
		Role role = new Role();
		List<Role> rolelist = new ArrayList<Role>();
		String page = DisplayGetPage.getPageParamName("roles", request);// 第几页
		HttpSession session = request.getSession(true);
		String method = request.getParameter("operate");
		if(method.equals("select"))
		{
			if (query!=null && !query.isEmpty()) {
				if(session.getAttribute("usercondition")!=null)
					query = String.valueOf(session.getAttribute("rolecondition"));
			} else {
				session.removeAttribute("rolecondition");
				session.setAttribute("rolecondition", query);
			}
			model.addAttribute("ptmeth", "select");
		}
		else
		{
			model.addAttribute("ptmeth", "list");
		}
		if (page == null) {
			rolelist = rolemgr.getRolelistByPage(query, 0,
					Constants.pagesize);
		} else {
			rolelist = rolemgr.getRolelistByPage(query,
					(Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		int resultSize = rolemgr.getRolelistByPageCount(query);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("role",role);
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("pagesize",Constants.pagesize);
		return new ModelAndView("user/rolelist",Constants.ROLE_LIST,rolelist);
	}

	private boolean isFormSubmission(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("post");
	}

	protected boolean isAdd(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("add"));
	}
	
	protected boolean isUpdate(HttpServletRequest request)
	{
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("update"));
	}
	
	@SuppressWarnings("unchecked")
	protected void UpdateCache(HttpServletRequest request,Role r)
	{
		if(isUpdate(request))
		{
			//update Authoriylist
			List<Role> perlist = (List<Role>)this.getServletContext().getAttribute(Constants.AVAILIST_ROLES);
			for (Role role: perlist) {
				if(role.getRoleid().equals(r.getRoleid()))
				{
					role.setRolename(r.getRolename());
					break;
				}
			}
			this.getServletContext().setAttribute(Constants.AVAILIST_ROLES, perlist);
			//update Authoriylabels
			List<LabelValue> plabelvalues = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_ROLES);
			for (LabelValue ll : plabelvalues) {
				if(ll.getLabel().equals(r.getRoleid()))
				{
					
					ll.setLabel(r.getRoleid()+"");
					ll.setValue(r.getRolename());
					break;
				}
			}
//			plabelvalues.add(new LabelValue(r.getRoleid()+"",r.getRolename()));
			this.getServletContext().removeAttribute(Constants.AVAILABLE_ROLES);
			this.getServletContext().setAttribute(Constants.AVAILABLE_ROLES, plabelvalues);
//			SecurityUtils.getSubject();
		}
		else if(isAdd(request))
		{
			//update Authoriylist
			List<Role> perlist = (List<Role>)this.getServletContext().getAttribute(Constants.AVAILIST_ROLES);
			perlist.add(r);
			this.getServletContext().setAttribute(Constants.AVAILIST_ROLES, perlist);
			//update Authoriylabels
			List<LabelValue> plabelvalues = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_ROLES);
			plabelvalues.add(new LabelValue(r.getRoleid()+"",r.getRolename()));
			this.getServletContext().setAttribute(Constants.AVAILABLE_ROLES, plabelvalues);
		}
	}
}
