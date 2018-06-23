package com.sinosoft.qualityRecords.infoFeedback.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("serial")
@Entity
@Table(name="t_feedback_info")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class InfoFeedback  implements Serializable{
	private Long id;
	private String  commonName ;//通用名称
	private String  specification;//规格
	private String  drugForm;//剂型
	private String  approvalNumber;//批准文号
	private String  manufacturer;//生产厂家
	private String  unit;//单位
	private String batchproduction;//批号
	private String quantity ;  // -- 数量 
	private String feedbackdepartment ;//    -- 反馈部门 
	private String feedbacksuggestion ; //   -- 质量情况反映
	private Long createPersonId;//创建人ID
	private Date createDate  ;//   -- 创建时间 
	private String returnUnit;//来货单位
	private String type;//类型0、指派，1、被指派
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="common_name",length=50)
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	@Column(name="specification",length=50)
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	@Column(name="drug_form",length=50)
	public String getDrugForm() {
		return drugForm;
	}
	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}
	@Column(name="approvalNumber",length=100)
	public String getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	@Column(name="manufacturer",length=100)
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Column(name="unit",length=50)
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name="batch_production",length=20)
	public String getBatchproduction() {
		return batchproduction;
	}
	public void setBatchproduction(String batchproduction) {
		this.batchproduction = batchproduction;
	}
	@Column(name="quantity",length=20)
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name="feedbackdepartment",length=100)
	public String getFeedbackdepartment() {
		return feedbackdepartment;
	}
	public void setFeedbackdepartment(String feedbackdepartment) {
		this.feedbackdepartment = feedbackdepartment;
	}
	@Column(name="feedbacksuggestion",columnDefinition="text")
	public String getFeedbacksuggestion() {
		return feedbacksuggestion;
	}
	public void setFeedbacksuggestion(String feedbacksuggestion) {
		this.feedbacksuggestion = feedbacksuggestion;
	}
	@Column(name="createPerson_Id")
	public Long getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name="return_unit",length=100)
	public String getReturnUnit() {
		return returnUnit;
	}
	public void setReturnUnit(String returnUnit) {
		this.returnUnit = returnUnit;
	}
	@Transient
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
