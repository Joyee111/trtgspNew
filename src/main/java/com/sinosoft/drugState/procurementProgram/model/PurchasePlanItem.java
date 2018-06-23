package com.sinosoft.drugState.procurementProgram.model;

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
@Table(name = "t_purchase_plan_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchasePlanItem implements Serializable{
	/***
	id int NOT NULL,
	purchase_plan_order int,    -- 计划单id 
	qualified_medicine_id int,    -- 合格药品id 
	common_name varchar(50),    -- 通用名称 
	specifications varchar(50),    -- 规格 
	quantity int,    -- 数量 
	remark varchar(100),    -- 备注 
	plan_type varchar(2)    -- 计划类别
	money varchar(10)		----金额	
	taxPrice  varchar(10)   --批发价
	 * **/
	private Long id;
	private Long purchasePlanOrder;
	private Long qualifiedMedicineId;
	private String commonName;
	private String specifications;
	private String quantity;
	private String remark;
	private String planType;
	private String taxPrice;
	private String deductionRate;//扣率
	private PurchasePlan purchasePlan;
	private QualityMidicine qualityMidicine;
	private String money;
	@Column(name="money",length=10)
	@SearchableProperty	
	public String getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(String taxPrice) {
		this.taxPrice = taxPrice;
	}
	@Column(name="tax_price",length=10)
	@SearchableProperty	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public PurchasePlan getPurchasePlan() {
		return purchasePlan;
	}
	public void setPurchasePlan(PurchasePlan purchasePlan) {
		this.purchasePlan = purchasePlan;
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
	@Column(name="purchase_plan_order")
	@SearchableProperty
	public Long getPurchasePlanOrder() {
		return purchasePlanOrder;
	}
	public void setPurchasePlanOrder(Long purchasePlanOrder) {
		this.purchasePlanOrder = purchasePlanOrder;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="common_name",length=50)
	@SearchableProperty
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	@Column(name="specifications",length=50)
	@SearchableProperty
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Column(name="quantity")
	@SearchableProperty
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name="remark",length=100)
	@SearchableProperty
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="plan_type",length=2)
	@SearchableProperty
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	@Column(name="deduction_rate",length=100)
	public String getDeductionRate() {
		return deductionRate;
	}
	public void setDeductionRate(String deductionRate) {
		this.deductionRate = deductionRate;
	}
	
}
