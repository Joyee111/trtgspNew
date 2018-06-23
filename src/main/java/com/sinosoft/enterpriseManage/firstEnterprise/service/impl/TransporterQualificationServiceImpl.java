package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.TransporterQualificationDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.enterpriseManage.firstEnterprise.service.TransporterQualificationService;
/**
 * 
* @ClassName: TransporterQualificationServiceImpl 
* @author lfl
* @date 2013-7-3 下午03:04:18 
* @Description: TODO(承运上资质管理)
 */
@Service
public class TransporterQualificationServiceImpl extends
		GenericManagerImpl<TransporterQualification, Long> implements TransporterQualificationService {
	private TransporterQualificationDao transporterQualificationDao;
	@Autowired
	public TransporterQualificationServiceImpl(TransporterQualificationDao transporterQualificationDao){
		super(transporterQualificationDao);
		this.transporterQualificationDao =transporterQualificationDao;
	}

	@Override
	public List<TransporterQualification> findTransporterQualificationList(
			int first, int pagesize) {
		return transporterQualificationDao.findTransporterQualificationList(first, pagesize);
	}

	@Override
	public List<TransporterQualification> queryTransporterQualificationList(
			String queryCysmc, String queryHtmc, int first, int pagesize) {
		// TODO Auto-generated method stub
		return transporterQualificationDao.queryTransporterQualificationList(queryCysmc, queryHtmc, first, pagesize);
	}

}
