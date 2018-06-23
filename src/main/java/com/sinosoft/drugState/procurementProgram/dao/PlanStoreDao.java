package com.sinosoft.drugState.procurementProgram.dao;

import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;

public interface PlanStoreDao {

	public PurchasePlanStore save(PurchasePlanStore ps);

	public void update(PurchasePlanStore ps1);

	public void del(PurchasePlanStore ps1);


}
