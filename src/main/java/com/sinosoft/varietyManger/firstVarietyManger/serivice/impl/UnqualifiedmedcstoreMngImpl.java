package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.varietyManger.firstVarietyManger.dao.UnqualifiedmedcstoreDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.UnqualifiedmedcstoreMng;
@Service
public class UnqualifiedmedcstoreMngImpl  implements   UnqualifiedmedcstoreMng{
	@Autowired
	private UnqualifiedmedcstoreDao unqualifiedmedcstoreDao;

	@Override
	public void saveOrUpdataHg(Unqualifiedmedcstore unqualifiedmedcstore) {
		unqualifiedmedcstoreDao.saveOrUpdataHg(unqualifiedmedcstore);
		
	}
	@Override
	public void saveUnqualifiedmedcstore(Unqualifiedmedcstore unqualifiedmedcstore) {
		unqualifiedmedcstoreDao.saveUnqualifiedmedcstore(unqualifiedmedcstore);
		
	}
	@Override
	public Unqualifiedmedcstore findById(String pihao) {
		
		return unqualifiedmedcstoreDao.findById(pihao);
	}
	@Override
	public List<QualityMidicine> findUnqualifiedMedcStore() {
		// TODO Auto-generated method stub
		return unqualifiedmedcstoreDao.findUnqualifiedMedcStore();
	}
	@Override
	public List<Unqualifiedmedcstore> findUnqualifiedMedcStoreByMedcId(Long quQuMedcId) {
		// TODO Auto-generated method stub
		return unqualifiedmedcstoreDao.findUnqualifiedMedcStoreByMedcId(quQuMedcId);
	}
	
	@Override
	public List<QualityMidicine> findQualifiedMedcStore() {
		// TODO Auto-generated method stub
		return unqualifiedmedcstoreDao.findQualifiedMedcStore();
	}
	
	

	}

