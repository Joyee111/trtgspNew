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
 * @author cbl:
 * @version 创建时间：Nov 28, 2014 16:09:00 AM
 * 类说明
 * 公司资质Model
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_company_quality_management")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class OurQualityManagement implements Serializable{
	
	private Long id;//主键ID
	private String customer_name;//公司名称
	private String address;//企业地址
	private String businessScope;//经营范围
	private String legalRepresentative;//法定代表人
	private String qualityPrincipal;//质量负责人
	private String businessLicencePath;//营业执照路径
	private String businessLicenceDate;//营业执照到期时间
	private String businessPermitPath;//经营许可证路径
	private String businessPermitDate;//经营许可证到期时间
	private String gspCertificatePath;//GSP路径
	private String gspCertificateDate;//GSP到期时间
	private String organizationCodePath;//组织机构代码证路径
	private String organizationCodeDate;//组织机构代码到期时间
	private Integer delete_flag;////删除表示  0 未删除 1 已删除
	private String useFlag;//使用标识 0表示启用，1表示停用 默认为使用状态
	private String remark;//备注
	
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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="customer_name",length=100)
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customerName) {
		customer_name = customerName;
	}
	
	@Column(name="address",length=255)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="businessScope",length=655)
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	
	@Column(name="legalRepresentative",length=20)
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	@Column(name="qualityPrincipal",length=20)
	public String getQualityPrincipal() {
		return qualityPrincipal;
	}
	public void setQualityPrincipal(String qualityPrincipal) {
		this.qualityPrincipal = qualityPrincipal;
	}
	
	@Column(name="businessLicencePath",length=255)
	public String getBusinessLicencePath() {
		return businessLicencePath;
	}
	public void setBusinessLicencePath(String businessLicencePath) {
		this.businessLicencePath = businessLicencePath;
	}
	
	@Column(name="businessLicenceDate")
	public String getBusinessLicenceDate() {
		return businessLicenceDate;
	}
	public void setBusinessLicenceDate(String businessLicenceDate) {
		this.businessLicenceDate = businessLicenceDate;
	}
	
	@Column(name="businessPermitPath",length=255)
	public String getBusinessPermitPath() {
		return businessPermitPath;
	}
	public void setBusinessPermitPath(String businessPermitPath) {
		this.businessPermitPath = businessPermitPath;
	}
	
	@Column(name="businessPermitDate")
	public String getBusinessPermitDate() {
		return businessPermitDate;
	}
	public void setBusinessPermitDate(String businessPermitDate) {
		this.businessPermitDate = businessPermitDate;
	}
	
	@Column(name="gspCertificatePath",length=255)
	public String getGspCertificatePath() {
		return gspCertificatePath;
	}
	public void setGspCertificatePath(String gspCertificatePath) {
		this.gspCertificatePath = gspCertificatePath;
	}
	
	@Column(name="gspCertificateDate")
	public String getGspCertificateDate() {
		return gspCertificateDate;
	}
	public void setGspCertificateDate(String gspCertificateDate) {
		this.gspCertificateDate = gspCertificateDate;
	}
	
	@Column(name="organizationCodePath",length=255)
	public String getOrganizationCodePath() {
		return organizationCodePath;
	}
	public void setOrganizationCodePath(String organizationCodePath) {
		this.organizationCodePath = organizationCodePath;
	}
	
	@Column(name="organizationCodeDate")
	public String getOrganizationCodeDate() {
		return organizationCodeDate;
	}
	public void setOrganizationCodeDate(String organizationCodeDate) {
		this.organizationCodeDate = organizationCodeDate;
	}
	
	@Column(name="remark",length=655)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}
