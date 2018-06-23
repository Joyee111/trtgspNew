package com.sinosoft.drugState.procurementProgram.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_purchase_plan_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchasePlan implements Serializable{
	/**
	id int NOT NULL,
	year varchar(4),    -- 年度 
	season varchar(2),    -- 季度 
	qualifiedSupplier_id int    -- 合格供应商id 
	purchaseTime 					---购货日期
	plan_no     ----计划编号
	 * **/
	private Long id;
	private String year;
	private String season;
	private Long qualifiedSupplierId;
	private String purchaseTime;
	private QualifiedSuppliers qualifiedSupplier;//供货商
	private String planNo;
	private String departmentId;//经营公司ID
	@Column(name="plan_no",length=20)
	@SearchableProperty
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	@Column(name="purchase_time",length=20)
	@SearchableProperty
	public String getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getQualifiedSupplier() {
		return qualifiedSupplier;
	}
	public void setQualifiedSupplier(QualifiedSuppliers qualifiedSupplier) {
		this.qualifiedSupplier = qualifiedSupplier;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="year",length=4)
	@SearchableProperty
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Column(name="season",length=2)
	@SearchableProperty
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	@Column(name="qualifiedSupplierId")
	@SearchableProperty
	public Long getQualifiedSupplierId() {
		return qualifiedSupplierId;
	}
	public void setQualifiedSupplierId(Long qualifiedSupplierId) {
		this.qualifiedSupplierId = qualifiedSupplierId;
	}
	@Column(name="department_id",length=20)
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
}
