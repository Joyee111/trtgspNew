package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;

public interface SalesStaffService extends GenericManager<SalesStaff, Long> {
	public List<SalesStaff> findSalesStaffList(String type,int first,int pagesize);
	public List<SalesStaff> querySalesStaffList(String type,String param,int first,int pagesize);
	public List<SalesStaff> findSalesStaffAllByType(String type);
}
