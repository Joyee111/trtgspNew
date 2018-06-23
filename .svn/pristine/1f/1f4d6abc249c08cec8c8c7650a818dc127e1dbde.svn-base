package com.sinosoft.enterpriseManage.firstEnterprise.action;

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
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnitsAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.ProcurementStaffService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualPurchUnitsAccessoryService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.systemConfig.WarnConfigService;
import com.sinosoft.systemLog.service.SystemLogService;
import com.sinosoft.user.User;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.DisplayGetPage;
import com.sinosoft.util.FileOperate;
import com.sinosoft.util.FileUtil;
import com.sinosoft.util.StringUtil;
import com.sinosoft.util.UtilJson;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 2:43:27 PM 类说明
 */
@Controller
public class QualifiedPurchaseUnitsAction extends BaseFormController {
	@Autowired
	private QualifiedPurchaseUnitsService qualifiedPurchaseUnitsService;
	@Autowired
	private QualPurchUnitsAccessoryService qualPurchUnitsAccessoryService;
	@Autowired
	private WarnConfigService configService;
	@Autowired
	private PurchaseUnitsService purchaseUnitsService;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private ProcurementStaffService procStaffService;
	@Autowired
	private DrugFormDictionaryService drugFormDictionaryService;

	@RequestMapping("/firstEnterprise/hgghdw.html")
	public ModelAndView getQulifiedPurchList(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<QualifiedPurchaseUnits> qualifiesPurcList = new ArrayList<QualifiedPurchaseUnits>();
		String page = DisplayGetPage.getPageParamName("qualifiesPurch", request);
		String hql = "from QualifiedPurchaseUnits a where a.delete_flag=0 and a.authorizationDate <> '9999-12-31' order by a.id DESC";
		if (page == null) {
			qualifiesPurcList = qualifiedPurchaseUnitsService.findListByPage(hql, 0, Constants.pagesize);
		} else {
			qualifiesPurcList = qualifiedPurchaseUnitsService.findListByPage(hql,
					(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_qualified_purchase_units where delete_flag=0  AND authorization_date <> '9999-12-31' ";
		int resultSize = qualifiedPurchaseUnitsService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/HGGHDW/hgghdw", "qualifiesPurcList", qualifiesPurcList);
	}

	@RequestMapping("/firstEnterprise/queryhgghdw.html")
	public ModelAndView queryQulifiedPurchList(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<QualifiedPurchaseUnits> qualifiesPurchList = new ArrayList<QualifiedPurchaseUnits>();
		String page = DisplayGetPage.getPageParamName("qualifiesPurch", request);
		String query_khbh = request.getParameter("query_khbh");
		String query_kfmc = request.getParameter("query_kfmc");
		StringBuffer buffer = new StringBuffer();
		buffer.append(
				"from QualifiedPurchaseUnits a where 1=1 and  a.delete_flag=0  and a.authorizationDate <> '9999-12-31' ");
		String sql = "select count(*) from t_qualified_purchase_units where delete_flag=0 and  authorization_date <> '9999-12-31' ";
		if (query_khbh != null && !"".equals(query_khbh.trim())) {
			buffer.append(" and a.customerNumber like'");
			buffer.append("%");
			buffer.append(query_khbh.trim() + "%'");
			sql = sql + " and customer_number like'%" + query_khbh.trim() + "%'";
		}
		if (query_kfmc != null && !"".equals(query_kfmc.trim())) {
			buffer.append(" and a.customerName like'");
			buffer.append("%");
			buffer.append(query_kfmc.trim() + "%'");
			sql = sql + " and customer_name like'%" + query_kfmc.trim() + "%'";
		}
		buffer.append(" order by a.id DESC");
		// String hql = "from QualifiedSuppliers a where a.deleteFlag=0 order by
		// a.id DESC";
		if (page == null) {
			qualifiesPurchList = qualifiedPurchaseUnitsService.findListByaPage(buffer.toString(),
					new HashMap<String, Object>(), 0, Constants.pagesize);
		} else {
			qualifiesPurchList = qualifiedPurchaseUnitsService.findListByaPage(buffer.toString(),
					new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数

		int resultSize = qualifiedPurchaseUnitsService.countRecordByCondition(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/HGGHDW/hgghdw", "qualifiesPurcList", qualifiesPurchList);
	}

	@RequestMapping("/firstEnterprise/view_hgghdw.html")
	public ModelAndView viewQualifiedPurch(Model model, HttpServletRequest request, HttpServletResponse response) {
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = new Long(0);
		}
		QualifiedPurchaseUnits quaPurchUnit = qualifiedPurchaseUnitsService.get(id);
		// PurchaseUnit enterprise = purchaseUnitsService.get(id);
		String shengfenValue = quaPurchUnit.getCustomerNumber().substring(0, 2);
		List<String> drugFromList = new ArrayList();
		drugFromList.add("中成药");
		drugFromList.add("化学药制剂");
		drugFromList.add("抗生素");
		drugFromList.add("生化药品");
		model.addAttribute("drugFromList", drugFromList);
		model.addAttribute("shengfenValue", shengfenValue);
		model.addAttribute("quaPurchUnit", quaPurchUnit);
		Map<String, String> quamap = purchaseUnitsService.qmMap();
		model.addAttribute("quamap", quamap);
		// model.addAttribute("enterprise", enterprise);
		return new ModelAndView("/QYZZ/HGGHDW/view_hgghdw");
	}

	@RequestMapping("/firstEnterprise/hgghdwxgjl.html")
	public ModelAndView qulifiedPurchListModiRecord(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<QualifiedPurchaseUnitsAccessory> accessoryList = new ArrayList<QualifiedPurchaseUnitsAccessory>();
		String page = DisplayGetPage.getPageParamName("archives", request);
		String hql = "from QualifiedPurchaseUnits a where a.deleteFlag=0 order by a.id DESC";
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		if (page == null) {
			accessoryList = qualPurchUnitsAccessoryService.findAccessoriesListByPage(id, 0, Constants.pagesize);
		} else {
			accessoryList = qualPurchUnitsAccessoryService.findAccessoriesListByPage(id,
					(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		// String sql ="select count(*) from t_qualified_purchase_units_archives
		// where qualified_purchase_units_id="+id;
		int resultSize = qualPurchUnitsAccessoryService.countRecord(id);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/HGGHDW/hgghdwjl", "accessoryList", accessoryList);
	}

	@RequestMapping("/firstEnterprise/update_hgghdw.html")
	public String updataQualifiedPurch(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");// 客户ID
		String customerNumber = request.getParameter("customerNumber");// 客户ID
		String customerName = request.getParameter("customerName");// 客户名称
		String busLiceExpiraDate = request.getParameter("busLiceExpiraDate");// 营业执照到期时间
		String busLiceAnnualSurvey = request.getParameter("busLiceAnnualSurvey");// 企业年度信息报告到期时间
		String liceExpirationDate = request.getParameter("liceExpirationDate");// 许可证到期日期
		String gpsExpirationDate = request.getParameter("gpsExpirationDate");// GSP截止日期
		// String documentEvidenceDate =
		// request.getParameter("documentEvidenceDate");//认证材料到期日期
		String tenBitCode = request.getParameter("tenBitCode");// 十位码
		String email = request.getParameter("email");// Email地址
		String pinyinCode = request.getParameter("pinyinCode");// 拼音码
		String postalCode = request.getParameter("postalCode");// 邮编
		String companyPhone = request.getParameter("companyPhone");// 企业联系电话
		String phone = request.getParameter("phone");// 采购人联系电话
		String portraiture = request.getParameter("portraiture");// 传真
		String corporation = request.getParameter("corporation");// 法人
		String taxpayeRegisterNo = request.getParameter("taxpayeRegisterNo");// 纳税人登记证
		String bankName = request.getParameter("bankName");// 开户银行
		String bankNumber = request.getParameter("bankNumber");// 开户银行账户
		String bankUserName = request.getParameter("bankUserName");// 开户户名
		String businessScope = request.getParameter("businessScope");// 经营范围

		String organizationCodeDate = request.getParameter("organizationCodeDate");// 组织机构代码到期时间
		String organizationCodeInspectionDate = request.getParameter("organizationCodeInspectionDate");// 组织机构代码年检时间
		String qualityAssuranceDate = request.getParameter("qualityAssuranceDate");// 质量保证协议到期日期
		String authorizationDate = request.getParameter("authorizationDate");// 法人委托书到期时间
		String remark = request.getParameter("remark");
		String[] saleCompany = request.getParameterValues("saleCompany");
		String[] oldNo = request.getParameterValues("oldNumber");
		String taxReceiptAddress = request.getParameter("taxReceiptAddress");// 税票信息地址
		String taxReceiptPhone = request.getParameter("taxReceiptPhone");// 税票电话
		String shippingAddress = request.getParameter("shippingAddress");// 发货地址
		String consigneeName = request.getParameter("consigneeName");// 收货人
		String consigneePhone = request.getParameter("consigneePhone");// 收货人电话
		String electronicMonitoringCode = request.getParameter("electronicMonitoringCode");// 电子监管码
		String accountOpeningDate = request.getParameter("accountOpeningDate");
		String address = request.getParameter("address");// 企业地址
		String economicNature = request.getParameter("economicNature");// 企业经营类型
		String userFalg = request.getParameter("userFlag");// 停用标识
		String openCompany = request.getParameter("openCompany");
		String sqlCompanys = "";
		String oldNos = "";
		String reason = request.getParameter("reason");// 修改原因
		String qualityPrincipal = request.getParameter("qualityPrincipal");
		String licenseNo = request.getParameter("licenseNo");// 经营/生产许可证号
		String businessLicenseNo = request.getParameter("businessLicenseNo");// 营业执照号
		String certificateNo = request.getParameter("certificateNo");// GSP/GMP认证证书号码;
		String receivingPerson = request.getParameter("receivingPerson");// 提货人员
		if (saleCompany != null && !"".equals(saleCompany)) {
			if (saleCompany.length > 0) {
				for (int i = 0; i < saleCompany.length; i++) {
					if (i != saleCompany.length - 1) {
						sqlCompanys += saleCompany[i] + ",";
					} else {
						sqlCompanys += saleCompany[i];
					}
				}
			}
		}
		if (oldNo != null && !"".equals(oldNo)) {
			if (oldNo.length > 0) {
				for (int i = 0; i < oldNo.length; i++) {
					if (!"".equals(oldNo[i]) && oldNo[i] != null) {
						if (i != oldNo.length - 1) {
							oldNos += oldNo[i] + ",";
						} else {
							oldNos += oldNo[i];
						}
					}
				}
			}
		}
		String procurementStaff = request.getParameter("procurement_staff");
		String procurementStaff1 = request.getParameter("procurement_staff1");

		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		Long p_Id = null;
		if (isNull(id)) {
			p_Id = Long.valueOf(id);
		} else {
			p_Id = Long.valueOf(0);
		}
		QualifiedPurchaseUnits qualifiedPurchaseUnits = qualifiedPurchaseUnitsService.get(p_Id);

		List<QualifiedPurchaseUnitsAccessory> archivesList = new ArrayList<QualifiedPurchaseUnitsAccessory>();
		ProcurementStaff proStaff = procStaffService.get(Long.valueOf(procurementStaff));
		ProcurementStaff proStaff1 = null;
		if (isNull(procurementStaff1)) {
			proStaff1 = procStaffService.get(Long.valueOf(procurementStaff1));
		}
		qualifiedPurchaseUnits.setProcurementReceiving(proStaff1);
		qualifiedPurchaseUnits.setUploadflag(2);
		
		if (isNull(licenseNo)) {
			if (!isQuals(licenseNo, qualifiedPurchaseUnits.getLicenseNo())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改经营/生产许可证号");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改经营/生产许可证号，修改前值为：" + qualifiedPurchaseUnits.getLicenseNo() + "修改后值为：" + licenseNo);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setLicenseNo(licenseNo);
		}
		if (isNull(businessLicenseNo)) {
			if (!isQuals(businessLicenseNo, qualifiedPurchaseUnits.getBusinessLicenseNo())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改营业执照号");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改营业执照号，修改前值为：" + qualifiedPurchaseUnits.getBusinessLicenseNo()
						+ "修改后值为：" + businessLicenseNo);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setBusinessLicenseNo(businessLicenseNo);
		}
		if (isNull(certificateNo)) {
			if (!isQuals(certificateNo, qualifiedPurchaseUnits.getCertificateNo())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改GSP/GMP认证证书号码");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改GSP/GMP认证证书号码，修改前值为："
						+ qualifiedPurchaseUnits.getCertificateNo() + "修改后值为：" + certificateNo);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setCertificateNo(certificateNo);
		}
		if (isNull(qualityPrincipal)) {
			if (!isQuals(qualityPrincipal, qualifiedPurchaseUnits.getQualityPrincipal())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改质量负责人");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改质量负责人，修改前值为：" + qualifiedPurchaseUnits.getQualityPrincipal() + "修改后值为：" + qualityPrincipal);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setQualityPrincipal(qualityPrincipal);
		}
		if (isNull(organizationCodeDate)) {
			if (!isQuals(organizationCodeDate, qualifiedPurchaseUnits.getOrganizationCodeDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改组织机构代码到期时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改组织机构代码到期时间，修改前值为："
						+ qualifiedPurchaseUnits.getOrganizationCodeDate() + "修改后值为：" + organizationCodeDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setOrganizationCodeDate(organizationCodeDate);
		}
		if (isNull(procurementStaff)) {
			if (qualifiedPurchaseUnits != null && (!isQuals(proStaff.getProcurementName(),
					qualifiedPurchaseUnits.getProcurementStaff().getProcurementName()))) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改采购人员");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改采购人员，修改前值为：" + qualifiedPurchaseUnits.getProcurementStaff().getProcurementName() + "修改后值为："
								+ proStaff.getProcurementName());

				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setProcurementStaff(proStaff);
		}
		/*
		 * if(isNull(procurementStaff)){ if(!isQuals(procurementStaff,
		 * qualifiedPurchaseUnits.getProcurementStaffName())){
		 * QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new
		 * QualifiedPurchaseUnitsAccessory();
		 * qualifiedPuchAccessory.setModifier(user);
		 * qualifiedPuchAccessory.setProject_name("修改采购人员");
		 * qualifiedPuchAccessory.setQualified_purchase_units_id(
		 * qualifiedPurchaseUnits.getId());
		 * qualifiedPuchAccessory.setModified_time(new Date());
		 * qualifiedPuchAccessory.setChangeContent("修改采购人员，修改前值为："+
		 * qualifiedPurchaseUnits.getProcurementStaffName()+"修改后值为："+
		 * procurementStaff); qualifiedPuchAccessory.setReason(reason);
		 * archivesList.add(qualifiedPuchAccessory);
		 * 
		 * } qualifiedPurchaseUnits.setProcurementStaffName(procurementStaff); }
		 */
		if (isNull(organizationCodeInspectionDate)) {
			if (!isQuals(organizationCodeInspectionDate, qualifiedPurchaseUnits.getOrganizationCodeInspectionDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改组织机构代码年检时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改组织机构代码年检时间，修改前值为：" + qualifiedPurchaseUnits.getOrganizationCodeInspectionDate() + "修改后值为："
								+ organizationCodeInspectionDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setOrganizationCodeInspectionDate(organizationCodeInspectionDate);
		}
		if (isNull(authorizationDate)) {
			if (!isQuals(authorizationDate, qualifiedPurchaseUnits.getAuthorizationDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改法人委托书到期时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改法人委托书到期时间，修改前值为："
						+ qualifiedPurchaseUnits.getAuthorizationDate() + "修改后值为：" + authorizationDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setAuthorizationDate(authorizationDate);
		}
		if (isNull(qualityAssuranceDate)) {
			if (!isQuals(qualityAssuranceDate, qualifiedPurchaseUnits.getQualityAssuranceDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改质量保证书到时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改质量保证书到时间，修改前值为："
						+ qualifiedPurchaseUnits.getQualityAssuranceDate() + "修改后值为：" + qualityAssuranceDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}

			qualifiedPurchaseUnits.setQualityAssuranceDate(qualityAssuranceDate);
		}
		if (isNull(sqlCompanys)) {
			if (!isQuals(sqlCompanys, qualifiedPurchaseUnits.getSaleCompany())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改销售类别编号");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				String c = "";
				String d = "";
				if (sqlCompanys != null && !"".equals(sqlCompanys)) {
					String a[] = sqlCompanys.split(",");
					for (int i = 0; i < a.length; i++) {
						if ("1".equals(a[i])) {
							if (i != a.length - 1) {
								c += "经营,";
							} else {
								c += "经营";
							}
						}
						if ("2".equals(a[i])) {
							if (i != a.length - 1) {
								c += "新品,";
							} else {
								c += "新品";
							}
						}
						if ("3".equals(a[i])) {
							if (i != a.length - 1) {
								c += "市场,";
							} else {
								c += "市场";
							}
						}
					}
				}
				if (qualifiedPurchaseUnits.getSaleCompany() != null
						&& !"".equals(qualifiedPurchaseUnits.getSaleCompany())) {
					String a[] = qualifiedPurchaseUnits.getSaleCompany().split(",");
					for (int i = 0; i < a.length; i++) {
						if ("1".equals(a[i])) {
							d += "经营,";
						}
						if ("2".equals(a[i])) {
							d += "新品,";
						}
						if ("3".equals(a[i])) {
							d += "市场,";
						}
					}
				}
				qualifiedPuchAccessory.setChangeContent("修改销售类别，修改前值为：" + d + "修改后值为：" + c);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setSaleCompany(sqlCompanys);
		}

		if (isNull(oldNos)) {
			if (!isQuals(oldNos, qualifiedPurchaseUnits.getOldNo())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改旧编号");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改旧编号，修改前值为：" + qualifiedPurchaseUnits.getOldNo() + "修改后值为：" + oldNos);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setOldNo(oldNos);
		}
		if (isNull(customerNumber)) {
			if (!isQuals(customerNumber, qualifiedPurchaseUnits.getCustomerNumber())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改编号");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改编号，修改前值为：" + qualifiedPurchaseUnits.getCustomerNumber() + "修改后值为：" + customerName);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setCustomerNumber(customerNumber);
		}
		if (isNull(customerName)) {
			if (!isQuals(customerName, qualifiedPurchaseUnits.getCustomerName())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改客户名称");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改客户名称，修改前值为：：" + qualifiedPurchaseUnits.getCustomerName() + "修改后值为：" + customerName);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setCustomerName(customerName);
		}
		if (isNull(busLiceExpiraDate)) {
			if (!isQuals(busLiceExpiraDate, qualifiedPurchaseUnits.getBusLiceExpiraDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改营业执照到期时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改营业执照到期时间，修改前值为："
						+ qualifiedPurchaseUnits.getBusLiceExpiraDate() + "修改后值为：" + busLiceExpiraDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setBusLiceExpiraDate(busLiceExpiraDate);
		}
		if (isNull(busLiceAnnualSurvey)) {
			if (!isQuals(busLiceAnnualSurvey, qualifiedPurchaseUnits.getBusLiceAnnualSurvey())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改企业年度信息报告到期时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改企业年度信息报告到期时间，修改前值为："
						+ qualifiedPurchaseUnits.getBusLiceAnnualSurvey() + "修改后值为：" + busLiceAnnualSurvey);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setBusLiceAnnualSurvey(busLiceAnnualSurvey);
		}
		if (isNull(liceExpirationDate)) {
			if (!isQuals(liceExpirationDate, qualifiedPurchaseUnits.getLiceExpirationDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改经营许可证到期时间");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改经营许可证到期时间，修改前值为："
						+ qualifiedPurchaseUnits.getLiceExpirationDate() + "修改后值为：" + liceExpirationDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setLiceExpirationDate(liceExpirationDate);
		}
		if (isNull(gpsExpirationDate)) {
			if (!isQuals(gpsExpirationDate, qualifiedPurchaseUnits.getGpsExpirationDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改GSP截止日期");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改GSP截止日期，修改前值为："
						+ qualifiedPurchaseUnits.getGpsExpirationDate() + "修改后值为：" + gpsExpirationDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setGpsExpirationDate(gpsExpirationDate);
		}
		/*
		 * if(isNull(documentEvidenceDate)){ if(!isQuals(documentEvidenceDate,
		 * qualifiedPurchaseUnits.getDocumentEvidenceDate())){
		 * QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new
		 * QualifiedPurchaseUnitsAccessory();
		 * qualifiedPuchAccessory.setModifier(user);
		 * qualifiedPuchAccessory.setProject_name("修改认证材料到期日期");
		 * qualifiedPuchAccessory.setQualified_purchase_units_id(
		 * qualifiedPurchaseUnits.getId());
		 * qualifiedPuchAccessory.setModified_time(new Date());
		 * qualifiedPuchAccessory.setChangeContent("修改认证材料到期日期，修改前值为："+
		 * qualifiedPurchaseUnits.getDocumentEvidenceDate()+"修改后值为："+
		 * documentEvidenceDate); archivesList.add(qualifiedPuchAccessory);
		 * 
		 * }
		 * qualifiedPurchaseUnits.setDocumentEvidenceDate(documentEvidenceDate);
		 * }
		 */
		// String tenBitCode = request.getParameter("tenBitCode");//十位码
		if (isNull(tenBitCode)) {
			if (!isQuals(tenBitCode, qualifiedPurchaseUnits.getTenBitCode())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改十位码");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改十位码，修改前值为：" + qualifiedPurchaseUnits.getTenBitCode() + "修改后值为：" + tenBitCode);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setTenBitCode(tenBitCode);
		}
		// String email = request.getParameter("email");//Email地址
		if (isNull(email)) {
			if (!isQuals(email, qualifiedPurchaseUnits.getEmail())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改email");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改email，修改前值为：" + qualifiedPurchaseUnits.getEmail() + "修改后值为：" + email);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setEmail(email);
		}
		if (isNull(address)) {
			if (!isQuals(address, qualifiedPurchaseUnits.getAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改企业地址");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改企业地址，修改前值为：" + qualifiedPurchaseUnits.getAddress() + "修改后值为：" + address);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setAddress(address);
		}
		if (isNull(economicNature)) {
			if (!isQuals(economicNature, qualifiedPurchaseUnits.getEconomicNature())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改企业经营类型");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改企业经营类型，修改前值为：" + qualifiedPurchaseUnits.getEconomicNature() + "修改后值为：" + economicNature);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setEconomicNature(economicNature);
		}
		// String pinyinCode = request.getParameter("pinyinCode");//拼音码
		if (isNull(pinyinCode)) {
			if (!isQuals(pinyinCode, qualifiedPurchaseUnits.getPinyinCode())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改拼音码");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改拼音码，修改前值为：" + qualifiedPurchaseUnits.getPinyinCode() + "修改后值为：" + pinyinCode);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setPinyinCode(pinyinCode);
		}
		// String postalCode = request.getParameter("postalCode");//邮编
		if (isNull(postalCode)) {
			if (!isQuals(postalCode, qualifiedPurchaseUnits.getPostalCode())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改邮编");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改邮编，修改前值为：" + qualifiedPurchaseUnits.getPostalCode() + "修改后值为：" + postalCode);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setPostalCode(postalCode);
		}
		// String phone = request.getParameter("phone");//电话
		if (isNull(phone)) {
			if (!isQuals(phone, qualifiedPurchaseUnits.getPhone())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改采购人员联系电话");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改采购人员联系电话，修改前值为：" + qualifiedPurchaseUnits.getPhone() + "修改后值为：" + phone);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setPhone(phone);
		}
		if (isNull(companyPhone)) {
			if (!isQuals(companyPhone, qualifiedPurchaseUnits.getCompanyPhone())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改企业联系电话");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改企业联系电话，修改前值为：" + qualifiedPurchaseUnits.getCompanyPhone() + "修改后值为：" + companyPhone);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setCompanyPhone(companyPhone);
		}
		// String portraiture = request.getParameter("portraiture");//传真
		if (isNull(portraiture)) {
			if (!isQuals(portraiture, qualifiedPurchaseUnits.getPortraiture())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改传真");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改传真，修改前值为：" + qualifiedPurchaseUnits.getPortraiture() + "修改后值为：" + portraiture);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setPortraiture(portraiture);
		}
		// String corporation = request.getParameter("corporation");//法人
		if (isNull(corporation)) {
			if (!isQuals(corporation, qualifiedPurchaseUnits.getCorporation())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改法人");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改法人，修改前值为：" + qualifiedPurchaseUnits.getCorporation() + "修改后值为：" + corporation);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setCorporation(corporation);
		}
		// String taxRegisNo = request.getParameter("certificate_No");//纳税人登记证
		if (isNull(taxpayeRegisterNo)) {
			if (!isQuals(taxpayeRegisterNo, qualifiedPurchaseUnits.getTaxpayeRegisterNo())) {

				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改纳税人登记证");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改纳税人登记证，修改前值为："
						+ qualifiedPurchaseUnits.getTaxpayeRegisterNo() + "修改后值为：" + taxpayeRegisterNo);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);

			}
			qualifiedPurchaseUnits.setTaxpayeRegisterNo(taxpayeRegisterNo);
		}
		// String bankName = request.getParameter("bankName");//开户银行
		if (isNull(bankName)) {
			if (!isQuals(bankName, qualifiedPurchaseUnits.getBankName())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改开户银行");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改开户银行，修改前值为：" + qualifiedPurchaseUnits.getBankName() + "修改后值为：" + bankName);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setBankName(bankName);
		}
		// String bankNumber = request.getParameter("bankNumber");//开户银行账户
		if (isNull(bankNumber)) {
			if (!isQuals(bankNumber, qualifiedPurchaseUnits.getBankNumber())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改开户银行账户");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改开户银行账户，修改前值为：" + qualifiedPurchaseUnits.getBankNumber() + "修改后值为：" + bankNumber);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setBankNumber(bankNumber);
		}
		if (isNull(accountOpeningDate)) {
			if (!isQuals(accountOpeningDate, qualifiedPurchaseUnits.getAccountOpeningDate())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改开户日期");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改开户日期，修改前值为：" + qualifiedPurchaseUnits.getAccountOpeningDate()
						+ "修改后值为：" + accountOpeningDate);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setAccountOpeningDate(accountOpeningDate);
		}

		// String businessScope = request.getParameter("businessScope");//经营范围
		if (isNull(businessScope)) {
			if (!isQuals(businessScope, qualifiedPurchaseUnits.getBusinessScope())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改经营范围");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改经营范围，修改前值为：" + qualifiedPurchaseUnits.getBusinessScope() + "修改后值为：" + businessScope);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setBusinessScope(businessScope);
		}
		if (isNull(remark)) {
			if (!isQuals(remark, qualifiedPurchaseUnits.getRemark())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("修改备注");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改备注，修改前值为：" + qualifiedPurchaseUnits.getRemark() + "修改后值为：" + remark);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setRemark(remark);
		}

		if (isNull(taxReceiptAddress)) {
			if (!isQuals(taxReceiptAddress, qualifiedPurchaseUnits.getTaxReceiptAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("税票信息地址");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改税票信息地址，修改前值为："
						+ qualifiedPurchaseUnits.getTaxReceiptAddress() + "修改后值为：" + taxReceiptAddress);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setTaxReceiptAddress(taxReceiptAddress);
		}
		if (isNull(taxReceiptPhone)) {
			if (!isQuals(taxReceiptAddress, qualifiedPurchaseUnits.getTaxReceiptAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("税票电话");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改税票电话，修改前值为：" + qualifiedPurchaseUnits.getTaxReceiptPhone() + "修改后值为：" + taxReceiptPhone);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setTaxReceiptPhone(taxReceiptPhone);
		}
		if (isNull(shippingAddress)) {
			if (!isQuals(shippingAddress, qualifiedPurchaseUnits.getShippingAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("发货地址");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改发货地址，修改前值为：" + qualifiedPurchaseUnits.getShippingAddress() + "修改后值为：" + shippingAddress);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setShippingAddress(shippingAddress);
		}
		if (isNull(consigneeName)) {
			if (!isQuals(taxReceiptAddress, qualifiedPurchaseUnits.getTaxReceiptAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("收货人");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改收货人，修改前值为：" + qualifiedPurchaseUnits.getConsigneeName() + "修改后值为：" + consigneeName);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setConsigneeName(consigneeName);
		}
		if (isNull(consigneePhone)) {
			if (!isQuals(taxReceiptAddress, qualifiedPurchaseUnits.getTaxReceiptAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("收货人电话");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改收货人电话，修改前值为：" + qualifiedPurchaseUnits.getConsigneePhone() + "修改后值为：" + consigneePhone);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setConsigneePhone(consigneePhone);
		}
		if (isNull(electronicMonitoringCode)) {
			if (!isQuals(taxReceiptAddress, qualifiedPurchaseUnits.getTaxReceiptAddress())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("客户电子监管码");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent("修改客户电子监管码，修改前值为："
						+ qualifiedPurchaseUnits.getElectronicMonitoringCode() + "修改后值为：" + electronicMonitoringCode);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setElectronicMonitoringCode(electronicMonitoringCode);
		}
		if (isNull(userFalg)) {
			if (!isQuals(userFalg, qualifiedPurchaseUnits.getUseFlag())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("停用标识");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory
						.setChangeContent("修改停用标识，修改前值为：" + getUserFlagValue(qualifiedPurchaseUnits.getUseFlag())
								+ "修改后值为：" + getUserFlagValue(userFalg));
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setUseFlag(userFalg);
		}
		if (isNull(openCompany)) {
			if (!isQuals(openCompany, qualifiedPurchaseUnits.getOpenCompany())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("开户公司");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改开户公司，修改前值为：" + qualifiedPurchaseUnits.getOpenCompany() + "修改后值为：" + openCompany);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setOpenCompany(openCompany);
		}
		if (isNull(receivingPerson)) {
			if (!isQuals(receivingPerson, qualifiedPurchaseUnits.getReceivingPerson())) {
				QualifiedPurchaseUnitsAccessory qualifiedPuchAccessory = new QualifiedPurchaseUnitsAccessory();
				qualifiedPuchAccessory.setModifier(user);
				qualifiedPuchAccessory.setProject_name("提货人员");
				qualifiedPuchAccessory.setQualified_purchase_units_id(qualifiedPurchaseUnits.getId());
				qualifiedPuchAccessory.setModified_time(new Date());
				qualifiedPuchAccessory.setChangeContent(
						"修改提货人员，修改前值为：" + qualifiedPurchaseUnits.getReceivingPerson() + "修改后值为：" + receivingPerson);
				qualifiedPuchAccessory.setReason(reason);
				archivesList.add(qualifiedPuchAccessory);
			}
			qualifiedPurchaseUnits.setReceivingPerson(receivingPerson);
		}

		String nowdate = DateTimeUtils.getNowStrDate();
		if (isNull(qualifiedPurchaseUnits.getBusLiceExpiraDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getBusLiceExpiraDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {// 今天比该日期大,就是过期了
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getBusLiceAnnualSurvey())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getBusLiceAnnualSurvey()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {// 今天比该日期大,就是过期了
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getLiceExpirationDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getLiceExpirationDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getGpsExpirationDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getGpsExpirationDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getOrganizationCodeDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getOrganizationCodeDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getOrganizationCodeInspectionDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getOrganizationCodeInspectionDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getQualityAssuranceDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getQualityAssuranceDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getAuthorizationDate())) {
			if (DateTimeUtils.compareTwoDate(nowdate, qualifiedPurchaseUnits.getAuthorizationDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getProcurementStaff().getPowerOfAttorneyDate())) {// 采购人员-法人委托书到期日期
			if (DateTimeUtils.compareTwoDate(nowdate,
					qualifiedPurchaseUnits.getProcurementStaff().getPowerOfAttorneyDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}
		if (isNull(qualifiedPurchaseUnits.getProcurementStaff().getIdentityCardDate())) {// 采购人员-身份证有效期
			if (DateTimeUtils.compareTwoDate(nowdate,
					qualifiedPurchaseUnits.getProcurementStaff().getIdentityCardDate()) > 0
					&& qualifiedPurchaseUnits.getUseFlag().trim().equals("0")) {
				qualifiedPurchaseUnits.setUseFlag("2");
			}
		}

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		batchUpload(multiRequest, qualifiedPurchaseUnits);
		qualifiedPurchaseUnitsService.saveOrUpdate(qualifiedPurchaseUnits);
		qualPurchUnitsAccessoryService.saveList(archivesList);
		logService.addLog("修改合格购货单位", user.getRealname(), "修改", "企业资质管理  > 合格购货单位", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/firstEnterprise/ajaxQueryWarnPurchase.html")
	public String ajaxQuerWarn(Model model, HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'ghs%' or a.limit_name like 'cg%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer("from QualifiedPurchaseUnits a where 1=1 and  a.delete_flag=0");
		StringBuffer subjectBuffer = new StringBuffer();
		String yinyezhizhao = "";// 营业执照日期
		String yingyezhizhaonianjian = "";// 企业年度信息报告
		String xukezheng = "";// 许可证
		String gspdaoqi = "";// GS到期日期
		String zuzhijigoudaima = "";// 组织机构代码
		String zuzhijigoudaimanianjian = "";// 组织机构代码年检
		String zhiliaobaozhengxieyishu = "";// 质量保证协议书
		String shouquanweitoushu = "";// 委托授权书
		String cgfarenweituoshu = "";// 采购人员法人委托书
		String cgshenfenzheng = "";// 采购人员身份证
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils
					.formCurrentDate(DateTimeUtils.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("ghs_businessLicense_ExpirationDate")) {
				subjectBuffer.append("or a.busLiceExpiraDate<='" + startDate + "'  ");
				yinyezhizhao = startDate;
			} else if (limit_name.equals("ghs_businessLicense_annualSurvey")) {
				subjectBuffer.append("or a.busLiceAnnualSurvey<='" + startDate + "'  ");
				yingyezhizhaonianjian = startDate;
			} else if (limit_name.equals("ghs_licence_ExpirationDate")) {
				subjectBuffer.append("or a.liceExpirationDate<='" + startDate + "'  ");
				xukezheng = startDate;
			} else if (limit_name.equals("ghs_GPS_ExpirationDate")) {
				subjectBuffer.append("or a.gpsExpirationDate<='" + startDate + "'  ");
				gspdaoqi = startDate;
			} else if (limit_name.equals("ghs_organizationCodeDate")) {
				subjectBuffer.append("or a.organizationCodeDate<='" + startDate + "'  ");
				zuzhijigoudaima = startDate;
			} else if (limit_name.equals("ghs_organizationCodeInspectionDate")) {
				subjectBuffer.append("or a.organizationCodeInspectionDate<='" + startDate + "'  ");
				zuzhijigoudaimanianjian = startDate;
			} else if (limit_name.equals("ghs_qualityAssuranceDate")) {
				subjectBuffer.append("or a.qualityAssuranceDate<='" + startDate + "'  ");
				zhiliaobaozhengxieyishu = startDate;
			} else if (limit_name.equals("ghs_authorizationDate")) {
				subjectBuffer.append("or a.authorizationDate<='" + startDate + "'  ");
				shouquanweitoushu = startDate;
			} else if (limit_name.equals("cg_authorizationDate")) {
				subjectBuffer.append("or a.procurementStaff.powerOfAttorneyDate<='" + startDate + "'  ");
				cgfarenweituoshu = startDate;
			} else if (limit_name.equals("cg_IDCardValidate")) {
				subjectBuffer.append("or a.procurementStaff.identityCardDate<='" + startDate + "'  ");
				cgshenfenzheng = startDate;
			}
		}
		String subjecStr = subjectBuffer.toString();
		if (!subjecStr.trim().equals("")) {
			String str = subjecStr.substring(2);
			hqlBuffer.append(" and ( ");
			hqlBuffer.append(str);
			hqlBuffer.append(" )");
		}
		List<QualifiedPurchaseUnits> purchaseList = qualifiedPurchaseUnitsService.findList(hqlBuffer.toString());

		for (QualifiedPurchaseUnits purchase : purchaseList) {
			// String companyName = supply.getCustomerName();
			String yyzz = purchase.getBusLiceExpiraDate();// 营业执照到期时间期
			String yyzznj = purchase.getBusLiceAnnualSurvey();// 企业年度信息报告
			String xyz = purchase.getLiceExpirationDate();// 经营许可证到期时间
			String gsp = purchase.getGpsExpirationDate();// GSP截止日期
			String zzjgdm = purchase.getOrganizationCodeDate();// 组织机构代码
			String zzjgdmnj = purchase.getOrganizationCodeInspectionDate();// 组织机构代码年检
			String zlbzs = purchase.getQualityAssuranceDate();//质量保证协议到期日期
			String sqwts = purchase.getAuthorizationDate();//授权委托书到期日期
			String today = DateTimeUtils.getNowStrDate();

			
			if (yyzz != null && !"".equals(yyzz.trim()) && DateTimeUtils.compareTwoDate(today, yyzz) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (yyzznj != null && !"".equals(yyzznj.trim()) && DateTimeUtils.compareTwoDate(today, yyzznj) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (xyz != null && !"".equals(xyz.trim()) && DateTimeUtils.compareTwoDate(today, xyz) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (gsp != null && !"".equals(gsp.trim()) && DateTimeUtils.compareTwoDate(today, gsp) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (zzjgdm != null && !"".equals(zzjgdm.trim()) && DateTimeUtils.compareTwoDate(today, zzjgdm) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
				//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (zzjgdmnj != null && !"".equals(zzjgdmnj.trim()) && DateTimeUtils.compareTwoDate(today, zzjgdmnj) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
				//	qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (zlbzs != null && !"".equals(zlbzs.trim()) && DateTimeUtils.compareTwoDate(today, zlbzs) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (sqwts != null && !"".equals(sqwts.trim()) && DateTimeUtils.compareTwoDate(today, sqwts) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (purchase.getProcurementStaff() != null && purchase.getProcurementStaff().getIdentityCardDate() != null
					&& !"".equals(purchase.getProcurementStaff().getIdentityCardDate())
					&& DateTimeUtils.compareTwoDate(today, purchase.getProcurementStaff().getIdentityCardDate()) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}
			if (purchase.getProcurementStaff() != null && purchase.getProcurementStaff().getPowerOfAttorneyDate() != null
					&& !"".equals(purchase.getProcurementStaff().getPowerOfAttorneyDate())
					&& DateTimeUtils.compareTwoDate(today, purchase.getProcurementStaff().getPowerOfAttorneyDate()) > 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("0")) {
					purchase.setUseFlag("2");
					//qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
				}

			}

			if (yyzz != null && !"".equals(yyzz.trim()) && DateTimeUtils.compareTwoDate(today, yyzz) <= 0
					&& yyzznj != null && !"".equals(yyzznj.trim()) && DateTimeUtils.compareTwoDate(today, yyzznj) <= 0
					&& xyz != null && !"".equals(xyz.trim()) && DateTimeUtils.compareTwoDate(today, xyz) <= 0
					&& gsp != null && !"".equals(gsp.trim()) && DateTimeUtils.compareTwoDate(today, gsp) <= 0
					&& zzjgdm != null && !"".equals(zzjgdm.trim()) && DateTimeUtils.compareTwoDate(today, zzjgdm) <= 0
					&& zzjgdmnj != null && !"".equals(zzjgdmnj.trim())
					&& !purchase.getProcurementStaff().getPowerOfAttorneyDate().equals("")&&purchase.getProcurementStaff().getPowerOfAttorneyDate()!=null
					&&DateTimeUtils.compareTwoDate(today, purchase.getProcurementStaff().getPowerOfAttorneyDate().toString())<=0
					&& !purchase.getProcurementStaff().getIdentityCardDate().equals("")&&purchase.getProcurementStaff().getIdentityCardDate()!=null
					&&DateTimeUtils.compareTwoDate(today, purchase.getProcurementStaff().getIdentityCardDate().toString())<=0
					&& DateTimeUtils.compareTwoDate(today, zzjgdmnj) <= 0 && zlbzs != null && !"".equals(zlbzs.trim())
					&& DateTimeUtils.compareTwoDate(today, zlbzs) <= 0 && sqwts != null && !"".equals(sqwts.trim())
					&& DateTimeUtils.compareTwoDate(today, sqwts) <= 0) {
				if (purchase.getUseFlag() != null && purchase.getUseFlag().trim().equals("2")) {
					purchase.setUseFlag("0");
				}

			}
			qualifiedPurchaseUnitsService.saveOrUpdate(purchase);
			// String khxx = purchase.getAccountDate();//开户信息到期日期
			if (purchase.getDelete_flag() == 0) {
				if (yinyezhizhao != "" && yyzz != null && DateTimeUtils.compareTwoDate(yinyezhizhao, yyzz) >= 0) {

					int days = DateTimeUtils.compareDateInterval(yyzz, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "营业执照还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append(
								"" + purchase.getCustomerName() + "营业执照已过期<font>" + Math.abs(days) + "</font>天</a>");
					}

				}
				if (yingyezhizhaonianjian != "" && yyzznj != null
						&& DateTimeUtils.compareTwoDate(yingyezhizhaonianjian, yyzznj) >= 0) {

					int days = DateTimeUtils.compareDateInterval(yyzznj, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "企业年度信息报告还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append(
								"" + purchase.getCustomerName() + "企业年度信息报告已过期<font>" + Math.abs(days) + "</font>天</a>");
					}

				}
				if (xukezheng != "" && xyz != null && DateTimeUtils.compareTwoDate(xukezheng, xyz) >= 0) {
					int days = DateTimeUtils.compareDateInterval(xyz, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "许可证还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append(
								"" + purchase.getCustomerName() + "许可证已过期<font>" + Math.abs(days) + "</font>天</a>");
					}

				}
				if (gspdaoqi != "" && gsp != null && DateTimeUtils.compareTwoDate(gspdaoqi, gsp) >= 0) {
					int days = DateTimeUtils.compareDateInterval(gsp, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "GSP认证还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "GSP认证已过期<font>" + Math.abs(days)
								+ "</font>天 到期</a>");
					}

				}

				if (zuzhijigoudaima != "" && zzjgdm != null
						&& DateTimeUtils.compareTwoDate(zuzhijigoudaima, zzjgdm) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zzjgdm, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "组织机构代码还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "组织机构代码已过期<font>" + Math.abs(days)
								+ "</font>天 到期</a>");

					}
				}
				if (zuzhijigoudaimanianjian != "" && zzjgdmnj != null
						&& DateTimeUtils.compareTwoDate(zuzhijigoudaimanianjian, zzjgdmnj) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zzjgdmnj, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "组织机构代码年检还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "组织机构代码年检已过期<font>" + Math.abs(days)
								+ "</font>天 到期</a>");

					}
				}
				if (zhiliaobaozhengxieyishu != "" && zlbzs != null
						&& DateTimeUtils.compareTwoDate(zhiliaobaozhengxieyishu, zlbzs) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zlbzs, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "质量保证协议书还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "质量保证协议书已过期<font>" + Math.abs(days)
								+ "</font>天 到期</a>");

					}
				}
				if (shouquanweitoushu != "" && sqwts != null
						&& DateTimeUtils.compareTwoDate(shouquanweitoushu, sqwts) >= 0) {
					int days = DateTimeUtils.compareDateInterval(sqwts, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "法人委托书还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId() + "' traget='_blank'>");
						buffer.append("" + purchase.getCustomerName() + "法人委托书已过期<font>" + Math.abs(days)
								+ "</font>天 到期</a>");

					}
				}

				if (purchase.getProcurementStaff() != null) {
					if (purchase.getProcurementStaff().getPowerOfAttorneyDate() != null
							&& !"".equals(purchase.getProcurementStaff().getPowerOfAttorneyDate().trim())) {
						if (DateTimeUtils.compareTwoDate(cgfarenweituoshu,
								purchase.getProcurementStaff().getPowerOfAttorneyDate()) >= 0) {
							int days = DateTimeUtils.compareDateInterval(purchase.getProcurementStaff().getPowerOfAttorneyDate(),
									nowdate);
							if (days >= 0) {
								buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId()
										+ "' traget='_blank'>");
								buffer.append(
										"" + purchase.getCustomerName() + "采购员" + purchase.getProcurementStaff().getProcurementName()
												+ "法人委托书还有<font>" + days + "</font>天 到期</a>");
							} else {
								buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId()
										+ "' traget='_blank'>");
								buffer.append(
										"" + purchase.getCustomerName() + "采购员" + purchase.getProcurementStaff().getProcurementName()
												+ "法人委托书已过期<font>" + Math.abs(days) + "</font>天 到期</a>");

							}
						}
					}
					if (purchase.getProcurementStaff().getIdentityCardDate() != null
							&& !"".equals(purchase.getProcurementStaff().getIdentityCardDate().trim())) {
						if (DateTimeUtils.compareTwoDate(cgshenfenzheng, purchase.getProcurementStaff().getIdentityCardDate()) >= 0) {
							int days = DateTimeUtils.compareDateInterval(purchase.getProcurementStaff().getIdentityCardDate(),
									nowdate);
							if (days >= 0) {
								buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId()
										+ "' traget='_blank'>");
								buffer.append(
										"" + purchase.getCustomerName() + "采购员" + purchase.getProcurementStaff().getProcurementName()
												+ "身份证还有<font>" + days + "</font>天 到期</a>");
							} else {
								buffer.append("&nbsp;<a href='view_hgghdw.html?id=" + purchase.getId()
										+ "' traget='_blank'>");
								buffer.append(
										"" + purchase.getCustomerName() + "采购员" + purchase.getProcurementStaff().getProcurementName()
												+ "身份证已过期<font>" + Math.abs(days) + "</font>天 到期</a>");

							}
						}
					}
				}
			}

		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/firstEnterprise/confrimRejectQualefiedPurchase.html")
	public String confrimRejectQualefiedPurchase(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("id");
		Long id = null;
		if (isNull(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		QualifiedPurchaseUnits qualifiedPurchaseUnits = qualifiedPurchaseUnitsService.findByPurchaseUtilsId(id);
		PurchaseUnit purchaseUnit = purchaseUnitsService.get(qualifiedPurchaseUnits.getPurchaseUnitsId());
		purchaseUnit.setReviewStatus(3);
		purchaseUnitsService.save(purchaseUnit);
		qualifiedPurchaseUnits.setDelete_flag(1);
		qualifiedPurchaseUnitsService.saveOrUpdate(qualifiedPurchaseUnits);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("驳回合格购货商成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);

		return null;
	}

	private boolean isNull(String str) {

		return str != null && !"".equals(str.trim());
	}

	private boolean isQuals(String str1, String str2) {
		if (str2 == null)
			return false;
		return str1.trim().equals(str2.trim());
	}

	private String getUserFlagValue(String type) {
		String returnValue = "";
		if (type == null) {
			returnValue = "null";
			return returnValue;
		} else if (type.equals("")) {
			return returnValue;
		}
		return type.equals("0") ? "启用状态" : type.equals("1") ? "停用状态 " : "暂时停用状态 ";
	}

	public static void batchUpload(MultipartHttpServletRequest request, QualifiedPurchaseUnits purchaseUnit) {
		Map<String, MultipartFile> filesMap = request.getFileMap();
		String serverRealPath = request.getSession().getServletContext().getRealPath("/");// 获取服务器绝对路径
		String fileSavePath = serverRealPath + Constants.UPLOAD_PATH;// 上传文件存储的绝对路径
		String fileTempPath = serverRealPath + Constants.TEMPPATH;// 上传文件在服务器临时存储的的绝对路径
		new File(fileSavePath).mkdirs();
		try {
			File tempPathFile = new File(fileTempPath);
			if (!tempPathFile.exists()) {
				tempPathFile.mkdirs();
			}
			Iterator<String> its = filesMap.keySet().iterator();
			while (its.hasNext()) {
				String requestName = its.next();
				MultipartFile item = filesMap.get(requestName);
				String fileName = FileUtil.getFileName();// 重命名文件名
				MultipartFile uploadFile = (MultipartFile) item;
				if (uploadFile.getOriginalFilename() == null || uploadFile.getOriginalFilename().equals(""))
					continue;
				String fileNameLong = uploadFile.getOriginalFilename();// 获取上传文件的名称
				// String requestName = uploadFile.getName();//获取上传文件对应字段名称
				String fileNameExtension = FileUtil.getFileExtension(fileNameLong);// 获取文件的上传拓展名
				String relativeSavePath = Constants.UPLOAD_PATH + fileName + "." + fileNameExtension;// 用户保存到数据库的相对文件路径及名称
				relativeSavePath = relativeSavePath.substring(1);
				File savaFile = new File(fileSavePath + fileName + "." + fileNameExtension);
				if (!savaFile.exists()) {
					savaFile.mkdirs();
				}
				if (requestName.equals("businessLicencePath")) {// 营业执照
					purchaseUnit.setBusinessLicencePath(relativeSavePath);
				} else if (requestName.equals("licencePath")) {// 许可证
					purchaseUnit.setLicencePath(relativeSavePath);
				} else if (requestName.equals("businessLicenseInspectionPath")) {// 营业执照年检
					purchaseUnit.setBusinessLicenseInspectionPath(relativeSavePath);
				} else if (requestName.equals("gspCertificatePath")) {// gsp证书
					purchaseUnit.setGspCertificatePath(relativeSavePath);
				} else if (requestName.equals("organizationCodePath")) {// 组织机构代码
					purchaseUnit.setOrganizationCodePath(relativeSavePath);
				} else if (requestName.equals("organizationCodeInspectionPath")) {// 组织机构代码年检到
					purchaseUnit.setOrganizationCodeInspectionPath(relativeSavePath);
				} else if (requestName.equals("qualityAssurancePath")) {// 质量保证协议
					purchaseUnit.setQualityAssurancePath(relativeSavePath);
				} else if (requestName.equals("authorizationPath")) {// 法人委托书
					purchaseUnit.setAuthorizationPath(relativeSavePath);
				}
				uploadFile.transferTo(savaFile);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/firstEnterprise/delteQualifiedAttachment.html")
	public ModelAndView deleteFile(Model mode, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type = request.getParameter("type");
		String ctxPath = request.getSession().getServletContext().getRealPath("/");
		String filePath = ctxPath + fileName;
		Long enterpriseId = null;
		if (id != null && !id.trim().equals("")) {
			enterpriseId = Long.valueOf(id);
		} else {
			enterpriseId = Long.valueOf(0);
		}
		QualifiedPurchaseUnits purchaseUnit = qualifiedPurchaseUnitsService.get(enterpriseId);
		if (type != null && !type.trim().equals("")) {
			if (type.equals("yyzz")) {
				purchaseUnit.setBusinessLicencePath("");
			} else if (type.equals("xkz")) {
				purchaseUnit.setLicencePath("");
			} else if (type.equals("yyzznj")) {
				purchaseUnit.setBusinessLicenseInspectionPath("");
			} else if (type.equals("gspzs")) {
				purchaseUnit.setGspCertificatePath("");
			} else if (type.equals("zzjgdm")) {
				purchaseUnit.setOrganizationCodePath("");
			} else if (type.equals("zzjgdmnj")) {
				purchaseUnit.setOrganizationCodeInspectionPath("");
			} else if (type.equals("zlbzxy")) {
				purchaseUnit.setQualityAssurancePath("");
			} else if (type.equals("wtsqs")) {
				purchaseUnit.setAuthorizationPath("");
			}
		}
		qualifiedPurchaseUnitsService.saveOrUpdate(purchaseUnit);
		boolean status = FileOperate.delFile(filePath);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status) {
			map.put("success", URLEncoder.encode("删除附件成功！", "UTF-8"));
		} else {
			map.put("success", URLEncoder.encode("删除附件失败！", "UTF-8"));
		}
		UtilJson.printMapJson(response, map);
		return null;
	}
}
