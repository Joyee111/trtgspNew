package com.sinosoft.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.role.Role;
import com.sinosoft.role.RoleManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.authoriy.Authoriy;
import com.sinosoft.authoriy.AuthoriyManager;
import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.frame.model.LabelValue;
import com.sinosoft.util.DisplayGetPage;

@Controller
@RequestMapping("user/authoriyform.html")
public class AuthoriyFormController extends BaseFormController {
	private AuthoriyManager pmgr;
	
	@Autowired
	public void setAuthoriyManager(AuthoriyManager pmgr) {
		this.pmgr = pmgr;
	}

    @Autowired
    private RoleManager roleManager;

	public AuthoriyFormController() {
		setCancelView("redirect:/shirologin.html");
		setSuccessView("redirect:/user/authoriyform.html?method=query");
	}
	
	
	/**
	 * 
	 * @param authoriy
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Authoriy authoriy, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("cancel") != null) {
			return getSuccessView();
		}
		

		if (request.getParameter("delete") != null) {
			pmgr.removeAuthoriy(authoriy.getAuthoriyid());
			String authoriyname = null;
			List<Authoriy> authoriylist = (List<Authoriy>) this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			for (Authoriy a : authoriylist) {
				if(a.getAuthoriyid().equals(authoriy.getAuthoriyid()))
				{
					authoriyname = a.getAuthoriyname();
					authoriylist.remove(a);
					break;
				}
			}
			
			List<LabelValue> authoriylabel = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_PERMISSONS);
			for (LabelValue lv : authoriylabel) {
				if(authoriyname!=null && lv.getLabel().equals(authoriyname))
				{
					authoriylabel.remove(lv);
					break;
				}
			}
			return getSuccessView();
		} else {
			Authoriy p = pmgr.saveAuthoriy(authoriy);
			if (p != null) {
				UpdateCache(request, p);
				return getSuccessView();
			} else {
				return "user/authoriyform";
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	protected Authoriy showForm(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
		if (!isFormSubmission(request)) {
			String pId = request.getParameter("id");
			Authoriy p = null;
            Authoriy parent = null;
			
			if (!StringUtils.isBlank(pId)) {
				p = pmgr.get(Long.parseLong(pId));
                if (p.getParentid().longValue() != -1l) {
                    parent = pmgr.get(p.getParentid());
                }
            } else {
				p = new Authoriy();
			}
			List<Authoriy> pauthoriylist = new ArrayList<Authoriy>(); 
			//pmgr.getParentAuthoriyList();
			/*List<Authoriy> authoriylist = (List<Authoriy>) this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			for (Authoriy a : authoriylist) {
				if(a.getParentid()!=null && a.getParentid()==-1)
				{
					pauthoriylist.add(a);
				}
			}
			model.addAttribute("pauthoriylist",pauthoriylist);*/
            model.addAttribute("parent",parent);
			return p;
		} else {
			return null;
		}
	}
	
	@RequestMapping(params="method=query")
	public ModelAndView handleRequest(Model model,Authoriy authoriy,HttpServletRequest request)
	{
		List<Authoriy> authoriylist = new ArrayList<Authoriy>();
		String page =  DisplayGetPage.getPageParamName("authoriy",request);//第几页
		if(page==null)
		{
			authoriylist = pmgr.getAuthoriyList(authoriy,0,Constants.pagesize);
		}
		else
		{
			authoriylist = pmgr.getAuthoriyList(authoriy,(Integer.parseInt(page)-1)*Constants.pagesize,Constants.pagesize);
		}
		int resultSize = pmgr.getAuthoriyCount(authoriy);
		model.addAttribute("resultSize",resultSize);
		model.addAttribute("pagesize",Constants.pagesize);
		model.addAttribute("authoriy",authoriy);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size/Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("user/authoriylist",Constants.AUTHORIY_LIST,authoriylist);
	}

    @RequestMapping(params="method=tree")
    @ResponseBody
    public  String ajaxTree(String id, HttpServletResponse response) throws IOException {
        String result = "";
        List<Authoriy> authoriyList;
        if (id == null || id.isEmpty()) {
            authoriyList = pmgr.getAuthoriyListByParentId(-1l);
        } else {
            authoriyList = pmgr.getAuthoriyListByParentId(Long.valueOf(id));
        }
        JSONArray array = new JSONArray();
        JSONObject object;
        if (authoriyList != null && !authoriyList.isEmpty()) {
            for (Authoriy authoriy : authoriyList) {
                object = new JSONObject();
                object.put("id", authoriy.getAuthoriyid());
                object.put("text", authoriy.getDescription());
                object.put("state", "closed");
                array.put(object);
            }
        }

        return array.toString();
    }

    @RequestMapping(params="method=entireTree")
    @ResponseBody
    public String entireTree(String roleId) {
        Role role = roleManager.getRoleById(Long.valueOf(roleId));
        return getEntireTree(-1l,role.getAuthoriy()).toString();
    }

    private JSONArray getEntireTree(Long parentId, Set<Authoriy> authoriySet) {
        JSONArray array = new JSONArray();
        JSONObject object = null;
        List<Authoriy> authoriyList = pmgr.getAuthoriyListByParentId(parentId);
        if(authoriyList!=null&&!authoriyList.isEmpty()) {
            for (Authoriy authoriy : authoriyList) {
                object = new JSONObject();
                object.put("id", authoriy.getAuthoriyid());
                object.put("text", authoriy.getDescription());
                object.put("state", "open");
                if (authoriySet != null && !authoriySet.isEmpty()) {
                    for (Authoriy currUserAuthoriy : authoriySet) {
                        if (currUserAuthoriy.getAuthoriyid().equals(authoriy.getAuthoriyid())) {
                            object.put("checked",true);
                        }
                    }
                }
                object.put("children",getEntireTree(authoriy.getAuthoriyid(), authoriySet));
                array.put(object);
            }
        }
        return array;
    }

    private boolean isFormSubmission(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("post");
	}
	
	protected boolean isUpdate(HttpServletRequest request)
	{
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("update"));
	}

	protected boolean isAdd(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("add"));
	}
	
	@SuppressWarnings("unchecked")
	protected void UpdateCache(HttpServletRequest request,Authoriy p)
	{
		if(isUpdate(request))
		{
			//update Authoriylist
			List<Authoriy> perlist = (List<Authoriy>)this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			for (Authoriy pl : perlist) {
				if(pl.getAuthoriyid().equals(p.getAuthoriyid()))
				{
					pl.setAuthoriyname(p.getAuthoriyname());
					break;
				}
			}
			this.getServletContext().setAttribute(Constants.AVAILIST_PERMISSONS, perlist);
			//update Authoriylabels
			List<LabelValue> plabelvalues = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_PERMISSONS);
			for (LabelValue ll : plabelvalues) {
				if(ll.getLabel().equals(p.getAuthoriyname()))
				{
					ll.setLabel(p.getAuthoriyname());
					ll.setValue(p.getDescription());
					break;
				}
			}
			plabelvalues.add(new LabelValue(p.getAuthoriyname(),p.getDescription()));
			this.getServletContext().setAttribute(Constants.AVAILABLE_PERMISSONS, plabelvalues);
		}
		else if(isAdd(request))
		{
			//update Authoriylist
			List<Authoriy> perlist = (List<Authoriy>)this.getServletContext().getAttribute(Constants.AVAILIST_PERMISSONS);
			perlist.add(p);
			this.getServletContext().setAttribute(Constants.AVAILIST_PERMISSONS, perlist);
			//update Authoriylabels
			List<LabelValue> plabelvalues = (List<LabelValue>) this.getServletContext().getAttribute(Constants.AVAILABLE_PERMISSONS);
			plabelvalues.add(new LabelValue(p.getAuthoriyname(),p.getDescription()));
			this.getServletContext().setAttribute(Constants.AVAILABLE_PERMISSONS, plabelvalues);
		}
	}
}
