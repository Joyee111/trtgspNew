package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;


import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_qualified_medicine ")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualityMidicine implements Serializable {// 合格 药品档案

	private long id;
	private Long firstmedicineid;// 首营药品
	private String commonname;// 通用名称
	private DrugFormDictionary dosageforms;// 剂型
	private String tradename;// 商品名
	private String medicinalNo;//药品号
	private String medicinalProductNo;//生产编号
	private String  massSpecifications;//药品规格
	private String specifications;// 包装规格
	private String licensenumber;// 批准文号
	private QualifiedSuppliers produceno;// 生产厂商编号
	//private BasedCriteria qualityStandard; // 质量标准依据依据依据
	private String  qualityStandardName;//质量标准依据民称
	private String unit; // 单位
	private String function;// 功能
	private String validdate;// varchar(10), -- 有效期
	private String manufacturerlicensepath;// varchar(50), -- 厂商证照路径
	private String registeredtrademarkpath;// varchar(50), -- 注册商标
	private String approvaldocumentpath;// varchar(50), -- 批准文件路径
	private String qualitystandardpath;// varchar(50), -- 质量标准依据依据依据路径
	private String checkoutreportpath;// varchar(50), -- 检验报告书路径

	private String packingpath;// varchar(50), -- 包装情况路径
	private String instructionspath;// varchar(50), -- 标签、说明书路径
	private Long modifiedpersonid;// int, -- 修改人id
	private String modifieddate;// datetime, -- 修改时间
	private String medicinecategory;// varchar(20), -- 药品类别
	private String medicineManagement;//药品特殊管理类别
	private int useflag;// varchar(12) DEFAULT 0 -- 停用标志 0 启用 1 停用
	private String medcRegistrApprovalPath; //药品注册批准文件路径
	private String medcRegistrApprovalDate;//药品注册批准文件到期日期
	private String maintainCycle;//养护周期
	private String medicinalAttribute;//存储条件
	private String storageStore;//存储库区
	private QualifiedSuppliers supplyUnit;//供货单位
	private String registeredTrademarks;
	private String departmentId;//销售公司ID 1001经营、2001新品、3001市场
	private String isfood;//是否食品 0 药品 1 食品
	private String trusteeEnterprise;//受托方企业名称


	public QualityMidicine() {

	}

	public QualityMidicine(FirstVariety firstVariety) {
		this.firstmedicineid = firstVariety.getId();
		this.commonname = firstVariety.getCommonName();
		this.medicinalNo = firstVariety.getMedicinalNo();
		this.medicinalProductNo = firstVariety.getMedicProductNo();
		this.massSpecifications =firstVariety.getMedicSpecifications();
		this.specifications = firstVariety.getSpecifications();
		this.dosageforms = firstVariety.getDosageForms();
		this.licensenumber = firstVariety.getLicenseNumber();
		//this.qualityStandard = firstVariety.getQualityStandard();
		this.qualityStandardName = firstVariety.getQualityStandardName();
		this.produceno = firstVariety.getProduceNo();
		this.validdate = firstVariety.getValidDate();
		this.manufacturerlicensepath = firstVariety
				.getManufacturerLicensePath();
		this.registeredtrademarkpath = firstVariety
				.getRegisteredTrademarkPath();
		this.approvaldocumentpath = firstVariety.getApprovalDocumentPath();
		this.qualitystandardpath = firstVariety.getQualityStandardPath();
		this.instructionspath = firstVariety.getInstructionsPath();
		this.packingpath = firstVariety.getPackingPath();
		this.checkoutreportpath = firstVariety.getCheckoutReportpath();
		this.function = firstVariety.getFunction();
		this.unit = firstVariety.getUnit();
		this.useflag = 0;
		this.medcRegistrApprovalPath = firstVariety.getMedcRegistrApprovalPath();
		this.medcRegistrApprovalDate =  firstVariety.getMedcRegistrApprovalDate();
		this.medicinecategory = firstVariety.getDrugCategor();
		this.medicinalAttribute = firstVariety.getStorageConditions();
		this.supplyUnit = firstVariety.getSupplyUnit();
		this.registeredTrademarks = firstVariety.getRegisteredTrademarks();
		this.departmentId = firstVariety.getDepartmentId();
		this.isfood = firstVariety.getIsfood();
		this.storageStore = firstVariety.getStorageStore();
		this.medicineManagement = firstVariety.getSpecialManagement();
		this.trusteeEnterprise = firstVariety.getTrusteeEnterprise();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@SearchableProperty
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name="qualityStandard_name",length=100)
	public String getQualityStandardName() {
		return qualityStandardName;
	}

	public void setQualityStandardName(String qualityStandardName) {
		this.qualityStandardName = qualityStandardName;
	}

	/*@ManyToOne(cascade=CascadeType.REFRESH)
	public BasedCriteria getQualityStandard() {
		return qualityStandard;
	}

	public void setQualityStandard(BasedCriteria qualityStandard) {
		this.qualityStandard = qualityStandard;
	}
*/
	@Column(name = "first_medicine_id")
	@SearchableProperty
	public Long getFirstmedicineid() {
		return firstmedicineid;
	}

	public void setFirstmedicineid(Long firstmedicineid) {
		this.firstmedicineid = firstmedicineid;
	}

	@Column(name = "common_name", length = 50)
	@SearchableProperty
	public String getCommonname() {
		return commonname;
	}

	public void setCommonname(String commonname) {
		this.commonname = commonname;
	}

	@ManyToOne(cascade = CascadeType.REFRESH)
	public DrugFormDictionary getDosageforms() {
		return dosageforms;
	}

	public void setDosageforms(DrugFormDictionary dosageforms) {
		this.dosageforms = dosageforms;
	}

	@Column(name = "trade_name", length = 50)
	@SearchableProperty
	public String getTradename() {
		return tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}
	@Column(name="medc_no",length=50)
	public String getMedicinalNo() {
		return medicinalNo;
	}

	public void setMedicinalNo(String medicinalNo) {
		this.medicinalNo = medicinalNo;
	}
	@Column(name="medc_production_no",length=50)
	public String getMedicinalProductNo() {
		return medicinalProductNo;
	}

	public void setMedicinalProductNo(String medicinalProductNo) {
		this.medicinalProductNo = medicinalProductNo;
	}
	@Column(name="mass_specifications",length=100)
	public String getMassSpecifications() {
		return massSpecifications;
	}

	public void setMassSpecifications(String massSpecifications) {
		this.massSpecifications = massSpecifications;
	}

	@Column(name = "specifications", length = 50)
	@SearchableProperty
	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Column(name = "license_number", length = 50)
	@SearchableProperty
	public String getLicensenumber() {
		return licensenumber;
	}

	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}

	@ManyToOne(cascade = CascadeType.REFRESH)
	public QualifiedSuppliers getProduceno() {
		return produceno;
	}

	public void setProduceno(QualifiedSuppliers produceno) {
		this.produceno = produceno;
	}

	@Column(name = "unit", length = 50)
	@SearchableProperty
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Column(name = "feature", length = 655)
	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Column(name = "valid_date", length = 50)
	@SearchableProperty
	public String getValiddate() {
		return validdate;
	}

	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}

	@Column(name = "manufacturer_license_path", length = 100)
	@SearchableProperty
	public String getManufacturerlicensepath() {
		return manufacturerlicensepath;
	}

	public void setManufacturerlicensepath(String manufacturerlicensepath) {
		this.manufacturerlicensepath = manufacturerlicensepath;
	}

	@Column(name = "registered_trademark_path", length = 100)
	@SearchableProperty
	public String getRegisteredtrademarkpath() {
		return registeredtrademarkpath;
	}

	public void setRegisteredtrademarkpath(String registeredtrademarkpath) {
		this.registeredtrademarkpath = registeredtrademarkpath;
	}

	@Column(name = "approval_document_path", length = 100)
	@SearchableProperty
	public String getApprovaldocumentpath() {
		return approvaldocumentpath;
	}

	public void setApprovaldocumentpath(String approvaldocumentpath) {
		this.approvaldocumentpath = approvaldocumentpath;
	}

	@Column(name = "quality_standard_path", length = 100)
	@SearchableProperty
	public String getQualitystandardpath() {
		return qualitystandardpath;
	}

	public void setQualitystandardpath(String qualitystandardpath) {
		this.qualitystandardpath = qualitystandardpath;
	}

	@Column(name = "checkout_report_path", length = 100)
	@SearchableProperty
	public String getCheckoutreportpath() {
		return checkoutreportpath;
	}

	public void setCheckoutreportpath(String checkoutreportpath) {
		this.checkoutreportpath = checkoutreportpath;
	}

	@Column(name = "packing_path", length = 100)
	@SearchableProperty
	public String getPackingpath() {
		return packingpath;
	}

	public void setPackingpath(String packingpath) {
		this.packingpath = packingpath;
	}

	@Column(name = "instructions_path", length = 100)
	@SearchableProperty
	public String getInstructionspath() {
		return instructionspath;
	}

	public void setInstructionspath(String instructionspath) {
		this.instructionspath = instructionspath;
	}

	@Column(name = "modified_person_id")
	@SearchableProperty
	public Long getModifiedpersonid() {
		return modifiedpersonid;
	}

	public void setModifiedpersonid(Long modifiedpersonid) {
		this.modifiedpersonid = modifiedpersonid;
	}

	@Column(name = "modified_date", length = 20)
	@SearchableProperty
	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	@Column(name = "medicine_category", length = 50)
	@SearchableProperty
	public String getMedicinecategory() {
		return medicinecategory;
	}

	public void setMedicinecategory(String medicinecategory) {
		this.medicinecategory = medicinecategory;
	}

	@Column(name = "use_flag")
	@SearchableProperty
	public int getUseflag() {
		return useflag;
	}

	public void setUseflag(int useflag) {
		this.useflag = useflag;
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
	@Column(name="maintain_cycle",length=50)
	public String getMaintainCycle() {
		return maintainCycle;
	}

	public void setMaintainCycle(String maintainCycle) {
		this.maintainCycle = maintainCycle;
	}
	@Column(name="medicinal_attribute",length=50)
	public String getMedicinalAttribute() {
		return medicinalAttribute;
	}

	public void setMedicinalAttribute(String medicinalAttribute) {
		this.medicinalAttribute = medicinalAttribute;
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
	@Column(name="storage_store",length = 50)
	public void setStorageStore(String storageStore) {
		this.storageStore = storageStore;
	}

	public String getStorageStore() {
		return storageStore;
	}
	@Column(name="medicine_management",length = 50)
	public void setMedicineManagement(String medicineManagement) {
		this.medicineManagement = medicineManagement;
	}

	public String getMedicineManagement() {
		return medicineManagement;
	}
	@Column(name="trustee_enterprise",length=100)
	public String getTrusteeEnterprise() {
		return trusteeEnterprise;
	}

	public void setTrusteeEnterprise(String trusteeEnterprise) {
		this.trusteeEnterprise = trusteeEnterprise;
	}
	
}
