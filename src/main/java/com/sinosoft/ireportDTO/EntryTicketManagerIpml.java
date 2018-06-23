package com.sinosoft.ireportDTO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
@Service
public class EntryTicketManagerIpml extends GenericManagerImpl<EntryTicket, Long> implements
		EntryTicketMangaer {
	private EntryTicketDao entryTicketDao;
	@Autowired
	public EntryTicketManagerIpml(EntryTicketDao entryTicketDao){
		this.entryTicketDao = entryTicketDao;
		this.dao = entryTicketDao;
	}
	/**
	 * 根据验收单ID查询入库票
	 */
	public EntryTicket getEntryTicketByAcceptanceId(String id) {
		// TODO Auto-generated method stub
		return entryTicketDao.getEntryTicketByAcceptanceId(id);
	}
	
	@Override
	public List<EntryTicket> getPage(EntryTicket et, int i, int pagesize,String batch) {
		return entryTicketDao.getPage(et,i,pagesize,batch);
	}

	@Override
	public int getTotalCount(EntryTicket et) {
		return entryTicketDao.getTotalCount(et);
	}
	@Override
	public EntryTicket findById(String id) {
		return entryTicketDao.findById(id);
	}
}
