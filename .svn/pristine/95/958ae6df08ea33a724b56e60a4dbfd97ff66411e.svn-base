package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualifiedmedcstoreDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

@Repository("QualifiedmedcstoreDao")
public class QualifiedmedcstoreDaoImpl extends GenericDaoHibernate<Qualifiedmedcstore, Long> implements QualifiedmedcstoreDao {

	public QualifiedmedcstoreDaoImpl() {
		super(Qualifiedmedcstore.class);
	}
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	String now = df.format(new Date());// new Date()为获取当前系统时间
	@Override
	public Qualifiedmedcstore savequ(Qualifiedmedcstore qu) {
		Qualifiedmedcstore qus=getHibernateTemplate().merge(qu);
		return qus;
	}

	@Override
	public Qualifiedmedcstore findqu(String batchproduction,
			Long qualifiedmedicineid) {
		String hql=" from Qualifiedmedcstore q where q.qualifiedmedicineid ="+qualifiedmedicineid+" and q.batchproduction = "+batchproduction;
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Qualifiedmedcstore qu = new Qualifiedmedcstore();
		if(query.list()!=null){
			qu = (Qualifiedmedcstore) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qu;
	}

	@Override
	public Qualifiedmedcstore updatequ(Qualifiedmedcstore qu) {
		getHibernateTemplate().saveOrUpdate(qu);
		return null;
	}

	@Override
	public Qualifiedmedcstore findByBaNo(String no) {
		String hql=" from Qualifiedmedcstore q where q.batchproduction='"+no+"' and q.quantity > 0";
		Session session = null;
		List<Qualifiedmedcstore> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public List<Qualifiedmedcstore> findQualifiedMedcStore(String hql,int first ,int pagesize) {
		List<Qualifiedmedcstore> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list =query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Qualifiedmedcstore> getQualifiedMedicValidWarning(String date,int first,int pagesize ) {
		List<Qualifiedmedcstore> medicStoreList = null;
		Session session = null;
		StringBuffer hqlBuffer = new StringBuffer("select a from  Qualifiedmedcstore a where 1=1 ");
		if(date!=null && !"".equals(date)){
			//hqlBuffer.append(" and a.validdate <= :date");
			hqlBuffer.append(" and a.validdate between :now and :date");
		}
		hqlBuffer.append(" and  a.quantity > 0L ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(now!=null && !"".equals(now)){
				query.setParameter("now", now);
			}
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			medicStoreList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return medicStoreList;
	}

	@Override
	public int countQualifiedMedicValidWarning(String date) {
		Session session = null;
		String count = "0";
		String sql = "select count(*) from t_qualified_medc_store where 1=1 ";
		if(date!=null && !"".equals(date)){
			//sql = sql+" and valid_date <= :date ";
			sql = sql+" and valid_date between :now and :date ";
		}
		sql += " and quantity > 0 ";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			if(now!=null && !"".equals(now)){
				query.setParameter("now", now);
			}
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(count);
	}
	
}
