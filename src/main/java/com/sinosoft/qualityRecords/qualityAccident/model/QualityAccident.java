package com.sinosoft.qualityRecords.qualityAccident.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@SuppressWarnings("serial")
@Entity
@Table(name="t_quality_accident_info")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualityAccident implements Serializable{
	private Long id ;//int NOT NULL,
	private Long qualifiedmedicineid;// int NOT NULL,    -- 合格药品id 
	private String number ;//varchar(20),    -- 编号 
	private String drugsnumber ;// varchar(20),    -- 药品编号 
	private Long quantity ;//int,    -- 数量 
	private String batchproduction;// varchar(50),    -- 批号 
	private String accidentconditions;// varchar(100),    -- 事故情况 
	private String handlingsuggestion;//  varchar(100),    -- 处理意见 
	private String accidentanalysis;// varchar(100),    -- 事故分析 
	private String result ;//varchar(100),    -- 处理结果 
	private Long modifierid ;//int,    -- 修改人id 
	private Date modifiedtime;// datetime    -- 修改时间 
	private Long deliveryunitid ; //  -- 供货单位id 
	private QualifiedSuppliers qualifiedSuppliers;
	private QualityMidicine qualityMidicine;
	
	@Column(name="delivery_unit_id")
	@SearchableProperty
	public Long getDeliveryunitid() {
		return deliveryunitid;
	}
	public void setDeliveryunitid(Long deliveryunitid) {
		this.deliveryunitid = deliveryunitid;
	}
	@Transient
	public QualifiedSuppliers getQualifiedSuppliers() {
		return qualifiedSuppliers;
	}
	public void setQualifiedSuppliers(QualifiedSuppliers qualifiedSuppliers) {
		this.qualifiedSuppliers = qualifiedSuppliers;
	}
	@Transient
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	
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
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public Long getQualifiedmedicineid() {
		return qualifiedmedicineid;
	}
	public void setQualifiedmedicineid(Long qualifiedmedicineid) {
		this.qualifiedmedicineid = qualifiedmedicineid;
	}
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="drugs_number",length=20)
	@SearchableProperty
	public String getDrugsnumber() {
		return drugsnumber;
	}
	public void setDrugsnumber(String drugsnumber) {
		this.drugsnumber = drugsnumber;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_production",length=50)
	@SearchableProperty
	public String getBatchproduction() {
		return batchproduction;
	}
	public void setBatchproduction(String batchproduction) {
		this.batchproduction = batchproduction;
	}
	@Column(name="accident_conditions",length=100)
	@SearchableProperty
	public String getAccidentconditions() {
		return accidentconditions;
	}
	public void setAccidentconditions(String accidentconditions) {
		this.accidentconditions = accidentconditions;
	}
	@Column(name="handling_suggestion",length=100)
	@SearchableProperty
	public String getHandlingsuggestion() {
		return handlingsuggestion;
	}
	public void setHandlingsuggestion(String handlingsuggestion) {
		this.handlingsuggestion = handlingsuggestion;
	}
	@Column(name="accident_analysis",length=100)
	@SearchableProperty
	public String getAccidentanalysis() {
		return accidentanalysis;
	}
	public void setAccidentanalysis(String accidentanalysis) {
		this.accidentanalysis = accidentanalysis;
	}
	@Column(name="result",length=100)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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

