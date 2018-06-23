package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
/**
 * 
* @ClassName: TransporterQualification 
* @author lfl
* @date 2013-7-3 下午02:33:34 
* @Description:承运商资质
 */
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("serial")
@Entity
@Table(name="t_transporter_qualification")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TransporterQualification implements Serializable {
	private long id ;//主键ID
	private String transporterName;//承运商名称
	private String legalRepresentative;//法人代表
	private String businessLicense;//营业执照
	private String businessLicenseDate;//营业执照到期时间期
	private String transportationLicense;//运输许可证
	private String transportationLicenseDate;//运输许可证到期日期
	private String contractName;//合同名称
	private String contractDate;//合同到期日期
	private String deleteFlag;//删除停用表示 0 表示正常、1表示删除或者停用,2暂时停用
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="transporter_name",length=50)
	public String getTransporterName() {
		return transporterName;
	}
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}
	@Column(name="legal_representative",length=50)
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	@Column(name="business_license",length=50)
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	@Column(name="business_license_date",length=50)
	public String getBusinessLicenseDate() {
		return businessLicenseDate;
	}
	public void setBusinessLicenseDate(String businessLicenseDate) {
		this.businessLicenseDate = businessLicenseDate;
	}
	@Column(name="transportation_license",length=50)
	public String getTransportationLicense() {
		return transportationLicense;
	}
	public void setTransportationLicense(String transportationLicense) {
		this.transportationLicense = transportationLicense;
	}
	@Column(name="transportation_license_date",length=50)
	public String getTransportationLicenseDate() {
		return transportationLicenseDate;
	}
	public void setTransportationLicenseDate(String transportationLicenseDate) {
		this.transportationLicenseDate = transportationLicenseDate;
	}
	@Column(name="contract_name",length=50)
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	@Column(name="contract_date",length=50)
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	@Column(name="delete_flag",length=4)
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	
}
