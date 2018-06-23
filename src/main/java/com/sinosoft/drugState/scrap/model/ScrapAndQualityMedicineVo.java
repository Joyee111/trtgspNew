package com.sinosoft.drugState.scrap.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class ScrapAndQualityMedicineVo {
   
	private Long id;
	private String medicinalNo;
	private String commonname;
	private String formName;
	private String specifications;
	private String batchno;
	private String unit;
	private String quantity;
	private String validdate;
	private String customerName1;//生产厂商名称
	private String customerName2;//供货厂商名称
	private String applyTime;
	private String scrapReason; //申请报废原因
	
	
	
	
	public ScrapAndQualityMedicineVo(ScrapMedicine sm,QualityMidicine qm) {
	   this.id=sm.getId();
	   this.medicinalNo=sm.getMedicinalNo();
	   this.commonname=qm.getCommonname();
	   this.formName=qm.getDosageforms().getFormName();
	   this.specifications=qm.getSpecifications();
	   this.batchno=sm.getBatchno();
	   this.unit=qm.getUnit();
	   this.quantity=sm.getQuantity().toString();
	   this.validdate=qm.getValiddate();
	   this.customerName1=qm.getProduceno().getCustomerName();
	   this.customerName2=qm.getSupplyUnit().getCustomerName();
	   this.applyTime=sm.getApplyTime();
	   this.scrapReason=sm.getScrapReason();
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getMedicinalNo() {
		return medicinalNo;
	}




	public void setMedicinalNo(String medicinalNo) {
		this.medicinalNo = medicinalNo;
	}




	public String getCommonname() {
		return commonname;
	}




	public void setCommonname(String commonname) {
		this.commonname = commonname;
	}




	public String getFormName() {
		return formName;
	}




	public void setFormName(String formName) {
		this.formName = formName;
	}




	public String getSpecifications() {
		return specifications;
	}




	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}




	public String getBatchno() {
		return batchno;
	}




	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}




	public String getUnit() {
		return unit;
	}




	public void setUnit(String unit) {
		this.unit = unit;
	}




	public String getQuantity() {
		return quantity;
	}




	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}




	public String getValiddate() {
		return validdate;
	}




	public void setValiddate(String validdate) {
		this.validdate = validdate;
	}




	public String getCustomerName1() {
		return customerName1;
	}




	public void setCustomerName1(String customerName1) {
		this.customerName1 = customerName1;
	}




	public String getCustomerName2() {
		return customerName2;
	}




	public void setCustomerName2(String customerName2) {
		this.customerName2 = customerName2;
	}




	public String getApplyTime() {
		return applyTime;
	}




	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}




	public String getScrapReason() {
		return scrapReason;
	}




	public void setScrapReason(String scrapReason) {
		this.scrapReason = scrapReason;
	}
	
	
}
