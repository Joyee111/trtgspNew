package com.sinosoft.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.frame.service.UserExistsException;
import com.sinosoft.role.Role;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.PropertiesUtil;
import com.sinosoft.util.SystemConfigUtil;
import com.sinosoft.util.UtilJson;

@SuppressWarnings("unchecked")
@Controller
public class UserFormController extends BaseFormController {

	private final String shiropage = "redirect:/index.html";
	private final String userlistpage = "redirect:/user/users.html";
	private final String edituserpage = "redirect:/user/edituserform.html";
	private MessageSource messageSource = null;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	// 保存用户
	@RequestMapping("/user/saveuser.html")
	public String onSubmit(User user, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MessageSourceAccessor text = new MessageSourceAccessor(messageSource,
				request.getLocale());
		BigDecimalConverter bd = new BigDecimalConverter(null);
		DateConverter dc = new DateConverter(null);
		ConvertUtils.register(bd, java.math.BigDecimal.class);
		ConvertUtils.register(dc, java.util.Date.class);
		String page = request.getParameter("tz");
		String pagename = DisplayGetPage.getPageName("users", request);
		String postmethod = request.getParameter("ptmeth");
		if ("".equalsIgnoreCase(page)) {
			page = "1";
		}

		if (request.getParameter("cancel") != null) {
			return userlistpage;
		}

		if (request.getParameter("delete") != null) {
			boolean boo = getUserManager().removeUser(user.getId().toString());
			if (!boo) {
				System.out.println("not delete!");
			}
		} else {
			if (isAdd(request)) {
				int isuint = getUserManager().isUnique(user.getUsername(),
						user.getEmail());
				if (isuint > 0) {
					saveError(request, text
							.getMessage("errors.existing.user", new Object[] {
									user.getUsername(), user.getEmail() }));
					return "/user/userform";
				}
				// 添加
				String[] userRoles = request.getParameterValues("userRoles");
				List<Role> rolelist = (List<Role>) this.getServletContext()
						.getAttribute(Constants.AVAILIST_ROLES);
				if (userRoles != null) {
					Set<Role> roles = new HashSet<Role>();
					for (String rolename : userRoles) {
						for (Role r : rolelist) {
							if (r.getRolename().equals(rolename)) {
								roles.add(r);
							}
						}
					}
					user.setRoles(roles);
				}
				getUserManager().SaveUser(user);
			} else {
				int isuint = getUserManager().isUnique(user.getUsername(),
						user.getEmail());
				// 判断是否admin用户,不能修改admin用户
				Subject subject = SecurityUtils.getSubject();
				if (user.getUsername().equals("admin")
						&& !user.getUsername().equals(subject.getPrincipal())) {
					return "redirect:/user/userform.html?method=update&id="
							+ user.getId();
				}
				if (isuint > 1) {
					saveError(request, text
							.getMessage("errors.existing.user", new Object[] {
									user.getUsername(), user.getEmail() }));
					return "user/userform";
				}
				User newuser = getUserManager().getUser(user.getId()+"");
				// 修改
				String[] userRoles = request.getParameterValues("userRoles");
				List<Role> rolelist = (List<Role>) this.getServletContext()
						.getAttribute(Constants.AVAILIST_ROLES);
				newuser.getRoles().clear();
				if (userRoles != null) {
					Set<Role> roles = new HashSet<Role>();
					for (String roleid : userRoles) {
						for (Role r : rolelist) {
							if (r.getRoleid().toString().equals(roleid)) {
								roles.add(r);
							}
						}
					}
					newuser.setRoles(roles);
				}
				newuser = this.changeUser(newuser,user);
				getUserManager().saveOrUpdateUser(newuser);
			}
		}
		if ("select".equalsIgnoreCase(postmethod)) {
			return "redirect:/user/users.html?method=select&"
					+ pagename + "=" + page;
		} else {
			return "redirect:/user/users.html?method=list&"
					+ pagename + "=" + page;
		}
	}

