package com.sinosoft.comQuery.ReturnCheckRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.ReturnCheckRecords.dao.ReturnCheckRecordsDao;
import com.sinosoft.comQuery.ReturnCheckRecords.model.ReturnCheckRecords;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
@Repository("ReturnCheckRecordsDao")
public class ReturnCheckRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long>implements ReturnCheckRecordsDao {
	public ReturnCheckRecordsDaoImpl() {
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
			session.close();
		}
		return a;
	}

	@Override
	public List<?> getReturnCheckRecordsByPage(String hql, Map map, int first,
			int pagesize) {
		Session session =null;
		List<?> returnCheckRecordsList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
				
			}
			returnCheckRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return returnCheckRecordsList;
	}

	@Override
	public QualifiedPurchaseUnits findById(String id) {
		//String hql = "select t from QualifiedPurchaseUnits t where id ="+Long.parseLong(id);
		Session session = null;
		QualifiedPurchaseUnits re = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			re = (QualifiedPurchaseUnits)session.get(QualifiedPurchaseUnits.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return re;
//		Query query = session.createQuery(hql);
//		if(query.list().size()>0){
//			QualifiedPurchaseUnits re=	(QualifiedPurchaseUnits) query.list().get(0);
//			try {
//				session.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return re;
//		}else{
//			return null;
//		}
	}

	@Override
	public List<?> getAllReturnCheckRecord(String hql, Map<String, Object> map) {
		List<ReturnCheckRecords> list = null;
		Session session = null;
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
			if(session != null)
				session.close();
		}
		return list;
	}
}
