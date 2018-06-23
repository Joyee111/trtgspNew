package com.sinosoft.drugState.accepreturn.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.drugState.accepreturn.dao.ReturnCheckAcceptNoteRecordsDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.drugState.accepreturn.service.ReturnCheckAcceptNoteRecordsManager;
import com.sinosoft.user.User;
@Service
public class ReturnCheckAcceptNoteRecordsManagerImpl extends
		GenericManagerImpl<ReturnCheckAcceptNoteRecords, Long> implements
		ReturnCheckAcceptNoteRecordsManager {
	private ReturnCheckAcceptNoteRecordsDao recordsDao;
	@Autowired
	public ReturnCheckAcceptNoteRecordsManagerImpl(ReturnCheckAcceptNoteRecordsDao recordsDao){
		super(recordsDao);
		this.recordsDao = recordsDao;
	}
	@Override
	public void addReturnCheckAcceptNoteRecords(Long returnCheAccNoteRecordsId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		recordsDao.addReturnCheckAcceptNoteRecords(returnCheAccNoteRecordsId, projectName, changeContent, modityUser, changeReason);
		
	}

	

}
