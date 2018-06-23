package com.sinosoft.comQuery.infoFeedbackRecords.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;

public interface InfoFeedbackRecordsMng {
	List<InfoFeedback> getPage(InfoFeedback df,String userId,  int i, int pagesize2);

	int getTotalCount(String userId);
	
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<InfoFeedback> getInfoFeedbackByPage(String hql ,Map map , int first ,int pagesize);
	
	/**
	 * 根据id查询ｍｏｄｅｌ
	 * @param id
	 * @return
	 */
	InfoFeedback findById(String id);
}
