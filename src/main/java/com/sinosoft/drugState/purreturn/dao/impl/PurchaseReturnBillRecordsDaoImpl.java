package com.sinosoft.drugState.purreturn.dao.impl;


import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.purreturn.dao.PurchaseReturnBillRecordsDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBillRecords;
import com.sinosoft.user.User;
@Repository("purchaseReturnBillRecordsDao")
public class PurchaseReturnBillRecordsDaoImpl extends
		GenericDaoHibernate<PurchaseReturnBillRecords, Long> implements PurchaseReturnBillRecordsDao {
	public PurchaseReturnBillRecordsDaoImpl(){
		super(PurchaseReturnBillRecords.class);
	}
	@Override
	public void addPurchaseReturnBillRecords(Long purchaseReturnBillId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		PurchaseReturnBillRecords records = new PurchaseReturnBillRecords();
		records.setPurchaseReturnBillId(purchaseReturnBillId);
		records.setProjectName(projectName);
		records.setChangeContent(changeContent);
		records.setModityUser(modityUser);
		records.setChangeReason(changeReason);
		records.setModityDate(new Date());
		save(records);
	}
}
