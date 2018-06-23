package com.sinosoft.comQuery.inspeAcceptRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.inspeAcceptRecords.dao.InspeAcceptRecordsDao;
import com.sinosoft.comQuery.inspeAcceptRecords.model.InspeAcceptRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;


@Repository("InspeAcceptRecordsDao")
public class InspeAcceptRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long> implements InspeAcceptRecordsDao {
	public InspeAcceptRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}
	@Override
	public List<?> getInspeAcceptRecordsByPage(String hql, Map map, int first,
			int pageseiz) {
		Session session =null;
		List<InspeAcceptRecords> inspeAcceptRecordsList = null;
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
			inspeAcceptRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return inspeAcceptRecordsList;
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

}
