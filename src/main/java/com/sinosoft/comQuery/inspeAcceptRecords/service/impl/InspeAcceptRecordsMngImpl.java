package com.sinosoft.comQuery.inspeAcceptRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.inspeAcceptRecords.dao.InspeAcceptRecordsDao;
import com.sinosoft.comQuery.inspeAcceptRecords.service.InspeAcceptRecordsMng;
@Service
public class InspeAcceptRecordsMngImpl implements InspeAcceptRecordsMng {
	@Autowired
	private InspeAcceptRecordsDao inspeAcceptRecordsDao;

	public void setInspeAcceptRecordsDao(InspeAcceptRecordsDao inspeAcceptRecordsDao) {
		this.inspeAcceptRecordsDao = inspeAcceptRecordsDao;
	}

	@Override
	public List<?> getInspeAcceptRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return inspeAcceptRecordsDao.getInspeAcceptRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		
		return inspeAcceptRecordsDao.getQueryCount(hql);
	}

}
