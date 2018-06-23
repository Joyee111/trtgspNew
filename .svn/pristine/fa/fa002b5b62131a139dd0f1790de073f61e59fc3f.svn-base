package com.sinosoft.drugState.stopcell.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class StopSaleBillVO {
	private Long id ;//停售单ID
	private String commonName;//通用名称
	private String  midicNo;//药品编号
	private String specification;//规格
	private String unit;//单位
	private String purchaseUnit;//生产厂商
	private String checkDate;//检查日期
	private String location;//检查地点
	private String checkSituation;//停售原因
	private String batchProduction;//生产批号
	private Long quantity; //数量
	private String applicationPerson;//申请人
	private String apllicationTime;//申请时间
	public StopSaleBillVO(){
		
	}
	public StopSaleBillVO(StopSaleBill stopSaleBill,QualityMidicine midicine){
		this.id = stopSaleBill.getId();
		this.commonName = midicine.getCommonname();
		this.checkDate = stopSaleBill.getCheckDate();
		this.location = stopSaleBill.getLocation();
		this.checkSituation = stopSaleBill.getCheckSituation();
		this.batchProduction = stopSaleBill.getBatchProduction();
		this.quantity = stopSaleBill.getQuantity();
		this.applicationPerson = stopSaleBill.getUser().getRealname();
		this.apllicationTime = stopSaleBill.getApplicationTime();
		this.specification = midicine.getSpecifications();
		this.unit = midicine.getUnit();
		this.purchaseUnit = midicine.getProduceno().getCustomerName();
		this.midicNo = midicine.getMedicinalNo();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCheckSituation() {
		return checkSituation;
	}
	public void setCheckSituation(String checkSituation) {
		this.checkSituation = checkSituation;
	}
	public String getBatchProduction() {
		return batchProduction;
	}
	public void setBatchProduction(String batchProduction) {
		this.batchProduction = batchProduction;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getApplicationPerson() {
		return applicationPerson;
	}
	public void setApplicationPerson(String applicationPerson) {
		this.applicationPerson = applicationPerson;
	}
	public String getApllicationTime() {
		return apllicationTime;
	}
	public void setApllicationTime(String apllicationTime) {
		this.apllicationTime = apllicationTime;
	}
	public String getMidicNo() {
		return midicNo;
	}
	public void setMidicNo(String midicNo) {
		this.midicNo = midicNo;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	
}
