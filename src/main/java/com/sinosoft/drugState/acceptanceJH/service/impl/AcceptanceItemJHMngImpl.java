package com.sinosoft.drugState.acceptanceJH.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.acceptanceJH.dao.AcceptanceItemJHDao;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.drugState.acceptanceJH.service.AcceptanceItemJHMng;
import com.sinosoft.ireportDTO.EntryTicket;

@Service
public class AcceptanceItemJHMngImpl implements AcceptanceItemJHMng{
	@Autowired 
	private AcceptanceItemJHDao acceptanceItemJHDao;

	@Override
	public CheckAcceptItemJH save(CheckAcceptItemJH ch) {
		return acceptanceItemJHDao.savech(ch);
	}

	@Override
	public void del(List<?> receItem) {
		for(int i=0;i<receItem.size();i++){
			acceptanceItemJHDao.del(receItem.get(i).toString());
		}
		
	}

	@Override
	public CheckAcceptItemJH findById(String id) {
		return acceptanceItemJHDao.findById(id);
	}

	@Override
	public List<EntryTicket> findCheckAndAcceptByBatchNumber(String batchNumber) {
		
		return acceptanceItemJHDao.findCheckAndAcceptByBatchNumber(batchNumber);
	}

	@Override
	public List<CheckAcceptItemJH> findysdItemJHJson() {
		return acceptanceItemJHDao.findysdItemJHJson();
	}

	@Override
	public List<CheckAcceptItemJH> findysdItemJsonByBatchSize(String batch) {
		
		return acceptanceItemJHDao.findysdItemJsonByBatchSize(batch);
	}
}
