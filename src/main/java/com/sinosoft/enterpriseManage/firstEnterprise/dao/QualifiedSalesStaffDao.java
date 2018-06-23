package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;
import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;

public interface QualifiedSalesStaffDao extends GenericDao<SalesStaff, Long> {
	public List<SalesStaff> findListByPage(String hql ,int first ,int pagesize);
	public List<SalesStaff> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
	public int countRecordByCondition(String sql);
	public List<SalesStaff> findList(String hql);
	public SalesStaff findBySalesStaffId(Long id);
}
