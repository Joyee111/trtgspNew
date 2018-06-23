package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

/**
 * 委托储存单位资质Model
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_commissioned_storage_unit_qualification")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class CommissionedStorageUnitQualification  implements Serializable {
	private long id;
	private long companyNumber;//公司编号
	private String companyName;// 企业名称
	private String legalRepresentative;// 法定代表人
	private String compamyAddress;// 企业地址
	private String quality_principal;// 质量负责人
	private String taxReceiptAddress;//税票信息地址
	private String taxReceiptPhone;//税票电话
	private String storageScope;//储存范围
	private String warehouseAddress;//储存仓库地址
	private String business_licence_path;// 营业执照路径
	private String business_licence_date;// 营业执照到期时间期
	private String licence_path;// 经营许可证路径
	private String licence_date;// 经营许可证到期时间
//	private String pinyinCode;// 拼音码
//	private String portraiture;// 传真
	private String bankName;// 开户银行
	private String bankNumber;// 开户银行账号
//	private String bankUserName;// 开户户名
	private String gsp_certificate_path;// gsp证书
	private String gsp_certificate_date;// gsp证书到期日期
	private String organization_code_path;// 组织机构代码
	private String organization_code_date;// 组织机构代码到期时间期
	private String organization_code_inspection_date;//组织机构代码年检时间
	private String tax_Registration_Certificate_Path;//税务登记证
	private String third_logistics_drug_confirmation_path;//第三方药品物流业务确认书
	private String third_logistics_drug_confirmation_date;//第三方药品物流业务确认书到期时间
	private Integer delete_flag;////删除表示  0 未删除 1 已删除
	private String useFlag;//使用标识 0表示启用，1表示停用 默认为使用状态
	private String remark;// 备注

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="CompanyNumber")
	public long getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(long companyNumber) {
		this.companyNumber = companyNumber;
	}

	@Column(name="delete_flag")
	public Integer getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(Integer deleteFlag) {
		delete_flag = deleteFlag;
	}
	
	@Column(name="use_flag",length=2)
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	
	@Column(name = "companyName", length = 50)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "legalRepresentative", length = 20)
	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	@Column(name = "compamyAddress", length = 100)
	public String getCompamyAddress() {
		return compamyAddress;
	}

	public void setCompamyAddress(String compamyAddress) {
		this.compamyAddress = compamyAddress;
	}


	@Column(name = "quality_principal", length = 20)
	public String getQuality_principal() {
		return quality_principal;
	}

	public void setQuality_principal(String qualityPrincipal) {
		quality_principal = qualityPrincipal;
	}

	@Column(name = "business_licence_path", length = 200)
	public String getBusiness_licence_path() {
		return business_licence_path;
	}

	public void setBusiness_licence_path(String businessLicencePath) {
		business_licence_path = businessLicencePath;
	}

	@Column(name = "business_licence_date", length = 20)
	public String getBusiness_licence_date() {
		return business_licence_date;
	}

	public void setBusiness_licence_date(String businessLicenceDate) {
		business_licence_date = businessLicenceDate;
	}

	@Column(name = "licence_path", length = 200)
	public String getLicence_path() {
		return licence_path;
	}

	public void setLicence_path(String licencePath) {
		licence_path = licencePath;
	}

	@Column(name = "licence_date", length = 20)
	public String getLicence_date() {
		return licence_date;
	}

	public void setLicence_date(String licenceDate) {
		licence_date = licenceDate;
	}

	@Column(name = "bankName", length = 50)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "bankNumber", length = 100)
	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	@Column(name = "gsp_certificate_path", length = 200)
	public String getGsp_certificate_path() {
		return gsp_certificate_path;
	}

	public void setGsp_certificate_path(String gspCertificatePath) {
		gsp_certificate_path = gspCertificatePath;
	}

	@Column(name = "gsp_certificate_date", length = 20)
	public String getGsp_certificate_date() {
		return gsp_certificate_date;
	}

	public void setGsp_certificate_date(String gspCertificateDate) {
		gsp_certificate_date = gspCertificateDate;
	}

	@Column(name = "organization_code_path", length = 200)
	public String getOrganization_code_path() {
		return organization_code_path;
	}

	public void setOrganization_code_path(String organizationCodePath) {
		organization_code_path = organizationCodePath;
	}

	@Column(name = "organization_code_date", length = 20)
	public String getOrganization_code_date() {
		return organization_code_date;
	}

	public void setOrganization_code_date(String organizationCodeDate) {
		organization_code_date = organizationCodeDate;
	}

	@Column(name = "organization_code_inspection_date", length = 20)
	public String getOrganization_code_inspection_date() {
		return organization_code_inspection_date;
	}

	public void setOrganization_code_inspection_date(
			String organizationCodeInspectionDate) {
		organization_code_inspection_date = organizationCodeInspectionDate;
	}

	@Column(name = "remark", length = 655)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "taxReceiptAddress", length = 100)
	public String getTaxReceiptAddress() {
		return taxReceiptAddress;
	}

	public void setTaxReceiptAddress(String taxReceiptAddress) {
		this.taxReceiptAddress = taxReceiptAddress;
	}

	@Column(name = "taxReceiptPhone", length = 100)
	public String getTaxReceiptPhone() {
		return taxReceiptPhone;
	}

	public void setTaxReceiptPhone(String taxReceiptPhone) {
		this.taxReceiptPhone = taxReceiptPhone;
	}
	
	@Column(name = "storageScope", length = 655)
	public String getStorageScope() {
		return storageScope;
	}

	public void setStorageScope(String storageScope) {
		this.storageScope = storageScope;
	}
	
	@Column(name="warehouseAddress",length=100)
	public String getWarehouseAddress() {
		return warehouseAddress;
	}

	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}

	@Column(name="tax_Registration_Certificate_Path",length=200)
	public String getTax_Registration_Certificate_Path() {
		return tax_Registration_Certificate_Path;
	}

	public void setTax_Registration_Certificate_Path(
			String taxRegistrationCertificatePath) {
		tax_Registration_Certificate_Path = taxRegistrationCertificatePath;
	}

	@Column(name="third_logistics_drug_confirmation_path",length=200)
	public String getThird_logistics_drug_confirmation_path() {
		return third_logistics_drug_confirmation_path;
	}

	public void setThird_logistics_drug_confirmation_path(
			String thirdLogisticsDrugConfirmationPath) {
		third_logistics_drug_confirmation_path = thirdLogisticsDrugConfirmationPath;
	}

	@Column(name="third_logistics_drug_confirmation_date",length=20)
	public String getThird_logistics_drug_confirmation_date() {
		return third_logistics_drug_confirmation_date;
	}

	public void setThird_logistics_drug_confirmation_date(
			String thirdLogisticsDrugConfirmationDate) {
		third_logistics_drug_confirmation_date = thirdLogisticsDrugConfirmationDate;
	}


}
