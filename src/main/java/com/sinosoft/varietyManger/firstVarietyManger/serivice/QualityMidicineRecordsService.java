package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicineRecords;

/**
 * @author lfl:
 * @version 创建时间：Jun 8, 2013 11:10:32 AM
 * 类说明
 */
public interface QualityMidicineRecordsService extends GenericManager<QualityMidicineRecords, Long> {
	public List<QualityMidicineRecords> getListByPage(String hql ,Map map,int first,int pagesize);
	
	public void saveAll(List<QualityMidicineRecords> qualityMidicineRecords);
}
