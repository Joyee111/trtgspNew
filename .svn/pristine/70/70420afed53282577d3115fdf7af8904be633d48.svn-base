package com.sinosoft.qualityRecords.adverseReactionInfo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("serial")
@Entity
@Table(name="t_adverse_reaction_doubt_item")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class AdverseReactionDoubtItem implements Serializable {
	private Long id;
	private Long adverseReactionInfoId;//不良药品反应信息id
	private Long qualifiedMedicineId;//合格药品id
	private String commonName;//通用名称 
	private String licenseNo;//批准文号 
	private String usageDosage;//用法用量
	private String beginDate;//开始用药时间
	private String reason;//用药原因 
	private String remark;//备注 
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="adverse_reaction_info_id")
	@SearchableProperty
	public Long getAdverseReactionInfoId() {
		return adverseReactionInfoId;
	}
	public void setAdverseReactionInfoId(Long adverseReactionInfoId) {
		this.adverseReactionInfoId = adverseReactionInfoId;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedMedicineId() {
		return qualifiedMedicineId;
	}
	public void setQualifiedMedicineId(Long qualifiedMedicineId) {
		this.qualifiedMedicineId = qualifiedMedicineId;
	}
	@Column(name="common_name",length=50)
	@SearchableProperty
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	@Column(name="license_number",length=50)
	@SearchableProperty
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	@Column(name="usage_dosage",length=50)
	@SearchableProperty
	public String getUsageDosage() {
		return usageDosage;
	}
	public void setUsageDosage(String usageDosage) {
		this.usageDosage = usageDosage;
	}
	@Column(name="begin_date",length=50)
	@SearchableProperty
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	@Column(name="reason",length=50)
	@SearchableProperty
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(name="remark",length=50)
	@SearchableProperty
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
		

}
