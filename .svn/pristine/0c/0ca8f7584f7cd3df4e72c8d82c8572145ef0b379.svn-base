package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.FirstEnterpriseDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
@Repository("firstEnterpriseDao")
public class FirstEnterpriseHibernate extends GenericDaoHibernate<FirstEnterprise, Long> implements FirstEnterpriseDao {
	public FirstEnterpriseHibernate(){
		super(FirstEnterprise.class);
	}
	/**
	 * 根据HQL获取首营企业列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FirstEnterprise> getFirstEnterpriseListByHql(String hql) {
		
		return getHibernateTemplate().find(hql);
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.enterpriseManage.firstEnterprise.dao.FirstEnterpriseDao#getFirstEnterpriseByPage(java.lang.String, java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<FirstEnterprise> enterpriseList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
				
			}
			enterpriseList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return enterpriseList;
	}
}
