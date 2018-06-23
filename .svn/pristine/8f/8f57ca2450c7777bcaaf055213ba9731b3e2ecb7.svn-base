package com.sinosoft.qualityRecords.temRecords.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.temRecords.model.HumitureRecord;

public interface TemRecordsDao {
public List<?> getTemRecordsByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	public List<?> getTemByPage(String hql );
	public List<?> getHumByPage(String hql );
	
	public List<HumitureRecord> findHumAndTemByCondition(String location,String startDate,String endDate,int first,int pagesize);
	public int countHumAndTemByCondition(String location,String startDate,String endDate);
	
	public List<HumitureRecord> findHumAndTemByTableName(String tableName,String location,
			String startDate, String endDate, int first, int pagesize);
	
	public int countHumAndTemByTableName(String tableName,String location,String startDate,String endDate);
}
