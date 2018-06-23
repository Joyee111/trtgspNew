package com.sinosoft.qualityRecords.temRecords.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.temRecords.dao.TemRecordsDao;
import com.sinosoft.qualityRecords.temRecords.model.HumitureRecord;
import com.sinosoft.qualityRecords.temRecords.serivice.TemRecordsMng;
@Service
public class TemRecordsMngImpl implements TemRecordsMng {
	@Autowired
	private TemRecordsDao temRecordsDao;

	public void setTemRecordsDao(TemRecordsDao temRecordsDao) {
		this.temRecordsDao = temRecordsDao;
	}

	@Override
	public int getQueryCount(String hql) {

		return temRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<?> getTemRecordsByPage(String hql, Map map, int first,
			int pagesize) {
		return temRecordsDao.getTemRecordsByPage(hql, map, first, pagesize);
	}

	@Override
	public List<?> getHumByPage(String hql) {

		return temRecordsDao.getHumByPage(hql);
	}

	@Override
	public List<?> getTemByPage(String hql) {

		return temRecordsDao.getTemByPage(hql);
	}

	@Override
	public List<HumitureRecord> findHumAndTemByCondition(String location,
			String startDate, String endDate, int first, int pagesize) {
		// TODO Auto-generated method stub
		return temRecordsDao.findHumAndTemByCondition(location, startDate, endDate, first, pagesize);
	}

	@Override
	public int countHumAndTemByCondition(String location, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return temRecordsDao.countHumAndTemByCondition(location, startDate, endDate);
	}


	@Override
	public List<HumitureRecord> findHumAndTemByTableName(String tableName,String location,
			String startDate, String endDate, int first, int pagesize) {
		// TODO Auto-generated method stub
		return temRecordsDao.findHumAndTemByTableName(tableName,location, startDate, endDate, first, pagesize);
	}


	@Override
	public int countHumAndTemByTableName(String tableName,String location,String startDate,String endDate) {
		// TODO Auto-generated method stub
		return temRecordsDao.countHumAndTemByTableName(tableName,location, startDate, endDate);
	}



	
}
