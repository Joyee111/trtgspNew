package com.sinosoft.drugState.acceptance.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.acceptance.dao.AcceptanceItemDao;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.acceptance.service.AcceptanceItemMng;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.ireportDTO.EntryTicket;

@Service
public class AcceptanceItemMngImpl implements AcceptanceItemMng {
	@Autowired 
	private AcceptanceItemDao acceptanceItemDao;

	@Override
	public CheckacceptItem save(CheckacceptItem ch) {
		return acceptanceItemDao.savech(ch);
	}

	@Override
	public void del(List<?> receItem) {
		for(int i=0;i<receItem.size();i++){
			acceptanceItemDao.del(receItem.get(i).toString());
		}
		
	}

	@Override
	public CheckacceptItem findById(String id) {
		return acceptanceItemDao.findById(id);
	}

	@Override
	public List<EntryTicket> findCheckAndAcceptByBatchNumber(String batchNumber) {
		return acceptanceItemDao.findCheckAndAcceptByBatchNumber(batchNumber);
	}

	@Override
	public List<CheckacceptItem> findysdItemJson() {
		return acceptanceItemDao.findysdItemJson();
	}

	@Override
	public List<PurchaseOrderItem> findysdItemJsonByBatchSize(String batch) {
		
		return acceptanceItemDao.findysdItemJsonByBatchSize(batch);
	}

	@Override
	public List<Map<String,Object>> findysdItemJsonByBatchSize2(String batch) {
		return acceptanceItemDao.findysdItemJsonByBatchSize2(batch);
	}
}
