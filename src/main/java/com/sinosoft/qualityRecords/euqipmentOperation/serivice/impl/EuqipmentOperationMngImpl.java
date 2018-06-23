package com.sinosoft.qualityRecords.euqipmentOperation.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.euqipmentOperation.dao.EuqipmentOperationDao;
import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;
import com.sinosoft.qualityRecords.euqipmentOperation.serivice.EuqipmentOperationMng;
@Service
public class EuqipmentOperationMngImpl implements EuqipmentOperationMng {
	 @Autowired
	private EuqipmentOperationDao euqipmentOperationDao;

	public void setEuqipmentOperationDao(EuqipmentOperationDao euqipmentOperationDao) {
		this.euqipmentOperationDao = euqipmentOperationDao;
	}
	@Override
	public List<EuqipmentOperation> getPage(EuqipmentOperation eo, int pageSize, int resultSize) {
		StringBuffer hql=new StringBuffer(" from EuqipmentOperation t where 1=1 " );
		return euqipmentOperationDao.getPage(eo, pageSize,resultSize,hql.toString());
	}
	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from EuqipmentOperation t where 1=1");
		return euqipmentOperationDao.getTotalCount(hql.toString());
	}
	@Override
	public EuqipmentOperation findById(String id) {
		return euqipmentOperationDao.findById(id);
	}
	@Override
	public void saveOrUpdata(EuqipmentOperation eo) {
		euqipmentOperationDao.saveOrUpdata(eo);
	}
	@Override
	public void saveEuqipmentOperation(EuqipmentOperation eo) {
		euqipmentOperationDao.saveEuqipmentOperation(eo);
	}
	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			euqipmentOperationDao.del(ids[i]);
		}
		
	}
	@Override
	public List<EuqipmentOperation> getEuqipmentOperationByPage(String hql, Map map,
			int first, int pagesize) {
		return euqipmentOperationDao.getEuqipmentOperationByPage(hql, map, first, pagesize);
	}
	@Override
	public int getQueryCount(String hql) {

		return euqipmentOperationDao.getQueryCount(hql);
	}
}
