package com.sinosoft.qualityRecords.qualityQuery.dao.impl;




import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.qualityQuery.dao.QualityQueryDao;
import com.sinosoft.qualityRecords.qualityQuery.model.QulityQuery;

@Repository("QualityQueryDao")
public class QualityQueryDaoImpl extends GenericDaoHibernate<QulityQuery, Long>   implements QualityQueryDao{
	public QualityQueryDaoImpl() {
		super(QulityQuery.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QulityQuery> getPage(QulityQuery qq, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<QulityQuery> res = null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();
//			for (int i = 0; i < res.size(); i++) {
//				Long qualifiedmedicineid = res.get(i).getQualifiedmedicineid();
//				
//				String sql = "select t from QualityMidicine t where id ="+qualifiedmedicineid;
//				Query queryMedicine = session.createQuery(sql);
//				res.get(i).setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return res;
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
			session.close();
		}	
		return a;
	}

	@Override
	public QulityQuery findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		QulityQuery qulityQuery=new QulityQuery();
		try{
			String hql = "select t from QulityQuery t where id ="+Long.parseLong(ids);
			Query query = session.createQuery(hql);	
			qulityQuery=(QulityQuery) query.list().get(0);
//			Long Qualifiedmedicineid =qulityQuery.getQualifiedmedicineid();
//			
//			String sql = "select t from QualityMidicine t where id ="+Qualifiedmedicineid;
//			Query queryMedicine = session.createQuery(sql);
//			qulityQuery.setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		
		return qulityQuery;
	}

	@Override
	public void saveOrUpdata(QulityQuery qq) {
		this.getHibernateTemplate().saveOrUpdate(qq);
	}

	@Override
	public void saveQulityQuery(QulityQuery qq) {
		this.getHibernateTemplate().save(qq);
	}

	@Override
	public void del(String ids) {
		QulityQuery qq=findById(ids);
		getHibernateTemplate().delete(qq);
	}
	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createQuery(hql);
		   a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}	
		
		return a;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QulityQuery> getQulityQueryByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<QulityQuery> qulityQueryList = null;
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
			qulityQueryList = query.list();
//			for (int i = 0; i < qulityQueryList.size(); i++) {
//				Long Qualifiedmedicineid = qulityQueryList.get(i).getQualifiedmedicineid();
//				
//				String sql = "select t from QualityMidicine t where id ="+Qualifiedmedicineid;
//				Query queryMedicine = session.createQuery(sql);
//				qulityQueryList.get(i).setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return qulityQueryList;
	
	
	}
	
}
