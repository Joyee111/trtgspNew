package com.sinosoft.drugState.inspectionRecords.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.inspectionRecords.dao.InspectItemDao;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.service.InspectItemMng;

@Service
public class InspectItemMngImpl implements InspectItemMng{
	@Autowired
	private InspectItemDao inspectItemDao;
	
	public void setInspectItemDao(InspectItemDao inspectItemDao) {
		this.inspectItemDao = inspectItemDao;
	}

	@Override
	public void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem) {
		inspectItemDao.saveReceivingNoteItem(receivingNoteItem);
	}

	@Override
	public void del(List<?> list) {
		for(int i =0;i<list.size();i++){
			String a = list.get(i).toString();
			inspectItemDao.del(a);
		}
	}

	@Override
	public ReceivingNoteItem findById(Long id) {
		return inspectItemDao.findById(id);
	}

	@Override
	public void delOne(String id) {
		inspectItemDao.delOne(id);
		
	}

}
