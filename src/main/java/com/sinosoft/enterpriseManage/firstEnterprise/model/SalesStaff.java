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
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings("serial")
@Entity
@Table(name="t_salesstaff")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class SalesStaff implements Serializable {
	private long id;//主键ID
	private String saleName;//销售人员名称
	private String gender;//性别
	private String birthday;//出生日期
	private String IDNumber;//身份证号
	private String telephone;//电话
	private String powerOfAttorneyPath;//法人委托书路径
	private String powerOfAttorneyDate;//法人委托书到期日期
	private String identityCardPath;//身份证路径
	private String identityCardDate;//身份证有效期
	private String trainingCertificatePath;//药品推销员培训证书路径
	private String trainingCertificateDate;//药品推销员培训证书有效期
	private String reviewStatus;//状态 0 待录入 1 待审批 2 审批通过 3 驳回
	private Long proposerID;//申请人ID
	private Long auditor_ID;//审核人ID 
	private Date applicationTime;//申请时间
	private Date reviewTime;//审核时间
	private String pinyinCode;//拼音码
	private String reject_reason;//驳回原因
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="sale_name",length=50)
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	@Column(name="gender",length=5)
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
	@Column(name="ID_number",length=20)
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	@Column(name="telephone",length=50)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(name="power_of_attorney_path",length=100)
	public String getPowerOfAttorneyPath() {
		return powerOfAttorneyPath;
	}
	public void setPowerOfAttorneyPath(String powerOfAttorneyPath) {
		this.powerOfAttorneyPath = powerOfAttorneyPath;
	}
	@Column(name="power_of_Attorney_date",length=20)
	public String getPowerOfAttorneyDate() {
		return powerOfAttorneyDate;
	}
	public void setPowerOfAttorneyDate(String powerOfAttorneyDate) {
		this.powerOfAttorneyDate = powerOfAttorneyDate;
	}
	@Column(name="identity_card_path",length=100)
	public String getIdentityCardPath() {
		return identityCardPath;
	}
	public void setIdentityCardPath(String identityCardPath) {
		this.identityCardPath = identityCardPath;
	}
	@Column(name="identity_card_date",length=20)
	public String getIdentityCardDate() {
		return identityCardDate;
	}
	public void setIdentityCardDate(String identityCardDate) {
		this.identityCardDate = identityCardDate;
	}
	@Column(name="training_certificate_path",length=100)
	public String getTrainingCertificatePath() {
		return trainingCertificatePath;
	}
	public void setTrainingCertificatePath(String trainingCertificatePath) {
		this.trainingCertificatePath = trainingCertificatePath;
	}
	@Column(name="training_certificate_date",length=100)
	public String getTrainingCertificateDate() {
		return trainingCertificateDate;
	}
	public void setTrainingCertificateDate(String trainingCertificateDate) {
		this.trainingCertificateDate = trainingCertificateDate;
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
	@Column(name="pinyin_code")
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
	
	
}
