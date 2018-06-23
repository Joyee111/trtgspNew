package com.sinosoft.drugState.purchaseNote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderRecords;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseOrderRecordsDao;
import com.sinosoft.drugState.purchaseNote.service.PurchaseOrderRecordsManager;
import com.sinosoft.user.User;
@Service
public class PurchaseOrderRecordsManagerImpl extends GenericManagerImpl<PurchaseOrderRecords, Long>
		implements PurchaseOrderRecordsManager {
	private PurchaseOrderRecordsDao purchaseOrderRecordsDao;
	@Autowired
	public PurchaseOrderRecordsManagerImpl(PurchaseOrderRecordsDao purchaseOrderRecordsDao){
		super(purchaseOrderRecordsDao);
		this.purchaseOrderRecordsDao = purchaseOrderRecordsDao;
	}
	@Override
	public void addPurchaseOrderRecords(Long purchaseOrderId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		purchaseOrderRecordsDao.addPurchaseOrderRecords(purchaseOrderId, projectName, changeContent, modityUser, changeReason);

	}
}
