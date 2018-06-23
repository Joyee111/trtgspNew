package com.sinosoft.comQuery.drugComInfoRecords.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.drugComInfoRecords.dao.DrugComInfoRecordsDao;
import com.sinosoft.comQuery.drugComInfoRecords.service.DrugComInfoRecordsMng;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
@Service
public class DrugComInfoRecordsMngImpl implements DrugComInfoRecordsMng {
	 @Autowired
	 private DrugComInfoRecordsDao  drugComInfoRecordsDao;

	public void setDrugComInfoRecordsDao(DrugComInfoRecordsDao drugComInfoRecordsDao) {
		this.drugComInfoRecordsDao = drugComInfoRecordsDao;
	}
	

	@Override
	public List<DrugComInfo> getPage(DrugComInfo dr,String  userId, int pageSize,
			int resultSize) {
		List<DrugComInfo> list = new ArrayList<DrugComInfo>();
		if(userId!=null &&!"".equals(userId)){
			StringBuffer hql=new StringBuffer(" from DrugComInfo t where 1=1 " );
			list = drugComInfoRecordsDao.getPage(dr,userId, pageSize,resultSize,hql.toString());	
		}
		
		
		
	
		return list;
	}

	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from DrugComInfo t where 1=1");
		return drugComInfoRecordsDao.getTotalCount(hql.toString());
	}

	@Override
	public DrugComInfo findById(String id) {

		return drugComInfoRecordsDao.findById(id);
	}


	@Override
	public List<DrugComInfo> getDrugComInfoByPage(String hql, Map map,
			int first, int pagesize) {
		return drugComInfoRecordsDao.getDrugComInfoByPage(hql, map, first, pagesize);
	}







}
