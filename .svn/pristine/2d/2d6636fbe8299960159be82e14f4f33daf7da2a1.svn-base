package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.dictionary.mode.DrugFormDictionary;
@SuppressWarnings("serial")
@Entity
@Table(name="t_supply_drug_froms")
@Transactional
public class QulifiedSupplyDrugFroms implements Serializable {
	private Long id;
	private Long qualifiedSuppliers_id;//供应商ID
	private Long drugFormDictionary_id;//剂型id
	private String drugFormDate;//剂型到期时间
	private DrugFormDictionary drugFormDictionary;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="qualifiedSuppliers_id")
	public void setQualifiedSuppliers_id(Long qualifiedSuppliers_id) {
		this.qualifiedSuppliers_id = qualifiedSuppliers_id;
	}
	public Long getQualifiedSuppliers_id() {
		return qualifiedSuppliers_id;
	}
	@Column(name="drugForm_id")
	public void setDrugFormDictionary_id(Long drugFormDictionary_id) {
		this.drugFormDictionary_id = drugFormDictionary_id;
	}
	public Long getDrugFormDictionary_id() {
		return drugFormDictionary_id;
	}
	@Column(name="drugForm_date")
	public void setDrugFormDate(String drugFormDate) {
		this.drugFormDate = drugFormDate;
	}
	public String getDrugFormDate() {
		return drugFormDate;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public void setDrugFormDictionary(DrugFormDictionary drugFormDictionary) {
		this.drugFormDictionary = drugFormDictionary;
	}
	public DrugFormDictionary getDrugFormDictionary() {
		return drugFormDictionary;
	}
}
