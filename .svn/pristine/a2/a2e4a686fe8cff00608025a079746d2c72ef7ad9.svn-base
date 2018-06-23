package com.sinosoft.qualityRecords.qualityQuery.serivice;

import java.util.List;
import java.util.Map;


import com.sinosoft.qualityRecords.qualityQuery.model.QulityQuery;

public interface QualityQueryMng {
	List<QulityQuery> getPage(QulityQuery qq, int i, int pagesize2);

	int getTotalCount();
	QulityQuery findById(String id);

	void saveOrUpdata(QulityQuery qq);


	void saveQulityQuery(QulityQuery qq);

	void del(String[] ids);
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<QulityQuery> getQulityQueryByPage(String hql,Map map ,int first, int pagesize);
	int getQueryCount(String hql);

}
