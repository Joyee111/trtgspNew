package com.sinosoft.drugState.returnRecords.model;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class ReturnReceivingNoteVO {

	private Long id;//退货药品单号
	private String commonName;//通用名称
	private String durgFrom;//剂型
	private String specification;//规格
	private String purchaseUnit;//退回单位
	private String receivingUnit;//收货单位
	private String receivingAddress;//收货地址
	private String receivedDate;//收获时间
	private String deliveryDate;//到货时间
	private String checkConclusion;//检查结论
	private String receivingUser;//收货人
	private String modifyDate;//修改时间
	public ReturnReceivingNoteVO(){
		
	}
	public ReturnReceivingNoteVO(ReturnReceivingNote reNote,ReturnReceivingNoteItem reItem,QualifiedPurchaseUnits puUnits,QualityMidicine midicine){
		this.id = reNote.getId();
		this.commonName = midicine.getCommonname();
		this.durgFrom = midicine.getDosageforms().getFormName();
		this.specification = midicine.getSpecifications();
		this.purchaseUnit = puUnits.getCustomerName();
		this.receivingUnit= reNote.getReceivingUnit();
		this.receivingAddress = reNote.getReceivingAddress();
		this.receivedDate = reNote.getReceivedDate();
		this.deliveryDate = reNote.getDeliveryDate();
		this.checkConclusion = reNote.getCheckConclusion();
		this.receivingUser = reNote.getUser().getRealname();
		this.modifyDate = reNote.getModifyDate();
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
	public String getDurgFrom() {
		return durgFrom;
	}
	public void setDurgFrom(String durgFrom) {
		this.durgFrom = durgFrom;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public String getReceivingUnit() {
		return receivingUnit;
	}
	public void setReceivingUnit(String receivingUnit) {
		this.receivingUnit = receivingUnit;
	}
	public String getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}
	public String getReceivingUser() {
		return receivingUser;
	}
	public void setReceivingUser(String receivingUser) {
		this.receivingUser = receivingUser;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
