package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;

public interface FirstEnterpriseService extends GenericManager<FirstEnterprise, Long> {
	/**
	 *
	 * @param firsEnterprise  查询实体
	 * @param first
	 * @param pageSize 页面大小
	 * @return
	 */
	public List<FirstEnterprise> getFirstEnterprisesList(int first, int pageSize);
	/**
	 * 
	 * @param state 状态
	 * @return
	 */
	public int getOrderInfoCountByState( Integer state);
	
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql ,Map map , int first ,int pagesize);
}
