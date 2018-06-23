package com.sinosoft.drugState.outcheck.model;
public class OutboundCheckBillVO {
	private Long id ;//出库复核记录ID
	private String commoneName;//通用名称
	private String drugFrom;//剂型
	private String specification;//规格
	private String batchNumber;//批号
	private Long quantity;//数量
	private String purchaseUnits;//购货单位
	private String qaualityStatus;//质量状况
	private String applityPerson;//申请人；
	private String outDate;//销售时间
	private String remark;//备注
	private String salesFromNumber;
	private String salesItemNumber;
	public OutboundCheckBillVO(){
		
	}
	public OutboundCheckBillVO(OutboundCheckBill checkBill,OutboundCheckItem checkItem){
		this.id = checkBill.getId();
		this.commoneName = checkItem.getQualityMidicine().getCommonname();
		this.drugFrom = checkItem.getQualityMidicine().getDosageforms().getFormName();
		this.specification = checkItem.getQualityMidicine().getSpecifications();
		this.batchNumber = checkItem.getBatchNo();
		this.quantity  = checkItem.getQuantity();
		this.purchaseUnits = checkBill.getQualifiedPurchaseUnits().getCustomerName();
		this.qaualityStatus  = checkBill.getQualitySituation();
		this.applityPerson = checkBill.getUser().getRealname();
		this.outDate = checkBill.getSaleTime();
		this.remark = checkBill.getRemark();
		this.salesFromNumber = checkBill.getSalesFromNumber();
		this.salesItemNumber = checkBill.getSalesNumber();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommoneName() {
		return commoneName;
	}
	public void setCommoneName(String commoneName) {
		this.commoneName = commoneName;
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
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getPurchaseUnits() {
		return purchaseUnits;
	}
	public void setPurchaseUnits(String purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}
	public String getQaualityStatus() {
		return qaualityStatus;
	}
	public void setQaualityStatus(String qaualityStatus) {
		this.qaualityStatus = qaualityStatus;
	}
	public String getApplityPerson() {
		return applityPerson;
	}
	public void setApplityPerson(String applityPerson) {
		this.applityPerson = applityPerson;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getSalesFromNumber() {
		return salesFromNumber;
	}
	public void setSalesFromNumber(String salesFromNumber) {
		this.salesFromNumber = salesFromNumber;
	}
	public String getSalesItemNumber() {
		return salesItemNumber;
	}
	public void setSalesItemNumber(String salesItemNumber) {
		this.salesItemNumber = salesItemNumber;
	}
	
}
