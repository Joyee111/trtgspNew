package com.sinosoft.drugState.procurementProgram.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.procurementProgram.dao.PlanStoreDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.procurementProgram.serviece.PlanStoreMng;

@Service
public class PlanStoreMngImpl implements PlanStoreMng{
	@Autowired
	private PlanStoreDao planStoreDao;

	@Override
	public PurchasePlanStore save(PurchasePlanStore ps) {
		return planStoreDao.save(ps);
	}

	@Override
	public void update(PurchasePlanStore ps1) {
		planStoreDao.update(ps1);
	}

	@Override
	public void del(PurchasePlanStore ps1) {
		planStoreDao.del(ps1);
	}

}
