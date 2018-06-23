package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * @author cbl:
 * @version 创建时间：Dec, 2014 3:13:33 PM
 * 类说明
 */
public interface OurQualityManagementDao extends GenericDao<OurQualityManagement, Long> {
	
	public List<OurQualityManagement> findListByPage(String hql ,int first ,int pagesize);
	public List<OurQualityManagement> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize);
	
	public int countRecordByCondition(String sql);
	public OurQualityManagement findById(long id);
	public List<OurQualityManagement> findList(String hql);
	
}
