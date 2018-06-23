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

import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
@SuppressWarnings("serial")
@Entity
@Table(name=" t_transport_records_source")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TransportRecordsResource  implements Serializable{
	private Long id; //int NOT NULL
	private String  deliverydate;// datetime,    -- 发货时间 。。
	private String deliveryaddress;// varchar(100),    -- 发货地址 。。
	private String receivingunit;// varchar(50),    -- 收货单位 。。
	private String receivingaddress; //varchar(100),    -- 收货地址 。。
	private String orderno;// varchar(50),    -- 派车单号 。。
	private Long quantity; //int,    -- 药品件数 。。
	private String transporttype;// varchar(10),    -- 运输方式 。。

	private String plateno; //varchar(50),    -- 车牌号 。。
	private String carrierunit;//承运商
	private TransporterQualification transporterQualification;

	
	@Column(name="carrierunit",length=50)
	@SearchableProperty
	public String getCarrierunit() {
		return carrierunit;
	}
	public void setCarrierunit(String carrierunit) {
		this.carrierunit = carrierunit;
	}
	@Transient
	public TransporterQualification getTransporterQualification() {
		return transporterQualification;
	}
	public void setTransporterQualification(
			TransporterQualification transporterQualification) {
		this.transporterQualification = transporterQualification;
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
	@Column(name="delivery_date",length=50)
	@SearchableProperty
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
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
	@Column(name="order_no",length=50)
	@SearchableProperty
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
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

	
	
}
