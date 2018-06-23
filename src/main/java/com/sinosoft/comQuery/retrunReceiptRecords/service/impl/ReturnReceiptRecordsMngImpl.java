package com.sinosoft.comQuery.retrunReceiptRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.retrunReceiptRecords.dao.ReturnReceiptRecordsDao;
import com.sinosoft.comQuery.retrunReceiptRecords.service.ReturnReceiptRecordsMng;
@Service
public class ReturnReceiptRecordsMngImpl implements ReturnReceiptRecordsMng {
	@Autowired
	private ReturnReceiptRecordsDao returnReceiptRecordsDao;

	public void setInspeAcceptRecordsDao(ReturnReceiptRecordsDao returnReceiptRecordsDao) {
		this.returnReceiptRecordsDao = returnReceiptRecordsDao;
	}

	@Override
	public List<?> getReturnReceiptRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return returnReceiptRecordsDao.getReturnReceiptRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		
		return returnReceiptRecordsDao.getQueryCount(hql);
	}

}
