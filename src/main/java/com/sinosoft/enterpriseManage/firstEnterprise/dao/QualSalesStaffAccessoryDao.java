package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSalesStaffAccessory;

public interface QualSalesStaffAccessoryDao extends GenericDao<QualifiedSalesStaffAccessory, Long> {
	public List<QualifiedSalesStaffAccessory> findAccessoriesListByPage(long salesStaffId,int first ,int pagesize);
}
