package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedProcurementStaffAccessory;

public interface QualProcurementStaffAccessoryService extends GenericManager<QualifiedProcurementStaffAccessory, Long> {
	public List<QualifiedProcurementStaffAccessory>findAccessoriesListByPage(long procurementStaffId,int first ,int pagesize);
	public int countRecord(long procurementStaffId);
	public void saveList(List<QualifiedProcurementStaffAccessory> quaProcurementStaffAccessoryList);
}
