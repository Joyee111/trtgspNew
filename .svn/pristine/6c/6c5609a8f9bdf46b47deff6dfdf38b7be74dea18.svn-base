package com.sinosoft.comQuery.drugSaleRecords.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.comQuery.drugSaleRecords.model.DrugSaleRecords;

public interface DrugSaleRecordsMng {
	/**
	 * 根据HQL查询条件分页显示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<?> getDrugSaleRecordsByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 条件查询条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
	
	public List<DrugSaleRecords> getDrugSaleRecords(String hql ,int first ,int pagesize);
	
	public List<?> getAllDrugSaleRecordsByCondiction(String hql, Map<String, Object> paraMap);
}
