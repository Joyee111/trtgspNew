package com.sinosoft.qualityRecords.transportRecords.serivice.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.qualityRecords.transportRecords.dao.TransportRecordsDao;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecords;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecordsResource;
import com.sinosoft.qualityRecords.transportRecords.serivice.TransportRecordsMng;
import com.sinosoft.user.User;
@Service
public class TransportRecordsMngImpl implements TransportRecordsMng {
	 @Autowired
		private TransportRecordsDao transportRecordsDao;

	public void setTransportRecordsDao(TransportRecordsDao transportRecordsDao) {
		this.transportRecordsDao = transportRecordsDao;
	}
	@Override
	public List<TransportRecords> getPage(TransportRecords tr, int pageSize, int resultSize) {
		StringBuffer hql=new StringBuffer(" from TransportRecords t where 1=1 and t.plateno is not null order by t.deliverydate DESC " );
		return transportRecordsDao.getPage(tr, pageSize,resultSize,hql.toString());
	}
	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from TransportRecords t where 1=1 and t.plateno is not null");
		return transportRecordsDao.getTotalCount(hql.toString());
	}
	@Override
	public TransportRecords findById(String id) {
		return transportRecordsDao.findById(id);
	}
	@Override
	public void saveOrUpdata(TransportRecords tr) {
		transportRecordsDao.saveOrUpdata(tr);
	}
	@Override
	public void saveTransportRecords(TransportRecords tr) {
		transportRecordsDao.saveTransportRecords(tr);
	}
	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			transportRecordsDao.del(ids[i]);
		}
		
	}
	@Override
	public List<TransportRecords> getTransportRecordsByPage(String hql, Map map,
			int first, int pagesize) {
		return transportRecordsDao.getTransportRecordsByPage(hql, map, first, pagesize);
	}
	@Override
	public int getQueryCount(String hql) {

		return transportRecordsDao.getQueryCount(hql);
	}
	@Override
	public Map<String, String> qsMap() {
		return transportRecordsDao.qsMap();
	}
	@Override
	public TransportRecordsResource findByOrderno(String no) {

		return transportRecordsDao.findByOrderno(no);
	}
	@Override
	public User findByUserId(String id) {
		return transportRecordsDao.findByUserId(id);
	}
	@Override
	public TransporterQualification findByCarrierunit(String id) {
		return transportRecordsDao.findByCarrierunit(id);
	}
	@Override
	public List<TransportRecordsResource> findtrJsonty() {
		return transportRecordsDao.findtrJsonty();
	}
	@Override
	public TransportRecordsResource findByIds(String id) {
		return transportRecordsDao.findByIds(id);
	}
	@Override
	public List<TransportRecords> getAllTransportRecords(String hql,
			Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return transportRecordsDao.getAllTransportRecords(hql, paramMap);
	}
}
