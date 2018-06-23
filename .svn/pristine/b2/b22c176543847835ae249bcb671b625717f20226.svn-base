package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.OurQualityManagementDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagement;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 11:13:57 AM
 * 类说明
 * OurQualityManagement类的Dao包
 */
@Repository("ourQualityManagementDao")
public class OurQualityManagementHibernate extends GenericDaoHibernate<OurQualityManagement, Long>
		implements OurQualityManagementDao {

	
	public OurQualityManagementHibernate(){
		super(OurQualityManagement.class);
	}

	@Override
	public int countRecordByCondition(String sql) {
		// TODO Auto-generated method stub
		return getRecordCount(sql);
	}

	

	@Override
	public List<OurQualityManagement> findListByPage(String hql, int first,
			int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByaPage(hql,map,first,pagesize);
	}

	@Override
	public List<OurQualityManagement> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<OurQualityManagement> ourQualityManagementList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = paramMap.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), paramMap.get(key));
				
			}
			ourQualityManagementList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ourQualityManagementList;
	}

	/*
	 * 改正get方法无法取出数据的错误
	 * @see com.sinosoft.enterpriseManage.firstEnterprise.dao.OurQualityManagementDao#findById(int)
	 */
	@Override
	public OurQualityManagement findById(long id) {
		String hql = " from OurQualityManagement a where a.id="+id;
		List<OurQualityManagement> list = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
			if(list.size()<1){
				return null;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list.get(0);
	}

	
	
	
	@Override
	public List<OurQualityManagement> findList(String hql) {
		List<OurQualityManagement> list = null;
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
	
	
	
	
}