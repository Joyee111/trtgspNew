package com.sinosoft.drugState.inspectionRecords.model;

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
import com.sinosoft.user.User;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_purchase_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchaseOrder implements Serializable{
	
	/**
	id int NOT NULL,
	qualifiedSupplier_id int,    -- 合格供应商id 
	number varchar(12),    -- 采购单号 
	modify_date datetime,    -- 修改时间  采购订单的订单日期 药品采购记录的 购货日期  入库单制单的供货日期
	modifier int    -- 修改人 
	season String   --当前季度
	* */
	private Long id ;
	private QualifiedSuppliers qualifiedSupplierId;
	private String number;
	private String modifyDate;
	private Long modifier;
	private User user;
	private String season;
	private String departmentId;
	private String status;//状态 0表示录入、1表示待审核、2表示已审核
	private String rejectFlag;//状态1表示审核通过后驳回状态 默认状态为NULL
	private String useFlag;//使用状态  0表示使用 1表示停用
	private String reason;//作废原因
    private String checkAcceptDate;//验收日期
    private Long accepterID1;//验收人1
    private Long accepterID2;//验收人2
    
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getQualifiedSupplierId() {
		return qualifiedSupplierId;
	}
	public void setQualifiedSupplierId(QualifiedSuppliers qualifiedSupplierId) {
		this.qualifiedSupplierId = qualifiedSupplierId;
	}
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="modify_date",length=50)
	@SearchableProperty
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Column(name="modifier")
	@SearchableProperty
	public Long getModifier() {
		return modifier;
	}
	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}
	@Column(name="season",length=50)
	@SearchableProperty
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	@Column(name="department_id",length=20)
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Column(name="status",length=2)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="reject_flag",length=5)
	public String getRejectFlag() {
		return rejectFlag;
	}
	public void setRejectFlag(String rejectFlag) {
		this.rejectFlag = rejectFlag;
	}
	@Column(name="use_flag",length=2)
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	@Column(name="reason",length=200)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
	@Column(name="check_accept_date",length=50)
	public String getCheckAcceptDate() {
		return checkAcceptDate;
	}
	public void setCheckAcceptDate(String checkAcceptDate) {
		this.checkAcceptDate = checkAcceptDate;
	}
	
	
	@Column(name="accepter_ID1")
	@SearchableProperty
	public Long getAccepterID1() {
		return accepterID1;
	}
	public void setAccepterID1(Long accepterID1) {
		this.accepterID1 = accepterID1;
	}
	@Column(name="accepter_ID2")
	@SearchableProperty
	public Long getAccepterID2() {
		return accepterID2;
	}
	public void setAccepterID2(Long accepterID2) {
		this.accepterID2 = accepterID2;
	}
	
	
	
}
