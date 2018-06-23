package com.sinosoft.qualityRecords.qualityQuery.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sinosoft.qualityRecords.qualityQuery.dao.QualityQueryDao;
import com.sinosoft.qualityRecords.qualityQuery.model.QulityQuery;
import com.sinosoft.qualityRecords.qualityQuery.serivice.QualityQueryMng;
@Service
public class QualityQueryMngImpl implements QualityQueryMng {
	 @Autowired
	private QualityQueryDao qualityQueryDao;
	public void setQualityQueryDao(QualityQueryDao qualityQueryDao) {
		this.qualityQueryDao = qualityQueryDao;
	}

	@Override
	public List<QulityQuery> getPage(QulityQuery qq, int pageSize,
			int resultSize) {
		StringBuffer hql=new StringBuffer("from QulityQuery t where 1=1 order by qualitydate desc ");
		return qualityQueryDao.getPage(qq, pageSize,resultSize,hql.toString());
	}


	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from QulityQuery t where 1=1");
		return qualityQueryDao.getTotalCount(hql.toString());
	}

	@Override
	public QulityQuery findById(String id) {
		return qualityQueryDao.findById(id);
	}


	@Override
	public void saveOrUpdata(QulityQuery qq) {
		qualityQueryDao.saveOrUpdata(qq);
	}


	@Override
	public void saveQulityQuery(QulityQuery qq) {
		qualityQueryDao.saveQulityQuery(qq);
	}


	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			qualityQueryDao.del(ids[i]);
		}
		
	}

	@Override
	public int getQueryCount(String hql) {
		return qualityQueryDao.getQueryCount(hql);
	}

	@Override
	public List<QulityQuery> getQulityQueryByPage(String hql, Map map,
			int first, int pagesize) {
		return qualityQueryDao.getQulityQueryByPage(hql, map, first, pagesize);
	}
}
