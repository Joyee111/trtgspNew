package com.sinosoft.drugState.outcheck.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "trtss_sales_form_info")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TrtssSalesFormInfo implements Serializable{
	/**
	id  NOT NULL,
	qualified_purchase_units_id int,    -- 购货单位id 
	sales_form_no varchar(15),    -- 销售单号 
	department_id varchar(20),
	contract_no varchar(15),    -- 合同号 
	con_ware_no varchar(5),    -- 发货仓库号 
	trans_way_no varchar(2),    -- 运输方式代码 
	trans_corp_no varchar(2),    -- 运输单位 
	customer_id varchar(15),    -- 客户id 
	creater_id varchar(15),    -- 销售员 
	create_date datetime,    -- 开单时间 
	net_amount decimal(18,2),    -- 药品金额 
	tax_amount decimal(18,2),    -- 销售金额 
	total_amount decimal(18,2)    -- 价税合计 
	saleTIme   String 
	 * **/
	private Long id;
	private Long qualifiedPurchaseUnitsId;
	private String sqlesFormNo;
	private String departmentId;
	private String contractNo;
	private String conWareNo;
	private String transWayNo;
	private String transCorpNo;
	private String customerId;
	private String createrId;
	private Date createrDate;
	private BigDecimal netAmount;
	private BigDecimal taxAmount;
	private BigDecimal totalAmount;
	private String saleTime;
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
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedPurchaseUnitsId() {
		return qualifiedPurchaseUnitsId;
	}
	public void setQualifiedPurchaseUnitsId(Long qualifiedPurchaseUnitsId) {
		this.qualifiedPurchaseUnitsId = qualifiedPurchaseUnitsId;
	}
	@Column(name="sales_form_no",length=15)
	@SearchableProperty
	public String getSqlesFormNo() {
		return sqlesFormNo;
	}
	public void setSqlesFormNo(String sqlesFormNo) {
		this.sqlesFormNo = sqlesFormNo;
	}
	@Column(name="department_id",length=20)
	@SearchableProperty
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Column(name="contract_no",length=15)
	@SearchableProperty
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@Column(name="con_ware_no",length=5)
	@SearchableProperty
	public String getConWareNo() {
		return conWareNo;
	}
	public void setConWareNo(String conWareNo) {
		this.conWareNo = conWareNo;
	}
	@Column(name="trans_way_no",length=2)
	@SearchableProperty
	public String getTransWayNo() {
		return transWayNo;
	}
	public void setTransWayNo(String transWayNo) {
		this.transWayNo = transWayNo;
	}
	@Column(name="trans_corp_no",length=2)
	@SearchableProperty
	public String getTransCorpNo() {
		return transCorpNo;
	}
	public void setTransCorpNo(String transCorpNo) {
		this.transCorpNo = transCorpNo;
	}
	@Column(name="customer_id",length=15)
	@SearchableProperty
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column(name="creater_id",length=15)
	@SearchableProperty
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	@Column(name="create_date")
	@SearchableProperty
	public Date getCreaterDate() {
		return createrDate;
	}
	public void setCreaterDate(Date createrDate) {
		this.createrDate = createrDate;
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
	@Column(name="sale_time",length=20)
	@SearchableProperty
	public String getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}
}
