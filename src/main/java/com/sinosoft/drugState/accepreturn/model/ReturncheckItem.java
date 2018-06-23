package com.sinosoft.drugState.accepreturn.model;

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

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_returncheck_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ReturncheckItem implements Serializable{
	/**
	return_check_id  NOT NULL,    -- 退货验收id 
	qualified_medicine_id int NOT NULL,    -- 合格药品id 
	produce_no int,    -- 生产厂商编号 
	common_name varchar(50),    -- 通用名称 
	dosage_forms varchar(20),    -- 剂型 
	specifications varchar(20),    -- 规格 
	license_number varchar(50),    -- 批准文号 
	quantity int,    -- 数量 
	qualified_quantity int    -- 合格数量 
	invalidQuantity;  int     --退回供应商数量
	batch_production varchar(50)   ---生产批号
	invalidQuantity;//退回供应商数量
	validateDate;//有效期至
	productionDate;//生产日期
	 * */
	
	private Long id;
	private Long returnCheckId;
	private Long qualifiedMedicineId;
	private Long produceNo;
	private String commonName;
	private String dosageForms;
	private String specifications;
	private String licenseNumber;
	private Long quantity;
	private Long qualifiedQuantity;
	private Long unqualifiedQuantity;
	private Long invalidQuantity;//退回供应商数量
	private String batchProduction;
	private String validateDate;//有效期至
	private String productionDate;//生产日期
	private QualityMidicine qualityMidicine;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="return_check_id")
	@SearchableProperty
	public Long getReturnCheckId() {
		return returnCheckId;
	}
	public void setReturnCheckId(Long returnCheckId) {
		this.returnCheckId = returnCheckId;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="produce_no")
	@SearchableProperty
	public Long getProduceNo() {
		return produceNo;
	}
	public void setProduceNo(Long produceNo) {
		this.produceNo = produceNo;
	}
	@Column(name="common_name",length=50)
	@SearchableProperty
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	@Column(name="dosage_forms",length=100)
	@SearchableProperty
	public String getDosageForms() {
		return dosageForms;
	}
	public void setDosageForms(String dosageForms) {
		this.dosageForms = dosageForms;
	}
	@Column(name="specifications",length=20)
	@SearchableProperty
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Column(name="license_number",length=50)
	@SearchableProperty
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="qualified_quantity")
	@SearchableProperty
	public Long getQualifiedQuantity() {
		return qualifiedQuantity;
	}
	public void setQualifiedQuantity(Long qualifiedQuantity) {
		this.qualifiedQuantity = qualifiedQuantity;
	}
	@Column(name="unqualified_quantity")
	public Long getUnqualifiedQuantity() {
		return unqualifiedQuantity;
	}
	public void setUnqualifiedQuantity(Long unqualifiedQuantity) {
		this.unqualifiedQuantity = unqualifiedQuantity;
	}
	
	@Column(name="invalid_quantity")
	public Long getInvalidQuantity() {
		return invalidQuantity;
	}
	public void setInvalidQuantity(Long invalidQuantity) {
		this.invalidQuantity = invalidQuantity;
	}
	@Column(name="batch_production",length=50)
	@SearchableProperty
	public String getBatchProduction() {
		return batchProduction;
	}
	public void setBatchProduction(String batchProduction) {
		this.batchProduction = batchProduction;
	}
	@Column(name="validateDate",length=20)
	public String getValidateDate() {
		return validateDate;
	}
	
	public void setValidateDate(String validateDate) {
		this.validateDate = validateDate;
	}
	@Column(name="productionDate",length=20)
	public String getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	
}
