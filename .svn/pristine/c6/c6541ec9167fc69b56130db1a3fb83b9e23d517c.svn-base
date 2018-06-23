package com.sinosoft.comQuery.sampleTicketRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.sampleTicketRecords.dao.SampleTicketRecordsDao;
import com.sinosoft.comQuery.sampleTicketRecords.model.SampleTicketRecords;
import com.sinosoft.comQuery.sampleTicketRecords.service.SampleTicketRecordsMng;
@Service
public class SampleTicketRecordsMngImpl implements SampleTicketRecordsMng {
	@Autowired
	private SampleTicketRecordsDao sampleTicketRecordsDao;

	public void setSampleTicketRecordsDao(SampleTicketRecordsDao sampleTicketRecordsDao) {
		this.sampleTicketRecordsDao = sampleTicketRecordsDao;
	}

	@Override
	public List<?> getSampleTicketRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return sampleTicketRecordsDao.getSampleTicketRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {

		return sampleTicketRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<SampleTicketRecords> getSampleTicketRecords(String hql, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return sampleTicketRecordsDao.getSampleTicketRecords(hql, 0, 10);
	}

	@Override
	public List<?> getAllSampleTicketRecordsByCondiction(String hql,
			Map<String, Object> paraMap) {
		return sampleTicketRecordsDao.getAllSampleTicketRecordsByCondiction(hql, paraMap);
	}
}
