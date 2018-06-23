package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;

public interface FirstEnterpriseDao extends GenericDao<FirstEnterprise, Long> {
	/**
	 * 根据HQL列表查询首营企业列表
	 * @param hql
	 * @return
	 */
	public List<FirstEnterprise> getFirstEnterpriseListByHql(String hql);
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql,Map map ,int first, int pageseiz);
}
