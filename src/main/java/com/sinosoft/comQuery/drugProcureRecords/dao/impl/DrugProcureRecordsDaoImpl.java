package com.sinosoft.comQuery.drugProcureRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.drugProcureRecords.dao.DrugProcureRecordsDao;
import com.sinosoft.comQuery.drugProcureRecords.model.DrugProcureRecords;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
@Repository("DrugProcureRecordsDao")
public class DrugProcureRecordsDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long> implements DrugProcureRecordsDao {
	public DrugProcureRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}

	@Override
	public List<?> getDrugProcureRecordsByPage(String hql,
			Map map, int first, int pageseiz) {
		Session session =null;
		List<DrugProcureRecords> drugProcureRecordsList = null;
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
			drugProcureRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return drugProcureRecordsList;
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
	public List<DrugProcureRecords> getAllDrugProcureRecords(String sql, Map<String, Object> map){
		Session session = null;
		List<DrugProcureRecords> list =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				query.setParameter(key, map.get(key));
				
			}
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session !=null)
				session.close();
		}
		return list;
	}
}
