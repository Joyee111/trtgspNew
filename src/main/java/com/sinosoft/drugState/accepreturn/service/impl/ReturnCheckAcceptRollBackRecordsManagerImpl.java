package com.sinosoft.drugState.accepreturn.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.drugState.accepreturn.dao.ReturnCheckAcceptRollBackRecordsDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptRollBackRecords;
import com.sinosoft.drugState.accepreturn.service.ReturnCheckAcceptRollBackRecordsManager;
import com.sinosoft.user.User;
@Service
public class ReturnCheckAcceptRollBackRecordsManagerImpl extends
		GenericManagerImpl<ReturnCheckAcceptRollBackRecords, Long> implements
		ReturnCheckAcceptRollBackRecordsManager {
	private ReturnCheckAcceptRollBackRecordsDao recordsDao;
	@Autowired
	public ReturnCheckAcceptRollBackRecordsManagerImpl(ReturnCheckAcceptRollBackRecordsDao recordsDao){
		super(recordsDao);
		this.recordsDao = recordsDao;
	}
	@Override
	public void addReturnCheckAcceptRollBackRecords(Long returnCheAccNoteRecordsId,User applyUser,
			String rollBackReason) {
		recordsDao.addReturnCheckAcceptRollBackRecords(returnCheAccNoteRecordsId, applyUser, rollBackReason);
		
	}

	

}
