package com.sinosoft.comQuery.receivingRecordsJH.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.receivingRecordsJH.dao.ReceivingRecordsJHDao;
import com.sinosoft.comQuery.receivingRecordsJH.service.ReceivingRecordsJHMng;

@Service
public class ReceivingRecordsJHMngImpl implements ReceivingRecordsJHMng{
	@Autowired
	private ReceivingRecordsJHDao receivingRecordsJHDao;

	public void setInspeAcceptRecordsJHDao(ReceivingRecordsJHDao receivingRecordsJHDao) {
		this.receivingRecordsJHDao = receivingRecordsJHDao;
	}

	@Override
	public List<?> getReceivingRecordsJHByPage(String hql, Map map, int first,
			int pageseiz) {

		return receivingRecordsJHDao.getReceivingRecordsJHByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		
		return receivingRecordsJHDao.getQueryCount(hql);
	}
}
