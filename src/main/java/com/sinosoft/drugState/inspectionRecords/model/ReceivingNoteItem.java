package com.sinosoft.drugState.inspectionRecords.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_receiving_note_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ReceivingNoteItem  implements Serializable{
	/***
	receiving_note_id  NOT NULL,    -- 收货单id 
	qualified_medicine_id int NOT NULL,    -- 合格药品id 
	produce_no varchar(2),    -- 生产厂商编号 
	common_name varchar(50),    -- 通用名称 
	dosage_forms varchar(20),    -- 剂型 
	specifications varchar(20),    -- 规格 
	license_number varchar(50),    -- 批准文号 
	quantity int    -- 数量 
	batch_production varchar(50)   ---生产批号
	end_time varchar(50)  --有效期至
	 ***/
	private Long id;
	private Long receivingNoteId;
	private Long qualifiedMedicineId;
	private String produceNo;
	private String commonName;
	private String dosageForms;
	private String specifications;
	private String licenseNumber;
	private Long quantity;
	private String batchProduction;
	private String endTime;
	private String tkdat;
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
	@Column(name="receiving_note_id")
	@SearchableProperty
	public Long getReceivingNoteId() {
		return receivingNoteId;
	}
	public void setReceivingNoteId(Long receivingNoteId) {
		this.receivingNoteId = receivingNoteId;
	}
	@Column(name="qualifiedMedicine_id")
	@SearchableProperty
//	@ManyToOne(cascade=CascadeType.REFRESH)
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="produce_no",length=2)
	@SearchableProperty
	public String getProduceNo() {
		return produceNo;
	}
	public void setProduceNo(String produceNo) {
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
	@Column(name="batch_production",length=50)
	@SearchableProperty
	public String getBatchProduction() {
		return batchProduction;
	}
	public void setBatchProduction(String batchProduction) {
		this.batchProduction = batchProduction;
	}
	@Column(name="end_time",length=50)
	@SearchableProperty
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="tkdat",length=50)
	@SearchableProperty
	public String getTkdat() {
		return tkdat;
	}
	public void setTkdat(String tkdat) {
		this.tkdat = tkdat;
	}
	
	
	
}
