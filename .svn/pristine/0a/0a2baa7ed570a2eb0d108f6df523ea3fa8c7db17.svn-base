package com.sinosoft.comQuery.drugSaleRecords.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.drugSaleRecords.dao.DrugSaleRecordsDao;
import com.sinosoft.comQuery.drugSaleRecords.model.DrugSaleRecords;
import com.sinosoft.comQuery.drugSaleRecords.service.DrugSaleRecordsMng;
@Service
public class DrugSaleRecordsMngImpl implements DrugSaleRecordsMng {
	@Autowired
	private DrugSaleRecordsDao drugSaleRecordsDao;

	public void setDrugSaleRecordsDao(DrugSaleRecordsDao drugSaleRecordsDao) {
		this.drugSaleRecordsDao = drugSaleRecordsDao;
	}

	@Override
	public List<?> getDrugSaleRecordsByPage(String hql, Map map, int first,
			int pageseiz) {

		return drugSaleRecordsDao.getDrugSaleRecordsByPage(hql, map, first, pageseiz);
	}

	@Override
	public int getQueryCount(String hql) {

		return drugSaleRecordsDao.getQueryCount(hql);
	}

	@Override
	public List<DrugSaleRecords> getDrugSaleRecords(String hql, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return drugSaleRecordsDao.getDrugSaleRecords(hql, 0, 10);
	}

	@Override
	public List<?> getAllDrugSaleRecordsByCondiction(String hql,
			Map<String, Object> paraMap) {
		return drugSaleRecordsDao.getAllDrugSaleRecordsByCondiction(hql, paraMap);
	}
}
