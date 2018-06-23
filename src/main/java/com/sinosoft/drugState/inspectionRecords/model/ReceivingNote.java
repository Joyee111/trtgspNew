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
@Table(name = "t_receiving_note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ReceivingNote implements Serializable {
	
	
	
	/**
	id int NOT NULL,
	qualifiedSupplier_id int,    -- 合格供应商id 
	number varchar(12) NOT NULL,    -- 收货编号 
	received_date  datetime,    -- 收货日期 
	delivery_date datetime,    -- 发货日期 
	receiving_unit  varchar(50),    -- 收货单位 
	receiving_address varchar(100),    -- 收货地址 
	check_conclusion varchar(50),    -- 检查结论 
	goods_clerk numeric(19),    -- 收货员 
	modify_date datetime,    -- 修改时间 
	result varchar(50)    -- 处理结果 
	purchase_number		-- 采购单号
	 * **/
	private Long id;
	private QualifiedSuppliers qualifiedSupplierId;//供货商
	private String receivedDate;
	private String deliveryDate;
	private Long quantity;
	private String enddate;
	private String receivingUnit;
	private String receivingAddress;
	private String checkConclusion;
	private String goodsClerk;
	private String modifyDate;
	private String result;
	private String number;
	private User user;
	private String purchaseNumber;
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	@ManyToOne(cascade=CascadeType.REFRESH)
	public QualifiedSuppliers getQualifiedSupplierId() {
		return qualifiedSupplierId;
	}
	public void setQualifiedSupplierId(QualifiedSuppliers qualifiedSupplierId) {
		this.qualifiedSupplierId = qualifiedSupplierId;
	}
	@Column(name="received_date",length=20)
	@SearchableProperty
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	@Column(name="delivery_date",length=20)
	@SearchableProperty
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="enddate",length=20)
	@SearchableProperty
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	@Column(name="receiving_unit",length=50)
	@SearchableProperty
	public String getReceivingUnit() {
		return receivingUnit;
	}
	public void setReceivingUnit(String receivingUnit) {
		this.receivingUnit = receivingUnit;
	}
	@Column(name="receiving_address",length=100)
	@SearchableProperty
	public String getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	@Column(name="check_conclusion",length=50)
	@SearchableProperty
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}
	@Column(name="goods_clerk",length=20)
	@SearchableProperty
	public String getGoodsClerk() {
		return goodsClerk;
	}
	public void setGoodsClerk(String goodsClerk) {
		this.goodsClerk = goodsClerk;
	}
	@Column(name="modify_date",length=20)
	@SearchableProperty
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Column(name="result",length=50)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="purchase_number",length=20)
	@SearchableProperty
	public String getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
	
	
}
