package com.sinosoft.drugState.purreturn.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.drugState.purreturn.dao.PurchaseReturnBillRecordsDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBillRecords;
import com.sinosoft.drugState.purreturn.service.PurchaseReturnBillRecordsDaoManager;
import com.sinosoft.user.User;
@Service
public class PurchaseReturnBillRecordsDaoManagerImpl extends
		GenericManagerImpl<PurchaseReturnBillRecords, Long> implements
		PurchaseReturnBillRecordsDaoManager {
	private PurchaseReturnBillRecordsDao recordsDao;
	@Autowired
	public PurchaseReturnBillRecordsDaoManagerImpl(PurchaseReturnBillRecordsDao recordsDao){
		super(recordsDao);
		this.recordsDao = recordsDao;
	}
	@Override
	public void addPurchaseReturnBillRecords(Long purchaseReturnBillId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		recordsDao.addPurchaseReturnBillRecords(purchaseReturnBillId, projectName, changeContent, modityUser, changeReason);

	}

}
