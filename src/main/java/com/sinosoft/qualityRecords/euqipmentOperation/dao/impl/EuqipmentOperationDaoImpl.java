package com.sinosoft.qualityRecords.euqipmentOperation.dao.impl;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.euqipmentOperation.dao.EuqipmentOperationDao;
import com.sinosoft.qualityRecords.euqipmentOperation.model.EuqipmentOperation;

@Repository("EuqipmentOperationDao")
public class EuqipmentOperationDaoImpl extends GenericDaoHibernate<EuqipmentOperation, Long>  implements EuqipmentOperationDao {
	
	public EuqipmentOperationDaoImpl() {
		super(EuqipmentOperation.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EuqipmentOperation> getPage(EuqipmentOperation eo, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<EuqipmentOperation> res=null;
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
	public EuqipmentOperation findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		EuqipmentOperation euqipmentOperation=new EuqipmentOperation();
		try{
			String hql = "select t from EuqipmentOperation t where id ="+Long.parseLong(ids);
			Query query = session.createQuery(hql);
			euqipmentOperation= (EuqipmentOperation) query.list().get(0);	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return euqipmentOperation;
	}

	@Override
	public void saveOrUpdata(EuqipmentOperation eo) {
		this.getHibernateTemplate().saveOrUpdate(eo);
	}
	@Override
	public void saveEuqipmentOperation(EuqipmentOperation eo) {
		this.getHibernateTemplate().save(eo);
	}

	@Override
	public void del(String ids) {
		EuqipmentOperation eo=findById(ids);
		getHibernateTemplate().delete(eo);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EuqipmentOperation> getEuqipmentOperationByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<EuqipmentOperation> euqipmentOperationList = null;
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
			euqipmentOperationList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return euqipmentOperationList;
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
