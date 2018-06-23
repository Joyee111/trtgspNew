package com.sinosoft.comQuery.unqualifiedManagerRecords.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.comQuery.unqualifiedManagerRecords.dao.UnqualifiedManagerRecordsDao;
import com.sinosoft.comQuery.unqualifiedManagerRecords.service.UnqualifiedManagerRecordsMng;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;

@Service
public class UnqualifiedManagerRecordsMngImpl implements UnqualifiedManagerRecordsMng {
	@Autowired
	private UnqualifiedManagerRecordsDao unqualifiedManagerRecordsDao;

	public void setUnqualifiedManagerRecordsDao(
			UnqualifiedManagerRecordsDao unqualifiedManagerRecordsDao) {
		this.unqualifiedManagerRecordsDao = unqualifiedManagerRecordsDao;
	}



	@Override
	public List<DrugFormDictionary> findList(String hql) {

		return unqualifiedManagerRecordsDao.findList(hql);
	}



	@Override
	public List<UnqualifiedManager> getPage(UnqualifiedManager um,String isfood, int i,
			int pagesize) {

		return unqualifiedManagerRecordsDao.getPage(um,isfood, i, pagesize);
	}



	@Override
	public int getTotalCount(UnqualifiedManager um,String isfood) {

		return unqualifiedManagerRecordsDao.getTotalCount(um,isfood);
	}

}
