package com.sinosoft.qualityRecords.drugMaintenance.dao.impl;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.drugMaintenance.dao.DrugMaintenanceDao;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Repository("DrugMaintenanceDao")
public class DrugMaintenanceDaoImpl extends GenericDaoHibernate<DrugMaintenance, Long>  implements DrugMaintenanceDao{
	public DrugMaintenanceDaoImpl() {
		super(DrugMaintenance.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugMaintenance> getPage(DrugMaintenance dm, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<DrugMaintenance> res =null;
		try{
			Query query = session.createQuery(hql);
			query.setFirstResult(pageSize);
			query.setMaxResults(resultSize);
			 res = query.list();
			for (int i = 0; i < res.size(); i++) {
				
				  Long Qualifiedmedicineid = res.get(i).getQualifiedmedicineid();
					
					String sql = "select t from QualifiedmedcstoreRe t where qualifiedmedicineid ="+Qualifiedmedicineid;
					Query queryFiedmedcstore=session.createQuery(sql);
					//Query queryMedicine = session.createQuery(sql);
					if(queryFiedmedcstore.list()!=null && queryFiedmedcstore.list().size()>0){
						res.get(i).setQualifiedmedcstoreRe((QualifiedmedcstoreRe)queryFiedmedcstore.list().get(0));
					}
			    
			    
//		    	Long qmid = res.get(i).getQualifiedmedicineid();
//				
//				String sql2 = "select t from QualityMidicine t where id ="+(long)qmid;
//				Query qmlist=session.createQuery(sql2);
//				Qualifiedmedcstore q = new Qualifiedmedcstore();
//				res.get(i).setQualifiedmedcstore(q);
//			    res.get(i).getQualifiedmedcstore().setQualityMidicine((QualityMidicine)qmlist.list().get(0));
//			    
				//	Long userId = res.get(i).getModifierid();
					if(res.get(i).getModifierid()!=null){
						User user = (User)session.get(User.class,res.get(i).getModifierid());
						 res.get(i).setUser(user);
					}
//				
//				String sql3 = "select t from User t where id ="+userId;
//				Query userlist=session.createQuery(sql3);
//				//Query queryMedicine = session.createQuery(sql);
//			    res.get(i).setUser((User)userlist.list().get(0));
			
			}	
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
	public DrugMaintenance findById(String ids) {
		Session session = null;
		DrugMaintenance drugMaintenance= null;
		try{
			 session = this.getHibernateTemplate().getSessionFactory().openSession();
			 drugMaintenance =  (DrugMaintenance)session.get(DrugMaintenance.class, Long.parseLong(ids));
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
			 session.close();
		}
	
		return drugMaintenance;
	}
	@Override
	public void saveOrUpdata(DrugMaintenance dm) {
		this.getHibernateTemplate().saveOrUpdate(dm);
	}

	@Override
	public void saveDrugMaintenance(DrugMaintenance dm) {
		this.getHibernateTemplate().save(dm);
	}

	@Override
	public void del(String ids) {
		DrugMaintenance dm=findById(ids);
		getHibernateTemplate().delete(dm);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugMaintenance> getDrugMaintenanceByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<DrugMaintenance> drugMaintenanceList = null;
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
			drugMaintenanceList = query.list();
			for (int i = 0; i < drugMaintenanceList.size(); i++) {
				Long qid = null;
				qid = drugMaintenanceList.get(i).getQualifiedmedicineid();
				String sql = "select t from QualifiedmedcstoreRe t where qualifiedmedicineid ="+qid +" and batchproduction='"+drugMaintenanceList.get(i).getBatchnumber() +"'";
				Query qualifiedmedcstoreRe = session.createQuery(sql);
				drugMaintenanceList.get(i).setQualifiedmedcstoreRe((QualifiedmedcstoreRe)qualifiedmedcstoreRe.list().get(0));
				
                Long qmid = drugMaintenanceList.get(i).getQualifiedmedicineid();
				
				String sql2 = "select t from QualityMidicine t where id ="+qmid;
				Query qmlist=session.createQuery(sql2);
				//Query queryMedicine = session.createQuery(sql);
				drugMaintenanceList.get(i).getQualifiedmedcstoreRe().setQualityMidicine((QualityMidicine)qmlist.list().get(0));
				
				 Long userId = drugMaintenanceList.get(i).getModifierid();
				 if(userId!=null ){
					User user = (User)session.get(User.class, userId);
					drugMaintenanceList.get(i).setUser(user);
				 }
//					String sql3 = "select t from User t where id ="+userId;
//					Query userlist=session.createQuery(sql3);
//					//Query queryMedicine = session.createQuery(sql);
//					drugMaintenanceList.get(i).setUser((User)userlist.list().get(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return drugMaintenanceList;
	}
	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createSQLQuery(hql);
			  a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return a;
	}

}
