package com.sinosoft.drugState.accepreturn.model;

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
@SuppressWarnings("serial")
@Entity
@Table(name = "t_return_check_accept_note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ReturnCheckAcceptNote implements Serializable{
	/**
	id int NOT NULL,
	application_time datetime,    -- 申请时间 
	arrival_date datetime,    -- 到货日期 
	auditor_ID int,    -- 审核人ID 
	certificate varchar(20),    -- 合格证 
	check_accept_date datetime,    -- 验收日期 
	check_conclusion varchar(50),    -- 退货原因 
	data_mode varchar(20)    -- 数据状态 
	enddate datetime,    -- 有效期至 
	goods_clerk varchar(20),    -- 收货员 
	number varchar(12) NOT NULL,    -- 单据号 
	proposer_ID int,    -- 申请人id 
	report_no varchar(20)	--报告单号
	result varchar(50),    -- 验收结果 
	return_no varchar(20)	--退货单号’、
	review_status tinyint,    -- 0 待录入 1 待审批 2 审批通过 3 驳回  4已复检 5申请回退
	review_time datetime,    -- 审核时间 
	rollback varchar(1)     --是否回退过 1.是    其他.否
	visual_examination varchar(50) --复查结论
	qualified_purchase_units_id int,    -- 购货商id 
	recheckPersionId;//复检人员ID
	rejectFlag;//审核通过表示1、表示驳回表示  默认为NULL
	accepterId; //验收人
	checkAcceptDate2;//验收日期2
	result2;//验收结果2
	rollback ;
	 * */
	private Long id;
	private Long qualifiedPurchaseUnitsId;
	private String number;
	private String arrivalDate;
	private String checkAcceptDate;
	private String checkAcceptDate2;//验收日期2
	private String certificate;
	private String enddate;
	private String checkConclusion;
	private String goodsClerk;
	private String result;
	private String result2;//验收结果2
	private Long reviewStatus; // 0 待录入 1 待审批 2 审批通过 3 待特殊验收
	private Long proposerID;
	private Long accepterId; //验收人
	private Long recheckPersionId;//复检人员ID
	private String applicationTime;
	private Long auditorID;
	private String reviewTime;
	private String dataMode;
	private String returnNo;
	private String reportNo;
	private String visualExamination;
	private QualifiedPurchaseUnits qualifiedPurchaseUnits;
	private String rejectFlag;//审核通过表示1、表示驳回表示  默认为NULL
	private String rollback;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedPurchaseUnits getQualifiedPurchaseUnits() {
		return qualifiedPurchaseUnits;
	}
	public void setQualifiedPurchaseUnits(QualifiedPurchaseUnits qualifiedPurchaseUnits) {
		this.qualifiedPurchaseUnits = qualifiedPurchaseUnits;
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
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedPurchaseUnitsId() {
		return qualifiedPurchaseUnitsId;
	}
	public void setQualifiedPurchaseUnitsId(Long qualifiedPurchaseUnitsId) {
		this.qualifiedPurchaseUnitsId = qualifiedPurchaseUnitsId;
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
	@Column(name="certificate",length=20)
	@SearchableProperty
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	@Column(name="enddate")
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
	@Column(name="data_mode",length=20)
	@SearchableProperty
	public String getDataMode() {
		return dataMode;
	}
	public void setDataMode(String dataMode) {
		this.dataMode = dataMode;
	}
	@Column(name="return_no",length=20)
	@SearchableProperty
	public String getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}
	@Column(name="report_no",length=20)
	@SearchableProperty
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	@Column(name="visual_examination",length=50)
	@SearchableProperty
	public String getVisualExamination() {
		return visualExamination;
	}
	public void setVisualExamination(String visualExamination) {
		this.visualExamination = visualExamination;
	}
	@Column(name="recheck_persion_id")
	public Long getRecheckPersionId() {
		return recheckPersionId;
	}
	public void setRecheckPersionId(Long recheckPersionId) {
		this.recheckPersionId = recheckPersionId;
	}
	@Column(name="reject_flag",length=4)
	public String getRejectFlag() {
		return rejectFlag;
	}
	public void setRejectFlag(String rejectFlag) {
		this.rejectFlag = rejectFlag;
	}
	@Column(name="result2",length=50)
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getResult2() {
		return result2;
	}
	@Column(name="check_accept_date2",length=20)
	public void setCheckAcceptDate2(String checkAcceptDate2) {
		this.checkAcceptDate2 = checkAcceptDate2;
	}
	public String getCheckAcceptDate2() {
		return checkAcceptDate2;
	}
	@Column(name="accepter_id")
	public void setAccepterId(Long accepterId) {
		this.accepterId = accepterId;
	}
	public Long getAccepterId() {
		return accepterId;
	}
	
	@Column(name="roll_back", length=1)
	public String getRollback() {
		return rollback;
	}
	public void setRollback(String rollback) {
		this.rollback = rollback;
	}
	
	
}
