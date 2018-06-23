package com.sinosoft.qualityRecords.drugMaintenanceJH.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.sinosoft.base.GenericManager;
import com.sinosoft.qualityRecords.drugMaintenanceJH.model.DrugMaintenanceJH;

public interface DrugMaintenanceJHMng extends GenericManager<DrugMaintenanceJH, Long>{
	List<DrugMaintenanceJH> getPage(DrugMaintenanceJH dm, int pagesize, int resultsize);

	int getTotalCount();
	DrugMaintenanceJH findById(String id);

	void saveOrUpdata(DrugMaintenanceJH dm);


	void saveDrugMaintenanceJH(DrugMaintenanceJH dm);

	void del(String[] ids);

	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<DrugMaintenanceJH> getDrugMaintenanceByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	
	public Session getSession();
}
