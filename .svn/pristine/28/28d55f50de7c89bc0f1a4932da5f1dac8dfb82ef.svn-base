package com.sinosoft.enterpriseManage.firstEnterprise.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterpriseAccessoryVO;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnitsAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSupplierArchives;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSuppArchivesService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSupplyDrugFromsService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
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

@Controller
public class QualifiedSuppliesAction extends BaseFormController {
	@Autowired
	private QualifiedSuppliersService qualifiedSuppliesService;
	@Autowired
	private QualSuppArchivesService qualSuppArchivesService;
	@Autowired
	private WarnConfigService configService;
	@Autowired
	private FirstEnterpriseService firstEnterpriseService;
	@Autowired
	private SalesStaffService salesService;
	@Autowired
	private SystemLogService logService;
	@Autowired
	private DrugFormDictionaryService drugFormDictionaryService;
	@Autowired
	private QualSupplyDrugFromsService qualSupplyDrugFromsService;

	@RequestMapping("/firstEnterprise/qualifiedSupplies.html")
	public ModelAndView getQulifiedSupply(Model model, HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/SYQY/HGGYS/qualifiedSupplies");
	}

	@RequestMapping("/firstEnterprise/hggys.html")
	public ModelAndView getQulifiedSupplyList(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<QualifiedSuppliers> qualifiesSupplyList = new ArrayList<QualifiedSuppliers>();
		String page = DisplayGetPage.getPageParamName("qualifiesSupply", request);
		String hql = "from QualifiedSuppliers a where a.deleteFlag=0 order by a.id DESC";
		if (page == null) {
			qualifiesSupplyList = qualifiedSuppliesService.getQualifiedSuppliersList(0, Constants.pagesize);
		} else {
			qualifiesSupplyList = qualifiedSuppliesService.getQualifiedSuppliersListByCondition(hql,
					new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_qualifiedSupplier where delete_flag=0";
		int resultSize = qualifiedSuppliesService.countOrderInfo(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/HGGYS/hggys", "qualifiesSupplyList", qualifiesSupplyList);
	}

	@RequestMapping("/firstEnterprise/queryhggys.html")
	public ModelAndView queryQulifiedSupplyList(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<QualifiedSuppliers> qualifiesSupplyList = new ArrayList<QualifiedSuppliers>();
		String page = DisplayGetPage.getPageParamName("qualifiesSupply", request);
		String query_khbh = request.getParameter("query_khbh");
		String query_kfmc = request.getParameter("query_kfmc");
		StringBuffer buffer = new StringBuffer();
		buffer.append("from QualifiedSuppliers a where 1=1 and   a.deleteFlag=0 ");
		String sql = "select count(*) from t_qualifiedSupplier where delete_flag=0";
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
			sql = sql + " and name like'%" + query_kfmc.trim() + "%'";
		}
		buffer.append(" order by a.id DESC");
		// String hql = "from QualifiedSuppliers a where a.deleteFlag=0 order by
		// a.id DESC";
		if (page == null) {
			qualifiesSupplyList = qualifiedSuppliesService.getQualifiedSuppliersListByCondition(buffer.toString(),
					new HashMap<String, Object>(), 0, Constants.pagesize);
		} else {
			qualifiesSupplyList = qualifiedSuppliesService.getQualifiedSuppliersListByCondition(buffer.toString(),
					new HashMap<String, Object>(), (Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数

		int resultSize = qualifiedSuppliesService.countOrderInfo(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/QYZZ/HGGYS/hggys", "qualifiesSupplyList", qualifiesSupplyList);
	}

	@RequestMapping("/firstEnterprise/view_hggys.html")
	public ModelAndView viewQualifiedSupply(Model model, HttpServletRequest request, HttpServletResponse response) {
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = new Long(0);
		}
		QualifiedSuppliers qualifiedSupply = qualifiedSuppliesService.findById(String.valueOf(id));
		List<DrugFormDictionary> drugFromList = drugFormDictionaryService.getAll();

		model.addAttribute("drugFromList", drugFromList);
		model.addAttribute("qualifiedSupply", qualifiedSupply);
		return new ModelAndView("/QYZZ/HGGYS/view_hggys");
	}

	/*
	 * @RequestMapping("/firstEnterprise/updateScope.html") public ModelAndView
	 * updateScope(Model model,HttpServletRequest request ,HttpServletResponse
	 * response) throws UnsupportedEncodingException{ String p_id =
	 * request.getParameter("id"); String values =
	 * request.getParameter("drugFromList"); Long id = null; if(p_id!=null &&
	 * !"".equals(p_id)){ id = Long.valueOf(p_id); }else{ id = new Long(0); }
	 * 
	 * QualifiedSuppliers qualifiedSupply =
	 * qualifiedSuppliesService.findById(String.valueOf(id)); String
	 * businessScope = ""; Date date = new Date(); SimpleDateFormat
	 * modifyDateFormat = new SimpleDateFormat("yyyy-MM-dd"); String modifyDate
	 * = modifyDateFormat.format(date);
	 * 
	 * List<QulifiedSupplyDrugFroms> drugFromsList =
	 * qualSupplyDrugFromsService.getListByQualSuppId(id); //先删除
	 * if(null!=drugFromsList){ for(QulifiedSupplyDrugFroms drugFroms
	 * :drugFromsList){ qualSupplyDrugFromsService.delete(drugFroms); } }
	 * drugFromsList.clear(); if (null!=values){ String[]
	 * result=values.split(","); for(int i=0;i<result.length;i++) {
	 * QulifiedSupplyDrugFroms drugFroms = new QulifiedSupplyDrugFroms();
	 * DrugFormDictionary drugFrom =
	 * drugFormDictionaryService.get(Long.parseLong(result[i]));
	 * 
	 * drugFroms.setQualifiedSuppliers_id(id);
	 * drugFroms.setDrugFormDictionary_id(drugFrom.getId());
	 * drugFroms.setDrugFormDictionary(drugFrom);
	 * drugFroms.setDrugFormDate(modifyDate);
	 * 
	 * drugFromsList.add(drugFroms); businessScope += drugFrom.getFormName() +
	 * ","; } }
	 * 
	 * qualifiedSupply.setBusinessScope(businessScope);
	 * qualSupplyDrugFromsService.saveList(drugFromsList);
	 * qualifiedSuppliesService.save(qualifiedSupply);
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
	 * UtilJson.printMapJson(response, map); return null; }
	 */
	@RequestMapping("/firstEnterprise/query_hggysxgjl.html")
	public ModelAndView queryQulSuppArchiesList(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<QualifiedSupplierArchives> archivesList = new ArrayList<QualifiedSupplierArchives>();
		String page = DisplayGetPage.getPageParamName("archives", request);
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !"".equals(p_id)) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		if (page == null) {
			archivesList = qualSuppArchivesService.getQualifiedSuppliersByPage(id, 0, Constants.pagesize);
		} else {
			archivesList = qualSuppArchivesService.getQualifiedSuppliersByPage(id,
					(Integer.parseInt(page) - 1) * Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_qualifiedSupplier_archives where supplier_id=" + id;
		int resultSize = qualSuppArchivesService.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size / Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		return new ModelAndView("/QYZZ/HGGYS/hggysxgjl", "archivesList", archivesList);
	}

	@RequestMapping("/firstEnterprise/update_hggys.html")
	public String updataQualifiedSupply(FirstEnterpriseAccessoryVO accessoryList, Model model,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");// 客户ID
		String customerNumber = request.getParameter("customerNumber");// 客户ID
		String customerName = request.getParameter("customerName");// 客户名称
		String busiLiceExpiDate = request.getParameter("busiLiceExpiDate");// 营业执照到期时间
		String busiLIceAnnuSurvey = request.getParameter("busiLIceAnnuSurvey");// 营业执照年检时间
		String liceExpiDate = request.getParameter("liceExpiDate");// 许可证到期日期
		String gspExpirDate = request.getParameter("gspExpirDate");// GSP截止日期
		// String littCredentDate =
		// request.getParameter("littCredentDate");//认证证书到期日期
		// String accountDate = request.getParameter("accountDate");//开户信息到期日期
		String tenBitCode = request.getParameter("tenBitCode");// 十位码
		String email = request.getParameter("email");// Email地址
		String pinyinCode = request.getParameter("pinyinCode");// 拼音码
		String postalCode = request.getParameter("postalCode");// 邮编
		String phone = request.getParameter("phone");// 电话
		String portraiture = request.getParameter("portraiture");// 传真
		String corporation = request.getParameter("corporation");// 法人
		String taxRegisNo = request.getParameter("taxRegisNo");// 纳税人登记证
		String bankName = request.getParameter("bankName");// 开户银行
		String bankNumber = request.getParameter("bankNumber");// 开户银行账户
		String bankUserName = request.getParameter("bankUserName");
		String businessScope = request.getParameter("businessScope");// 经营范围
		String sales_deputy = request.getParameter("sales_deputy");// 销售代表
		SalesStaff salesStaff = salesService.get(Long.valueOf(sales_deputy));
		String deliveryPersonnel = request.getParameter("deliveryPersonnel");// 提货人员
		String organizationCodeDate = request.getParameter("organizationCodeDate");// 组织机构代码到期时间期
		String organizationCodeInspectionDate = request.getParameter("organizationCodeInspectionDate");// 组织机构代码年检日期
		String qualityAssuranceDate = request.getParameter("qualityAssuranceDate");// 质量保证协议到期日期
		String authorizationDate = request.getParameter("authorizationDate");
		String remark = request.getParameter("remark");
		String reason = request.getParameter("reason");
		String useFalg = request.getParameter("useFlag");// 停用标识
		User user = (User) request.getSession().getAttribute(Constants.LOCAL_USER);
		MultipartHttpServletRequest muliRequest = (MultipartHttpServletRequest) request;
		Long p_Id = null;
		if (isNull(id)) {
			p_Id = Long.valueOf(id);
		} else {
			p_Id = Long.valueOf(0);
		}

		QualifiedSuppliers qualifiedSuppliers = qualifiedSuppliesService.get(p_Id);
		List<QualifiedSupplierArchives> archivesList = new ArrayList<QualifiedSupplierArchives>();
		if (isNull(authorizationDate)) {
			if (!isQuals(authorizationDate, qualifiedSuppliers.getAuthorizationDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改法人委托书到期时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改法人委托书到期时间，修改前值为："
						+ qualifiedSuppliers.getAuthorizationDate() + "修改后值为：" + authorizationDate);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setAuthorizationDate(authorizationDate);
		}
		if (isNull(organizationCodeDate)) {
			if (!isQuals(organizationCodeDate, qualifiedSuppliers.getOrganizationCodeDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改组织机构代码到期时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改组织机构代码到期时间，修改前值为："
						+ qualifiedSuppliers.getOrganizationCodeDate() + "修改后值为：" + organizationCodeDate);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setOrganizationCodeDate(organizationCodeDate);
		}
		if (isNull(organizationCodeInspectionDate)) {
			if (!isQuals(organizationCodeInspectionDate, qualifiedSuppliers.getOrganizationCodeInspectionDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改组织机构代码年检时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改组织机构代码年检时间，修改前值为：" + qualifiedSuppliers.getOrganizationCodeInspectionDate()
								+ "修改后值为：" + organizationCodeInspectionDate);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setOrganizationCodeInspectionDate(organizationCodeInspectionDate);
		}
		if (isNull(qualityAssuranceDate)) {
			if (!isQuals(organizationCodeInspectionDate, qualifiedSuppliers.getOrganizationCodeInspectionDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改质量保证书到期时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改质量保证书到期时间，修改前值为："
						+ qualifiedSuppliers.getQualityAssuranceDate() + "修改后值为：" + qualityAssuranceDate);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setQualityAssuranceDate(qualityAssuranceDate);
		}
		if (isNull(sales_deputy)) {
			if (qualifiedSuppliers.getSales_deputy() != null
					&& !isQuals(salesStaff.getSaleName(), qualifiedSuppliers.getSales_deputy().getSaleName())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改销售代表");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改销售代表，修改前值为："
						+ qualifiedSuppliers.getSales_deputy().getSaleName() + "修改后值为：" + salesStaff.getSaleName());
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setSales_deputy(salesStaff);
		}
		if (isNull(deliveryPersonnel)) {
			if (!isQuals(deliveryPersonnel, qualifiedSuppliers.getDeliveryPersonnel())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改提货人员");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改提货人员，修改前值为：" + qualifiedSuppliers.getDeliveryPersonnel() + "修改后值为：" + deliveryPersonnel);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setDeliveryPersonnel(deliveryPersonnel);
		}

		if (isNull(customerNumber)) {
			if (!isQuals(customerNumber, qualifiedSuppliers.getCustomerNumber())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改编号");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改编号，修改前值为：" + qualifiedSuppliers.getCustomerNumber() + "修改后值为：" + customerName);
				qualifiedSupplierArchives.setReason(reason);

				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setCustomerNumber(customerNumber);
		}
		if (isNull(customerName)) {
			if (!isQuals(customerName, qualifiedSuppliers.getCustomerName())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改客户名称");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改客户名称，修改前值为：" + qualifiedSuppliers.getCustomerName() + "修改后值为：" + customerNumber);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setCustomerName(customerName);
		}
		if (isNull(busiLiceExpiDate)) {
			if (!isQuals(busiLiceExpiDate, qualifiedSuppliers.getBusiLiceExpiDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改营业执照到期时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改营业执照到期时间，修改前值为：" + qualifiedSuppliers.getBusiLiceExpiDate() + "修改后值为：" + busiLiceExpiDate);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);

			}
			qualifiedSuppliers.setBusiLiceExpiDate(busiLiceExpiDate);
		}
		if (isNull(busiLIceAnnuSurvey)) {
			if (!isQuals(busiLIceAnnuSurvey, qualifiedSuppliers.getBusiLIceAnnuSurvey())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改营业执照年检时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改营业执照到期时间，修改前值为："
						+ qualifiedSuppliers.getBusiLIceAnnuSurvey() + "修改后值为：" + busiLIceAnnuSurvey);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setBusiLIceAnnuSurvey(busiLIceAnnuSurvey);
		}
		if (isNull(liceExpiDate)) {
			if (!isQuals(liceExpiDate, qualifiedSuppliers.getLiceExpiDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改经营许可证到期时间");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改经营许可证到期时间，修改前值为：" + qualifiedSuppliers.getLiceExpiDate() + "修改后值为：" + liceExpiDate);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setLiceExpiDate(liceExpiDate);
		}
		if (isNull(gspExpirDate)) {
			if (!isQuals(gspExpirDate, qualifiedSuppliers.getGspExpirDate())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改GSP截止日期");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改GSP截止日期，修改前值为：" + qualifiedSuppliers.getGspExpirDate() + "修改后值为：" + gspExpirDate);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setGspExpirDate(gspExpirDate);
		}
		/*
		 * if(isNull(littCredentDate)){ if(!isQuals(littCredentDate,
		 * qualifiedSuppliers.getLittCredentDate())){ QualifiedSupplierArchives
		 * qualifiedSupplierArchives = new QualifiedSupplierArchives();
		 * qualifiedSupplierArchives.setModifierId(user);
		 * qualifiedSupplierArchives.setProjectName("修改认证证书到期日期");
		 * qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
		 * qualifiedSupplierArchives.setModifiedTime(new Date());
		 * qualifiedSupplierArchives.setChangeContent("修改认证证书到期日期，修改前值为："+
		 * qualifiedSuppliers.getLittCredentDate()+"修改后值为："+littCredentDate);
		 * archivesList.add(qualifiedSupplierArchives); }
		 * qualifiedSuppliers.setLittCredentDate(littCredentDate); }
		 * if(isNull(accountDate)){ if(!isQuals(accountDate,
		 * qualifiedSuppliers.getAccountDate())){ QualifiedSupplierArchives
		 * qualifiedSupplierArchives = new QualifiedSupplierArchives();
		 * qualifiedSupplierArchives.setModifierId(user);
		 * qualifiedSupplierArchives.setProjectName("修改许开户信息到期日期");
		 * qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
		 * qualifiedSupplierArchives.setModifiedTime(new Date());
		 * qualifiedSupplierArchives.setChangeContent("修改开户信息到期日期，修改前值为："+
		 * qualifiedSuppliers.getAccountDate()+"修改后值为："+accountDate);
		 * archivesList.add(qualifiedSupplierArchives); }
		 * qualifiedSuppliers.setAccountDate(littCredentDate); }
		 */
		// String tenBitCode = request.getParameter("tenBitCode");//十位码
		if (isNull(tenBitCode)) {
			if (!isQuals(tenBitCode, qualifiedSuppliers.getTenBitCode())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改十位码");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改十位码，修改前值为：" + qualifiedSuppliers.getTenBitCode() + "修改后值为：" + tenBitCode);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setTenBitCode(tenBitCode);
		}
		// String email = request.getParameter("email");//Email地址
		if (isNull(email)) {
			if (!isQuals(email, qualifiedSuppliers.getEmail())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改Email地址");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改Email地址，修改前值为：" + qualifiedSuppliers.getEmail() + "修改后值为：" + email);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setEmail(email);
		}
		// String pinyinCode = request.getParameter("pinyinCode");//拼音码
		if (isNull(pinyinCode)) {
			if (!isQuals(pinyinCode, qualifiedSuppliers.getPinyinCode())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改拼音码");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改拼音码，修改前值为：" + qualifiedSuppliers.getPinyinCode() + "修改后值为：" + pinyinCode);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setPinyinCode(pinyinCode);
		}
		// String postalCode = request.getParameter("postalCode");//邮编
		if (isNull(postalCode)) {
			if (!isQuals(postalCode, qualifiedSuppliers.getPostalCode())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改邮编");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改邮编，修改前值为：" + qualifiedSuppliers.getPinyinCode() + "修改后值为：" + postalCode);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setPostalCode(postalCode);
		}
		// String phone = request.getParameter("phone");//电话
		if (isNull(phone)) {
			if (!isQuals(phone, qualifiedSuppliers.getPhone())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改电话");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改电话，修改前值为：" + qualifiedSuppliers.getPhone() + "修改后值为：" + phone);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setPhone(phone);
		}
		// String portraiture = request.getParameter("portraiture");//传真
		if (isNull(portraiture)) {
			if (!isQuals(portraiture, qualifiedSuppliers.getPortraiture())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改传真");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改传真，修改前值为：" + qualifiedSuppliers.getPortraiture() + "修改后值为：" + portraiture);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setPortraiture(portraiture);
		}
		// String corporation = request.getParameter("corporation");//法人
		if (isNull(corporation)) {
			if (!isQuals(corporation, qualifiedSuppliers.getCorporation())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改/法人");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改/法人，修改前值为：" + qualifiedSuppliers.getCorporation() + "修改后值为：" + corporation);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setCorporation(corporation);
		}
		// String taxRegisNo = request.getParameter("certificate_No");//纳税人登记证
		if (isNull(taxRegisNo)) {
			if (!isQuals(taxRegisNo, qualifiedSuppliers.getTaxRegisNo())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改纳税人登记证");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改纳税人登记证，修改前值为：" + qualifiedSuppliers.getTaxRegisNo() + "修改后值为：" + taxRegisNo);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setTaxRegisNo(taxRegisNo);
		}
		// String bankName = request.getParameter("bankName");//开户银行
		if (isNull(bankName)) {
			if (!isQuals(bankName, qualifiedSuppliers.getBankName())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改开户银行");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改开户银行，修改前值为：" + qualifiedSuppliers.getBankName() + "修改后值为：" + bankName);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setBankName(bankName);
		}
		// String bankNumber = request.getParameter("bankNumber");//开户银行账户
		if (isNull(bankNumber)) {
			if (!isQuals(bankNumber, qualifiedSuppliers.getBankNumber())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改开户银行账户");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改开户银行账户，修改前值为：" + qualifiedSuppliers.getBankName() + "修改后值为：" + bankNumber);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setBankNumber(bankNumber);
		}
		if (isNull(bankUserName)) {
			if (!isQuals(bankUserName, qualifiedSuppliers.getBankUserName())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改开户户名");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改开户户名，修改前值为：" + qualifiedSuppliers.getBankUserName() + "修改后值为：" + bankUserName);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setBankUserName(bankUserName);
		}
		// String businessScope = request.getParameter("businessScope");//经营范围
		if (isNull(businessScope)) {
			if (!isQuals(businessScope, qualifiedSuppliers.getBusinessScope())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改经营范围");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent(
						"修改经营范围，修改前值为：" + qualifiedSuppliers.getBusinessScope() + "修改后值为：" + businessScope);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setBusinessScope(businessScope);
		}
		if (isNull(remark)) {
			if (!isQuals(remark, qualifiedSuppliers.getRemark())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("修改备注");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives
						.setChangeContent("修改备注，修改前值为：" + qualifiedSuppliers.getRemark() + "修改后值为：" + remark);
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setRemark(remark);
		}
		if (isNull(useFalg)) {
			if (!isQuals(useFalg, qualifiedSuppliers.getUseFlag())) {
				QualifiedSupplierArchives qualifiedSupplierArchives = new QualifiedSupplierArchives();
				qualifiedSupplierArchives.setModifierId(user);
				qualifiedSupplierArchives.setProjectName("停用标识");
				qualifiedSupplierArchives.setSupplierId(qualifiedSuppliers.getId());
				qualifiedSupplierArchives.setModifiedTime(new Date());
				qualifiedSupplierArchives.setChangeContent("修改停用标识，修改前值为："
						+ getUserFlagValue(qualifiedSuppliers.getUseFlag()) + "修改后值为：" + getUserFlagValue(useFalg));
				qualifiedSupplierArchives.setReason(reason);
				archivesList.add(qualifiedSupplierArchives);
			}
			qualifiedSuppliers.setUseFlag(useFalg);
		}

		batchUpload(muliRequest, accessoryList, qualifiedSuppliers);
		Set<QulifiedSupplyAccessory> set = new HashSet<QulifiedSupplyAccessory>();
		if (accessoryList.getQualifiedAccessoryLst() != null) {
			set.addAll(accessoryList.getQualifiedAccessoryLst());
		}
		Set<QulifiedSupplyDrugFroms> dSet = new HashSet<QulifiedSupplyDrugFroms>();
		if (accessoryList.getQulifiedSupplyDrugFromsList() != null) {
			for (QulifiedSupplyDrugFroms dItem : accessoryList.getQulifiedSupplyDrugFromsList()) {
				dItem.setDrugFormDictionary(drugFormDictionaryService.get(dItem.getDrugFormDictionary_id()));
			}
			dSet.addAll(accessoryList.getQulifiedSupplyDrugFromsList());
		}
		qualifiedSuppliers.setDrugFroms(dSet);
		qualifiedSuppliers.setAccessories(set);
		qualifiedSuppliesService.saveOrUpdate(qualifiedSuppliers);
		qualSuppArchivesService.saveList(archivesList);
		logService.addLog("修改合格供货单位", user.getRealname(), "修改", "企业资质管理  > 合格供货单位", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("数据保存成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/firstEnterprise/ajaxQueryQualifiedSuppliers.html")
	public List<QualifiedSuppliers> ajaxQueryQualifiedSuppliers(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		List<QualifiedSuppliers> qualifiedSuppliersList = new ArrayList<QualifiedSuppliers>();
		String hql = "from QualifiedSuppliers a where a.deleteFlag=0 ";
		qualifiedSuppliersList = qualifiedSuppliesService.findList(hql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qualSuppList", qualifiedSuppliersList);
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/firstEnterprise/ajaxQueryWarnSuppliers.html")
	public String ajaxQuerWarn(Model model, HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'gys%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer("from QualifiedSuppliers a where 1=1 and  a.deleteFlag=0");
		StringBuffer subjecBuffer = new StringBuffer();
		String yinyezhizhao = "";// 营业执照日期
		// String yingyezhizhaonianjian = "";//营业执照年检
		String xukezheng = "";// 经营许可证
		String gspdaoqi = "";// GS到期日期
		String zuzhijigoudama = "";// 组织机构代码
		String zuzhijigoudaimanianjian = "";// 组织机构代码年检
		String zhiliangbaozhengxiyi = "";// 质量保证协议
		String weitoushouqushu = "";// 委托授权书
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils
					.formCurrentDate(DateTimeUtils.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("gys_businessLicense_ExpirationDate")) {
				subjecBuffer.append("or a.busiLiceExpiDate<='" + startDate + "'  ");
				yinyezhizhao = startDate;
			} /*
				 * else
				 * if(limit_name.equals("gys_businessLicense_annualSurvey")){
				 * subjecBuffer.append("or a.busiLIceAnnuSurvey<='"
				 * +startDate+"'  "); yingyezhizhaonianjian= startDate; }
				 */else if (limit_name.equals("gys_licence_ExpirationDate")) {
				subjecBuffer.append("or a.liceExpiDate<='" + startDate + "'");
				xukezheng = startDate;
			} else if (limit_name.equals("gys_GPS_ExpirationDate")) {
				subjecBuffer.append("or a.gspExpirDate<='" + startDate + "' ");
				gspdaoqi = startDate;
			} else if (limit_name.equals("gys_organizationCodeDate")) {
				subjecBuffer.append("or a.organizationCodeDate<='" + startDate + "'  ");
				zuzhijigoudama = startDate;
			} else if (limit_name.equals("gys_organizationCodeInspectionDate")) {
				subjecBuffer.append("or a.organizationCodeInspectionDate<='" + startDate + "'  ");
				zuzhijigoudaimanianjian = startDate;
			} else if (limit_name.equals("gys_qualityAssuranceDate")) {
				subjecBuffer.append("or a.qualityAssuranceDate<='" + startDate + "'  ");
				zhiliangbaozhengxiyi = startDate;
			} else if (limit_name.equals("gys_authorizationDate")) {
				subjecBuffer.append("or a.authorizationDate<='" + startDate + "'  ");
				weitoushouqushu = startDate;
			}
		}
		String subjectStr = subjecBuffer.toString();
		if (!subjectStr.trim().equals("")) {
			String str = subjectStr.substring(2);
			hqlBuffer.append(" and ( ");
			hqlBuffer.append(str);
			hqlBuffer.append(" )");
		}
		List<QualifiedSuppliers> supplyList = qualifiedSuppliesService.findList(hqlBuffer.toString());

		for (QualifiedSuppliers supply : supplyList) {
			// String companyName = supply.getCustomerName();
			String yyzz = supply.getBusiLiceExpiDate();// 营业执照到期时间期
			// String yyzznj = supply.getBusiLIceAnnuSurvey();//营业执照年检时间
			String xyz = supply.getLiceExpiDate();// 许可证到期日期
			String gsp = gspWarningDate(supply.getAccessories());// GSP截止日期
			String zzjgdm = supply.getOrganizationCodeDate();// 组织机构代码
			String zzjgdmnj = supply.getOrganizationCodeInspectionDate();// 组织机构代码年检
			String zlbzxy = supply.getQualityAssuranceDate();// 质量保证协议
			String sqwts = supply.getAuthorizationDate();// 法人委托书
			Set<QulifiedSupplyAccessory> accessorySet = supply.getAccessories();

			if (supply.getDeleteFlag().equals("0")) {
				if (yinyezhizhao != "" && yyzz != null && DateTimeUtils.compareTwoDate(yinyezhizhao, yyzz) >= 0) {

					int days = DateTimeUtils.compareDateInterval(yyzz, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "营业执照还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "营业执照已过期<font>" + Math.abs(days) + "</font>天</a>");
					}
				}
				/*
				 * if(yingyezhizhaonianjian!="" && yyzznj!=null &&
				 * DateTimeUtils.compareTwoDate(yingyezhizhaonianjian,
				 * yyzznj)>=0){
				 * 
				 * int days = DateTimeUtils.compareDateInterval(yyzznj,
				 * nowdate); if(days>=0){
				 * buffer.append("&nbsp;<a href='view_hggys.html?id="+supply.
				 * getId()+"' traget='_blank'>");
				 * buffer.append(""+supply.getCustomerName()+"营业执照年检还有<font>"+
				 * days+"</font>天 到期</a>"); }else{
				 * buffer.append("&nbsp;<a href='view_hggys.html?id="+supply.
				 * getId()+"' traget='_blank'>");
				 * buffer.append(""+supply.getCustomerName()+"营业执照年检已过期<font>"+
				 * Math.abs(days)+"</font>天</a>"); }
				 * 
				 * }
				 */
				if (xukezheng != "" && xyz != null && DateTimeUtils.compareTwoDate(xukezheng, xyz) >= 0) {
					int days = DateTimeUtils.compareDateInterval(xyz, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "经营/生产许可证还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "经营/生产许可证已过期<font>" + Math.abs(days) + "</font>天 </a>");
					}
				}
				if (gspdaoqi != "" && gsp != null && !"".equals(gsp)
						&& DateTimeUtils.compareTwoDate(gspdaoqi, gsp) >= 0) {
					int days = DateTimeUtils.compareDateInterval(gsp, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "GSP/GMP认证还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "GSP/GMP认证已过期<font>" + Math.abs(days) + "</font>天</a>");
					}
				}
				if (zuzhijigoudama != "" && zzjgdm != null
						&& DateTimeUtils.compareTwoDate(zuzhijigoudama, zzjgdm) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zzjgdm, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "组织机构代码还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "组织机构代码已过期<font>" + Math.abs(days) + "</font>天</a>");
					}

				}
				if (zuzhijigoudaimanianjian != "" && zzjgdmnj != null
						&& DateTimeUtils.compareTwoDate(zuzhijigoudaimanianjian, zzjgdmnj) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zzjgdmnj, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "组织机构代码年检还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "组织机构代码年检已过期<font>" + Math.abs(days) + "</font>天</a>");
					}
				}
				if (zhiliangbaozhengxiyi != "" && zlbzxy != null
						&& DateTimeUtils.compareTwoDate(zhiliangbaozhengxiyi, zlbzxy) >= 0) {
					int days = DateTimeUtils.compareDateInterval(zlbzxy, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "质量保证协议书还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "质量保证协议书已过期<font>" + Math.abs(days) + "</font>天</a>");
					}
				}
				if (weitoushouqushu != "" && sqwts != null
						&& DateTimeUtils.compareTwoDate(weitoushouqushu, sqwts) >= 0) {
					int days = DateTimeUtils.compareDateInterval(sqwts, nowdate);
					if (days >= 0) {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append("" + supply.getCustomerName() + "法人委托书还有<font>" + days + "</font>天 到期</a>");
					} else {
						buffer.append("&nbsp;<a href='view_hggys.html?id=" + supply.getId() + "' traget='_blank'>");
						buffer.append(
								"" + supply.getCustomerName() + "法人委托书已过期<font>" + Math.abs(days) + "</font>天</a>");
					}
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/firstEnterprise/confirmReject.html")
	public String confirmReject(Model model, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String p_id = request.getParameter("id");
		Long id = null;
		if (isNull(p_id)) {
			id = new Long(p_id);
		} else {
			id = Long.valueOf(0);
		}
		QualifiedSuppliers qSuppliers = qualifiedSuppliesService.findByFirstEnterpriseId(id);
		qSuppliers.setDeleteFlag("1");
		FirstEnterprise firstEnterprise = firstEnterpriseService.get(qSuppliers.getFirstEnterpriseId());
		firstEnterprise.setReview_status(3);
		firstEnterpriseService.saveOrUpdate(firstEnterprise);
		qualifiedSuppliesService.saveOrUpdate(qSuppliers);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("驳回合格供应商成功！", "UTF-8"));
		UtilJson.printMapJson(response, map);
		return null;
	}

	/**
	 * 获取资质未过期的供货单位
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/firstEnterprise/qualitySupplyJson.html")
	public void findQulitySupplyJson(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<QualifiedSuppliers> list = null;
		String hql = "select a from QualifiedSuppliers a where a.deleteFlag=0 and a.useFlag= 0 order by a.customerName";
		list = qualifiedSuppliesService.findList(hql);
		// 封装采购单json

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				QualifiedSuppliers supply = list.get(i);

				String yyzz = supply.getBusiLiceExpiDate();// 营业执照到期时间期
				String xyz = supply.getLiceExpiDate();// 许可证到期日期
				String gsp = supply.getGspExpirDate();// GSP截止日期
				String zzjgdm = supply.getOrganizationCodeDate();// 组织机构代码
				String zzjgdmnj = supply.getOrganizationCodeInspectionDate();// 组织机构代码年检
				String zlbzxy = supply.getQualityAssuranceDate();// 质量保证协议
				String sqwts = supply.getAuthorizationDate();// 法人委托书

				String now = DateTimeUtils.getNowStrDate();
				if (yyzz != null && yyzz != "" && !"".equals(yyzz) && DateTimeUtils.compareTwoDate(yyzz, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (xyz != null && xyz != "" && !"".equals(xyz) && DateTimeUtils.compareTwoDate(xyz, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (gsp != null && gsp != "" && !"".equals(gsp) && DateTimeUtils.compareTwoDate(gsp, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (zzjgdm != null && zzjgdm != "" && !"".equals(zzjgdm)
						&& DateTimeUtils.compareTwoDate(zzjgdm, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (zzjgdmnj != null && zzjgdmnj != "" && !"".equals(zzjgdmnj)
						&& DateTimeUtils.compareTwoDate(zzjgdmnj, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (zlbzxy != null && zlbzxy != "" && !"".equals(zlbzxy)
						&& DateTimeUtils.compareTwoDate(zlbzxy, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
				if (sqwts != null && sqwts != "" && !"".equals(sqwts) && DateTimeUtils.compareTwoDate(sqwts, now) < 0) {
					list.remove(i);
					i--;
					continue;
				}
			}
		}

		String json = "[";
		int index = 0;
		if (list != null && list.size() > 0) {
			for (QualifiedSuppliers supply : list) {
				index++;
				json += "{";
				json += "\"id\":\"" + supply.getPinyinCode() + "_" + supply.getId() + "\",";
				json += "\"text\":\"" + supply.getCustomerName() + "\",";
				json += "\"disbale\":\"" + supply.getUseFlag() + "\"";
				if (index == list.size()) {
					json += "}";
				} else {
					json += "},";
				}
			}
		}
		json += "]";
		response.setContentType("text/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isNull(String str) {

		return str != null && !"".equals(str.trim());
	}

	private boolean isQuals(String str1, String str2) {
		if (str2 == null)
			return false;
		return str1.trim().equals(str2.trim());
	}

	public void batchUpload(MultipartHttpServletRequest request, FirstEnterpriseAccessoryVO firstAccessory,
			QualifiedSuppliers supplier) {
		// response.setCharacterEncoding("utf-8");
		Map<String, MultipartFile> filesMap = request.getFileMap();
		String serverRealPath = request.getSession().getServletContext().getRealPath("/");// 获取服务器绝对路径
		String fileSavePath = serverRealPath + Constants.UPLOAD_PATH;// 上传文件存储的绝对路径
		String fileTempPath = serverRealPath + Constants.TEMPPATH;// 上传文件在服务器临时存储的的绝对路径
		new File(fileSavePath).mkdirs();
		// String tempPath = request.getServletPath();
		// int sizeThreshold = Integer.valueOf(Constants.SIZETHRESHOLD);//缓冲区的大小
		// int fileMaxSize = Integer.valueOf(Constants.SIZEMAX);//上传文件的最大限制
		try {
			File tempPathFile = new File(fileTempPath);
			if (!tempPathFile.exists()) {
				tempPathFile.mkdirs();
			}
			// DiskFileItemFactory factory = new DiskFileItemFactory();
			// factory.setRepository(tempPathFile);
			// factory.setSizeThreshold(sizeThreshold);
			// ServletFileUpload upload = new ServletFileUpload(factory);
			// List<FileItem> items = upload.parseRequest(request);
			Iterator<String> its = filesMap.keySet().iterator();
			Set<FirstEnterpriseAccessory> set = new HashSet<FirstEnterpriseAccessory>();
			List<QulifiedSupplyAccessory> firstAccessoryList = firstAccessory.getQualifiedAccessoryLst();
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
					savaFile.createNewFile();
				}

				if (requestName.equals("business_licence_path")) {// 营业执照
					supplier.setBusiness_licence_path(relativeSavePath);
				} else if (requestName.equals("licence_path")) {// 经营许可证
					supplier.setLicence_path(relativeSavePath);
				} else if (requestName.equals("business_licence_inspection_path")) {// 营业执照年检
					supplier.setBusiness_licence_inspection_path(relativeSavePath);
				} else if (requestName.equals("gsp_certificate_path")) {// GSP
					supplier.setGsp_certificate_path(relativeSavePath);
				} else if (requestName.equals("organization_code_path")) {// 组织机构
					supplier.setOrganization_code_path(relativeSavePath);
				} else if (requestName.equals("organization_code_inspection_path")) {// 组织机构年检
					supplier.setOrganization_code_inspection_path(relativeSavePath);
				} else if (requestName.equals("quality_assurance_path")) {// 质量保证协议
					supplier.setQuality_assurance_path(relativeSavePath);
				} else if (requestName.equals("authorization_path")) {
					supplier.setAuthorization_path(relativeSavePath);
				} else if (requestName.contains("request_name")) {
					for (QulifiedSupplyAccessory accessory : firstAccessoryList) {
						String accessName = accessory.getRequest_name();
						if (requestName.equals(accessName)) {
							accessory.setAccessoryPath(relativeSavePath);
							// set.add(accessory);
						}

					}
				} else {
					for (QulifiedSupplyAccessory accessory : firstAccessoryList) {
						String accsoryPath = accessory.getAccessoryPath();
						if (accsoryPath != null && !"".equals(accsoryPath)) {
							// set.add(accessory);
						}

					}

				}

				uploadFile.transferTo(savaFile);
				// String relativeSavePathSmail =
				// baseDir+fileName+"_01."+fileNameExtension;//用户保存到数据库的相对文件路径及名称
				// relativeSavePathSmail = relativeSavePathSmail.substring(1);
				// File savaFile = new
				// File(saveRealPath+fileName+"."+fileNameExtension);
			}
			// firstEnterprise.setAccessories(set);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String gspWarningDate(Set<QulifiedSupplyAccessory> accessorySet) {
		String gspWarningDate = "";
		List<String> list = new ArrayList<String>();
		if (accessorySet != null && accessorySet.size() > 0) {
			Iterator<QulifiedSupplyAccessory> iterator = accessorySet.iterator();
			while (iterator.hasNext()) {
				String date = iterator.next().getAccessoryDate();
				if (date != null && !"".equals(date) && !"null".equalsIgnoreCase(date)) {
					list.add(date);
				}
			}
			Collections.sort(list);
			if (list.size() > 0)
				gspWarningDate = list.get(0);
		}
		return gspWarningDate;
	}

	@RequestMapping("/firstEnterprise/qualifiedSupplierFile.html")
	public ModelAndView deleteFile(Model mode, HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type = request.getParameter("type");
		String ctxPath = request.getSession().getServletContext().getRealPath("/");
		String filePath = ctxPath + fileName;
		if (type != null && !type.trim().equals("")) {
			QualifiedSuppliers suppliers = qualifiedSuppliesService.get(Long.valueOf(id));
			if (type.equals("yyzz")) {
				suppliers.setBusiness_licence_path("");
			} else if (type.equals("xkz")) {
				suppliers.setLicence_path("");
			} else if (type.equals("yyzznj")) {
				suppliers.setBusiness_licence_inspection_path("");
			} else if (type.equals("gsp")) {
				suppliers.setGsp_certificate_path("");
			} else if (type.equals("zzjgdm")) {
				suppliers.setOrganization_code_path("");
			} else if (type.equals("zzjgdmnj")) {
				suppliers.setOrganization_code_inspection_path("");
			} else if (type.equals("zbxy")) {
				suppliers.setQuality_assurance_path("");
			} else if (type.equals("wtsqs")) {
				suppliers.setAuthorization_path("");
			}
			qualifiedSuppliesService.saveOrUpdate(suppliers);
		} else {
			QulifiedSupplyAccessory accessory = qualifiedSuppliesService.findQulifiedSupplyAccessoryById(id);
			accessory.setAccessoryPath("");
			qualifiedSuppliesService.saveQulifiedSupplyAccessory(accessory);
		}

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

	/**
	 * 将资质过期的合格供货单位设置为暂时停用
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/firstEnterprise/checkQqualitySupply.html")
	public void checkQulitySupply(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<QualifiedSuppliers> list = null;
		String hql = "select a from QualifiedSuppliers a where a.deleteFlag=0 order by a.customerName";
		list = qualifiedSuppliesService.findList(hql);
		// 封装采购单json

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				QualifiedSuppliers supply = list.get(i);

				String yyzz = supply.getBusiLiceExpiDate();// 营业执照到期时间期
				String xyz = supply.getLiceExpiDate();// 许可证到期日期
				String gsp = supply.getGspExpirDate();// GSP截止日期
				String zzjgdm = supply.getOrganizationCodeDate();// 组织机构代码
				String zzjgdmnj = supply.getOrganizationCodeInspectionDate();// 组织机构代码年检
				String zlbzxy = supply.getQualityAssuranceDate();// 质量保证协议
				String sqwts = supply.getAuthorizationDate();// 法人委托书

				String now = DateTimeUtils.getNowStrDate();
				if (yyzz != null && yyzz != "" && !"".equals(yyzz) && DateTimeUtils.compareTwoDate(yyzz, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (xyz != null && xyz != "" && !"".equals(xyz) && DateTimeUtils.compareTwoDate(xyz, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (gsp != null && gsp != "" && !"".equals(gsp) && DateTimeUtils.compareTwoDate(gsp, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (zzjgdm != null && zzjgdm != "" && !"".equals(zzjgdm)
						&& DateTimeUtils.compareTwoDate(zzjgdm, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (zzjgdmnj != null && zzjgdmnj != "" && !"".equals(zzjgdmnj)
						&& DateTimeUtils.compareTwoDate(zzjgdmnj, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (zlbzxy != null && zlbzxy != "" && !"".equals(zlbzxy)
						&& DateTimeUtils.compareTwoDate(zlbzxy, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
				if (sqwts != null && sqwts != "" && !"".equals(sqwts) && DateTimeUtils.compareTwoDate(sqwts, now) < 0) {
					supply.setUseFlag("2");
					qualifiedSuppliesService.saveOrUpdate(supply);
					continue;
				}
			}
		}

	}

}
