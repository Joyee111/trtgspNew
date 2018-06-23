package com.sinosoft.comQuery.infoFeedbackRecords.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;

public interface InfoFeedbackRecordsDao {
	/**
	 * 信息反馈列表查询列表
	 * @param qq
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
    List<InfoFeedback> getPage(InfoFeedback df,String userId,int pageSize, int resultSize, String string);
   /**
    * 信息反馈列表查询列表条数
    * @param string
    * @return
    */
	int getTotalCount(String string);
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<InfoFeedback> getInfoFeedbackByPage(String hql,Map map ,int first, int pagesize);
	/**
	 * 根据id查询ｍｏｄｅｌ
	 * @param id
	 * @return
	 */
	InfoFeedback findById(String id);
}
