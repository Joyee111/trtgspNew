package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;

public interface SalesStaffDao extends GenericDao<SalesStaff, Long> {
	public List<SalesStaff> findSalesStaffList(String type,int first,int pagesize);
	public List<SalesStaff> querySalesStaffList(String type,String param,int first,int pagesize);
	public List<SalesStaff> findSalesStaffAllByType(String type);
}
