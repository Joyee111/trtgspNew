package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 14:37:18 PM
 * 类说明
 * 
 */
public interface OurQualityManagementService extends GenericManager<OurQualityManagement, Long> {

	public int countRecord(long qualUtilId);
	public void saveList(List<OurQualityManagement> ourQualityManagementSta);
	public List<OurQualityManagement> findListByPage(String hql ,int first ,int pagesize);
	public int countRecordByCondition(String sql);
	public OurQualityManagement findById(long id);
	public List<OurQualityManagement> findList(String hql);
}
