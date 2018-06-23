package com.sinosoft.comQuery.inspeAcceptRecordsJH.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.inspeAcceptRecordsJH.dao.InspeAcceptRecordsJHDao;
import com.sinosoft.comQuery.inspeAcceptRecordsJH.model.InspeAcceptRecordsJH;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;

@Repository("InspeAcceptRecordsJHDao")
public class InspeAcceptRecordsJHDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long> implements InspeAcceptRecordsJHDao{
	public InspeAcceptRecordsJHDaoImpl() {
		super(DrugMaintenance.class);
	}
	@Override
	public List<?> getInspeAcceptRecordsByPage(String hql, Map map, int first,
			int pageseiz) {
		Session session =null;
		List<InspeAcceptRecordsJH> inspeAcceptRecordsJHList = null;
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
			inspeAcceptRecordsJHList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return inspeAcceptRecordsJHList;
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
