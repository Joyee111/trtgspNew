package com.sinosoft.drugState.recoverycell.model;

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

import com.sinosoft.user.User;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_recovery_sale_bill")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class RecoverySaleBill implements Serializable {
	/**
	id int NOT NULL,
	qualified_medicine_id int NOT NULL,    -- 合格药品id 
	company_id int NOT NULL,    -- 公司id 
	check_date datetime,    -- 检查日期 
	location varchar(50),    -- 存放地点 
	check_situation varchar(20),    -- 检查情况 
	review_status tinyint,    -- 审核状态 0 待录入 1 待审批 2 审批通过 3 驳回    
	proposer_ID int,    -- 申请人id 
	application_time datetime,    -- 申请时间 
	auditor_ID int,    -- 审核人id 
	review_time datetime,    -- 审核时间 
	data_mode varchar(20)    -- 数据状态 
	batchProduction varchar(20)   -----生产批号
	quantity ----数量
	 * **/
	
	private Long id;
	private Long qualifiedMedicineId;
	private String checkDate;
	private String location;
	private String checkSituation;
	private Long reviewStatus;
	private Long proposerID;
	private String applicationTime;
	private Long auditorID;
	private String reviewTime;
	private String dataMode;
	private String batchProduction;
	private User user;
	private String quantity;
	@Column(name="quantity",length=20)
	@SearchableProperty
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="check_date",length=20)
	@SearchableProperty
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	@Column(name="location",length=50)
	@SearchableProperty
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="check_situation",length=20)
	@SearchableProperty
	public String getCheckSituation() {
		return checkSituation;
	}
	public void setCheckSituation(String checkSituation) {
		this.checkSituation = checkSituation;
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
	@Column(name="batch_production",length=50)
	@SearchableProperty
	public String getBatchProduction() {
		return batchProduction;
	}
	public void setBatchProduction(String batchProduction) {
		this.batchProduction = batchProduction;
	}

}
