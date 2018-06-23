package com.sinosoft.drugState.returnRecords.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.returnRecords.dao.ReturnRecordsDao;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO;
import com.sinosoft.drugState.returnRecords.service.ReturnRecordsMng;

@Service
public class ReturnRecordsMngImpl implements ReturnRecordsMng {
	
	@Autowired
	private ReturnRecordsDao returnRecordsDao;
	@Override
	public List<ReturnReceivingNote> getPage(ReturnReceivingNote re, int i, int pagesize) {
		return returnRecordsDao.getPage(re,i,pagesize);
	}

	@Override
	public int getTotalCount(ReturnReceivingNote re) {
		return returnRecordsDao.getTotalCount(re);
	}

	@Override
	public ReturnReceivingNote findById(String id) {
		return returnRecordsDao.findById(id);
	}

	@Override
	public List<ReturnReceivingNoteItem> findYp(Long id) {
		return returnRecordsDao.findYp(id);
	}

	@Override
	public ReturnReceivingNote saveReceivingNote(ReturnReceivingNote re) {
		return returnRecordsDao.saveReceivingNote(re);
	}
	
	@Override
	public void del(String id) {
		returnRecordsDao.del(id);
	}

	@Override
	public List<?> findAllId(String s) {
		return returnRecordsDao.findAllId(s);
	}

	@Override
	public List<OutboundCheckBill> findItemById(String saleNumber) {
		return returnRecordsDao.findItemById(saleNumber);
	}

	@Override
	public List<OutboundCheckItem> findOutItem(Long id) {
		return returnRecordsDao.findOutItem(id);
	}

	@Override
	public List<OutboundCheckBill> findOutboundCheckBill(String salesItemId) {
		// TODO Auto-generated method stub
		return returnRecordsDao.findOutboundCheckBill(salesItemId);
	}

	@Override
	public int countReturnReceivingNoteByCondiction(String date,
			String customerName, String status,String xiaoshoudanhao,String tuihuodanhao,String isfood) {
		// TODO Auto-generated method stub
		return returnRecordsDao.countReturnReceivingNoteByCondiction(date, customerName, status,xiaoshoudanhao,tuihuodanhao,isfood);
		
	}

	@Override
	public List<ReturnReceivingNoteVO> findReturnReceivingNoteByCondiction(
			String date, String customerName,String status, String xiaoshoudanhao,String tuihuodanhao, String isfood,int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return returnRecordsDao.findReturnReceivingNoteByCondiction(date, customerName,status,xiaoshoudanhao,tuihuodanhao,isfood, first, pagesize);
	}

	@Override
	public Integer getSumQuantity(String saleNumber,String batchNo,String qualifiedMedicineId) {
		return returnRecordsDao.getSumQuantity(saleNumber,batchNo,qualifiedMedicineId);
	}



	
}
