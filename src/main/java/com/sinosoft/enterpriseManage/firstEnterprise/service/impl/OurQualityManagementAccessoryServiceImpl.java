package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.OurQualityManagementAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagementAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.OurQualityManagementAccessoryService;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:35:39 PM
 * 类说明
 * service实现类
 */
@Service
public class OurQualityManagementAccessoryServiceImpl extends
		GenericManagerImpl<OurQualityManagementAccessory, Long> implements OurQualityManagementAccessoryService {
	private OurQualityManagementAccessoryDao ourQualityManagementAccessoryDao;
	
	@Autowired
	public OurQualityManagementAccessoryServiceImpl(OurQualityManagementAccessoryDao ourQualityManagementAccessoryDao){
		super(ourQualityManagementAccessoryDao);
		this.ourQualityManagementAccessoryDao =ourQualityManagementAccessoryDao;
	}
	
	@Override
	public int countRecord(long companyQualityManagementId) {
		String sql = "select count(*) from t_company_quality_management_archives where company_quality_management_id="+companyQualityManagementId;
		return getRecordCount(sql);
	}

	@Override
	public List<OurQualityManagementAccessory> findAccessoriesListByPage(
			long companyQualityManagementId, int first, int pagesize) {
		return ourQualityManagementAccessoryDao.findAccessoriesListByPage(companyQualityManagementId, first, pagesize);
	}

	@Override
	public void saveList(
			List<OurQualityManagementAccessory> ourQualityManagementAccessoryList) {
		Iterator<OurQualityManagementAccessory>  its = ourQualityManagementAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}

	

	

}
