package com.sinosoft.drugState.returnRecords.dao;

import java.util.List;

import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO;

public interface ReturnRecordsDao {

	int getTotalCount(ReturnReceivingNote re);

	List<ReturnReceivingNote> getPage(ReturnReceivingNote re, int i,
			int pagesize);

	ReturnReceivingNote findById(String id);

	List<ReturnReceivingNoteItem> findYp(Long id);

	ReturnReceivingNote saveReceivingNote(ReturnReceivingNote re);

	void del(String id);

	List<?> findAllId(String s);

	List<OutboundCheckBill> findItemById(String saleNumber);

	List<OutboundCheckItem> findOutItem(Long id);
	public List<OutboundCheckBill> findOutboundCheckBill(String salesItemId);
	List<ReturnReceivingNoteVO> findReturnReceivingNoteByCondiction(String date,String customerName,String status,String xiaoshoudanhao,String tuihuodanhao,String isfood,int first,int pagesize);
	int countReturnReceivingNoteByCondiction(String date,String customerName,String status,String xiaoshoudanhao,String tuihuodanhao,String isfood);
	
	
	public Integer getSumQuantity(String saleNumber,String batchNo,String qualifiedMedicineId);
}
