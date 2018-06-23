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

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@SuppressWarnings("serial")
@Entity
@Table(name = "t_purchase_plan_store")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchasePlanStore implements Serializable{
	/**
	id int NOT NULL,
	year varchar(4),    -- 年份 
	season varchar(2),    -- 季度 
	qualified_medicine_id int,    -- 合格药品id 
	quantity int,    -- 数量 
	trade_price numeric(10,2),    -- 批发价 
	price numeric(10,2)    -- 金额 
	 * **/
	private Long id;
	private String year;
	private String season;
	private QualityMidicine qualityMidicine;
	private Long quantity;
	private String tradePrice;
	private String price;
	private Long qualityMidicineId;
	private String departmentId;//经营公司
	@Column(name="quality_idicine_id")
	@SearchableProperty
	public Long getQualityMidicineId() {
		return qualityMidicineId;
	}
	public void setQualityMidicineId(Long qualityMidicineId) {
		this.qualityMidicineId = qualityMidicineId;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Column(name="season",length=2)
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	@Column(name="quantity")
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="trade_price",length=20)
	public String getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}
	@Column(name="price",length=20)
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Column(name="department_id",length=20)
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
