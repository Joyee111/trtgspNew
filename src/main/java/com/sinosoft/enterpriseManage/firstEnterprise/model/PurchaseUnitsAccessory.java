package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 11:12:59 AM
 * 类说明
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_purchase_units_accessory")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class PurchaseUnitsAccessory implements Serializable {
	private long id;//主键ID
	private long purchase_units_id;//主键id
	private String accessoryName;//附件存放路径
	private String accessoryDate;//附件路径
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="purchase_units_id")
	public long getPurchase_units_id() {
		return purchase_units_id;
	}
	public void setPurchase_units_id(long purchaseUnitsId) {
		purchase_units_id = purchaseUnitsId;
	}
	@Column(name="accessory_name",length=200)
	public String getAccessoryName() {
		return accessoryName;
	}
	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}
	@Column(name="accessory_date",length=20)
	public String getAccessoryDate() {
		return accessoryDate;
	}
	public void setAccessoryDate(String accessoryDate) {
		this.accessoryDate = accessoryDate;
	}
	
}
