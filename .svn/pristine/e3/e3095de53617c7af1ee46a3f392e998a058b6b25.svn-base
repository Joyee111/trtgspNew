package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.IOException;
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
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.service.ProcurementStaffService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 3:06:35 PM
 * 类说明
 */
@Controller
public class PurchaseUnitsAction extends BaseFormController {
	private static String REDIRECTPATH ="redirect:/firstEnterprise/ghdwdlr.html";
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@Autowired
	private ProcurementStaffService procStaffService;
	@Autowired
	private SystemLogService logService;
	@RequestMapping("/firstEnterprise/ghdwdlr.html")
	public ModelAndView purchaseUnitsInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		String hql = "from PurchaseUnit a where reviewStatus =0 order by a.id DESC";
		if(page==null){
			purchaseUnitsList = purchaseUnitsService.findListByPage(0, 0, Constants.pagesize);
		}else{
			purchaseUnitsList = purchaseUnitsService.findListByPage(0,(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.countRecordByState(0);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwdlr","purchaseUnitsList",purchaseUnitsList);
	}
	@RequestMapping("/firstEnterprise/query_ghdwdlr.html")
	public ModelAndView queryPurchaseUnitsInfoList(Model model,HttpServletRequest request,HttpServletResponse response){
		List<PurchaseUnit> purchaseUnitsList = new ArrayList<PurchaseUnit>();
	//	String page = DisplayGetPage.getPageParamName("users", request);// 第几页
		String page = DisplayGetPage.getPageParamName("purchaseUnit", request);
		StringBuffer buffer = new StringBuffer();
		StringBuffer sqlBuffer = new StringBuffer();
		buffer.append("from PurchaseUnit a where a.reviewStatus =0");
		sqlBuffer.append("select count(*) from t_purchase_units where 1=1 and review_status=0");
		String query_qycx = request.getParameter("query_qycx");
		if(query_qycx!=null && !query_qycx.equals("")){
			buffer.append(" and ( a.companyName like '%");
			buffer.append(query_qycx+"%' or a.corporation like '%");
			buffer.append(query_qycx+"%' ) ");
			sqlBuffer.append(" and ( company_name like '%");
			sqlBuffer.append(query_qycx+"%' or corporation like'%");
			sqlBuffer.append(query_qycx+"%' ) ");
		}
		buffer.append(" order by a.id DESC");
		//String hql = "from FirstEnterprise a where a.review_status =0 order by a.id DESC";
		
		if(page==null){
			purchaseUnitsList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(), 0, Constants.pagesize);
		}else{
			purchaseUnitsList = purchaseUnitsService.findListByPage(buffer.toString(),new HashMap<String, Object>(),(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		
		// 获取总条数
		int resultSize = purchaseUnitsService.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
	//	model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/GHDW/ghdwdlr","purchaseUnitsList",purchaseUnitsList);
	}
	@RequestMapping("/firstEnterprise/add_ghdwdlr.html")
	public ModelAndView addPurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		Map<String, String> quamap= purchaseUnitsService.qmMap();
		model.addAttribute("quamap", quamap);
		List<String> drugFromList = new ArrayList();
		drugFromList.add("中成药");
		drugFromList.add("化学药制剂");
		drugFromList.add("抗生素");
		drugFromList.add("生化药品");
		model.addAttribute("drugFromList", drugFromList);
		return new ModelAndView("/QYZZ/GHDW/add_ghwdlr");
	}
	@RequestMapping("/firstEnterprise/save_ghdwdlr.html")
	public String  savePurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String  companyName = request.getParameter("companyName");//企业名称
		String  corporation = request.getParameter("corporation");//法人名称
		String  address = request.getParameter("address");//企业地址
		String  economicNature = request.getParameter("economicNature");//企业性质
		String companyPhone = request.getParameter("companyPhone");//企业联系电话
		String  postalCode = request.getParameter("postalCode");//邮编
		String  qualityPrincipal = request.getParameter("qualityPrincipal");//质量负责人
		String  businessLicenseNo = request.getParameter("businessLicenseNo");//营业执照号
		String  licenseNo = request.getParameter("licenseNo");//许可证号
		//String  salesDeputy = request.getParameter("salesDeputy");//销售代表
		String  procurementStaff = request.getParameter("procurement_staff");//采购人员
		String  phone = request.getParameter("phone");//联系电话
		String  certificateNo = request.getParameter("certificateNo");//认证证书号
		String  taxpayerRegisterNo = request.getParameter("taxpayerRegisterNo");//纳税人帐号
		String  customerNumber = request.getParameter("customerNumber");//客户编号
		String  tenBitCode = request.getParameter("tenBitCode");//十位码
		String  pinyinCode = request.getParameter("pinyinCode");//拼音码号
		String  portraiture = request.getParameter("portraiture");//传真
		String  bankName = request.getParameter("bankName");//开户银行
		String  bankNumber = request.getParameter("bankNumber");//银行账号
		String bankUserName = request.getParameter("bankUserName");
		String  businessScope = request.getParameter("businessScope");//经营范围
		String  applyCause = request.getParameter("applyCause");//申请原因
		String  businessLicenceDate = request.getParameter("businessLicenceDate");//营业执照到期时间期
		String  licenceDate = request.getParameter("licenceDate");//许可证到期日期
		String  documentEvidenceDate = request.getParameter("documentEvidenceDate");//许可证到期日期
		String businessLicenseInspectionDate = request.getParameter("businessLicenseInspectionDate");//营业执照年检时间
		String gspCertificateDate = request.getParameter("gspCertificateDate");//gsp证书到期日期
		String organizationCodeDate = request.getParameter("organizationCodeDate");//组织机构代码到期时间
		String organizationCodeInspectionDate = request.getParameter("organizationCodeInspectionDate");//组织机构代码年检时间
		String qualityAssuranceDate = request.getParameter("qualityAssuranceDate");//质量保证协议到期日期
		String authorizationDate = request.getParameter("authorizationDate");//法人委托书到期时间
		String remark = request.getParameter("remark");
		String[] saleCompany = request.getParameterValues("saleCompany");
		String[] oldNo =request.getParameterValues("oldNumber");
		String taxReceiptAddress = request.getParameter("taxReceiptAddress");//税票信息地址
		String taxReceiptPhone = request.getParameter("taxReceiptPhone");//税票电话
		String shippingAddress = request.getParameter("shippingAddress");//发货地址
		String consigneeName = request.getParameter("consigneeName");//收货人
		String consigneePhone = request.getParameter("consigneePhone");//收货人电话
		String electronicMonitoringCode = request.getParameter("electronicMonitoringCode");//电子监管码
		String accountOpeningDate = request.getParameter("accountOpeningDate");
		String openCompany = request.getParameter("openCompay");//开户公司
		String receivingPerson = request.getParameter("receivingPerson");
		String  procurementStaff1 = request.getParameter("procurement_staff1");//提货人员id
		String as = request.getParameter("gender");
		
		
		
		
		String sqlCompanys="";
		String oldNos="";
		if(saleCompany!=null && !"".equals(saleCompany)){
		if(saleCompany.length>0){
				for(int i=0;i<saleCompany.length;i++){
					if(i!=saleCompany.length-1){
						sqlCompanys +=saleCompany[i]+",";
					}else{
						sqlCompanys +=saleCompany[i];
					}
				}
			}
		}
		if(oldNo!=null && !"".equals(oldNo)){
			if(oldNo.length>0){
				for(int i=0;i<oldNo.length;i++){
					if(!"".equals(oldNo[i])&& oldNo[i]!=null){
						if(i!=oldNo.length-1){
							oldNos +=oldNo[i]+",";
						}else{
							oldNos +=oldNo[i];
						}
					}
				}
			}
		}
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request; 
		String  save_type = request.getParameter("save_type");//保存类型
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		ProcurementStaff procStaff = procStaffService.get(Long.valueOf(procurementStaff));
		ProcurementStaff procStaff1 = null;
		if(procurementStaff1!=null && !"".equals(procurementStaff1)){
			procStaff1 = procStaffService.get(Long.valueOf(procurementStaff1));
		}
		PurchaseUnit purchaseUnit = new PurchaseUnit();
		purchaseUnit.setBankUserName(bankUserName);
		purchaseUnit.setBusinessLicenseInspectionDate(businessLicenseInspectionDate);
		purchaseUnit.setGspCertificateDate(gspCertificateDate);
		purchaseUnit.setOrganizationCodeDate(organizationCodeDate);
		purchaseUnit.setOrganizationCodeInspectionDate(organizationCodeInspectionDate);
		purchaseUnit.setAuthorizationDate(authorizationDate);
		purchaseUnit.setQualityAssuranceDate(qualityAssuranceDate);
		purchaseUnit.setCompanyName(companyName);
		purchaseUnit.setCorporation(corporation);
		purchaseUnit.setAddress(address);
		purchaseUnit.setEconomicNature(economicNature);
		purchaseUnit.setPostalCode(postalCode);
		purchaseUnit.setQualityPrincipal(qualityPrincipal);
		purchaseUnit.setBusinessLicenseNo(businessLicenseNo);
		purchaseUnit.setLicenseNo(licenseNo);
		purchaseUnit.setProcurementStaff(procStaff);
		purchaseUnit.setProcurementReceiving(procStaff1);
		purchaseUnit.setProcurementStaffName(procurementStaff);
		purchaseUnit.setCompantPhone(companyPhone);
		purchaseUnit.setPhone(phone);
		purchaseUnit.setCertificateNo(certificateNo);
		purchaseUnit.setTaxpayerRegisterNo(taxpayerRegisterNo);
		purchaseUnit.setCustomerNumber(customerNumber);
		purchaseUnit.setTenBitCode(tenBitCode);
		purchaseUnit.setPinyinCode(pinyinCode);
		purchaseUnit.setPortraiture(portraiture);
		purchaseUnit.setBankName(bankName);
		purchaseUnit.setBankNumber(bankNumber);
		purchaseUnit.setBusinessScope(businessScope);
		purchaseUnit.setApplyCause(applyCause);
		purchaseUnit.setBusinessLicenceDate(businessLicenceDate);
		purchaseUnit.setLicenceDate(licenceDate);
		purchaseUnit.setDocumentEvidenceDate(documentEvidenceDate);
		purchaseUnit.setProposerId(user.getId());
		purchaseUnit.setRemark(remark);
		purchaseUnit.setSaleCompany(sqlCompanys);
		purchaseUnit.setOldNo(oldNos);
		purchaseUnit.setAccountOpeningDate(accountOpeningDate);
		purchaseUnit.setTaxReceiptAddress(taxReceiptAddress);
		purchaseUnit.setTaxReceiptPhone(taxReceiptPhone);
		purchaseUnit.setConsigneeName(consigneeName);
		purchaseUnit.setConsigneePhone(consigneePhone);
		purchaseUnit.setShippingAddress(shippingAddress);
		purchaseUnit.setElectronicMonitoringCode(electronicMonitoringCode);
		purchaseUnit.setOpenCompany(openCompany);
		purchaseUnit.setReceivingPerson(receivingPerson);
		if(save_type.equals("0")){
			purchaseUnit.setReviewStatus(0);
		}
		if(save_type.equals("1")){
			purchaseUnit.setReviewStatus(1);
			purchaseUnit.setApplication_time(new Date());
		}
		batchUpload(multRequest,purchaseUnit);
		purchaseUnitsService.save(purchaseUnit);
		logService.addLog("新增购货单位", user.getRealname(), "新增", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
		
		
	}
	@RequestMapping("/firstEnterprise/update_ghdwdlr.html")
	public String updatePurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String  companyName = request.getParameter("companyName");//企业名称
		String  corporation = request.getParameter("corporation");//法人名称
		String  address = request.getParameter("address");//企业地址
		String  companyPhone = request.getParameter("companyPhone");
		String  economicNature = request.getParameter("economicNature");//企业性质
		String  postalCode = request.getParameter("postalCode");//邮编
		String  qualityPrincipal = request.getParameter("qualityPrincipal");//质量负责人
		String  businessLicenseNo = request.getParameter("businessLicenseNo");//营业执照号
		String  licenseNo = request.getParameter("licenseNo");//许可证号
		//String  salesDeputy = request.getParameter("salesDeputy");//销售代表
		String procurementStaff = request.getParameter("procurement_staff");//采购人员
		String  phone = request.getParameter("phone");//联系电话
		String  certificateNo = request.getParameter("certificateNo");//认证证书号
		String  taxpayerRegisterNo = request.getParameter("taxpayerRegisterNo");//纳税人帐号
		String  customerNumber = request.getParameter("customerNumber");//客户编号
		String  tenBitCode = request.getParameter("tenBitCode");//十位码
		String  pinyinCode = request.getParameter("pinyinCode");//拼音码号
		String  portraiture = request.getParameter("portraiture");//传真
		String  bankName = request.getParameter("bankName");//开户银行
		String  bankNumber = request.getParameter("bankNumber");//银行账号
		String  businessScope = request.getParameter("businessScope");//经营范围
		String  applyCause = request.getParameter("applyCause");//申请原因
		String  businessLicenceDate = request.getParameter("businessLicenceDate");//营业执照到期时间期
		String  licenceDate = request.getParameter("licenceDate");//许可证到期日期
		String  documentEvidenceDate = request.getParameter("documentEvidenceDate");//许可证到期日期
		String businessLicenseInspectionDate = request.getParameter("businessLicenseInspectionDate");//营业执照年检时间
		String gspCertificateDate = request.getParameter("gspCertificateDate");//gsp证书到期日期
		String organizationCodeDate = request.getParameter("organizationCodeDate");//组织机构代码到期时间
		String organizationCodeInspectionDate = request.getParameter("organizationCodeInspectionDate");//组织机构代码年检时间
		String qualityAssuranceDate = request.getParameter("qualityAssuranceDate");//质量保证协议到期日期
		String authorizationDate = request.getParameter("authorizationDate");//法人委托书到期时间
		String remark = request.getParameter("remark");
		String bankUserName = request.getParameter("bankUserName");
		String[] saleCompany = request.getParameterValues("saleCompany");
		String[] oldNo =request.getParameterValues("oldNumber");
		String sqlCompanys="";
		String oldNos="";
		String taxReceiptAddress = request.getParameter("taxReceiptAddress");//税票信息地址
		String taxReceiptPhone = request.getParameter("taxReceiptPhone");//税票电话
		String shippingAddress = request.getParameter("shippingAddress");//发货地址
		String consigneeName = request.getParameter("consigneeName");//收货人
		String consigneePhone = request.getParameter("consigneePhone");//收货人电话
		String electronicMonitoringCode = request.getParameter("electronicMonitoringCode");//电子监管码
		String openCompany = request.getParameter("openCompay");//开户公司
		String accountOpeningDate = request.getParameter("accountOpeningDate");
		String receivingPerson = request.getParameter("receivingPerson");
		String  procurementStaff1 = request.getParameter("procurement_staff1");//提货人员id
		if(saleCompany!=null && !"".equals(saleCompany)){
			if(saleCompany.length>0){
					for(int i=0;i<saleCompany.length;i++){
						if(i!=saleCompany.length-1){
							sqlCompanys +=saleCompany[i]+",";
						}else{
							sqlCompanys +=saleCompany[i];
						}
					}
				}
			}
			if(oldNo!=null && !"".equals(oldNo)){
				if(oldNo.length>0){
					for(int i=0;i<oldNo.length;i++){
						if(!"".equals(oldNo[i])&& oldNo[i]!=null){
							if(i!=oldNo.length-1){
								oldNos +=oldNo[i]+",";
							}else{
								oldNos +=oldNo[i];
							}
						}
					}
				}
			}
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request; 
		String  save_type = request.getParameter("save_type");//保存类型
		String p_id = request.getParameter("id");
		Long id = null;
		if(p_id!=null && !p_id.equals("")){
			id = Long.valueOf(p_id);
		}else{
			id = Long.valueOf(0);
		}
		ProcurementStaff proStaff = procStaffService.get(Long.valueOf(procurementStaff));
		ProcurementStaff procStaff1 = null;
		if(procurementStaff1!=null && !"".equals(procurementStaff1)){
			procStaff1 = procStaffService.get(Long.valueOf(procurementStaff1));
		}
		
		PurchaseUnit purchaseUnit = purchaseUnitsService.get(id);
		purchaseUnit.setBankUserName(bankUserName);
		purchaseUnit.setCompanyName(companyName);
		purchaseUnit.setCorporation(corporation);
		purchaseUnit.setCompantPhone(companyPhone);
		purchaseUnit.setAddress(address);
		purchaseUnit.setEconomicNature(economicNature);
		purchaseUnit.setPostalCode(postalCode);
		purchaseUnit.setQualityPrincipal(qualityPrincipal);
		purchaseUnit.setBusinessLicenseNo(businessLicenseNo);
		purchaseUnit.setLicenseNo(licenseNo);
		//purchaseUnit.setSalesDeputy(salesDeputy);
		purchaseUnit.setProcurementStaff(proStaff);
		purchaseUnit.setProcurementReceiving(procStaff1);
		purchaseUnit.setProcurementStaffName(procurementStaff);
		purchaseUnit.setPhone(phone);
		purchaseUnit.setCertificateNo(certificateNo);
		purchaseUnit.setTaxpayerRegisterNo(taxpayerRegisterNo);
		purchaseUnit.setCustomerNumber(customerNumber);
		purchaseUnit.setTenBitCode(tenBitCode);
		purchaseUnit.setPinyinCode(pinyinCode);
		purchaseUnit.setPortraiture(portraiture);
		purchaseUnit.setBankName(bankName);
		purchaseUnit.setBankNumber(bankNumber);
		purchaseUnit.setBusinessScope(businessScope);
		purchaseUnit.setApplyCause(applyCause);
		purchaseUnit.setBusinessLicenceDate(businessLicenceDate);
		purchaseUnit.setLicenceDate(licenceDate);
		purchaseUnit.setDocumentEvidenceDate(documentEvidenceDate);
		purchaseUnit.setBusinessLicenseInspectionDate(businessLicenseInspectionDate);
		purchaseUnit.setGspCertificateDate(gspCertificateDate);
		purchaseUnit.setOrganizationCodeDate(organizationCodeDate);
		purchaseUnit.setOrganizationCodeInspectionDate(organizationCodeInspectionDate);
		purchaseUnit.setAuthorizationDate(authorizationDate);
		purchaseUnit.setQualityAssuranceDate(qualityAssuranceDate);
		purchaseUnit.setRemark(remark);
		purchaseUnit.setSaleCompany(sqlCompanys);
		purchaseUnit.setOldNo(oldNos);
		purchaseUnit.setTaxReceiptAddress(taxReceiptAddress);
		purchaseUnit.setTaxReceiptPhone(taxReceiptPhone);
		purchaseUnit.setShippingAddress(shippingAddress);
		purchaseUnit.setConsigneeName(consigneeName);
		purchaseUnit.setConsigneePhone(consigneePhone);
		purchaseUnit.setElectronicMonitoringCode(electronicMonitoringCode);
		purchaseUnit.setAccountOpeningDate(accountOpeningDate);
		purchaseUnit.setOpenCompany(openCompany);//开户公司
		purchaseUnit.setReceivingPerson(receivingPerson);
		if(save_type.equals("0")){
			purchaseUnit.setReviewStatus(0);
		}
		if(save_type.equals("1")){
			purchaseUnit.setReviewStatus(1);
			purchaseUnit.setApplication_time(new Date());
		}
		
		batchUpload(multRequest,purchaseUnit);
		//batchUpload(multRequest,purchaseUnit);
		purchaseUnitsService.saveOrUpdate(purchaseUnit);
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		logService.addLog("修改购货单位", user.getRealname(), "修改", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
		
	}
	@RequestMapping("/firstEnterprise/delte_ghdwdql.html")
	public String deletePurchaseUnit(Model model,HttpServletRequest request ,HttpServletResponse response){
		String[] p_ids = request.getParameterValues("delete_id");
		User user =(User) request.getSession().getAttribute(Constants.LOCAL_USER);
		if(p_ids!=null && !p_ids.equals("")){
			
			for(String str_id : p_ids){
				Long id = Long.valueOf(str_id);
				PurchaseUnit purchaseUnit = purchaseUnitsService.get(id);
				purchaseUnitsService.delete(purchaseUnit);
				logService.addLog("删除购货单位", user.getRealname(), "删除", "企业资质管理  > 购货单位", StringUtil.getIpAddr(request));
			}
		}
		
		return  REDIRECTPATH;
	}
	@RequestMapping("/firstEnterprise/modify_ghdwdlr.html")
	public ModelAndView modifyPurchaseUnits(Model model,HttpServletRequest request,HttpServletResponse response){
		String p_id = request.getParameter("id");
		Long id = null; 
		if(p_id!=null && !"".equals(p_id)){
			id = Long.valueOf(p_id);
		}else{
			id = new Long(0);
		}
		PurchaseUnit enterprise = purchaseUnitsService.get(id);
		String a =enterprise.getCustomerNumber().substring(0, 2);
		model.addAttribute("shengfenValue", a);
		model.addAttribute("purchaseUnit",enterprise);
		Map<String, String> quamap= purchaseUnitsService.qmMap();
		model.addAttribute("quamap", quamap);
		List<String> drugFromList = new ArrayList<String>();
		drugFromList.add("中成药");
		drugFromList.add("化学药制剂");
		drugFromList.add("抗生素");
		drugFromList.add("生化药品");
		model.addAttribute("drugFromList", drugFromList);
		return  new  ModelAndView("/QYZZ/GHDW/edit_ghdwdlr");
	}
	public static void batchUpload(MultipartHttpServletRequest   request,PurchaseUnit purchaseUnit){
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
				//	String requestName = uploadFile.getName();//获取上传文件对应字段名称
					String fileNameExtension = FileUtil.getFileExtension(fileNameLong);//获取文件的上传拓展名
					String relativeSavePath = Constants.UPLOAD_PATH+fileName+"."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
					relativeSavePath = relativeSavePath.substring(1);
					File savaFile = new File(fileSavePath+fileName+"."+fileNameExtension);
					
					if(!savaFile.exists()){
						savaFile.createNewFile();
					}
					if(requestName.equals("businessLicencePath")){//营业执照
						purchaseUnit.setBusinessLicencePath(relativeSavePath);
					}else if(requestName.equals("licencePath")){//许可证
						purchaseUnit.setLicencePath(relativeSavePath);
					}else if(requestName.equals("businessLicenseInspectionPath")){//营业执照年检
						purchaseUnit.setBusinessLicenseInspectionPath(relativeSavePath);
					}else if(requestName.equals("gspCertificatePath")){//gsp证书
						purchaseUnit.setGspCertificatePath(relativeSavePath);
					}else if(requestName.equals("organizationCodePath")){//组织机构代码
						purchaseUnit.setOrganizationCodePath(relativeSavePath);
					}else if(requestName.equals("organizationCodeInspectionPath")){//组织机构代码年检到
						purchaseUnit.setOrganizationCodeInspectionPath(relativeSavePath);
					}else if(requestName.equals("qualityAssurancePath")){//质量保证协议
						purchaseUnit.setQualityAssurancePath(relativeSavePath);
					}else if(requestName.equals("authorizationPath")){//法人委托书
						purchaseUnit.setAuthorizationPath(relativeSavePath);
					}
					uploadFile.transferTo(savaFile);
				}
				}catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	@RequestMapping("/firstEnterprise/delteAttachment.html")
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
	   PurchaseUnit purchaseUnit =  purchaseUnitsService.get(enterpriseId);
	   if(type!=null && !type.trim().equals("")){
		   if(type.equals("yyzz")){
			   purchaseUnit.setBusinessLicencePath("");
		   }else if(type.equals("xkz")){
			   purchaseUnit.setLicencePath("");
		   }else if(type.equals("yyzznj")){
			   purchaseUnit.setBusinessLicenseInspectionPath("");
		   }else if(type.equals("gspzs")){
			   purchaseUnit.setGspCertificatePath("");
		   }else if(type.equals("zzjgdm")){
			   purchaseUnit.setOrganizationCodePath("");
		   }else if(type.equals("zzjgdmnj")){
			   purchaseUnit.setOrganizationCodeInspectionPath("");
		   }else if(type.equals("zlbzxy")){
			   purchaseUnit.setQualityAssurancePath("");
		   }else if(type.equals("wtsqs")){
			   purchaseUnit.setAuthorizationPath("");
		   }
	   }
	   purchaseUnitsService.saveOrUpdate(purchaseUnit);
	   boolean status = FileOperate.delFile(filePath);
	   Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success", URLEncoder.encode("删除附件成功！", "UTF-8"));
	   }else{
		   map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
	@RequestMapping("/firstEnterprise/findNumber.html")
	public void findNumber(String number,Model model,HttpServletRequest request,HttpServletResponse response){
		String nextNumber= purchaseUnitsService.findNumberByPro(number);
		try {
			response.getWriter().write(nextNumber.trim());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	//检查录入的购货单位名称是否重复
	@RequestMapping("/firstEnterprise/checkName.html")
	public ModelAndView checkName(Model mode ,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		Boolean status = true;
	    if(name != null && name != ""){
	    	status = purchaseUnitsService.checkName(name);
	    }
		
	    Map<String, Object> map = new HashMap<String, Object>();
	   if(status){
		   map.put("success", URLEncoder.encode("企业名称未重复", "UTF-8"));
	   }else{
		   map.put("fail", URLEncoder.encode("企业名称重复", "UTF-8"));
	   }
	   UtilJson.printMapJson(response, map);
		return null;
	}
}

