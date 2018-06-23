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
@SuppressWarnings("serial")
@Entity
@Table(name="t_qualified_accessory")
@Transactional
public class QulifiedSupplyAccessory implements Serializable {
	private long accssoryId;
	private String certificateNumber;//证书号
	private String accessoryDate;//证书有效期
	private String accessoryPath;//证书路径
	private String request_name;//请求名称
	private String request_type;//证书类别
	public QulifiedSupplyAccessory(){
		
	}
	public QulifiedSupplyAccessory(FirstEnterpriseAccessory fristeAccessory){
		this.accessoryDate =fristeAccessory.getAccessoryDate();
		this.accessoryPath = fristeAccessory.getAccessoryPath();
		this.certificateNumber = fristeAccessory.getCertificateNumber();
		this.request_name = fristeAccessory.getRequest_name();
		this.request_type = fristeAccessory.getRequest_type();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getAccssoryId() {
		return accssoryId;
	}
	public void setAccssoryId(long accssoryId) {
		this.accssoryId = accssoryId;
	}
	@Column(name="certificate_number",length=50)
	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	@Column(name="accessoryDate",length=50)
	public String getAccessoryDate() {
		return accessoryDate;
	}
	public void setAccessoryDate(String accessoryDate) {
		this.accessoryDate = accessoryDate;
	}
	
	@Column(name="accessoryPath",length=100)
	public String getAccessoryPath() {
		return accessoryPath;
	}
	public void setAccessoryPath(String accessoryPath) {
		this.accessoryPath = accessoryPath;
	}
	@Column(name="request_name",length=20)
	public String getRequest_name() {
		return request_name;
	}
	public void setRequest_name(String requestName) {
		request_name = requestName;
	}
	@Column(name="certificate_type")
	public String getRequest_type() {
		return request_type;
	}
	public void setRequest_type(String requestType) {
		request_type = requestType;
	}
}
