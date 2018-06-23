package com.sinosoft.drugState.maintenancePlan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.maintenancePlan.dao.MaintenancePlanDao;
import com.sinosoft.drugState.maintenancePlan.service.MaintenancePlanMng;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
@Service
public class MaintenancePlanMngImpl implements  MaintenancePlanMng{
	@Autowired
	private MaintenancePlanDao maintenancePlanDao;
	
	@Override
	public List<QualifiedmedcstoreRe> getPage(QualifiedmedcstoreRe qm, int i,
			int pagesize) {
		return maintenancePlanDao.getPage(qm, i,pagesize);
	}

	@Override
	public int getTotalCount(QualifiedmedcstoreRe qm) {
		return maintenancePlanDao.getTotalCount(qm);
	}

	@Override
	public QualifiedmedcstoreRe findById(String id) {
		return maintenancePlanDao.findById(id);
	}

	@Override
	public WarnConfig findWanrn() {
		return maintenancePlanDao.findWanrn();
	}

	@Override
	public List<QualifiedmedcstoreRe> getQualifiedMdecByDate(String startDae,
			String endDate,String batchNumber, int first, int pagesize) {
		return maintenancePlanDao.getQualifiedMdecByDate(startDae, endDate,batchNumber, first, pagesize);
	}

	@Override
	public int countQualifiedMdeByCondition(String startDate, String endDate,
			String bathcNumber) {
		// TODO Auto-generated method stub
		return maintenancePlanDao.countQualifiedMdeByCondition(startDate, endDate, bathcNumber);
	}
	
}
