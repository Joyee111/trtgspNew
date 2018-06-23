package com.sinosoft.comQuery.outCheckRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.outCheckRecords.dao.OutCheckRecordsDao;
import com.sinosoft.comQuery.outCheckRecords.model.OutCheckRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
@Repository("OutCheckRecordsDao")
public class OutCheckRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long>implements OutCheckRecordsDao {
	public OutCheckRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}

	@Override
	public List<?> getOutCheckRecordsByPage(String hql, Map map, int first,
			int pagesize) {
		Session session =null;
		List<OutCheckRecords> outCheckRecordsList = null;
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
			outCheckRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return outCheckRecordsList;
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
