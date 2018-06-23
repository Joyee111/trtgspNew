package com.sinosoft.qualityRecords.unqualifiedManger.dao;

import java.util.List;
import java.util.Map;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

public interface UnqualifiedManagerDao {
	/**
	 * 信息反馈列表查询列表
	 * @param qq
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
	List<UnqualifiedManager> getPage(UnqualifiedManager um, int pageSize, int resultSize, String string);
   /**
    * 信息反馈列表查询列表条数
    * @param string
    * @return
    */
	int getTotalCount(String string);
	/**
	 * 根据id查询ｍｏｄｅｌ
	 * @param id
	 * @return
	 */
	UnqualifiedManager findById(String id);
	/**
     * 修改保存
     * @param dr
     */
	void saveOrUpdata(UnqualifiedManager um);
	/**
     * 添加保存
     * @param dr
     */
	void saveUnqualifiedManager(UnqualifiedManager um);
	
   /**
    * 删除
    * @param ids
    */
	void del(String ids);
	Map<String, String> qsMap();
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UnqualifiedManager> getUnqualifiedManagerByPage(String hql,Map map ,int first, int pagesize);
	/**
	 * 根据HQL查询条件分页显示首营企业列表条数
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	int getQueryCount(String hql);
/*
 * 根据id查药品库存表
 */
	Qualifiedmedcstore findYpkcById(String id);
	List<Qualifiedmedcstore> findypJsonty();
	
	/**
	 * 获取未录入报废药品的不合格药品
	 * @return
	 * @author whn
	 */
	List<UnqualifiedManager> findunypJsonty();
	
	
	public List<QualityMidicine> findqmJsonty();
}
