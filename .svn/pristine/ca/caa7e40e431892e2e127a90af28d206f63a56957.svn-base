package com.sinosoft.qualityRecords.qualityAccident.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.qualityAccident.dao.QualityAccidentDao;
import com.sinosoft.qualityRecords.qualityAccident.model.QualityAccident;
import com.sinosoft.qualityRecords.qualityAccident.service.QualityAccidentMng;
@Service
public class QualityAccidentMngImpl implements QualityAccidentMng {
	@Autowired
	private QualityAccidentDao QualityAccidentDao;
	public void setQualityAccidentDao(QualityAccidentDao qualityAccidentDao) {
		QualityAccidentDao = qualityAccidentDao;
	}
	@Override
	public List<QualityAccident> getPage(QualityAccident qa, int pageSize,
			int resultSize) {
		StringBuffer hql=new StringBuffer(" from QualityAccident t where 1=1 " );
		return QualityAccidentDao.getPage(qa, pageSize,resultSize,hql.toString());
	}
	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from QualityAccident t where 1=1");
		return QualityAccidentDao.getTotalCount(hql.toString());
	}

	@Override
	public QualityAccident findById(String id) {
		return QualityAccidentDao.findById(id);
	}
	@Override
	public void saveOrUpdata(QualityAccident qa) {
		QualityAccidentDao.saveOrUpdata(qa);
	}


	@Override
	public void saveQualityAccident(QualityAccident qa) {
		QualityAccidentDao.saveQualityAccident(qa);
	}


	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			QualityAccidentDao.del(ids[i]);
		}
	}
	
		@Override
		public List<QualityAccident> getQualityAccidentByPage(String hql, Map map,
				int first, int pagesize) {

			return QualityAccidentDao.getQualityAccidentByPage(hql, map, first, pagesize);
		}
		@Override
		public int getQueryCount(String hql) {
			
			return QualityAccidentDao.getQueryCount(hql);
		}
}
