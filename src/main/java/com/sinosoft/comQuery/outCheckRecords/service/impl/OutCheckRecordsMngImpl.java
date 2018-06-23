package com.sinosoft.comQuery.outCheckRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.outCheckRecords.dao.OutCheckRecordsDao;
import com.sinosoft.comQuery.outCheckRecords.service.OutCheckRecordsMng;
@Service
public class OutCheckRecordsMngImpl implements OutCheckRecordsMng {
	@Autowired
	private OutCheckRecordsDao outCheckRecordsDao;

	public void setOutCheckRecordsDao(OutCheckRecordsDao outCheckRecordsDao) {
		this.outCheckRecordsDao = outCheckRecordsDao;
	}

	@Override
	public List<?> getOutCheckRecordsByPage(String hql, Map map, int first,
			int pagesize) {

		return outCheckRecordsDao.getOutCheckRecordsByPage(hql, map, first, pagesize);
	}

	@Override
	public int getQueryCount(String hql) {

		return outCheckRecordsDao.getQueryCount(hql);
	}
}
