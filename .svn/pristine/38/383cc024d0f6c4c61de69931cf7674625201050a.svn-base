package com.sinosoft.comQuery.returnReceivingRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.returnReceivingRecords.dao.ReturnReceivingRecordsDao;
import com.sinosoft.comQuery.returnReceivingRecords.service.ReturnReceivingRecordsMng;
@Service
public class ReturnReceivingRecordsMngImpl implements ReturnReceivingRecordsMng {
	@Autowired
	private  ReturnReceivingRecordsDao returnReceivingRecordsDao;

	public void setReturnReceivingRecordsDao(
			ReturnReceivingRecordsDao returnReceivingRecordsDao) {
		this.returnReceivingRecordsDao = returnReceivingRecordsDao;
	}

	@Override
	public int getQueryCount(String hql) {
		return returnReceivingRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<?> getReturnReceivingRecordsByPage(String hql, Map map,
			int first, int pageseiz) {
		return returnReceivingRecordsDao.getReturnReceivingRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public List<?> getAllReturnReceivingRecords(String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return returnReceivingRecordsDao.getAllReturnReceivingRecords(hql, map);
	}
}
