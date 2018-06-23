package com.sinosoft.drugState.acceptance.model;

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
@Table(name = "t_checkaccept_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class CheckacceptItem implements Serializable {

	/**
	id int NOT NULL,
	receiving_id int NOT NULL,    -- 收货单id 
	qualified_medicine_id int NOT NULL,    -- 合格药品id 
	produce_no int,    -- 生产厂商编号 
	common_name varchar(50),    -- 通用名称 
	dosage_forms varchar(20),    -- 剂型 
	specifications varchar(20),    -- 规格 
	license_number varchar(50),    -- 批准文号 
	quantity int,    -- 数量 
	qualified_quantity int    -- 合格数量 
	batch_production varchar(50)   ---生产批号
	end_time varchar(50) --有效期至
	unqualifiedAmount --不合格数量
	unqualifiedItems --不合格项
	returnGoods  --处理措施
	produce_time --生产日期
	 * **/
	private Long id;
	private Long receivingId;
	private Long qualifiedMedicineId;
	private Long produceNo;
	private String commonName;
	private String dosageForms;
	private String specifications;
	private String licenseNumber;
	private Long quantity;
	private Long qualifiedQuantity;
	private QualityMidicine qualityMidicine;
	private String batchProduction;
	private String endTime;
	private String unqualifiedAmount;
	private String unqualifiedItems;
	private String returnGoods;
	private String produceTime;
	@Column(name="produce_time",length=20)
	@SearchableProperty
	public String getProduceTime() {
		return produceTime;
	}
	public void setProduceTime(String produceTime) {
		this.produceTime = produceTime;
	}
	@Column(name="unqualified_amount",length=10)
	@SearchableProperty
	public String getUnqualifiedAmount() {
		return unqualifiedAmount;
	}
	public void setUnqualifiedAmount(String unqualifiedAmount) {
		this.unqualifiedAmount = unqualifiedAmount;
	}
	@Column(name="unqualified_items",length=100)
	@SearchableProperty
	public String getUnqualifiedItems() {
		return unqualifiedItems;
	}
	public void setUnqualifiedItems(String unqualifiedItems) {
		this.unqualifiedItems = unqualifiedItems;
	}
	@Column(name="return_goods",length=10)
	@SearchableProperty
	public String getReturnGoods() {
		return returnGoods;
	}
	public void setReturnGoods(String returnGoods) {
		this.returnGoods = returnGoods;
	}
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
	@Column(name="receiving_id")
	@SearchableProperty
	public Long getReceivingId() {
		return receivingId;
	}
	public void setReceivingId(Long receivingId) {
		this.receivingId = receivingId;
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
	@Column(name="dosage_forms",length=20)
	@SearchableProperty
	public String getDosageForms() {
		return dosageForms;
	}
	public void setDosageForms(String dosageForms) {
		this.dosageForms = dosageForms;
	}
	@Column(name="specifications",length=50)
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
	
}
