package com.sinosoft.comQuery.unqualifiedManagerRecords.dao;

import java.util.List;

import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;

public interface UnqualifiedManagerRecordsDao {

	/**
	 * 剂型List
	 * @return
	 */
	public List<DrugFormDictionary> findList(String hql);
	
	List<UnqualifiedManager> getPage(UnqualifiedManager um,String isfood, int i, int pagesize);

	int getTotalCount(UnqualifiedManager um,String isfood);
}
