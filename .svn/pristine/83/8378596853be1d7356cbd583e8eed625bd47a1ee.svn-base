package com.sinosoft.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.frame.service.UserExistsException;
import com.sinosoft.role.Role;
import com.sinosoft.role.RoleManager;
import com.sinosoft.systemConfig.SystemConfigManager;
import com.sinosoft.user.User;
import com.sinosoft.util.CheckEmpty;
import com.sinosoft.util.PropertiesUtil;
import com.sinosoft.util.SystemConfigUtil;

@SuppressWarnings("unchecked")
@Controller
public class LoginController extends BaseFormController {
	private final String shiropage = "redirect:/shirologin.html";
	private final String registerpage = "redirect:/register/register.html";
	SystemConfigManager configmgr;
	RoleManager rmgr;
	private MessageSource messageSource = null;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@Autowired
	public void setRmgr(RoleManager rmgr)
	{
		this.rmgr = rmgr;
	}

	@Autowired
	public void setConfigmgr(SystemConfigManager configmgr) {
		this.configmgr = configmgr;
	}


	@RequestMapping("index.html")
	public ModelAndView showIndex(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String message = null;
		if (null != request.getSession().getAttribute("downlaodresult")) {
			String downlaodresult = request.getSession().getAttribute(
					"downlaodresult").toString();
			request.getSession().removeAttribute("downlaodresult");
			if (!CheckEmpty.isEmpty(downlaodresult)) {
				if (downlaodresult.equals("1")) {
					message = PropertiesUtil.getPropertiesValue(
							"authoriy.download.success", request)[0].toString();
				} else {
					message = PropertiesUtil.getPropertiesValue(
							"authoriy.file.notiexits", request)[0].toString();
				}
			}
			model.addAttribute("downlaodresult", message);
		}
        model.addAttribute("errorMessage", request.getParameter("errorMessage"));
		return new ModelAndView("login/login");
	}

	@RequestMapping("shirologin.html")
	public String handleRequest(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String message = null;
		if (null != request.getSession().getAttribute("downlaodresult")) {
			String downlaodresult = request.getSession().getAttribute(
					"downlaodresult").toString();
			request.getSession().removeAttribute("downlaodresult");
			if (!CheckEmpty.isEmpty(downlaodresult)) {
				if (downlaodresult.equals("1")) {
					message = PropertiesUtil.getPropertiesValue(
							"authoriy.download.success", request)[0].toString();
				} else {
					message = PropertiesUtil.getPropertiesValue(
							"authoriy.file.notiexits", request)[0].toString();
				}
			}
			model.addAttribute("downlaodresult", message);
		}

		Subject subject = SecurityUtils.getSubject();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return "redirect:loginError.html";
		}
		/* 加载最新产品 */

		if (username != null && !username.equals("")) {
			User user = null;
			// 是否登录
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			if (localuser == null) {
				user = getUserManager().getUserByUsername(username);
				setSessionUser(user, username, request);
			} else {
				if (!localuser.getUsername().equals(username)) {
					user = getUserManager().getUserByUsername(username);
					setSessionUser(user, username, request);
				}
			}
		}

