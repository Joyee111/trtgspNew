package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualifiedmedcstoreReDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.QualifiedmedcstoreReMng;
@Service
public class QualifiedmedcstoreReMngImpl implements QualifiedmedcstoreReMng{
	@Autowired
	private QualifiedmedcstoreReDao qualifiedmedcstoreReDao;
	
	public void setQualifiedmedcstoreReDao(QualifiedmedcstoreReDao qualifiedmedcstoreReDao){
		this.qualifiedmedcstoreReDao = qualifiedmedcstoreReDao;
	}
	
	@Override
	public QualifiedmedcstoreRe updatequ(QualifiedmedcstoreRe qu) {
		
		return qualifiedmedcstoreReDao.updatequ(qu);
	}
	
	@Override
	public QualifiedmedcstoreRe findReById(String id) {
		return qualifiedmedcstoreReDao.findReById(id);
	}

	@Override
	public QualifiedmedcstoreRe save(QualifiedmedcstoreRe qu) {
		
		return qualifiedmedcstoreReDao.save(qu);
	}

	

	

	
		
	
	
}
