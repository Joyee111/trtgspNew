package com.sinosoft.qualityRecords.drugMaintenance.model;

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

import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
@SuppressWarnings("serial")
@Entity
@Table(name="t_maintain_info ")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugMaintenance implements Serializable{
	private  Long id;//NOT NULL,
	private Long qualifiedmedicineid;// int NOT NULL,    -- 合格药品库id 
	private String maintaindate;// datetime,    -- 养护日期 
	private String goodsallocation;// varchar(50),    -- 货位 
	private Long quantity ;//int,    -- 数量 
	private String batchnumber;// varchar(20),    -- 批号 
	private String qualityproblemString;// varchar(200),    -- 质量情况 
	private String conservationmeasures;// varchar(50),    -- 养护措施 
	private String result;// varchar(100),    -- 处理结果 
	private String remark ;//varchar(100),    -- 备注 
	private Long modifierid ;//int,    -- 修改人id 
	private Date modifiedtime;// datetime    -- 修改时间 
	private String isqualified;// tinyint,    -- 故障是否排除 0 否 1 是 
	

	private QualifiedmedcstoreRe qualifiedmedcstoreRe;//新合格药品库，包括返厂的

	private   User  user;
	@Transient
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="is_qualified",length=20)
	@SearchableProperty
	public String getIsqualified() {
		return isqualified;
	}
	public void setIsqualified(String isqualified) {
		this.isqualified = isqualified;
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
	@Column(name="maintain_date")
	@SearchableProperty
	public String getMaintaindate() {
		return maintaindate;
	}
	public void setMaintaindate(String maintaindate) {
		this.maintaindate = maintaindate;
	}
	@Column(name="goods_allocation",length=50)
	@SearchableProperty
	public String getGoodsallocation() {
		return goodsallocation;
	}
	public void setGoodsallocation(String goodsallocation) {
		this.goodsallocation = goodsallocation;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_numbe",length=20)
	@SearchableProperty
	public String getBatchnumber() {
		return batchnumber;
	}
	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}
	@Column(name="quality_problem",length=200)
	@SearchableProperty
	public String getQualityproblemString() {
		return qualityproblemString;
	}
	public void setQualityproblemString(String qualityproblemString) {
		this.qualityproblemString = qualityproblemString;
	}
	@Column(name="conservation_measures",length=50)
	@SearchableProperty
	public String getConservationmeasures() {
		return conservationmeasures;
	}
	public void setConservationmeasures(String conservationmeasures) {
		this.conservationmeasures = conservationmeasures;
	}
	@Column(name="result",length=100)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="remark",length=100)
	@SearchableProperty
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public QualifiedmedcstoreRe getQualifiedmedcstoreRe() {
		return qualifiedmedcstoreRe;
	}
	public void setQualifiedmedcstoreRe(QualifiedmedcstoreRe qualifiedmedcstoreRe) {
		this.qualifiedmedcstoreRe = qualifiedmedcstoreRe;
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
