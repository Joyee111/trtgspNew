package com.sinosoft.drugState.procurementProgram.dao.impl;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.procurementProgram.dao.ProcurementProgramItemDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
@Repository("ProcurementProgramItemDao")
public class ProcurementProgramItemDaoImpl extends GenericDaoHibernate<PurchasePlanItem, Long> implements ProcurementProgramItemDao{

	public ProcurementProgramItemDaoImpl() {
		super(PurchasePlanItem.class);
	}

	@Override
	public void saveReceivingNoteItem(PurchasePlanItem receivingNoteItem) {
		this.getHibernateTemplate().save(receivingNoteItem);
	}

}
