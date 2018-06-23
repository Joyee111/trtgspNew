package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityMidicineDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualityMidicineMng;
@Service
public class QualityMidicineMngImpl extends GenericManagerImpl<QualityMidicine, Long> implements QualityMidicineMng {
	
		private QualityMidicineDao qualityMidicineDao;
	@Autowired
	public QualityMidicineMngImpl(QualityMidicineDao qualityMidicineDao ){
		super(qualityMidicineDao);
		this.qualityMidicineDao = qualityMidicineDao;
	}
	public void setQualityMidicineDao(QualityMidicineDao qualityMidicineDao) {
		this.qualityMidicineDao = qualityMidicineDao;
	}

	@Override
	public QualityMidicine findById(String id) {
		return qualityMidicineDao.findById(id);
	}

	@Override
	public void updata(QualityMidicine qm) {
		qualityMidicineDao.updata(qm);
	}
	@Override
	public List<QualityMidicine> getListByPage(String hql, Map map, int first,
			int pagesize) {
		return qualityMidicineDao.getListByPage(hql, map, first, pagesize);
	}
	@Override
	public List<QualityMidicine> getAll(String hql) {
		return qualityMidicineDao.getAll(hql);
	}
	@Override
	public List<QualityMidicine> findList(String hql, int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getListByPage(hql, new HashMap<String, Object>(), first, pagesize);
	}
	@Override
	public List<PurchaseOrderMidicineVO> getPurchaseOrderMidicineVo(String hql,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getPurchaseOrderMidicineVo(hql, first, pagesize);
	}
	@Override
	public List<ChectAcceptMidicineVO> getChectAcceptMidicineVO(String hql,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getChectAcceptMidicineVO(hql, first, pagesize);
	}
	@Override
	public List<ReceiveMidicineVO> getReceiveMidicineVO(String hql, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getReceiveMidicineVO(hql, first, pagesize);
	}
	@Override
	public List<MaintenanceMidicineVO> getMaintenanceMidicineVO(String hql,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getMaintenanceMidicineVO(hql, first, pagesize);
	}
	@Override
	public QualityMidicine findByFirstVarietyId(Long id) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.findByFirstVarietyId(id);
	}
	@Override
	public List<QualifiedmedcstoreVO> getQualifiedmedcstoreVO(String hql,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getQualifiedmedcstoreVO(hql, first, pagesize);
	}
	@Override
	public List<MidicineOutCheckVO> getMidicineOutCheckVO(String hql,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getMidicineOutCheckVO(hql, first, pagesize);
	}
	@Override
	public List<TrtssSalesFormMidicineVO> getTrtssSalesFormMidicineVO(
			String hql, int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualityMidicineDao.getTrtssSalesFormMidicineVO(hql, first, pagesize);
	}
	
}
