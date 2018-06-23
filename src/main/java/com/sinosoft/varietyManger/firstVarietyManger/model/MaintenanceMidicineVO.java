package com.sinosoft.varietyManger.firstVarietyManger.model;

import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;

public class MaintenanceMidicineVO extends PurchaseOrderMidicineVO {
	private DrugMaintenance drugMaintenance;
	
	public MaintenanceMidicineVO(){
		
	}
	public MaintenanceMidicineVO(DrugMaintenance drugMaintenance,QualityMidicine qualityMidicine){
		this.drugMaintenance = drugMaintenance;
		this.qualityMidicine = qualityMidicine;
	}
	public DrugMaintenance getDrugMaintenance() {
		return drugMaintenance;
	}

	public void setDrugMaintenance(DrugMaintenance drugMaintenance) {
		this.drugMaintenance = drugMaintenance;
	}
	
}
