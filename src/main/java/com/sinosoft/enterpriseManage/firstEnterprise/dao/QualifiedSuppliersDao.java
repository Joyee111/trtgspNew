package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;

public interface QualifiedSuppliersDao extends GenericDao<QualifiedSuppliers, Long> {
	/**
	 * 根据HQL查询条件分页显示合格供应商列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<QualifiedSuppliers> getQualifiedSuppliersByPage(String hql,Map map ,int first, int pageseiz);
	QualifiedSuppliers findById(String id);
	public List<QualifiedSuppliers> findList(String hql);
	QualifiedSuppliers findByFirstEnterpriseId(Long id);
	public List<QualifiedSuppliers> getAllQualifieddSupplisersByCondiction(
			String hql, Map<String, Object> map);
	/**
	 * 查询合格供应商附件
	 * @param requestName
	 * @return
	 */
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryByRequestName(String requestName);
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryById(String id);
	public void saveQulifiedSupplyAccessory(QulifiedSupplyAccessory accessory);
}
