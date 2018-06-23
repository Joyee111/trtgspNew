package com.sinosoft.qualityRecords.adverseReactionInfo.model;


import java.io.Serializable;
import java.util.Date;
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
@Table(name="t_adverse_reaction_info")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class AdverseReactionInfo implements Serializable {
	private Long id;
	private String name;//不良反应名称
	private String occurrenceDate;//发生时间
	private String medicalRecordNo;//病历号
	private int type;//不良反应类型 1 新的 2 一般 3 严重 
	private int reportType;//上报者类型 1 机构 2 企业 3 个人 
	private String unitName;//单位名称 
	private String departmentName;//部门名称
	private String phone;//电话
	private String reportDate;//报告日期
	private String patientName;//患者名称 
	private int gender;//性别 
	private String nation;//民族
	private String birthdate;//出生日期
	private String weight;//体重
	private int familyAdverseReaction;//家族不良反应 
	private int sinceAdverseReaction;//既往不良反应
	private String adverseReactionResult;//不良反应结果
	private String originalDisease;//原疾病
	private int influence;//对原疾病影响
	private int similarDomestic;// 国内类似
	private int foreignSimilar;// 国外类似 
	private String procedureDescription;//过程描述
	private Long modifierid;//修改人-id
	private Date modifiedtime ;//修改时间 
	
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
	@Column(name="name",length=50)
	@SearchableProperty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="occurrence_date",length=50)
	@SearchableProperty
	public String getOccurrenceDate() {
		return occurrenceDate;
	}
	public void setOccurrenceDate(String occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
	}
	@Column(name="medical_record_number",length=50)
	@SearchableProperty
	public String getMedicalRecordNo() {
		return medicalRecordNo;
	}
	public void setMedicalRecordNo(String medicalRecordNo) {
		this.medicalRecordNo = medicalRecordNo;
	}
	@Column(name="type")
	@SearchableProperty
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name="report_type")
	@SearchableProperty
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}
	@Column(name="unit_name",length=50)
	@SearchableProperty
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	@Column(name="department_name",length=50)
	@SearchableProperty
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Column(name="phone",length=50)
	@SearchableProperty
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="report_date",length=50)
	@SearchableProperty
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	@Column(name="patient_name",length=50)
	@SearchableProperty
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Column(name="gender")
	@SearchableProperty
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Column(name="nation",length=50)
	@SearchableProperty
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	@Column(name="birthdate" ,length=50)
	@SearchableProperty
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Column(name="weight",length=50)
	@SearchableProperty
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Column(name="family_adverse_reaction",length=50)
	@SearchableProperty
	public int getFamilyAdverseReaction() {
		return familyAdverseReaction;
	}
	public void setFamilyAdverseReaction(int familyAdverseReaction) {
		this.familyAdverseReaction = familyAdverseReaction;
	}
	@Column(name="since_adverse_reaction",length=50)
	@SearchableProperty
	public int getSinceAdverseReaction() {
		return sinceAdverseReaction;
	}
	public void setSinceAdverseReaction(int sinceAdverseReaction) {
		this.sinceAdverseReaction = sinceAdverseReaction;
	}
	@Column(name="adverse_reaction_result",length=50)
	@SearchableProperty
	public String getAdverseReactionResult() {
		return adverseReactionResult;
	}
	public void setAdverseReactionResult(String adverseReactionResult) {
		this.adverseReactionResult = adverseReactionResult;
	}
	@Column(name="original_disease",length=50)
	@SearchableProperty
	public String getOriginalDisease() {
		return originalDisease;
	}
	public void setOriginalDisease(String originalDisease) {
		this.originalDisease = originalDisease;
	}
	@Column(name="influence",length=50)
	@SearchableProperty
	public int getInfluence() {
		return influence;
	}
	public void setInfluence(int influence) {
		this.influence = influence;
	}
	@Column(name="similar_domestic",length=50)
	@SearchableProperty
	public int getSimilarDomestic() {
		return similarDomestic;
	}
	public void setSimilarDomestic(int similarDomestic) {
		this.similarDomestic = similarDomestic;
	}
	@Column(name="foreign_similar")
	@SearchableProperty
	public int getForeignSimilar() {
		return foreignSimilar;
	}
	public void setForeignSimilar(int foreignSimilar) {
		this.foreignSimilar = foreignSimilar;
	}
	@Column(name="procedure_description",length=100)
	@SearchableProperty
	public String getProcedureDescription() {
		return procedureDescription;
	}
	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}
	@Column(name="modifier_id")
	@SearchableProperty
	public Long getModifierid() {
		return modifierid;
	}
	public void setModifierid(Long modifierid) {
		this.modifierid = modifierid;
	}
	@Column(name="modified_time")
	@SearchableProperty
	public Date getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	
}
