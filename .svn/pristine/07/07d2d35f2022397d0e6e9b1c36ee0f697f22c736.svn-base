package com.sinosoft.qualityRecords.adverseReactionInfo.dao.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionInfoDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionInfo;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@Repository("adverseReactionInfoDao")
public class AdverseReactionInfoDaoImpl extends GenericDaoHibernate<AdverseReactionInfo, Long> implements AdverseReactionInfoDao {
	
	public AdverseReactionInfoDaoImpl(){//AdverseReactionInfo   AdverseReactionDoubtItem
		super(AdverseReactionInfo.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AdverseReactionInfo> getPage(AdverseReactionInfo ar, int i, int pagesize) {
		List<AdverseReactionInfo> list =null;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try{
			String hql = "from AdverseReactionInfo t ";
			
			Query query = session.createQuery(hql);
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			  list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	@Override
	public int getTotalCount() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			String hql = "select count(*) from AdverseReactionInfo t ";
			Query query = session.createQuery(hql);
			String list = query.list().get(0).toString();
			a=Integer.parseInt(list);	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return a;
	}
	@Override
	public AdverseReactionInfo save(AdverseReactionInfo ar){
		AdverseReactionInfo mcs =getHibernateTemplate().merge(ar);
		return mcs;
		
	}
	@Override
	public AdverseReactionInfo findById(String id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		AdverseReactionInfo chn =new AdverseReactionInfo();
		try{
			String hql = "from AdverseReactionInfo t where t.id="+Long.parseLong(id);	
			Query query = session.createQuery(hql);
		    chn=(AdverseReactionInfo) query.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return chn;
	}
	
	@Override
	public void update(AdverseReactionInfo ar) {
		this.getHibernateTemplate().saveOrUpdate(ar);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AdverseReactionDoubtItem> findYp(Long id) {
		List<AdverseReactionDoubtItem> list=null;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try{
			String hql = "select t from AdverseReactionDoubtItem t where t.adverseReactionInfoId ="+id;
			Query query = session.createQuery(hql);
			 list= query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		return list;
	}
	@Override
	public List<?> findAllId(Long id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<?> list =new ArrayList();
		try{
			String sql = " select t.id from AdverseReactionDoubtItem t where t.adverseReactionInfoId= "+id;
			
			Query sqlQuery = session.createQuery(sql);
			 list = sqlQuery.list();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	@Override
	public void del(String id) {
		AdverseReactionInfo ar = findById(id);
		this.getHibernateTemplate().delete(ar);
	}
	@Override
	public QualityMidicine findYpById(String quamap) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		QualityMidicine qu = new QualityMidicine();
		try{
			Long a = Long.parseLong(quamap.trim());
			String hql = "select t from QualityMidicine t where id ="+a;
		
			Query query = session.createQuery(hql);
			 qu = (QualityMidicine) query.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return qu;
	}
	@Override
	public List<AdverseReactionUseItem> findBYYp(Long id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<AdverseReactionUseItem> list=null;
		try{
			String hql = "select t from AdverseReactionUseItem t where t.adverseReactionInfoId ="+id;
			
			Query query = session.createQuery(hql);
			 list= query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AdverseReactionInfo> getAdverseReactionInfoByPage(String hql, Map map,	int first, int pagesize) {
		Session session =null;
		List<AdverseReactionInfo> adverseReactionInfoList = null;
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
			adverseReactionInfoList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return adverseReactionInfoList;
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
	//并用药
	@SuppressWarnings("unchecked")
	@Override
	public List<?> findAllIds(Long id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<?> list =new ArrayList();
		try{
			String sql = " select t.id from AdverseReactionUseItem t where t.adverseReactionInfoId= "+id;	
			Query sqlQuery = session.createQuery(sql);
			list = sqlQuery.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	
	
}
