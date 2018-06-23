package com.sinosoft.comQuery.sampleTicketRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.sampleTicketRecords.dao.SampleTicketRecordsDao;
import com.sinosoft.comQuery.sampleTicketRecords.model.SampleTicketRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;

@Repository("SampleTicketRecordsDao")
public class SampleTicketRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long>implements SampleTicketRecordsDao {
	public SampleTicketRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}

	@Override
	public List<?> getSampleTicketRecordsByPage(String hql, Map map, int first,
			int pageseiz) {
		Session session =null;
		List<SampleTicketRecords> sampleTicketRecordsList = null;
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
			sampleTicketRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return sampleTicketRecordsList;
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
	public List<SampleTicketRecords> getSampleTicketRecords(String hql, int first,
			int pagesize) {
		List<SampleTicketRecords> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<?> getAllSampleTicketRecordsByCondiction(String hql,
			Map<String, Object> paraMap) {
		List<?> recordList = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(hql);
			Iterator<String> it = paraMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				query.setParameter(key, paraMap.get(key));
			}
			recordList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return recordList;
	}
}
