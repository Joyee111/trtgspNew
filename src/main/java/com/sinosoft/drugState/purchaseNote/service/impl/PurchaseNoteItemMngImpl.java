package com.sinosoft.drugState.purchaseNote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseNoteItemDao;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteItemMng;
@Service
public class PurchaseNoteItemMngImpl implements PurchaseNoteItemMng{
	
	@Autowired
	private PurchaseNoteItemDao purchaseNoteItemDao;
	
	@Override
	public void savePurchaseOrderItem(PurchaseOrderItem PurchaseOrderItem) {
		purchaseNoteItemDao.saveReceivingNoteItem(PurchaseOrderItem);
	}

	@Override
	public void del(List<?> list) {
		if(list !=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				if(list.get(i)!=null){
					delOne(list.get(i).toString());
				}
			}
		}
	}

	@Override
	public void delOne(String id) {
		purchaseNoteItemDao.delOne(id);
	}

	@Override
	public List<PurchasePlanStore> findypJsonqy(int year, int season) {
		return purchaseNoteItemDao.findypJsonqy(year, season);
	}

	@Override
	public List<PurchasePlanStore> findMedicByYearAndDept(String year,
			String departmentId) {
		// TODO Auto-generated method stub
		return purchaseNoteItemDao.findMedicByYearAndDept(year, departmentId);
	}

	@Override
	public List<PurchaseOrderItem> findByBatch(String batch) {
		return purchaseNoteItemDao.findByBatch(batch);
	}

	@Override
	public void saveOrUpdateItem(PurchaseOrderItem purchaseOrderItem) {
		purchaseNoteItemDao.saveOrUpdateItem(purchaseOrderItem);
		
	}



}
