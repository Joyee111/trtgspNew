package com.sinosoft.comQuery.drugComInfoRecords.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;

public interface DrugComInfoRecordsMng {
    /**
     * 投诉管理列表
     * @param dr
     * @param pageSize
     * @param resultSize
     * @param string
     * @return
     */
	List<DrugComInfo> getPage(DrugComInfo dr,String userId, int i, int pagesize);

	int getTotalCount();
	/**
	 * 根据id查询ｍｏｄｅｌ
	 * @param id
	 * @return
	 */
	DrugComInfo findById(String id);
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<DrugComInfo> getDrugComInfoByPage(String hql ,Map map , int first ,int pagesize);
}
