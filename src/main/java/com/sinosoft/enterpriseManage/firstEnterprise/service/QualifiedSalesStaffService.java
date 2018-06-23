package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;

public interface QualifiedSalesStaffService extends GenericManager<SalesStaff, Long> {
	public List<SalesStaff> findListByPage(String hql ,int first ,int pagesize);
	public List<SalesStaff> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
	
	public int countRecordByCondition(String sql);
	public List<SalesStaff> findList(String hql);
	public SalesStaff findByPurchaseUtilsId(Long id);
}
