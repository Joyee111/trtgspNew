package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.SalesStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.SalesStaffService;
@Service
public class SalesStaffServiceImpl extends GenericManagerImpl<SalesStaff, Long> implements
		SalesStaffService {
	private  SalesStaffDao  salesStaffDao;
	@Autowired
	public SalesStaffServiceImpl(SalesStaffDao  salesStaffDao){
		super(salesStaffDao);
		this.salesStaffDao = salesStaffDao;
	}
	@Override
	public List<SalesStaff> findSalesStaffList(String type, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return salesStaffDao.findSalesStaffList(type, first, pagesize);
	}

	@Override
	public List<SalesStaff> querySalesStaffList(String type, String param,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return salesStaffDao.querySalesStaffList(type, param, first, pagesize);
	}
	@Override
	public List<SalesStaff> findSalesStaffAllByType(String type) {
		// TODO Auto-generated method stub
		return salesStaffDao.findSalesStaffAllByType(type);
	}

	

}
