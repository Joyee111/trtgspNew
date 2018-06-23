package com.sinosoft.drugState.salereturn.model;

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

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_sale_return_bill")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class SaleReturnBill implements Serializable{
	/***
	id int NOT NULL,
	number varchar(20),    -- 编号 
	qualified_medicine_id int,    -- 合格药品id 
	qualified_purchase_units_id int,    -- 购货商id 
	return_reason varchar(50),    -- 退货原因 
	review_status tinyint,    -- 0 待录入 1 待审批 2 审批通过 3 驳回    
	proposer_ID int,    -- 申请人id 
	application_time datetime,    -- 申请时间 
	auditor_ID int,    -- 审核人id 
	review_time datetime    -- 审核时间 
	quantity Long 	数量
	batch_number varchar（50）生产批号
	return_type varchar(50) 退货类型
	 * **/
	private Long id;
	private String number;
	private Long qualifiedMedicineId;
	private Long qualifiedPurchaseUnitsId;
	private String returnReason;
	private Long reviewStatus;
	private Long proposerID;
	private String applicationTime;
	private Long auditorID;
	private String reviewTime;
	private Long quantity;
	private String batchNumber;
	private String returnType;
	private User user;
	private QualityMidicine qualityMidicine;
	private QualifiedPurchaseUnits qualifiedPurchaseUnits;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedPurchaseUnits getQualifiedPurchaseUnits() {
		return qualifiedPurchaseUnits;
	}
	public void setQualifiedPurchaseUnits(QualifiedPurchaseUnits qualifiedPurchaseUnits) {
		this.qualifiedPurchaseUnits = qualifiedPurchaseUnits;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedPurchaseUnitsId() {
		return qualifiedPurchaseUnitsId;
	}
	public void setQualifiedPurchaseUnitsId(Long qualifiedPurchaseUnitsId) {
		this.qualifiedPurchaseUnitsId = qualifiedPurchaseUnitsId;
	}
	@Column(name="return_reason",length=50)
	@SearchableProperty
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	@Column(name="review_status")
	@SearchableProperty
	public Long getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Long reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Column(name="proposer_ID")
	@SearchableProperty
	public Long getProposerID() {
		return proposerID;
	}
	public void setProposerID(Long proposerID) {
		this.proposerID = proposerID;
	}
	@Column(name="application_time",length=20)
	@SearchableProperty
	public String getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}
	@Column(name="auditor_ID")
	@SearchableProperty
	public Long getAuditorID() {
		return auditorID;
	}
	public void setAuditorID(Long auditorID) {
		this.auditorID = auditorID;
	}
	@Column(name="review_time",length=20)
	@SearchableProperty
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_number",length=50)
	@SearchableProperty
	public String getBatchNumber() {
		return batchNumber;
	}
	
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	@Column(name="return_type",length=50)
	@SearchableProperty
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	
}
