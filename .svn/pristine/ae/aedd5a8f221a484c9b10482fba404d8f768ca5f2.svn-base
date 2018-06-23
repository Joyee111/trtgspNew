package com.sinosoft.drugState.inspectionRecords.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class PurchaseOrderItemVO {
	private String commonName ;//通用名称
	private String drugFrom ;//剂型
	private String specification ;//规格
	private String unit ;//单位
	private Long quanlity;//数量
	private String batchNumber ;//批号
	private String productUnit ;//生产企业
	private String approvalNumber ;//批准文号
	private String taxtPrice ;//含税单价
	private String deductionRate ;//扣率
	private String money ;//金额
	private String validDate ;//有效期至
	private String tkdat;//生产日期
	
	public PurchaseOrderItemVO(){
		
	}
	public PurchaseOrderItemVO(PurchaseOrderItem item, QualityMidicine midicine){
		this.commonName = midicine.getCommonname();
		this.drugFrom = midicine.getDosageforms().getFormName();
		this.specification = midicine.getSpecifications();
		this.unit = midicine.getUnit();
		this.quanlity = item.getQuantity();
		this.batchNumber = item.getBatchProduction();
		this.productUnit = midicine.getProduceno().getCustomerName();
		this.approvalNumber = midicine.getLicensenumber();
		this.taxtPrice = item.getTaxPrice();
		this.deductionRate = item.getRate();
		this.money = item.getMoney();
		this.validDate = item.getEndTime();
		this.tkdat = item.getTkdat();
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getDrugFrom() {
		return drugFrom;
	}
	public void setDrugFrom(String drugFrom) {
		this.drugFrom = drugFrom;
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
	public Long getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(Long quanlity) {
		this.quanlity = quanlity;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public String getApprovalNumber() {
		return approvalNumber;
	}
	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}
	public String getTaxtPrice() {
		return taxtPrice;
	}
	public void setTaxtPrice(String taxtPrice) {
		this.taxtPrice = taxtPrice;
	}
	public String getDeductionRate() {
		return deductionRate;
	}
	public void setDeductionRate(String deductionRate) {
		this.deductionRate = deductionRate;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getTkdat() {
		return tkdat;
	}
	public void setTkdat(String tkdat) {
		this.tkdat = tkdat;
	}
	
}
