package com.sinosoft.qualityRecords.transportRecords.model;

import java.io.Serializable;

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

@SuppressWarnings("serial")
@Entity
@Table(name=" t_transport_records")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TransportRecords implements Serializable{
	private Long id; //int NOT NULL
	private String orderno;// varchar(50),    -- 货单号 。。
	private String operator;// varchar(50),    -- 委托经办人 
	private String  hdtime;//签收时间
	private String baoshu;//包数
	private String zhongliang;//重量
	private String checi;//车次
	private String yunfei;//运费
	private String yssx;//运输时限
	private String qsr;//签收人
	
	private String deliveryaddress;// varchar(100),    -- 发货地址 。。
	private String receivingunit;// varchar(50),    -- 收货单位 。。
	private String receivingaddress; //varchar(100),    -- 收货地址 。。
	private Long quantity; //int,    -- 药品件数 。。
	private String transporttype;// varchar(10),    -- 运输方式 。。
	private String plateno; //varchar(50),    -- 车牌号 。。
	private String carrierunit;//承运商
	private String deliverydate ;//发货时间
	
	private TransportRecordsResource transportRecordsResource;
	private   User  user;
	@Transient
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Transient
	public TransportRecordsResource getTransportRecordsResource() {
		return transportRecordsResource;
	}
	public void setTransportRecordsResource(
			TransportRecordsResource transportRecordsResource) {
		this.transportRecordsResource = transportRecordsResource;
	}
	@Column(name="hdtime",length=50)
	@SearchableProperty
	public String getHdtime() {
		return hdtime;
	}
	
	public void setHdtime(String hdtime) {
		this.hdtime = hdtime;
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
	

	@Column(name="order_no",length=50)
	@SearchableProperty
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	@Column(name="operator",length=50)
	@SearchableProperty
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Column(name="baoshu",length=50)
	@SearchableProperty
	public String getBaoshu() {
		return baoshu;
	}
	public void setBaoshu(String baoshu) {
		this.baoshu = baoshu;
	}
	@Column(name="zhongliang",length=50)
	@SearchableProperty
	public String getZhongliang() {
		return zhongliang;
	}
	public void setZhongliang(String zhongliang) {
		this.zhongliang = zhongliang;
	}
	@Column(name="checi",length=50)
	@SearchableProperty
	public String getCheci() {
		return checi;
	}
	public void setCheci(String checi) {
		this.checi = checi;
	}
	@Column(name="yunfei",length=50)
	@SearchableProperty
	public String getYunfei() {
		return yunfei;
	}
	public void setYunfei(String yunfei) {
		this.yunfei = yunfei;
	}
	@Column(name="yssx",length=50)
	@SearchableProperty
	public String getYssx() {
		return yssx;
	}
	public void setYssx(String yssx) {
		this.yssx = yssx;
	}
	@Column(name="qsr",length=50)
	@SearchableProperty
	public String getQsr() {
		return qsr;
	}
	public void setQsr(String qsr) {
		this.qsr = qsr;
	}
	@Column(name="delivery_address",length=100)
	@SearchableProperty
	public String getDeliveryaddress() {
		return deliveryaddress;
	}
	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	@Column(name="receiving_unit",length=50)
	@SearchableProperty
	public String getReceivingunit() {
		return receivingunit;
	}
	public void setReceivingunit(String receivingunit) {
		this.receivingunit = receivingunit;
	}
	@Column(name="receiving_address",length=100)
	@SearchableProperty
	public String getReceivingaddress() {
		return receivingaddress;
	}
	public void setReceivingaddress(String receivingaddress) {
		this.receivingaddress = receivingaddress;
	}
	
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="transport_type",length=20)
	@SearchableProperty
	public String getTransporttype() {
		return transporttype;
	}
	public void setTransporttype(String transporttype) {
		this.transporttype = transporttype;
	}
	
	@Column(name="plateno",length=50)
	@SearchableProperty
	public String getPlateno() {
		return plateno;
	}
	public void setPlateno(String plateno) {
		this.plateno = plateno;
	}
	
	@Column(name="carrierunit",length=50)
	@SearchableProperty
	public String getCarrierunit() {
		return carrierunit;
	}
	public void setCarrierunit(String carrierunit) {
		this.carrierunit = carrierunit;
	}
	@Column(name="deliverydate",length=50)
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	
}
