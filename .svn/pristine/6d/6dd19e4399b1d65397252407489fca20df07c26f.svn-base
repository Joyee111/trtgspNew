package com.sinosoft.ireportDTO;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;

public interface EntryTicketMangaer extends GenericManager<EntryTicket, Long> {
	public EntryTicket getEntryTicketByAcceptanceId(String id);
	
	/**
	 * 
	 * @param et
	 * @param i
	 * @param pagesize
	 * @return 返回符合条件的EntryTicket对象集合
	 */
	List<EntryTicket> getPage(EntryTicket et, int i, int pagesize,String batch);
	
	/**
	 * @param et 
	 * @return 符合条件的数量
	 */
	int getTotalCount(EntryTicket et);
	
	/**
	 * 根据ID查询EntryTicket对象
	 * @param id 
	 * @return EntryTicket对象
	 */
	EntryTicket findById(String id);
	
}
