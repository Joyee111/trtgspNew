package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessoryVO;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.CnToPy;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;
@Controller
public class FirstEnterpriseAction extends BaseFormController {
	@Autowired
	private FirstEnterpriseService firstEnterpriseService;
	@Autowired
	private SalesStaffService salesService;
	@Autowired
	private PurchaseUnitsService purchaseUnitService;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/enterpriseIframe.html")
	public ModelAndView firstEnterpriseIframe(Model model,HttpServletRequest request,HttpServletResponse response){
	  return new ModelAndView("/QYZZ/SYQY/firstEnterprise");
	}
	@RequestMapping("/firstEnterprise/add_syqy.html")
	public ModelAndView addFirstEnterprise(Model model,HttpServletRequest request ,HttpServletResponse response){
		return  new  ModelAndView("/QYZZ/SYQY/add_syqy");
	}
	
	@RequestMapping("/firstEnterprise/syqydlr.html")
	public ModelAndView firstEnterpristInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<FirstEnterprise> firstEnterpriseList = new ArrayList<FirstEnterprise>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("enterprise", request);
		String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";
		if(page==null){
			firstEnterpriseList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			firstEnterpriseList = firstEnterpriseService.getFirstEnterpriseByPage(hql, new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = firstEnterpriseService.getOrderInfoCountByState(Integer.valueOf(0));
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/SYQY/syqydlr","firstEnterpriseList",firstEnterpriseList);
	}
	@RequestMapping("/firstEnterprise/query_syqydlr.html")
	public ModelAndView queryEnterpristInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<FirstEnterprise> firstEnterpriseList = new ArrayList<FirstEnterprise>();
		String query_qycx= request.getParameter("query_qycx");
		// 暂时先不考虑String query_zjhm= request.getParameter("query_zjhm");
		
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("enterprise", request);
	//	String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";
		StringBuffer hqlBuffer = new StringBuffer("from FirstEnterprise a where a.review_status =0");
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_FirstEnterprise where 1=1 and review_status = 0");
		if(query_qycx!=null && !query_qycx.equals("")){
			hqlBuffer.append(" and ( a.companyName like '%");
			hqlBuffer.append(query_qycx+"%' or a.corporation like '%");
			hqlBuffer.append(query_qycx+"%' ) ");
			sqlBuffer.append(" and (name like '%").append(query_qycx).append("%' or corporation like'%").append(query_qycx).append("%')");
		}
		hqlBuffer.append(" order by a.id DESC");
		if(page==null){
			firstEnterpriseList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			firstEnterpriseList = firstEnterpriseService.getFirstEnterpriseByPage(hqlBuffer.toString(), new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = firstEnterpriseService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/SYQY/syqydlr","firstEnterpriseList",firstEnterpriseList);
	}
	
	@RequestMapping("/firstEnterprise/edit_syqy.html")
	public ModelAndView editFirstEnterprise(Model model,HttpServletRequest request ,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		FirstEnterprise enterprise = firstEnterpriseService.get(id);
		model.addAttribute("enterprise",enterprise);
		return  new  ModelAndView("/QYZZ/SYQY/edit_syqy");
	}
	@RequestMapping("/firstEnterprise/save_syqy.html")
	public String  saveFirstEnterprise(FirstEnterpriseAccessoryVO accessoryVO, Model model,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String companyName = request.getParameter("companyName");//公司名称
		String corporation = request.getParameter("corporation");//法定代表人
		String compamyAddress = request.getParameter("compamyAddress");//企业地址
		String economic_nature = request.getParameter("economic_nature");//企业性质
		String postalcode = request.getParameter("postalcode");//邮编
		String quality_principal = request.getParameter("quality_principal");//质量负责人
		String business_license_No = request.getParameter("business_license_No");//营业质证号
		String license_No = request.getParameter("business_license_No");//许可证号
		String sales_deputy = request.getParameter("sales_deputy");//销售代表
		SalesStaff salesStaff = salesService.get(Long.valueOf(sales_deputy));
		String phone = request.getParameter("phone");//联系电话
		String certificate_No = request.getParameter("certificate_No");//认证证书号
		String apply_cause = request.getParameter("apply_cause");//申请原因
		
		String business_licence_date = request.getParameter("business_licence_date");//营业执照到期时间期
		String licence_date = request.getParameter("licence_date");//经营许可证到期时间
		//String littCredentDate = request.getParameter("littCredentDate");//认证证书到期日期
		//String accountDate = request.getParameter("accountDate");//开户信息到期日期
		//String annualSurveyDate = request.getParameter("annualSurveyDate");//年检证明到期日期
		
		String business_licence_inspection_date = request.getParameter("business_licence_inspection_date");//营业执照年检证明到期日期
		String gsp_certificate_date  = request.getParameter("gsp_certificate_date");//gsp证书到期日期
		String organization_code_date = request.getParameter("organization_code_date");//组织机构代码到期时间期
		String organization_code_inspection_date = request.getParameter("organization_code_inspection_date");//组织机构代码年检日期
		String quality_assurance_date = request.getParameter("quality_assurance_date");//质量保证协议到期日期
		String authorization_date = request.getParameter("authorization_date");
		
		String customerNumber = request.getParameter("customerNumber");//客户编号
		String tenBitCode = request.getParameter("tenBitCode");//十位码
		String email = request.getParameter("email");//email地址
		String businessScope = request.getParameter("businessScope");//经营范围
		String pinyinCode = request.getParameter("pinyinCode");//拼音码
		String portraiture = request.getParameter("portraiture");//传真
		String taxpayerRegisterNo = request.getParameter("taxpayerRegisterNo");//纳税人登记号
		String bankName = request.getParameter("bankName");//开户银行
		String bankNumber = request.getParameter("bankNumber");//开户银行账号
		String bankUserName = request.getParameter("bankUserName");//开户户名
		String deliveryPersonnel = request.getParameter("deliveryPersonnel");//提货人
		String remark = request.getParameter("remark");
		
		MultipartHttpServletRequest  muliRequest = (MultipartHttpServletRequest)request;
		
	//	String certificate_No = request.getParameter("certificate_No");
	//	String business_license_No = request.getParameter("business_license_No");
	//	String license_No = request.getParameter("license_No");
		
	//	String business_licence = request.getParameter("business_licence");
	//	String licence = request.getParameter("licence");
		String save_type = request.getParameter("save_type");
		Integer company_type=null;
		if(economic_nature!=null && !economic_nature.trim().equals("")){
			company_type= Integer.valueOf(economic_nature);
		}
		FirstEnterprise enterprise = new FirstEnterprise();
		enterprise.setCompanyName(companyName);
		enterprise.setCorporation(corporation);
		enterprise.setCompamyAddress(compamyAddress);
		
		if(company_type!=null){
			enterprise.setEconomic_nature(company_type);
		}
		enterprise.setPostalcode(postalcode);
		enterprise.setQuality_principal(quality_principal);
		enterprise.setSales_deputy(salesStaff);
		enterprise.setPhone(phone);
		enterprise.setCertificate_No(certificate_No);
		enterprise.setApply_cause(apply_cause);
		enterprise.setBusiness_license_No(business_license_No);
		enterprise.setLicense_No(license_No);
		enterprise.setBusiness_licence_date(business_licence_date);
		enterprise.setLicence_date(licence_date);
		//enterprise.setLittCredentDate(littCredentDate);
		//enterprise.setAccountDate(accountDate);
		//enterprise.setAnnualSurveyDate(annualSurveyDate);
		enterprise.setBusiness_licence_inspection_date(business_licence_inspection_date);
		enterprise.setGsp_certificate_date(gsp_certificate_date);
		enterprise.setOrganization_code_date(organization_code_date);
		enterprise.setOrganization_code_inspection_date(organization_code_inspection_date);
		enterprise.setQuality_assurance_date(quality_assurance_date);
		enterprise.setAuthorization_date(authorization_date);
		
		enterprise.setCustomerNumber(customerNumber);
		enterprise.setTenBitCode(tenBitCode);
		enterprise.setPinyinCode(pinyinCode);
		enterprise.setEmail(email);
		enterprise.setBusinessScope(businessScope);
		enterprise.setPortraiture(portraiture);
		enterprise.setTaxpayerRegisterNo(taxpayerRegisterNo);
		enterprise.setBankName(bankName);
		enterprise.setBankNumber(bankNumber);
		enterprise.setBankUserName(bankUserName);
		enterprise.setDeliveryPersonnel(deliveryPersonnel);
		enterprise.setRemark(remark);
		if(save_type.equals("0")){
			enterprise.setReview_status(0);
		}
		if(save_type.equals("1")){
			enterprise.setReview_status(1);
			enterprise.setApplication_time(new Date());
		}
	//	batchUploadFiles(request, response, enterprise);
		batchUpload(muliRequest, enterprise,accessoryVO);
		Set<FirstEnterpriseAccessory> set = new HashSet<FirstEnterpriseAccessory>();
		if(accessoryVO.getFirstAccessoryList()!=null){
			set.addAll(accessoryVO.getFirstAccessoryList());
		}
		enterprise.setAccessories(set);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		firstEnterpriseService.save(enterprise);
		logService.addLog("录入首营企业", user.getRealname(), "新增", "企业资质管理  > 首营企业", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/update_syqy.html")
	public String  updateFirstEnterprise(FirstEnterpriseAccessoryVO accessoryVO,Model model,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		String companyName = request.getParameter("companyName");//公司名称
		String corporation = request.getParameter("corporation");//法定代表人
		String compamyAddress = request.getParameter("compamyAddress");//企业地址
		String economic_nature = request.getParameter("economic_nature");//企业性质
		String postalcode = request.getParameter("postalcode");//邮编
		String quality_principal = request.getParameter("quality_principal");//质量负责人
		String business_license_No = request.getParameter("business_license_No");//营业质证号
		String license_No = request.getParameter("business_license_No");//许可证号
		String sales_deputy = request.getParameter("sales_deputy");//销售代表
		SalesStaff salesStaff = salesService.get(Long.valueOf(sales_deputy));
		String phone = request.getParameter("phone");//联系电话
		String certificate_No = request.getParameter("certificate_No");//认证证书号
		String apply_cause = request.getParameter("apply_cause");//申请原因
		
		String business_licence_date = request.getParameter("business_licence_date");//营业执照到期时间期
		String licence_date = request.getParameter("licence_date");//许可证到期日期
		//String littCredentDate = request.getParameter("littCredentDate");//认证证书到期日期
		//String accountDate = request.getParameter("accountDate");//开户信息到期日期
		//String annualSurveyDate = request.getParameter("annualSurveyDate");//年检证明到期日期
		String business_licence_inspection_date = request.getParameter("business_licence_inspection_date");//营业执照年检证明到期日期
		String gsp_certificate_date  = request.getParameter("gsp_certificate_date");//gsp证书到期日期
		String organization_code_date = request.getParameter("organization_code_date");//组织机构代码到期时间期
		String organization_code_inspection_date = request.getParameter("organization_code_inspection_date");//组织机构代码年检日期
		String quality_assurance_date = request.getParameter("quality_assurance_date");//质量保证协议到期日期
		String authorization_date = request.getParameter("authorization_date");
		String  remark = request.getParameter("remark");
		
		String customerNumber = request.getParameter("customerNumber");//客户编号
		String tenBitCode = request.getParameter("tenBitCode");//十位码
		String email = request.getParameter("email");//email地址
		String businessScope = request.getParameter("businessScope");//经营范围
		String pinyinCode = request.getParameter("pinyinCode");//拼音码
		String portraiture = request.getParameter("portraiture");//传真
		String taxpayerRegisterNo = request.getParameter("taxpayerRegisterNo");//纳税人登记号
		String bankName = request.getParameter("bankName");//开户银行
		String bankNumber = request.getParameter("bankNumber");//开户银行账号
		String bankUserName = request.getParameter("bankUserName");
		String deliveryPersonnel = request.getParameter("deliveryPersonnel");
		//String remark = request.getParameter("remark");
		String save_type = request.getParameter("save_type");
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		FirstEnterprise enterprise = firstEnterpriseService.get(id);
		Integer company_type=null;
		if(economic_nature!=null && !economic_nature.trim().equals("")){
			company_type= Integer.valueOf(economic_nature);
		}
		enterprise.setCompanyName(companyName);
		enterprise.setCorporation(corporation);
		enterprise.setCompamyAddress(compamyAddress);
		//enterprise.setEconomic_nature(company_type);
		if(company_type!=null){
			enterprise.setEconomic_nature(company_type);
		}
		enterprise.setPostalcode(postalcode);
		enterprise.setQuality_principal(quality_principal);
		enterprise.setSales_deputy(salesStaff);
		enterprise.setPhone(phone);
		enterprise.setApply_cause(apply_cause);
		enterprise.setCertificate_No(certificate_No);
		enterprise.setBusiness_license_No(business_license_No);
		enterprise.setLicense_No(license_No);
		enterprise.setAuthorization_date(authorization_date);
		enterprise.setBusiness_licence_date(business_licence_date);
		enterprise.setLicence_date(licence_date);
		//enterprise.setLittCredentDate(littCredentDate);
		//enterprise.setAccountDate(accountDate);
		//enterprise.setAnnualSurveyDate(annualSurveyDate);
	//	String business_licence_inspection_date = request.getParameter("business_licence_inspection_date");//营业执照年检证明到期日期
	//	String gsp_certificate_date  = request.getParameter("gsp_certificate_date");//gsp证书到期日期
	//	String organization_code_date = request.getParameter("organization_code_date");//组织机构代码到期时间期
	//	String organization_code_inspection_date = request.getParameter("organization_code_inspection_date");//组织机构代码年检日期
	//	String quality_assurance_date = request.getParameter("quality_assurance_date");//质量保证协议到期日期
		enterprise.setBusiness_licence_inspection_date(business_licence_inspection_date);
		enterprise.setGsp_certificate_date(gsp_certificate_date);
		enterprise.setOrganization_code_date(organization_code_date);
		enterprise.setOrganization_code_inspection_date(organization_code_inspection_date);
		enterprise.setQuality_assurance_date(quality_assurance_date);
		
		enterprise.setCustomerNumber(customerNumber);
		enterprise.setTenBitCode(tenBitCode);
		enterprise.setPinyinCode(pinyinCode);
		enterprise.setEmail(email);
		enterprise.setBusinessScope(businessScope);
		enterprise.setPortraiture(portraiture);
		enterprise.setTaxpayerRegisterNo(taxpayerRegisterNo);
		enterprise.setBankName(bankName);
		enterprise.setBankNumber(bankNumber);
		enterprise.setBankUserName(bankUserName);
		enterprise.setDeliveryPersonnel(deliveryPersonnel);
		enterprise.setProposer_ID(user.getId());
		enterprise.setRemark(remark);
		if(save_type.equals("0")){
			enterprise.setReview_status(0);
		}
		if(save_type.equals("1")){
			enterprise.setReview_status(1);
			enterprise.setApplication_time(new Date());
		}
		MultipartHttpServletRequest  muliRequest = (MultipartHttpServletRequest)request;
		batchUpload(muliRequest, enterprise,accessoryVO);
		Set<FirstEnterpriseAccessory> set = new HashSet<FirstEnterpriseAccessory>();
		if(accessoryVO.getFirstAccessoryList()!=null){
			set.addAll(accessoryVO.getFirstAccessoryList());
		}
		enterprise.setAccessories(set);
		firstEnterpriseService.saveOrUpdate(enterprise);
		logService.addLog("修改首营企业", user.getRealname(), "新增", "企业资质管理  > 首营企业", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！","UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/delte_syqydql.html")
	public ModelAndView deleteFirstEnterprise(Model model,HttpServletRequest request ,HttpServletResponse response){
		String[] p_ids = request.getParameterValues("delete_id");
		if(p_ids!=null && !p_ids.equals("")){
			
			for(String str_id : p_ids){
				Long id = Long.valueOf(str_id);
				FirstEnterprise enterprise = firstEnterpriseService.get(id);
				firstEnterpriseService.delete(enterprise);
			}
		}
		
		return  firstEnterpristInfoList(model,request,response);
	}
	/**
	 * 首营企业上传文件处理
	 * @param request
	 * @param response
	 * @param firstEnterprise
	 */
	private static void batchUploadFiles(HttpServletRequest request ,HttpServletResponse response ,FirstEnterprise firstEnterprise ){
			String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
			String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
			String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
			new File(fileSavePath).mkdirs();
			//String tempPath = request.getServletPath();
			int sizeThreshold = Integer.valueOf(Constants.SIZETHRESHOLD);//缓冲区的大小
		//	int fileMaxSize = Integer.valueOf(Constants.SIZEMAX);//上传文件的最大限制
			try{
				File tempPathFile = new File(fileTempPath);
				if(!tempPathFile.exists()){
					tempPathFile.mkdirs();
				}
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(tempPathFile);
			factory.setSizeThreshold(sizeThreshold);
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> its = items.iterator();
			while(its.hasNext()){
				FileItem item = its.next();
				String fileName = FileUtil.getFileName();//重命名文件名
				FileItem uploadFile = (FileItem) item;
				String fileNameLong = uploadFile.getName();//获取上传文件的名称
				String requestName = uploadFile.getFieldName();//获取上传文件对应字段名称
				String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
				String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
				relativeSavePath = relativeSavePath.substring(1);
				File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
	
				if(requestName.equals("business_licence_path")){//营业执照
					firstEnterprise.setBusiness_licence_path(relativeSavePath);
				}else if(requestName.equals("licence_path")){//经营许可证
					firstEnterprise.setLicence_path(relativeSavePath);
				}else if(requestName.equals("business_licence_inspection_path")){//营业执照年检
					firstEnterprise.setBusiness_licence_inspection_path(relativeSavePath);
				}else if(requestName.equals("gsp_certificate_path")){//GSP
					firstEnterprise.setGsp_certificate_path(relativeSavePath);
				}else if(requestName.equals("organization_code_path")){//组织机构
					firstEnterprise.setOrganization_code_path(relativeSavePath);
				}else if(requestName.equals("organization_code_inspection_path")){//组织机构年检
					firstEnterprise.setOrganization_code_inspection_path(relativeSavePath);
				}else if(requestName.equals("quality_assurance_path")){
					firstEnterprise.setQuality_assurance_path(relativeSavePath);
				}else if(requestName.equals("authorization_path")){
					firstEnterprise.setAuthorization_path(relativeSavePath);
				}
				uploadFile.write(savaFile);
			//	String relativeSavePathSmail = baseDir+fileName+"_01."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
			//	relativeSavePathSmail = relativeSavePathSmail.substring(1);
			//	File savaFile = new File(saveRealPath+fileName+"."+fileNameExtension);
			}
			}catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public static void batchUpload(MultipartHttpServletRequest   request,FirstEnterprise firstEnterprise,FirstEnterpriseAccessoryVO firstAccessory){
	//response.setCharacterEncoding("utf-8");
	  Map<String, MultipartFile> filesMap = request.getFileMap();
		 String serverRealPath = request.getSession().getServletContext().getRealPath("/");//获取服务器绝对路径
			String fileSavePath = serverRealPath+Constants.UPLOAD_PATH;//上传文件存储的绝对路径
			String fileTempPath = serverRealPath+Constants.TEMPPATH;//上传文件在服务器临时存储的的绝对路径
			new File(fileSavePath).mkdirs();
			//String tempPath = request.getServletPath();
			//int sizeThreshold = Integer.valueOf(Constants.SIZETHRESHOLD);//缓冲区的大小
			//int fileMaxSize = Integer.valueOf(Constants.SIZEMAX);//上传文件的最大限制
			try{
				File tempPathFile = new File(fileTempPath);
				if(!tempPathFile.exists()){
					tempPathFile.mkdirs();
				}
			//DiskFileItemFactory factory = new DiskFileItemFactory();
			//factory.setRepository(tempPathFile);
			//factory.setSizeThreshold(sizeThreshold);
			//ServletFileUpload upload = new ServletFileUpload(factory);
			//List<FileItem> items = upload.parseRequest(request);
			Iterator<String> its = filesMap.keySet().iterator();
			Set<FirstEnterpriseAccessory> set =  new HashSet<FirstEnterpriseAccessory>();
			List<FirstEnterpriseAccessory> firstAccessoryList = firstAccessory.getFirstAccessoryList();
			while(its.hasNext()){
				String requestName = its.next();
				MultipartFile item = filesMap.get(requestName);
				String fileName = FileUtil.getFileName();//重命名文件名
				MultipartFile uploadFile = (MultipartFile) item;
				if(uploadFile.getOriginalFilename()==null || uploadFile.getOriginalFilename().equals(""))
					continue;
				String fileNameLong = uploadFile.getOriginalFilename();//获取上传文件的名称
			//	String requestName = uploadFile.getName();//获取上传文件对应字段名称
				String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
				String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
				relativeSavePath = relativeSavePath.substring(1);
				File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
				if(!savaFile.exists()){
					savaFile.createNewFile();
				}
				if(requestName.equals("business_licence_path")){//营业执照
					firstEnterprise.setBusiness_licence_path(relativeSavePath);
				}else if(requestName.equals("licence_path")){//经营许可证
					firstEnterprise.setLicence_path(relativeSavePath);
				}else if(requestName.equals("business_licence_inspection_path")){//营业执照年检
					firstEnterprise.setBusiness_licence_inspection_path(relativeSavePath);
				}else if(requestName.equals("gsp_certificate_path")){//GSP
					firstEnterprise.setGsp_certificate_path(relativeSavePath);
				}else if(requestName.equals("organization_code_path")){//组织机构
					firstEnterprise.setOrganization_code_path(relativeSavePath);
				}else if(requestName.equals("organization_code_inspection_path")){//组织机构年检
					firstEnterprise.setOrganization_code_inspection_path(relativeSavePath);
				}else if(requestName.equals("quality_assurance_path")){//质量保证协议
					firstEnterprise.setQuality_assurance_path(relativeSavePath);
				}else if(requestName.equals("authorization_path")){
					firstEnterprise.setAuthorization_path(relativeSavePath);
				}else if(requestName.contains("request_name")){
					for(FirstEnterpriseAccessory  accessory : firstAccessoryList){
						String accessName = accessory.getRequest_name();
						if(requestName.equals(accessName)){
							accessory.setAccessoryPath(relativeSavePath);
							//set.add(accessory);
						}
						
					}
				}else{
					for(FirstEnterpriseAccessory  accessory : firstAccessoryList){
						String accsoryPath = accessory.getAccessoryPath();
						if(accsoryPath!=null && !"".equals(accsoryPath)){
						//	set.add(accessory);
						}
						
					}
					
				}
				
				uploadFile.transferTo(savaFile);
			//	String relativeSavePathSmail = baseDir+fileName+"_01."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
			//	relativeSavePathSmail = relativeSavePathSmail.substring(1);
			//	File savaFile = new File(saveRealPath+fileName+"."+fileNameExtension);
			}
		//	firstEnterprise.setAccessories(set);
			}catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	@RequestMapping("/firstEnterprise/deltefile.html")
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
	   FirstEnterprise firstEnterprise =  firstEnterpriseService.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("yyzz")){
			   firstEnterprise.setBusiness_licence_path("");
		   }else if(type.equals("xkz")){
			   firstEnterprise.setLicence_path("");
		   }else if(type.equals("yyzznj")){
			   firstEnterprise.setBusiness_licence_inspection_path("");
		   }else if(type.equals("gsp")){
			   firstEnterprise.setGsp_certificate_path("");
		   }else if(type.equals("zzjgdm")){
			   firstEnterprise.setOrganization_code_path("");
		   }else if(type.equals("zzjgdmnj")){
			   firstEnterprise.setOrganization_code_inspection_path("");
		   }else if(type.equals("zbxy")){
			   firstEnterprise.setQuality_assurance_path("");
		   }else if(type.equals("wtsqs")){
			   firstEnterprise.setAuthorization_path("");
		   }
	   }
	   firstEnterpriseService.saveOrUpdate(firstEnterprise);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success",URLEncoder.encode("删除附件成功！","UTF-8"));
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！","UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/ajaxChanggeChinaToPinyin.html")
	public String ajaxChanggeChinaToPinyin(Model modele,HttpServletRequest request,HttpServletResponse response){
		String[] array = {"有限公司","有限责任公司"};
		String type=request.getParameter("type");
		String chinaValue = request.getParameter("chinaValue");
		String subString = "";
		for(String str : array){
			if(chinaValue.indexOf(str)>=0){
				subString = chinaValue.substring(0, chinaValue.indexOf(str));
				break;
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if(!subString.equals("") && type!=null && !type.equals("")){
			List<PurchaseUnit> purchaseUnits = purchaseUnitService.findListByParam(subString);
			if(purchaseUnits!=null && purchaseUnits.size()>0){
				map.put("purchasUnits", purchaseUnits);
			}
		}
		String returnValue = "";
		if(chinaValue!=null && chinaValue.trim().length()>0){
			returnValue = CnToPy.getPinYinHeadChar(chinaValue);
		}
		map.put("returnValue", returnValue);
		UtilJson.printMapJson(response, map);
		return null;
	}
}
