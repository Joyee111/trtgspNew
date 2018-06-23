package com.sinosoft.drugState.outcheck.model;

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
@Table(name = "t_outbound_check_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class OutboundCheckItem implements Serializable {
	/***
	id int NOT NULL,
	outbound_check_bill_id int,    --  出库复核单id 
	qualified_medicine_id int,    --  合格药品id 
	produce_no int,    --  生产厂商编号 
	common_name varchar(50),    --  通用名称 
	dosage_forms int,    --  剂型 
	specifications varchar(20),    --  规格 
	license_number varchar(50),    --  批准文号 
	quantity int,    --  数量 
	batch_no varchar(20)    --  批次 
	 * ****/
	private Long id;
	private Long outboundCheckBillId;
	private Long qualifiedMedicineId;
	private Long produceNo;
	private String commonName;
	private String dosageForms;
	private String specifications;
	private String licenseNumber;
	private Long quantity;
	private String batchNo;
	private String validityTime;
	private String tkdat;
	private QualityMidicine qualityMidicine;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="outbound_check_bill_id")
	@SearchableProperty
	public Long getOutboundCheckBillId() {
		return outboundCheckBillId;
	}
	public void setOutboundCheckBillId(Long outboundCheckBillId) {
		this.outboundCheckBillId = outboundCheckBillId;
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
	@Column(name="dosage_forms")
	@SearchableProperty
	public String getDosageForms() {
		return dosageForms;
	}
	public void setDosageForms(String dosageForms) {
		this.dosageForms = dosageForms;
	}
	@Column(name="specifications",length=100)
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
	@Column(name="batch_no",length=20)
	@SearchableProperty
	public String getBatchNo() {
		return batchNo;
	}
	@Column(name="validity_time",length=20)
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getValidityTime() {
		return validityTime;
	}
	public void setValidityTime(String validityTime) {
		this.validityTime = validityTime;
	}
	
	@Column(name="tkdat",length=20)
	public String getTkdat() {
		return tkdat;
	}
	public void setTkdat(String tkdat) {
		this.tkdat = tkdat;
	}
	


}
