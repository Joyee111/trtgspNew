package com.sinosoft.qualityRecords.complantManager.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.complantManager.dao.DrugComInfoDao;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Repository("DrugComInfoDao")
public class DrugComInfoDaoImpl extends GenericDaoHibernate<DrugComInfo, Long>  implements DrugComInfoDao{

	public DrugComInfoDaoImpl() {
		super(DrugComInfo.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugComInfoItem> getPage(DrugComInfoItem dr,String userId, int pageSize,int resultSize,String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<DrugComInfoItem> res = null;
		try{
				Query query = session.createQuery(hql);
				query.setFirstResult(pageSize);
				query.setMaxResults(resultSize);
				 res = query.list();
				for (int i = 0; i < res.size(); i++) {
					Long drugComInfoId = res.get(i).getDrugComInfoId();
					
					String sql = "select t from DrugComInfo t where id ="+drugComInfoId;
					Query drugComInfo = session.createQuery(sql);			
					res.get(i).setDrugComInfo((DrugComInfo)drugComInfo.list().get(0));
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
	public DrugComInfo findById(String ids) {

		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		DrugComInfoItem drugComInfoItem=new DrugComInfoItem();
		DrugComInfo  drugComInfo=new DrugComInfo();
		try{
             String sql = "  from DrugComInfoItem t where t.id= "+Long.parseLong(ids);
	
			Query query = session.createQuery(sql);
			drugComInfoItem=(DrugComInfoItem) query.list().get(0);
	
			Long drugInfoId=drugComInfoItem.getDrugComInfoId();
			 String hql = "  from DrugComInfo t where t.id= "+drugInfoId;
				
				Query querys = session.createQuery(hql);
				drugComInfo=(DrugComInfo) querys.list().get(0);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return drugComInfo;
	
		
		
	}

	@Override
	public void saveOrUpdata(DrugComInfo dr) {
		this.getHibernateTemplate().saveOrUpdate(dr);
	}

	@Override
	public void saveDrugComInfo(DrugComInfo dr) {
		this.getHibernateTemplate().save(dr);
	}

	
	@Override
	public void delss(String id) {
		DrugComInfo ar = findById(id);
		this.getHibernateTemplate().delete(ar);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> qmMap() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		try{
			
			String hql =" select q from QualityMidicine q ";
			
			Query query = session.createQuery(hql);
			if(query.list().size()>0){
				List<QualityMidicine> listMq=query.list();
				for(int i=0 ;i<listMq.size();i++){
					QualityMidicine qm=listMq.get(i);
					if(qm!=null){
						map.put(String.valueOf(qm.getId()), qm.getTradename());
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
	public QualityMidicine findYpById(String quamap) {
		Session session = null;
		QualityMidicine qualityMidicine= null;
		try{
			session =  this.getHibernateTemplate().getSessionFactory().openSession();
			qualityMidicine = (QualityMidicine)session.get(QualityMidicine.class, Long.valueOf(quamap));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return qualityMidicine;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DrugComInfoItem> getDrugComInfoByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<DrugComInfoItem> drugComInfoList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();
//			while(it.hasNext()){
//				Object key = it.next();
//				query.setParameter(key.toString(), map.get(key));
//				
//			}
			drugComInfoList = query.list();
		
			
			for (int i = 0; i < drugComInfoList.size(); i++) {
				Long drugComInfoId = drugComInfoList.get(i).getDrugComInfoId();
				
				String sql = "select t from DrugComInfo t where id ="+drugComInfoId;
				Query drugComInfo = session.createQuery(sql);			
				drugComInfoList.get(i).setDrugComInfo((DrugComInfo)drugComInfo.list().get(0));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return drugComInfoList;
	}
	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createQuery(hql);
			String shu=query.list().get(0).toString();
			  a = Integer.parseInt(shu);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return a;
	}
	@Override
	public Map<String, String> jsMap() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		try{
			String hql =" select q from User q order by q.realname asc ";
			Query query = session.createQuery(hql);
			if(query.list().size()>0){
				List<User> listMq=query.list();
				for(int i=0 ;i<listMq.size();i++){
					User qs=listMq.get(i);
					if(qs!=null){
						map.put(String.valueOf(qs.getId()), qs.getRealname());
						
					}
				}
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		map.put("0", "完成");
		return map;
	
	}
	@Override
	public void save(DrugComInfoItem di) {
		this.getHibernateTemplate().save(di);
		
	}
	@Override
	public void dels(String string) {
		DrugComInfoItem ch = findByIda(string);
		this.getHibernateTemplate().delete(ch);
		
	}
	@Override
	public DrugComInfoItem findByIda(String id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		DrugComInfoItem drugComInfoItem=new DrugComInfoItem();
		try{
			String hql="from DrugComInfoItem t where t.id="+Long.parseLong(id);
			Query query = session.createQuery(hql);
			drugComInfoItem=(DrugComInfoItem) query.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return drugComInfoItem;
	}
	@Override
	public List<?> findAllId(Long id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<?> list =new ArrayList();
		try{
			String sql = " select t.id from DrugComInfoItem t where t.drugComInfoId= "+id;
			
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
	public List<DrugComInfoItem> findYp(Long id) {
		List<DrugComInfoItem> list=null;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try{
			String hql = "select t from DrugComInfoItem t where t.drugComInfoId ="+id;
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
	public void update(DrugComInfoItem di) {
		this.getHibernateTemplate().saveOrUpdate(di);
		
	}
	@Override
	public List<?> findZhiPaiId(Long id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<?> list =new ArrayList();
		try{
			String sql = " select t.zhipaiId from DrugComInfoItem t where t.drugComInfoId= "+id;
			
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
	public int countWaitingToDo(Long userId) {
		Session session  = null;
		int count = 0;
		try{
			String sql = "select COUNT(*) from t_drugComInfo_item   where zhipaiId=:userId";
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			query.setLong("userId", userId);
			count = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return count;
	}


}
