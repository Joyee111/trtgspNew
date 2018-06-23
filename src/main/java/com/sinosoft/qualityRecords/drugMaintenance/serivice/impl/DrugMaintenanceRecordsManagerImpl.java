package com.sinosoft.qualityRecords.drugMaintenance.serivice.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.qualityRecords.drugMaintenance.dao.DrugMaintenanceRecordsDao;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenanceRecords;
import com.sinosoft.qualityRecords.drugMaintenance.serivice.DrugMaintenanceRecordsManager;
import com.sinosoft.user.User;
@Service
public class DrugMaintenanceRecordsManagerImpl extends
		GenericManagerImpl<DrugMaintenanceRecords, Long> implements DrugMaintenanceRecordsManager {
	private DrugMaintenanceRecordsDao dRecordsDao;
	@Autowired
	public DrugMaintenanceRecordsManagerImpl(DrugMaintenanceRecordsDao dRecordsDao){
		super(dRecordsDao);
		this.dRecordsDao = dRecordsDao;
	}
	@Override
	public void saveDrugMaintenanceRecords(Long drugMaintenanceId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		dRecordsDao.saveDrugMaintenanceRecords(drugMaintenanceId, projectName, changeContent, modityUser, changeReason);

	}


}
