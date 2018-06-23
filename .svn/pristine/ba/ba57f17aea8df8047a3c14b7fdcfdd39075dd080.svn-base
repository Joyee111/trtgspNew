package com.sinosoft.comQuery.infoFeedbackRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.infoFeedbackRecords.dao.InfoFeedbackRecordsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedbackItem;

@Repository("InfoFeedbackRecordsDao")
public class InfoFeedbackRecordsDaoImpl extends GenericDaoHibernate<InfoFeedback, Long> implements InfoFeedbackRecordsDao {
	public InfoFeedbackRecordsDaoImpl() {
		super(InfoFeedback.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InfoFeedback> getPage(InfoFeedback df,String userId, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<InfoFeedback> res = null;
		try{
				Query query = session.createQuery(hql);
				query.setFirstResult(pageSize);
				query.setMaxResults(resultSize);
				 res = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
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
			if(session!=null)
				session.close();
		}


		return a;
	}
	@Override
	public List<InfoFeedback> getInfoFeedbackByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<InfoFeedback> infoFeedbackList = null;
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
			infoFeedbackList = query.list();

//			for (int i = 0; i < infoFeedbackList.size(); i++) {
//				Long infoFeedbackId = infoFeedbackList.get(i).getInfoFeedbackId();
//				
//				String sql = "select t from InfoFeedback t where id ="+infoFeedbackId;
//				Query infoFeedback = session.createQuery(sql);
//				infoFeedbackList.get(i).setInfoFeedback((InfoFeedback)infoFeedback.list().get(0));
//				
//				Long deliveryunitid = infoFeedbackList.get(i).getInfoFeedback().getDeliveryunitid();
//				String sqls = "select t from QualifiedSuppliers t where id ="+deliveryunitid;
//				Query qualifiedSuppliers = session.createQuery(sqls);
//				infoFeedbackList.get(i).getInfoFeedback().setQualifiedSuppliers((QualifiedSuppliers)qualifiedSuppliers.list().get(0));
//			}
//			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return infoFeedbackList;
	
	}
	
	@Override
	public InfoFeedback findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		InfoFeedbackItem infoFeedbackItem=new InfoFeedbackItem();
		InfoFeedback  infoFeedback=new InfoFeedback();
		try{
             String sql = "  from InfoFeedback t where t.id= "+Long.parseLong(ids);
	
			Query query = session.createQuery(sql);
			infoFeedback=(InfoFeedback) query.list().get(0);
	
//			Long infoFeedbackId=infoFeedbackItem.getInfoFeedbackId();
//			 String hql = "  from InfoFeedback t where t.id= "+infoFeedbackId;
//				
//				Query querys = session.createQuery(hql);
//				infoFeedback=(InfoFeedback) querys.list().get(0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		
		return infoFeedback;
	
		
		
	
	}
}
