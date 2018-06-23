package com.sinosoft.drugState.scrap.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.scrap.dao.ScrapDao;
import com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo;
import com.sinosoft.drugState.scrap.model.ScrapMedicine;
import com.sinosoft.drugState.scrap.service.ScrapMng;
import com.sinosoft.qualityRecords.unqualifiedManger.dao.UnqualifiedManagerDao;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Service
public class ScrapMngImpl implements ScrapMng {
	@Autowired
	private ScrapDao scrapDao;
	@Autowired
	private UnqualifiedManagerDao unqualifiedManagerDao;
	

	@Override
	public List<UnqualifiedManager> findUnqualifiedManagerList() {
		
		return unqualifiedManagerDao.findunypJsonty();
	}


	@Override
	public List<ScrapAndQualityMedicineVo> getPage(String commonName, String status,
			int first, int pageSize) {
		
		return scrapDao.getPage(commonName, status, first, pageSize);
	}


	@Override
	public int countScrapMedicineByStatus(String commonName, String status) {
		return scrapDao.countScrapMedicineByStatus(commonName, status);
	}


	@Override
	public void saveOrUpdate(ScrapMedicine sm) {
		scrapDao.saveOrUpdateSM(sm);
		
	}


	@Override
	public void save(ScrapMedicine sm) {
		scrapDao.saveSM(sm);
		
	}


	@Override
	public ScrapMedicine findById(String id) {
		
		return scrapDao.findById(id);
	}


	@Override
	public List<QualityMidicine> findqmJsonty() {
		// TODO Auto-generated method stub
		return unqualifiedManagerDao.findqmJsonty();
	}

	
}
