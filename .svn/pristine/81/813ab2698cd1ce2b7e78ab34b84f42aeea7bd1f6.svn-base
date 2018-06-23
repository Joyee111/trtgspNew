package com.sinosoft.systemLog.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.systemLog.model.SysLog;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.util.DisplayGetPage;
@Controller
public class SystemLogAction extends BaseFormController {
	@Autowired
	private SystemLogService sevice;
	@RequestMapping("/systemlog/systemLog.html")
	public String findSystemLog(Model model, HttpServletRequest request, HttpServletResponse response){
		String page = DisplayGetPage.getPageParamName("log", request);
		List<SysLog> logList = null;
		String startDate = request.getParameter("startDate");//开始时间
		String endDate = request.getParameter("endDate");//结束时间
		StringBuffer  hqlbuBuffer = new StringBuffer("select s from SysLog s where 1=1 ");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_system_log where 1=1 ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(startDate != null && !"".equals(startDate.trim())){
			hqlbuBuffer.append(" and CONVERT(varchar(50), s.log_date, 20) >= :startDate ");
			paramMap.put("startDate", startDate+" 00:00:00");
			sqlBuffer.append(" and CONVERT(varchar(50), log_date, 20) >= '"+startDate+" 00:00:00' ");
		}
		if(endDate != null && !"".equals(endDate.trim())){
			hqlbuBuffer.append(" and CONVERT(varchar(50), s.log_date, 20) >= :endDate ");
			paramMap.put("endDate", endDate+" 23:23:59");
			sqlBuffer.append(" and CONVERT(varchar(50), log_date, 20) <= '"+endDate+" 23:23:59' ");
		}
		if(page== null || "".equals(page.trim()) || page.equals("0")){
			logList = sevice.getListByPage(hqlbuBuffer.toString(), paramMap, 0, Constants.pagesize);
		}else{
			logList = sevice.getListByPage(hqlbuBuffer.toString(), paramMap, (Integer.parseInt(page)-1) * Constants.pagesize, Constants.pagesize);
		}
		model.addAttribute("logList", logList);
		int resultSize = sevice.getRecordCount(sqlBuffer.toString());
	//	int resultSize = firstEnterpriseService.getOrderInfoCountByState(Integer.valueOf(2));
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return "/systemLog/systemLog";
	}
	
}
