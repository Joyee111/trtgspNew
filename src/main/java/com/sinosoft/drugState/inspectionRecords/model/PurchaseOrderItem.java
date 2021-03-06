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
@Table(name = "t_purchase_order_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchaseOrderItem implements Serializable{
	
	/**
	id int NOT NULL,
	purchase_order_id  NOT NULL,    -- 采购单id 
	qualified_medicine_id int,    -- 合格药品id 
	produce_no int,    -- 生产厂商编号 
	common_name varchar(50),    -- 通用名称 
	dosage_forms String,    -- 剂型 
	specifications varchar(50),    -- 规格 
	license_number varchar(50),    -- 批准文号 
	quantity int,    -- 数量 
	batch_production varchar(50)    -- 生产批号 
	tkdat	varchar(50) 			--生产日期
	end_time varchar(50)	--有效期至
	erp_flag varchar(10)    --中间表中标示
	uploadFlag int    --上传标记
	* */
	private Long id ;
	private Long purchaseOrderId;
	private Long qualifiedMedicineId;
	private Long produceNo;
	private String commonName;
	private Long dosageForms;
	private String specifications;
	private String licenseNumber;
	private Long quantity;
	private Long actualReceivedQuantity;//实际收货数量
	private String batchProduction;
	private String endTime;
	private String money;
	private String taxPrice;
	private String rate;
	private String tkdat;
	private Long flag;
	private String erp_flag;
	private Integer uploadFlag;
	
	@Column(name="upload_flag",length=10)
	@SearchableProperty	
	public Integer getUploadFlag() {
		return uploadFlag;
	}
	public void setUploadFlag(Integer uploadFlag) {
		this.uploadFlag = uploadFlag;
	}
	@Column(name="erp_flag",length=10)
	@SearchableProperty
	public String getErp_flag() {
		return erp_flag;
	}
	public void setErp_flag(String erpFlag) {
		erp_flag = erpFlag;
	}
	@Column(name="tkdat",length=50)
	@SearchableProperty
	public String getTkdat() {
		return tkdat;
	}
	public void setTkdat(String tkdat) {
		this.tkdat = tkdat;
	}
	
	@Column(name="tax_price",length=10)
	@SearchableProperty
	public String getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(String taxPrice) {
		this.taxPrice = taxPrice;
	}
	@Column(name="rate",length=10)
	@SearchableProperty
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Column(name="money",length=10)
	@SearchableProperty
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
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
	@Column(name="purchase_order_id")
	@SearchableProperty
	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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
	public Long getDosageForms() {
		return dosageForms;
	}
	public void setDosageForms(Long dosageForms) {
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
	@Column(name="actual_received_quantity")
	@SearchableProperty
	public Long getActualReceivedQuantity() {
		return actualReceivedQuantity;
	}
	public void setActualReceivedQuantity(Long actualReceivedQuantity) {
		this.actualReceivedQuantity= actualReceivedQuantity;
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
	public boolean equals(Object item ){
		if( !(item instanceof PurchaseOrderItem)){
			return false;
		}
		return this.getId() == ((PurchaseOrderItem)item).getId();
	}
	public int hashCode(){
		return this.getId().intValue()*17;
	}
	
	@Column(name="flag")
	@SearchableProperty
	public Long getFlag() {
		return flag;
	}
	public void setFlag(Long flag) {
		this.flag = flag;
	}
	
}
