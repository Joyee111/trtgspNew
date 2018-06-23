package com.sinosoft.varietyManger.firstVarietyManger.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityTrackRecord;

public interface QualityTrackRecordDao extends GenericDao<QualityTrackRecord, Long> {
	/**
	 * 根据质量档案ID查询质量档案记录
	 * @param qualityFielesId
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<QualityTrackRecord> getTrackRecordList(Long qualityFielesId,int first,int pagesize);
	public int countTrackRecordList(Long qualityFilesId);
	/**
	 * 根据药品货号、通用名称查询质量档案
	 * @param medicNo
	 * @param commonNane
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<QualityFiles> getQualityFiles(String medicNo,String commonNane,int first,int pagesize);
	public int countQualityFiles(String medicNo,String commonName);
	public void saveQaulified(QualityFiles qualityFiles);
	public void deleteQualified(Long id);
	public QualityFiles getQualified(Long id);
	public List<QualityMidicine> findQualityMedic();
}
