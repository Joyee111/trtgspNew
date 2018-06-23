package com.sinosoft.qualityRecords.drugMaintenanceJH.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.drugMaintenanceJH.dao.DrugMaintenanceJHDao;
import com.sinosoft.qualityRecords.drugMaintenanceJH.model.DrugMaintenanceJH;

@Repository("DrugMaintenanceJHDao")
public class DrugMaintenanceJHDaoImpl extends GenericDaoHibernate<DrugMaintenanceJH, Long>  implements DrugMaintenanceJHDao {
	public DrugMaintenanceJHDaoImpl() {
		super(DrugMaintenanceJH.class);
	}

	@Override
	public void del(String ids) {
		DrugMaintenanceJH dm=findById(ids);
		getHibernateTemplate().delete(dm);
	}

	@Override
	public DrugMaintenanceJH findById(String id) {
		Session session = null;
		DrugMaintenanceJH drugMaintenanceJH= null;
		try{
			 session = this.getHibernateTemplate().getSessionFactory().openSession();
			 drugMaintenanceJH =  (DrugMaintenanceJH)session.get(DrugMaintenanceJH.class, Long.parseLong(id));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
	
		return drugMaintenanceJH;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugMaintenanceJH> getDrugMaintenanceJHByPage(String hql,
			Map map, int first, int pagesize) {
		Session session =null;
		List<DrugMaintenanceJH> drugMaintenanceJHList = null;
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
			drugMaintenanceJHList = query.list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return drugMaintenanceJHList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugMaintenanceJH> getPage(DrugMaintenanceJH dm, int pageSize,
			int resultSize, String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<DrugMaintenanceJH> res =null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return res;
	}

	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createSQLQuery(hql);
			  a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return a;
	}

	@Override
	public int getTotalCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createQuery(hql);
			  a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}

		return a;
	}

	@Override
	public void saveDrugMaintenanceJH(DrugMaintenanceJH dm) {
		this.getHibernateTemplate().save(dm);
		
	}

	@Override
	public void saveOrUpdata(DrugMaintenanceJH dm) {
		this.getHibernateTemplate().saveOrUpdate(dm);
		
	}

	@Override
	public Session getSession() {
		Session session = null;
		boolean result = true;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
		}catch(Exception e){
			result = false;
			e.printStackTrace();
		}
		if(result == true){
			return session;
		}
		return null;
	}
	
}
