package com.sinosoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.systemConfig.SystemLog;
import com.sinosoft.systemConfig.SystemLogDao;
import com.sinosoft.systemConfig.SystemLogManager;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.SystemConfigUtil;

@Controller
@RequestMapping("/systemConfig/sysLog.html")
public class SystemLogController extends BaseFormController {

	private SystemLogManager mgr = null;

	@Autowired
	public void setMgr(SystemLogManager mgr) {
		this.mgr = mgr;
	}

	@Autowired
	SystemLogDao dao;

	// list列表展示
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public ModelAndView select(Model model, HttpServletRequest request) {

		// SystemLogUtil.saveError("info","222");

		String page = DisplayGetPage.getPageParamName("systemLog", request);// 第几页
		SystemLog syslog = new SystemLog();
		List systemLog = null;
		int pagesize = mgr.getPagesize(syslog);

		systemLog = mgr.getListLog((Integer.parseInt(page) - 1)
				* Constants.pagesize, Constants.pagesize, syslog);

		model.addAttribute("resultSize", pagesize);
//		new HSSFCell();
		double size = Constants.pagesize;
		model.addAttribute("displayallpage", Math.ceil(pagesize / size ));
		model.addAttribute("thispage", Integer.parseInt(page));

		model.addAttribute("systemLog", syslog);
//		HSSFRichTextString
//		HSSFRow
//		System.out.println(HSSFWorkbook.class.getProtectionDomain().getCodeSource().getLocation());
//		ExcelHssfView
		model.addAttribute("ptmeth", "list");

		// 日志信息类型
		String[] logType = SystemConfigUtil.getSystemValue("logType", this
				.getServletContext());
		model.addAttribute("logType", logType);

		return new ModelAndView("systemConfig/sysLogList",
				Constants.SYSTEMLOG_LIST, systemLog);
	}

	// select列表展示
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "method=select")
	public ModelAndView selectlist(SystemLog sysLog, Model model,
			HttpServletRequest request) {
		List systemLog = null;

		/* start--->查询model的session */
		HttpSession session = request.getSession(true);
		if (null == sysLog.getBtime() && null == sysLog.getEtime()
				& null == sysLog.getLogType()) {
			ArrayList syslist = (ArrayList) session
					.getAttribute("sysloglistSession");
			sysLog.setBtime(String.valueOf(syslist.get(0)));
			sysLog.setEtime(String.valueOf(syslist.get(1)));
			sysLog.setLogType(String.valueOf(syslist.get(2)));
		} else {
			ArrayList strlist = new ArrayList();
			strlist.add(sysLog.getBtime());
			strlist.add(sysLog.getEtime());
			strlist.add(sysLog.getLogType());

			session.setAttribute("sysloglistSession", strlist);

		}

		// session.removeAttribute("MySessionVariable");
		/* 查询model的session<----end */

		String page = DisplayGetPage.getPageParamName("systemLog", request);// 第几页
		int pagesize = mgr.getPagesize(sysLog);

		systemLog = mgr.getListLog((Integer.parseInt(page) - 1)
				* Constants.pagesize, Constants.pagesize, sysLog);

		request.setAttribute("resultSize", pagesize);
		model.addAttribute("systemLog", sysLog);

		double size = Constants.pagesize;
		model.addAttribute("displayallpage", Math.ceil(pagesize / size ));
		model.addAttribute("thispage", Integer.parseInt(page));

		model.addAttribute("ptmeth", "select");

		// 日志信息类型
		String[] logType = SystemConfigUtil.getSystemValue("logType", this
				.getServletContext());
		model.addAttribute("logType", logType);

		return new ModelAndView("systemConfig/sysLogList",
				Constants.SYSTEMLOG_LIST, systemLog);

	}

}
