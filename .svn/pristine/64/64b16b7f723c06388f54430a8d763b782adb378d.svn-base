package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.varietyManger.firstVarietyManger.dao.QualifiedmedcstoreDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreMng;
@Service
public class QualifiedmedcstoreMngImpl implements QualifiedmedcstoreMng{
	@Autowired
	private QualifiedmedcstoreDao qualifiedmedcstoreDao;
	
	@Override
	public Qualifiedmedcstore savequ(Qualifiedmedcstore qu){
//		if(qu!=null){
//			if(qu.getBatchproduction()!=null&& qu.getQualifiedmedicineid()!=null){
//				Qualifiedmedcstore qus = qualifiedmedcstoreDao.findqu(qu.getBatchproduction(),qu.getQualifiedmedicineid());
//				
//			
//			
//			}
			return qualifiedmedcstoreDao.savequ(qu);
	}

	@Override
	public Qualifiedmedcstore updatequ(Qualifiedmedcstore qu) {
		return qualifiedmedcstoreDao.updatequ(qu);
	}

	@Override
	public Qualifiedmedcstore findByBaNo(String no) {
		return qualifiedmedcstoreDao.findByBaNo(no);
	}

	@Override
	public List<Qualifiedmedcstore> findQualifiedMedcStore(String hql,
			int first, int pagesize) {
		return qualifiedmedcstoreDao.findQualifiedMedcStore(hql, first, pagesize);
	}

	@Override
	public List<Qualifiedmedcstore> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return qualifiedmedcstoreDao.getAllByState(hql, map);
	}

	@Override
	public List<Qualifiedmedcstore> getQualifiedMedicValidWarning(String date,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return qualifiedmedcstoreDao.getQualifiedMedicValidWarning(date, first, pagesize);
	}

	@Override
	public int countQualifiedMedicValidWarning(String date) {
		// TODO Auto-generated method stub
		return qualifiedmedcstoreDao.countQualifiedMedicValidWarning(date);
	}

	@Override
	public Qualifiedmedcstore findStoreByBaId(String batch, Long id) {
		
		return qualifiedmedcstoreDao.findqu(batch, id);
	}

}
