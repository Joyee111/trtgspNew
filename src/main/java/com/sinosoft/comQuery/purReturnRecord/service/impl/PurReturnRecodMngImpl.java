package com.sinosoft.comQuery.purReturnRecord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sinosoft.comQuery.purReturnRecord.dao.PurReturnRecordDao;
import com.sinosoft.comQuery.purReturnRecord.service.PurReturnRecordMng;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;

@Service
public class PurReturnRecodMngImpl implements PurReturnRecordMng {
	@Autowired
	private PurReturnRecordDao purReturnRecordDao;

	public void setPurReturnRecordDao(PurReturnRecordDao purReturnRecordDao) {
		this.purReturnRecordDao = purReturnRecordDao;
	}

	@Override
	public List<PurchaseReturnBill> getPage(PurchaseReturnBill mc,String isfood, int i,
			int pagesize) {

		return purReturnRecordDao.getPage(mc,isfood, i, pagesize);
	}

	@Override
	public int getTotalCount(PurchaseReturnBill mc,String isfood) {

		return purReturnRecordDao.getTotalCount(mc,isfood);
	}

	@Override
	public List<PurchaseReturnBill> getAll(String tuihuodanwei,String department, int i,
			int pagesize) {
		// TODO Auto-generated method stub
		return purReturnRecordDao.getAll(tuihuodanwei,department, i, pagesize);
	}
}
