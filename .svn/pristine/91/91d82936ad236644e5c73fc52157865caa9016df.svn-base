package com.sinosoft.drugState.returnRecords.model;

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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.user.User;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_return_receiving_note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class ReturnReceivingNote implements Serializable{
	/**
	id int NOT NULL,
	qualified_purchase_units_id int,    -- 购货商id 
	number varchar(12) NOT NULL,    -- 收货编号 
	received_date datetime,    -- 收货日期 
	delivery_date datetime,    -- 发货日期 
	receiving_unit varchar(50),    -- 收货单位 
	receiving_address varchar(100),    -- 收货地址 
	check_conclusion varchar(50),    -- 检查结论 
	goods_clerk numeric(19),    -- 收货员id 
	modify_date datetime,
	result varchar(50)    -- 处理结果 
	return_Number  varchar(20) --退货单号
	saleNo  varchar(50)   ----销售单号
	 * **/
	private Long id;
	private Long qualifiedPurchaseUnitsId;
	private String number;
	private String receivedDate;
	private String deliveryDate;
	private String receivingUnit;
	private String receivingAddress;
	private String checkConclusion;
	private String goodsClerk;
	private String modifyDate;
	private String result;
	private User user;
	private String returnNumber;
	private String saleNo;
	private String returnReason;//退货原因
	@Column(name="sale_no",length=50)
	@SearchableProperty
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	@Column(name="return_number",length=20)
	@SearchableProperty
	public String getReturnNumber() {
		return returnNumber;
	}
	public void setReturnNumber(String returnNumber) {
		this.returnNumber = returnNumber;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	@Fetch(FetchMode.SELECT)
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
	@Column(name="qualified_purchase_units_id")
	@SearchableProperty
	public Long getQualifiedPurchaseUnitsId() {
		return qualifiedPurchaseUnitsId;
	}
	public void setQualifiedPurchaseUnitsId(Long qualifiedPurchaseUnitsId) {
		this.qualifiedPurchaseUnitsId = qualifiedPurchaseUnitsId;
	}
	@Column(name="number",length=20)
	@SearchableProperty
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name="received_date",length=20)
	@SearchableProperty
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	@Column(name="deliveryDate",length=20)
	@SearchableProperty
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	@Column(name="modifyDate",length=20)
	@SearchableProperty
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Column(name="result",length=12)
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="return_reason",length=500)
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	
}
