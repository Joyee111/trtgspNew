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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 10:17:14 AM
 * 类说明 购买单位
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_purchase_units")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchaseUnit implements Serializable {
	
	private long id;//主键ID
	private String 	companyName;//公司名称
	private String  corporation;//法人代表
	private String  address;//公司地址
	private String  economicNature;//企业性质
	private String  compantPhone;//企业电话
	private String  postalCode;//企业邮编
	private String  qualityPrincipal;//质量负责人
	private String  certificateNo;//认证证书号
	private String  licenseNo;//许可证号
	private String  businessLicenseNo;//营业执照号
	private ProcurementStaff  procurementStaff;//采购人员
	private String  procurementStaffName;//采购人员名字
	private String  phone;//采购人电话电话
	private String  businessLicencePath;//营业执照路径
	private String  businessLicenceDate;//营业执照到期时间期
	private String  licencePath;//许可证路径
	private String  licenceDate;//许可证到期日期
	private String  documentEvidencePath;//证明材料路径
	private String  documentEvidenceDate;//证明材料到期时间
	private String  businessScope;//经营范围
	private String  rejectCause;//驳回原因
	private String  applyCause;//申请原因
	private String  examineContent;//审批内容
	private Integer  reviewStatus;//审核状态 0 待录入 1 待审批 2 审批通过 3 驳回
	private long  proposerId;//申请人ID
	private Date  application_time;//申请时间
	private long  auditorId;//审核人ID
	private Date  reviewTime;//审核时间
	private String customerNumber;//客户编号
	private String tenBitCode;//十位码
	private String email;//email地址
	private String pinyinCode;//拼音码
	private String portraiture;//传真
	private String taxpayerRegisterNo;//纳税人登记号
	private String bankName;//开户银行
	private String bankNumber;//开户银行账号
	private String bankUserName;//开户户名
	private String businessLicenseInspectionPath;//营业执照年检
	private String businessLicenseInspectionDate;//营业执照年检时间
	private String gspCertificatePath;//gsp证书
	private String gspCertificateDate;//gsp证书到期日期
	private String organizationCodePath;//组织机构代码
	private String organizationCodeDate;//组织机构代码到期时间
	private String organizationCodeInspectionPath;//组织机构代码年检时间
	private String organizationCodeInspectionDate;//组织机构代码年检时间
	private String qualityAssurancePath;//质量保证协议
	private String qualityAssuranceDate;//质量保证协议到期日期
	private String authorizationPath;//法人委托书
	private String authorizationDate;//法人委托书到期时间
	private String remark;//备注
	private String saleCompany;//销售公司
	private String oldNo;//旧客编号
	private String taxReceiptAddress;//税票信息地址
	private String taxReceiptPhone;//税票电话
	private String shippingAddress;//发货地址
	private String consigneeName;//收货人
	private String consigneePhone;//收货人电话
	private String electronicMonitoringCode;//电子监管码
	private String accountOpeningDate;//开户日期
	private String openCompany;//开户公司0表示经营 、1表示新品、2表示市场
	private String receivingPerson;//提货人员名字
	private ProcurementStaff procurementReceiving;//提货人员
	private Set<PurchaseUnitsAccessory> purUnitsAccessory = new HashSet<PurchaseUnitsAccessory>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="company_name",length=100)
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="economic_nature",length=2)
	public String getEconomicNature() {
		return economicNature;
	}
	public void setEconomicNature(String economicNature) {
		this.economicNature = economicNature;
	}
	@Column(name="company_phone",length=100)
	public String getCompantPhone() {
		return compantPhone;
	}
	public void setCompantPhone(String compantPhone) {
		this.compantPhone = compantPhone;
	}
	@Column(name="postalcode",length=10)
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Column(name="quality_principal",length=20)
	public String getQualityPrincipal() {
		return qualityPrincipal;
	}
	public void setQualityPrincipal(String qualityPrincipal) {
		this.qualityPrincipal = qualityPrincipal;
	}
	@Column(name="certificate_No",length=20)
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	@Column(name="license_No",length=20)
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Column(name="business_license_No",length=50)
	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public ProcurementStaff getProcurementStaff() {
		return procurementStaff;
	}
	public void setProcurementStaff(ProcurementStaff procurementStaff) {
		this.procurementStaff = procurementStaff;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public ProcurementStaff getProcurementReceiving() {
		return procurementReceiving;
	}
	public void setProcurementReceiving(ProcurementStaff procurementReceiving) {
		this.procurementReceiving = procurementReceiving;
	}
	@Column(name="procurementStaff_name",length=50)
	public String getProcurementStaffName() {
		return procurementStaffName;
	}
	public void setProcurementStaffName(String procurementStaffName) {
		this.procurementStaffName = procurementStaffName;
	}
	@Column(name="phone",length=100)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="business_licence_path",length=200)
	public String getBusinessLicencePath() {
		return businessLicencePath;
	}
	public void setBusinessLicencePath(String businessLicencePath) {
		this.businessLicencePath = businessLicencePath;
	}
	@Column(name="business_licence_date",length=20)
	public String getBusinessLicenceDate() {
		return businessLicenceDate;
	}
	public void setBusinessLicenceDate(String businessLicenceDate) {
		this.businessLicenceDate = businessLicenceDate;
	}
	@Column(name="licence_path",length=200)
	public String getLicencePath() {
		return licencePath;
	}
	public void setLicencePath(String licencePath) {
		this.licencePath = licencePath;
	}
	@Column(name="licence_date",length=20)
	public String getLicenceDate() {
		return licenceDate;
	}
	public void setLicenceDate(String licenceDate) {
		this.licenceDate = licenceDate;
	}
	@Column(name="documentary_evidence_path",length=200)
	public String getDocumentEvidencePath() {
		return documentEvidencePath;
	}
	public void setDocumentEvidencePath(String documentEvidencePath) {
		this.documentEvidencePath = documentEvidencePath;
	}
	@Column(name="documentary_evidence_date",length=20)
	public String getDocumentEvidenceDate() {
		return documentEvidenceDate;
	}
	public void setDocumentEvidenceDate(String documentEvidenceDate) {
		this.documentEvidenceDate = documentEvidenceDate;
	}
	@Column(name="business_scope",length=655)
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	@Column(name="reject_cause",length=200)
	public String getRejectCause() {
		return rejectCause;
	}
	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}
	@Column(name="apply_cause",length=200)
	public String getApplyCause() {
		return applyCause;
	}
	public void setApplyCause(String applyCause) {
		this.applyCause = applyCause;
	}
	@Column(name="examine_content",length=200)
	public String getExamineContent() {
		return examineContent;
	}
	public void setExamineContent(String examineContent) {
		this.examineContent = examineContent;
	}
	@Column(name="review_status")
	public Integer getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	@Column(name="proposer_ID")
	public long getProposerId() {
		return proposerId;
	}
	public void setProposerId(long proposerId) {
		this.proposerId = proposerId;
	}
	@Column(name="application_time")
	public Date getApplication_time() {
		return application_time;
	}
	public void setApplication_time(Date applicationTime) {
		application_time = applicationTime;
	}
	@Column(name="auditor_ID")
	public long getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(long auditorId) {
		this.auditorId = auditorId;
	}
	@Column(name="review_time")
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	@Column(name="customer_number",length=20)
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	@Column(name="ten_bit_code",length=20)
	public String getTenBitCode() {
		return tenBitCode;
	}
	public void setTenBitCode(String tenBitCode) {
		this.tenBitCode = tenBitCode;
	}
	@Column(name="email",length=20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="pinyin_code",length=50)
	public String getPinyinCode() {
		return pinyinCode;
	}
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	@Column(name="portraiture",length=100)
	public String getPortraiture() {
		return portraiture;
	}
	public void setPortraiture(String portraiture) {
		this.portraiture = portraiture;
	}
	@Column(name="taxpayer_register_no",length=20)
	public String getTaxpayerRegisterNo() {
		return taxpayerRegisterNo;
	}
	public void setTaxpayerRegisterNo(String taxpayerRegisterNo) {
		this.taxpayerRegisterNo = taxpayerRegisterNo;
	}
	@Column(name="bank_name",length=100)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name="bank_number",length=100)
	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	@Column(name="bank_UserName",length=50)
	public String getBankUserName() {
		return bankUserName;
	}
	public void setBankUserName(String bankUserName) {
		this.bankUserName = bankUserName;
	}
	@OneToMany(targetEntity=PurchaseUnitsAccessory.class, cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="purchase_units_id",updatable=false)
	public Set<PurchaseUnitsAccessory> getPurUnitsAccessory() {
		return purUnitsAccessory;
	}
	public void setPurUnitsAccessory(Set<PurchaseUnitsAccessory> purUnitsAccessory) {
		this.purUnitsAccessory = purUnitsAccessory;
	}
	@Column(name="business_license_inspection_path",length=100)
	public String getBusinessLicenseInspectionPath() {
		return businessLicenseInspectionPath;
	}
	public void setBusinessLicenseInspectionPath(
			String businessLicenseInspectionPath) {
		this.businessLicenseInspectionPath = businessLicenseInspectionPath;
	}
	@Column(name="business_license_inspection_date",length=20)
	public String getBusinessLicenseInspectionDate() {
		return businessLicenseInspectionDate;
	}
	public void setBusinessLicenseInspectionDate(
			String businessLicenseInspectionDate) {
		this.businessLicenseInspectionDate = businessLicenseInspectionDate;
	}
	@Column(name="gsp_certificate_path",length=100)
	public String getGspCertificatePath() {
		return gspCertificatePath;
	}
	public void setGspCertificatePath(String gspCertificatePath) {
		this.gspCertificatePath = gspCertificatePath;
	}
	@Column(name="gsp_certificate_date",length=20)
	public String getGspCertificateDate() {
		return gspCertificateDate;
	}
	public void setGspCertificateDate(String gspCertificateDate) {
		this.gspCertificateDate = gspCertificateDate;
	}
	@Column(name="organization_code_path",length=100)
	public String getOrganizationCodePath() {
		return organizationCodePath;
	}
	public void setOrganizationCodePath(String organizationCodePath) {
		this.organizationCodePath = organizationCodePath;
	}
	@Column(name="organization_code_date",length=20)
	public String getOrganizationCodeDate() {
		return organizationCodeDate;
	}
	public void setOrganizationCodeDate(String organizationCodeDate) {
		this.organizationCodeDate = organizationCodeDate;
	}
	@Column(name="organization_code_inspection_path",length=100)
	public String getOrganizationCodeInspectionPath() {
		return organizationCodeInspectionPath;
	}
	public void setOrganizationCodeInspectionPath(
			String organizationCodeInspectionPath) {
		this.organizationCodeInspectionPath = organizationCodeInspectionPath;
	}
	@Column(name="organization_code_inspection_date",length=20)
	public String getOrganizationCodeInspectionDate() {
		return organizationCodeInspectionDate;
	}
	public void setOrganizationCodeInspectionDate(
			String organizationCodeInspectionDate) {
		this.organizationCodeInspectionDate = organizationCodeInspectionDate;
	}
	@Column(name="quality_assurance_path",length=100)
	public String getQualityAssurancePath() {
		return qualityAssurancePath;
	}
	public void setQualityAssurancePath(String qualityAssurancePath) {
		this.qualityAssurancePath = qualityAssurancePath;
	}
	@Column(name="quality_assurance_date",length=20)
	public String getQualityAssuranceDate() {
		return qualityAssuranceDate;
	}
	public void setQualityAssuranceDate(String qualityAssuranceDate) {
		this.qualityAssuranceDate = qualityAssuranceDate;
	}
	@Column(name="authorization_path",length=100)
	public String getAuthorizationPath() {
		return authorizationPath;
	}
	public void setAuthorizationPath(String authorizationPath) {
		this.authorizationPath = authorizationPath;
	}
	@Column(name="authorization_date",length=20)
	public String getAuthorizationDate() {
		return authorizationDate;
	}
	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	@Column(name="remark",length=655)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="sale_company",length=20)
	public String getSaleCompany() {
		return saleCompany;
	}
	public void setSaleCompany(String saleCompany) {
		this.saleCompany = saleCompany;
	}
	@Column(name="old_no",length=200)
	public String getOldNo() {
		return oldNo;
	}
	public void setOldNo(String oldNo) {
		this.oldNo = oldNo;
	}
	@Column(name="taxReceipt_address",length=100)
	public String getTaxReceiptAddress() {
		return taxReceiptAddress;
	}
	public void setTaxReceiptAddress(String taxReceiptAddress) {
		this.taxReceiptAddress = taxReceiptAddress;
	}
	@Column(name="taxReceipt_phone",length=50)
	public String getTaxReceiptPhone() {
		return taxReceiptPhone;
	}
	public void setTaxReceiptPhone(String taxReceiptPhone) {
		this.taxReceiptPhone = taxReceiptPhone;
	}
	@Column(name="shipping_address",length=100)
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@Column(name="consignee_name",length=655)
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	@Column(name="consignee_phone",length=655)
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	@Column(name="electronicMonitoring_code",length=20)
	public String getElectronicMonitoringCode() {
		return electronicMonitoringCode;
	}
	public void setElectronicMonitoringCode(String electronicMonitoringCode) {
		this.electronicMonitoringCode = electronicMonitoringCode;
	}
	@Column(name="accoutOpening_date",length=20)
	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	@Column(name="open_company",length=10)
	public String getOpenCompany() {
		return openCompany;
	}
	public void setOpenCompany(String openCompany) {
		this.openCompany = openCompany;
	}
	@Column(name="receiving_person",length=50)
	public String getReceivingPerson() {
		return receivingPerson;
	}
	public void setReceivingPerson(String receivingPerson) {
		this.receivingPerson = receivingPerson;
	}
	
	
}
