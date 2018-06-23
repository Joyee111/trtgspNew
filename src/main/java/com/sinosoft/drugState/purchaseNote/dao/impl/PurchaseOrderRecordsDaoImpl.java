package com.sinosoft.drugState.purchaseNote.dao.impl;


import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderRecords;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseOrderRecordsDao;
import com.sinosoft.user.User;
@Repository("purchaseOrderRecordsDao")
public class PurchaseOrderRecordsDaoImpl extends GenericDaoHibernate<PurchaseOrderRecords, Long>
		implements PurchaseOrderRecordsDao {
	public PurchaseOrderRecordsDaoImpl(){
		super(PurchaseOrderRecords.class);
	}
	@Override
	public void addPurchaseOrderRecords(Long purchaseOrderId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		PurchaseOrderRecords records = new PurchaseOrderRecords();
		records.setPurchaseOrderId(purchaseOrderId);
		records.setProjectName(projectName);
		records.setChangeContent(changeContent);
		records.setModityUser(modityUser);
		records.setChangeReason(changeReason);
		records.setModityDate(new Date());
		save(records);

	}


}
