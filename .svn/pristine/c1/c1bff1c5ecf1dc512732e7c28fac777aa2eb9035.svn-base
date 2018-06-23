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
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
@Controller
public class SalesStaffServiceAction extends BaseFormController {
	@Autowired
	private SalesStaffService service;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/salesStaff.html")
	public String findSalesStaffList(Model model ,HttpServletRequest request,HttpServletResponse response){
		String type= request.getParameter("type");
		List<SalesStaff> salesStaffList = null;
		String page = DisplayGetPage.getPageParamName("sale", request);
		if(page==null){
			salesStaffList = service.findSalesStaffList(type, 0, Constants.pagesize);
		}else{
			salesStaffList = service.findSalesStaffList(type, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		String sql = "select count(*) from t_salesstaff where review_status='"+type+"'";
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("salesStaffList",salesStaffList);
		String returnStr = "";
		if(type!=null&& type.equals("0")){//待录入
			returnStr="/QYZZ/XSRY/xsrydlr";
		}else if(type.equals("1")){//带审核
			returnStr="/QYZZ/XSRY/xsrydsh";
		}else if(type.equals("2")){//已审核
			returnStr="/QYZZ/XSRY/xsryysh";
		}else if(type.equals("3")){//已驳回
			returnStr="/QYZZ/XSRY/xsryybh";
		}
		return returnStr;
	}
	@RequestMapping("/firstEnterprise/querySalesStaff.html")
	public String querySalesStaffList(Model model ,HttpServletRequest request,HttpServletResponse response){
		String type= request.getParameter("type");
		String queryName = request.getParameter("queryName");
		List<SalesStaff> salesStaffList = null;
		String page = DisplayGetPage.getPageParamName("sale", request);
		if(page==null){
			salesStaffList = service.querySalesStaffList(type, queryName, 0, Constants.pagesize);
		}else{
			salesStaffList = service.querySalesStaffList(type, queryName, (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		//String sql = "select count(*) from t_salesstaff where review_status='"+type+"'" +" and (pinyinCode lile'%"+queryName+"%' or saleName lile'%"+queryName+"%')";
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_salesstaff where review_status='"+type+"'");
		if(queryName!=null&& queryName!=""){
			sqlBuffer.append(" and (pinyin_code like'%"+queryName+"%' or sale_name like'%"+queryName+"%')");
		}
		int resultSize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		model.addAttribute("salesStaffList",salesStaffList);
		String returnStr = "";
		if(type!=null&& type.equals("0")){//待录入
			returnStr="/QYZZ/XSRY/xsrydlr";
		}else if(type.equals("1")){//带审核
			returnStr="/QYZZ/XSRY/xsrydsh";
		}else if(type.equals("2")){//已审核
			returnStr="/QYZZ/XSRY/xsryysh";
		}else if(type.equals("3")){//已驳回
			returnStr="/QYZZ/XSRY/xsryybh";
		}
		return returnStr;
	}
	@RequestMapping("/firstEnterprise/addSalesStaff.html")
	public String addSalesStaff(Model model ,HttpServletRequest request,HttpServletResponse response){
		return "/QYZZ/XSRY/add_xsry";
	}
	@RequestMapping("/firstEnterprise/editSalesStaff.html")
	public String  viewSalesStaff(Model model,HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("type");
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		SalesStaff salesStaff = service.get(id);
		model.addAttribute("salesStaff", salesStaff);
		String returnStr = "";
		if(type!=null && type.equals("0")){
			returnStr = "/QYZZ/XSRY/edit_xsry";
		}else if(type.equals("1")){
			returnStr = "/QYZZ/XSRY/view_xsrydsh";
		}else if(type.equals("2")){
			returnStr = "/QYZZ/XSRY/view_xsryysh";
		}else if(type.equals("3")){
			returnStr = "/QYZZ/XSRY/view_xsryybh";
		}
		return returnStr;
	}
	@RequestMapping("/firstEnterprise/saveSalesStaff.html")
	public String saveSalesStaff(SalesStaff salesStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type!=null && save_type.equals("0")){//保存
			salesStaff.setReviewStatus("0");
		}else if(save_type.equals("1")){//申请
			salesStaff.setReviewStatus("1");
			salesStaff.setProposerID(user.getId());
			salesStaff.setApplicationTime(new Date());
		}
		MultipartHttpServletRequest multrequest = (MultipartHttpServletRequest)request;
		batchUpload(multrequest, salesStaff);
		SalesStaff sales = service.save(salesStaff);
		logService.addLog("新增供货单位销售人员", user.getRealname(), "新增", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		if(sales.getId()>0){
			map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		}else{
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/updateSalesStaff.html")
	public String updateSalesStaff(SalesStaff salesStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String save_type = request.getParameter("save_type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		if(save_type!=null && save_type.equals("0")){//保存
			salesStaff.setReviewStatus("0");
		}else if(save_type.equals("1")){//申请
			salesStaff.setReviewStatus("1");
			salesStaff.setProposerID(user.getId());
			salesStaff.setApplicationTime(new Date());
		}
		MultipartHttpServletRequest multrequest = (MultipartHttpServletRequest)request;
		batchUpload(multrequest, salesStaff);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveOrUpdate(salesStaff);
			logService.addLog("修改供货单位销售人员", user.getRealname(), "修改", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/batchAuditSalesStaff.html")
	public String batchAuditSalesStaff(String[] delete_id ,HttpServletRequest request,HttpServletResponse response){
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
			SalesStaff salesStaff =  service.get(id);
			if(auditType.equals("0")){
				salesStaff.setReviewStatus("2");
			}else if(auditType.equals("1")){
				salesStaff.setReviewStatus("3");
			}
			salesStaff.setAuditor_ID(user.getId());
			salesStaff.setReviewTime(new Date());
			service.saveOrUpdate(salesStaff);
			logService.addLog("审核供货单位销售人员", user.getRealname(), "审核", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "操作成功！");
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/delteSalesStaff.html")
	public String delteSalesStaff(String[] delete_id ,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		for(String p_id : delete_id){
			Long id = null;
			if(p_id!=null && !p_id.equals("")){
				id = Long.valueOf(p_id);
			}else{
				id = Long.valueOf(0);
			}
			service.remove(id);
		}
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("删除供货单位销售人员", user.getRealname(), "删除", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "删除数据成功！");
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/auditSalesStaff.html")
	public String auditSalesStaff(SalesStaff salesStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
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
			salesStaff.setReviewStatus("2");
			salesStaff.setAuditor_ID(user.getId());
			salesStaff.setReviewTime(new Date());
			try{
				service.saveOrUpdate(salesStaff);
			}catch (Exception e) {
				map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
				UtilJson.printMapJson(response, map);
				e.printStackTrace();
			}
		}else if(save_type.equals("1")){//驳回
			SalesStaff sale = service.get(id);
			sale.setReviewStatus("3");
			sale.setReject_reason(reject_reason);
			sale.setAuditor_ID(user.getId());
			sale.setReviewTime(new Date());
			try{
				service.saveOrUpdate(sale);
				logService.addLog("审核供货单位销售人员", user.getRealname(), "审核", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
			}catch (Exception e) {
				map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
				UtilJson.printMapJson(response, map);
				e.printStackTrace();
			}
		}
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/qualifiedSalespersonToReject.html")
	public String qualifiedSalespersonToReject(SalesStaff salesStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		salesStaff.setReviewStatus("3");
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			service.saveOrUpdate(salesStaff);
		}catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/comfrimRejectSalesperson.html")
	public String comfrimRejectSalesperson(SalesStaff salesStaff ,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		salesStaff.setReviewStatus("0");
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
			service.saveOrUpdate(salesStaff);
			logService.addLog("确认驳回供货单位销售人员", user.getRealname(), "确认驳回", "企业资质管理  > 供货单位销售人员", StringUtil.getIpAddr(request));
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
	public static void batchUpload(MultipartHttpServletRequest   request,SalesStaff salesStaff){
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
					}else if(requestName.equals("trainingCertificate")){//药品推销员培训证书路径
						salesStaff.setTrainingCertificatePath(relativeSavePath);
					}
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	@RequestMapping("/firstEnterprise/delteSalesFile.html")
	public ModelAndView deleteFile(Model mode ,HttpServletRequest request ,HttpServletResponse response){
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
	   SalesStaff salesStaff =  service.get(id);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("frwts")){
				salesStaff.setPowerOfAttorneyPath("");
		   }else if(type.equals("sfz")){
			   salesStaff.setIdentityCardPath("");
		   }else if(type.equals("txz")){
			   salesStaff.setTrainingCertificatePath("");
		   }
	   }
	   service.saveOrUpdate(salesStaff);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success", "删除附件成功！");
	   }else{
		   map.put("success", "删除附件失败！");
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/findSalesStaffJson.html")
	public void findSalesStaffJson(HttpServletRequest request, HttpServletResponse response, Model model){
		List<SalesStaff> list = null;
		list = service.findSalesStaffAllByType("2");
		//封装采购单json
		
		String json = "[";
		int index=0;
		if(list!=null && list.size()>0){
			for(SalesStaff sales : list){
					index++;
					json+="{";
					json+="\"id\":\""+sales.getPinyinCode()+"_"+sales.getId()+"\",";
					json+="\"text\":\""+sales.getSaleName()+"\"";
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
