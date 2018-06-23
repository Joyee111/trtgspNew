package com.sinosoft.qualityRecords.drugMaintenanceJH.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManager;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.qualityRecords.drugMaintenanceJH.dao.DrugMaintenanceJHDao;
import com.sinosoft.qualityRecords.drugMaintenanceJH.model.DrugMaintenanceJH;
import com.sinosoft.qualityRecords.drugMaintenanceJH.service.DrugMaintenanceJHMng;

@Service
public class DrugMaintenanceJHMngImpl extends GenericManagerImpl<DrugMaintenanceJH, Long> implements DrugMaintenanceJHMng{
	@Autowired
	private DrugMaintenanceJHDao drugMaintenanceJHDao;
	public void setDrugMaintenanceJHDao(DrugMaintenanceJHDao drugMaintenanceJHDao) {
		this.drugMaintenanceJHDao = drugMaintenanceJHDao;
	}
	
	@Override
	public void del(String[] ids) {
		for(int i = 0;i<ids.length;i++){
			drugMaintenanceJHDao.del(ids[i]);
		}
		
	}

	@Override
	public DrugMaintenanceJH findById(String id) {
		return drugMaintenanceJHDao.findById(id);
	}

	@Override
	public List<DrugMaintenanceJH> getDrugMaintenanceByPage(String hql,
			Map map, int first, int pagesize) {
		return drugMaintenanceJHDao.getDrugMaintenanceJHByPage(hql, map, first, pagesize);
	}

	@Override
	public List<DrugMaintenanceJH> getPage(DrugMaintenanceJH dm, int pagesize,
			int resultsize) {
		StringBuffer hql=new StringBuffer(" from DrugMaintenanceJH t where 1=1 " );
		return drugMaintenanceJHDao.getPage(dm, pagesize,resultsize,hql.toString());
	}

	@Override
	public int getQueryCount(String hql) {
		return drugMaintenanceJHDao.getQueryCount(hql);
	}

	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from DrugMaintenanceJH t where 1=1");
		return drugMaintenanceJHDao.getTotalCount(hql.toString());
	}

	@Override
	public void saveDrugMaintenanceJH(DrugMaintenanceJH dm) {
		drugMaintenanceJHDao.saveDrugMaintenanceJH(dm);
		
	}

	@Override
	public void saveOrUpdata(DrugMaintenanceJH dm) {
		drugMaintenanceJHDao.saveOrUpdata(dm);
		
	}

	@Override
	public Session getSession() {
		return drugMaintenanceJHDao.getSession();
	}

}
