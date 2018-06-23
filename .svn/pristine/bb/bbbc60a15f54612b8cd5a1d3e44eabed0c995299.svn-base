package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedSuppliersDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSuppliersService;
@Service
public class QualSupplyServiceImpl extends GenericManagerImpl<QualifiedSuppliers,Long> implements
		QualifiedSuppliersService {
	
	private QualifiedSuppliersDao qualifiedSuppliersDao;
	@Autowired
	public QualSupplyServiceImpl(QualifiedSuppliersDao qualifiedSuppliersDao){
		super(qualifiedSuppliersDao);
		this.qualifiedSuppliersDao = qualifiedSuppliersDao;
	}
	@Override
	public int countOrderInfo(String sql) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.getRecordCount(sql);
	}

	@Override
	public List<QualifiedSuppliers> getQualifiedSuppliersList(int first,
			int pageSize) {
		String hql = " from QualifiedSuppliers a order by a.id DESC";
		Map<String, Object> map = new HashMap<String, Object>();
		return qualifiedSuppliersDao.getQualifiedSuppliersByPage(hql, map, first, pageSize);
	}

	@Override
	public List<QualifiedSuppliers> getQualifiedSuppliersListByCondition(
			String hql, Map<String, Object> map, int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.getQualifiedSuppliersByPage(hql, map, first, pagesize);
	}
	@Override
	public QualifiedSuppliers findById(String id) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.findById(id);
	}
	@Override
	public List<QualifiedSuppliers> findList(String hql) {
		
		return qualifiedSuppliersDao.findList(hql);
	}
	@Override
	public QualifiedSuppliers findByFirstEnterpriseId(Long id) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.findByFirstEnterpriseId(id);
	}
	@Override
	public List<QualifiedSuppliers> getAllQualifieddSupplisersByCondiction(
			String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.getAllQualifieddSupplisersByCondiction(hql, map);
	}
	@Override
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryByRequestName(
			String requestName) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.findQulifiedSupplyAccessoryByRequestName(requestName);
	}
	@Override
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryById(String id) {
		// TODO Auto-generated method stub
		return qualifiedSuppliersDao.findQulifiedSupplyAccessoryById(id);
	}
	@Override
	public void saveQulifiedSupplyAccessory(
			QulifiedSupplyAccessory accessory) {
		// TODO Auto-generated method stub
		 qualifiedSuppliersDao.saveQulifiedSupplyAccessory(accessory);
	}

	
}
