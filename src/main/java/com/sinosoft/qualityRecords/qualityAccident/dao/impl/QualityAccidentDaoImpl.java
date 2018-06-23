package com.sinosoft.qualityRecords.qualityAccident.dao.impl;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.qualityAccident.dao.QualityAccidentDao;
import com.sinosoft.qualityRecords.qualityAccident.model.QualityAccident;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@Repository("QualityAccidentDao")
public class QualityAccidentDaoImpl extends GenericDaoHibernate<QualityAccident, Long> implements QualityAccidentDao {
	public QualityAccidentDaoImpl() {
		super(QualityAccident.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityAccident> getPage(QualityAccident qa, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<QualityAccident> res=null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();
			for (int i = 0; i < res.size(); i++) {
				Long Qualifiedmedicineid = res.get(i).getQualifiedmedicineid();
				
				String sql = "select t from QualityMidicine t where id ="+Qualifiedmedicineid;
				Query queryMedicine = session.createQuery(sql);
				res.get(i).setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));
			}	
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
	public QualityAccident findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		QualityAccident qualityAccident=new QualityAccident();
		try{
			String hql = "select t from QualityAccident t where id ="+Long.parseLong(ids);	
			Query query = session.createQuery(hql);	
			qualityAccident=(QualityAccident) query.list().get(0);
			Long Qualifiedmedicineid =qualityAccident.getQualifiedmedicineid();
			
			String sql = "select t from QualityMidicine t where id ="+Qualifiedmedicineid;
			Query queryMedicine = session.createQuery(sql);
			qualityAccident.setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return qualityAccident;
	}
	@Override
	public void saveOrUpdata(QualityAccident qa) {
		this.getHibernateTemplate().saveOrUpdate(qa);
	}

	@Override
	public void saveQualityAccident(QualityAccident qa) {
		this.getHibernateTemplate().save(qa);
	}
	@Override
	public void del(String ids) {
		QualityAccident qa=findById(ids);
		getHibernateTemplate().delete(qa);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityAccident> getQualityAccidentByPage(String hql, Map map,
			int first, int pagesize) {

		Session session =null;
		List<QualityAccident> qualityAccidentList = null;
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
			qualityAccidentList = query.list();
			for (int i = 0; i < qualityAccidentList.size(); i++) {
				Long Qualifiedmedicineid = qualityAccidentList.get(i).getQualifiedmedicineid();
				
				String sql = "select t from QualityMidicine t where id ="+Qualifiedmedicineid;
				Query queryMedicine = session.createQuery(sql);
				qualityAccidentList.get(i).setQualityMidicine((QualityMidicine)queryMedicine.list().get(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return qualityAccidentList;
	
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
}
