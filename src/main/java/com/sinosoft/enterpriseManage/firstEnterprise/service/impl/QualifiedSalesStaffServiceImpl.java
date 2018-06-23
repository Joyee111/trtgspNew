package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedSalesStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedSalesStaffService;

@Service
public class QualifiedSalesStaffServiceImpl extends
		GenericManagerImpl<SalesStaff, Long> implements QualifiedSalesStaffService {
	private QualifiedSalesStaffDao qualifiedSalesStaffDao;
	@Autowired
	public QualifiedSalesStaffServiceImpl(QualifiedSalesStaffDao qualifiedSalesStaffDao){
		super(qualifiedSalesStaffDao);
		this.qualifiedSalesStaffDao = qualifiedSalesStaffDao;
	}
	@Override
	public int countRecordByCondition(String sql) {
		return qualifiedSalesStaffDao.countRecordByCondition(sql);
	}

	@Override
	public List<SalesStaff> findListByPage(String hql, int first,
			int pagesize) {
		return qualifiedSalesStaffDao.findListByPage(hql, first, pagesize);
	}

	@Override
	public List<SalesStaff> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		return qualifiedSalesStaffDao.findListByaPage(hql, paramMap, first, pagesize);
	}
	@Override
	public List<SalesStaff> findList(String hql) {
		// TODO Auto-generated method stub
		return qualifiedSalesStaffDao.findList(hql);
	}
	@Override
	public SalesStaff findByPurchaseUtilsId(Long id) {
		// TODO Auto-generated method stub
		return qualifiedSalesStaffDao.findBySalesStaffId(id);
	}
}
