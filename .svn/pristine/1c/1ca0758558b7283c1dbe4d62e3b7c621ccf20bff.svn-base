package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityMidicineDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;
@Repository("QualityMidicineDao")
public class QualityMidicineDaoImpl extends GenericDaoHibernate<QualityMidicine, Long> implements QualityMidicineDao  {

	public QualityMidicineDaoImpl() {
		super(QualityMidicine.class);
	}

	@Override
	public QualityMidicine findById(String ids) {
		
		String hql = "select t from QualityMidicine t where id ="+ids;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		QualityMidicine qu=new QualityMidicine();
		if(query.list()!=null){
			qu =(QualityMidicine) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
		
	}

	@Override
	public void updata(QualityMidicine qm) {
		this.getHibernateTemplate().saveOrUpdate(qm);
	}

	@Override
	public List<QualityMidicine> getAll(String hql) {
		List<QualityMidicine> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseOrderMidicineVO> getPurchaseOrderMidicineVo(String hql,int first, int pagesize) {
		 Session session = null;
		 List<PurchaseOrderMidicineVO> list = null;
		 try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}

	@Override
	public List<ChectAcceptMidicineVO> getChectAcceptMidicineVO(String hql,
			int first, int pagesize) {
		 Session session = null;
		 List<ChectAcceptMidicineVO> list = null;
		 try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			 Query query = session.createQuery(hql);
			 query.setFirstResult(first);
			 query.setMaxResults(pagesize);
			 list = query.list();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}

	@Override
	public List<ReceiveMidicineVO> getReceiveMidicineVO(String hql, int first,
			int pagesize) {
		Session session = null;
		List<ReceiveMidicineVO> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<MaintenanceMidicineVO> getMaintenanceMidicineVO(String hql,
			int first, int pagesize) {
		Session session = null;
		List<MaintenanceMidicineVO> list =null;
		try{
			session =  getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public QualityMidicine findByFirstVarietyId(Long id) {
		QualityMidicine qualityMidicine = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(QualityMidicine.class);
			criteria.add(Restrictions.eq("firstmedicineid", id));
			if(criteria.list()!=null && criteria.list().size()>0){
				qualityMidicine = (QualityMidicine)criteria.list().get(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return qualityMidicine;
	}

	@Override
	public List<QualifiedmedcstoreVO> getQualifiedmedcstoreVO(String hql,
			int first, int pagesize) {
		Session session = null;
		List<QualifiedmedcstoreVO> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<MidicineOutCheckVO> getMidicineOutCheckVO(String hql,
			int first, int pagesize) {
		Session session = null;
		 List<MidicineOutCheckVO> list = null;
		 try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}

	@Override
	public List<TrtssSalesFormMidicineVO> getTrtssSalesFormMidicineVO(
			String hql, int first, int pagesize) {
		 Session session = null;
		 List<TrtssSalesFormMidicineVO> list = null;
		 try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}
	

}
