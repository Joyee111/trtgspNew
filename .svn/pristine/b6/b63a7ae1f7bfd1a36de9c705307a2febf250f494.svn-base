package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 2:37:29 PM
 * 类说明
 */
public interface QualifiedPurchaseUnitsService extends GenericManager<QualifiedPurchaseUnits, Long> {
	public List<QualifiedPurchaseUnits> findListByPage(String hql ,int first ,int pagesize);
	public List<QualifiedPurchaseUnits> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
	public int countRecordByCondition(String sql);
	public List<QualifiedPurchaseUnits> findList(String hql);
	public QualifiedPurchaseUnits findByPurchaseUtilsId(Long id);
}
