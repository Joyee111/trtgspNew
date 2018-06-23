package com.sinosoft.comQuery.comQuery.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.CustomerInfo;



public interface ComQueryDao {
	//供应商展示
	 
 
	
    List<FirstEnterprise> getPage(FirstEnterprise fe, int pageSize, int resultSize, String string);

	int getTotalCount(String string);
	//合格供应商
	QualifiedSuppliers findById(String id);
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	/**
	 * 购货商
	 * @param hql
	 * @param map
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<PurchaseUnit> getPurchaseUnitByPage(String hql ,Map map , int first ,int pagesize);
	int getPurchaseUnitCount(String hql);
	/**
	 * 查询满足条件的购货商
	 * @param hql
	 * @param map
	 * @return
	 */
	public List<CustomerInfo> getCustomerInfoList(String hql ,Map<String,String> map);

}
