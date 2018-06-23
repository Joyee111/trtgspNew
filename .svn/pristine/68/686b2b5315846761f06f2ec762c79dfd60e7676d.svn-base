package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.TransporterQualificationRecordsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualificationRecords;
import com.sinosoft.enterpriseManage.firstEnterprise.service.TransporterQualificationRecordsService;
@Service
public class TransporterQualificationRecordsServiceImpl extends
		GenericManagerImpl<TransporterQualificationRecords, Long> implements
		TransporterQualificationRecordsService {
	private TransporterQualificationRecordsDao transporterQualificationRecordsDao;
	@Autowired
	public TransporterQualificationRecordsServiceImpl(TransporterQualificationRecordsDao transporterQualificationRecordsDao){
		super(transporterQualificationRecordsDao);
		this.transporterQualificationRecordsDao = transporterQualificationRecordsDao;
	}
	@Override
	public List<TransporterQualificationRecords> getTransporterQualificationRecords(
			Long id, int first, int pagesize) {
		
		return transporterQualificationRecordsDao.getTransporterQualificationRecords(id, first, pagesize);
	}

}
