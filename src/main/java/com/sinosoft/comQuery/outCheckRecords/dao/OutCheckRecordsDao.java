package com.sinosoft.comQuery.outCheckRecords.dao;

import java.util.List;
import java.util.Map;

public interface OutCheckRecordsDao {
public List<?> getOutCheckRecordsByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
}
