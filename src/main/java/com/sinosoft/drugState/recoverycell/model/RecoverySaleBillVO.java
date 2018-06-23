package com.sinosoft.drugState.recoverycell.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;


public class RecoverySaleBillVO {
	private Long id;//恢复销售单号ID
	private String commonName;//通用名称
	private String checkDate;//检查日期
	private String location;//检查情况
	private String checkSituation;//检查结论
	private String applicationName;//申请人
	private String applicationTime;//申请时间
	private String batchProduction;//批号
	private String quantity;//数量
	public RecoverySaleBillVO(){
		
	}
	public RecoverySaleBillVO(RecoverySaleBill saleBill,QualityMidicine midicine){
		this.id = saleBill.getId();
		this.commonName = midicine.getCommonname();
		this.checkDate = saleBill.getCheckDate();
		this.checkSituation = saleBill.getCheckSituation();
		this.applicationName = saleBill.getUser().getRealname();
		this.applicationTime = saleBill.getApplicationTime();
		this.batchProduction = saleBill.getBatchProduction();
		this.quantity = saleBill.getQuantity();
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
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}
	public String getBatchProduction() {
		return batchProduction;
	}
	public void setBatchProduction(String batchProduction) {
		this.batchProduction = batchProduction;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
