package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;

public interface QualSupplyDrugFromsService extends GenericManager<QulifiedSupplyDrugFroms, Long> {
	public List<QulifiedSupplyDrugFroms> getListByQualSuppId(Long id);
	public void saveList(List<QulifiedSupplyDrugFroms> drugFromsList);
	
}
