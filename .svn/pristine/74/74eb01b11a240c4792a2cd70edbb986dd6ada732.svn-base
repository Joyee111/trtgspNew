package com.sinosoft.drugState.accepreturn.dao.impl;


import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.accepreturn.dao.ReturnCheckAcceptNoteRecordsDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteRecords;
import com.sinosoft.user.User;
@Repository("returnCheckAcceptNoteRecordsDao")
public class ReturnCheckAcceptNoteRecordsDaoImpl extends
		GenericDaoHibernate<ReturnCheckAcceptNoteRecords, Long> implements ReturnCheckAcceptNoteRecordsDao {
	public ReturnCheckAcceptNoteRecordsDaoImpl(){
		super(ReturnCheckAcceptNoteRecords.class);
	}
	@Override
	public void addReturnCheckAcceptNoteRecords(Long returnCheAccNoteRecordsId,
			String projectName, String changeContent, User modityUser,
			String changeReason) {
		ReturnCheckAcceptNoteRecords records = new ReturnCheckAcceptNoteRecords();
		records.setReturnCheckAcceptNoteId(returnCheAccNoteRecordsId);
		records.setChangeContent(changeContent);
		records.setProjectName(projectName);
		records.setModityUser(modityUser);
		records.setModityDate(new Date());
		records.setChangeReason(changeReason);
		save(records);

	}

	

}
