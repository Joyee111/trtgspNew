package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.CommissionedStorageUnitQualificationDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification;
import com.sinosoft.enterpriseManage.firstEnterprise.service.CommissionedStorageUnitQualificationService;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:35:39 PM
 * 类说明
 * 实现类
 */
@Service
public class CommissionedStorageUnitQualificationServiceImpl extends
		GenericManagerImpl<CommissionedStorageUnitQualification, Long> implements CommissionedStorageUnitQualificationService {
	
	private CommissionedStorageUnitQualificationDao csuqDao;
	
	@Autowired
	public CommissionedStorageUnitQualificationServiceImpl(CommissionedStorageUnitQualificationDao csuqDao){
		super(csuqDao);
		this.csuqDao = csuqDao;
	}
	/**
	 * 从传入的ID中取出该ID的操作记录条数
	 */
	@Override
	public int countRecord(long Id) {
		String sql = "select count(*) from t_commissioned_storage_unit_qualification where id="+Id;
		return getRecordCount(sql);
	}

	
	@Override
	public void saveList(
			List<CommissionedStorageUnitQualification> csuqList) {
		Iterator<CommissionedStorageUnitQualification>  its = csuqList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}
	
	@Override
	public List<CommissionedStorageUnitQualification> findListByPage(String hql, int first,
			int pagesize) {
		return csuqDao.findListByPage(hql, first, pagesize);
	}
	
	@Override
	public int countRecordByCondition(String sql) {
		return csuqDao.countRecordByCondition(sql);
	}
	
	@Override
	public List<CommissionedStorageUnitQualification> findList(String hql) {
		return csuqDao.findList(hql);
	}
	@Override
	public List<CommissionedStorageUnitQualification> findListByaPage(
			String hql, Map<String, Object> paramMap, int first, int pagesize) {
		return csuqDao.findListByaPage(hql, paramMap, first, pagesize);
	}
	
	
	

}
