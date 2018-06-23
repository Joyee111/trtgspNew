package com.sinosoft.ireportDTO;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;

public interface EntryTicketDao extends GenericDao<EntryTicket, Long> {
	public EntryTicket getEntryTicketByAcceptanceId(String id);
	
	public List<EntryTicket> getPage(EntryTicket et, int i, int pagesize,String batch);
	
	public int getTotalCount(EntryTicket et);
	
	EntryTicket findById(String id);
}
