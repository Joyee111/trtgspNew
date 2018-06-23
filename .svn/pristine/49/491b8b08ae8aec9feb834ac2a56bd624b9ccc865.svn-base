package com.sinosoft.drugState.inspectionRecords.model;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public class ReveivingNoteVO {
	private Long   reveivingId;
	private String commonName;//品名
	private String batchNumber;//批号
	private String quality;//数量
	private String goodsReceiptDate;//收获日期
	private String shipTime;//发货时间
	private String receiptAddress;//收获地址
	private String inspectionResults;//检查结论
	private String receiptPeople;//收获人
	public ReveivingNoteVO(){
		
	}
	public ReveivingNoteVO(ReceivingNote reNote,ReceivingNoteItem reItem,QualityMidicine qmMidicine){
		this.reveivingId =  reNote.getId();
		this.commonName = qmMidicine.getCommonname();
		this.batchNumber = reItem.getBatchProduction();
		this.quality =  reItem.getQuantity().toString();
		this.goodsReceiptDate = reNote.getReceivedDate();
		this.shipTime = reNote.getDeliveryDate();
		this.receiptAddress = reNote.getReceivingAddress();
		this.inspectionResults = reNote.getCheckConclusion();
		this.receiptPeople =  reNote.getUser().getRealname();
	}
	
	public Long getReveivingId() {
		return reveivingId;
	}
	public void setReveivingId(Long reveivingId) {
		this.reveivingId = reveivingId;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getGoodsReceiptDate() {
		return goodsReceiptDate;
	}
	public void setGoodsReceiptDate(String goodsReceiptDate) {
		this.goodsReceiptDate = goodsReceiptDate;
	}
	public String getShipTime() {
		return shipTime;
	}
	public void setShipTime(String shipTime) {
		this.shipTime = shipTime;
	}
	public String getReceiptAddress() {
		return receiptAddress;
	}
	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}
	public String getInspectionResults() {
		return inspectionResults;
	}
	public void setInspectionResults(String inspectionResults) {
		this.inspectionResults = inspectionResults;
	}
	public String getReceiptPeople() {
		return receiptPeople;
	}
	public void setReceiptPeople(String receiptPeople) {
		this.receiptPeople = receiptPeople;
	}
	
	
}
