package com.sinosoft.comQuery.receivingRecords.dao;

import java.util.List;
import java.util.Map;

public interface ReceivingRecordsDao {
	/**
	 * 根据HQL查询条件分页显示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<?> getReceivingRecordsByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 条件查询条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
}
