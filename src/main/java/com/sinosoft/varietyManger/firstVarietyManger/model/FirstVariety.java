package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 10:21:11 AM
 * 类说明  首营药品品种
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_first_medicine")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class FirstVariety implements Serializable {
	
	private Long id;//主键ID
	
	private String commonName;//通用名称
	
	private DrugFormDictionary dosageForms;//剂型ID
	
	private QualifiedSuppliers produceNo;//生产企业编号
	
	private String medicinalNo;//药品编号
	
	private String medicProductNo;//生产编号
	
	private String medicSpecifications;//质量规格
	
	private String specifications;//包装规格
	
	private String licenseNumber;//批准文号
	
	private BasedCriteria qualityStandard;//质量标准依据依据依据
	
	private String qualityStandardName;//质量标准依据名称
	
	private String function;//功能
	
	private String unit;//单位
	
	private String validDate;//有效期
	
	private Integer reviewStatus;//审核状态
	
	private Long proposerId;//申请人ID
	
	private Date applicationTime;//申请时间
	
	private Long auditorId;//审核人ID
	
	private Date reviewTime;//审核时间 
	
	private String  dataMode;//数据状态 
	
	private String applicationReason;//申请原因
	
	private String auditContent;//审核内容
	
	private String rejectReason;//驳回原因
	
	private String manufacturerLicensePath;//厂商证照路径
	
	private String registeredTrademarkPath;//注册商标路径
	
	private String approvalDocumentPath;//批准文件路径 
	
	private String qualityStandardPath;//质量标准依据依据依据路径 
	
	private String packingPath;//包装情况路径
	
	private String instructionsPath;//标签、说明书路径
	
	private String checkoutReportpath;//检验报告书路径
	
	private String medcRegistrApprovalPath; //药品注册批准文件路径
	
	private String medcRegistrApprovalDate;//药品注册批准文件到期日期
	
	private String drugCategor;//药品类别
	
	private String specialManagement;//特殊管理
	
	private String storageConditions;//存储条件
	
	private String storageStore;//存储库区
	
	private QualifiedSuppliers supplyUnit;//供货 单位
	
	private String registeredTrademarks;//注册商标
	
	private String departmentId;//销售公司ID 1001经营、2001新品、3001市场
	
	private String isfood;//是否为食品 0 药品 1 食品
	
	private String trusteeEnterprise;//受托方企业名称
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="commonName",length=50)
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	public DrugFormDictionary getDosageForms() {
		return dosageForms;
	}
	public void setDosageForms(DrugFormDictionary dosageForms) {
		this.dosageForms = dosageForms;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getProduceNo() {
		return produceNo;
	}
	public void setProduceNo(QualifiedSuppliers produceNo) {
		this.produceNo = produceNo;
	}
	@Column(name="medicinal_no",length=50)
	public String getMedicinalNo() {
		return medicinalNo;
	}
	public void setMedicinalNo(String medicinalNo) {
		this.medicinalNo = medicinalNo;
	}
	@Column(name="medicnal_product_no",length=50)
	public String getMedicProductNo() {
		return medicProductNo;
	}
	public void setMedicProductNo(String medicProductNo) {
		this.medicProductNo = medicProductNo;
	}
	@Column(name="medicnal_specifications",length=100)
	public String getMedicSpecifications() {
		return medicSpecifications;
	}
	public void setMedicSpecifications(String medicSpecifications) {
		this.medicSpecifications = medicSpecifications;
	}
	@Column(name="specifications",length=100)
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Column(name="license_number",length=50)
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	@Column(name="qualityStandard_name",length=100)
	public String getQualityStandardName() {
		return qualityStandardName;
	}
	public void setQualityStandardName(String qualityStandardName) {
		this.qualityStandardName = qualityStandardName;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public BasedCriteria getQualityStandard() {
		return qualityStandard;
	}
	public void setQualityStandard(BasedCriteria qualityStandard) {
		this.qualityStandard = qualityStandard;
	}
	@Column(name="feature",length=655)
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	@Column(name="unit",length=50)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name="valid_date",length=20)
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	@Column(name="review_status")
	public Integer getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Column(name="proposer_id")
	public Long getProposerId() {
		return proposerId;
	}
	public void setProposerId(Long proposerId) {
		this.proposerId = proposerId;
	}
	@Column(name="application_time")
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	@Column(name="auditor_id")
	public Long getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(Long auditorId) {
		this.auditorId = auditorId;
	}
	@Column(name="review_time")
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Column(name="data_mode" ,length=50)
	public String getDataMode() {
		return dataMode;
	}
	public void setDataMode(String dataMode) {
		this.dataMode = dataMode;
	}
	@Column(name="application_reason",length=655)
	public String getApplicationReason() {
		return applicationReason;
	}
	public void setApplicationReason(String applicationReason) {
		this.applicationReason = applicationReason;
	}
	@Column(name="audit_content",length=655)
	public String getAuditContent() {
		return auditContent;
	}
	public void setAuditContent(String auditContent) {
		this.auditContent = auditContent;
	}
	@Column(name="reject_reason",length=655)
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	@Column(name="manufacturer_license_path",length=100)
	public String getManufacturerLicensePath() {
		return manufacturerLicensePath;
	}
	public void setManufacturerLicensePath(String manufacturerLicensePath) {
		this.manufacturerLicensePath = manufacturerLicensePath;
	}
	@Column(name="registered_trademark_path",length=100)
	public String getRegisteredTrademarkPath() {
		return registeredTrademarkPath;
	}
	public void setRegisteredTrademarkPath(String registeredTrademarkPath) {
		this.registeredTrademarkPath = registeredTrademarkPath;
	}
	@Column(name="approval_document_path",length=100)
	public String getApprovalDocumentPath() {
		return approvalDocumentPath;
	}
	public void setApprovalDocumentPath(String approvalDocumentPath) {
		this.approvalDocumentPath = approvalDocumentPath;
	}
	@Column(name="quality_standard_path",length=100)
	public String getQualityStandardPath() {
		return qualityStandardPath;
	}
	public void setQualityStandardPath(String qualityStandardPath) {
		this.qualityStandardPath = qualityStandardPath;
	}
	@Column(name="packing_path",length=100)
	public String getPackingPath() {
		return packingPath;
	}
	public void setPackingPath(String packingPath) {
		this.packingPath = packingPath;
	}
	@Column(name="instructions_path",length=100)
	public String getInstructionsPath() {
		return instructionsPath;
	}
	public void setInstructionsPath(String instructionsPath) {
		this.instructionsPath = instructionsPath;
	}
	@Column(name="checkout_report_path",length=100)
	public String getCheckoutReportpath() {
		return checkoutReportpath;
	}
	public void setCheckoutReportpath(String checkoutReportpath) {
		this.checkoutReportpath = checkoutReportpath;
	}
	@Column(name="medc_registr_approval_path" ,length=100)
	public String getMedcRegistrApprovalPath() {
		return medcRegistrApprovalPath;
	}
	
	public void setMedcRegistrApprovalPath(String medcRegistrApprovalPath) {
		this.medcRegistrApprovalPath = medcRegistrApprovalPath;
	}
	@Column(name="medc_registr_approval_date",length=20)
	public String getMedcRegistrApprovalDate() {
		return medcRegistrApprovalDate;
	}
	public void setMedcRegistrApprovalDate(String medcRegistrApprovalDate) {
		this.medcRegistrApprovalDate = medcRegistrApprovalDate;
	}
	@Column(name="drug_categor",length=50)
	public String getDrugCategor() {
		return drugCategor;
	}
	public void setDrugCategor(String drugCategor) {
		this.drugCategor = drugCategor;
	}
	@Column(name="storage_conditions",length=50)
	public String getStorageConditions() {
		return storageConditions;
	}
	public void setStorageConditions(String storageConditions) {
		this.storageConditions = storageConditions;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getSupplyUnit() {
		return supplyUnit;
	}
	public void setSupplyUnit(QualifiedSuppliers supplyUnit) {
		this.supplyUnit = supplyUnit;
	}
	@Column(name="registered_trademarks",length=100)
	public String getRegisteredTrademarks() {
		return registeredTrademarks;
	}
	public void setRegisteredTrademarks(String registeredTrademarks) {
		this.registeredTrademarks = registeredTrademarks;
	}
	@Column(name="dp_id",length=20)
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Column(name="is_food",length=2)
	public String getIsfood() {
		return isfood;
	}
	public void setIsfood(String isfood) {
		this.isfood = isfood;
	}
	@Column(name="storage_store",length=50)
	public void setStorageStore(String storageStore) {
		this.storageStore = storageStore;
	}
	public String getStorageStore() {
		return storageStore;
	}
	@Column(name="special_management",length=50)
	public void setSpecialManagement(String specialManagement) {
		this.specialManagement = specialManagement;
	}
	public String getSpecialManagement() {
		return specialManagement;
	}
	@Column(name="trustee_enterprise",length=100)
	public String getTrusteeEnterprise() {
		return trusteeEnterprise;
	}
	public void setTrusteeEnterprise(String trusteeEnterprise) {
		this.trusteeEnterprise = trusteeEnterprise;
	}
	
}
