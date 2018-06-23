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

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_check_accept_note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class CheckAcceptNote implements Serializable{
	
	/**
	id int NOT NULL,
	qualifiedSupplier_id int,    -- 合格供应商id 
	number varchar(12),    -- 单据号 
	arrival_date datetime,    -- 到货日期 
	check_accept_date datetime,    -- 验收日期 
	certificate varchar(20),    -- 合格证 
	enddate datetime,    -- 有效期至 
	check_conclusion varchar(50),    -- 检查结论 
	goods_clerk varchar(20),    -- 收货员 
	result varchar(50),    -- 处理结果 
	review_status tinyint,    -- 0 待录入 1 待审批 2 审批通过 3 驳回 
	proposer_ID int,    -- 申请人id，验收人id
	application_time datetime,    -- 申请时间 
	auditor_ID int,    -- 审核人ID 
	review_time datetime    -- 审核时间 
	receiving_number	--收货单号
	 * **/
	private Long id;
	private Long qualifiedSupplierId;
	private String number;
	private String arrivalDate;
	private String checkAcceptDate;//验收日期
	private String checkAcceptDate2;//验收日期2
	private String certificate;
	private String enddate;
	private String checkConclusion;//验收结论
	private String checkConclusion2;//验收结论2
	private String goodsClerk;
	private String result;//处理结果
	private String result2;//处理结果2
	private Integer reviewStatus;//0表示待录入1表示审核2表示待确认3表示确认
	private Long proposerID;//申请人，验收人
	private Long accepterID;//验收人2
	private String applicationTime;//申请时间，保存验收单时的时间
	private Long auditorID;//审核人
	private String reviewTime;
	private String receivingNumber;
	private String visualExamination;
	private String checkIsQualified;//检查是否合格	0合格,1不合格
	private String checkIsQualified2;//检查是否合格2
	private String  printFlag;//打印标识 1表示已打印
	private QualifiedSuppliers qualifiedSupplierIds;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getQualifiedSupplierIds() {
		return qualifiedSupplierIds;
	}
	public void setQualifiedSupplierIds(QualifiedSuppliers qualifiedSupplierIds) {
		this.qualifiedSupplierIds = qualifiedSupplierIds;
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
	@Column(name="qualifiedSupplier_id")
	@SearchableProperty
	public Long getQualifiedSupplierId() {
		return qualifiedSupplierId;
	}
	public void setQualifiedSupplierId(Long qualifiedSupplierId) {
		this.qualifiedSupplierId = qualifiedSupplierId;
	}
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="arrival_date",length=20)
	@SearchableProperty
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Column(name="check_accept_date",length=20)
	@SearchableProperty
	public String getCheckAcceptDate() {
		return checkAcceptDate;
	}
	public void setCheckAcceptDate(String checkAcceptDate) {
		this.checkAcceptDate = checkAcceptDate;
	}
	@Column(name="certificate")
	@SearchableProperty
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	@Column(name="enddate",length=20)
	@SearchableProperty
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	@Column(name="check_conclusion",length=50)
	@SearchableProperty
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}
	@Column(name="goods_clerk",length=20)
	@SearchableProperty
	public String getGoodsClerk() {
		return goodsClerk;
	}
	public void setGoodsClerk(String goodsClerk) {
		this.goodsClerk = goodsClerk;
	}
	@Column(name="result",length=50)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="review_status")
	@SearchableProperty
	public Integer getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Integer reviewStatus) {
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
	@Column(name="review_time")
	@SearchableProperty
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Column(name="receiving_number",length=20)
	@SearchableProperty
	public String getReceivingNumber() {
		return receivingNumber;
	}
	public void setReceivingNumber(String receivingNumber) {
		this.receivingNumber = receivingNumber;
	}
	@Column(name="getVisual_examination",length=20)
	@SearchableProperty
	public String getVisualExamination() {
		return visualExamination;
	}
	public void setVisualExamination(String visualExamination) {
		this.visualExamination = visualExamination;
	}
	@Column(name="check_qualified")
	public String getCheckIsQualified() {
		return checkIsQualified;
	}
	public void setCheckIsQualified(String checkIsQualified) {
		this.checkIsQualified = checkIsQualified;
	}
	@Column(name="print_flag",length=2)
	public String getPrintFlag() {
		return printFlag;
	}
	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}
	@Column(name="check_accept_date2",length=20)
	public void setCheckAcceptDate2(String checkAcceptDate2) {
		this.checkAcceptDate2 = checkAcceptDate2;
	}
	public String getCheckAcceptDate2() {
		return checkAcceptDate2;
	}
	@Column(name="check_conclusion2",length=50)
	public void setCheckConclusion2(String checkConclusion2) {
		this.checkConclusion2 = checkConclusion2;
	}
	public String getCheckConclusion2() {
		return checkConclusion2;
	}
	
	@Column(name="accepter_ID")
	public void setAccepterID(Long accepterID) {
		this.accepterID = accepterID;
	}
	public Long getAccepterID() {
		return accepterID;
	}
	@Column(name="result2",length=50)
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getResult2() {
		return result2;
	}
	@Column(name="check_qualified2")
	public void setCheckIsQualified2(String checkIsQualified2) {
		this.checkIsQualified2 = checkIsQualified2;
	}
	public String getCheckIsQualified2() {
		return checkIsQualified2;
	}
	
	
}
