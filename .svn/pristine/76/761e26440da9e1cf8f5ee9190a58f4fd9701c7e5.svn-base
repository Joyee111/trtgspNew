package com.sinosoft.drugState.scrap.model;

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
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

/**
 * 报废药品
 * @author whn
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_scrap_medicine")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ScrapMedicine implements Serializable{
	private Long id; // NOT NULL,
	private Long  qualifiedmedicineid ;//合格药品库id 
	private Long qualifiedpurchaseunitsid; //int,    -- 购货单位id(暂时不用，同一批号的药品可能有多个购货单位）
	private Long quantity ;  // -- 数量 
	private String batchno ;//varchar(50),    -- 生产批号 
	private String shipmentdate;// datetime,    -- 来货日期 
	private String qualitysituation; // varchar(100),    -- 检查情况 
	private String result ;//varchar(100),    -- 处理意见
	private String remark; //varchar(100),    -- 备注 
	private Long modifierid ;   // -- 修改人id 
	private Date modifiedtime  ;//   -- 修改时间 
	private Qualifiedmedcstore qualifiedmedcstore;//合格药品库
	private QualifiedSuppliers qualifiedSuppliers;
	private String harvestNumber;//收获凭证号
	private String unqualified;//不合格项
	private String processingNo;//处理单号
	private String processingDate;//处理日期
	private User user;
	private String medicinalNo;// 药品号码
	private String validUntil;//有效期至
	private String scrapReason; //申请报废原因
	private String applyTime; //申请时间
	private String status; //状态：0录入 1审核 2已审核
	private String lossProperty; //财损
	private String state;//A合格，C不合格
	
	
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="harvestNumber" ,length=50)
	@SearchableProperty
	public String getHarvestNumber() {
		return harvestNumber;
	}

	public void setHarvestNumber(String harvestNumber) {
		this.harvestNumber = harvestNumber;
	}
	@Column(name="unqualified" ,length=50)
	@SearchableProperty
	public String getUnqualified() {
		return unqualified;
	}

	public void setUnqualified(String unqualified) {
		this.unqualified = unqualified;
	}
	@Column(name="processingNo" ,length=50)
	@SearchableProperty
	public String getProcessingNo() {
		return processingNo;
	}

	public void setProcessingNo(String processingNo) {
		this.processingNo = processingNo;
	}


	@Column(name="processingDate" ,length=50)
	@SearchableProperty
	public String getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(String processingDate) {
		this.processingDate = processingDate;
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
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedpurchaseunitsid() {
		return qualifiedpurchaseunitsid;
	}
	public void setQualifiedpurchaseunitsid(Long qualifiedpurchaseunitsid) {
		this.qualifiedpurchaseunitsid = qualifiedpurchaseunitsid;
	}
	@Column(name="quantity ")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_no" ,length=50)
	@SearchableProperty
	public String getBatchno() {
		return batchno;
	}
	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}
	@Column(name="shipment_date" ,length=50)
	@SearchableProperty
	public String getShipmentdate() {
		return shipmentdate;
	}
	public void setShipmentdate(String shipmentdate) {
		this.shipmentdate = shipmentdate;
	}
	@Column(name="quality_situation" ,length=100)
	@SearchableProperty
	public String getQualitysituation() {
		return qualitysituation;
	}
	public void setQualitysituation(String qualitysituation) {
		this.qualitysituation = qualitysituation;
	}
	
	@Column(name="loss_property" ,length=20)
	@SearchableProperty
	public String getLossProperty() {
		return lossProperty;
	}
	public void setLossProperty(String lossProperty) {
		this.lossProperty = lossProperty;
	}
	
	
	
	
	@Column(name="result" ,length=100)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="remark" ,length=100)
	@SearchableProperty
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@Transient
	public Qualifiedmedcstore getQualifiedmedcstore() {
		return qualifiedmedcstore;
	}

	public void setQualifiedmedcstore(Qualifiedmedcstore qualifiedmedcstore) {
		this.qualifiedmedcstore = qualifiedmedcstore;
	}

	@Transient
	public QualifiedSuppliers getQualifiedSuppliers() {
		return qualifiedSuppliers;
	}
	public void setQualifiedSuppliers(QualifiedSuppliers qualifiedSuppliers) {
		this.qualifiedSuppliers = qualifiedSuppliers;
	}
	@Column(name="medicina_no",length=50)
	public String getMedicinalNo() {
		return medicinalNo;
	}

	public void setMedicinalNo(String medicinalNo) {
		this.medicinalNo = medicinalNo;
	}
	@Column(name="valid_until",length=20)
	public String getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}
	@Column(name="scrap_reason",length=255)
	public String getScrapReason() {
		return scrapReason;
	}

	public void setScrapReason(String scrapReason) {
		this.scrapReason = scrapReason;
	}
	@Column(name="apply_time",length=10)
	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	@Column(name="status",length=1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="state",length=1)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
