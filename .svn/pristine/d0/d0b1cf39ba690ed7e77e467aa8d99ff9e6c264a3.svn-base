package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.OurQualityManagementDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement;
import com.sinosoft.enterpriseManage.firstEnterprise.service.OurQualityManagementService;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:35:39 PM
 * 类说明
 * 实现类
 */
@Service
public class OurQualityManagementServiceImpl extends
		GenericManagerImpl<OurQualityManagement, Long> implements OurQualityManagementService {
	
	private OurQualityManagementDao ourQualityManagementDao;
	
	@Autowired
	public OurQualityManagementServiceImpl(OurQualityManagementDao ourQualityManagementDao){
		super(ourQualityManagementDao);
		this.ourQualityManagementDao = ourQualityManagementDao;
	}
	/**
	 * 从传入的ID中取出该ID的操作记录条数
	 */
	@Override
	public int countRecord(long Id) {
		String sql = "select count(*) from t_company_quality_management where id="+Id;
		return getRecordCount(sql);
	}

	
	@Override
	public void saveList(
			List<OurQualityManagement> quaPurcUnitsAccessoryList) {
		Iterator<OurQualityManagement>  its = quaPurcUnitsAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}
	
	
	@Override
	public List<OurQualityManagement> findListByPage(String hql, int first,
			int pagesize) {
		return ourQualityManagementDao.findListByPage(hql, first, pagesize);
	}
	
	@Override
	public int countRecordByCondition(String sql) {
		return ourQualityManagementDao.countRecordByCondition(sql);
	}
	@Override
	public OurQualityManagement findById(long id) {
		return ourQualityManagementDao.findById(id);
	}
	@Override
	public List<OurQualityManagement> findList(String hql) {
		return ourQualityManagementDao.findList(hql);
	}
	
	
	

}
