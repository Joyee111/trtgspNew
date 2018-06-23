package com.sinosoft.comQuery.ReturnCheckRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.ReturnCheckRecords.dao.ReturnCheckRecordsDao;
import com.sinosoft.comQuery.ReturnCheckRecords.service.ReturnCheckRecordsMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
@Service
public class ReturnCheckRecordsMngImpl implements ReturnCheckRecordsMng {
	@Autowired
	private ReturnCheckRecordsDao returnCheckRecordsDao;

	public void setReturnCheckRecordsDao(ReturnCheckRecordsDao returnCheckRecordsDao) {
		this.returnCheckRecordsDao = returnCheckRecordsDao;
	}

	@Override
	public int getQueryCount(String hql) {
		return returnCheckRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<?> getReturnCheckRecordsByPage(String hql, Map map, int first,
			int pagesize) {

		return returnCheckRecordsDao.getReturnCheckRecordsByPage(hql, map, first, pagesize);
	}

	@Override
	public QualifiedPurchaseUnits findById(String id) {

		return returnCheckRecordsDao.findById(id);
	}

	@Override
	public List<?> getAllReturnCheckRecord(String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return returnCheckRecordsDao.getAllReturnCheckRecord(hql, map);
	}
}
