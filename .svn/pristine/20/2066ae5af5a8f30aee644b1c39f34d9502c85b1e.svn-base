package com.sinosoft.comQuery.drugComInfoRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sinosoft.comQuery.drugComInfoRecords.dao.DrugComInfoRecordsDao;
import com.sinosoft.frame.dao.hibernate.GenericDaoHibernate;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



@Repository("DrugComInfoRecordsDao")
public class DrugComInfoRecordsDaoImpl extends GenericDaoHibernate<DrugComInfo, Long>implements DrugComInfoRecordsDao {
	public DrugComInfoRecordsDaoImpl() {
		super(DrugComInfo.class);
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
	public DrugComInfo findById(String id) {

		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		DrugComInfoItem drugComInfoItem = new DrugComInfoItem();
		DrugComInfo drugComInfo = new DrugComInfo();
		try {
			String sql = "  from DrugComInfo t where t.id= "
					+ Long.parseLong(id);

			Query query = session.createQuery(sql);
			drugComInfo = (DrugComInfo) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null)
				session.close();
		}

		return drugComInfo;

	}


	@Override
	public List<DrugComInfo> getPage(DrugComInfo dr, String userId,
			int pageSize, int resultSize, String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		List<DrugComInfo> res = null;
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


	@SuppressWarnings("unchecked")
	@Override
	public List<DrugComInfo> getDrugComInfoByPage(String hql, Map map,
			int first, int pagesize) {
		Session session =null;
		List<DrugComInfo> drugComInfoList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();
			drugComInfoList = query.list();		
//			for (int i = 0; i < drugComInfoList.size(); i++) {
//				Long drugComInfoId = drugComInfoList.get(i).getDrugComInfoId();
//				
//				String sql = "select t from DrugComInfo t where id ="+drugComInfoId;
//				Query drugComInfo = session.createQuery(sql);			
//				drugComInfoList.get(i).setDrugComInfo((DrugComInfo)drugComInfo.list().get(0));
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return drugComInfoList;
	}








	



	


	

}
