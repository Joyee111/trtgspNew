package com.sinosoft.drugState.scrap.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.scrap.dao.ScrapDao;
import com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo;
import com.sinosoft.drugState.scrap.model.ScrapMedicine;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
@Repository("ScrapDaoDao")
public class ScrapDaoImpl extends GenericDaoHibernate<ScrapMedicine, Long> implements  ScrapDao{

	public ScrapDaoImpl() {
		super(ScrapMedicine.class);
	}

	@Override
	public List<ScrapAndQualityMedicineVo> getPage(String commonName, String status,
			int first, int pageSize) {
		Session session = null;
		//List<ScrapMedicine> list = null;
		List<ScrapAndQualityMedicineVo> list=null;
		//StringBuffer hqlBuffer = new StringBuffer("select  d  from ScrapMedicine  d , QualityMidicine q  " +
		//		" where  d.qualifiedmedicineid =  q.id and d.status=:status ");  
		StringBuffer hqlBuffer = new StringBuffer("select  new com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo(d,q) from ScrapMedicine  d , QualityMidicine q  " +
		" where  d.qualifiedmedicineid =  q.id and d.status=:status ");   
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.commonname like :commonName ");
		}
		hqlBuffer.append(" order by d.modifiedtime DESC");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setParameter("status", status);
			query.setFirstResult(first);
			query.setMaxResults(pageSize);
			list = query.list();
			
			/*for (int i = 0; i < list.size(); i++) {
	              Long Qualifiedmedicineid = list.get(i).getQualifiedmedicineid();
					
					String sql = "select t from Qualifiedmedcstore t where qualifiedmedicineid ="+Qualifiedmedicineid;
					Query queryFiedmedcstore=session.createQuery(sql);
					//Query queryMedicine = session.createQuery(sql);
					if(queryFiedmedcstore.list()!=null && queryFiedmedcstore.list().size()>0){
						list.get(i).setQualifiedmedcstore((Qualifiedmedcstore)queryFiedmedcstore.list().get(0));
					}
			}*/		
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}

	@Override
	public int countScrapMedicineByStatus(String commonName, String status) {
		Session session = null;
		String  count = "";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from ScrapMedicine  d , QualityMidicine q  " +
				" where  d.qualifiedmedicineid =  q.id and d.status=:status ");   
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.commonname like :commonName ");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setParameter("status", status);
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return Integer.parseInt(count);
	}
	

	@Override
	public void saveOrUpdateSM(ScrapMedicine sm) {
		this.getHibernateTemplate().saveOrUpdate(sm);
		
	}

	@Override
	public void saveSM(ScrapMedicine sm) {
		this.getHibernateTemplate().save(sm);
		
	}

	@Override
	public ScrapMedicine findById(String id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		ScrapMedicine scrapMedicine=new ScrapMedicine();
		try{
			String hql = "select t from ScrapMedicine t where id ="+Long.parseLong(id);
			Query query = session.createQuery(hql);
			scrapMedicine=(ScrapMedicine) query.list().get(0);
			Long Qualifiedmedicineid =scrapMedicine.getQualifiedmedicineid();	
			String sql = "select t from Qualifiedmedcstore t where id ="+Qualifiedmedicineid;
			Query qualifiedmedcstore = session.createQuery(sql);
			if(qualifiedmedcstore!=null && qualifiedmedcstore.list().size()>0){
				scrapMedicine.setQualifiedmedcstore((Qualifiedmedcstore)qualifiedmedcstore.list().get(0));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	
		return scrapMedicine;
	}
	
	
}
