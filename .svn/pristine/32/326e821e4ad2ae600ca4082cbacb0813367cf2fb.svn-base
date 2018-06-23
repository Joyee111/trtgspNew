package com.sinosoft.varietyManger.firstVarietyManger.model;

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

/**
 * 作废药品库
 * @author zyf
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_invalid_medc_store")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class InvalidMedcStore implements Serializable{
	
	private Long id;
	private Long qualifiedmedicineid;// int,    -- 合格药品id 
	private Long quantity ;//int,    -- 数量 
	private String batchproduction;// varchar(50),    -- 生产批号 
	private String  validdate;// varchar(10)    -- 有效期至 
	private String status;//0表示不能生成不合格品记录、1、表示可以生成不合格品记录
	
	
	
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
	@Column(name="quantity ")
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
	@Column(name="valid_date",length = 50)
	@SearchableProperty
	public String getValiddate() {
		return validdate;
	}
	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}
	@Column(name="status",length=2)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
