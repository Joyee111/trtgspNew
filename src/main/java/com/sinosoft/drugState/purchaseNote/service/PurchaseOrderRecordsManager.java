package com.sinosoft.drugState.purchaseNote.service;

import com.sinosoft.base.GenericManager;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderRecords;
import com.sinosoft.user.User;

public interface PurchaseOrderRecordsManager extends GenericManager<PurchaseOrderRecords, Long> {
	public  void addPurchaseOrderRecords(Long purchaseOrderId, String projectName, String changeContent,User modityUser,String changeReason);
}
