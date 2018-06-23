package com.sinosoft.qualityRecords.unqualifiedManger.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.unqualifiedManger.dao.UnqualifiedManagerDao;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
@Repository("UnqualifiedManagerDao")
public class UnqualifiedManagerDaoImpl extends GenericDaoHibernate<UnqualifiedManager, Long> implements UnqualifiedManagerDao {
	public UnqualifiedManagerDaoImpl() {
		super(UnqualifiedManager.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<UnqualifiedManager> getPage(UnqualifiedManager um, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<UnqualifiedManager> res = null;

	
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();
			
			for (int i = 0; i < res.size(); i++) {
              Long Qualifiedmedicineid = res.get(i).getQualifiedmedicineid();
				
				String sql = "select t from Qualifiedmedcstore t where qualifiedmedicineid ="+Qualifiedmedicineid;
				Query queryFiedmedcstore=session.createQuery(sql);
				//Query queryMedicine = session.createQuery(sql);
				if(queryFiedmedcstore.list()!=null && queryFiedmedcstore.list().size()>0){
					res.get(i).setQualifiedmedcstore((Qualifiedmedcstore)queryFiedmedcstore.list().get(0));
				}
			    
			    
			    
//		    	Long qmid = res.get(i).getQualifiedmedicineid();
//				
//				String sql2 = "select t from QualityMidicine t where t.id ="+(long)qmid;
//				Query qmlist=session.createQuery(sql2);
//				//Query queryMedicine = session.createQuery(sql);
//				Qualifiedmedcstore q = new Qualifiedmedcstore();
//				res.get(i).setQualifiedmedcstore(q);
//			    res.get(i).getQualifiedmedcstore().setQualityMidicine((QualityMidicine)qmlist.list().get(0));
			
			
			
//				Long qualifiedpurchaseunitsid = res.get(i).getQualifiedpurchaseunitsid();
//				
//				String sql3 = "select t from QualifiedSuppliers t where id ="+qualifiedpurchaseunitsid;
//				Query qualifiedSuppliers = session.createQuery(sql3);
//				res.get(i).setQualifiedSuppliers((QualifiedSuppliers)qualifiedSuppliers.list().get(0));
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
	public UnqualifiedManager findById(String ids) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		UnqualifiedManager unqualifiedManager=new UnqualifiedManager();
		try{
			String hql = "select t from UnqualifiedManager t where id ="+Long.parseLong(ids);
			Query query = session.createQuery(hql);
			unqualifiedManager=(UnqualifiedManager) query.list().get(0);
			Long Qualifiedmedicineid =unqualifiedManager.getQualifiedmedicineid();	
			String sql = "select t from Qualifiedmedcstore t where id ="+Qualifiedmedicineid;
			Query qualifiedmedcstore = session.createQuery(sql);
			if(qualifiedmedcstore!=null && qualifiedmedcstore.list().size()>0){
				unqualifiedManager.setQualifiedmedcstore((Qualifiedmedcstore)qualifiedmedcstore.list().get(0));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return unqualifiedManager;
	}
	@Override
	public void saveOrUpdata(UnqualifiedManager um) {
		this.getHibernateTemplate().saveOrUpdate(um);
	}

	@Override
	public void saveUnqualifiedManager(UnqualifiedManager um) {
		this.getHibernateTemplate().save(um);
	}

	@Override
	public void del(String ids) {
		UnqualifiedManager um=findById(ids);
		getHibernateTemplate().delete(um);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> qsMap() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		try{
			String hql =" select q from QualifiedSuppliers q ";
			Query query = session.createQuery(hql);
			if(query.list().size()>0){
				List<QualifiedSuppliers> listMq=query.list();
				for(int i=0 ;i<listMq.size();i++){
					QualifiedSuppliers qs=listMq.get(i);
					if(qs!=null){
						map.put(String.valueOf(qs.getId()), qs.getCustomerName());
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
	@SuppressWarnings("unchecked")
	@Override
	public List<UnqualifiedManager> getUnqualifiedManagerByPage(String hql, Map map,int first, int pagesize) {
		Session session =null;
		List<UnqualifiedManager> unqualifiedManagerList = null;
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
			unqualifiedManagerList = query.list();
			for (int i = 0; i < unqualifiedManagerList.size(); i++) {
				Long Qualifiedmedicineid = unqualifiedManagerList.get(i).getQualifiedmedicineid();
				
				String sql = "select t from Qualifiedmedcstore t where qualifiedmedicineid ="+Qualifiedmedicineid;
				Query qualifiedmedcstore = session.createQuery(sql);
				unqualifiedManagerList.get(i).setQualifiedmedcstore((Qualifiedmedcstore)qualifiedmedcstore.list().get(0));
			
			
//				Long qualifiedpurchaseunitsid = unqualifiedManagerList.get(i).getQualifiedpurchaseunitsid();
//				
//				String sql3 = "select t from QualifiedSuppliers t where id ="+qualifiedpurchaseunitsid;
//				Query qualifiedSuppliers = session.createQuery(sql3);
//				unqualifiedManagerList.get(i).setQualifiedSuppliers((QualifiedSuppliers)qualifiedSuppliers.list().get(0));
				
             	Long qmid = unqualifiedManagerList.get(i).getQualifiedmedicineid();
				
				String sql2 = "select t from QualityMidicine t where id ="+qmid;
				Query qmlist=session.createQuery(sql2);
				unqualifiedManagerList.get(i).getQualifiedmedcstore().setQualityMidicine((QualityMidicine)qmlist.list().get(0));
			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return unqualifiedManagerList;
	
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
	public Qualifiedmedcstore findYpkcById(String ids) {

		
		String hql = "select t from Qualifiedmedcstore t where id ="+Long.parseLong(ids);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Qualifiedmedcstore qu=new Qualifiedmedcstore();
		if(query.list()!=null){
			qu =(Qualifiedmedcstore) query.list().get(0);
		}
		return qu;
	
	}
	@Override
	public List<Qualifiedmedcstore> findypJsonty() {

		String hql =" from Qualifiedmedcstore q   ";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<Qualifiedmedcstore> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
	
	@Override  
	public List<UnqualifiedManager> findunypJsonty() {

		String hql ="select q from UnqualifiedManager q where q.processingNo not in " +
				"(select s.processingNo  from ScrapMedicine s, UnqualifiedManager q where s.batchno = q.batchno and s.processingNo = q.processingNo)  " +
				" order by q.batchno   ";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<UnqualifiedManager> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;


	}
	@Override
	public List<QualityMidicine> findqmJsonty(){
		String hql="select qm from QualityMidicine qm";
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.createQuery(hql);
		List<QualityMidicine> list=query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
