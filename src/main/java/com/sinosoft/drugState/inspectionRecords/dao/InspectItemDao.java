package com.sinosoft.drugState.inspectionRecords.dao;

import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;

public interface InspectItemDao {

	void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem);

	void del(String a);

	ReceivingNoteItem findById(Long id);

	void delOne(String id);
	
}
