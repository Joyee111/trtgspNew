package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSalesStaffAccessory;

public interface QualSalesStaffAccessoryService extends GenericManager<QualifiedSalesStaffAccessory, Long> {
	public List<QualifiedSalesStaffAccessory>findAccessoriesListByPage(long salesStaffId,int first ,int pagesize);
	public int countRecord(long salesStaffId);
	public void saveList(List<QualifiedSalesStaffAccessory> quaSalesStaffAccessoryList);
}
