package com.sinosoft.qualityRecords.drugMaintenance.serivice;

import java.util.List;
import java.util.Map;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
public interface DrugMaintenanceMng {
	List<DrugMaintenance> getPage(DrugMaintenance dm, int i, int pagesize2);

	int getTotalCount();
	DrugMaintenance findById(String id);

	void saveOrUpdata(DrugMaintenance dm);


	void saveDrugMaintenance(DrugMaintenance dm);

	void del(String[] ids);

	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<DrugMaintenance> getDrugMaintenanceByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);

}
