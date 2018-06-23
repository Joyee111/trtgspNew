package com.sinosoft.qualityRecords.qualityAccident.dao;

import java.util.List;
import java.util.Map;


import com.sinosoft.qualityRecords.qualityAccident.model.QualityAccident;

public interface QualityAccidentDao {
	/**
	 * 展示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	List<QualityAccident> getPage(QualityAccident qa, int pageSize, int resultSize, String string);
/**
 * 展示条数
 * @param string
 * @return
 */
	int getTotalCount(String string);
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	QualityAccident findById(String id);
	
/**
 * 添加修改
 * @param qa
 */
	void saveOrUpdata(QualityAccident qa);
/**
 * 保存
 * @param qa
 */
	void saveQualityAccident(QualityAccident qa);
/**
 * 删除
 * @param ids
 */
	void del(String ids);
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<QualityAccident> getQualityAccidentByPage(String hql,Map map ,int first, int pagesize);
	/**
	 * 带查询条件的条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);

}
