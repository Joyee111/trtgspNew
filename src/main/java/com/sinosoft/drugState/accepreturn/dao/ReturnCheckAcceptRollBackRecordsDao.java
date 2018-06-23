package com.sinosoft.drugState.accepreturn.dao;

import com.sinosoft.base.GenericDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptRollBackRecords;
import com.sinosoft.user.User;

public interface ReturnCheckAcceptRollBackRecordsDao extends GenericDao<ReturnCheckAcceptRollBackRecords, Long> {
	public void addReturnCheckAcceptRollBackRecords(Long returnCheAccNoteRecordsId, User applyUser, String rollBackReason);
}
