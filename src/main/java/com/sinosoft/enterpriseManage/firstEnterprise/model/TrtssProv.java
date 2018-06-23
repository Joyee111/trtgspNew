package com.sinosoft.enterpriseManage.firstEnterprise.model;

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

@Entity
@Table(name = "trtss_prov")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TrtssProv {
	/**
	id int NOT NULL,
	prov_id varchar(10),    -- 省份id 
	prov_name varchar(50)    -- 省份名称 
	 * **/
	Long id;
	private String provId;
	private String provName;
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
	@Column(name="prov_id",length=10)
	@SearchableProperty
	public String getProvId() {
		return provId;
	}
	public void setProvId(String provId) {
		this.provId = provId;
	}
	@Column(name="prov_name",length=50)
	@SearchableProperty
	public String getProvName() {
		return provName;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	

}
