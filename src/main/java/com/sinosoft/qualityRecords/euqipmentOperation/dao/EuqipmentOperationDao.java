package com.sinosoft.qualityRecords.euqipmentOperation.dao;

import java.util.List;
import java.util.Map;


import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;


public interface EuqipmentOperationDao {
	/**
	 * 设备运行列表
	 * @param eo
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
    List<EuqipmentOperation> getPage(EuqipmentOperation eo, int pageSize, int resultSize, String string);
 /**
  * 设备运行类表条数
  * @param string
  * @return
  */
	int getTotalCount(String string);
	/**
	 * 根据iｄ得到ｍｏｄｅｌ　
	 * @param id
	 * @return
	 */
	EuqipmentOperation findById(String id);
	/**
	 * 修改保存
	 * @param eo
	 */

	void saveOrUpdata(EuqipmentOperation eo);
/**
 * 添加保存
 * @param eo
 */
	void saveEuqipmentOperation(EuqipmentOperation eo);
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
	public List<EuqipmentOperation> getEuqipmentOperationByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 根据HQL查询条件分页显示首营企业列表条数
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	int getQueryCount(String hql);

}
