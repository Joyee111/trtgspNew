package com.sinosoft.systemConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.util.UtilJson;
@Controller
public class WarnConfigAction extends BaseFormController {
	@Autowired
	private WarnConfigService service;
	@RequestMapping("/systemConfig/viewWarnConfig.html")
	public ModelAndView viewWarnConfig(Model model ,HttpServletRequest request,HttpServletResponse response){
		List<WarnConfig> warnConfigList = null;
		warnConfigList = service.getAll();
		if(warnConfigList!=null){
			for(WarnConfig config : warnConfigList){
				String limit_name= config.getLimit_name();
				if(limit_name.equals("gys_businessLicense_ExpirationDate")){
					model.addAttribute("gys_businessLicense_ExpirationDate", config);
				}else if(limit_name.equals("gys_businessLicense_annualSurvey")){
					model.addAttribute("gys_businessLicense_annualSurvey", config);
				}else if(limit_name.equals("gys_licence_ExpirationDate")){
					model.addAttribute("gys_licence_ExpirationDate",config);
				}else if(limit_name.equals("gys_GPS_ExpirationDate")){
					model.addAttribute("gys_GPS_ExpirationDate", config);
				}else if(limit_name.equals("gys_organizationCodeDate")){
					model.addAttribute("gys_organizationCodeDate", config);
				}else if(limit_name.equals("gys_organizationCodeInspectionDate")){
					model.addAttribute("gys_organizationCodeInspectionDate", config);
				}else if(limit_name.equals("gys_qualityAssuranceDate")){
					model.addAttribute("gys_qualityAssuranceDate", config);
				}else if(limit_name.equals("gys_authorizationDate")){
					model.addAttribute("gys_authorizationDate", config);
				}else if(limit_name.equals("ghs_businessLicense_ExpirationDate")){
					model.addAttribute("ghs_businessLicense_ExpirationDate", config);
				}else if(limit_name.equals("ghs_businessLicense_annualSurvey")){
					model.addAttribute("ghs_businessLicense_annualSurvey", config);
				}else if(limit_name.equals("ghs_licence_ExpirationDate")){
					model.addAttribute("ghs_licence_ExpirationDate",config);
				}else if(limit_name.equals("ghs_GPS_ExpirationDate")){
					model.addAttribute("ghs_GPS_ExpirationDate", config);
				}else if(limit_name.equals("ghs_organizationCodeDate")){
					model.addAttribute("ghs_organizationCodeDate", config);
				}else if(limit_name.equals("ghs_organizationCodeInspectionDate")){
					model.addAttribute("ghs_organizationCodeInspectionDate", config);
				}else if(limit_name.equals("ghs_qualityAssuranceDate")){
					model.addAttribute("ghs_qualityAssuranceDate", config);
				}else if(limit_name.equals("ghs_authorizationDate")){
					model.addAttribute("ghs_authorizationDate", config);
				}else if(limit_name.equals("yp_valid_date")){
					model.addAttribute("yp_valid_date", config);
				}else if(limit_name.equals("yp_medince_regist_date")){
					model.addAttribute("yp_medince_regist_date",config);
				}else if(limit_name.equals("yh_maintenance_plan")){
					model.addAttribute("yh_maintenance_plan",config);
				}else if(limit_name.equals("cg_authorizationDate")){
					model.addAttribute("cg_authorizationDate",config);
				}else if(limit_name.equals("cg_IDCardValidate")){
					model.addAttribute("cg_IDCardValidate",config);
				}else if(limit_name.equals("gh_IDCardValidate")){
					model.addAttribute("gh_IDCardValidate",config);
				}else if(limit_name.equals("gh_PharmaceuticalSalesmanTrainingCertificateDate")){
					model.addAttribute("gh_PharmaceuticalSalesmanTrainingCertificateDate",config);
				}
			}
		}
		return new ModelAndView("/systemConfig/warn_config");
	}
	@RequestMapping("/systemConfig/saveWarnConfig.html")
	public String saveOrUpadteWarnConfig(WarnConfigVO configVo,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		List<WarnConfig> warnConfigs = configVo.getWarnConfig();
		for(WarnConfig warnConfig : warnConfigs){
			service.saveOrUpdate(warnConfig);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
}
