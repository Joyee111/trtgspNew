package com.sinosoft.comQuery.returnReceivingRecords.dao;

import java.util.List;
import java.util.Map;

public interface ReturnReceivingRecordsDao  {
	/**
	 * 根据HQL查询条件分页显示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<?> getReturnReceivingRecordsByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 条件查询条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
	public List<?> getAllReturnReceivingRecords(String hql, Map<String, Object> map);
}
