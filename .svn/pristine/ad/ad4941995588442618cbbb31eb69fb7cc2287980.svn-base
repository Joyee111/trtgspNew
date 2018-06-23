package com.sinosoft.drugState.purchaseNote.dao;

import java.util.List;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;

public interface PurchaseNoteItemDao {

	void saveReceivingNoteItem(PurchaseOrderItem receivingNoteItem);

	void delOne(String id);
	PurchaseOrderItem findById(String id);

	List<PurchasePlanStore> findypJsonqy(int year, int season);
	public List<PurchasePlanStore> findMedicByYearAndDept(String year,String departmentId);
	/**
	 * 根据批号查询采购细单
	 * @param batch
	 * @return
	 */
	List<PurchaseOrderItem> findByBatch(String batch);
	
	/**
	 * 更新采购细单
	 * @author 王海楠
	 * @date 2016-7-28 16:45:04
	 * @param receivingNoteItem
	 */
	void saveOrUpdateItem(PurchaseOrderItem receivingNoteItem);
}
