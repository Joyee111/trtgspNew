package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedProcurementStaffAccessory;

public interface QualProcurementStaffAccessoryDao extends GenericDao<QualifiedProcurementStaffAccessory, Long> {
	public List<QualifiedProcurementStaffAccessory> findAccessoriesListByPage(long proStaffId,int first ,int pagesize);
}
