package com.sinosoft.qualityRecords.drugMaintenance.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.drugMaintenance.dao.DrugMaintenanceDao;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.qualityRecords.drugMaintenance.serivice.DrugMaintenanceMng;

@Service
public class DrugMaintenanceMngImpl implements DrugMaintenanceMng{
	 @Autowired
	private DrugMaintenanceDao drugMaintenanceDao;
	public void setDrugMaintenanceDao(DrugMaintenanceDao drugMaintenanceDao) {
		this.drugMaintenanceDao = drugMaintenanceDao;
	}
	@Override
	public List<DrugMaintenance> getPage(DrugMaintenance dm, int pageSize,
			int resultSize) {
		StringBuffer hql=new StringBuffer(" from DrugMaintenance t where 1=1 " );
		return drugMaintenanceDao.getPage(dm, pageSize,resultSize,hql.toString());
	}
	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from DrugMaintenance t where 1=1");
		return drugMaintenanceDao.getTotalCount(hql.toString());
	}
	@Override
	public DrugMaintenance findById(String id) {
		return drugMaintenanceDao.findById(id);
	}


	@Override
	public void saveOrUpdata(DrugMaintenance dm) {
		drugMaintenanceDao.saveOrUpdata(dm);
	}
	@Override
	public void saveDrugMaintenance(DrugMaintenance dm) {
		drugMaintenanceDao.saveDrugMaintenance(dm);
	}


	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			drugMaintenanceDao.del(ids[i]);
		}
		
	}
	@Override
	public List<DrugMaintenance> getDrugMaintenanceByPage(String hql, Map map,
			int first, int pagesize) {
		return drugMaintenanceDao.getDrugMaintenanceByPage(hql, map, first, pagesize);
	}

	@Override
	public int getQueryCount(String hql) {

		return drugMaintenanceDao.getQueryCount(hql);
	}
}
