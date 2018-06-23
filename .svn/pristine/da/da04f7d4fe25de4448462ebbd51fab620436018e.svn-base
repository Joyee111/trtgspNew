package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="t_quality_files")
@Transactional
public class QualityFiles implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1005684699735452L;
	private Long id;//主键
	private QualityMidicine qualityMidicine;
	private String vendorLicensesStatus;//厂商证照审核情况
	private String registeredTrademarkName;//注册商标名称
	private String approvalDocumentName;//批准文件名称
	private String 	qualityStandardsName;//质量标准名称
	private String inspectionYeportStatus;//检验报告书审核情况
	private String packageStatus;//包装审核情况
	private String brochuresStatus;//标签、说明书审核情况
	private String createDate;//建党时间
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,targetEntity=QualityMidicine.class)
	@JoinColumn(name="medic_id")
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@Column(name="vendor_licenses_status",length=655)
	public String getVendorLicensesStatus() {
		return vendorLicensesStatus;
	}
	public void setVendorLicensesStatus(String vendorLicensesStatus) {
		this.vendorLicensesStatus = vendorLicensesStatus;
	}
	@Column(name="registered_trademark_name",length=655)
	public String getRegisteredTrademarkName() {
		return registeredTrademarkName;
	}
	public void setRegisteredTrademarkName(String registeredTrademarkName) {
		this.registeredTrademarkName = registeredTrademarkName;
	}
	@Column(name="approval_document_name",length=655)
	public String getApprovalDocumentName() {
		return approvalDocumentName;
	}
	public void setApprovalDocumentName(String approvalDocumentName) {
		this.approvalDocumentName = approvalDocumentName;
	}
	@Column(name="quality_standards_name",length=655)
	public String getQualityStandardsName() {
		return qualityStandardsName;
	}
	public void setQualityStandardsName(String qualityStandardsName) {
		this.qualityStandardsName = qualityStandardsName;
	}
	@Column(name="inspection_yeport_status",length=655)
	public String getInspectionYeportStatus() {
		return inspectionYeportStatus;
	}
	public void setInspectionYeportStatus(String inspectionYeportStatus) {
		this.inspectionYeportStatus = inspectionYeportStatus;
	}
	@Column(name="package_status",length=655)
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
	@Column(name="brochures_status",length=655)
	public String getBrochuresStatus() {
		return brochuresStatus;
	}
	public void setBrochuresStatus(String brochuresStatus) {
		this.brochuresStatus = brochuresStatus;
	}
	@Column(name="create_date",length=10)
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
