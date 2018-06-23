package com.sinosoft.drugState.purchaseNote.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseNoteItemDao;

@Repository("PurchaseNoteItemDao")
public class PurchaseNoteItemDaoImpl extends GenericDaoHibernate<PurchaseOrderItem,Long> implements PurchaseNoteItemDao{
	
	
	
	
	public PurchaseNoteItemDaoImpl() {
		super(PurchaseOrderItem.class);
	}

	@Override
	public void saveReceivingNoteItem(PurchaseOrderItem receivingNoteItem) {
		this.getHibernateTemplate().save(receivingNoteItem);
	}
	
	public PurchaseOrderItem findById(String id){
		/*String hql = "from PurchaseOrderItem t where t.id="+Long.parseLong(id);
		Session session =getHibernateTemplate().getSessionFactory().openSession();
		Query query= session.createQuery(hql);
		PurchaseOrderItem reIt=(PurchaseOrderItem) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		PurchaseOrderItem reIt = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			reIt = (PurchaseOrderItem)session.get(PurchaseOrderItem.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return reIt;
	}
	
	@Override
	public void delOne(String id) {
		PurchaseOrderItem reIt=findById(id);
		getHibernateTemplate().delete(reIt);
	}

	@Override
	public List<PurchasePlanStore> findypJsonqy(int year, int season) {
		/*String hql = "select t from PurchasePlanStore t where t.year ='"+year+"' and t.season='"+season+"'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<PurchasePlanStore> list= query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t from PurchasePlanStore t where t.year =:year and t.season=:season";
		Session session = null;
		List<PurchasePlanStore> list = null;
		
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("year", String.valueOf(year));
			query.setParameter("season", String.valueOf(season));
			 list= query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<PurchasePlanStore> findMedicByYearAndDept(String year,
			String departmentId) {
		Session session = null;
		List<PurchasePlanStore> list = null;
		DetachedCriteria  detachedCriteria = DetachedCriteria.forClass(PurchasePlanStore.class);
		if(year!=null && !"".equals(year)){
			detachedCriteria.add(Restrictions.eq("year", year));
		}
		if(departmentId!=null && !"".equals(departmentId)){
			detachedCriteria.add(Restrictions.eq("departmentId", departmentId));
		}
		try{
			session =  getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);
			list = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<PurchaseOrderItem> findByBatch(String batch) {
		String hql = "select t from PurchaseOrderItem t where batchProduction =:batch";
		Session session = null;
		List<PurchaseOrderItem> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("batch", batch);
			list= query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public void saveOrUpdateItem(PurchaseOrderItem receivingNoteItem) {
		this.getHibernateTemplate().saveOrUpdate(receivingNoteItem);
		
	}

}
