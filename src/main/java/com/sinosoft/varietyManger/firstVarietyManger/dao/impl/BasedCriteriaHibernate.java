package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.BasedCriteriaDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.BasedCriteria;
@Repository("basedCriteriaDao")
public class BasedCriteriaHibernate extends GenericDaoHibernate<BasedCriteria, Long>
		implements BasedCriteriaDao {
	public BasedCriteriaHibernate(){
		super(BasedCriteria.class);
	}

}
