package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public interface QualityFilesService extends GenericManager<QualityFiles, Long>{
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
