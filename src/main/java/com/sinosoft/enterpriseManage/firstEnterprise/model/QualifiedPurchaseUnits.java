package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 11:24:00 AM
 * 类说明 合格购货单位
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_qualified_purchase_units")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualifiedPurchaseUnits implements Serializable {
	private long id;//主键ID
	private long purchaseUnitsId;//购货单位ID
	private String customerNumber;//客户编号
	private String customerName;//客户名称
	private String busLiceExpiraDate;//营业执照到期时间期
	private String busLiceAnnualSurvey;//营业执照年检时间
	private String liceExpirationDate;//许可证到期日期
	private String gpsExpirationDate;//GSP截止日期
	private String documentEvidenceDate;//证明材料到期日期
	private String tenBitCode;//十位码
	private String email;//邮箱
	private String pinyinCode;//拼音码
	private String postalCode;//邮编
	private String companyPhone;//企业联系电话
	private String phone;//采购人电话
	private String portraiture;//传真
	private String corporation;//法人
	private String taxpayeRegisterNo;//纳税人登记证号
	private String bankName;//开户银行
	private String bankNumber;//银行帐号
	private String bankUserName;//开户户名
	private String businessScope;//经营范围
	private long  modifierId;//修改人Id
	private Date  modifiedTime;//修改时间
	private Integer  delete_flag;//删除表示  0 未删除 1 已删除
//	private String businessLicenseInspectionPath;//营业执照年检
	private String businessLicenseInspectionDate;//营业执照年检时间
//	private String gspCertificatePath;//gsp证书
//	private String gspCertificateDate;//gsp证书到期日期
//	private String organizationCodePath;//组织机构代码
	private String organizationCodeDate;//组织机构代码到期时间
//	private String organizationCodeInspectionPath;//组织机构代码年检时间
	private String organizationCodeInspectionDate;//组织机构代码年检时间
//	private String qualityAssurancePath;//质量保证协议
	private String qualityAssuranceDate;//质量保证协议到期日期
