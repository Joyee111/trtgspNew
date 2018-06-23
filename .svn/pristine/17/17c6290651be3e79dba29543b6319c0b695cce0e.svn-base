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
import com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;
import com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicineRecords;
import com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.FirstVarietyService;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineRecordsService;

/**
 * @author lfl:
 * @version 创建时间：Jun 7, 2013 2:24:01 PM 类说明 合格药品action
 */
@Controller
public class QualifiedMedicinalAction extends BaseFormController {
	@Autowired
	private QualityMidicineMng service;
	@Autowired
	private QualifiedSuppliersService supplyService;
	@Autowired
	private DrugFormDictionaryService formService;
	@Autowired
	private QualityMidicineRecordsService recordsService;
	@Autowired
	private WarnConfigService configService;
	@Autowired
	private FirstVarietyService firstVarietyService;
	@Autowired
	private SystemLogService logService;

	@RequestMapping("/drugVarieties/qulidiedMedicinal.html")
	public ModelAndView getQualifiedMidicinesList(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		List<QualityMidicine> qualityMidicinesList = new ArrayList<QualityMidicine>();
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String hql = "from QualityMidicine a where a.departmentId is not null  order by a.id DESC";
		if (page == null) {
			qualityMidicinesList = service.getListByPage(hql, new HashMap(), 0,
					Constants.pagesize);
		} else {
			qualityMidicinesList = service.getListByPage(hql, new HashMap(),
					(Integer.parseInt(page) - 1) * Constants.pagesize,
					Constants.pagesize);
		}
		// 获取总条数
		String sql = "select count(*) from t_qualified_medicine  where dp_id is not null";
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", qualityMidicinesList);
	}
@RequestMapping("/drugVarieties/allQulidiedMedicinal.html")
	public ModelAndView getAllQualifiedMidicinesList(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		List<QualityMidicine> qualityMidicinesList = new ArrayList<QualityMidicine>();
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String hql = "from QualityMidicine a  order by a.id DESC";
			qualityMidicinesList = service.getAllByState(hql,new HashMap<String, Object>());
		
		// 获取总条数
		String sql = "select count(*) from t_qualified_medicine  ";
		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", qualityMidicinesList);
	}

	@RequestMapping("/drugVarieties/queryQulidiedMedicinal.html")
	public ModelAndView queryQualifiedMidicinesList(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		List<QualityMidicine> qualityMidicinesList = new ArrayList<QualityMidicine>();
		String query_commonname = request.getParameter("query_commonname");// 通用名称
		String query_forms = request.getParameter("query_forms");// 剂型
		String query_number = request.getParameter("query_number");//货号
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		StringBuffer hqlBuffer = new StringBuffer(
				"select a from QualityMidicine a  inner join fetch a.dosageforms  where 1=1  and a.departmentId is not null");
		StringBuffer sqlBuffer = new StringBuffer(
				"select count(*) from  t_qualified_medicine q join t_dosage_form d on q.dosageforms_id=d.id where 1=1 and q.dp_id is not null");
		if (query_commonname != null && !"".equals(query_commonname.trim())) {
			hqlBuffer.append(" and a.commonname like'%"
					+ query_commonname.trim() + "%'");
			sqlBuffer.append(" and q.common_name like'%"
					+ query_commonname.trim() + "%'");
		}
		if (query_forms != null && !"".equals(query_forms.trim())) {
			hqlBuffer.append(" and a.dosageforms.formName like'%"
					+ query_forms.trim() + "%'");
			sqlBuffer.append(" and d.form_name like'%" + query_forms.trim()
					+ "%'");
		}
		if(query_number != null && !"".equals(query_number.trim())){
			hqlBuffer.append(" and a.medicinalNo like '%" + query_number+"%' ");
			sqlBuffer.append(" and q.medc_no like '%" + query_number +"%' " );
		}
		hqlBuffer.append(" order by a.id DESC");

		if (page == null) {
			qualityMidicinesList = service.getListByPage(hqlBuffer.toString(),
					new HashMap(), 0, Constants.pagesize);
		} else {
			qualityMidicinesList = service.getListByPage(hqlBuffer.toString(),
					new HashMap(), (Integer.parseInt(page) - 1)
							* Constants.pagesize, Constants.pagesize);
		}
		// 获取总条数
		// String sql
		// ="select count(*) from t_qualified_purchase_units where delete_flag=0";
		int resultSize = service.getRecordCount(sqlBuffer.toString());
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", qualityMidicinesList);
	}

