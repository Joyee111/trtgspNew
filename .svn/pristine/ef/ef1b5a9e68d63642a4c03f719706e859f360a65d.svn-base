package com.sinosoft.comQuery.returnReceivingRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.returnReceivingRecords.dao.ReturnReceivingRecordsDao;
import com.sinosoft.comQuery.returnReceivingRecords.model.ReturnReceivingRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
@Repository("ReturnReceivingRecordsDao")
public class ReturnReceivingRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long>implements ReturnReceivingRecordsDao {
	public ReturnReceivingRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}

	@Override
	public int getQueryCount(String hql) {
		Session session = null;
		int a=0;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
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
	public List<?> getReturnReceivingRecordsByPage(String hql, Map map,
			int first, int pageseiz) {
		Session session =null;
		List<ReturnReceivingRecords> returnReceivingRecordsList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pageseiz);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
				
			}
			returnReceivingRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return returnReceivingRecordsList;
	}

	@Override
	public List<?> getAllReturnReceivingRecords(String hql, Map<String, Object> map) {
		List<ReturnReceivingRecords>  list = null;
		Session  session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(hql);
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				query.setParameter(key, map.get(key));
			}
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null )
				session.close();
		}
		return list;
	}
}
