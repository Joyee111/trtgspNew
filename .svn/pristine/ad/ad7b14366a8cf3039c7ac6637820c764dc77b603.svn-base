package com.sinosoft.drugState.acceptance.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.ireportDTO.EntryTicket;

public interface AcceptanceItemMng {
	
	CheckacceptItem save(CheckacceptItem ch);

	void del(List<?> receItem);
	
	CheckacceptItem findById( String id);
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