	@RequestMapping("/drugVarieties/viewQulidiedMedicinal.html")
	public ModelAndView viewQulifiedMedicinal(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !p_id.trim().equals("")) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		QualityMidicine qualityMidicine = service.get(id);
		model.addAttribute("qualityMidicine", qualityMidicine);
		return new ModelAndView("arietyManage/qualifiedmedicinal/view_hdypda");
	}

	@RequestMapping("/drugVarieties/updateQulidiedMedicinal.html")
	public ModelAndView updateQulifiedMedicinal(QualityMidicine midicine,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String p_id = request.getParameter("p_id");
		Long id = null;
		if (p_id != null && !p_id.equals("")) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		String dosageform = request.getParameter("dosageform");// 剂型
		String produce_no = request.getParameter("produce_no");// 生产企业
		String supply_unit = request.getParameter("supply_unit");// 供货单位
		String manufacturerPath = request.getParameter("manufacturerPath");// 厂商证照附件
		String registeredPath = request.getParameter("registeredPath");// 注册商标附件
		String approvalPath = request.getParameter("approvalPath");// 批准文件附件
		String qualityPath = request.getParameter("qualityPath");// 质量标准依据依据依据附件
		String packPath = request.getParameter("packPath");// 包装情况附件
		String instructPath = request.getParameter("instructPath");// 标签，说明书附件
		String checkoutPath = request.getParameter("checkoutPath");// 检验报告书附件
		String medcRegistrAppPath = request.getParameter("medcRegistrAppPath");// 药品注册批准文件
		String quality_standard = request.getParameter("quality_standard");
		String registeredTrademarks = request.getParameter("registeredTrademarks");//注册商标
		String reject_cause = request.getParameter("reject_cause");
		String trusteeEnterprise = request.getParameter("trusteeEnterprise");//受托方企业
	//	BasedCriteria basedCriteria = baService.get(Long
	//			.valueOf(quality_standard));

		User user = (User) request.getSession().getAttribute(
				Constants.LOCAL_USER);
		List<QualityMidicineRecords> recordsList = new ArrayList<QualityMidicineRecords>();
		QualityMidicine quaMidicine = service.get(id);
		
		if(!isQuals(midicine.getTrusteeEnterprise().trim(),quaMidicine.getTrusteeEnterprise())
				&& quaMidicine.getTrusteeEnterprise() != null){
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改受托方企业名称");
			records.setChangeContent("修改受托方企业名称：修改前值为"
					+ quaMidicine.getTrusteeEnterprise() + ",修改后值为"
					+ midicine.getTrusteeEnterprise());
			records.setQulityMidicineId(quaMidicine.getId());
			records.setModifyReason(reject_cause);
			recordsList.add(records);
			quaMidicine.setTrusteeEnterprise(trusteeEnterprise);
		}
		
		if(midicine.getUseflag()!= quaMidicine.getUseflag()){
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改使用状态");
			records.setChangeContent("修改使用状态：修改前值为"
					+ getStatus(quaMidicine.getUseflag()) + ",修改后值为"
					+ getStatus(midicine.getUseflag()));
			records.setQulityMidicineId(quaMidicine.getId());
			records.setModifyReason(reject_cause);
			recordsList.add(records);
			quaMidicine.setUseflag(midicine.getUseflag());
		}
		if (isNotNull(midicine.getCommonname())) {// 通用名称
			if (!isQuals(midicine.getCommonname().trim(), quaMidicine
					.getCommonname())) {

				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改通用名称");
				records.setChangeContent("修改通用名称：修改前值为"
						+ quaMidicine.getCommonname() + ",修改后值为"
						+ midicine.getCommonname());
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setCommonname(midicine.getCommonname());
			}
		}
		if (isNotNull(dosageform)) {// 剂型
			if (quaMidicine.getDosageforms() == null
					|| !isQuals(dosageform.trim(), ""
							+ quaMidicine.getDosageforms().getId())) {
				DrugFormDictionary form = formService.get(Long
						.valueOf(dosageform));
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改剂型");
				records.setChangeContent("修改剂型：修改前值为"
						+ quaMidicine.getDosageforms() == null ? null
						: quaMidicine.getDosageforms().getFormName() + ",修改后值为"
								+ form.getFormName());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setDosageforms(form);
			}
		}
		if (isNotNull(midicine.getMedicinalNo())) {// 药品编号
			if (!isQuals(midicine.getMedicinalNo().trim(), quaMidicine
					.getMedicinalNo())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品编号");
				records.setChangeContent("修改药品编号：修改前值为"
						+ quaMidicine.getMedicinalNo() + ",修改后值为"
						+ midicine.getMedicinalNo());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setMedicinalNo(midicine.getMedicinalNo());
			}

		}
		if (isNotNull(midicine.getMedicinalProductNo())) {// 生产编号
			if (!isQuals(midicine.getMedicinalProductNo().trim(), quaMidicine
					.getMedicinalProductNo())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改生产编号");
				records.setChangeContent("修改生产编号：修改前值为"
						+ quaMidicine.getMedicinalProductNo() + ",修改后值为"
						+ midicine.getMedicinalProductNo());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setMedicinalProductNo(midicine
						.getMedicinalProductNo());
			}
		}
		if (isNotNull(midicine.getMassSpecifications())) {// 质量规格
			if (!isQuals(midicine.getMassSpecifications().trim(), quaMidicine
					.getMassSpecifications())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改质量规格");
				records.setChangeContent("修改质量规格：修改前值为"
						+ quaMidicine.getMassSpecifications() + ",修改后值为"
						+ midicine.getMassSpecifications());
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setMassSpecifications(midicine
						.getMassSpecifications());
			}
		}
		if (isNotNull(produce_no)) {// 生产企业
			if (quaMidicine.getProduceno() == null
					|| !isQuals(produce_no, ""
							+ quaMidicine.getProduceno().getId())) {
				QualifiedSuppliers supply = supplyService.get(Long
						.valueOf(produce_no));
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改生产企业");
				records.setChangeContent("修改生产企业：修改前值为"
						+ quaMidicine.getProduceno() == null ? null
						: quaMidicine.getProduceno().getCustomerName()
								+ ",修改后值为" + supply.getCustomerName());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setProduceno(supply);
			}

		}
		if (isNotNull(supply_unit)) {// 供货单位
			if (quaMidicine.getSupplyUnit() == null
					|| !isQuals(supply_unit, ""
							+ quaMidicine.getSupplyUnit().getId())) {
				QualifiedSuppliers supply = supplyService.get(Long
						.valueOf(supply_unit));
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改供货单位");
				records.setChangeContent("修改供货单位：修改前值为"
						+ quaMidicine.getSupplyUnit() == null ? null
						: quaMidicine.getSupplyUnit().getCustomerName()
								+ ",修改后值为" + supply.getCustomerName());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setSupplyUnit(supply);
			}

		}
		if (isNotNull(midicine.getSpecifications())) {// 规格
			if (!isQuals(midicine.getSpecifications().trim(), quaMidicine
					.getSpecifications())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品规格");
				records.setChangeContent("修改药品规格：修改前值为"
						+ quaMidicine.getSpecifications() + ",修改后值为"
						+ midicine.getSpecifications());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setSpecifications(midicine.getSpecifications());
			}
		}
		if (isNotNull(midicine.getLicensenumber())) {// 批准文号
			if (!isQuals(midicine.getLicensenumber().trim(), quaMidicine
					.getLicensenumber())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改批准文号");
				records.setChangeContent("修改批准文号：修改前值为"
						+ quaMidicine.getLicensenumber() + ",修改后值为"
						+ midicine.getLicensenumber());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setLicensenumber(midicine.getLicensenumber());
			}
		}
		if (isNotNull(quality_standard)) {// 质量标准依据依据依据
			if (!isQuals(quality_standard, quaMidicine.getQualityStandardName())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改质量标准依据");
				records.setChangeContent("修改质量标准依据：修改前值为"
						+ quaMidicine.getQualityStandardName() == null ? null
						: quaMidicine.getQualityStandardName()
								+ ",修改后值为"
								+ quality_standard);
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setQualityStandardName(quality_standard);
			}
		}
		if (isNotNull(midicine.getMaintainCycle())) {// 养护周期
			if (!isQuals(midicine.getMaintainCycle().trim(), quaMidicine
					.getMaintainCycle())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改养护周期");
				records.setChangeContent("修改养护周期：修改前值为"
						+ quaMidicine.getMaintainCycle() + ",修改后值为"
						+ midicine.getMaintainCycle());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				
				quaMidicine.setMaintainCycle(midicine.getMaintainCycle());
			}
		}
		if (isNotNull(midicine.getMedicinalAttribute())) {// 储存条件
			if (!isQuals(midicine.getMedicinalAttribute().trim(), quaMidicine
					.getMedicinalAttribute())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品储存条件");
				records.setChangeContent("修改药品储存条件：修改前值为"
						+ getMedicnalAttributeName(quaMidicine
								.getMedicinalAttribute())
						+ ",修改后值为"
						+ getMedicnalAttributeName(midicine
								.getMedicinalAttribute()));
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setMedicinalAttribute(midicine
						.getMedicinalAttribute());
			}
		}
		if (isNotNull(midicine.getStorageStore())) {// 储存库区
			if (!isQuals(midicine.getStorageStore().trim(), quaMidicine
					.getStorageStore())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品储存库区");
				records.setChangeContent("修改药品储存库区：修改前值为"
						+ quaMidicine.getStorageStore()
						+ ",修改后值为"
						+ midicine.getStorageStore());
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setStorageStore(midicine
						.getStorageStore());
			}
		}
		if (isNotNull(midicine.getValiddate())) {// 有效期
			if (!isQuals(midicine.getValiddate().trim(), quaMidicine
					.getValiddate())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品过期时间");
				records.setChangeContent("修改药品过期时间：修改前值为"
						+ quaMidicine.getValiddate() + ",修改后值为"
						+ midicine.getValiddate());
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setValiddate(midicine.getValiddate());
			}
		}
		if (isNotNull(midicine.getUnit())) {// 单位
			if (!isQuals(midicine.getUnit().trim(), quaMidicine.getUnit())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品单位");
				records.setChangeContent("修改药品单位：修改前值为" + quaMidicine.getUnit()
						+ ",修改后值为" + midicine.getUnit());
				records.setQulityMidicineId(quaMidicine.getId());
				records.setModifyReason(reject_cause);
				recordsList.add(records);
				quaMidicine.setUnit(midicine.getUnit());
			}
		}
		/*
		if (isNotNull(midicine.getTradename())) {// 商品名
			if (!isQuals(midicine.getTradename().trim(), quaMidicine
					.getTradename())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改商品名");
				records.setChangeContent("修改商品名：修改前值为"
						+ quaMidicine.getTradename() + ",修改后值为"
						+ midicine.getTradename());
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setTradename(midicine.getTradename());
			}
		}*/
		if (isNotNull(midicine.getRegisteredTrademarks())) {// 商品名
			if (!isQuals(midicine.getRegisteredTrademarks().trim(), quaMidicine
					.getRegisteredTrademarks())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改注册商标");
				records.setChangeContent("修改注册商标：修改前值为"
						+ quaMidicine.getRegisteredTrademarks() + ",修改后值为"
						+ midicine.getRegisteredTrademarks());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setRegisteredTrademarks(midicine.getRegisteredTrademarks());
			}
		}
		if (isNotNull(midicine.getMedicinecategory())) {// 类别
			if (!isQuals(midicine.getMedicinecategory().trim(), quaMidicine
					.getMedicinecategory())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品类别");
				records.setChangeContent("修改药品类别：修改前值为"
						+ quaMidicine.getMedicinecategory() + ",修改后值为"
						+ midicine.getMedicinecategory());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setMedicinecategory(midicine.getMedicinecategory());
			}
		}
		if (isNotNull(midicine.getMedicineManagement())) {// 管理
			if (!isQuals(midicine.getMedicineManagement().trim(), quaMidicine
					.getMedicineManagement())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品管理");
				records.setChangeContent("修改药品管理：修改前值为"
						+ quaMidicine.getMedicineManagement() + ",修改后值为"
						+ midicine.getMedicineManagement());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setMedicineManagement(midicine.getMedicineManagement());
			}
		}
		if(isNotNull(midicine.getDepartmentId())) {
			if(!isQuals(midicine.getDepartmentId().trim(), quaMidicine.getDepartmentId())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改销售公司");
				String oldDepartmentId = "";
				if(quaMidicine.getDepartmentId().equals("1001")) {
					oldDepartmentId = "经营";
				}else if(quaMidicine.getDepartmentId().equals("2001")) {
					oldDepartmentId = "新品";
				}else if(quaMidicine.getDepartmentId().equals("3001")) {
					oldDepartmentId = "市场";
				}
				String newDepartmentId = "";
				if(midicine.getDepartmentId().equals("1001")) {
					newDepartmentId = "经营";
				}else if(midicine.getDepartmentId().equals("2001")) {
					newDepartmentId = "新品";
				}else if(midicine.getDepartmentId().equals("3001")) {
					newDepartmentId = "市场";
				}
				records.setChangeContent("修改销售公司：修改前值为"
						+oldDepartmentId+",修改后值为"
						+newDepartmentId);
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setDepartmentId(midicine.getDepartmentId());
			}
		}
		if (isNotNull(midicine.getFunction())) {// 功能
			if (!isQuals(midicine.getFunction().trim(), quaMidicine
					.getFunction())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品功能");
				records.setChangeContent("修改药品功能：修改前值为"
						+ quaMidicine.getFunction() + ",修改后值为"
						+ midicine.getFunction());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setFunction(midicine.getFunction());
			}
		}
		if (isNotNull(midicine.getMedcRegistrApprovalDate())) {// 药品注册文件到期日期
			if (!isQuals(midicine.getMedcRegistrApprovalDate().trim(),
					quaMidicine.getMedcRegistrApprovalDate())) {
				QualityMidicineRecords records = new QualityMidicineRecords();
				records.setModifyTime(new Date());
				records.setModifyId(user);
				records.setProjectName("修改药品注册文件到期日期");
				records.setChangeContent("修改药品注册文件到期日期：修改前值为"
						+ quaMidicine.getMedcRegistrApprovalDate() + ",修改后值为"
						+ midicine.getMedcRegistrApprovalDate());
				records.setModifyReason(reject_cause);
				records.setQulityMidicineId(quaMidicine.getId());
				recordsList.add(records);
				quaMidicine.setMedcRegistrApprovalDate(midicine.getMedcRegistrApprovalDate());
			}
		}
		/** 此处根据20130729需求 暂时删除
		if (isNotNull(manufacturerPath)) {// 厂商证照
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改厂商证照附件");
			records.setChangeContent("修改厂商证照附件");
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(registeredPath)) {// 注册商标
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改注册商标附件");
			records.setChangeContent("修改注册商标附件");
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}*/
		if (isNotNull(approvalPath)) {// 批准文件
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改批准文件附件");
			records.setChangeContent("修改批准文件附件");
			records.setModifyReason(reject_cause);
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(qualityPath)) {// 质量标准依据依据依据
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改质量标准依据依据依据附件");
			records.setChangeContent("修改质量标准依据依据依据附件");
			records.setModifyReason(reject_cause);
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(packPath)) {// 包装情况
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改包装情况附件");
			records.setChangeContent("修改包装情况附件");
			records.setModifyReason(reject_cause);
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(instructPath)) {// 标签，说明书
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修改标签，说明书附件");
			records.setChangeContent("修改标签，说明书附件");
			records.setModifyReason(reject_cause);
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(checkoutPath)) {// 检查报告
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修检查报告附件");
			records.setChangeContent("修改检查报告附件");
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		if (isNotNull(medcRegistrAppPath)) {// 批准文件附件
			QualityMidicineRecords records = new QualityMidicineRecords();
			records.setModifyTime(new Date());
			records.setModifyId(user);
			records.setProjectName("修药品注册批准附件");
			records.setChangeContent("修药品注册批准附件");
			records.setModifyReason(reject_cause);
			records.setQulityMidicineId(quaMidicine.getId());
			recordsList.add(records);
		}
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request;
		batchUpload(multRequest, quaMidicine);
		recordsService.saveAll(recordsList);
		quaMidicine.setModifiedpersonid(user.getId());
		service.saveOrUpdate(quaMidicine);
		logService.addLog("修改合格品种", user.getRealname(), "修改", "品种管理  >合格品种", StringUtil.getIpAddr(request));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
		UtilJson.printMapJson(response, map);

		return null;
	}


	public boolean isNotNull(String str) {
		return str != null && !str.trim().equals("");
	}

	private boolean isQuals(String str1, String str2) {
		if (str1 == null)
			return false;
		if (str2 == null)
			return false;

		return str1.trim().equals(str2.trim());
	}

	/**
	 *文件上传
	 * 
	 * @param request
	 * @param firstVariety
	 */
	public static void batchUpload(MultipartHttpServletRequest request,
			QualityMidicine midicine) {
		Map<String, MultipartFile> filesMap = request.getFileMap();
		String serverRealPath = request.getSession().getServletContext()
				.getRealPath("/");// 获取服务器绝对路径
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
				if (uploadFile.getOriginalFilename() == null
						|| uploadFile.getOriginalFilename().equals(""))
					continue;
				String fileNameLong = uploadFile.getOriginalFilename();// 获取上传文件的名称
				String fileNameExtension = FileUtil
						.getFileExtension(fileNameLong);// 获取文件的上传拓展名
				String relativeSavePath = Constants.UPLOAD_PATH + fileName
						+ "." + fileNameExtension;// 用户保存到数据库的相对文件路径及名称
				relativeSavePath = relativeSavePath.substring(1);
				File savaFile = new File(fileSavePath + fileName + "."
						+ fileNameExtension);
				if (!savaFile.exists()) {
					savaFile.createNewFile();
				}
				if (requestName.equals("manufacturerPath")) {// 厂商证照路径
					midicine.setManufacturerlicensepath(relativeSavePath);
				} else if (requestName.equals("registeredPath")) {// 注册商标路径
					midicine.setRegisteredtrademarkpath(relativeSavePath);
				} else if (requestName.equals("approvalPath")) {// 批准文件路径
					midicine.setApprovaldocumentpath(relativeSavePath);
				} else if (requestName.equals("qualityPath")) {// 质量标准依据依据依据路径
					midicine.setQualitystandardpath(relativeSavePath);
				} else if (requestName.equals("packPath")) {// 包装情况路径
					midicine.setPackingpath(relativeSavePath);
				} else if (requestName.equals("instructPath")) {// 标签、说明书路径
					midicine.setInstructionspath(relativeSavePath);
				} else if (requestName.equals("checkoutPath")) {// 检查报告路径
					midicine.setCheckoutreportpath(relativeSavePath);
				} else if (requestName.equals("medcRegistrAppPath")) {
					midicine.setMedcRegistrApprovalPath(relativeSavePath);
				}
				uploadFile.transferTo(savaFile);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/drugVarieties/deleteQualityMidinceFile.html")
	public ModelAndView deleteFile(Model mode, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName");
		String type = request.getParameter("type");
		String ctxPath = request.getSession().getServletContext().getRealPath(
				"/");
		String filePath = ctxPath + fileName;
		Long enterpriseId = null;
		if (id != null && !id.trim().equals("")) {
			enterpriseId = Long.valueOf(id);
		} else {
			enterpriseId = Long.valueOf(0);
		}
		QualityMidicine firstEnterprise = service.get(enterpriseId);
		if (type != null && !type.trim().equals("")) {
			if (type.equals("cszz")) {
				firstEnterprise.setManufacturerlicensepath("");
			} else if (type.equals("zcsb")) {
				firstEnterprise.setRegisteredtrademarkpath("");
			} else if (type.equals("pzwj")) {
				firstEnterprise.setApprovaldocumentpath("");
			} else if (type.equals("zlbz")) {
				firstEnterprise.setQualitystandardpath("");
			} else if (type.equals("bzqk")) {
				firstEnterprise.setPackingpath("");
			} else if (type.equals("bqsm")) {
				firstEnterprise.setInstructionspath("");
			} else if (type.equals("jybgs")) {
				firstEnterprise.setCheckoutreportpath("");
			} else if (type.equals("ypzcpzwj")) {
				firstEnterprise.setMedcRegistrApprovalPath("");
			}
		}
		service.saveOrUpdate(firstEnterprise);
		boolean status = FileOperate.delFile(filePath);
		Map<String, Object> map = new HashMap<String, Object>();
		if (status) {
			map.put("success", "删除附件成功！");
		} else {
			map.put("success", "删除附件失败！");
		}
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/drugVarieties/confrimRejectQualityMidince.html")
	public String confrimRejectQualityMidince(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !p_id.trim().equals("")) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		FirstVariety firstVariety = firstVarietyService.get(id);
		firstVariety.setReviewStatus(3);
		firstVarietyService.saveOrUpdate(firstVariety);
		QualityMidicine qualityMidicine = service
				.findByFirstVarietyId(firstVariety.getId());
		qualityMidicine.setUseflag(2);
		service.saveOrUpdate(qualityMidicine);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "驳回合格药品成功！");
		UtilJson.printMapJson(response, map);
		return null;
	}

	/**
	 * ajax 查询合格药品
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/ajaxQueryQulidiedMedicinal.html")
	public String ajaxQueryQualifiedMedicinal(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		List<QualityMidicine> midicineList = null;
		String hql = "select a.id,a.commonname from QualityMidicine a where a.useflag=0";
		midicineList = service.getAll(hql);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("midicineList", midicineList);
		UtilJson.printMapJson(response, map);
		return null;
	}

	@RequestMapping("/drugVarieties/ajaxQueryWarnMedicinal.html")
	public String ajaxQuerWarn(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name  = 'yp_medince_regist_date' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		StringBuffer hqlBuffer = new StringBuffer(
				"from QualityMidicine a where 1=1 and  a.useflag=0");
		//String yaopinyouxiaoqi = "";
		String yaopzhucwenjianyouxiaoqi = "";
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null
					&& limit_name.equals("yp_medince_regist_date")) {
				hqlBuffer.append(" and a.medcRegistrApprovalDate <= '" + startDate + "' ");
				yaopzhucwenjianyouxiaoqi = startDate;
			}
		}
		List<QualityMidicine> midicineList = service.getAll(hqlBuffer
				.toString());

		for (QualityMidicine midicine : midicineList) {
			//String ypyxq = midicine.getValiddate();// 药品有效期 
			String ypzcwjyxq = midicine.getMedcRegistrApprovalDate();
			
			if (ypzcwjyxq != null
					&& DateTimeUtils.compareTwoDate(yaopzhucwenjianyouxiaoqi,
							ypzcwjyxq) >= 0) {
				int days = DateTimeUtils
						.compareDateInterval(ypzcwjyxq, nowdate);
				if (days >= 0) {
					buffer
							.append("&nbsp;<a href='viewQulidiedMedicinal.html?id="
									+ midicine.getId() + "' traget='_blank'>");
					buffer.append("" + midicine.getCommonname()
							+ "注册批准文件还有<font>" + days + "</font>天 到期</a>");
				} else {
					if( midicine.getUseflag() !=1){
						midicine.setUseflag(1);
						service.updata(midicine);
					}
					
					buffer
							.append("&nbsp;<a href='viewQulidiedMedicinal.html?id="
									+ midicine.getId() + "' traget='_blank'>");
					buffer.append("" + midicine.getCommonname()
							+ "注册批准文件已过期<font>" + Math.abs(days)
							+ "</font>天</a>");
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}
	/**
	 * 首页根据批号查询该批号的当前状态
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/ajaxHomePageMidince.html")
	public String ajaxHomePageMedicWrang(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String batchNumber = request.getParameter("batchNumber");
		String type=request.getParameter("type");
		User user = (User)request.getSession().getAttribute(Constants.LOCAL_USER);
		Map<Long, String> authorityMap = user.getAuthoriy();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("batchNumber", batchNumber);
		Iterator<Long> its = authorityMap.keySet().iterator();
		while(its.hasNext()){
			Long key = its.next();
			String value = authorityMap.get(key);
			map.put(value, value);
		}
		if (batchNumber != null && !"".equals(batchNumber.trim())) {
			StringBuffer hqlBuffer = new StringBuffer(
					"select new com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO(a,b,c)");
			hqlBuffer
					.append(" from PurchaseOrder a , PurchaseOrderItem b, QualityMidicine c  where b.purchaseOrderId = a.id and b.qualifiedMedicineId=c.id");
			hqlBuffer.append(" and b.batchProduction='" + batchNumber + "'");
			List<PurchaseOrderMidicineVO> purOderMedicVoList = null;
			
			String midinceInfo = "";
			try {
				purOderMedicVoList = service.getPurchaseOrderMidicineVo(
						hqlBuffer.toString(), 0, 10);
				if (purOderMedicVoList == null
						|| purOderMedicVoList.size() <= 0) {
					midinceInfo = "<tr><td>没有查询到该批次药品的相关信息</td></tr>";
					map.put("midinceInfo", midinceInfo);
					map.put(Constants.PURCHASEORDERSTATE, "0");// 没有查询到该批号的合格药品
					UtilJson.printMapJson(response, map);
					return null;
				} else {
					String hql = "select a from WarnConfig a where (a.limit_name like'gys%' or a.limit_name like 'yp%') and a.use_flag=0";
					List<WarnConfig> configList = configService.findList(hql);
					/* 采购订单校验 */
					if(purchaseOrder(response, purOderMedicVoList, configList,map, batchNumber,type)==null){
						return null;
					}
					/* 判断该批号的药品是否收获 */
					if(receiveMidicine(response, configList, map, batchNumber, type)==null){
						return null;
					}
					/* 药品验收 */
					if(chectAcceptMidicine(response, configList, map, batchNumber,type)==null){
						return null;
					}
					/* 养护计划 */
					if(conservePlan(response, configList, map, batchNumber,type)==null){
						return null;
					}
					/* 养护 */
					if(maintenanceMidicine(response, configList, map, batchNumber,type)==null){
						return null;
					}
					/* 销售订单 */
					if(saleOrder(response, configList, map, batchNumber,type)==null){
						return null;
					}

					/* 出库复核 */
					if(checkOut(response, configList, map, batchNumber,type)==null){
						return null;
					}
					/* 出库 暂时为考虑 */
					map.put(Constants.PURCHASEORDERSTATE, "12");
					UtilJson.printMapJson(response, map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

		}
		return null;
	}

	public String purchaseOrder(HttpServletResponse response,
			List<PurchaseOrderMidicineVO> purOderMedicVoList,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String purchaseOrderStr = "";// 采购订单显示
		String supplierStr = "";// 供应商显示
		String supplierStrErr = "";
		String purchaseMidicineStr ="";
		String purchaseMidicineStrErr ="";
		int supplierError = 0;// 供应商过期
		int medicError = 0;// 药品过期
		String youxiaoqiyujing = "";
		String midinceInfo = "";
		//int index = 1;
		for (PurchaseOrderMidicineVO purOrderMidicVo : purOderMedicVoList) {
			midinceInfo = "<tr><th>药品号：</th><td>"
					+ purOrderMidicVo.getQualityMidicine().getMedicinalNo()
					+ "</td>"
					+ "<th>药品通用名：</th><td>"
					+ purOrderMidicVo.getQualityMidicine().getCommonname()
					+ "</td>"
					+ "<th>剂型：</th><td>"
					+ purOrderMidicVo.getQualityMidicine().getDosageforms()
							.getFormName()
					+ "</td>"
					+ "<th>规格：</th><td>"
					+ purOrderMidicVo.getQualityMidicine().getSpecifications()
					+ "</td>"
					+ "<th>生产厂家：</th><td>"
					+ purOrderMidicVo.getPurchaseOrder()
							.getQualifiedSupplierId().getCustomerName()
					+ "</td></tr>";
			if(map.get("home_cgdd")!=null && map.get("home_cgdd")!=""){
				purchaseOrderStr = purchaseOrderStr + "<li><a href='drugState/purchaseNote/add.html?method=edit&thispage=1&id="+purOrderMidicVo.getPurchaseOrder().getId().toString()+"'>"
				+ ".采购单号为" + purOrderMidicVo.getPurchaseOrder().getNumber()
				+ "的"
				+ purOrderMidicVo.getQualityMidicine().getCommonname()
				+ "有效期至："
				+ purOrderMidicVo.getPurchaseOrderItem().getEndTime()
				+ "</a></li>";
			}else{
				purchaseOrderStr = purchaseOrderStr + "<li><a href='javascript:void(0)'>"
				+ ".采购单号为" + purOrderMidicVo.getPurchaseOrder().getNumber()
				+ "的"
				+ purOrderMidicVo.getQualityMidicine().getCommonname()
				+ "有效期至："
				+ purOrderMidicVo.getPurchaseOrderItem().getEndTime()
				+ "</a></li>";
			}
		
			String supplyName = purOrderMidicVo.getPurchaseOrder()
					.getQualifiedSupplierId().getCustomerName();// 供应商名称
			String operationTime = purOrderMidicVo.getPurchaseOrder()
					.getModifyDate();// 订单操作时间
			for (WarnConfig config : configList) {
				youxiaoqiyujing = DateTimeUtils.formCurrentDate(DateTimeUtils
						.getCalendar(operationTime, Integer.valueOf(config
								.getLimit_day())));// 营业执照
				if (config.getLimit_name().equals(
						"gys_businessLicense_ExpirationDate")) {
					String yingyezhihaoyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getBusiLiceExpiDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(
									youxiaoqiyujing,yingyezhihaoyouxiaoqi ) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								youxiaoqiyujing, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									+  "." + supplyName + "供应商的营业执照还有"
									+ days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								+  "." + supplyName + "供应商的营业执照还有"
								+ days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									+  "." + supplyName
									+ "供应商的营业执照已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								+  "." + supplyName
								+ "供应商的营业执照已过期</a></li>";
						supplierError = supplierError + 1;
								
							}
						}
					}
				} /* 取消供应商营业执照年检  else if (config.getLimit_name().equals(
						"gys_businessLicense_annualSurvey")) {
					String yingyezhihaonjyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getBusiLIceAnnuSurvey();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(
									youxiaoqiyujing,yingyezhihaonjyouxiaoqi ) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								yingyezhihaonjyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									+  "." + supplyName + "供应商的营业执照年检还有"
									+ days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								+  "." + supplyName + "供应商的营业执照年检还有"
								+ days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									+  "." + supplyName
									+ "供应商的营业执照年检已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								+  "." + supplyName
								+ "供应商的营业执照年检已过期</a></li>";
								supplierError = supplierError + 1;
							}
						}
					}
				}*/ else if (config.getLimit_name().equals(
						"gys_licence_ExpirationDate")) {
					String xukezhengyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getLiceExpiDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
									xukezhengyouxiaoqi) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								xukezhengyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName + "供应商的经营许可证还有"
									+ days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName + "供应商的经营许可证还有"
								+ days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的经营许可证已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的经营许可证已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
					}
					
				} else if (config.getLimit_name().equals(
						"gys_GPS_ExpirationDate")) {
					String gspyouxiaoqi = purOrderMidicVo.getPurchaseOrder()
							.getQualifiedSupplierId().getGspExpirDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
									gspyouxiaoqi) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								gspyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName + "供应商的GSP证书还有"
									+ days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName + "供应商的GSP证书还有"
								+ days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的GSP证书已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的GSP证书已过期</a></li>";
						supplierError = supplierError + 1;
							}

						}
					}
				} else if (config.getLimit_name().equals(
						"gys_organizationCodeDate")) {
					String zuzhijigouyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getOrganizationCodeDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(
									youxiaoqiyujing,zuzhijigouyouxiaoqi ) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								zuzhijigouyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName + "供应商的组织机构代码还有"
									 + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName + "供应商的组织机构代码还有"
								 + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的组织机构代码已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的组织机构代码已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
					}
				} else if (config.getLimit_name().equals(
						"gys_organizationCodeInspectionDate")) {
					String zuzhijigounjyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getOrganizationCodeInspectionDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(
									youxiaoqiyujing,zuzhijigounjyouxiaoqi ) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								zuzhijigounjyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的组织机构代码年检还有" + days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的组织机构代码年检还有" + days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的组织机构代码年检已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的组织机构代码年检已过期</a></li>";
						supplierError = supplierError + 1;
							}

						}
					}
				} else if (config.getLimit_name().equals(
						"gys_qualityAssuranceDate")) {
					String zhiliangxieyiyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getQualityAssuranceDate();
					if (youxiaoqiyujing != null
							&& zhiliangxieyiyouxiaoqi!="" && DateTimeUtils.compareTwoDate(
									youxiaoqiyujing, zhiliangxieyiyouxiaoqi) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								zhiliangxieyiyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName + "供应商的质量保证协议还有"
									+ days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName + "供应商的质量保证协议还有"
								+ days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的质量保证协议已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的质量保证协议已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
					}
				} else if (config.getLimit_name().equals(
						"gys_authorizationDate")) {
					String shouquanxieyishuyouxiaoqi = purOrderMidicVo
							.getPurchaseOrder().getQualifiedSupplierId()
							.getAuthorizationDate();
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(
									youxiaoqiyujing,shouquanxieyishuyouxiaoqi ) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								shouquanxieyishuyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStr = supplierStr + "<li><a href='javascript:void(0)'>"
									+ "." + supplyName
									+ "供应商的法人委托书还有" + days + "天过期</a></li>";
							}else{
								supplierStr = supplierStr + "<li><a href='firstEnterprise/hggys.html'>"
								+ "." + supplyName
								+ "供应商的法人委托书还有" + days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hggys")==null || map.get("home_hggys").equals("")){
							supplierStrErr = supplierStrErr + "<li><a href='javascript:void(0)'>"
									 + "." + supplyName
									+ "供应商的法人委托书已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								supplierStrErr = supplierStrErr + "<li><a href='firstEnterprise/hggys.html'>"
								 + "." + supplyName
								+ "供应商的法人委托书已过期</a></li>";
						supplierError = supplierError + 1;
								
							}

						}
					}
				} else if (config.getLimit_name().equals("yp_valid_date")) {
					String yaopinyouxiaoqi = purOrderMidicVo
							.getPurchaseOrderItem().getEndTime();
					String batch_No = purOrderMidicVo.getPurchaseOrderItem()
							.getBatchProduction();// 药品批号
					String medicName = purOrderMidicVo.getQualityMidicine()
							.getCommonname();// 通用名称
					if (youxiaoqiyujing != null
							&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
									yaopinyouxiaoqi) >= 0) {
						int days = DateTimeUtils.compareDateInterval(
								yaopinyouxiaoqi, operationTime);
						if (days >= 0) {
							if(map.get("home_hgpz")==null || map.get("home_hgpz").equals("")){
							purchaseMidicineStr = purchaseMidicineStr + "<li><a href='drugState/purchaseNote/list.html'>"
									 + ".批号为" + batch_No + "的"
									+ medicName + "还有" + days + "过期天</a></li>";
							}else{
								purchaseMidicineStr = purchaseMidicineStr + "<li><a href='javascript:void(0)'>"
								 + ".批号为" + batch_No + "的"
								+ medicName + "还有" + days + "过期天</a></li>";
							}
						} else {
							if(map.get("home_hgpz")==null || map.get("home_hgpz").equals("")){
							purchaseMidicineStrErr = purchaseMidicineStrErr + "<li><a href='javascript:void(0)'>"
									 + ".批号为" + batch_No + "的"
									+ medicName + "已过期</a></li>";
							medicError = medicError + 1;
							}else{
								purchaseMidicineStrErr = purchaseMidicineStrErr + "<li><a href='drugState/purchaseNote/list.html'>"
								 + ".批号为" + batch_No + "的"
								+ medicName + "已过期</a></li>";
								medicError = medicError + 1;
							}

						}
					}
				}
				//index++;
			}

		}
		map.put("supplierStrErr", supplierStrErr);
		map.put("purchaseMidicineStrErr", purchaseMidicineStrErr);
		map.put("midinceInfo", midinceInfo);
		map.put("purchaseOrderStr", purchaseOrderStr);
		map.put("purchaseMidicineStr", purchaseMidicineStr);
		map.put("supplierStr", supplierStr);
		map.put("medicError", medicError);
		if (supplierError > 0 && medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "1");// 表示合格供应商和药品够过期
			UtilJson.printMapJson(response, map);
			return null;
		} else if (supplierError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "2");// 表示仅合格供应商
			UtilJson.printMapJson(response, map);
			return null;
		} else if (medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "3");// 表示仅药品过期
			UtilJson.printMapJson(response, map);
			return null;
		}

		return "";
	}

	/**
	 * 药品验收
	 * 
	 * @param response
	 * @param configList
	 * @param map
	 * @param batchNumber
	 * @return
	 */
	public String receiveMidicine(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String receiveHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO(a,b,c) from ReceivingNote a, ReceivingNoteItem b,QualityMidicine c where b.receivingNoteId = a.id and  b.qualifiedMedicineId = c.id and b.batchProduction='"
				+ batchNumber + "'";
		String receiveMedicStr = "";// 药品验收提示信息
		String receiveMedicStrErr="";
		int medicError = 0;
		int index = 1;
		String youxiaoqiyujing = "";
		List<ReceiveMidicineVO> receiveMidicineVoList = service
				.getReceiveMidicineVO(receiveHql, 0, 10);
		if (receiveMidicineVoList == null || receiveMidicineVoList.size() <= 0) {
			map.put(Constants.PURCHASEORDERSTATE, "44");// 表示没有收获
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			for (ReceiveMidicineVO receiveMidicineVO : receiveMidicineVoList) {
				String operationTime = receiveMidicineVO.getReceivingNote()
						.getReceivedDate();// 订单操作时间

				for (WarnConfig config : configList) {
					if (config.getLimit_name().equals("yp_valid_date")) {
						youxiaoqiyujing = DateTimeUtils
								.formCurrentDate(DateTimeUtils.getCalendar(
										operationTime, Integer.valueOf(config
												.getLimit_day())));// 收获
						String yaopinyouxiaoqi = receiveMidicineVO
								.getReceivingNoteItem().getEndTime();
						String batch_No = receiveMidicineVO
								.getReceivingNoteItem().getBatchProduction();// 药品批号
						String medicName = receiveMidicineVO
								.getQualityMidicine().getCommonname();// 通用名称
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(
										youxiaoqiyujing,yaopinyouxiaoqi ) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yaopinyouxiaoqi, operationTime);
							if (days >= 0) {
								if(map.get("home_sh")==null || map.get("home_sh").equals("")){
								receiveMedicStr = receiveMedicStr
										+ "<li><a href='javascript:void(0)'>"  + ".批号为"
										+ batch_No + "的" + medicName + "还有"
										+ days + "天过期</a></li>";
								}else{
									receiveMedicStr = receiveMedicStr
									+ "<li><a href='javascript:void(0)'>"  + ".批号为"
									+ batch_No + "的" + medicName + "还有"
									+ days + "天过期</a></li>";
								}
							} else {
								if(map.get("home_sh")==null || map.get("home_sh").equals("")){
								receiveMedicStrErr = receiveMedicStrErr
										+ "<li><a href='javascript:void(0)'>" + ".批号为"
										+ batch_No + "的" + medicName
										+ "已过期</a></li>";
								medicError = medicError + 1;
								}else{
									receiveMedicStrErr = receiveMedicStrErr
									+ "<li><a href='drugState/inspectionRecords/list.html'>" + ".批号为"
									+ batch_No + "的" + medicName
									+ "已过期</a></li>";
									medicError = medicError + 1;
								}
							}
						}
					}
					index++;
				}
			}
		}
		map.put("receiveMedicStr", receiveMedicStr);
		map.put("receiveMedicStrErr", receiveMedicStrErr);
		if (medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "4");// 收获时药品过期
			UtilJson.printMapJson(response, map);
			return null;
		}
		return "";
	}

	public String chectAcceptMidicine(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String checkAcceptHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO(a,b,c) from CheckAcceptNote as a , CheckacceptItem as b ,QualityMidicine as c  where b.receivingId=a.id  and b.qualifiedMedicineId = c.id and b.batchProduction='"
				+ batchNumber + "'";
		String checkAcceptStr = "";
		String checkAcceptStrErr="";
		int medicError = 0;
		int index = 1;
		String youxiaoqiyujing = "";
		List<ChectAcceptMidicineVO> checkAcceptMidicineVoList = service
				.getChectAcceptMidicineVO(checkAcceptHql, 0, 10);
		if (checkAcceptMidicineVoList == null
				|| checkAcceptMidicineVoList.size() <= 0) {
			map.put(Constants.PURCHASEORDERSTATE, "5");// 没有验收单
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			for (ChectAcceptMidicineVO chectAcceptMidicineVO : checkAcceptMidicineVoList) {
				String operationTime = chectAcceptMidicineVO
						.getCheckAcceptNote().getCheckAcceptDate();// 收获单审核时间
				for (WarnConfig config : configList) {
					if (config.getLimit_name().equals("yp_valid_date")) {
						youxiaoqiyujing = DateTimeUtils
								.formCurrentDate(DateTimeUtils.getCalendar(
										operationTime, Integer.valueOf(config
												.getLimit_day())));// 营业执照
						String yaopinyouxiaoqi = chectAcceptMidicineVO
								.getCheckacceptItem().getEndTime();
						String batch_No = chectAcceptMidicineVO
								.getCheckacceptItem().getBatchProduction();// 药品批号
						String medicName = chectAcceptMidicineVO
								.getQualityMidicine().getCommonname();// 通用名称
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(
										youxiaoqiyujing,yaopinyouxiaoqi ) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yaopinyouxiaoqi, operationTime);
							if (days >= 0) {
								if(map.get("home_ys")==null || map.get("home_ys").equals("")){
								checkAcceptStr = checkAcceptStr
										+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
										+ batch_No + "的" + medicName + "还有"
										+ days + "天过期</a></li>";
								}else{
									checkAcceptStr = checkAcceptStr
									+ "<li><a href='drugState/checkaccept/list.html'>" + index + ".批号为"
									+ batch_No + "的" + medicName + "还有"
									+ days + "天过期</a></li>";
								}
							} else {
								if(map.get("home_ys")==null || map.get("home_ys").equals("")){
								checkAcceptStrErr = checkAcceptStrErr
										+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
										+ batch_No + "的" + medicName
										+ "已过期</a></li>";
								medicError = medicError + 1;
								}else{
									checkAcceptStrErr = checkAcceptStrErr
									+ "<li><a href='drugState/checkaccept/list.html'>" + index + ".批号为"
									+ batch_No + "的" + medicName
									+ "已过期</a></li>";
							medicError = medicError + 1;
								}

							}
						}
					}
				}
				index++;
			}
		}
		map.put("checkAcceptStrErr", checkAcceptStrErr);
		map.put("checkAcceptStr", checkAcceptStr);
		if (medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "55");// 药品收获时候药品过期
			UtilJson.printMapJson(response, map);
			return null;
		}
		return "";
	}

	/**
	 * 养护计划
	 * 
	 * @param response
	 * @param configList
	 * @param map
	 * @param batchNumber
	 * @return
	 */
	public String conservePlan(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String curingPlanHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO(a,b) from Qualifiedmedcstore a ,QualityMidicine b where a.qualifiedmedicineid=b.id and a.batchproduction='"
				+ batchNumber + "'";
		String curingPlanStr = "";
		String curingPlanErr="";
		int medicError=0;
		int index = 1;
		String youxiaoqiyujing = "";
	
		List<QualifiedmedcstoreVO> qualifiedmedcstoreVOList = service
				.getQualifiedmedcstoreVO(curingPlanHql, 0, 10);
		if (qualifiedmedcstoreVOList == null
				|| qualifiedmedcstoreVOList.size() <= 0) {
			//map.put(Constants.PURCHASEORDERSTATE, "6");// 养护计划没有生成
			//UtilJson.printMapJson(response, map);
			//return null;
		} else {
			for (QualifiedmedcstoreVO qualifiedmedcstoreVO : qualifiedmedcstoreVOList) {
				String operationTime = qualifiedmedcstoreVO
						.getQualifiedmedcstore().getCreatedate();// 养护计划生成时间
				for (WarnConfig config : configList) {
					if (config.getLimit_name().equals("yp_valid_date")) {
						String yaopinyouxiaoqi = qualifiedmedcstoreVO
								.getQualifiedmedcstore().getNextmaintaindate();
						String batch_No = qualifiedmedcstoreVO
								.getQualifiedmedcstore().getBatchproduction();// 药品批号
						String medicName = qualifiedmedcstoreVO
								.getQualityMidicine().getCommonname();// 通用名称
						/* 暂时去掉养护计划预警youxiaoqiyujing = DateTimeUtils
								.formCurrentDate(DateTimeUtils.getCalendar(
										operationTime, Integer.valueOf(config
												.getLimit_day())));//
*/						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(
										youxiaoqiyujing,yaopinyouxiaoqi ) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yaopinyouxiaoqi, operationTime);
							if (days >= 0) {
								if(map.get("home_yhjh")==null || map.get("home_yhjh").equals("")){
								curingPlanStr = curingPlanStr
										+ "<li><a href='javascript:void(0)'>.批号为"
										+ batch_No + "的" + medicName
										+ "距下一个养护计划还有" + days + "天过期</a></li>";
								}else{
									curingPlanStr = curingPlanStr
									+ "<li><a href='drugState/MaintenancePlan/list.html'>.批号为"
									+ batch_No + "的" + medicName
									+ "距下一个养护计划还有" + days + "天过期</a></li>";
								}
							} else {
								if(map.get("home_yhjh")==null || map.get("home_yhjh").equals("")){
								curingPlanErr = curingPlanErr
										+ "<li><a href='javascript:void(0)'>.批号为"
										+ batch_No + "的" + medicName
										+ "养护计划已过期</a></li>";
								medicError = medicError+1;
								}else{
									curingPlanErr = curingPlanErr
									+ "<li><a href='drugState/MaintenancePlan/list.html'>" + index + ".批号为"
									+ batch_No + "的" + medicName
									+ "养护计划已过期</a></li>";
							medicError = medicError+1;
								}

							}
						}

					}
					index++;
				}
			}
		}
		map.put("curingPlanStr", curingPlanStr);
		map.put("curingPlanErr", curingPlanErr);
		if(medicError>0){
			map.put(Constants.PURCHASEORDERSTATE, "7");
			UtilJson.printMapJson(response, map);
			return null;
		}
		return "";

	}

	/**
	 * 药品养护
	 * 
	 * @param response
	 * @param configList
	 * @param map
	 * @param batchNumber
	 * @return
	 */
	public String maintenanceMidicine(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String youxiaoqiyujing = "";
		int index = 1;
		String maintainHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO(a,c) from DrugMaintenance as a ,QualityMidicine as c  where a.qualifiedmedicineid=c.id and a.batchnumber='"
				+ batchNumber + "'";
		List<MaintenanceMidicineVO> maintenanceMidicineVOList = service
				.getMaintenanceMidicineVO(maintainHql, 0, 10);
		String maintainStr = "";
		String maintainStrErr="";
		int medicError = 0;
		if (maintenanceMidicineVOList == null
				|| maintenanceMidicineVOList.size() <= 0) {
		//	map.put(Constants.PURCHASEORDERSTATE, "7");// 没有养护记录
		//	UtilJson.printMapJson(response, map);
		//	return null;
		} else {
			for (MaintenanceMidicineVO maintenanceMidicineVO : maintenanceMidicineVOList) {
				String operationTime = maintenanceMidicineVO
						.getDrugMaintenance().getMaintaindate();// 养护计划生成时间
				for (WarnConfig config : configList) {
					if (config.getLimit_name().equals("yp_valid_date")) {
						youxiaoqiyujing = DateTimeUtils
								.formCurrentDate(DateTimeUtils.getCalendar(
										operationTime, Integer.valueOf(config
												.getLimit_day())));// 营业执照
						String yaopinyouxiaoqi = maintenanceMidicineVO
								.getDrugMaintenance().getMaintaindate();
						String batch_No = maintenanceMidicineVO
								.getDrugMaintenance().getBatchnumber();// 药品批号
						String medicName = maintenanceMidicineVO
								.getQualityMidicine().getCommonname();// 通用名称
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(
										youxiaoqiyujing,yaopinyouxiaoqi ) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yaopinyouxiaoqi, operationTime);
							if (days >= 0) {
								if(map.get("home_yhjl")==null || map.get("home_yhjl").equals("")){
								maintainStr = maintainStr + "<li><a href='javascript:void(0)'>"
										+ index + ".批号为" + batch_No + "的"
										+ medicName + "还有" + days
										+ "天过期</a></li>";
								}else{
									maintainStr = maintainStr + "<li><a href='qualityRecords/drugMaintenance/list.html'>"
									+ index + ".批号为" + batch_No + "的"
									+ medicName + "还有" + days
									+ "天过期</a></li>";
								}
							} else {
								if(map.get("home_yhjl")==null || map.get("home_yhjl").equals("")){
								maintainStrErr = maintainStrErr + "<li><a href='javascript:void(0)'>"
										+ index + ".批号为" + batch_No + "的"
										+ medicName + "已过期</a></li>";
								medicError = medicError + 1;
								}else{
									maintainStrErr = maintainStrErr + "<li><a href='qualityRecords/drugMaintenance/list.html'>"
									+ index + ".批号为" + batch_No + "的"
									+ medicName + "已过期</a></li>";
									medicError = medicError + 1;
								}

							}
						}

					}
					index++;
				}
			}
		}
		map.put("maintainStrErr", maintainStrErr);
		map.put("maintainStr", maintainStr);
		if (medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "8");// 药品养护过期
			UtilJson.printMapJson(response, map);
			return null;
		}
		return "";
	}

	/**
	 * 根据批号查询销售订单
	 * 
	 * @param response
	 * @param configList
	 * @param map
	 * @param batchNumber
	 * @return
	 */
	public String saleOrder(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {
		String youxiaoqiyujing = "";
		String drugSalesHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO(a,b,c,d) from TrtssSalesFormInfo a,TrtssSalesItemsInfo b,QualityMidicine c,QualifiedPurchaseUnits d where b.trtssSalesFormInfoId = a.id and b.qualified_medicineId=c.id and a.qualifiedPurchaseUnitsId=d.id and b.batchNo='"
				+ batchNumber + "'";
		List<TrtssSalesFormMidicineVO> trtsssalesList = service
				.getTrtssSalesFormMidicineVO(drugSalesHql, 0, 10);
		String saleMidinceStr = "";// 销售药品预警
		String saleMidinceStrErr="";
		String saleSupplyStr = "";// 销售供应商预警
		String saleSupplyStrErr = "";// 销售供应商预警
		int index = 1;
		int medicError = 0;
		int supplierError = 0;
		if (trtsssalesList == null || trtsssalesList.size() <= 0) {
			map.put(Constants.PURCHASEORDERSTATE, "9");
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			for (TrtssSalesFormMidicineVO trtssMidicineVO : trtsssalesList) {
				String operateTime = DateTimeUtils.format(trtssMidicineVO.getTrtssSalesFormInfo()
						.getCreaterDate(), "yyyy-MM-dd");
				for (WarnConfig config : configList) {
					youxiaoqiyujing = DateTimeUtils
							.formCurrentDate(DateTimeUtils.getCalendar(
									operateTime, Integer.valueOf(config
											.getLimit_day())));// 营业执照
					String limit_name = config.getLimit_name();
					if (limit_name.equals("gys_businessLicense_ExpirationDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getBusLiceExpiraDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的营业执照还有" + days + "天过期</a></li>";
							}else{
								saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的营业执照还有" + days + "天过期</a></li>";
							}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的营业执照已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的营业执照已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}
					} /*取消购货商的营业执照年检限制 else if (limit_name
							.equals("gys_businessLicense_annualSurvey")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getBusLiceAnnualSurvey();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName + "购货商的营业执照年检还有"
									+ days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName + "购货商的营业执照年检还有"
									+ days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的营业执照年检已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的营业执照年检已过期</a></li>";
								supplierError = supplierError + 1;
							}
						}
						}

					}*/ else if (limit_name.equals("gys_licence_ExpirationDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getLiceExpirationDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName + "购货商的经营许可证还有"
									+ days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName + "购货商的经营许可证还有"
									+ days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的经营许可证已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的经营许可证已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}

					} else if (limit_name.equals("gys_GPS_ExpirationDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getGpsExpirationDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName + "购货商的还有"
									+ days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName + "购货商的还有"
									+ days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}

					} else if (limit_name.equals("gys_organizationCodeDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getOrganizationCodeDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的组织机构代码还有" + days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName
									+ "购货商的组织机构代码还有" + days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的组织机构代码已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的组织机构代码已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}

					} else if (limit_name
							.equals("gys_organizationCodeInspectionDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getOrganizationCodeInspectionDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq	) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName + "购货商的组织机构代码年检还有"
									+ days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName + "购货商的组织机构代码年检还有"
									+ days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的组织机构代码年检已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的组织机构代码年检已过期</a></li>";
								supplierError = supplierError + 1;
							}
						}
						}

					} else if (limit_name.equals("gys_qualityAssuranceDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getQualityAssuranceDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的质量保证协议还有" + days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName
									+ "购货商的质量保证协议还有" + days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的质量保证协议已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的质量保证协议已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}
					} else if (limit_name.equals("gys_authorizationDate")) {
						String yyzhyxq = trtssMidicineVO.getPurchaseUnit()
								.getAuthorizationDate();
						String supplyName = trtssMidicineVO.getPurchaseUnit()
								.getCustomerName();
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(youxiaoqiyujing,
										yyzhyxq	) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yyzhyxq, operateTime);
							if(days>0){
								if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStr = saleSupplyStr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName + "购货商的法人委托书还有"
									+ days + "天过期</a></li>";
								}else{
									saleSupplyStr = saleSupplyStr + "<li><a href='firstEnterprise/hgghdw.html'>"
									+ index + "." + supplyName + "购货商的法人委托书还有"
									+ days + "天过期</a></li>";
								}
						} else {
							if(map.get("home_hgghs")==null || map.get("home_hgghs").equals("")){
							saleSupplyStrErr = saleSupplyStrErr + "<li><a href='javascript:void(0)'>"
									+ index + "." + supplyName
									+ "购货商的法人委托书已过期</a></li>";
							supplierError = supplierError + 1;
							}else{
								saleSupplyStrErr = saleSupplyStrErr + "<li><a href='firstEnterprise/hgghdw.html'>"
								+ index + "." + supplyName
								+ "购货商的法人委托书已过期</a></li>";
						supplierError = supplierError + 1;
							}
						}
						}

					} else if (limit_name.equals("yp_valid_date")) {
						String yaopinyouxiaoqi = trtssMidicineVO
								.getTrtSalesItemsInfo().getExpireDate()+"-01";
						String batch_No = trtssMidicineVO
								.getTrtSalesItemsInfo().getBatchNo();// 药品批号
						String medicName = trtssMidicineVO.getQualityMidicine()
								.getCommonname();// 通用名称
						if (youxiaoqiyujing != null
								&& DateTimeUtils.compareTwoDate(
										youxiaoqiyujing,yaopinyouxiaoqi ) >= 0) {
							int days = DateTimeUtils.compareDateInterval(
									yaopinyouxiaoqi, operateTime);
							if (days >= 0) {
								if(map.get("home_hgpz")==null || map.get("home_hgpz").equals("")){
								saleMidinceStr = saleMidinceStr
										+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
										+ batch_No + "的" + medicName + "还有"
										+ days + "天过期</a></li>";
								}else{
									saleMidinceStr = saleMidinceStr
									+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
									+ batch_No + "的" + medicName + "还有"
									+ days + "天过期</a></li>";
								}
							} else {
								if(map.get("home_hgpz")==null || map.get("home_hgpz").equals("")){
								saleMidinceStrErr = saleMidinceStrErr
										+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
										+ batch_No + "的" + medicName
										+ "已过期</a></li>";
								medicError = medicError + 1;
								}else{
									saleMidinceStrErr = saleMidinceStrErr
									+ "<li><a href='javascript:void(0)'>" + index + ".批号为"
									+ batch_No + "的" + medicName
									+ "已过期</a></li>";
							medicError = medicError + 1;
								}

							}
						}
					}
				}
			}
		}
		map.put("saleSupplyStr", saleSupplyStr);
		map.put("saleSupplyStrErr", saleSupplyStrErr);
		map.put("saleMidinceStr", saleMidinceStr);
		map.put("saleMidinceStrErr", saleMidinceStrErr);
		
		if(supplierError>0&& medicError>0){
			map.put(Constants.PURCHASEORDERSTATE, "99");
			UtilJson.printMapJson(response, map);
			return null;
		}else if (supplierError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "999");
			UtilJson.printMapJson(response, map);
			return null;
		}else if (medicError > 0) {
			map.put(Constants.PURCHASEORDERSTATE, "10");
			UtilJson.printMapJson(response, map);
			return null;
		}
		return "";
	}
	/**
	 * 出库复核
	 * @param response
	 * @param configList
	 * @param map
	 * @param batchNumber
	 * @return
	 */
	public String checkOut(HttpServletResponse response,
			List<WarnConfig> configList, Map<String, Object> map,
			String batchNumber,String type) {

		String outcheckHql = "select new com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO(a,b,c) from OutboundCheckBill a,OutboundCheckItem b,QualityMidicine c where b.outboundCheckBillId=a.id and b.qualifiedMedicineId=c.id and b.batchNo='"
				+ batchNumber + "'";
		List<MidicineOutCheckVO> midicineoutcheList = service
				.getMidicineOutCheckVO(outcheckHql, 0, 10);
		if (midicineoutcheList == null || midicineoutcheList.size() <= 0) {
			map.put(Constants.PURCHASEORDERSTATE, "11");// 没有出口复核
			UtilJson.printMapJson(response, map);
			return null;
		} else {
			
		}
		return "";
	}

	@RequestMapping("/drugVarieties/ajaxQueryReceiveMidicine.html")
	public String ajaxQueryReceiveMidicine(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		// StringBuffer hqlBuffer = new
		// StringBuffer("select c from ReceivingNote as a , ReceivingNoteItem as b ,QualityMidicine as c  where a.id=b.receivingNoteId and b.qualifiedMedicineId = c.id and  c.useflag=0");
		StringBuffer hqlBuffer = new StringBuffer(
				"select new com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO(b,c) from ReceivingNote as a , ReceivingNoteItem as b ,QualityMidicine as c  where a.id=b.receivingNoteId and b.qualifiedMedicineId = c.id and  c.useflag=0 ");
		String yaopinyouxiaoqi = "";
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("<div class='out_tch' style='display:block;' onmouseout='childHideDiolag(this)' onmousemove='childShowDiolag(this)'><div class='outbox'><div class='outbox_con'><ul>");

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			}
		}
		List<ReceiveMidicineVO> midicineList = service.getReceiveMidicineVO(
				hqlBuffer.toString(), 0, 10);
		int index = 1;
		for (ReceiveMidicineVO midicine : midicineList) {
			String ypyxq = midicine.getQualityMidicine().getValiddate();// 药品有效期
			if (ypyxq != null
					&& DateTimeUtils.compareTwoDate(yaopinyouxiaoqi, ypyxq) >= 0) {

				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryReceiveMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getReceivingNoteItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "还有<font>" + days + "</font>天 到期</a></li>");
				} else {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryReceiveMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getReceivingNoteItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
				}
			}
		}
		buffer
				.append("</ul><span><a href='drugVarieties/queryReceiveMidicineMore.html'>显示更多</a>...</span></div></div><img src='images/out_j.gif' /></div>");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/drugVarieties/queryReceiveMidicineMore.html")
	public ModelAndView ajaxQueryReceiveMidicineMore(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		StringBuffer hqlBuffer = new StringBuffer(
				"select c from QualityMidicine as c where c.id in(select b.qualifiedMedicineId from  ReceivingNote as a , ReceivingNoteItem as b  where a.id=b.receivingNoteId  group by  b.qualifiedMedicineId ) and  c.useflag=0");
		String sql = "select count(*) from t_qualified_medicine as c where c.id in (select b.qualifiedMedicine_id from  t_receiving_note as  a join t_receiving_note_item as b on a.id=b.receiving_note_id group by b.qualifiedMedicine_id ) and  c.use_flag=0 ";
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				sql = sql + " and c.valid_date<='" + startDate + "'";
			}
		}
		List<QualityMidicine> midicineList = service.getAll(hqlBuffer
				.toString());

		// 获取总条数

		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", midicineList);

	}

	@RequestMapping("/drugVarieties/ajaxQueryAcceptMidicine.html")
	public String ajaxQueryAcceptMidicine(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		// StringBuffer hqlBuffer = new
		// StringBuffer("select c from CheckAcceptNote as a , CheckacceptItem as b ,QualityMidicine as c  where a.id=b.receivingId and b.qualifiedMedicineId = c.id and  c.useflag=0");
		StringBuffer hqlBuffer = new StringBuffer(
				"select new com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO(b,c) from CheckAcceptNote as a , CheckacceptItem as b ,QualityMidicine as c  where a.id=b.receivingId and b.qualifiedMedicineId = c.id and  c.useflag=0");
		// StringBuffer hqlBuffer = new
		// StringBuffer("select checkacceptItem.* ,qualityMidicine.* from t_check_accept_note as a , t_checkaccept_item as checkacceptItem ,t_qualified_medicine qualityMidicine where a.id = checkacceptItem.receiving_id and checkacceptItem.qualified_medicine_id = qualityMidicine.id and qualityMidicine.use_flag=0 ");
		String yaopinyouxiaoqi = "";
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("<div class='out_tch' style='display:block;' onmouseout='childHideDiolag(this)' onmousemove='childShowDiolag(this)'><div class='outbox'><div class='outbox_con'><ul>");

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			}
		}
		List<ChectAcceptMidicineVO> midicineList = service
				.getChectAcceptMidicineVO(hqlBuffer.toString(), 0, 10);
		int index = 1;
		for (ChectAcceptMidicineVO midicine : midicineList) {
			String ypyxq = midicine.getQualityMidicine().getValiddate();// 药品有效期
			if (ypyxq != null
					&& DateTimeUtils.compareTwoDate(yaopinyouxiaoqi, ypyxq) >= 0) {

				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryAcceptMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getCheckacceptItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "还有<font>" + days + "</font>天 到期</a></li>");
				} else {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryAcceptMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getCheckacceptItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
				}
			}
		}
		buffer
				.append("</ul><span><a href='drugVarieties/queryAcceptMidicineMore.html'>显示更多</a>...</span></div></div><img src='images/out_j.gif' /></div>");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/drugVarieties/queryAcceptMidicineMore.html")
	public ModelAndView ajaxQueryAcceptMidicineMore(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		StringBuffer hqlBuffer = new StringBuffer(
				"select c from QualityMidicine as c where c.id in(select b.qualifiedMedicineId from CheckAcceptNote as a , CheckacceptItem as b where a.id=b.receivingId  group by b.qualifiedMedicineId) and  c.useflag=0");
		String sql = "select count(*) from t_qualified_medicine as c where c.id in (select b.qualified_medicine_id from  t_check_accept_note as  a join t_checkaccept_item as b on a.id=b.receiving_id group by  b.qualified_medicine_id ) and c.use_flag=0 ";
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				sql = sql + " and c.valid_date<='" + startDate + "'";
			}
		}
		List<QualityMidicine> midicineList = service.getAll(hqlBuffer
				.toString());

		// 获取总条数

		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", midicineList);

	}

	/**
	 *查询 养护药品中过期药品
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/drugVarieties/ajaxQueryMaintainMidicine.html")
	public String ajaxQueryMaintainMidicine(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		// StringBuffer hqlBuffer = new
		// StringBuffer("select c from DrugMaintenance as a ,QualityMidicine as c  where a.qualifiedmedicineid=c.id and  c.useflag=0");
		StringBuffer hqlBuffer = new StringBuffer(
				"select new com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO(a,c) from DrugMaintenance as a ,QualityMidicine as c  where a.qualifiedmedicineid=c.id and  c.useflag=0 ");
		String yaopinyouxiaoqi = "";
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();

		buffer
				.append("<div class='out_tch' style='display:block;' onmouseout='childHideDiolag(this)' onmousemove='childShowDiolag(this)'><div class='outbox'><div class='outbox_con'><ul>");
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			}
		}
		List<MaintenanceMidicineVO> midicineList = service
				.getMaintenanceMidicineVO(hqlBuffer.toString(), 0, 10);
		int index = 1;
		for (MaintenanceMidicineVO midicine : midicineList) {
			String ypyxq = midicine.getQualityMidicine().getValiddate();// 药品有效期
			if (ypyxq != null
					&& DateTimeUtils.compareTwoDate(yaopinyouxiaoqi, ypyxq) >= 0) {

				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryMaintainMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getDrugMaintenance().getBatchnumber()
							+ "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "还有<font>" + days + "</font>天 到期</a></li>");
				} else {
					buffer
							.append("<li>"
									+ index++
									+ ".<a href='drugVarieties/queryMaintainMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getDrugMaintenance().getBatchnumber()
							+ "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
				}
			}
		}
		buffer
				.append("</ul><span><a href='drugVarieties/queryMaintainMidicineMore.html'>显示更多</a>...</span></div></div><img src='images/out_j.gif' /></div>");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/drugVarieties/queryMaintainMidicineMore.html")
	public ModelAndView ajaxQueryMaintainMidicineMore(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		StringBuffer hqlBuffer = new StringBuffer(
				"select c from QualityMidicine as c where c.id in (select a.qualifiedmedicineid from DrugMaintenance as a  group by a.qualifiedmedicineid) and  c.useflag=0");
		String sql = "select count(*) from t_qualified_medicine as c where c.id in(select a.qualified_medicine_id from t_maintain_info as  a  group by a.qualified_medicine_id ) and  c.use_flag=0 ";
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				sql = sql + " and c.valid_date<='" + startDate + "'";
			}
		}
		List<QualityMidicine> midicineList = service.getAll(hqlBuffer
				.toString());

		// 获取总条数

		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", midicineList);

	}

	@RequestMapping("/drugVarieties/ajaxQueryPurchaseOrderMidicine.html")
	public String ajaxQueryPurchaseOrderMidicine(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		// StringBuffer hqlBuffer = new
		// StringBuffer("select c from PurchaseOrder as a ,PurchaseOrderItem as b ,QualityMidicine as c  where a.id = b.purchaseOrderId and  b.qualifiedMedicineId=c.id and  c.useflag=0");
		StringBuffer hqlBuffer = new StringBuffer(
				"select new com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO(b,c) from PurchaseOrder as a ,PurchaseOrderItem as b ,QualityMidicine as c  where a.id = b.purchaseOrderId and  b.qualifiedMedicineId=c.id and  c.useflag=0 ");
		// StringBuffer hqlBuffer = new
		// StringBuffer("select  purchaseOrderItem.*, qualityMidicine.* from t_purchase_order as a ,t_purchase_order_item as purchaseOrderItem ,t_qualified_medicine as qualityMidicine  where a.id = purchaseOrderItem.purchase_order_id and  purchaseOrderItem.qualified_medicine_id=qualityMidicine.id and  qualityMidicine.use_flag=0");
		String yaopinyouxiaoqi = "";
		String nowdate = DateTimeUtils.getNowStrDate();
		StringBuffer buffer = new StringBuffer();
		
		buffer
				.append(
						"<div class='out_tch' style='display:block;' onmouseout='childHideDiolag(this)' onmousemove='childShowDiolag(this)'>")
				.append(" <div class='outbox'>");
		buffer.append("<div class='outbox_con'>").append("<ul>");

		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				yaopinyouxiaoqi = startDate;
			}
		}
		// hqlBuffer.append(" group by qualityMidicine.id,purchaseOrderItem.id");
		// List<QualityMidicine> midicineList =
		// service.findList(hqlBuffer.toString(),0,10);
		List<PurchaseOrderMidicineVO> midicineList = service
				.getPurchaseOrderMidicineVo(hqlBuffer.toString(), 0, 10);
		int index = 1;
		for (PurchaseOrderMidicineVO midicine : midicineList) {
			String ypyxq = midicine.getQualityMidicine().getValiddate();// 药品有效期
			if (ypyxq != null
					&& DateTimeUtils.compareTwoDate(yaopinyouxiaoqi, ypyxq) >= 0) {

				int days = DateTimeUtils.compareDateInterval(ypyxq, nowdate);
				if (days >= 0) {
					buffer
							.append("<li>" + index++)
							.append(
									".<a href='drugVarieties/queryPurchaseOrderMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getPurchaseOrderItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getCommonname()
							+ "还有<font>" + days + "</font>天 到期</a></li>");
				} else {
					buffer
							.append("<li>" + index++)
							.append(
									"<a href='drugVarieties/queryPurchaseOrderMidicineMore.html' traget='_blank'>");
					buffer.append("批号为"
							+ midicine.getPurchaseOrderItem()
									.getBatchProduction() + "的"
							+ midicine.getQualityMidicine().getTradename()
							+ "已过期<font>" + Math.abs(days)
							+ "</font>天</a></li>");
				}
			}
		}

		buffer.append("</ul>");
		buffer.append("<span><a href='javascript:void(0)'>显示更多</a>...</span>");
		buffer.append("</div></div><img src='images/out_j.gif'></div>");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", buffer.toString());
		UtilJson.printMapJson(response, map);

		return null;
	}

	@RequestMapping("/drugVarieties/queryPurchaseOrderMidicineMore.html")
	public ModelAndView ajaxQueryPurchaseOrderMidicineMore(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String page = DisplayGetPage
				.getPageParamName("qualifiedMedic", request);
		String configHql = " from  WarnConfig a where a.limit_name like 'yp%' and a.use_flag=0";
		List<WarnConfig> configList = configService.findList(configHql);
		// String hql =
		// "select c from ReceivingNote a join ReceivingNoteItem b on a.id=b.receivingNoteId join QualityMidicine c on b.qualifiedMedicineId = c.id ";
		// StringBuffer hqlBuffer = new
		// StringBuffer("select c from PurchaseOrder as a ,PurchaseOrderItem as b ,QualityMidicine as c  where a.id = b.purchaseOrderId and  b.qualifiedMedicineId=c.id and  c.useflag=0");
		StringBuffer hqlBuffer = new StringBuffer(
				"select c from QualityMidicine c where c.id in (select b.qualifiedMedicineId from PurchaseOrderItem b , PurchaseOrder a where a.id = b.purchaseOrderId group by b.qualifiedMedicineId)");
		// String sql
		// ="select count(*) from t_purchase_order  as  a join  t_purchase_order_item as b on a.id =b.purchase_order_id join t_qualified_medicine as c on b.qualified_medicine_id = c.id where c.use_flag=0 ";
		String sql = "select COUNT(*) from t_qualified_medicine c where id in(select b.qualified_medicine_id from t_purchase_order a join t_purchase_order_item b on a.id=b.purchase_order_id  group by b.qualified_medicine_id)";
		for (WarnConfig config : configList) {
			String startDate = DateTimeUtils.formCurrentDate(DateTimeUtils
					.getCalendar(Integer.valueOf(config.getLimit_day())));
			String limit_name = config.getLimit_name();
			if (limit_name != null && limit_name.equals("yp_valid_date")) {
				hqlBuffer.append(" and  c.validdate<='" + startDate + "'");
				sql = sql + " and c.valid_date<='" + startDate + "'";
			}
		}
		List<QualityMidicine> midicineList = service.getAll(hqlBuffer
				.toString());

		// 获取总条数

		int resultSize = service.getRecordCount(sql);
		model.addAttribute("resultSize", resultSize);
		model.addAttribute("pagesize", Constants.pagesize);
		// model.addAttribute("firstEnterpriseList", firstEnterpriseList);
		double size = resultSize;
		model.addAttribute("displayallpage", Math.ceil(size
				/ Constants.pagesize));
		model.addAttribute("thispage", Integer.parseInt(page));
		// List<QualifiedSuppliers> qualiSuppList =
		// qualifiedSuppliesService.getQualifiedSuppliersList(first, pageSize);
		return new ModelAndView("/arietyManage/qualifiedmedicinal/hgypda",
				"qualityMidicinesList", midicineList);

	}

	private String getMedicnalAttributeName(String attribute) {
		String name = "";
		if (attribute == null) {
			name = "null";
		} else if (attribute.equals("1")) {
			name = "常温品";
		} else if (attribute.equals("2")) {
			name = "阴凉品";
		} else if (attribute.equals("3")) {
			name = "麻黄碱制剂";
		}
		return name;
	}

	public ModelAndView ajaxQueryMedicineByBatchNo(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@RequestMapping("/drugVarieties/newQulidiedMedicinal.html")
	public String addNewQualityMedice(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		return "arietyManage/qualifiedmedicinal/add_hdypda";
	}

	@RequestMapping("/drugVarieties/reloadQulidiedMedicinal.html")
	public ModelAndView reloadQulifiedMedicinal(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		String qualityMeId = request.getParameter("qualityMeId");
		String p_id = request.getParameter("id");
		Long id = null;
		if (p_id != null && !p_id.trim().equals("")) {
			id = Long.valueOf(p_id);
		} else {
			id = Long.valueOf(0);
		}
		QualityMidicine qualityMidicine = service.get(id);
		model.addAttribute("qualityMidicine", qualityMidicine);
		model.addAttribute("qualityMeId", qualityMeId);
		return new ModelAndView("arietyManage/qualifiedmedicinal/add_hdypda");
	}

	@RequestMapping("/drugVarieties/saveQulidiedMedicinal.html")
	public String saveQueryMedicine(QualityMidicine qualityMidicine,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String dosageform = request.getParameter("dosageform");// 剂型
		String produce_no = request.getParameter("produce_no");// 生产企业
		String supply_unit = request.getParameter("supply_unit");// 供货单位
		String quality_standard = request.getParameter("quality_standard");
		//BasedCriteria basedCriteria = baService.get(Long
		//		.valueOf(quality_standard));
		DrugFormDictionary form = formService.get(Long.valueOf(dosageform));
		QualifiedSuppliers produceNo = supplyService.get(Long
				.valueOf(produce_no));
		QualifiedSuppliers supply = supplyService
				.get(Long.valueOf(supply_unit));
		qualityMidicine.setDosageforms(form);
		qualityMidicine.setProduceno(produceNo);
		qualityMidicine.setSupplyUnit(supply);
		qualityMidicine.setQualityStandardName(quality_standard);
		qualityMidicine.setUseflag(0);
		MultipartHttpServletRequest multRequest = (MultipartHttpServletRequest) request;
		batchUpload(multRequest, qualityMidicine);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			QualityMidicine qmMidicine = service.save(qualityMidicine);

			if (qmMidicine != null && qmMidicine.getId() > 0) {
				map.put("success", URLEncoder.encode("保存数据成功！","UTF-8"));
			} else {
				map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			}
			UtilJson.printMapJson(response, map);
		} catch (Exception e) {
			map.put("success", URLEncoder.encode("保存数据失败！","UTF-8"));
			UtilJson.printMapJson(response, map);
			e.printStackTrace();
		}
		return null;
	}
	private String getStatus(int type){
		String str = "";
		if(type==0){
			str = "启用";
		}else if(type==1){
			str="停用";
		}
		return str;
	}
}
