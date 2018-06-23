package com.sinosoft.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.systemConfig.SystemConfig;
import com.sinosoft.systemConfig.SystemConfigManager;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/systemConfig/sysConfigEdit.html")
public class SystemConfigController extends BaseFormController {

	private SystemConfigManager mgr = null;

	@Autowired
	public void setSystemConfigManager(SystemConfigManager sysConfigManager) {
		this.mgr = sysConfigManager;
	}

	// list列表展示
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public ModelAndView select(Model model, HttpServletRequest request) {
		String page = DisplayGetPage.getPageParamName("systemConfig", request);// 第几页
		SystemConfig sysconfig = new SystemConfig();
		List systemConfig = null;
		int pagesize = mgr.getPagesize(sysconfig);

		systemConfig = mgr.getSystemConfigList((Integer.parseInt(page) - 1)
				* Constants.pagesize, Constants.pagesize, sysconfig);

		model.addAttribute("resultSize", pagesize);

		double size = Constants.pagesize;
		model.addAttribute("displayallpage", Math.ceil(pagesize
				/ size));
		model.addAttribute("thispage", Integer.parseInt(page));

		SystemConfig syscon = new SystemConfig();
		model.addAttribute("systemConfig", syscon);

		model.addAttribute("ptmeth", "list");

		return new ModelAndView("systemConfig/sysConfigList",
				Constants.SYSTEMCONFIG_LIST, systemConfig);
	}

	// select列表展示
	@RequestMapping(params = "method=select")
	public ModelAndView selectlist(SystemConfig sysConfig, Model model,
			HttpServletRequest request) {
		List systemConfig = null;

		/* start--->查询model的session */
		HttpSession session = request.getSession(true);
		if (null == sysConfig.getBtime() && null == sysConfig.getEtime()
				&& null == sysConfig.getConfigKey()) {
			ArrayList syslist = (ArrayList) session
					.getAttribute("sysconfiglistSession");
			sysConfig.setBtime(String.valueOf(syslist.get(0)));
			sysConfig.setEtime(String.valueOf(syslist.get(1)));
			sysConfig.setConfigKey(String.valueOf(syslist.get(2)));
		} else {
			ArrayList strlist = new ArrayList();
			strlist.add(sysConfig.getBtime());
			strlist.add(sysConfig.getEtime());
			strlist.add(sysConfig.getConfigKey());

			session.setAttribute("sysconfiglistSession", strlist);

		}

		// session.removeAttribute("MySessionVariable");
		/* 查询model的session<----end */

		String page = DisplayGetPage.getPageParamName("systemConfig", request);// 第几页
		int pagesize = mgr.getPagesize(sysConfig);

		systemConfig = mgr.getSystemConfigList((Integer.parseInt(page) - 1)
				* Constants.pagesize, Constants.pagesize, sysConfig);

		request.setAttribute("resultSize", pagesize);
		model.addAttribute("systemConfig", sysConfig);

		double size = Constants.pagesize;
		model.addAttribute("displayallpage", Math.ceil(pagesize
				/ size));
		model.addAttribute("thispage", Integer.parseInt(page));

		model.addAttribute("ptmeth", "select");

		return new ModelAndView("systemConfig/sysConfigList",
				Constants.SYSTEMCONFIG_LIST, systemConfig);

	}

	// 添加修改方法
	@RequestMapping(params = "method=edit")
	public String eidt(SystemConfig systemConfig, HttpServletRequest request) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd = Calendar.getInstance().getTime();
		systemConfig.setCreateTime(DateTimeUtils.StringToDate(sdf.format(dd),
				"yyyy-MM-dd HH:mm:ss"));

		try {
			mgr.saveSystemConfig(systemConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		SystemConfigManager mgr = (SystemConfigManager) ctx
				.getBean("systemConfigManager");

		getServletContext().setAttribute(Constants.SYSTEM_CONFIG,
				mgr.getSystemConfig());

		String pagename = request.getParameter("pagename");
		String page = request.getParameter("tz");
		if ("".equalsIgnoreCase(page)) {
			page = "1";
		}
		String postmethod = request.getParameter("ptmeth");
		if ("select".equalsIgnoreCase(postmethod)) {
			return "redirect:/systemConfig/sysConfigEdit.html?method=select&"
					+ pagename + "=" + page;
		} else {
			return "redirect:/systemConfig/sysConfigEdit.html?method=list&"
					+ pagename + "=" + page;
		}

	}

	// 删除方法
	@RequestMapping(params = "method=delete", method = RequestMethod.GET)
	public String delete(Long configId, HttpServletRequest request) {

		mgr.removeSystemConfig(configId);

		String page = request.getParameter("tz");
		String pagename = DisplayGetPage.getPageName("systemConfig", request);

		String postmethod = request.getParameter("ptmeth");
		if ("select".equalsIgnoreCase(postmethod)) {
			return "redirect:/systemConfig/sysConfigEdit.html?method=select&"
					+ pagename + "=" + page;
		} else {
			return "redirect:/systemConfig/sysConfigEdit.html?method=list&"
					+ pagename + "=" + page;
		}
	}

	// 进入编辑页面
	@ModelAttribute("systemConfig")
	@RequestMapping(params = "method=inedit")
	protected SystemConfig showForm(Long configId, HttpServletRequest request,
			Model model, HttpServletResponse response) throws Exception {
		String sysConfigId = String.valueOf(configId);
		SystemConfig systemConfig = new SystemConfig();
		if ("null".equals(sysConfigId)) {

		} else {
			systemConfig = mgr.getSysConfigById(configId);

		}
		// 将翻页参数和查询方式传到edit页面
		String page = request.getParameter("tz");
		String pagename = DisplayGetPage.getPageName("systemConfig", request);
		model.addAttribute("tzpage", page);
		model.addAttribute("pagename", pagename);
		model.addAttribute("ptmeth", request.getParameter("ptmeth"));

		return systemConfig;

	}

}
