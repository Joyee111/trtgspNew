package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.CommissionedStorageUnitQualificationAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualificationAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.CommissionedStorageUnitQualificationAccessoryService;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:35:39 PM
 * 类说明
 * service实现类
 */
@Service
public class CommissionedStorageUnitQualificationAccessoryServiceImpl extends
		GenericManagerImpl<CommissionedStorageUnitQualificationAccessory, Long> implements CommissionedStorageUnitQualificationAccessoryService {
	private CommissionedStorageUnitQualificationAccessoryDao csuqAccessoryDao;
	
	@Autowired
	public CommissionedStorageUnitQualificationAccessoryServiceImpl(CommissionedStorageUnitQualificationAccessoryDao csuqAccessoryDao){
		super(csuqAccessoryDao);
		this.csuqAccessoryDao =csuqAccessoryDao;
	}
	
	@Override
	public int countRecord(long csuqId) {
		String sql = "select count(*) from t_commissioned_storage_unit_qualification_accessory a where a.csuqId="+csuqId;
		return getRecordCount(sql);
	}

	@Override
	public List<CommissionedStorageUnitQualificationAccessory> findAccessoriesListByPage(
			long csuqId, int first, int pagesize) {
		return csuqAccessoryDao.findAccessoriesListByPage(csuqId, first, pagesize);
	}

	@Override
	public void saveList(
			List<CommissionedStorageUnitQualificationAccessory> csuqAccessoryList) {
		Iterator<CommissionedStorageUnitQualificationAccessory>  its = csuqAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}

	

	

}
