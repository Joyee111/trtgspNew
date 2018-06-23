package com.sinosoft.qualityRecords.qualityQuery.model;

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
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@SuppressWarnings("serial")
@Entity
@Table(name=" t_quality_records")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QulityQuery  implements Serializable {
	private Long id;
	private String  qualifiedmedicineid ;//合格药品id 
	private String inquiryunit;//查询单位
	private String quantity;//数量 
	private String batchproduction;//生产批号 
	private String qualitydate;//查询时间 
	private String qualityreason;//查询原因 
	private String checksituation;//查核情况 
	private String result;//处理结果 
	private Long modifierid;//修改人-id
	private Date modifiedtime ;//修改时间 
	private String  jixing  ;//剂型
	private String  guige  ;//规格
	private String  pihao  ;//批准文号
	private String scdw;//生产厂家
	
	private QualityMidicine qualityMidicine;
	
//	@ManyToOne(targetEntity=QualityMidicine.class,cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
//	@Fetch(FetchMode.JOIN)
//	@JoinColumn(name="quaMedicIds",updatable=false)
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
	public String getQualifiedmedicineid() {
		return qualifiedmedicineid;
	}
	public void setQualifiedmedicineid(String qualifiedmedicineid) {
		this.qualifiedmedicineid = qualifiedmedicineid;
	}
	@Column(name="inquiry_unit",length=20)
    @SearchableProperty
	public String getInquiryunit() {
		return inquiryunit;
	}
	public void setInquiryunit(String inquiryunit) {
		this.inquiryunit = inquiryunit;
	}
	@Column(name="quantity",length=20)
    @SearchableProperty
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_production" ,length=50)
    @SearchableProperty
	public String getBatchproduction() {
		return batchproduction;
	}
	public void setBatchproduction(String batchproduction) {
		this.batchproduction = batchproduction;
	}
	@Column(name="quality_date" ,length=100)
    @SearchableProperty
	public String getQualitydate() {
		return qualitydate;
	}
	public void setQualitydate(String qualitydate) {
		this.qualitydate = qualitydate;
	}
	@Column(name="quality_reason" ,length=1000)
    @SearchableProperty
	public String getQualityreason() {
		return qualityreason;
	}
	public void setQualityreason(String qualityreason) {
		this.qualityreason = qualityreason;
	}
	@Column(name="check_situation" ,length=1000)
    @SearchableProperty
	public String getChecksituation() {
		return checksituation;
	}
	public void setChecksituation(String checksituation) {
		this.checksituation = checksituation;
	}
	@Column(name="result" ,length=1000)
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
	@Column(name="jixing",length=100)
    @SearchableProperty
	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	@Column(name="guige",length=100)
    @SearchableProperty
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	@Column(name="pihao",length=100)
    @SearchableProperty
	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}
	@Column(name="scdw",length=100)
    @SearchableProperty
	public String getScdw() {
		return scdw;
	}

	public void setScdw(String scdw) {
		this.scdw = scdw;
	}

	

}
