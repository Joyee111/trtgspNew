package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 1:58:09 PM
 * 类说明
 */
public interface QualifiedPurchaseUnitsDao extends GenericDao<QualifiedPurchaseUnits, Long> {
	public List<QualifiedPurchaseUnits> findListByPage(String hql ,int first ,int pagesize);
	public List<QualifiedPurchaseUnits> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
	public int countRecordByCondition(String sql);
	public List<QualifiedPurchaseUnits> findList(String hql);
	public QualifiedPurchaseUnits findByPurchaseUtilsId(Long id);
}
