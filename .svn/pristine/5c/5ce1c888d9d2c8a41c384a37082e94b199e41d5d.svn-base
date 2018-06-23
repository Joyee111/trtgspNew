package com.sinosoft.comQuery.infoFeedbackRecords.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.infoFeedbackRecords.dao.InfoFeedbackRecordsDao;
import com.sinosoft.comQuery.infoFeedbackRecords.service.InfoFeedbackRecordsMng;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
@Service
public class InfoFeedbackRecordsMngImpl implements InfoFeedbackRecordsMng {
	@Autowired
	private InfoFeedbackRecordsDao infoFeedbackRecordsDao;

	public void setInfoFeedbackRecordsDao(
			InfoFeedbackRecordsDao infoFeedbackRecordsDao) {
		this.infoFeedbackRecordsDao = infoFeedbackRecordsDao;
	}



	@Override
	public int getTotalCount(String userId) {
		int i=0;
			StringBuffer hql=new StringBuffer(" select count(*) from InfoFeedback t where 1=1 " );
			i=infoFeedbackRecordsDao.getTotalCount(hql.toString());
		return i;
	
	}



	@Override
	public List<InfoFeedback> getPage(InfoFeedback df,String  userId, int pageSize,
			int resultSize) {
		List<InfoFeedback> list = new ArrayList<InfoFeedback>();
		if(userId!=null &&!"".equals(userId)){
			StringBuffer hql=new StringBuffer(" from InfoFeedback t where 1=1 " );
			list = infoFeedbackRecordsDao.getPage(df,userId, pageSize,resultSize,hql.toString());	
		}
		return list;
	}



	@Override
	public List<InfoFeedback> getInfoFeedbackByPage(String hql, Map map,
			int first, int pagesize) {
		return infoFeedbackRecordsDao.getInfoFeedbackByPage(hql, map, first, pagesize);
	}



	@Override
	public InfoFeedback findById(String id) {
		return infoFeedbackRecordsDao.findById(id);
	}

}
