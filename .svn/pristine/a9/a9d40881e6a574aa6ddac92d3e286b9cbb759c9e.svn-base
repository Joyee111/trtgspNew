package com.sinosoft.comQuery.receivingRecords.dao.impl;

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
import com.sinosoft.comQuery.receivingRecords.dao.ReceivingRecordsDao;
import com.sinosoft.comQuery.receivingRecords.model.ReceivingRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;


@Repository("ReceivingRecordsDao")
public class ReceivingRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long> implements ReceivingRecordsDao {
	public ReceivingRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}
	@Override
	public List<?> getReceivingRecordsByPage(String hql, Map map, int first,
			int pageseiz) {
		Session session =null;
		List<ReceivingRecords> receivingRecordsList = null;
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
			receivingRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return receivingRecordsList;
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
