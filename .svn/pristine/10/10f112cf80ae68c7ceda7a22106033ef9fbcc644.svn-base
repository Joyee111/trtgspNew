package com.sinosoft.comQuery.drugProcureRecords.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.drugProcureRecords.dao.DrugProcureRecordsDao;
import com.sinosoft.comQuery.drugProcureRecords.serivice.DrugProcureRecordsMng;
@Service
public class DrugProcureRecordsMngImpl implements DrugProcureRecordsMng {
	@Autowired
	private DrugProcureRecordsDao drugProcureRecordsDao;

	public void setDrugProcureRecordsDao(DrugProcureRecordsDao drugProcureRecordsDao) {
		this.drugProcureRecordsDao = drugProcureRecordsDao;
	}

	@Override
	public List<?> getDrugProcureRecordsByPage(String hql,
			Map map, int first, int pageseiz) {
		return drugProcureRecordsDao.getDrugProcureRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {
		return drugProcureRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<?> getAllDrugProcureRecords(String sql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return drugProcureRecordsDao.getAllDrugProcureRecords(sql, map);
	}
}
