package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification;

/**
 * @author cbl:
 * @version 创建时间：Dec, 2014 3:13:33 PM
 * 类说明
 */
public interface CommissionedStorageUnitQualificationDao extends GenericDao<CommissionedStorageUnitQualification, Long> {
	
	public List<CommissionedStorageUnitQualification> findListByPage(String hql ,int first ,int pagesize);
	public List<CommissionedStorageUnitQualification> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize);
	
	public int countRecordByCondition(String sql);
	public List<CommissionedStorageUnitQualification> findList(String hql);
	
}
