package com.sinosoft.drugState.purreturn.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_purchase_return_bill")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchaseReturnBill implements Serializable{
	/***
	id int NOT NULL,
	number varchar(20),    -- 编号 
	qualified_medicine_id int,    -- 合格药品id 
	qualifiedSupplier_id int,    -- 合格供应商id 
	return_reason varchar(50),    -- 退货原因 
	review_status tinyint,    -- 0 待录入 1 待审批 2 审批通过 3 驳回   
	proposer_ID int,    -- 申请人id 
	application_time datetime,    -- 申请时间 
	auditor_ID int,    -- 审核人id 
	review_time datetime    -- 审核时间 
	money  archar(20)  ---金额
	returnTime   --退出时间
	puMoney   --购进价格
	endTime   --有效期至
	manual_flag --购进退出手动生成标志,1表示手动录入
	state  --药品状态   a:合格；d:不合格；c：报废
	billType -- 
	 * **/
	private Long id;
	private String number;
	private Long qualifiedMedicineId;
	private Long qualifiedSupplierId;
	private String returnReason;
	private Long reviewStatus;
	private Long proposerID;
	private String applicationTime;
	private Long auditorID;
	private String reviewTime;
	private Long quantity;
	private String batchNumber;
	private String returnType;
	private String money;
	private String returnTime;
	private String puMoney;
	private String endTime;
	private String printFlag;//打印表示 ： 1表示已经打印 、其它表示为打印
	private String department;//部门
	private User user;
	private QualityMidicine qualityMidicine;
	private QualifiedSuppliers qualifiedSuppliers;
	private String manualFlag;//购进退出手动生成标志
	private String state;//库房标识
	@Column(name="return_time",length=20)
	@SearchableProperty
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	@Column(name="pu_money",length=20)
	@SearchableProperty
	public String getPuMoney() {
		return puMoney;
	}
	
	public void setPuMoney(String puMoney) {
		this.puMoney = puMoney;
	}
	@Column(name="end_time",length=20)
	@SearchableProperty
	public String getEndTime() {
		return endTime;
	}
	@Column(name="money",length=20)
	@SearchableProperty
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="money",length=20)
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
	public QualifiedSuppliers getQualifiedSuppliers() {
		return qualifiedSuppliers;
	}
	public void setQualifiedSuppliers(QualifiedSuppliers qualifiedSuppliers) {
		this.qualifiedSuppliers = qualifiedSuppliers;
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
	@Column(name="state",length=20)
	@SearchableProperty
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="qualifiedSupplier_id")
	@SearchableProperty
	public Long getQualifiedSupplierId() {
		return qualifiedSupplierId;
	}
	public void setQualifiedSupplierId(Long qualifiedSupplierId) {
		this.qualifiedSupplierId = qualifiedSupplierId;
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
	@Column(name="return_type",length=100)
	@SearchableProperty
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	@Column(name="print_flag",length=2)
	public String getPrintFlag() {
		return printFlag;
	}
	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}
	@Transient
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(name="manual_flag",length=2)
	public String getManualFlag() {
		return manualFlag;
	}
	public void setManualFlag(String manualFlag) {
		this.manualFlag = manualFlag;
	}
	
}
