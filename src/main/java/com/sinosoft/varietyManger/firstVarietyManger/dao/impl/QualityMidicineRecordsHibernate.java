package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;


import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityMidicineRecordsDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicineRecords;

/**
 * @author lfl:
 * @version 创建时间：Jun 8, 2013 11:09:08 AM
 * 类说明
 */
@Repository("qualityMidicineRecordsDao")
public class QualityMidicineRecordsHibernate extends GenericDaoHibernate<QualityMidicineRecords, Long>
		implements QualityMidicineRecordsDao {
	public QualityMidicineRecordsHibernate(){
		super(QualityMidicineRecords.class);
	}
	
}
