package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityMidicineRecordsDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicineRecords;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineRecordsService;

/**
 * @author lfl:
 * @version 创建时间：Jun 8, 2013 11:13:15 AM
 * 类说明
 */
@Service
public class QualityMidicineRecordsServiceImpl extends
		GenericManagerImpl<QualityMidicineRecords, Long> implements QualityMidicineRecordsService {
	private QualityMidicineRecordsDao qualityMidicineRecordsDao;
	@Autowired
	public QualityMidicineRecordsServiceImpl(QualityMidicineRecordsDao qualityMidicineRecordsDao){
		super(qualityMidicineRecordsDao);
		this.qualityMidicineRecordsDao = qualityMidicineRecordsDao;
	}
	@Override
	public List<QualityMidicineRecords> getListByPage(String hql,
			Map map, int first, int pagesize) {
		
		return qualityMidicineRecordsDao.getListByPage(hql, map, first, pagesize);
	}
	@Override
	public void saveAll(List<QualityMidicineRecords> qualityMidicineRecords) {
		Iterator<QualityMidicineRecords> its = qualityMidicineRecords.iterator();
		while(its.hasNext()){
			qualityMidicineRecordsDao.save(its.next());
		}
		
	}


}
