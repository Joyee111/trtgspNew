package com.sinosoft.qualityRecords.unqualifiedManger.service;

import java.util.List;
import java.util.Map;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

public interface UnqualifiedManagerMng {
	List<UnqualifiedManager> getPage(UnqualifiedManager um, int i, int pagesize2);

	int getTotalCount();
	UnqualifiedManager findById(String id);

	void saveOrUpdata(UnqualifiedManager um);


	void saveUnqualifiedManager(UnqualifiedManager um);

	void del(String[] ids);
	Map<String, String> qsMap();
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<UnqualifiedManager> getUnqualifiedManagerByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	/*
	 * 根据id查药品库存表
	 */
		Qualifiedmedcstore findYpkcById(String id);

		List<Qualifiedmedcstore> findypJsonqy();
}
