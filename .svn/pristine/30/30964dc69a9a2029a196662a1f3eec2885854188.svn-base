package com.sinosoft.drugState.inspectionRecords.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class PurchaseOrderVO {
	private Long id;//采购订单ID
	private String department;//经营公司
	private String orderNumber;//订单编号
	private String modityDate;//修改时间
	private String modifyPerson;//修改人
	private String commonName;//通用名称
	private String drugFrom;//剂型；
	private String specification;//规格
	private String  unit;//单位
	private Long quanlity;//数量
	private String batchNumber;//批号
	private String taxPrice;//含税单价
	private String deductionRate;//扣率
	private String money;//金额
	private String customerName; //供货单位
	private String validateDate;//有效期至
	private String medcNo;//货号
	private String useFlag;//0合格 1作废
	private String reason;//作废原因
	public PurchaseOrderVO(){
		
	}
	public PurchaseOrderVO(PurchaseOrder order ,PurchaseOrderItem orderItem,QualityMidicine midicine){
		this.id = order.getId();
		//this.department = order.getDepartmentId();
		if(order.getDepartmentId()==null || "".equals(order.getDepartmentId())){
			this.department = "";
		}else if(order.getDepartmentId().equals("1001")){
			this.department = "经营";
		}else if(order.getDepartmentId().equals("2001")){
			this.department = "新品";
		}else if(order.getDepartmentId().equals("3001")){
			this.department = "市场";
		}
		this.orderNumber = order.getNumber();
		this.modityDate = order.getModifyDate();
		this.modifyPerson = order.getUser().getRealname();
		this.commonName = midicine.getCommonname();
		this.drugFrom = midicine.getDosageforms().getFormName();
		this.specification = midicine.getSpecifications();
		this.unit = midicine.getUnit();
		this.quanlity = orderItem.getQuantity();
		this.batchNumber = orderItem.getBatchProduction();
		this.taxPrice = orderItem.getTaxPrice();
		this.deductionRate = orderItem.getRate();
		this.money = orderItem.getMoney();
		this.validateDate = orderItem.getEndTime();
		this.medcNo = midicine.getMedicinalNo();
		this.useFlag = order.getUseFlag();
		this.setCustomerName(order.getQualifiedSupplierId().getCustomerName());
		this.reason = order.getReason();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getModityDate() {
		return modityDate;
	}
	public void setModityDate(String modityDate) {
		this.modityDate = modityDate;
	}
	public String getModifyPerson() {
		return modifyPerson;
	}
	public void setModifyPerson(String modifyPerson) {
		this.modifyPerson = modifyPerson;
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
	public String getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(String taxPrice) {
		this.taxPrice = taxPrice;
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
	public String getValidateDate() {
		return validateDate;
	}
	public void setValidateDate(String validateDate) {
		this.validateDate = validateDate;
	}
	public String getMedcNo() {
		return medcNo;
	}
	public void setMedcNo(String medcNo) {
		this.medcNo = medcNo;
	}
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
