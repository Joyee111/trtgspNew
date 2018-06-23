package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;

public interface QualSupplyDrugFromsDao extends GenericDao<QulifiedSupplyDrugFroms, Long> {
	public List<QulifiedSupplyDrugFroms> getListByQualSuppId(Long qualSuppId);
	public  void saveList(List<QulifiedSupplyDrugFroms> list);
}
