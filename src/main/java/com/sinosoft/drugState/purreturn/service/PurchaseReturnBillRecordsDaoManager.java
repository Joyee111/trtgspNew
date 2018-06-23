package com.sinosoft.drugState.purreturn.service;

import com.sinosoft.base.GenericManager;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBillRecords;
import com.sinosoft.user.User;

public interface PurchaseReturnBillRecordsDaoManager extends
		GenericManager<PurchaseReturnBillRecords, Long> {
	public void addPurchaseReturnBillRecords(Long purchaseReturnBillId,
			String projectName, String changeContent, User modityUser,
			String changeReason);
}
