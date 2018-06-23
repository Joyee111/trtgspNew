package com.sinosoft.comQuery.comQuery.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.CustomerInfo;



@Repository("ComQueryDao")
public class ComQueryDaoImpl extends GenericDaoHibernate<FirstEnterprise, Long>  implements  ComQueryDao {
	public ComQueryDaoImpl() {
		super(FirstEnterprise.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FirstEnterprise> getPage(FirstEnterprise fe, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<FirstEnterprise> res=null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();
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
	public QualifiedSuppliers findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		QualifiedSuppliers qualifiedSuppliers=new QualifiedSuppliers();
		try{
			String hql = "select t from QualifiedSuppliers t where firstEnterpriseId ="+Long.parseLong(ids);
			
			Query query = session.createQuery(hql);
			qualifiedSuppliers=(QualifiedSuppliers) query.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		
		return qualifiedSuppliers;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<FirstEnterprise> firstEnterpriseList = null;
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
			firstEnterpriseList = query.list();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			session.close();
		}
		return firstEnterpriseList;
	}
	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;try{
			Query query = session.createQuery(hql);
			  a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}

		return a;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseUnit> getPurchaseUnitByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<PurchaseUnit> purchaseUnitList = null;
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
			purchaseUnitList = query.list();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			session.close();
		}
		return purchaseUnitList;
	}
	@Override
	public int getPurchaseUnitCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createQuery(hql);
			 a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
	
		return a;
	}
	@Override
	public List<CustomerInfo> getCustomerInfoList(String hql,
			Map<String, String> map) {
		List<CustomerInfo> customerInfoList = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			if(map!=null&& map.size()>0){
				Iterator<String> its = map.keySet().iterator();
				while(its.hasNext()){
					String key = its.next();
					String value = map.get(key);
					query.setParameter(key, value);
				}
			}
			customerInfoList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return customerInfoList;
	}
}
