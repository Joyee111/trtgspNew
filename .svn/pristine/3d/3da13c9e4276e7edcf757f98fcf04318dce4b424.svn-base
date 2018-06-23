package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Entity
@Table(name="t_FirstEnterprise")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class FirstEnterprise implements Serializable {
	private long id;
	private String companyName;//企业名称
	private String corporation;//法人代表
	private String compamyAddress;//企业地址
	private Integer economic_nature;// 0 国有 1 私营 
	private String postalcode;//企业邮编
	private String quality_principal;//质量负责人
	private String certificate_No;//认证证书号
	private String license_No;//许可证号 
	private String business_license_No;//营业执照号 
	private SalesStaff sales_deputy;//销售代表 
	private String phone;// 联系电话 
	private String apply_cause;//申请原因
	private String reject_cause;//驳回原因
	private String examine_content ;//审批内容
	private String business_licence_path;//营业执照路径 
	private String business_licence_date;// 营业执照到期时间期 
	private String licence_path;//经营许可证路径 
	private String licence_date;// 经营许可证到期时间 
	private String littCredentPath;//认证证书路径
	private String littCredentDate;//认证证书到期日期
	private String accountPath;// 开户信息路径	
	private String accountDate;// 开户信息到期日期
	private String annualSurveyPath;//年检证明路径
	private String annualSurveyDate;// 年检证明到期日期
	private Integer review_status;// 0 待录入 1 待审批 2 审批通过 3 驳回 
	private long proposer_ID; //申请人id 
	private Date application_time; //申请时间 
	private long auditor_ID;//审核人 
	private Date review_time;//审核时间
	private String customerNumber;//客户编号
	private String tenBitCode;//十位码
	private String email;//email地址
	private String businessScope;//经营范围
	private String pinyinCode;//拼音码
	private String portraiture;//传真
	private String taxpayerRegisterNo;//纳税人登记号
	private String bankName;//开户银行
	private String bankNumber;//开户银行账号
	private String bankUserName;//开户户名
	private String deliveryPersonnel;//提货人员
	private String business_licence_inspection_path;//营业执照年检证明
	private String business_licence_inspection_date;//营业执照年检证明到期日期
	private String gsp_certificate_path;//gsp证书
	private String gsp_certificate_date;//gsp证书到期日期
	private String organization_code_path;//组织机构代码
	private String organization_code_date;//组织机构代码到期时间期
	private String organization_code_inspection_path;//组织机构代码年检
	private String organization_code_inspection_date;//组织机构代码年检日期
	private String quality_assurance_path;//质量保证协议
	private String quality_assurance_date;//质量保证协议到期日期
	private String authorization_path;//委托书
	private String authorization_date;//委托书到期日期
	private String remark;//备注
	private Set<FirstEnterpriseAccessory> accessories = new HashSet<FirstEnterpriseAccessory>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="name",length=50)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="corporation",length=20)
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	@Column(name="address",length=100)
	public String getCompamyAddress() {
		return compamyAddress;
	}
	public void setCompamyAddress(String compamyAddress) {
		this.compamyAddress = compamyAddress;
	}
	@Column(name="economic_nature",length=2)
	public Integer getEconomic_nature() {
		return economic_nature;
	}
	public void setEconomic_nature(Integer economicNature) {
		economic_nature = economicNature;
	}
	@Column(name="postalcode",length=10)
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	@Column(name="quality_principal",length=20)
	public String getQuality_principal() {
		return quality_principal;
	}
	public void setQuality_principal(String qualityPrincipal) {
		quality_principal = qualityPrincipal;
	}
	@Column(name="certificate_No",length=20)
	public String getCertificate_No() {
		return certificate_No;
	}
	public void setCertificate_No(String certificateNo) {
		certificate_No = certificateNo;
	}
	@Column(name="license_No",length=20)
	public String getLicense_No() {
		return license_No;
	}
	public void setLicense_No(String licenseNo) {
		license_No = licenseNo;
	}
	@Column(name="business_license_No",length=20)
	public String getBusiness_license_No() {
		return business_license_No;
	}
	public void setBusiness_license_No(String businessLicenseNo) {
		business_license_No = businessLicenseNo;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public SalesStaff getSales_deputy() {
		return sales_deputy;
	}
	public void setSales_deputy(SalesStaff salesDeputy) {
		sales_deputy = salesDeputy;
	}
	@Column(name="phone",length=50)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="apply_cause",length=600)
	public String getApply_cause() {
		return apply_cause;
	}
	public void setApply_cause(String applyCause) {
		apply_cause = applyCause;
	}
	@Column(name="reject_cause",length=600)
	public String getReject_cause() {
		return reject_cause;
	}
	public void setReject_cause(String rejectCause) {
		reject_cause = rejectCause;
	}
	@Column(name="examine_content",length=600)
	public String getExamine_content() {
		return examine_content;
	}
	public void setExamine_content(String examineContent) {
		examine_content = examineContent;
	}
	@Column(name="business_licence_path",length=100)
	public String getBusiness_licence_path() {
		return business_licence_path;
	}
	public void setBusiness_licence_path(String businessLicencePath) {
		business_licence_path = businessLicencePath;
	}
	@Column(name="business_licence_date",length=20)
	public String getBusiness_licence_date() {
		return business_licence_date;
	}
	public void setBusiness_licence_date(String businessLicenceDate) {
		business_licence_date = businessLicenceDate;
	}
	@Column(name="licence_path",length=100)
	public String getLicence_path() {
		return licence_path;
	}
	public void setLicence_path(String licencePath) {
		licence_path = licencePath;
	}
	@Column(name="licence_date",length=20)
	public String getLicence_date() {
		return licence_date;
	}
	public void setLicence_date(String licenceDate) {
		licence_date = licenceDate;
	}
	@Column(name="litterae_credentiales_path",length=200)
	public String getLittCredentPath() {
		return littCredentPath;
	}
	public void setLittCredentPath(String littCredentPath) {
		this.littCredentPath = littCredentPath;
	}
	@Column(name="litterae_credentiales_date",length=20)
	public String getLittCredentDate() {
		return littCredentDate;
	}
	public void setLittCredentDate(String littCredentDate) {
		this.littCredentDate = littCredentDate;
	}
	@Column(name="account_path",length=200)
	public String getAccountPath() {
		return accountPath;
	}
	public void setAccountPath(String accountPath) {
		this.accountPath = accountPath;
	}
	@Column(name="account_date",length=20)
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	@Column(name="annual_survey_path",length=200)
	public String getAnnualSurveyPath() {
		return annualSurveyPath;
	}
	public void setAnnualSurveyPath(String annualSurveyPath) {
		this.annualSurveyPath = annualSurveyPath;
	}
	@Column(name="annual_survey_date",length=20)
	public String getAnnualSurveyDate() {
		return annualSurveyDate;
	}
	public void setAnnualSurveyDate(String annualSurveyDate) {
		this.annualSurveyDate = annualSurveyDate;
	}
	@Column(name="review_status",length=2)
	public Integer getReview_status() {
		return review_status;
	}
	public void setReview_status(Integer reviewStatus) {
		review_status = reviewStatus;
	}
	@Column(name="proposer_ID")
	public long getProposer_ID() {
		return proposer_ID;
	}
	public void setProposer_ID(long proposerID) {
		proposer_ID = proposerID;
	}
	@Column(name="application_time")
	public Date getApplication_time() {
		return application_time;
	}
	public void setApplication_time(Date applicationTime) {
		application_time = applicationTime;
	}
	@Column(name="auditor_ID")
	public long getAuditor_ID() {
		return auditor_ID;
	}
	public void setAuditor_ID(long auditorID) {
		auditor_ID = auditorID;
	}
	@Column(name="review_time")
	public Date getReview_time() {
		return review_time;
	}
	public void setReview_time(Date reviewTime) {
		review_time = reviewTime;
	}
	@Column(name="customerNumber",length=20)
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	@Column(name="tenBitCode",length=20)
	public String getTenBitCode() {
		return tenBitCode;
	}
	public void setTenBitCode(String tenBitCode) {
		this.tenBitCode = tenBitCode;
	}
	@Column(name="email",length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="businessScope",length=655)
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	@Column(name="pinyinCode",length=50)
	public String getPinyinCode() {
		return pinyinCode;
	}
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	@Column(name="portraiture",length=50)
	public String getPortraiture() {
		return portraiture;
	}
	public void setPortraiture(String portraiture) {
		this.portraiture = portraiture;
	}
	@Column(name="taxpayerRegisterNo",length=50)
	public String getTaxpayerRegisterNo() {
		return taxpayerRegisterNo;
	}
	public void setTaxpayerRegisterNo(String taxpayerRegisterNo) {
		this.taxpayerRegisterNo = taxpayerRegisterNo;
	}
	@Column(name="bankName",length=50)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name="bankNumber",length=100)
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	@Column(name="bankUserName",length=50)
	public String getBankUserName() {
		return bankUserName;
	}
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}
	@Column(name="delivery_personnel",length=50)
	public String getDeliveryPersonnel() {
		return deliveryPersonnel;
	}
	public void setDeliveryPersonnel(String deliveryPersonnel) {
		this.deliveryPersonnel = deliveryPersonnel;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<FirstEnterpriseAccessory> getAccessories() {
		return accessories;
	}
	public void setAccessories(Set<FirstEnterpriseAccessory> accessories) {
		this.accessories = accessories;
	}
	@Column(name="business_licence_inspection_path",length=100)
	public String getBusiness_licence_inspection_path() {
		return business_licence_inspection_path;
	}
	public void setBusiness_licence_inspection_path(
			String businessLicenceInspectionPath) {
		business_licence_inspection_path = businessLicenceInspectionPath;
	}
	@Column(name="business_licence_inspection_date",length=20)
	public String getBusiness_licence_inspection_date() {
		return business_licence_inspection_date;
	}
	public void setBusiness_licence_inspection_date(
			String businessLicenceInspectionDate) {
		business_licence_inspection_date = businessLicenceInspectionDate;
	}
	@Column(name="gsp_certificate_path",length=100)
	public String getGsp_certificate_path() {
		return gsp_certificate_path;
	}
	public void setGsp_certificate_path(String gspCertificatePath) {
		gsp_certificate_path = gspCertificatePath;
	}
	@Column(name="gsp_certificate_date",length=20)
	public String getGsp_certificate_date() {
		return gsp_certificate_date;
	}
	public void setGsp_certificate_date(String gspCertificateDate) {
		gsp_certificate_date = gspCertificateDate;
	}
	@Column(name="organization_code_path",length=100)
	public String getOrganization_code_path() {
		return organization_code_path;
	}
	public void setOrganization_code_path(String organizationCodePath) {
		organization_code_path = organizationCodePath;
	}
	@Column(name="organization_code_date",length=20)
	public String getOrganization_code_date() {
		return organization_code_date;
	}
	public void setOrganization_code_date(String organizationCodeDate) {
		organization_code_date = organizationCodeDate;
	}
	@Column(name="organization_code_inspection_path",length=100)
	public String getOrganization_code_inspection_path() {
		return organization_code_inspection_path;
	}
	public void setOrganization_code_inspection_path(
			String organizationCodeInspectionPath) {
		organization_code_inspection_path = organizationCodeInspectionPath;
	}
	@Column(name="organization_code_inspection_date",length=20)
	public String getOrganization_code_inspection_date() {
		return organization_code_inspection_date;
	}
	public void setOrganization_code_inspection_date(
			String organizationCodeInspectionDate) {
		organization_code_inspection_date = organizationCodeInspectionDate;
	}
	@Column(name="quality_assurance_path",length=100)
	public String getQuality_assurance_path() {
		return quality_assurance_path;
	}
	public void setQuality_assurance_path(String qualityAssurancePath) {
		quality_assurance_path = qualityAssurancePath;
	}
	@Column(name="quality_assurance_date",length=20)
	public String getQuality_assurance_date() {
		return quality_assurance_date;
	}
	public void setQuality_assurance_date(String qualityAssuranceDate) {
		quality_assurance_date = qualityAssuranceDate;
	}
	@Column(name="remark",length=655)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="authorization_path",length=100)
	public String getAuthorization_path() {
		return authorization_path;
	}
	public void setAuthorization_path(String authorizationPath) {
		authorization_path = authorizationPath;
	}
	@Column(name="authorization_date",length=100)
	public String getAuthorization_date() {
		return authorization_date;
	}
	public void setAuthorization_date(String authorizationDate) {
		authorization_date = authorizationDate;
	}
	
	
	
}
