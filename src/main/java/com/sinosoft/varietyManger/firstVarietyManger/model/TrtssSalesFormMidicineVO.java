package com.sinosoft.varietyManger.firstVarietyManger.model;

import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

public class TrtssSalesFormMidicineVO extends PurchaseOrderMidicineVO {
	private TrtssSalesFormInfo trtssSalesFormInfo;
	private TrtssSalesItemsInfo trtSalesItemsInfo;
	private QualifiedPurchaseUnits purchaseUnit;
	public TrtssSalesFormMidicineVO(){
		super();
	}
	public TrtssSalesFormMidicineVO(TrtssSalesFormInfo trtssSalesFormInfo,TrtssSalesItemsInfo trtSalesItemsInfo,QualityMidicine qualityMidicine,QualifiedPurchaseUnits purchaseUnit){
		this.trtssSalesFormInfo = trtssSalesFormInfo;
		this.trtSalesItemsInfo = trtSalesItemsInfo;
		this.qualityMidicine =qualityMidicine;
		this.purchaseUnit = purchaseUnit;
	}
	public TrtssSalesFormInfo getTrtssSalesFormInfo() {
		return trtssSalesFormInfo;
	}
	public void setTrtssSalesFormInfo(TrtssSalesFormInfo trtssSalesFormInfo) {
		this.trtssSalesFormInfo = trtssSalesFormInfo;
	}
	public TrtssSalesItemsInfo getTrtSalesItemsInfo() {
		return trtSalesItemsInfo;
	}
	public void setTrtSalesItemsInfo(TrtssSalesItemsInfo trtSalesItemsInfo) {
		this.trtSalesItemsInfo = trtSalesItemsInfo;
	}
	public QualifiedPurchaseUnits getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(QualifiedPurchaseUnits purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	
	
}
