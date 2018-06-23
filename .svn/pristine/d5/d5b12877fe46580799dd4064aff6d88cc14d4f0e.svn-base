package com.sinosoft.qualityRecords.euqipmentOperation.serivice;

import java.util.List;
import java.util.Map;


import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;


public interface EuqipmentOperationMng {
	List<EuqipmentOperation> getPage(EuqipmentOperation eo, int i, int pagesize2);

	int getTotalCount();
	EuqipmentOperation findById(String id);

	void saveOrUpdata(EuqipmentOperation eo);


	void saveEuqipmentOperation(EuqipmentOperation eo);

	void del(String[] ids);

	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<EuqipmentOperation> getEuqipmentOperationByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);

}
