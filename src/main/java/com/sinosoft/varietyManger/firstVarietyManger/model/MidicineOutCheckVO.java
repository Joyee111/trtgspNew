package com.sinosoft.varietyManger.firstVarietyManger.model;

import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;

public class MidicineOutCheckVO extends PurchaseOrderMidicineVO {
	private OutboundCheckBill outboundCheckBill;
	private OutboundCheckItem outboundCheckItem;
	public MidicineOutCheckVO(){
		super();
	}
	public MidicineOutCheckVO(OutboundCheckBill outboundCheckBill,OutboundCheckItem outcheCheckItem,QualityMidicine qualityMidicine){
		this.outboundCheckBill = outboundCheckBill;
		this.outboundCheckItem = outcheCheckItem;
		this.qualityMidicine = qualityMidicine;
	}
	public OutboundCheckBill getOutboundCheckBill() {
		return outboundCheckBill;
	}
	public void setOutboundCheckBill(OutboundCheckBill outboundCheckBill) {
		this.outboundCheckBill = outboundCheckBill;
	}
	public OutboundCheckItem getOutboundCheckItem() {
		return outboundCheckItem;
	}
	public void setOutboundCheckItem(OutboundCheckItem outboundCheckItem) {
		this.outboundCheckItem = outboundCheckItem;
	}
	
}
