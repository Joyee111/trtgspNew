package com.sinosoft.drugState.accepreturn.dao.impl;


import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.accepreturn.dao.ReturnCheckAcceptNoteRecordsDao;
import com.sinosoft.drugState.accepreturn.dao.ReturnCheckAcceptRollBackRecordsDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptRollBackRecords;
import com.sinosoft.user.User;
@Repository("returnCheckAcceptRollBackRecordsDao")
public class ReturnCheckAcceptRollBackRecordsDaoImpl extends
		GenericDaoHibernate<ReturnCheckAcceptRollBackRecords, Long> implements ReturnCheckAcceptRollBackRecordsDao {
	public ReturnCheckAcceptRollBackRecordsDaoImpl(){
		super(ReturnCheckAcceptRollBackRecords.class);
	}
	@Override
	public void addReturnCheckAcceptRollBackRecords(Long returnCheAccNoteRecordsId, User applyUser,
			String rollBackReason) {
		ReturnCheckAcceptRollBackRecords records = new ReturnCheckAcceptRollBackRecords();
		records.setReturnCheckAcceptNoteId(returnCheAccNoteRecordsId);
		records.setApplicant(applyUser);
		records.setApplyDate(new Date());
		records.setRollbackReason(rollBackReason);
		save(records);

	}

	

}
