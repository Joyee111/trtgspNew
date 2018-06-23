package com.sinosoft.drugState.acceptance.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.ireportDTO.EntryTicket;

public interface AcceptanceItemDao {


	CheckacceptItem savech(CheckacceptItem ch);

	void del(String string);

	CheckacceptItem findById(String id);
	public List<EntryTicket> findCheckAndAcceptByBatchNumber(String batchNumber);
	
	/**
	 * 获取验收细单
	 * @return
	 */
	List<CheckacceptItem> findysdItemJson();
	
	/**
	 * 批号位数大于3后开始查询细单
	 * @return
	 */
	List<PurchaseOrderItem> findysdItemJsonByBatchSize(String batch);
	
	/**
	 * 批号位数大于3后开始查询细单
	 * @return
	 */
	List<Map<String,Object>> findysdItemJsonByBatchSize2(String batch);
}
