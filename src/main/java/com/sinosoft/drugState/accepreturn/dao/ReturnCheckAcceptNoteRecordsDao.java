package com.sinosoft.drugState.accepreturn.dao;

import com.sinosoft.base.GenericDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.user.User;

public interface ReturnCheckAcceptNoteRecordsDao extends GenericDao<ReturnCheckAcceptNoteRecords, Long> {
	public void addReturnCheckAcceptNoteRecords(Long returnCheAccNoteRecordsId, String projectName, String changeContent, User modityUser, String changeReason);
}