		return "redirect:indexPage.html";
	}
	
	@RequestMapping("indexPage.html")
	public ModelAndView indexPage(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		return new ModelAndView("login/index");
	}

	@RequestMapping("loginError.html")
	public ModelAndView loginError(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		model.addAttribute("errorMessage","用户名密码错误！");
		return new ModelAndView("login/login");
	}

	/**
	 * 退出系统
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("slogout.html")
	protected ModelAndView handleRequest(Model model, HttpServletRequest request) {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			SecurityUtils.getSubject().logout();
			List<User> userlist = (List<User>) this.getServletContext()
					.getAttribute(Constants.SESSION_USER_LIST);
			for (User u : userlist) {
				if (u.getUsername().equals(username)) {
					userlist.remove(u);
					break;
				}
			}
		}
		return new ModelAndView("login/login");
	}


	public int setSessionUser(User user, String username,
			HttpServletRequest request) {
		request.getSession().setAttribute(Constants.LOCAL_USER, user);
		String ip = SystemConfigUtil.getIpArr(request);
		user.setIp(ip);
		int logincount = 0;
		List<User> sessuserlist = (List<User>) this.getServletContext()
				.getAttribute(Constants.SESSION_USER_LIST);
		for (User u : sessuserlist) {
			if (u.getUsername().equals(username)) {
				logincount++;
			}
		}
		if (logincount < 5) {
			sessuserlist.add(user);
		}
		return logincount;
	}

	// 注册用户
	// @ModelAttribute("registeruser")
	@RequestMapping("/register/register.html")
	protected String showRegisteruserForm(ModelMap map,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = new User();
		map.addAttribute("registeruser", user);
		String[] str = PropertiesUtil.getPropertiesValue("territory", request);
		Map<String, String> map1 = new HashMap<String, String>();
		map1 = getMap(str);
		map.addAttribute("territory", map1);
		return "login/register";
	}

	// 保存注册用户
	@RequestMapping("/register/saveregister.html")
	public String registerSubmit(User registeruser, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response,Model model)
			throws Exception {
		MessageSourceAccessor text = new MessageSourceAccessor(messageSource,
				request.getLocale());
		String password = registeruser.getPassword();
		if (request.getParameter("cancel") != null) {
			return shiropage;
		}

		// 判断用户名和email的唯一
		int isuint = getUserManager().isUnique(registeruser.getUsername(),
				registeruser.getEmail());
		if (isuint > 0) {
			saveError(request, text.getMessage("errors.existing.user",
					new Object[] { registeruser.getUsername(),
							registeruser.getEmail() }));
			return registerpage;
		}

		try {
			registeruser.setUsertype(Constants.USERTYPE_ORDINARY);
			registeruser.setIslocked(Long.parseLong(Constants.USER_NOLOCK));//默认用户未锁定
			registeruser.setRegistertime(new Date());//注册时间
			//查询默认角色
			Role role =  rmgr.getRole("normal");
			Set<Role> roleset = new HashSet<Role>();
			roleset.add(role);
			registeruser.setRoles(roleset);
			//FTP地址
			String[] strs = SystemConfigUtil.getSystemValue("ftpurl", this.getServletContext());
			String ftpurls = null;
			if(strs!=null && strs.length>0)
			{
				ftpurls = strs[0].toString();
				registeruser.setFtpurl(ftpurls);
			}
			//读取FTP下载根目录
			strs = SystemConfigUtil.getSystemValue("ftphomedirectory", this.getServletContext());
			String ftphomedirectory = null;
			if(strs!=null && strs.length>0)
			{
				ftphomedirectory = strs[0].toString();
				ftphomedirectory += "/" + registeruser.getUsername();
				registeruser.setFtphomedirectory(ftphomedirectory);
			}
			//读取最大登录数
			strs = SystemConfigUtil.getSystemValue("maxlogin", this.getServletContext());
			String maxlogin = null;
			if(strs!=null && strs.length>0)
			{
				maxlogin = strs[0].toString();
				registeruser.setMaxloginnumber(new BigDecimal(maxlogin));
			}
			//读取上传速度
			strs = SystemConfigUtil.getSystemValue("uploadingspeed", this.getServletContext());
			String uploadingspeed = null;
			if(strs!=null && strs.length>0)
			{
				uploadingspeed = strs[0].toString();
				registeruser.setUploadrate(Long.parseLong(uploadingspeed));
			}
			//读取下载速度
			strs = SystemConfigUtil.getSystemValue("downloadspeed", this.getServletContext());
			String downloadspeed = null;
			if(strs!=null && strs.length>0)
			{
				downloadspeed = strs[0].toString();
				registeruser.setDownloadrate(Long.parseLong(downloadspeed));
			}
			//FTP端口
			strs = SystemConfigUtil.getSystemValue("ftpport", this.getServletContext());
			String ftpport = null;
			if(strs!=null && strs.length>0)
			{
				ftpport = strs[0].toString();
				registeruser.setFtpport(new BigDecimal(ftpport));
			}
			registeruser.setWritepermission(Long.parseLong("1"));
			
			registeruser = getUserManager().saveOrUpdateUser(registeruser);
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(
					registeruser.getUsername(), password);
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
			}
		} catch (UserExistsException e) {
			saveError(request, text.getMessage("errors.existing.user",
					new Object[] { registeruser.getUsername(),
							registeruser.getEmail() }));
			return "login/register";
		}
		if (registeruser != null) {
			List<User> userlist = (List<User>) this.getServletContext()
					.getAttribute(Constants.SESSION_USER_LIST);
			userlist.add(registeruser);
		}
		
		//保存注册用户登录后，保存登录用户的相关信息
		if (username != null && !username.equals("")) {
			User user = null;
			// 是否登录
			User localuser = (User) request.getSession().getAttribute(
					Constants.LOCAL_USER);
			if (localuser == null) {
				user = getUserManager().getUserByUsername(username);
				setSessionUser(user, username, request);
			} else {
				if (!localuser.getUsername().equals(username)) {
					user = getUserManager().getUserByUsername(username);
					setSessionUser(user, username, request);
				}
			}
		}
		return "redirect:/index.html";
	}

	/**
	 * 获取是否已经登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register/judgeIsLogin.html")
	public String getAuthc(HttpServletRequest request,
			HttpServletResponse response) {
		User localuser = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		JSONObject jsonObj = new JSONObject();
		if (localuser == null) {
			jsonObj.put("islogin", "noauthc");
		} else {
			jsonObj.put("islogin", "authced");
		}
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
}
