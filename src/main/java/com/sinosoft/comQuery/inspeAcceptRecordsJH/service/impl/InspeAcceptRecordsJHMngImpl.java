package com.sinosoft.comQuery.inspeAcceptRecordsJH.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.inspeAcceptRecordsJH.dao.InspeAcceptRecordsJHDao;
import com.sinosoft.comQuery.inspeAcceptRecordsJH.service.InspeAcceptRecordsJHMng;

@Service
public class InspeAcceptRecordsJHMngImpl implements InspeAcceptRecordsJHMng{
	@Autowired
	private InspeAcceptRecordsJHDao inspeAcceptRecordsJHDao;

	public void setInspeAcceptRecordsJHDao(InspeAcceptRecordsJHDao inspeAcceptRecordsJHDao) {
		this.inspeAcceptRecordsJHDao = inspeAcceptRecordsJHDao;
	}

	@Override
	public List<?> getInspeAcceptRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return inspeAcceptRecordsJHDao.getInspeAcceptRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		
		return inspeAcceptRecordsJHDao.getQueryCount(hql);
	}
}
