package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;

public interface QualifiedSuppliersService extends GenericManager<QualifiedSuppliers, Long> {
	/**
	 * 默认查询供应商列表
	 * @param first
	 * @param pageSize
	 * @return
	 */
	public List<QualifiedSuppliers> getQualifiedSuppliersList(int first, int pageSize);
	/**
	 * 根据查询条件查询供应商列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<QualifiedSuppliers> getQualifiedSuppliersListByCondition(String hql ,Map<String,Object> map,int first,int pagesize);
	/**
	 * 统计总记录数
	 * @param sql
	 * @return
	 */
	public int countOrderInfo(String sql);
	QualifiedSuppliers  findById(String id);
	public List<QualifiedSuppliers> findList(String hql);
	public QualifiedSuppliers findByFirstEnterpriseId(Long id);
	
	public List<QualifiedSuppliers> getAllQualifieddSupplisersByCondiction(String hql,Map<String, Object> map);
	
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryByRequestName(String requestName);
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryById(String id);
	public void saveQulifiedSupplyAccessory(QulifiedSupplyAccessory accessory);
}
