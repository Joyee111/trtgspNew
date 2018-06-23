package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.UnqualifiedmedcstoreDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
@Repository("UnqualifiedmedcstoreDao")
public class UnqualifiedmedcstoreDaoImpl extends GenericDaoHibernate<Unqualifiedmedcstore, Long>implements UnqualifiedmedcstoreDao {
	public UnqualifiedmedcstoreDaoImpl() {
		super(Unqualifiedmedcstore.class);
	}
	@Override
	public void saveOrUpdataHg(Unqualifiedmedcstore unqualifiedmedcstore) {
		this.getHibernateTemplate().saveOrUpdate(unqualifiedmedcstore);
		
	}
	@Override
	public void saveUnqualifiedmedcstore(Unqualifiedmedcstore unqualifiedmedcstore) {
		this.getHibernateTemplate().save(unqualifiedmedcstore);
		
	}
	@Override
	public Unqualifiedmedcstore findById(String pihao) {

		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Unqualifiedmedcstore unqualifiedmedcstore=null;
		try{
			String hql = "from Unqualifiedmedcstore t where t.batchproduction ='"+pihao+"'";
			Query query = session.createQuery(hql);	
			List<?> list = query.list();
			if(query.list().size()>0){
				unqualifiedmedcstore=(Unqualifiedmedcstore) query.list().get(0);	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return unqualifiedmedcstore;
	
	}
	@Override
	public List<QualityMidicine> findUnqualifiedMedcStore() {
		List<QualityMidicine> unQuMedcStore = null;
		Session session = null;
		
		StringBuffer hqlBuffer = new StringBuffer("select distinct q from Unqualifiedmedcstore u,QualityMidicine q where 1=1 ") ;
		hqlBuffer.append(" and u.qualifiedmedicineid = q.id and u.status = '1' and u.quantity > 0 ");
		
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			unQuMedcStore = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close();
			}
		}
		return unQuMedcStore;
	}
	@Override
	public List<Unqualifiedmedcstore> findUnqualifiedMedcStoreByMedcId(Long unQuMedcId) {
		List<Unqualifiedmedcstore> unQuStoreList = null;
		Session session = null;
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Unqualifiedmedcstore.class);
		detachedCriteria.add(Restrictions.eq("qualifiedmedicineid", unQuMedcId));
		detachedCriteria.add(Restrictions.gt("quantity", Long.valueOf(0)));
		detachedCriteria.add(Restrictions.eq("status", "1"));
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			unQuStoreList = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close();
			}
		}
		return unQuStoreList;
	}
	
	@Override
	public List<QualityMidicine> findQualifiedMedcStore() {
		List<QualityMidicine> quMedcStore = null;
		Session session = null;
		
		StringBuffer hqlBuffer = new StringBuffer("select distinct q from QualityMidicine q where 1=1 ") ;
		
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			quMedcStore = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null ){
				session.close();
			}
		}
		return quMedcStore;
	}
}
