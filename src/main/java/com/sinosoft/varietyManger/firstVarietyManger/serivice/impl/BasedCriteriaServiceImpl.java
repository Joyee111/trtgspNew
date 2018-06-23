package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.BasedCriteriaDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.BasedCriteria;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.BasedCriteriaService;
@Service
public class BasedCriteriaServiceImpl extends GenericManagerImpl<BasedCriteria, Long>
		implements BasedCriteriaService {
	private BasedCriteriaDao basedCriteriaDao;
	@Autowired
	public BasedCriteriaServiceImpl(BasedCriteriaDao basedCriteriaDao){
		super(basedCriteriaDao);
		this.basedCriteriaDao =basedCriteriaDao;
	}
}
