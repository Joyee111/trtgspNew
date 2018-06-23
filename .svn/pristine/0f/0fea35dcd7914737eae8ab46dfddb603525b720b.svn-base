package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
/**
 * 
* @ClassName: ProcurementStaff 
* @author lfl
* @date 2013-7-11 上午11:14:38 
* @Description: TODO(采购人员)
 */
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("serial")
@Entity
@Table(name="t_procurement_staff")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ProcurementStaff implements Serializable {
	
	private long id;//主键ID
	private String procurementName;//采购人员名称
	private String gender;//性别
	private String birthday;//出生日期
	private String IDNumber;//身份证号
	private String powerOfAttorneyPath;//法人委托书路径
	private String powerOfAttorneyDate;//法人委托书到期日期
	private String identityCardPath;//身份证路径
	private String identityCardDate;//身份证有效期
	private String reviewStatus;//状态 0 待录入 1 待审批 2 审批通过 3 驳回
	private Long proposerID;//申请人ID
	private Long auditor_ID;//审核人ID 
	private Date applicationTime;//申请时间
	private Date reviewTime;//审核时间
	private String pinyinCode;//拼音码
	private String reject_reason;//驳回原因
	private String personType;//人员类型 0表示采购人员、1表示提货人员
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="procurement_name",length=50)
	public String getProcurementName() {
		return procurementName;
	}
	public void setProcurementName(String procurementName) {
		this.procurementName = procurementName;
	}
	@Column(name="gender",length=10)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="birthday",length=20)
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Column(name="IDNumber",length=25)
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	@Column(name="powerof_attorney_path",length=100)
	public String getPowerOfAttorneyPath() {
		return powerOfAttorneyPath;
	}
	public void setPowerOfAttorneyPath(String powerOfAttorneyPath) {
		this.powerOfAttorneyPath = powerOfAttorneyPath;
	}
	@Column(name="powerof_attorney_date",length=20)
	public String getPowerOfAttorneyDate() {
		return powerOfAttorneyDate;
	}
	public void setPowerOfAttorneyDate(String powerOfAttorneyDate) {
		this.powerOfAttorneyDate = powerOfAttorneyDate;
	}
	@Column(name="identitycard_path",length=100)
	public String getIdentityCardPath() {
		return identityCardPath;
	}
	public void setIdentityCardPath(String identityCardPath) {
		this.identityCardPath = identityCardPath;
	}
	@Column(name="identitycard_date")
	public String getIdentityCardDate() {
		return identityCardDate;
	}
	public void setIdentityCardDate(String identityCardDate) {
		this.identityCardDate = identityCardDate;
	}
	@Column(name="review_status",length=5)
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Column(name="proposer_id")
	public Long getProposerID() {
		return proposerID;
	}
	public void setProposerID(Long proposerID) {
		this.proposerID = proposerID;
	}
	@Column(name="auditor_id")
	public Long getAuditor_ID() {
		return auditor_ID;
	}
	public void setAuditor_ID(Long auditorID) {
		auditor_ID = auditorID;
	}
	@Column(name="application_time")
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	@Column(name="review_time")
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Column(name="pinyinCode",length=20)
	public String getPinyinCode() {
		return pinyinCode;
	}
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	@Column(name="reject_reason",length=655)
	public String getReject_reason() {
		return reject_reason;
	}
	public void setReject_reason(String rejectReason) {
		reject_reason = rejectReason;
	}
	@Column(name="person_type",length=2)
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	

}
