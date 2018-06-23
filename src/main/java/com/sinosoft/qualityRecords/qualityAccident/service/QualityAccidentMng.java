package com.sinosoft.qualityRecords.qualityAccident.service;

import java.util.List;
import java.util.Map;


import com.sinosoft.qualityRecords.qualityAccident.model.QualityAccident;

public interface QualityAccidentMng {
	List<QualityAccident> getPage(QualityAccident qa , int i, int pagesize2);

	int getTotalCount();
	QualityAccident findById(String id);

	void saveOrUpdata(QualityAccident  qa);


	void saveQualityAccident(QualityAccident qa);

	void del(String[] ids);

	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<QualityAccident> getQualityAccidentByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);

}
