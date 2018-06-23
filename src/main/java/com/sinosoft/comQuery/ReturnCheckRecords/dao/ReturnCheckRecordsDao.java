package com.sinosoft.comQuery.ReturnCheckRecords.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

public interface ReturnCheckRecordsDao {
public List<?> getReturnCheckRecordsByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	public QualifiedPurchaseUnits  findById(String id);
	public List<?> getAllReturnCheckRecord(String hql ,Map<String, Object> map);
}
