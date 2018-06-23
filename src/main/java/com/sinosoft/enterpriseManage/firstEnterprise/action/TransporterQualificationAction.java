package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
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
import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualificationRecords;
import com.sinosoft.enterpriseManage.firstEnterprise.service.TransporterQualificationRecordsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.TransporterQualificationService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
@Controller
public class TransporterQualificationAction extends BaseFormController {
	@Autowired
	private TransporterQualificationService service;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private TransporterQualificationRecordsService recordService;
	@RequestMapping("/firstEnterprise/transporterQualification.html")
	public ModelAndView findTransporterQualificationList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<TransporterQualification> transQualifList = null;
		String page = DisplayGetPage.getPageParamName("transporter", request);
		if(page==null){
			transQualifList = service.findTransporterQualificationList(0, Constants.pagesize);
		}else{
			transQualifList = service.findTransporterQualificationList((Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_transporter_qualification where business_license is not null";
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/YSZZ/transporterQualification","transQualifList",transQualifList);
	}
	@RequestMapping("/firstEnterprise/queryTransporterQualification.html")
	public ModelAndView queryTransporterQualificationList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<TransporterQualification> transQualifList = null;
		String page = DisplayGetPage.getPageParamName("transporter", request);
		String query_cysmc = request.getParameter("query_cysmc");
		String query_htmc = request.getParameter("query_htmc");
		if(page==null){
			transQualifList = service.queryTransporterQualificationList(query_cysmc, query_htmc,0, Constants.pagesize);
		}else{
			transQualifList = service.queryTransporterQualificationList(query_cysmc, query_htmc,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		StringBuffer sql = new StringBuffer("select count(*) from t_transporter_qualification where business_license is not null");
		if(query_cysmc!=null && !"".equals(query_cysmc.trim())){
			sql.append("  and transporter_name like '%"+query_cysmc.trim()+"%'");
		}
		if(query_htmc != null && !"".equals(query_htmc)){
			sql.append(" and contract_name like '%"+query_htmc.trim()+"%'");
		}
		/*if(query_cysmc!=null && !"".equals(query_cysmc.trim()) && query_htmc!=null && !"".equals(query_htmc.trim())){
			sql.append(" or  contract_name like '"+query_htmc.trim()+"'");
		}else if( query_htmc!=null && !"".equals(query_htmc.trim())&&(query_cysmc==null || "".equals(query_cysmc.trim()))){
			sql.append(" and contract_name like '"+query_htmc.trim()+"'");
		}*/
		
		int resultSize = service.getRecordCount(sql.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/YSZZ/transporterQualification","transQualifList",transQualifList);
	}
	@RequestMapping("/firstEnterprise/addTransporterQualification.html")
	public String addTransporterQualification(Model model,HttpServletRequest request,HttpServletResponse response){
		return "/QYZZ/YSZZ/addtransporterQualification";
	}
	@RequestMapping("/firstEnterprise/viewTransporterQualification.html")
	public String viewTransporterQualification(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		String type = request.getParameter("type");
		Long id = null;
		if(p_id!=null&&!"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		TransporterQualification transporterQualification = service.get(id);
		model.addAttribute("transQualification", transporterQualification);
		if(type.equals("view")){
			return "/QYZZ/YSZZ/viewTransporterQualification";
		}else{
			return "/QYZZ/YSZZ/editTransporterQualification";
		}
		
	}
	@RequestMapping("/firstEnterprise/saveTransporterQualification.html")
	public String saveTransporterQualification(TransporterQualification transporterQualification,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		transporterQualification.setDeleteFlag("0");
		TransporterQualification t =  service.save(transporterQualification);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("新增承运商资质", user.getRealname(), "新增", "企业资质管理  >承运商资质", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(t.getId()>0){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/updateTransporterQualification.html")
	public String updateTransporterQualification(TransporterQualification transporterQualification,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		//transporterQualification.setDeleteFlag("0"); //屏蔽，为保存状态
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		TransporterQualification tran = service.get(transporterQualification.getId());
		String modifyReason = request.getParameter("modify_reason");
		
		if(transporterQualification.getTransporterName() != null && !transporterQualification.getTransporterName().trim().equals(tran.getTransporterName().trim())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改承运商名称");
			records.setChangeContent("修改承运商名称,修改之前值为："+tran.getTransporterName()+",修改之后值为："+transporterQualification.getTransporterName());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getLegalRepresentative() != null && !transporterQualification.getLegalRepresentative().trim().equals(tran.getLegalRepresentative().trim())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改法人代表");
			records.setChangeContent("修改法人代表,修改之前值为："+tran.getLegalRepresentative()+",修改之后值为："+transporterQualification.getLegalRepresentative());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getBusinessLicense() != null && !transporterQualification.getBusinessLicense().trim().equals(tran.getBusinessLicense().trim())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改营业执照号");
			records.setChangeContent("修改营业执照号,修改之前值为："+tran.getBusinessLicense()+",修改之后值为："+transporterQualification.getBusinessLicense());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getBusinessLicenseDate() != null && !transporterQualification.getBusinessLicenseDate().trim().equals(tran.getBusinessLicenseDate())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改营业执照到期时间");
			records.setChangeContent("修改营业执照到期时间,修改之前值为："+tran.getBusinessLicenseDate()+",修改之后值为："+transporterQualification.getBusinessLicenseDate());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getTransportationLicense() != null && !transporterQualification.getTransportationLicense().trim().equals(tran.getTransportationLicense().trim())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改运输经营/生产许可证号");
			records.setChangeContent("修改运输经营/生产许可证号,修改之前值为："+tran.getTransportationLicense()+",修改之后值为："+transporterQualification.getTransportationLicense());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getTransportationLicenseDate() != null && !transporterQualification.getTransportationLicenseDate().trim().equals(tran.getTransportationLicenseDate())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改运输许可证到期日期");
			records.setChangeContent("修改运输许可证到期日期,修改之前值为："+tran.getTransportationLicenseDate()+",修改之后值为："+transporterQualification.getTransportationLicenseDate());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getContractName() != null && !transporterQualification.getContractName().trim().equals(tran.getContractName().trim())){
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改合同名称");
			records.setChangeContent("修改合同名称,修改之前值为："+tran.getContractName()+",修改之后值为："+transporterQualification.getContractName());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getContractDate() != null && !transporterQualification.getContractDate().trim().equals(tran.getContractDate().trim())){
			
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改合同到期日期");
			records.setChangeContent("修改合同到期日期,修改之前值为："+tran.getContractDate()+",修改之后值为："+transporterQualification.getContractDate());
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		if(transporterQualification.getDeleteFlag() != null && !transporterQualification.getDeleteFlag().trim().equals(tran.getDeleteFlag().trim())){
			
			TransporterQualificationRecords records = new TransporterQualificationRecords();
			records.setProjectName("修改状态");
			records.setChangeContent("修改状态,修改之前为："+getStatus(tran.getDeleteFlag())+",修改之后为："+getStatus(transporterQualification.getDeleteFlag()));
			records.setModityDate(new Date());
			records.setChangeReason(modifyReason);
			records.setTranQuaId(transporterQualification.getId());
			records.setModityUser(user);
			recordService.save(records);
		}
		service.saveOrUpdate(transporterQualification);
		logService.addLog("修改承运商资质", user.getRealname(), "修改", "企业资质管理  >承运商资质", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/deleteTransporterQualification.html")
	public String deleteTransporterQualification(String[] delete_id,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String[] ids = delete_id;
		for(String p_id : ids){
			Long id = null;
			if(p_id !=null && !"".equals(p_id)){
				id = Long.valueOf(p_id);
			}else{
				id = Long.valueOf(id);
			}
			TransporterQualification transporterQualification = service.get(id);
			transporterQualification.setDeleteFlag("1");
			service.saveOrUpdate(transporterQualification);
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除承运商资质", user.getRealname(), "删除", "企业资质管理  >承运商资质", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("删除数据成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/queryTranQuaRecords.html")
	public String queryTransporterQualificationRecords(Model model, HttpServletRequest request, HttpServletResponse response){
		List<TransporterQualificationRecords> recordsList = null;
		String page = DisplayGetPage.getPageParamName("record", request);
		String id = request.getParameter("id");
	//	String query_cysmc = request.getParameter("query_cysmc");
	//	String query_htmc = request.getParameter("query_cysmc");
		if(page==null){
			recordsList = recordService.getTransporterQualificationRecords(Long.valueOf(id), 0, Constants.pagesize);
		}else{
			recordsList = recordService.getTransporterQualificationRecords(Long.valueOf(id), (Integer.parseInt(page)-1)* Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		StringBuffer sql = new StringBuffer("select count(*) from t_transporter_qualification_records where tran_qua_id="+Long.parseLong(id));
		model.addAttribute("recordsList", recordsList);
		int resultSize = service.getRecordCount(sql.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return "/QYZZ/YSZZ/transporterQualificationRecords";
	}
	private String getStatus(String type){
		String str = "";
		if(type.equals("0")){
			str = "启用";
		}else if(type.equals("1")){
			str="停用";
		}else{
			str="暂时停用";
		}
		return str;
	}
}