	// 管理员添加，修改用户返回的对象
	@ModelAttribute
	@RequestMapping("/user/userform.html")
	protected String showForm(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String op = request.getParameter("method");
		String[] str = PropertiesUtil.getPropertiesValue("territory", request);
		Map<String, String> map = new HashMap<String, String>();
		map = getMap(str);
		String[] locks = PropertiesUtil.getPropertiesValue("user.locks", request);
		Map<String, String> locksmap = new HashMap<String, String>();
		locksmap = getMap(locks);

		User user = null;
		if (isAdd(request)) {
			user = new User();
		} else if (op.equals("update")) {
			String userId = request.getParameter("id");
			if (!StringUtils.isBlank(userId)) {
				user = getUserManager().getUser(userId);
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("locksmap", locksmap);
		model.addAttribute("territory", map);
		String page = request.getParameter("tz");
		String pagename = DisplayGetPage.getPageName("users", request);
		model.addAttribute("tzpage", page);
		model.addAttribute("pagename", pagename);
		model.addAttribute("ptmeth", request.getParameter("ptmeth"));
		String[] gradelist = SystemConfigUtil.getSystemValue("grade", this.getServletContext());
		model.addAttribute("grade",gradelist);
		String[] userlist = PropertiesUtil.getPropertiesValue("user.usertypes", request);
		Map usermap = new HashMap();
		usermap = getMap(userlist);
		model.addAttribute("usertypemap",usermap);
		return "user/userform";
	}

	// 用户查询
	@RequestMapping("/user/users.html")
	public ModelAndView handleRequest(User usersearchlist,
			HttpServletRequest request, Model model) {
		List<User> userlist = new ArrayList<User>();
		String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		HttpSession session = request.getSession(true);
		String method = request.getParameter("method");
		if(method.equals("select"))
		{
			if (!ValidateNull(usersearchlist)) {
				if(session.getAttribute("usercondition")!=null)
					usersearchlist = (User)session.getAttribute("usercondition");
			} else {
				session.removeAttribute("usercondition");
				session.setAttribute("usercondition", usersearchlist);
			}
			model.addAttribute("ptmeth", "select");
		}
		else
		{
			model.addAttribute("ptmeth", "list");
		}
		if (page == null) {
			userlist = getUserManager().getUserlistByPage(usersearchlist, 0,
					Constants.pagesize);
		} else {
			userlist = getUserManager().getUserlistByPage(usersearchlist,
					(Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		int resultSize = getUserManager().getOrderInfoCount(usersearchlist);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		model.addAttribute("user", usersearchlist);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		String[] str = PropertiesUtil.getPropertiesValue("territory", request);
		Map<String, String> map1 = new HashMap<String, String>();
		map1 = getMap(str);
		model.addAttribute("territory", map1);
		
		return new ModelAndView("user/userlist", Constants.USER_LIST, userlist);
	}

	// 用户编辑个人信息
	@RequestMapping("/user/saveedituser.html")
	public String editUser(User user, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return shiropage;
		}

		int isuint = getUserManager().isUnique(user.getUsername(),
				user.getEmail());
		if (isuint > 1) {
			errors.rejectValue("username", "errors.existing.user",
					new Object[] { user.getUsername(), user.getEmail() },
					"duplicate user");
			return edituserpage;
		}
		User newuser = getUserManager().get(user.getId());
		if (newuser != null) {
			newuser.setPassword(user.getPassword());
			newuser.setRealname(user.getRealname());
			newuser.setUsersex(user.getUsersex());
			newuser.setPassprompt(user.getPassprompt());
			newuser.setPassanswer(user.getPassanswer());
			newuser.setEmail(user.getEmail());
			newuser.setIdentitycard(user.getIdentitycard());
			newuser.setPostcode(user.getPostcode());
			newuser.setMobile(user.getMobile());
			newuser.setFax(user.getFax());
			newuser.setAddress(user.getAddress());
			newuser.setTelephone(user.getTelephone());
			newuser.setIpaddress(user.getIpaddress());
			newuser.setCompany(user.getCompany());
			newuser.setCompanyaddress(user.getCompanyaddress());
			newuser.setLawyername(user.getLawyername());
			newuser.setLawyerphone(user.getLawyerphone());
			newuser.setLawyermail(user.getLawyermail());
			newuser.setCompanycode(user.getCompanycode());
			newuser.setCompanyfax(user.getCompanyfax());
			newuser.setCompanyip(user.getCompanyip());
			newuser.setCountry(user.getCountry());
			newuser.setProvince(user.getProvince());
			newuser.setCity(user.getCity());
			newuser.setCounty(user.getCounty());
			newuser.setTerritory(user.getTerritory());
			// 保存用户
			newuser = getUserManager().saveOrUpdateUser(newuser);
			if (newuser != null) {
				List<User> sessionuserlist = (List<User>) this
						.getServletContext().getAttribute(
								Constants.SESSION_USER_LIST);
				for (User u : sessionuserlist) {
					if (u.getUsername().equals(newuser.getUsername())) {
						sessionuserlist.remove(u);
						sessionuserlist.add(newuser);
						this.getServletContext().removeAttribute(
								Constants.SESSION_USER_LIST);
						this.getServletContext().setAttribute(
								Constants.SESSION_USER_LIST, sessionuserlist);
						break;
					}
				}
			}
			return shiropage;
		} else {
			return edituserpage;
		}
	}

	// 编辑个人信息
	@RequestMapping("/user/edituserform.html")
	public String showEditUser(ModelMap model,HttpServletRequest request) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		User user = null;
		String username = subject.getPrincipal().toString();
		List<User> userlist = (List<User>) this.getServletContext()
				.getAttribute(Constants.SESSION_USER_LIST);
		for (User u : userlist) {
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		model.addAttribute("user", user);
		String[] str = PropertiesUtil.getPropertiesValue("territory", request);
		Map<String, String> map1 = new HashMap<String, String>();
		map1 = getMap(str);
		model.addAttribute("territory", map1);
		return "user/edituserform";
	}

	// 判断是否Add
	protected boolean isAdd(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("add"));
	}

	// 判断是否update
	protected boolean isUpdate(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("update"));
	}

	/**
	 * 解析string数组，返回map对象
	 * 
	 * @param str
	 * @return
	 */
	public Map getMap(String[] str) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < str.length; i++) {
			String[] obj = str[i].split("_");
			if (obj.length > 1)
				map.put(obj[1], obj[0]);
			else
				map.put(obj[0], obj[0]);
		}
		return map;
	}

