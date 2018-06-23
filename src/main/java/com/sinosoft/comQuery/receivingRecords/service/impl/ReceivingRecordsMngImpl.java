package com.sinosoft.comQuery.receivingRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.receivingRecords.dao.ReceivingRecordsDao;
import com.sinosoft.comQuery.receivingRecords.service.ReceivingRecordsMng;
@Service
public class ReceivingRecordsMngImpl implements ReceivingRecordsMng {
	@Autowired
	private ReceivingRecordsDao receivingRecordsDao;

	public void setInspeAcceptRecordsDao(ReceivingRecordsDao receivingRecordsDao) {
		this.receivingRecordsDao = receivingRecordsDao;
	}

	@Override
	public List<?> getReceivingRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return receivingRecordsDao.getReceivingRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		
		return receivingRecordsDao.getQueryCount(hql);
	}

}
