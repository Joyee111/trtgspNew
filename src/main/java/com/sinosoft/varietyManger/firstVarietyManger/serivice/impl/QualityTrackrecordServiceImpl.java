package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityTrackRecordDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityTrackRecord;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityTrackrecordService;
@Service
public class QualityTrackrecordServiceImpl extends GenericManagerImpl<QualityTrackRecord, Long>
		implements QualityTrackrecordService {
	private QualityTrackRecordDao qualityTrackRecordDao;
	@Autowired
	public QualityTrackrecordServiceImpl(QualityTrackRecordDao qualityTrackRecordDao){
		super(qualityTrackRecordDao);
		this.qualityTrackRecordDao = qualityTrackRecordDao;
	}
	@Override
	public int countTrackRecordList(Long qualityFilesId) {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.countTrackRecordList(qualityFilesId);
	}
	@Override
	public List<QualityFiles> getQualityFiles(String medicNo,
			String commonNane, int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.getQualityFiles(medicNo, commonNane, first, pagesize);
	}
	@Override
	public List<QualityTrackRecord> getTrackRecordList(Long qualityFielesId,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.getTrackRecordList(qualityFielesId, first, pagesize);
	}
	@Override
	public int countQualityFiles(String medicNo, String commonName) {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.countQualityFiles(medicNo, commonName);
	}
	@Override
	public void deleteQualified(Long id) {
		// TODO Auto-generated method stub
		qualityTrackRecordDao.deleteQualified(id);
	}
	@Override
	public QualityFiles getQualified(Long id) {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.getQualified(id);
	}
	@Override
	public void saveQaulified(QualityFiles qualityFiles) {
		// TODO Auto-generated method stub
		 qualityTrackRecordDao.saveQaulified(qualityFiles);
	}
	@Override
	public List<QualityMidicine> findQualityMedic() {
		// TODO Auto-generated method stub
		return qualityTrackRecordDao.findQualityMedic();
	}
	

}
;