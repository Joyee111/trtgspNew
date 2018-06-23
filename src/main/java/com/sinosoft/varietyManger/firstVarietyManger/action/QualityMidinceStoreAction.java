package com.sinosoft.varietyManger.firstVarietyManger.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.systemConfig.WarnConfigService;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
@Controller
public class QualityMidinceStoreAction extends BaseFormController {
	@Autowired
	private QualifiedmedcstoreMng service;
	@Autowired
	private WarnConfigService configService ;
	@RequestMapping("/comQuery/varietyQuery/qualityMedicStoreWarningList.html")
	public String getQualifiedMedicValidWarning(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<Qualifiedmedcstore> storeList = null;
		WarnConfig config = null;
		config = configService.getWarnConfigByName("yp_valid_date");
		Calendar calendar = null;
		String date = "";
		if(config.getLimit_day()!=null && !"".equals(config.getLimit_day())){
			calendar = DateTimeUtils.getCalendar(DateTimeUtils.getNowStrDate(), Integer.parseInt(config.getLimit_day()));
			date = DateTimeUtils.formCurrentDate(calendar);
		}
		String page  = DisplayGetPage.getPageParamName("strore", request);
		if(page==null){
			storeList = service.getQualifiedMedicValidWarning(date, 0, Constants.pagesize);
		}else{
			storeList = service.getQualifiedMedicValidWarning(date,(Integer.parseInt(page) - 1) * Constants.pagesize , Constants.pagesize);
		}
		model.addAttribute("storeList", storeList);
		// 获取总条数
		int resultSize = service.countQualifiedMedicValidWarning(date);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return "/comQuery/midicineValidateWarning/midicineValidateWarning";
	}
}
