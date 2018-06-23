package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSupplyDrugFromsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSupplyDrugFromsService;

@Service
public class QualSupplyDrugFromsServiceImpl extends GenericManagerImpl<QulifiedSupplyDrugFroms, Long>
		implements QualSupplyDrugFromsService {
	private QualSupplyDrugFromsDao qualSupplyDrugFromsDao;
	@Autowired
	public QualSupplyDrugFromsServiceImpl(QualSupplyDrugFromsDao qualSupplyDrugFromsDao){
		super(qualSupplyDrugFromsDao);
		this.qualSupplyDrugFromsDao = qualSupplyDrugFromsDao;
	}
	@Override
	public List<QulifiedSupplyDrugFroms> getListByQualSuppId(Long id) {
		
		return qualSupplyDrugFromsDao.getListByQualSuppId(id);
	}
	@Override
	public void saveList(List<QulifiedSupplyDrugFroms> drugFromsList) {
		qualSupplyDrugFromsDao.saveList(drugFromsList);
	}

}
