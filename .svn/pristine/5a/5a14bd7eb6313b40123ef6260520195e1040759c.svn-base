package com.sinosoft.qualityRecords.drugMaintenance.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.drugMaintenance.dao.DrugMaintenanceRecordsDao;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenanceRecords;
import com.sinosoft.user.User;
@Repository("drugMaintenanceRecordsDao")
public class DrugMaintenanceRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenanceRecords, Long>
		implements DrugMaintenanceRecordsDao {
	public DrugMaintenanceRecordsDaoImpl(){
		super(DrugMaintenanceRecords.class);
	}
	@Override
	public void saveDrugMaintenanceRecords(Long drugMaintenanceId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		DrugMaintenanceRecords records = new DrugMaintenanceRecords();
		records.setDrugMaintenanceId(drugMaintenanceId);
		records.setProjectName(projectName);
		records.setChangeContent(changeContent);
		records.setModityUser(modityUser);
		records.setChangeReason(changeReason);
		records.setModityDate(new Date());
		save(records);

	}

	

}
