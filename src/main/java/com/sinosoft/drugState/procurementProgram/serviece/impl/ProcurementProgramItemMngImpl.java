package com.sinosoft.drugState.procurementProgram.serviece.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.procurementProgram.dao.ProcurementProgramItemDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.serviece.ProcurementProgramItemMng;
@Service
public class ProcurementProgramItemMngImpl implements ProcurementProgramItemMng{
	@Autowired
	private ProcurementProgramItemDao procurementProgramItemDao;

	@Override
	public void saveReceivingNoteItem(PurchasePlanItem receivingNoteItem) {
		procurementProgramItemDao.saveReceivingNoteItem(receivingNoteItem);
	}
	

}
