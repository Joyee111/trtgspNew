package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
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
@Table(name="t_qualifiedSupplier")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualifiedSuppliers implements Serializable {//合格供应商
	private long id;//主键ID
	private Long firstEnterpriseId;//首营企业ID
	private String customerNumber;//客户编码
	private String customerName;//客服名称
	private String busiLiceExpiDate;//营业执照到期时间期
	private String busiLIceAnnuSurvey;//营业执照年检时间
	private String liceExpiDate;//经营许可证到期时间
	private String gspExpirDate;//GSP截止日期
	private String littCredentDate;//认证证书到期日期
	private String accountDate;//开户信息到期日期
	private String tenBitCode;//十位码
	private String email;//电子邮箱
	private String pinyinCode;//拼音码
	private String postalCode;//邮编
	private String phone;//电话
	private String portraiture;//传真
	private String corporation;//法人
	private String taxRegisNo;//纳税人登记账号
	private String bankName;//开户银行
	private String bankNumber;//银行账号
	private String bankUserName;//开户户名
	private String businessScope;//经营范围
	private Long modifierId;//修改人ID
	private String modified_time;//修改时间
	private String deleteFlag;//删除表示
	private SalesStaff sales_deputy;//销售代表
	private String deliveryPersonnel;//提货人员
	private String organizationCodeDate;//组织机构代码到期时间期
	private String organizationCodeInspectionDate;//组织机构代码年检日期
	private String qualityAssuranceDate;//质量保证协议到期日期
	private String authorizationDate;//委托协议书
	private String remark;//备注
	private String business_licence_path;//营业执照路径
	private String business_licence_inspection_path;//营业执照年检证明
	private String licence_path;//经营许可证路径 
	private String gsp_certificate_path;//gsp证书
	private String organization_code_path;//组织机构代码
	private String organization_code_inspection_path;//组织机构代码年检
	private String quality_assurance_path;//质量保证协议
	private String authorization_path;//委托书
	private String useFlag;//使用标识 0表示启用，1表示停用 2表示暂时停用 默认为使用状态
	
	private Set<QulifiedSupplyAccessory> accessories = new HashSet<QulifiedSupplyAccessory>();
	private Set<QulifiedSupplyDrugFroms> drugFroms = new HashSet<QulifiedSupplyDrugFroms>();
	public QualifiedSuppliers(){
		
	}
	
	public  QualifiedSuppliers(FirstEnterprise enterprise){
		this.firstEnterpriseId = enterprise.getId();
		this.customerNumber = enterprise.getCustomerNumber();
		this.customerName = enterprise.getCompanyName();
		this.busiLiceExpiDate = enterprise.getBusiness_licence_date();
		this.busiLIceAnnuSurvey = enterprise.getBusiness_licence_inspection_date();
		this.liceExpiDate = enterprise.getLicence_date();
		this.gspExpirDate = enterprise.getGsp_certificate_date();
		this.littCredentDate = enterprise.getLittCredentDate();
		this.accountDate = enterprise.getAccountDate();
		this.tenBitCode = enterprise.getTenBitCode();
		this.email = enterprise.getEmail();
		this.pinyinCode = enterprise.getPinyinCode();
		this.postalCode = enterprise.getPostalcode();
		this.corporation = enterprise.getCorporation();
		this.phone = enterprise.getPhone();
		this.portraiture = enterprise.getPortraiture();
		this.taxRegisNo = enterprise.getTaxpayerRegisterNo();
		this.bankName = enterprise.getBankName();
		this.bankNumber = enterprise.getBankNumber();
		this.bankUserName = enterprise.getBankUserName();
		this.businessScope = enterprise.getBusinessScope();
		this.sales_deputy = enterprise.getSales_deputy();
		this.deliveryPersonnel = enterprise.getDeliveryPersonnel();
		this.organizationCodeDate = enterprise.getOrganization_code_date();
		this.organizationCodeInspectionDate = enterprise.getOrganization_code_inspection_date();
		this.qualityAssuranceDate = enterprise.getQuality_assurance_date();
		this.authorizationDate = enterprise.getAuthorization_date();
		this.business_licence_path = enterprise.getBusiness_licence_path();
		this.business_licence_inspection_path = enterprise.getBusiness_licence_inspection_path();//营业执照年检证明
		this.licence_path = enterprise.getLicence_path();//经营许可证路径 
		this.gsp_certificate_path = enterprise.getGsp_certificate_path();//gsp证书
		this.organization_code_path = enterprise.getOrganization_code_path();//组织机构代码
		this.organization_code_inspection_path = enterprise.getOrganization_code_inspection_path();//组织机构代码年检
		this.quality_assurance_path = enterprise.getQuality_assurance_path();//质量保证协议
		this.authorization_path = enterprise.getAuthorization_path();//委托书
		this.useFlag = "0";
		Iterator<FirstEnterpriseAccessory>  it =  enterprise.getAccessories().iterator();
		while (it.hasNext()){
			this.accessories.add( new QulifiedSupplyAccessory(it.next()));
		}
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
	@Column(name="firstEnterprise_ID")
	public Long getFirstEnterpriseId() {
		return firstEnterpriseId;
	}
	public void setFirstEnterpriseId(Long firstEnterpriseId) {
		this.firstEnterpriseId = firstEnterpriseId;
	}
	@Column(name="customer_number",length=50)
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	@Column(name="name",length=50)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name="businessLicense_ExpirationDate",length=25)
	public String getBusiLiceExpiDate() {
		return busiLiceExpiDate;
	}
	public void setBusiLiceExpiDate(String busiLiceExpiDate) {
		this.busiLiceExpiDate = busiLiceExpiDate;
	}
	@Column(name="businessLicense_annualSurvey",length=25)
	public String getBusiLIceAnnuSurvey() {
		return busiLIceAnnuSurvey;
	}
	public void setBusiLIceAnnuSurvey(String busiLIceAnnuSurvey) {
		this.busiLIceAnnuSurvey = busiLIceAnnuSurvey;
	}
	@Column(name="licence_ExpirationDate",length=25)
	public String getLiceExpiDate() {
		return liceExpiDate;
	}
	public void setLiceExpiDate(String liceExpiDate) {
		this.liceExpiDate = liceExpiDate;
	}
	@Column(name="gsp_ExpirationDate",length=25)
	public String getGspExpirDate() {
		return gspExpirDate;
	}
	public void setGspExpirDate(String gspExpirDate) {
		this.gspExpirDate = gspExpirDate;
	}
	@Column(name="litterae_credentiales_date",length=25)
	public String getLittCredentDate() {
		return littCredentDate;
	}
	public void setLittCredentDate(String littCredentDate) {
		this.littCredentDate = littCredentDate;
	}
	@Column(name="account_date",length=25)
	public String getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(String accountDate) {
		this.accountDate = accountDate;
	}
	@Column(name="ten_bit_code",length=10)
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
	@Column(name="postalcode",length=10)
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Column(name="phone",length=50)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="portraiture",length=50)
	public String getPortraiture() {
		return portraiture;
	}
	public void setPortraiture(String portraiture) {
		this.portraiture = portraiture;
	}
	@Column(name="corporation",length=50)
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	@Column(name="taxpayer_register_no",length=20)
	public String getTaxRegisNo() {
		return taxRegisNo;
	}
	public void setTaxRegisNo(String taxRegisNo) {
		this.taxRegisNo = taxRegisNo;
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
	@Column(name="bank_userName",length=50)
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
	@Column(name="modifierId")
	public Long getModifierId() {
		return modifierId;
	}
	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	@Column(name="modified_time",length=20)
	public String getModified_time() {
		return modified_time;
	}
	public void setModified_time(String modifiedTime) {
		modified_time = modifiedTime;
	}
	@Column(name="delete_flag",length=2)
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public SalesStaff getSales_deputy() {
		return sales_deputy;
	}

	public void setSales_deputy(SalesStaff salesDeputy) {
		sales_deputy = salesDeputy;
	}

	@Column(name="delivery_personnel",length=50)
	public String getDeliveryPersonnel() {
		return deliveryPersonnel;
	}

	public void setDeliveryPersonnel(String deliveryPersonnel) {
		this.deliveryPersonnel = deliveryPersonnel;
	}
	@Column(name="organization_code_date",length=20)
	public String getOrganizationCodeDate() {
		return organizationCodeDate;
	}

	public void setOrganizationCodeDate(String organizationCodeDate) {
		this.organizationCodeDate = organizationCodeDate;
	}
	@Column(name="organization_code_inspection_date",length=20)
	public String getOrganizationCodeInspectionDate() {
		return organizationCodeInspectionDate;
	}

	public void setOrganizationCodeInspectionDate(
			String organizationCodeInspectionDate) {
		this.organizationCodeInspectionDate = organizationCodeInspectionDate;
	}
	@Column(name="quality_assurance_date")
	public String getQualityAssuranceDate() {
		return qualityAssuranceDate;
	}

	public void setQualityAssuranceDate(String qualityAssuranceDate) {
		this.qualityAssuranceDate = qualityAssuranceDate;
	}
	@Column(name="remark",length=655)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="authorization_date")
	public String getAuthorizationDate() {
		return authorizationDate;
	}

	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<QulifiedSupplyAccessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(Set<QulifiedSupplyAccessory> accessories) {
		this.accessories = accessories;
	}
	@Column(name="business_licence_path",length=100)
	public String getBusiness_licence_path() {
		return business_licence_path;
	}

	public void setBusiness_licence_path(String businessLicencePath) {
		business_licence_path = businessLicencePath;
	}
	@Column(name="business_licence_inspection_path",length=100)
	public String getBusiness_licence_inspection_path() {
		return business_licence_inspection_path;
	}

	public void setBusiness_licence_inspection_path(
			String businessLicenceInspectionPath) {
		business_licence_inspection_path = businessLicenceInspectionPath;
	}
	@Column(name="licence_path",length=100)
	public String getLicence_path() {
		return licence_path;
	}

	public void setLicence_path(String licencePath) {
		licence_path = licencePath;
	}
	@Column(name="gsp_certificate_path",length=100)
	public String getGsp_certificate_path() {
		return gsp_certificate_path;
	}

	public void setGsp_certificate_path(String gspCertificatePath) {
		gsp_certificate_path = gspCertificatePath;
	}
	@Column(name="organization_code_path",length=100)
	public String getOrganization_code_path() {
		return organization_code_path;
	}

	public void setOrganization_code_path(String organizationCodePath) {
		organization_code_path = organizationCodePath;
	}
	@Column(name="organization_code_inspection_path",length=100)
	public String getOrganization_code_inspection_path() {
		return organization_code_inspection_path;
	}

	public void setOrganization_code_inspection_path(
			String organizationCodeInspectionPath) {
		organization_code_inspection_path = organizationCodeInspectionPath;
	}
	@Column(name="quality_assurance_path",length=100)
	public String getQuality_assurance_path() {
		return quality_assurance_path;
	}

	public void setQuality_assurance_path(String qualityAssurancePath) {
		quality_assurance_path = qualityAssurancePath;
	}
	@Column(name="authorization_path",length=100)
	public String getAuthorization_path() {
		return authorization_path;
	}

	public void setAuthorization_path(String authorizationPath) {
		authorization_path = authorizationPath;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<QulifiedSupplyDrugFroms> getDrugFroms() {
		return drugFroms;
	}
	public void setDrugFroms(Set<QulifiedSupplyDrugFroms> drugFroms) {
		this.drugFroms = drugFroms;
	}	
	
	@Column(name="use_flag",length=2)
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
}
