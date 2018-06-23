package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

/**
 * 合格药品库
 * @author zyk
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_qualified_medc_store")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class Qualifiedmedcstore implements Serializable{
	private long id;
	private Long qualifiedmedicineid;// int,    -- 合格药品id 
	private Long quantity ;//int,    -- 数量 
	private String batchproduction;// varchar(50),    -- 生产批号 
	private String  validdate;// varchar(10)    -- 有效期至 
	private String nextmaintaindate;// datetime    -- 下一个养护日期 
	private QualityMidicine qualityMidicine;//合格 药品
	private String receivedDate;//收货日期
	private String createdate;//创建时间
	private String color;

	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Column(name="received_date",length=50)
	@SearchableProperty
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Column(name="next_maintain_date",length = 50)
	@SearchableProperty
	public String getNextmaintaindate() {
		return nextmaintaindate;
	}
	public void setNextmaintaindate(String nextmaintaindate) {
		this.nextmaintaindate = nextmaintaindate;
	}
	@Column(name="creatdate",length = 50)
	@SearchableProperty
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}


}
