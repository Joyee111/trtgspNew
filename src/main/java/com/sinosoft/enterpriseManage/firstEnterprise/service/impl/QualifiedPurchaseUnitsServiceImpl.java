package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedPurchaseUnitsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedPurchaseUnitsService;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 2:38:53 PM
 * 类说明
 */
@Service
public class QualifiedPurchaseUnitsServiceImpl extends
		GenericManagerImpl<QualifiedPurchaseUnits, Long> implements QualifiedPurchaseUnitsService {
	private QualifiedPurchaseUnitsDao qualifiedPurchaseUnitsDao;
	@Autowired
	public QualifiedPurchaseUnitsServiceImpl(QualifiedPurchaseUnitsDao qualifiedPurchaseUnitsDao){
		super(qualifiedPurchaseUnitsDao);
		this.qualifiedPurchaseUnitsDao = qualifiedPurchaseUnitsDao;
	}
	@Override
	public int countRecordByCondition(String sql) {
		return qualifiedPurchaseUnitsDao.countRecordByCondition(sql);
	}

	@Override
	public List<QualifiedPurchaseUnits> findListByPage(String hql, int first,
			int pagesize) {
		return qualifiedPurchaseUnitsDao.findListByPage(hql, first, pagesize);
	}

	@Override
	public List<QualifiedPurchaseUnits> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		return qualifiedPurchaseUnitsDao.findListByaPage(hql, paramMap, first, pagesize);
	}
	@Override
	public List<QualifiedPurchaseUnits> findList(String hql) {
		// TODO Auto-generated method stub
		return qualifiedPurchaseUnitsDao.findList(hql);
	}
	@Override
	public QualifiedPurchaseUnits findByPurchaseUtilsId(Long id) {
		// TODO Auto-generated method stub
		return qualifiedPurchaseUnitsDao.findByPurchaseUtilsId(id);
	}
}
