package com.sinosoft.drugState.procurementProgram.dao.impl;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.procurementProgram.dao.PlanStoreDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;

@Repository("PlanStoreDao")
public class PlanStoreDaoImpl extends GenericDaoHibernate<PurchasePlanStore, Long> implements PlanStoreDao{

	public PlanStoreDaoImpl() {
		super(PurchasePlanStore.class);
	}

	@Override
	public PurchasePlanStore save(PurchasePlanStore ps) {
		PurchasePlanStore psn= this.getHibernateTemplate().merge(ps);
		return psn;
		
	}

	@Override
	public void update(PurchasePlanStore ps1) {
		this.getHibernateTemplate().saveOrUpdate(ps1);
	}

	@Override
	public void del(PurchasePlanStore ps1) {
		this.getHibernateTemplate().delete(ps1);
	}
	
	
}