	public boolean ValidateNull(User user) {
		if (user.getUsername() != null || user.getRealname() != null
				|| user.getCompany() != null || user.getTerritory() != null
				|| user.getIslocked() != null || user.getCountry() != null
				|| user.getProvince()!=null || user.getCity() != null 
				|| user.getRegistertime()!=null) {
			return true;
		} else {
			return false;
		}
	}
	
	public User changeUser(User newuser,User olduser)
	{
		newuser.setPassword(olduser.getPassword());
		newuser.setUsername(olduser.getUsername());
		newuser.setRealname(olduser.getRealname());
		newuser.setUsersex(olduser.getUsersex());
		newuser.setPassprompt(olduser.getPassprompt());
		newuser.setPassanswer(olduser.getPassanswer());
		newuser.setEmail(olduser.getEmail());
		newuser.setIdentitycard(olduser.getIdentitycard());
		newuser.setPostcode(olduser.getPostcode());
		newuser.setMobile(olduser.getMobile());
		newuser.setTelephone(olduser.getTelephone());
		newuser.setFax(olduser.getFax());
		newuser.setAddress(olduser.getAddress());
		newuser.setIpaddress(olduser.getIpaddress());
		newuser.setIslocked(olduser.getIslocked());
		newuser.setCompany(olduser.getCompany());
		newuser.setCompanyaddress(olduser.getCompanyaddress());
		newuser.setLawyername(olduser.getLawyername());
		newuser.setLawyerphone(olduser.getLawyerphone());
		newuser.setLawyermail(olduser.getLawyermail());
		newuser.setCompanycode(olduser.getCompanycode());
		newuser.setCompanyfax(olduser.getCompanyfax());
		newuser.setCompanyip(olduser.getCompanyip());
		newuser.setCountry(olduser.getCountry());
		newuser.setProvince(olduser.getProvince());
		newuser.setCity(olduser.getCity());
		newuser.setCounty(olduser.getCounty());
		newuser.setTerritory(olduser.getTerritory());
		newuser.setGrade(olduser.getGrade());
		newuser.setFtphomedirectory(olduser.getFtphomedirectory());
		newuser.setMaxloginnumber(olduser.getMaxloginnumber());
		newuser.setIdletime(olduser.getIdletime());
		newuser.setUploadrate(olduser.getUploadrate());
		newuser.setDownloadrate(olduser.getDownloadrate());
		newuser.setFtpport(olduser.getFtpport());
		newuser.setFtpurl(olduser.getFtpurl());
		newuser.setMaxloginnumber(olduser.getMaxloginnumber());
		newuser.setMaxloginperip(olduser.getMaxloginperip());
		return newuser;
	}
	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return 
	 */
	
	@RequestMapping("/user/ajaxQueryUser.html")
	public  String ajaxQueryUser (Model model ,HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		User user = null;
		if(userId!=null && !userId.trim().equals("")){
			 user = getUserManager().getUser(userId);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if(user!=null){
			map.put("user", user);
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/user/ajaxChangeUserPassowd.html")
	public String ajaxChangPassWord(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String userId  =  request.getParameter("userId");
		String password = request.getParameter("password");
		User user = getUserManager().getUser(userId);
		String responseStr="";
		user.setPassword(password);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		 User u = 	getUserManager().saveOrUpdateUser(user);
		 if(u!=null && u.getId()!=null && u.getId()>0){
			 responseStr = URLEncoder.encode("修改密码成功","UTF-8");
			 map.put("success", responseStr);
	
		 }else{
			 responseStr = URLEncoder.encode("修改密码失败","UTF-8");
			 map.put("success", responseStr);
		 }
		} catch (UserExistsException e) {
			 responseStr = URLEncoder.encode("修改密码失败","UTF-8");
			 map.put("success", responseStr);
			 UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
}
