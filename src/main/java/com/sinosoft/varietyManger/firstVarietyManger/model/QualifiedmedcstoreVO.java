package com.sinosoft.varietyManger.firstVarietyManger.model;

public class QualifiedmedcstoreVO extends PurchaseOrderMidicineVO {
	private Qualifiedmedcstore  qualifiedmedcstore;
	public QualifiedmedcstoreVO(){
		super();
	}
	public QualifiedmedcstoreVO(Qualifiedmedcstore qualifiedmedcstore,QualityMidicine qualityMidicine){
		this.qualifiedmedcstore = qualifiedmedcstore;
		this.qualityMidicine =qualityMidicine;
	}
	public Qualifiedmedcstore getQualifiedmedcstore() {
		return qualifiedmedcstore;
	}
	public void setQualifiedmedcstore(Qualifiedmedcstore qualifiedmedcstore) {
		this.qualifiedmedcstore = qualifiedmedcstore;
	}
	
}
