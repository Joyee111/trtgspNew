package com.sinosoft.qualityRecords.complantManager.model;

import java.io.Serializable;

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

@SuppressWarnings("serial")
@Entity
@Table(name="t_drugComInfo_item")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugComInfoItem implements Serializable {
	private Long id;
	private Long drugComInfoId;//投诉信息id
	private String zhipaiId;//指派人的id 
	private DrugComInfo drugComInfo;

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
	@Column(name="drugComInfo_id")
	@SearchableProperty
	public Long getDrugComInfoId() {
		return drugComInfoId;
	}
	public void setDrugComInfoId(Long drugComInfoId) {
		this.drugComInfoId = drugComInfoId;
	}
	@Column(name="zhipaiId",length =20)
	@SearchableProperty
	public String getZhipaiId() {
		return zhipaiId;
	}
	public void setZhipaiId(String zhipaiId) {
		this.zhipaiId = zhipaiId;
	}
	@Transient
	public DrugComInfo getDrugComInfo() {
		return drugComInfo;
	}
	public void setDrugComInfo(DrugComInfo drugComInfo) {
		this.drugComInfo = drugComInfo;
	}
}
