package com.sinosoft.comQuery.outCheckRecords.service;

import java.util.List;
import java.util.Map;

public interface OutCheckRecordsMng {
public List<?> getOutCheckRecordsByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
}
