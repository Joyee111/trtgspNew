package com.sinosoft.comQuery.sampleTicketRecords.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.comQuery.sampleTicketRecords.model.SampleTicketRecords;

public interface SampleTicketRecordsMng {
	/**
	 * 根据HQL查询条件分页显示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<?> getSampleTicketRecordsByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 条件查询条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
	
	public List<SampleTicketRecords> getSampleTicketRecords(String hql ,int first ,int pagesize);
	
	public List<?> getAllSampleTicketRecordsByCondiction(String hql, Map<String, Object> paraMap);
}
