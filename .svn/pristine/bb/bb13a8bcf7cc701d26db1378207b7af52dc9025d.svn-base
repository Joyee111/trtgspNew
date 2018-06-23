package com.sinosoft.systemConfig;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;

/**
 * @author lfl:
 * @version 创建时间：Jun 13, 2013 4:14:22 PM
 * 类说明
 */
@Repository("warnConfigDao")
public class WarnConfigHibernate extends GenericDaoHibernate<WarnConfig, Long> implements
		WarnConfigDao {
	public  WarnConfigHibernate(){
		super(WarnConfig.class);
	}

	@Override
	public List<WarnConfig> findList(String hql) {
		List<WarnConfig> list = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public WarnConfig getWarnConfigByName(String configName) {
		Session session = null;
		String hql = "select a from WarnConfig a  where  a.limit_name =:configName";
		List<WarnConfig> configList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query  = session.createQuery(hql);
			query.setParameter("configName", configName);
			configList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return (configList!=null && configList.size()>0)?configList.get(0):null;
	}
	
}
