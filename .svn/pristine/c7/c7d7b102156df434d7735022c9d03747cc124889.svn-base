package com.sinosoft.varietyManger.firstVarietyManger.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.dictionary.service.DrugFormDictionaryService;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.FirstVarietyService;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 4:38:51 PM
 * 类说明
 */
@Controller
public class FirstVarietyAction extends BaseFormController {
	@Autowired
	private FirstVarietyService service ;
	@Autowired
	private DrugFormDictionaryService formSevice;
	@Autowired
	private QualifiedSuppliersService supplierService;
	@Autowired
	private QualityMidicineMng mideicineService;
	@Autowired
	private SystemLogService logService;
	
	@Autowired
	private QualifiedmedcstoreMng qualifiedmedcstoreMng;
	@Autowired
	private QualityMidicineMng qmmService;
	
	
	
	/**
	 * 根据状态查询首营药品列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/firstVariety.html")
	public ModelAndView getFirstVariety(Model model,HttpServletRequest request,HttpServletResponse response){
		String type=request.getParameter("type");
		if(type.trim().equals("input")){
		  return inputDrugStandardFileList(model, request, response);
		}else if(type.trim().equals("waitAudit")){
		  return waitAuditDrugStandardFileList(model, request, response);
		}else if(type.trim().equals("audited")){
		  return auditedDrugStandardFileList(model, request, response);
		}else if(type.trim().equals("rejected")){
		  return rejectedDrugStandardFileList(model, request, response);
		}
		return null;
	}
	@RequestMapping("/drugVarieties/queryfirstVariety.html")
	public ModelAndView queryFirstVariety(Model model,HttpServletRequest request,HttpServletResponse response){
		List<FirstVariety> firstVarietyList = new ArrayList<FirstVariety>();
		String type=request.getParameter("type");
		String page = DisplayGetPage.getPageParamName("firstVariety", request);
		String query_commonname = request.getParameter("query_commonname");
		String query_dosageForms = request.getParameter("query_dosageForms");
		StringBuffer hqlBuffer = new StringBuffer("from FirstVariety a where 1=1  and a.id > 296 and  departmentId is not NULL");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_first_medicine f join t_dosage_form d  on f.dosageForms_id=d.id   where 1=1 and f.id > 296 and f.dp_id is not null");
		if(query_commonname!=null && !query_commonname.trim().equals("")){
			hqlBuffer.append(" and a.commonName like'%"+query_commonname+"%'");
			sqlBuffer.append(" and f.commonName like'%"+query_commonname+"%'");
		}
		if(query_dosageForms!=null && !query_dosageForms.trim().equals("")){
			hqlBuffer.append(" and a.dosageForms.formName like'%").append(query_dosageForms+"%'");
			sqlBuffer.append(" and d.form_name like'%"+query_dosageForms+"%'");
		}
		if(type.trim().equals("input")){
			hqlBuffer.append(" and a.reviewStatus=0 order by a.id DESC");
			sqlBuffer.append(" and review_status=0");
			
		}else if(type.trim().equals("waitAudit")){
			hqlBuffer.append(" and a.reviewStatus=1 order by a.id DESC");
			sqlBuffer.append(" and review_status=1");
		}else if(type.trim().equals("audited")){
			hqlBuffer.append(" and a.reviewStatus=2 order by a.id DESC");
			sqlBuffer.append(" and review_status=2");
		}else if(type.trim().equals("rejected")){
			hqlBuffer.append(" and a.reviewStatus=3 order by a.id DESC");
			sqlBuffer.append(" and review_status=3");
		}
		if(page==null){
			firstVarietyList = service.findListByType(hqlBuffer.toString(), new HashMap(), 0, Constants.pagesize);
		}else{
			firstVarietyList = service.findListByType(hqlBuffer.toString(), new HashMap(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		int resultSize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		if(type.trim().equals("input")){
			return new ModelAndView("/arietyManage/firstVariety/sypzdlr","firstVarietyList",firstVarietyList);
			
		}else if(type.trim().equals("waitAudit")){
			return new ModelAndView("/arietyManage/firstVariety/sypzdsh","firstVarietyList",firstVarietyList);
		}else if(type.trim().equals("audited")){
			return new ModelAndView("/arietyManage/firstVariety/sypzysh","firstVarietyList",firstVarietyList);
		}else if(type.trim().equals("rejected")){
			return new ModelAndView("/arietyManage/firstVariety/sypzybh","firstVarietyList",firstVarietyList);
		}
		
		return null;
	}
	
	@RequestMapping("/drugVarieties/addFirstVariety.html")
	public String addFirstVariety(Model model ,HttpServletRequest request,HttpServletResponse response){
		return "/arietyManage/firstVariety/add_sypzdrl";
	}
	/**
	 * 编辑首营品种带录入
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/viewFirstVariety.html")
	public String viewFirstVariety(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id =  Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		FirstVariety firstVariety = service.get(id);
		model.addAttribute("firstVariety", firstVariety);
		return "/arietyManage/firstVariety/edit_sypzdrl";
	}
	/**
	 * 编辑首营品种待审核
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/viewWaitAuditFirstVariety.html")
	public String viewWaitAuditFirstVariety(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id =  Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		FirstVariety firstVariety = service.get(id);
		model.addAttribute("firstVariety", firstVariety);
		return "/arietyManage/firstVariety/view_sypzdsh";
	}
	/**
	 * 编辑首营品种已经审核
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/viewAuditedFirstVariety.html")
	public String viewAuditedFirstVariety(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id =  Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		FirstVariety firstVariety = service.get(id);
		model.addAttribute("firstVariety", firstVariety);
		return "/arietyManage/firstVariety/view_sypzysh";
	}
	/**
	 * 编辑首营品种已驳回
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/viewRejectedFirstVariety.html")
	public String viewRejectedFirstVariety(Model model ,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.trim().equals("")){
			id =  Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		FirstVariety firstVariety = service.get(id);
		model.addAttribute("firstVariety", firstVariety);
		return "/arietyManage/firstVariety/view_sypzybh";
	}
	/**
	 * 保存首营品种
	 * @param variety
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/drugVarieties/saveFirstVariety.html")
	public String saveFirstVariety(FirstVariety variety,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		String dosageForm = request.getParameter("dosageForm");
		String produce_no = request.getParameter("produce_no");
		String supply_unit = request.getParameter("supply_unit");
		String quality_standard = request.getParameter("quality_standard");
		DrugFormDictionary   drugFormDictionary = formSevice.get(Long.valueOf(dosageForm));
		
		QualifiedSuppliers qualifiedSupplier = supplierService.get(Long.valueOf(produce_no));
		QualifiedSuppliers supplyUnit = supplierService.get(Long.valueOf(supply_unit));
		//BasedCriteria basedCriteria = baService.get(Long.valueOf(quality_standard));
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type.equals("0")){
			variety.setReviewStatus(0);
		}else{
			variety.setReviewStatus(1);
		}
		variety.setProposerId(user.getId());
		//variety.setQualityStandard(basedCriteria);
		variety.setQualityStandardName(quality_standard);
		variety.setApplicationTime(new Date());
		variety.setDosageForms(drugFormDictionary);
		variety.setProduceNo(qualifiedSupplier);
		variety.setSupplyUnit(supplyUnit);
		//variety.setQualityStandard(basedCriteria)
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		batchUpload(multipartRequest, variety);
		variety = service.save(variety);
		
		
//		QualityMidicine qm = qmmService.findByFirstVarietyId(variety.getId());
//		if(qm!=null){
//			Qualifiedmedcstore qu = new Qualifiedmedcstore();
//			qu.setBatchproduction(variety.getMedicinalNo());//生产批号 
////			qu.setNextmaintaindate(nextmaintaindate);//下一个养护日期 
//			qu.setQualifiedmedicineid(qm.getId());//合格药品id
//			qu.setQualityMidicine(qm);//合格 药品
////			qu.setQuantity(quantity);//数量 
////			qu.setReceivedDate(receivedDate);//收获日期
////			qu.setValiddate(validdate);//有效期至
//			qualifiedmedcstoreMng.savequ(qu);
//		}
//		
		
		
		
		logService.addLog("新增首营品种", user.getRealname(), "新增", "品种管理  >首营品种", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(variety!=null && variety.getId()!=null){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 * 修改首营品种
	 * @param variety
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/drugVarieties/updateFirstVariety.html")
	public String updateFirstVariety(FirstVariety variety,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		String dosageForm = request.getParameter("dosageForm");
		String produce_no = request.getParameter("produce_no");
		String supply_unit = request.getParameter("supply_unit");
		String quality_standard = request.getParameter("quality_standard");
		DrugFormDictionary   drugFormDictionary = formSevice.get(Long.valueOf(dosageForm));
		
		QualifiedSuppliers qualifiedSupplier = supplierService.get(Long.valueOf(produce_no));
		QualifiedSuppliers supplyUnit = supplierService.get(Long.valueOf(supply_unit));
	//	BasedCriteria basedCriteria =baService.get(Long.valueOf(quality_standard));
	//	User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		FirstVariety firstvariety = service.get(variety.getId());
		if(save_type.equals("0")){
			firstvariety.setReviewStatus(0);
		}else{
			firstvariety.setReviewStatus(1);
		}
		firstvariety.setDepartmentId(variety.getDepartmentId());
		firstvariety.setCommonName(variety.getCommonName());
		//firstvariety.setQualityStandard(basedCriteria);
		firstvariety.setQualityStandardName(quality_standard);
		//firstvariety.setDosageForms(variety.getDosageForms());
		//firstvariety.setProduceNo(variety.getProduceNo());
		firstvariety.setSpecifications(variety.getSpecifications());
		firstvariety.setLicenseNumber(variety.getLicenseNumber());
		//firstvariety.setQualityStandard(variety.getQualityStandard());
		firstvariety.setFunction(variety.getFunction());
		firstvariety.setValidDate(variety.getValidDate());
		firstvariety.setDosageForms(drugFormDictionary);
		firstvariety.setProduceNo(qualifiedSupplier);
		firstvariety.setMedcRegistrApprovalDate(variety.getMedcRegistrApprovalDate());
		firstvariety.setMedicinalNo(variety.getMedicinalNo());
		firstvariety.setMedicProductNo(variety.getMedicProductNo());
		firstvariety.setMedcRegistrApprovalDate(variety.getMedcRegistrApprovalDate());
		firstvariety.setMedicSpecifications(variety.getMedicSpecifications());
		firstvariety.setSupplyUnit(supplyUnit);
		firstvariety.setDrugCategor(variety.getDrugCategor());
		firstvariety.setStorageConditions(variety.getStorageConditions());
		firstvariety.setStorageStore(variety.getStorageStore());
		firstvariety.setSpecialManagement(variety.getSpecialManagement());
		firstvariety.setTrusteeEnterprise(variety.getTrusteeEnterprise());
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		batchUpload(multipartRequest, firstvariety);
		firstvariety = service.save(firstvariety);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("修改首营品种", user.getRealname(), "修改", "品种管理  >首营品种", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(firstvariety!=null && firstvariety.getId()!=null){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 * 审核首营品种
	 * @param variety
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/drugVarieties/auditFirstVariety.html")
	public String auditFirstVariety(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String save_type = request.getParameter("save_type");
		String p_id = request.getParameter("id");
		String auditContent =  request.getParameter("auditContent");
		String rejectReason = request.getParameter("rejectReason");
		Long id = null;
		if(p_id!=null && !p_id.equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
	//	User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		FirstVariety firstvariety = service.get(id);
		
		if(save_type.equals("0")){
			firstvariety.setAuditContent(auditContent);
			firstvariety.setReviewStatus(2);
			QualityMidicine q = mideicineService.findByFirstVarietyId(firstvariety.getId());
			if(q!=null){
				q.setUseflag(0);
				mideicineService.saveOrUpdate(q);
			}else{
				QualityMidicine qualityMidicine = new QualityMidicine(firstvariety);
				mideicineService.save(qualityMidicine);
			}
			
			
		}else{
			//FirstVariety variety2 = service.get(id);
			firstvariety.setRejectReason(rejectReason);
			firstvariety.setReviewStatus(3);
			//service.saveOrUpdate(variety2);
		}
		service.saveOrUpdate(firstvariety);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("审核首营品种", user.getRealname(), "审核", "品种管理  >首营品种", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(firstvariety!=null && firstvariety.getId()!=null){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 * 确认驳回
	 * @param variety
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/rejectFirstVariety.html")
	public String rejectFirstVariety(FirstVariety variety,HttpServletRequest request,HttpServletResponse response){
		//String save_type = request.getParameter("save_type");
	//	User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		FirstVariety firstvariety = service.get(variety.getId());
		firstvariety.setReviewStatus(0);
		service.saveOrUpdate(firstvariety);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("确认驳回首营品种", user.getRealname(), "确认驳回", "品种管理  >首营品种", StringUtil.getIpAddr(request));
		return "redirect:/drugVarieties/firstVariety.html?type=rejected";
	}
	/**
	 * 批量删除
	 * @param delete_id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/deleteFirstVariety.html")
	public String  deleteFirstVariety(String[] delete_id ,HttpServletRequest request,HttpServletResponse response){
		String[] ids = delete_id;
		//int index = 1;
		if(ids!=null && ids.length>0){
			for(String id :ids){
				Long p_id = Long.valueOf(id);
				service.remove(p_id);
			//	index++;
			}
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除首营品种", user.getRealname(), "删除", "品种管理  >首营品种", StringUtil.getIpAddr(request));
		return "redirect:/drugVarieties/firstVariety.html?type=input";
	}
	@RequestMapping("/drugVarieties/batchAuditFirstVariety.html")
	public String  batchAuditFirstVariety(String[] delete_id ,HttpServletRequest request,HttpServletResponse response){
		String[] ids = delete_id;
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(ids!=null && ids.length>0){
			for(String id :ids){
				Long p_id = Long.valueOf(id);
				FirstVariety firstVariety = service.get(p_id);
				if(save_type.equals("0")){
					firstVariety.setReviewStatus(2);
					firstVariety.setAuditorId(user.getId());
					firstVariety.setReviewTime(new Date());
					QualityMidicine qualityMidicine = new QualityMidicine(firstVariety);
					mideicineService.save(qualityMidicine);
					
				}else{
					firstVariety.setReviewStatus(3);
				}
				service.save(firstVariety);
			}
		}
		return "redirect:/drugVarieties/firstVariety.html?type=waitAudit";
	}
	
	public ModelAndView inputDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<FirstVariety> firstVarietyList = new ArrayList<FirstVariety>();
			String page = DisplayGetPage.getPageParamName("firstVariety", request);
			if(page==null){
				firstVarietyList = service.findListByType(Integer.valueOf(0), 0, Constants.pagesize);
			}else{
				firstVarietyList = service.findListByType(Integer.valueOf(0), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = service.countRecordByType(0);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/firstVariety/sypzdlr","firstVarietyList",firstVarietyList);
	}
	public ModelAndView waitAuditDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<FirstVariety> firstVarietyList = new ArrayList<FirstVariety>();
			String page = DisplayGetPage.getPageParamName("firstVariety", request);
			if(page==null){
				firstVarietyList = service.findListByType(Integer.valueOf(1), 0, Constants.pagesize);
			}else{
				firstVarietyList = service.findListByType(Integer.valueOf(1), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = service.countRecordByType(1);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/firstVariety/sypzdsh","firstVarietyList",firstVarietyList);
	}
	public ModelAndView auditedDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<FirstVariety> firstVarietyList = new ArrayList<FirstVariety>();
			String page = DisplayGetPage.getPageParamName("firstVariety", request);
			if(page==null){
				firstVarietyList = service.findListByType(Integer.valueOf(2), 0, Constants.pagesize);
			}else{
				firstVarietyList = service.findListByType(Integer.valueOf(2), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = service.countRecordByType(2);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/firstVariety/sypzysh","firstVarietyList",firstVarietyList);
	}
	public ModelAndView rejectedDrugStandardFileList(Model model ,HttpServletRequest request,HttpServletResponse response){
		
		List<FirstVariety> firstVarietyList = new ArrayList<FirstVariety>();
			String page = DisplayGetPage.getPageParamName("firstVariety", request);
			if(page==null){
				firstVarietyList = service.findListByType(Integer.valueOf(3), 0, Constants.pagesize);
			}else{
				firstVarietyList = service.findListByType(Integer.valueOf(3), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}
			
			// 获取总条数
			int resultSize = service.countRecordByType(3);
			model.addAttribute("resultSize", resultSize);
			model.addAttribute("pagesize", Constants.pagesize);
			double size = resultSize;
			model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
			model.addAttribute("thispage", Integer.parseInt(page));
			return new ModelAndView("/arietyManage/firstVariety/sypzybh","firstVarietyList",firstVarietyList);
	}
	/**
	 * 删除附件
	 * @param mode
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/drugVarieties/deltefile.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type=request.getParameter("type");
	    String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
	    String filePath = ctxPath + fileName;
	    Long enterpriseId = null;
	    if(id!=null && !id.trim().equals("")){
	    	enterpriseId = Long.valueOf(id);
	    }else{
	    	enterpriseId = Long.valueOf(0);
	    }
	   FirstVariety firstVariety =  service.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("cszz")){//厂商证照路径
			   firstVariety.setManufacturerLicensePath("");
		   }else if(type.equals("zcsb")){//注册商标路径
			   firstVariety.setRegisteredTrademarkPath("");
		   }else if(type.equals("pzwj")){//批准文件路径 
			   firstVariety.setApplicationReason("");
		   }else if(type.equals("zlbz")){//质量标准依据依据依据路径 
			   firstVariety.setQualityStandardPath("");
		   }else if(type.equals("bzqk")){//包装情况路径
			   firstVariety.setPackingPath("");
		   }else if(type.equals("bqsm")){//标签、说明书路径
			   firstVariety.setInstructionsPath("");
		   }else if(type.equals("jybg")){//检验报告
			   firstVariety.setCheckoutReportpath("");
		   }else if(type.equals("ypzcpzwj")){//药品注册批准文件
			   firstVariety.setMedcRegistrApprovalPath("");
		   }
	   }
	   service.saveOrUpdate(firstVariety);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success",  URLEncoder.encode("删除附件成功！", "UTF-8"));
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 *文件上传
	 * @param request
	 * @param firstVariety
	 */
	public static void batchUpload(MultipartHttpServletRequest   request,FirstVariety firstVariety){
		  Map<String, MultipartFile> filesMap = request.getFileMap();
			 String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
				String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
				String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
				new File(fileSavePath).mkdirs();
				try{
					File tempPathFile = new File(fileTempPath);
					if(!tempPathFile.exists()){
						tempPathFile.mkdirs();
					}
				Iterator<String> its = filesMap.keySet().iterator();
				while(its.hasNext()){
					String requestName = its.next();
					MultipartFile item = filesMap.get(requestName);
					String fileName = FileUtil.getFileName();//重命名文件名
					MultipartFile uploadFile = (MultipartFile) item;
					if(uploadFile.getOriginalFilename()==null || uploadFile.getOriginalFilename().equals(""))
						continue;
					String fileNameLong = uploadFile.getOriginalFilename();//获取上传文件的名称
					String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
					String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
					relativeSavePath = relativeSavePath.substring(1);
					File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
					if(!savaFile.exists()){
						savaFile.createNewFile();
					}
					if(requestName.equals("manufacturerPath")){//厂商证照路径
						firstVariety.setManufacturerLicensePath(relativeSavePath);
					}else if(requestName.equals("registeredPath")){//注册商标路径
						firstVariety.setRegisteredTrademarkPath(relativeSavePath);
					}else if(requestName.equals("approvalPath")){//批准文件路径 
						firstVariety.setApprovalDocumentPath(relativeSavePath);
					}else if(requestName.equals("qualityPath")){//质量标准依据依据依据路径 
						firstVariety.setQualityStandardPath(relativeSavePath);
					}else if(requestName.equals("packPath")){//包装情况路径
						firstVariety.setPackingPath(relativeSavePath);
					}else if(requestName.equals("instructPath")){//标签、说明书路径
						firstVariety.setInstructionsPath(relativeSavePath);
					}else if(requestName.equals("checkReportpath")){//检查报告路径
						firstVariety.setCheckoutReportpath(relativeSavePath);
					}else if(requestName.equals("medcRegistrAppPath")){//药品注册品准文件
						firstVariety.setMedcRegistrApprovalPath(relativeSavePath);
					}
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		}
	@RequestMapping("/drugVarieties/ajaxAllQueryMedicine.html")
		public void ajaxQueryMedicineByState(HttpServletRequest request,HttpServletResponse response){
			List<FirstVariety> list = null;
			try{
				list = service.findAllMedinceListByState(2);
				
				String json = "[";
				if(list!=null){
					for(int i =0;i<list.size();i++){
						if(list.get(i).getCommonName()!=null && !"".equals(list.get(i).getCommonName())){
							json+="{";
							json+="\"id\":"+list.get(i).getId()+",";
							json+="\"text\":\""+list.get(i).getCommonName()+"\"";
							if(i==list.size()-1){
								json+="}";
							}else{
								json+="},";
							}
						}
					}
				}
				json+="]";
				response.setContentType("text/json;charset=UTF-8");
			   response.getWriter().write(json);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
