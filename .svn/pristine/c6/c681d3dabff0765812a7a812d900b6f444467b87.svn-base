package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.ProcurementStaffService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
@Controller
public class ProcurementStaffAction extends BaseFormController {
	@Autowired
	private ProcurementStaffService service;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/procurementStaffList.html")
	public String findProcurementStaffList(Model model,HttpServletRequest request,HttpServletResponse response){
		String type= request.getParameter("type");
		List<ProcurementStaff> procurementStaffList = null;
		String page = DisplayGetPage.getPageParamName("procurement", request);
		if(page==null){
			
			 procurementStaffList = service.findProcurementStaffByType(type, 0, Constants.pagesize);
			/*迎检if(!type.equals("2")){
				procurementStaffList = service.findProcurementStaffByType(type, 0, Constants.pagesize);
			}else{
				procurementStaffList = service.queryProcumentStaffByCondition("", "", 0, Constants.pagesize);
			}*/
		}else{
			 procurementStaffList = service.findProcurementStaffByType(type, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			/*迎检if(!type.equals("2")){
				procurementStaffList = service.findProcurementStaffByType(type, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}else{
				procurementStaffList = service.queryProcumentStaffByCondition("", "", (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}*/
		}
		String sql = "select count(*) from t_procurement_staff where review_status='"+type+"'";
	int resultSize = service.getRecordCount(sql);
		/*迎检int resultSize = 0;
		if(type.equals("2")){
			resultSize = service.countProcumentStaffByCondition("", "");
		}else{
			resultSize = service.getRecordCount(sql);
		}*/
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("procurementStaffList",procurementStaffList);
		String returnStr = "";
		if(type!=null&& type.equals("0")){//待录入
			returnStr="/QYZZ/CGRY/cgrydlr";
		}else if(type.equals("1")){//带审核
			returnStr="/QYZZ/CGRY/cgrydsh";
		}else if(type.equals("2")){//已审核
			returnStr="/QYZZ/CGRY/cgryysh";
		}else if(type.equals("3")){//已驳回
			returnStr="/QYZZ/CGRY/cgryybh";
		}
		return returnStr;
	}
	
	@RequestMapping("/firstEnterprise/queryProcurementStaffList.html")
	public String queryProcurementStaffList(Model model ,HttpServletRequest request,HttpServletResponse response){
		String type= request.getParameter("type");
		String queryName = request.getParameter("queryName");
		String personType = request.getParameter("person_type");
		List<ProcurementStaff> procurementStaffList = null;
		String page = DisplayGetPage.getPageParamName("procurement", request);
		if(page==null){
			
			procurementStaffList = service.findProcurementStaffByParam(type, queryName, personType, 0, Constants.pagesize);
			/*迎检if(!type.equals("2")){
				procurementStaffList = service.findProcurementStaffByParam(type, queryName, personType, 0, Constants.pagesize);
			}else{
				procurementStaffList = service.queryProcumentStaffByCondition(queryName, personType, 0, Constants.pagesize);
			}*/
		}else{
			procurementStaffList = service.findProcurementStaffByParam(type, queryName, personType,  (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			/*if(!type.equals("2")){
				procurementStaffList = service.findProcurementStaffByParam(type, queryName, personType,  (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}else{
				procurementStaffList = service.queryProcumentStaffByCondition(queryName, personType, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
			}*/
			
		}
		//String sql = "select count(*) from t_procurement_staff where review_status='"+type+"'" +" and (pinyinCode lile'%"+queryName+"%' or procurement_name lile'%"+queryName+"%')";
		StringBuffer sqlBuffer = new  StringBuffer("select count(*) from t_procurement_staff where review_status='"+type+"'");
		if(queryName!=null && queryName!=""){
			sqlBuffer.append(" and (pinyinCode like'%"+queryName+"%' or procurement_name like'%"+queryName+"%')");
		}
		if(personType != null && !"".equals(personType)){
			sqlBuffer.append(" and person_type ='"+personType+"'");
		}
		int resultSize = service.getRecordCount(sqlBuffer.toString());
		/*迎检int resultSize = 0;
		if(!type.equals("2")){
			resultSize = service.getRecordCount(sqlBuffer.toString());
		}else{
			resultSize = service.countProcumentStaffByCondition(queryName, personType);
		}*/
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("procurementStaffList",procurementStaffList);
		String returnStr = "";
		if(type!=null&& type.equals("0")){//待录入
			returnStr="/QYZZ/CGRY/cgrydlr";
		}else if(type.equals("1")){//带审核
			returnStr="/QYZZ/CGRY/cgrydsh";
		}else if(type.equals("2")){//已审核
			returnStr="/QYZZ/CGRY/cgryysh";
		}else if(type.equals("3")){//已驳回
			returnStr="/QYZZ/CGRY/cgryybh";
		}
		return returnStr;
	}
	
	@RequestMapping("/firstEnterprise/addProcurementStaff.html")
	public String addSalesStaff(Model model ,HttpServletRequest request,HttpServletResponse response){
		return "/QYZZ/CGRY/add_cgry";
	}
	@RequestMapping("/firstEnterprise/editProcurementStaff.html")
	public String  viewProcurementStaff(Model model,HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("type");
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		ProcurementStaff procurementStaff = service.get(id);
		model.addAttribute("procurementStaff", procurementStaff);
		String returnStr = "";
		if(type!=null && type.equals("0")){
			returnStr = "/QYZZ/CGRY/edit_cgry";
		}else if(type.equals("1")){
			returnStr = "/QYZZ/CGRY/view_cgrydsh";
		}else if(type.equals("2")){
			returnStr = "/QYZZ/CGRY/view_cgryysh";
		}else if(type.equals("3")){
			returnStr = "/QYZZ/CGRY/view_cgryybh";
		}
		return returnStr;
	}
	
	@RequestMapping("/firstEnterprise/saveProcurementStaff.html")
	public String saveProcurementStaff(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type!=null && save_type.equals("0")){//保存
			procurementStaff.setReviewStatus("0");
		}else if(save_type.equals("1")){//申请
			procurementStaff.setReviewStatus("1");
			procurementStaff.setProposerID(user.getId());
			procurementStaff.setApplicationTime(new Date());
		}
		MultipartHttpServletRequest multrequest = (MultipartHttpServletRequest)request;
		batchUpload(multrequest, procurementStaff);
		ProcurementStaff sales = service.save(procurementStaff);
		logService.addLog("录入购货单位采购人员", user.getRealname(), "新增", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(sales.getId()>0){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/updateProcurementStaff.html")
	public String updateProcurementStaff(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type!=null && save_type.equals("0")){//保存
			procurementStaff.setReviewStatus("0");
		}else if(save_type.equals("1")){//申请
			procurementStaff.setReviewStatus("1");
			procurementStaff.setProposerID(user.getId());
			procurementStaff.setApplicationTime(new Date());
		}
		MultipartHttpServletRequest multrequest = (MultipartHttpServletRequest)request;
		batchUpload(multrequest, procurementStaff);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveOrUpdate(procurementStaff);
			logService.addLog("修改购货单位采购人员", user.getRealname(), "修改", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		}catch (Exception e) {
			map.put("success",  URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("success",  URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 * 根据id查找采购人或提货人
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/firstEnterprise/find_hgcgry.html")
	public void findcgry(String id,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long cg_id = null; 
		if(id!=null && !"".equals(id)){
			cg_id = Long.valueOf(id);
		}else{
			cg_id = new Long(0);
		}
		ProcurementStaff  procurementStaff = service.get(cg_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		String name = procurementStaff.getProcurementName();
		String IDNumber = procurementStaff.getIDNumber();
		String powerOfAttorneyDate = procurementStaff.getPowerOfAttorneyDate();
		String idCardPath = procurementStaff.getIdentityCardPath();
		String attorneyPath = procurementStaff.getPowerOfAttorneyPath();
		String idCardDate = procurementStaff.getIdentityCardDate();
		String gender = procurementStaff.getGender();
		map.put("name", name);
		map.put("IDNumber",IDNumber );
		map.put("powerOfAttorneyDate",powerOfAttorneyDate);
		map.put("attorneyPath",attorneyPath);
		map.put("idCardDate",idCardDate);
		map.put("idCardPath",idCardPath);
		map.put("gender",gender);
		UtilJson.printMapJson(response, map);
	}
	
	/**
	 * 针对快速修改,成功会返回修改的ID,失败返回-1
	 * @param procurementStaff
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 * @author 	岑保霖
	 * @date 	创建时间：2016-03-15 16:49:07
	 */
	@RequestMapping("/firstEnterprise/ajaxAddProcurementStaff.html")
	public String ajaxAddProcurementStaff(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type!=null && save_type.equals("0")){//保存
			procurementStaff.setReviewStatus("0");
		}else if(save_type.equals("1") ){
			procurementStaff.setReviewStatus("1");
			procurementStaff.setProposerID(user.getId());
			procurementStaff.setApplicationTime(new Date());
		}else if (save_type.equals("2")){
			procurementStaff.setReviewStatus("2");
			procurementStaff.setProposerID(user.getId());
			procurementStaff.setAuditor_ID(user.getId());
			procurementStaff.setApplicationTime(new Date());
		}
		MultipartHttpServletRequest multrequest = (MultipartHttpServletRequest)request;
		batchUpload(multrequest, procurementStaff);
		Map<String, Object> map = new HashMap<String, Object>();
		ProcurementStaff newPs = null;
		try{
			if(procurementStaff == null || procurementStaff.getId() < 1){
				newPs = service.save(procurementStaff);
			}else{
				service.saveOrUpdate(procurementStaff);
				newPs = procurementStaff;
			}
			logService.addLog("录入购货单位采购人员", user.getRealname(), "新增", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		}catch (Exception e) {
			map.put("success",  URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("psid", newPs.getId());
		map.put("success",  URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	
	
	
	
	
	@RequestMapping("/firstEnterprise/batchAuditProcurementStaff.html")
	public String batchAuditSalesStaff(String[] delete_id ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String auditType = request.getParameter("auditType");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		for(String p_id : delete_id){
			Long id = null;
			if(p_id!=null && !p_id.equals("")){
				id = Long.valueOf(p_id);
			}else{
				id = Long.valueOf(0);
			}
			ProcurementStaff procurementStaff =  service.get(id);
			if(auditType.equals("0")){
				procurementStaff.setReviewStatus("2");
			}else if(auditType.equals("1")){
				procurementStaff.setReviewStatus("3");
			}
			procurementStaff.setAuditor_ID(user.getId());
			procurementStaff.setReviewTime(new Date());
			service.saveOrUpdate(procurementStaff);
			logService.addLog("审核购货单位采购人员", user.getRealname(), "审核", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("操作成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/delteProcurementStaff.html")
	public String delteSalesStaff(String[] delete_id ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		for(String p_id : delete_id){
			Long id = null;
			if(p_id!=null && !p_id.equals("")){
				id = Long.valueOf(p_id);
			}else{
				id = Long.valueOf(0);
			}
			service.remove(id);
			logService.addLog("删除购货单位采购人员", user.getRealname(), "删除", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success",URLEncoder.encode("删除数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/auditProcurementStaff.html")
	public String auditSalesStaff(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		String reject_reason = request.getParameter("reject_reason");
		String p_id = request.getParameter("p_id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(save_type!=null && save_type.equals("0")){//审核通过
			ProcurementStaff procurement = service.get(procurementStaff.getId());
			procurement.setReviewStatus("2");
			procurement.setAuditor_ID(user.getId());
			procurement.setReviewTime(new Date());
			try{
				service.saveOrUpdate(procurement);
			}catch (Exception e) {
				map.put("success",URLEncoder.encode("保存数据失败！","UTF-8"));
				UtilJson.printMapJson(response, map);
				e.printStackTrace();
			}
		}else if(save_type.equals("1")){//驳回
			ProcurementStaff procurement = service.get(id);
			procurement.setReviewStatus("3");
			procurement.setReject_reason(reject_reason);
			procurement.setAuditor_ID(user.getId());
			procurement.setReviewTime(new Date());
			try{
				service.saveOrUpdate(procurement);
			}catch (Exception e) {
				map.put("success", URLEncoder.encode(URLEncoder.encode("保存数据失败！","UTF-8"),"UTF-8"));
				UtilJson.printMapJson(response, map);
				e.printStackTrace();
			}
		}
		logService.addLog("审核购货单位采购人员", user.getRealname(), "审核", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/qualifiedProcurementToReject.html")
	public String qualifiedSalespersonToReject(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		procurementStaff = service.get(procurementStaff.getId());
		procurementStaff.setReviewStatus("3");
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveOrUpdate(procurementStaff);
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/comfrimRejectProcurement.html")
	public String comfrimRejectSalesperson(ProcurementStaff procurementStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		procurementStaff.setReviewStatus("0");
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveOrUpdate(procurementStaff);
			logService.addLog("驳回确认购货单位采购人员", user.getRealname(), "驳回确认", "企业资质管理  > 购货单位采购人员", StringUtil.getIpAddr(request));
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	/**
	 *文件上传
	 * @param request
	 * @param firstVariety
	 */
	public static void batchUpload(MultipartHttpServletRequest   request,ProcurementStaff salesStaff){
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
					if(requestName.equals("powerOfAttorney")){//法人委托书路径
						salesStaff.setPowerOfAttorneyPath(relativeSavePath);
					}else if(requestName.equals("identityCard")){//身份证路径
						salesStaff.setIdentityCardPath(relativeSavePath);
					}
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	@RequestMapping("/firstEnterprise/delteProcurementFile.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type=request.getParameter("type");
	    String ctxPath = request.getSession().getServletContext().getRealPath(  
        "/");
	    String filePath = ctxPath + fileName;
	    Long id = null;
	    if(p_id!=null && !p_id.trim().equals("")){
	    	id = Long.valueOf(p_id);
	    }else{
	    	id = Long.valueOf(0);
	    }
	   ProcurementStaff procurementStaff =  service.get(id);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("frwts")){
			   procurementStaff.setPowerOfAttorneyPath("");
		   }else if(type.equals("sfz")){
			   procurementStaff.setIdentityCardPath("");
		   }
	   }
	   service.saveOrUpdate(procurementStaff);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success",URLEncoder.encode("删除附件成功！","UTF-8") );
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！","UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/findProcurementSatffJson.html")
	public void findProcurementStaffJson(HttpServletRequest request, HttpServletResponse response, Model model){
		String personType = request.getParameter("personType");
		List<ProcurementStaff> list = null;
		list = service.fingProcurementStaffAllByType("2",personType);
		//封装采购单json
		
		String json = "[";
		int index=0;
		if(list!=null && list.size()>0){
			for(ProcurementStaff sales : list){
					index++;
					json+="{";
					json+="\"id\":\""+sales.getId()+"\",";
					json+="\"text\":\""+sales.getProcurementName()+"\"";
					if(index==list.size()){
						json+="}";
					}else{
						json+="},";
					}
				}
		}
		json+="]";
		System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

