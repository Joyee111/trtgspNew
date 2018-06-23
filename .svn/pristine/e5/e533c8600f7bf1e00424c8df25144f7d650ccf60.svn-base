package com.sinosoft.drugState.outcheck.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "trtss_sales_items_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TrtssSalesItemsInfo implements Serializable{
	
	/**
	id int NOT NULL,
	trtss_sales_form_info_id int,    -- 销售单id 
	qualified_medicine_id int,    -- 合格药品id 
	sales_form_no varchar(15),    -- 销售单号 
	sales_item_no varchar(15),    -- 销售单明细号 
	department_id varchar(20),
	medc_no varchar(15) NOT NULL,    -- 药品号 
	batch_no varchar(250),    -- 批号 
	expire_date varchar(250),    -- 有效期 
	medc_num decimal(18,2),    -- 件数 
	quantity decimal(18,2),    -- 数量 
	sales_price decimal(18,2),    -- 单价 
	retail_price decimal(18,2),    -- 零售价 
	discount decimal(5,2),    -- 扣率 
	tax_percent decimal(5,2),    -- 税率 
	net_amount decimal(18,2),    -- 无税金额 
	tax_amount decimal(18,2),    -- 税额 
	total_amount decimal(18,2)    -- 价税合计 
	 **/
	private Long id;
	private Long trtssSalesFormInfoId;
	private Long  qualified_medicineId;
	private String salesFormNo;
	private String salesItemNo;
	private String departmentId;
	private String medcNo;
	private String batchNo;
	private String expireDate;
	private BigDecimal medcNum;
	private BigDecimal quantity;
	private BigDecimal salesPrice;
	private BigDecimal retailPrice;
	private BigDecimal discount;
	private BigDecimal taxPercent;
	private BigDecimal netAmount;
	private BigDecimal taxAmount;
	private BigDecimal totalAmount;
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
	@Column(name="trtss_sales_form_info_id")
	@SearchableProperty
	public Long getTrtssSalesFormInfoId() {
		return trtssSalesFormInfoId;
	}
	public void setTrtssSalesFormInfoId(Long trtssSalesFormInfoId) {
		this.trtssSalesFormInfoId = trtssSalesFormInfoId;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualified_medicineId() {
		return qualified_medicineId;
	}
	public void setQualified_medicineId(Long qualified_medicineId) {
		this.qualified_medicineId = qualified_medicineId;
	}
	@Column(name="sales_form_no",length=15)
	@SearchableProperty
	public String getSalesFormNo() {
		return salesFormNo;
	}
	public void setSalesFormNo(String salesFormNo) {
		this.salesFormNo = salesFormNo;
	}
	@Column(name="sales_item_no",length=15)
	@SearchableProperty
	public String getSalesItemNo() {
		return salesItemNo;
	}
	public void setSalesItemNo(String salesItemNo) {
		this.salesItemNo = salesItemNo;
	}
	@Column(name="department_id",length=20)
	@SearchableProperty
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Column(name="medc_no",length=15)
	@SearchableProperty
	public String getMedcNo() {
		return medcNo;
	}
	public void setMedcNo(String medcNo) {
		this.medcNo = medcNo;
	}
	@Column(name="batch_no",length=250)
	@SearchableProperty
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	@Column(name="expire_date",length=250)
	@SearchableProperty
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	@Column(name="medc_num")
	@SearchableProperty
	public BigDecimal getMedcNum() {
		return medcNum;
	}
	public void setMedcNum(BigDecimal medcNum) {
		this.medcNum = medcNum;
	}
	@Column(name="quantity")
	@SearchableProperty
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	@Column(name="sales_price")
	@SearchableProperty
	public BigDecimal getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	@Column(name="retail_price")
	@SearchableProperty
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	@Column(name="discount")
	@SearchableProperty
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	@Column(name="tax_percent")
	@SearchableProperty
	public BigDecimal getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(BigDecimal taxPercent) {
		this.taxPercent = taxPercent;
	}
	@Column(name="net_amount")
	@SearchableProperty
	public BigDecimal getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}
	@Column(name="tax_amount")
	@SearchableProperty
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	@Column(name="total_amount")
	@SearchableProperty
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
