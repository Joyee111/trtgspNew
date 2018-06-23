package com.sinosoft.varietyManger.firstVarietyManger.model;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;

public class PurchaseOrderMidicineVO {
	private PurchaseOrder purchaseOrder;
	private PurchaseOrderItem  purchaseOrderItem;
	public  QualityMidicine qualityMidicine;
	public PurchaseOrderMidicineVO(){
		
	}
	public PurchaseOrderMidicineVO(PurchaseOrder purchaseOrder, PurchaseOrderItem purchaseOrderItem,QualityMidicine qualityMidicine){
		this.purchaseOrder = purchaseOrder;
		this.purchaseOrderItem = purchaseOrderItem;
		this.qualityMidicine = qualityMidicine;
	}
	
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public PurchaseOrderItem getPurchaseOrderItem() {
		return purchaseOrderItem;
	}
	public void setPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}
	
	
	
	
}
