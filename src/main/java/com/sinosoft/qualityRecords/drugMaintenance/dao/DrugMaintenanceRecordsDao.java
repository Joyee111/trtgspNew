package com.sinosoft.qualityRecords.drugMaintenance.dao;


import com.sinosoft.base.GenericDao;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenanceRecords;
import com.sinosoft.user.User;

public interface DrugMaintenanceRecordsDao extends GenericDao<DrugMaintenanceRecords, Long> {
	public void saveDrugMaintenanceRecords(Long drugMaintenanceId, String projectName, String changeContent, User modityUser, String changeReason);
}
