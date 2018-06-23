package com.sinosoft.drugState.outcheck.model;

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
@SuppressWarnings("serial")
@Entity
@Table(name = "t_outbound_check_bill")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class OutboundCheckBill implements Serializable{
	
	/***
	id int NOT NULL,
	qualified_purchase_units_id int,    --  购货单位id 
	quality_situation varchar(20),    --  质量状况 
	remark varchar(100),    --  备注 
	review_status tinyint,    --  审核状态 
	proposer_ID int,    --  申请人id 
	application_time datetime,    --  申请时间 
	auditor_ID int,    --  审核人id 
	review_time datetime,    --  审核时间 
	data_mode varchar(20)    --  数据状态 
	salesNumber varchar(20)   ---销售单号
	saleTime varchar(20)  ---销售日期
	 * */
	private Long id;
	private Long qualifiedPurchaseUnitsId;
	private String qualitySituation;
	private String remark;
	private Long reviewStatus;
	private Long proposerID;//出库人
	private String applicationTime;
	private Long auditorID;//复核人
	private String reviewTime;
	private String dataMode;
	private String salesNumber;
	private String saleTime;
	private Long auditor2ID;//出库复核人2
	private QualifiedPurchaseUnits qualifiedPurchaseUnits;
	private User user;
	private String outLibraryDate;//出库日期
	private String salesFromNumber;//票据号
	@Column(name="sales_time",length=50)
	@SearchableProperty
	public String getSaleTime() {
		return saleTime;
	}
	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}
	@Column(name="sales_number")
	@SearchableProperty
	public String getSalesNumber() {
		return salesNumber;
	}
	public void setSalesNumber(String salesNumber) {
		this.salesNumber = salesNumber;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedPurchaseUnits getQualifiedPurchaseUnits() {
		return qualifiedPurchaseUnits;
	}
	public void setQualifiedPurchaseUnits(QualifiedPurchaseUnits qualifiedPurchaseUnits) {
		this.qualifiedPurchaseUnits = qualifiedPurchaseUnits;
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
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedPurchaseUnitsId() {
		return qualifiedPurchaseUnitsId;
	}
	public void setQualifiedPurchaseUnitsId(Long qualifiedPurchaseUnitsId) {
		this.qualifiedPurchaseUnitsId = qualifiedPurchaseUnitsId;
	}
	@Column(name="quality_situation",length=20)
	@SearchableProperty
	public String getQualitySituation() {
		return qualitySituation;
	}
	public void setQualitySituation(String qualitySituation) {
		this.qualitySituation = qualitySituation;
	}
	@Column(name="remark",length=200)
	@SearchableProperty
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@Column(name="out_library_date",length=20)
	public String getOutLibraryDate() {
		return outLibraryDate;
	}
	public void setOutLibraryDate(String outLibraryDate) {
		this.outLibraryDate = outLibraryDate;
	}
	@Column(name="sales_FromNumber")
	public String getSalesFromNumber() {
		return salesFromNumber;
	}
	public void setSalesFromNumber(String salesFromNumber) {
		this.salesFromNumber = salesFromNumber;
	}
	
	@Column(name="auditor2_ID")
	@SearchableProperty
	public Long getAuditor2ID() {
		return auditor2ID;
	}
	public void setAuditor2ID(Long auditor2ID) {
		this.auditor2ID = auditor2ID;
	}
}
