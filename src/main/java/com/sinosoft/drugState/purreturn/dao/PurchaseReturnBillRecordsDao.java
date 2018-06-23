package com.sinosoft.drugState.purreturn.dao;


import com.sinosoft.base.GenericDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBillRecords;
import com.sinosoft.user.User;

public interface PurchaseReturnBillRecordsDao extends GenericDao<PurchaseReturnBillRecords, Long> {

	public void addPurchaseReturnBillRecords(Long returnCheckAcceptNoteId, String projectName, String changeContent,User modityUser, String changeReason);
}
