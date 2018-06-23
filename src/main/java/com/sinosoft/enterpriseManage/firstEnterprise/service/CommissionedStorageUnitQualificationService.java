package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:37:18 PM
 * 类说明
 * 
 */
public interface CommissionedStorageUnitQualificationService extends GenericManager<CommissionedStorageUnitQualification, Long> {

	public int countRecord(long csuqId);
	public void saveList(List<CommissionedStorageUnitQualification> csuqList);
	public List<CommissionedStorageUnitQualification> findListByPage(String hql ,int first ,int pagesize);
	public int countRecordByCondition(String sql);
	public List<CommissionedStorageUnitQualification> findList(String hql);
	public List<CommissionedStorageUnitQualification> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
}
