package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityFilesDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityFilesService;
@Service
public class QualityFilesServiceImpl extends GenericManagerImpl<QualityFiles, Long>
	implements QualityFilesService{
	
	private QualityFilesDao qualityFilesDao;
	
	@Autowired
	public QualityFilesServiceImpl(QualityFilesDao qualityFilesDao) {
		super(qualityFilesDao);
		this.qualityFilesDao = qualityFilesDao;
	}

	@Override
	public int countQualityFiles(String medicNo, String commonName) {
		
		return qualityFilesDao.countQualityFiles(medicNo, commonName);
	}

	

	@Override
	public void deleteQualified(Long id) {
		qualityFilesDao.deleteQualified(id);
		
	}

	@Override
	public List<QualityMidicine> findQualityMedic() {
		
		return qualityFilesDao.findQualityMedic();
	}

	@Override
	public QualityFiles getQualified(Long id) {
		
		return qualityFilesDao.getQualified(id);
	}

	@Override
	public List<QualityFiles> getQualityFiles(String medicNo,
			String commonNane, int first, int pagesize) {
		
		return qualityFilesDao.getQualityFiles(medicNo, commonNane, first, pagesize);
	}

	@Override
	public void saveQaulified(QualityFiles qualityFiles) {
		qualityFilesDao.saveQaulified(qualityFiles);
		
	}

}
