package com.sinosoft.drugState.purchaseNote.service;

import java.util.List;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;


public interface PurchaseNoteItemMng {
	/**
	 * @param list 删除对象的ID集合
	 */
	void del(List<?> list);


	/**
	 * @param id 单个删除的ID
	 */
	void delOne(String id);

	/**
	 * @param purchaseOrderItem 保存的对象
	 */
	void savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);


	/**
	 * 根据年份，季度查询PurchasePlanStore对象
	 * @param year
	 * @param season
	 * @return PurchasePlanStore对象集合
	 */
	List<PurchasePlanStore> findypJsonqy(int year, int season);
	/**
	 * 根据年份和经营公司ID查询PurchasePlanStore
	 * @param year
	 * @param departmentId
	 * @return
	 */
	List<PurchasePlanStore> findMedicByYearAndDept(String year,String departmentId);
	
	/**
	 * 根据批号查询采购细单
	 * @param batch
	 * @return
	 */
	List<PurchaseOrderItem> findByBatch(String batch);
	
	void saveOrUpdateItem(PurchaseOrderItem purchaseOrderItem);
}
