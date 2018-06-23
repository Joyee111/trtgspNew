package com.sinosoft.qualityRecords.transportRecords.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.qualityRecords.transportRecords.dao.TransportRecordsDao;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecords;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecordsResource;
import com.sinosoft.user.User;


@Repository("TransportRecordsDao")
public class TransportRecordsDaoImpl extends GenericDaoHibernate<TransportRecords, Long> implements TransportRecordsDao {
	public TransportRecordsDaoImpl() {
		super(TransportRecords.class);
	}
	@Override
	public List<TransportRecords> getPage(TransportRecords tr, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<TransportRecords> res=null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			res = query.list();
		}catch (HibernateException e) {
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
	public TransportRecords findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		TransportRecords transportRecords=new TransportRecords();
		try{
			String hql = "select t from TransportRecords t where id ="+Long.parseLong(ids);
			Query query = session.createQuery(hql);
			transportRecords= (TransportRecords) query.list().get(0);	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return transportRecords;
	}
	@Override
	public void saveOrUpdata(TransportRecords tr) {
		this.getHibernateTemplate().saveOrUpdate(tr);
	}
	@Override
	public void saveTransportRecords(TransportRecords tr) {
		this.getHibernateTemplate().save(tr);
	}

	@Override
	public void del(String ids) {
		TransportRecords tr=findById(ids);
		getHibernateTemplate().delete(tr);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TransportRecords> getTransportRecordsByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<TransportRecords> transportRecordsList = null;
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
			transportRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return transportRecordsList;
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
	@Override
	public Map<String, String> qsMap() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		try{
			String hql =" select q from TransporterQualification q ";
			Query query = session.createQuery(hql);
			if(query.list().size()>0){
				List<TransporterQualification> listMq=query.list();
				for(int i=0 ;i<listMq.size();i++){
					TransporterQualification qs=listMq.get(i);
					if(qs!=null){
						map.put(String.valueOf(qs.getId()), qs.getTransporterName());
					}
				}
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return map;
	
	}
	@Override
	public TransportRecordsResource findByOrderno(String no) {
		String hql=" from TransportRecordsResource q where q.orderno='" + no+"'";
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TransportRecordsResource qu = null;
		List<?> list = query.list();
		if(!query.list().isEmpty()){
			qu = (TransportRecordsResource) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}
	@Override
	public User findByUserId(String id) {
		String hql=" from User q where q.id='"+id+"'";
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		User qu = null;
		if(query.list()!=null&&query.list().size()>0){
			qu = (User) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}
	@Override
	public TransporterQualification findByCarrierunit(String id) {
		String hql=" from TransporterQualification q where q.id='"+id+"'";
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TransporterQualification qu = null;
		if(query.list()!=null&&query.list().size()>0){
			qu = (TransporterQualification) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}
	@Override
	public List<TransportRecordsResource> findtrJsonty() {
		String hql =" from TransportRecordsResource q   ";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<TransportRecordsResource> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public TransportRecordsResource findByIds(String id) {
		String hql=" from TransportRecordsResource q where q.id='" + id+"'";
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TransportRecordsResource qu = null;
		List<?> list = query.list();
		if(!query.list().isEmpty()){
			qu = (TransportRecordsResource) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}
	@Override
	public List<TransportRecords> getAllTransportRecords(String hql,
			Map<String, Object> paramMap) {
		Session session = null;
		List<TransportRecords> recordList =null;
		try{
			session =getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			Iterator<String> it = paramMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				query.setParameter(key, paramMap.get(key));
			}
			recordList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return recordList;
	}
}
