package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedSuppliersDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyAccessory;
@Repository("qualifiedSuppliersDao")
public class QualifiedSuppliersHibernate extends GenericDaoHibernate<QualifiedSuppliers, Long>
		implements QualifiedSuppliersDao {

	public QualifiedSuppliersHibernate(){
		super(QualifiedSuppliers.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QualifiedSuppliers> getQualifiedSuppliersByPage(String hql,
			Map map, int first, int pagesize) {
		Session session =null;
		List<QualifiedSuppliers> qualiSupplyList = null;
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
			qualiSupplyList = query.list();
		
		for(QualifiedSuppliers supplier : qualiSupplyList){
			if(!Hibernate.isInitialized(supplier.getAccessories()))
				Hibernate.initialize(supplier.getAccessories());
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return qualiSupplyList;
	}
	@Override
	public QualifiedSuppliers findById(String ids) {
		
	//	String hql = "select t from QualifiedSuppliers t where id ="+Long.parseLong(ids);
		Session session = null;
		QualifiedSuppliers qualifiedSuppliers = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			qualifiedSuppliers = (QualifiedSuppliers)session.get(QualifiedSuppliers.class, Long.parseLong(ids));
			//if(Hibernate.isInitialized(qualifiedSuppliers))
				Hibernate.initialize(qualifiedSuppliers.getAccessories());
				Hibernate.initialize(qualifiedSuppliers.getDrugFroms());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			  session.close();
		}
		return qualifiedSuppliers;
	}
	@Override
	public List<QualifiedSuppliers> findList(String hql) {
		List<QualifiedSuppliers> list =null;
	
		Session  session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list(); 
			if(list!=null && list.size()>0){
				for(QualifiedSuppliers suppliers: list){
					Hibernate.initialize(suppliers.getAccessories());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
		return list;
	}
	@Override
	public QualifiedSuppliers findByFirstEnterpriseId(Long id) {
		QualifiedSuppliers qsSuppliers = null;
		List<QualifiedSuppliers> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(QualifiedSuppliers.class);
			//criteria.setLockMode(LockMode.READ);
			criteria.add(Restrictions.eq("firstEnterpriseId", id));
			list = criteria.list();
			if(list !=null && list.size()>0)
				qsSuppliers = list.get(0);
				Hibernate.initialize(qsSuppliers.getAccessories());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return qsSuppliers;
	}
	@Override
	public List<QualifiedSuppliers> getAllQualifieddSupplisersByCondiction(
			String hql, Map<String, Object> map) {
		Session session = null;
		List<QualifiedSuppliers> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				query.setParameter(key, map.get(key));
			}
			list = query.list();
			if(list!=null){
				for(QualifiedSuppliers spSuppliers : list){
					Hibernate.initialize(spSuppliers.getAccessories());
				}
			}
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	@Override
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryByRequestName(
			String requestName) {
		List<QulifiedSupplyAccessory> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery("select q from QulifiedSupplyAccessory where request_name = :requestName");
			query.setParameter("requestName", requestName);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return (list != null )? list.get(0):null;
	}
	@Override
	public QulifiedSupplyAccessory findQulifiedSupplyAccessoryById(String id) {
		QulifiedSupplyAccessory accessory = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			accessory = (QulifiedSupplyAccessory)session.get(QulifiedSupplyAccessory.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return accessory;
	}
	@Override
	public void saveQulifiedSupplyAccessory(
			QulifiedSupplyAccessory accessory) {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			session.update(accessory);
			tx.commit();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
	}

}