//	private String authorizationPath;//法人委托书
	private String authorizationDate;//法人委托书到期时间
	private String remark;//备注
	private ProcurementStaff procurementStaff;//采购人员
	private ProcurementStaff procurementReceiving;//提货人员
	private String procurementStaffName;
	private String saleCompany;//销售公司
	private String oldNo;//旧客编号
	private String taxReceiptAddress;//税票信息地址
	private String taxReceiptPhone;//税票电话
	private String shippingAddress;//发货地址
	private String consigneeName;//收货人
	private String consigneePhone;//收货人电话
	private String electronicMonitoringCode;//电子监管码
	private String accountOpeningDate;//开户日期
	private String address;//企业地址
	private String economicNature;//企业经营类型
	private String useFlag;//使用标识 0表示启用，1表示停用 2表示暂时停用 默认为使用状态
	private String openCompany;//开户公司 
	private String qualityPrincipal;//质量负责人
	private String licenseNo;//经营/生产许可证号
	private String businessLicenseNo;//营业执照号
	private String certificateNo;//GSP/GMP认证证书号码;
	private String receivingPerson;//提货人员
	private String  businessLicencePath;//营业执照路径
	private String businessLicenseInspectionPath;//营业执照年检
	private String  licencePath;//许可证路径
	private String gspCertificatePath;//gsp证书
	private String organizationCodePath;//组织机构代码
	private String organizationCodeInspectionPath;//组织机构代码年检时间
	private String qualityAssurancePath;//质量保证协议
	private String authorizationPath;//法人委托书
	private Integer uploadflag; //接口上传标记 默认未上传为0  新增上传为1，修改上传为2.

	
	public QualifiedPurchaseUnits(){
		
	}
	public QualifiedPurchaseUnits(PurchaseUnit purchaseUnit ){
		this.purchaseUnitsId = purchaseUnit.getId();
		this.customerNumber = purchaseUnit.getCustomerNumber();
		this.customerName = purchaseUnit.getCompanyName();
		this.busLiceExpiraDate = purchaseUnit.getBusinessLicenceDate();
		this.liceExpirationDate = purchaseUnit.getLicenceDate();
		this.documentEvidenceDate = purchaseUnit.getDocumentEvidenceDate();
		this.busLiceAnnualSurvey = purchaseUnit.getBusinessLicenseInspectionDate();
		this.tenBitCode = purchaseUnit.getTenBitCode();
		this.email = purchaseUnit.getEmail();
		this.pinyinCode = purchaseUnit.getPinyinCode();
		this.postalCode = purchaseUnit.getPostalCode();
		this.companyPhone = purchaseUnit.getCompantPhone();
		this.phone = purchaseUnit.getPhone();
		this.portraiture = purchaseUnit.getPortraiture();
		this.corporation = purchaseUnit.getCorporation();
		this.taxpayeRegisterNo = purchaseUnit.getTaxpayerRegisterNo();
		this.bankName = purchaseUnit.getBankName();
		this.bankNumber = purchaseUnit.getBankNumber();
		this.bankUserName = purchaseUnit.getBankUserName();
		this.businessScope = purchaseUnit.getBusinessScope();
		this.gpsExpirationDate = purchaseUnit.getGspCertificateDate();
		this.saleCompany=purchaseUnit.getSaleCompany();
		this.oldNo=purchaseUnit.getOldNo();
	//	this.businessLicenseInspectionPath = purchaseUnit.getBusinessLicenseInspectionPath();
		this.businessLicenseInspectionDate = purchaseUnit.getBusinessLicenseInspectionDate();
	//	this.gspCertificatePath= purchaseUnit.getGspCertificatePath();//gsp证书
//		this.gspCertificateDate= purchaseUnit.getGspCertificateDate();//gsp证书到期日期
	//	this.organizationCodePath= purchaseUnit.getOrganizationCodePath();//组织机构代码
		this.organizationCodeDate= purchaseUnit.getOrganizationCodeDate();//组织机构代码到期时间
	//	this.organizationCodeInspectionPath= purchaseUnit.getOrganizationCodeInspectionPath();//组织机构代码年检时间
		this.organizationCodeInspectionDate= purchaseUnit.getOrganizationCodeInspectionDate();//组织机构代码年检时间
	//	this.qualityAssurancePath= purchaseUnit.getQualityAssurancePath();//质量保证协议
		this.qualityAssuranceDate = purchaseUnit.getQualityAssuranceDate();//质量保证协议到期日期
	//	this.authorizationPath= purchaseUnit.getAuthorizationPath();//法人委托书
		this.authorizationDate= purchaseUnit.getAuthorizationDate();//法人委托书到期时间
		this.remark = purchaseUnit.getRemark();//备注
		this.procurementStaff = purchaseUnit.getProcurementStaff();
		this.procurementReceiving = purchaseUnit.getProcurementReceiving();
		this.procurementStaffName = purchaseUnit.getProcurementStaffName();
		this.shippingAddress = purchaseUnit.getShippingAddress();
		this.delete_flag =0;
		this.taxReceiptAddress =purchaseUnit.getTaxReceiptAddress();
		this.taxReceiptPhone = purchaseUnit.getTaxReceiptPhone();
		this.consigneeName = purchaseUnit.getConsigneeName();
		this.consigneePhone = purchaseUnit.getConsigneePhone();
		this.electronicMonitoringCode = purchaseUnit.getElectronicMonitoringCode();
		this.accountOpeningDate = purchaseUnit.getAccountOpeningDate();
		this.address = purchaseUnit.getAddress();
		this.economicNature = purchaseUnit.getEconomicNature();
		this.useFlag = "0";
		this.openCompany = purchaseUnit.getOpenCompany();
		this.qualityPrincipal = purchaseUnit.getQualityPrincipal();
		this.licenseNo = purchaseUnit.getLicenseNo();//经营/生产许可证号
		this.businessLicenseNo = purchaseUnit.getBusinessLicenseNo();//营业执照号
		this.certificateNo = purchaseUnit.getCertificateNo();//GSP/GMP认证证书号码;
		this.receivingPerson = purchaseUnit.getReceivingPerson();
		this.businessLicencePath = purchaseUnit.getBusinessLicencePath();//营业执照路径
		this.businessLicenseInspectionPath = purchaseUnit.getBusinessLicenseInspectionPath();//营业执照年检
		this.licencePath = purchaseUnit.getLicencePath();//许可证路径
		this.gspCertificatePath = purchaseUnit.getGspCertificatePath();//gsp证书
		this.organizationCodePath = purchaseUnit.getOrganizationCodePath();//组织机构代码
		this.organizationCodeInspectionPath = purchaseUnit.getOrganizationCodeInspectionPath();//组织机构代码年检时间
		this.qualityAssurancePath = purchaseUnit.getQualityAssurancePath();//质量保证协议
		this.authorizationPath = purchaseUnit.getAuthorizationPath();//法人委托书
		this.modifierId = purchaseUnit.getAuditorId();
		this.modifiedTime = new Date();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="purchase_units_id")
	public long getPurchaseUnitsId() {
		return purchaseUnitsId;
	}
	public void setPurchaseUnitsId(long purchaseUnitsId) {
		this.purchaseUnitsId = purchaseUnitsId;
	}
	@Column(name="customer_number",length=20)
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	@Column(name="customer_name",length=100)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name="businessLicense_ExpirationDate",length=20)
	public String getBusLiceExpiraDate() {
		return busLiceExpiraDate;
	}
	public void setBusLiceExpiraDate(String busLiceExpiraDate) {
		this.busLiceExpiraDate = busLiceExpiraDate;
	}
	@Column(name="businessLicense_annualSurvey",length=20)
	public String getBusLiceAnnualSurvey() {
		return busLiceAnnualSurvey;
	}
	public void setBusLiceAnnualSurvey(String busLiceAnnualSurvey) {
		this.busLiceAnnualSurvey = busLiceAnnualSurvey;
	}
	@Column(name="licence_ExpirationDate",length=20)
	public String getLiceExpirationDate() {
		return liceExpirationDate;
	}
	public void setLiceExpirationDate(String liceExpirationDate) {
		this.liceExpirationDate = liceExpirationDate;
	}
	@Column(name="gps_ExpirationDate",length=20)
	public String getGpsExpirationDate() {
		return gpsExpirationDate;
	}
	public void setGpsExpirationDate(String gpsExpirationDate) {
		this.gpsExpirationDate = gpsExpirationDate;
	}
	@Column(name="documentary_evidence_date",length=20)
	public String getDocumentEvidenceDate() {
		return documentEvidenceDate;
	}
	public void setDocumentEvidenceDate(String documentEvidenceDate) {
		this.documentEvidenceDate = documentEvidenceDate;
	}
	@Column(name="ten_bit_code",length=20)
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
	@Column(name="pinyin_code",length=50)
	public String getPinyinCode() {
		return pinyinCode;
	}
	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}
	@Column(name="postalcode",length=50)
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Column(name="company_phone",length=100)
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	@Column(name="phone",length=50)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="portraiture",length=100)
	public String getPortraiture() {
		return portraiture;
	}
	public void setPortraiture(String portraiture) {
		this.portraiture = portraiture;
	}
	@Column(name="corporation",length=20)
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	@Column(name="taxpayer_register_no",length=20)
	public String getTaxpayeRegisterNo() {
		return taxpayeRegisterNo;
	}
	public void setTaxpayeRegisterNo(String taxpayeRegisterNo) {
		this.taxpayeRegisterNo = taxpayeRegisterNo;
	}
	@Column(name="bank_name",length=100)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name="bank_number",length=50)
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
	@Column(name="business_scope",length=655)
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	@Column(name="modifier")
	public long getModifierId() {
		return modifierId;
	}
	public void setModifierId(long modifierId) {
		this.modifierId = modifierId;
	}
	@Column(name="modified_time")
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Column(name="delete_flag")
	public Integer getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(Integer deleteFlag) {
		delete_flag = deleteFlag;
	}
	/*@Column(name="business_license_inspection_path",length=100)
	public String getBusinessLicenseInspectionPath() {
		return businessLicenseInspectionPath;
	}
	public void setBusinessLicenseInspectionPath(
			String businessLicenseInspectionPath) {
		this.businessLicenseInspectionPath = businessLicenseInspectionPath;
	}*/
	@Column(name="business_license_inspection_date",length=20)
	public String getBusinessLicenseInspectionDate() {
		return businessLicenseInspectionDate;
	}
	public void setBusinessLicenseInspectionDate(
			String businessLicenseInspectionDate) {
		this.businessLicenseInspectionDate = businessLicenseInspectionDate;
	}
	/*@Column(name="gsp_certificate_date",length=20)
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
	}*/
	@Column(name="organization_code_date",length=20)
	public String getOrganizationCodeDate() {
		return organizationCodeDate;
	}
	public void setOrganizationCodeDate(String organizationCodeDate) {
		this.organizationCodeDate = organizationCodeDate;
	}
	/*@Column(name="organization_code_inspection_path",length=100)
	public String getOrganizationCodeInspectionPath() {
		return organizationCodeInspectionPath;
	}
	public void setOrganizationCodeInspectionPath(
			String organizationCodeInspectionPath) {
		this.organizationCodeInspectionPath = organizationCodeInspectionPath;
	}*/
	@Column(name="organization_code_inspection_date",length=30)
	public String getOrganizationCodeInspectionDate() {
		return organizationCodeInspectionDate;
	}
	public void setOrganizationCodeInspectionDate(
			String organizationCodeInspectionDate) {
		this.organizationCodeInspectionDate = organizationCodeInspectionDate;
	}
	/*@Column(name="quality_assurance_path",length=100)
	public String getQualityAssurancePath() {
		return qualityAssurancePath;
	}
	public void setQualityAssurancePath(String qualityAssurancePath) {
		this.qualityAssurancePath = qualityAssurancePath;
	}*/
	@Column(name="quality_assurance_date",length=30)
	public String getQualityAssuranceDate() {
		return qualityAssuranceDate;
	}
	public void setQualityAssuranceDate(String qualityAssuranceDate) {
		this.qualityAssuranceDate = qualityAssuranceDate;
	}
	/*@Column(name="authorization_path",length=100)
	public String getAuthorizationPath() {
		return authorizationPath;
	}
	public void setAuthorizationPath(String authorizationPath) {
		this.authorizationPath = authorizationPath;
	}*/
	@Column(name="authorization_date",length=30)
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
	@Column(name="accountOpening_date")
	public String getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(String accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	@Column(name="address",length=100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="economic_nature",length=5)
	public String getEconomicNature() {
		return economicNature;
	}
	public void setEconomicNature(String economicNature) {
		this.economicNature = economicNature;
	}
	@Column(name="use_flag",length=2)
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	@Column(name="open_company",length=10)
	public String getOpenCompany() {
		return openCompany;
	}
	public void setOpenCompany(String openCompany) {
		this.openCompany = openCompany;
	}
	@Column(name="quality_principal",length=20)
	public String getQualityPrincipal() {
		return qualityPrincipal;
	}
	public void setQualityPrincipal(String qualityPrincipal) {
		this.qualityPrincipal = qualityPrincipal;
	}
	@Column(name="license_no",length=20)
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Column(name="business_license_no",length=50)
	public String getBusinessLicenseNo() {
		return businessLicenseNo;
	}
	public void setBusinessLicenseNo(String businessLicenseNo) {
		this.businessLicenseNo = businessLicenseNo;
	}
	@Column(name="certificate_no",length=20)
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	@Column(name="receiving_person",length=50)
	public String getReceivingPerson() {
		return receivingPerson;
	}
	public void setReceivingPerson(String receivingPerson) {
		this.receivingPerson = receivingPerson;
	}
	@Column(name="business_licence_path",length=100)
	public String getBusinessLicencePath() {
		return businessLicencePath;
	}
	public void setBusinessLicencePath(String businessLicencePath) {
		this.businessLicencePath = businessLicencePath;
	}
	@Column(name="business_license_inspection_path",length=100)
	public String getBusinessLicenseInspectionPath() {
		return businessLicenseInspectionPath;
	}
	public void setBusinessLicenseInspectionPath(
			String businessLicenseInspectionPath) {
		this.businessLicenseInspectionPath = businessLicenseInspectionPath;
	}
	@Column(name="licence_path",length=100)
	public String getLicencePath() {
		return licencePath;
	}
	public void setLicencePath(String licencePath) {
		this.licencePath = licencePath;
	}
	@Column(name="gsp_certificate_path",length=100)
	public String getGspCertificatePath() {
		return gspCertificatePath;
	}
	public void setGspCertificatePath(String gspCertificatePath) {
		this.gspCertificatePath = gspCertificatePath;
	}
	@Column(name="organization_code_path",length=100)
	public String getOrganizationCodePath() {
		return organizationCodePath;
	}
	public void setOrganizationCodePath(String organizationCodePath) {
		this.organizationCodePath = organizationCodePath;
	}
	@Column(name="organization_code_inspection_path",length=100)
	public String getOrganizationCodeInspectionPath() {
		return organizationCodeInspectionPath;
	}
	public void setOrganizationCodeInspectionPath(
			String organizationCodeInspectionPath) {
		this.organizationCodeInspectionPath = organizationCodeInspectionPath;
	}
	@Column(name="quality_assurance_path",length=100)
	public String getQualityAssurancePath() {
		return qualityAssurancePath;
	}
	public void setQualityAssurancePath(String qualityAssurancePath) {
		this.qualityAssurancePath = qualityAssurancePath;
	}
	@Column(name="authorization_path",length=100)
	public String getAuthorizationPath() {
		return authorizationPath;
	}
	public void setAuthorizationPath(String authorizationPath) {
		this.authorizationPath = authorizationPath;
	}
	@Column(name="upload_flag")
	public Integer getUploadflag() {
		return uploadflag;
	}

	public void setUploadflag(Integer uploadflag) {
		this.uploadflag = uploadflag;
	}
	
}
