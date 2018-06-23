package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagementAccessory;

public interface OurQualityManagementAccessoryService extends GenericManager<OurQualityManagementAccessory, Long> {
	public List<OurQualityManagementAccessory>findAccessoriesListByPage(long company_quality_management_id,int first ,int pagesize);
	public int countRecord(long company_quality_management_id);
	public void saveList(List<OurQualityManagementAccessory> ourQualityManagementAccessoryList);
}
