package com.sinosoft.drugState.returnRecords.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.returnRecords.dao.ReturnRecordsItemDao;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.service.ReturnRecordsItemMng;

@Service
public class ReturnRecordsItemMngImpl implements ReturnRecordsItemMng{
	@Autowired
	private ReturnRecordsItemDao returnRecordsItemDao;
	
	
	@Override
	public void saveReceivingNoteItem(ReturnReceivingNoteItem receivingNoteItem) {
		returnRecordsItemDao.saveReceivingNoteItem(receivingNoteItem);
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
		returnRecordsItemDao.delOne(id);
	}

}
