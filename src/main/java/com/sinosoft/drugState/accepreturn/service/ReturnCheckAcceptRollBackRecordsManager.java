package com.sinosoft.drugState.accepreturn.service;

import com.sinosoft.base.GenericManager;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptRollBackRecords;
import com.sinosoft.user.User;

public interface ReturnCheckAcceptRollBackRecordsManager extends
		GenericManager<ReturnCheckAcceptRollBackRecords, Long> {
	public void addReturnCheckAcceptRollBackRecords(Long returnCheAccNoteRecordsId,  User applyUser, String rollBackReason);
}
