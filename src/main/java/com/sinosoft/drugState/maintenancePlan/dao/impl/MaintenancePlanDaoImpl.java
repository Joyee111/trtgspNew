package com.sinosoft.drugState.maintenancePlan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.maintenancePlan.dao.MaintenancePlanDao;
import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;

@Repository("MaintenancePlanDao")
public class MaintenancePlanDaoImpl extends GenericDaoHibernate<QualifiedmedcstoreRe, Long> implements MaintenancePlanDao{

	public MaintenancePlanDaoImpl() {
		super(QualifiedmedcstoreRe.class);
	}

	@Override
	public List<QualifiedmedcstoreRe> getPage(QualifiedmedcstoreRe qm, int i,
			int pagesize) {
//		String hql = "from Qualifiedmedcstore t where 1=1 and t.quantity != 0 order by t.nextmaintaindate asc";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		query.setFirstResult(i);
//		query.setMaxResults(pagesize);
//		@SuppressWarnings("unchecked")
//		List<Qualifiedmedcstore> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql = "from QualifiedmedcstoreRe t where 1=1 and t.quantity != 0 order by t.nextmaintaindate asc";
		Session session = null;
		List<QualifiedmedcstoreRe> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list =query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCount(QualifiedmedcstoreRe qm) {
//		String hql = "select count(*) from Qualifiedmedcstore t where 1=1 and t.quantity != 0";
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		String hql = "select count(*) from QualifiedmedcstoreRe t where 1=1 and t.quantity != 0";
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public QualifiedmedcstoreRe findById(String id) {
		QualifiedmedcstoreRe  qualifiedmedcstoreRe = null;
		Session session = null;
		try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			 qualifiedmedcstoreRe = (QualifiedmedcstoreRe)session.get(QualifiedmedcstoreRe.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qualifiedmedcstoreRe;
	}

	@Override
	public WarnConfig findWanrn() {
		/*String hql = "select t from WarnConfig t where t.limit_name='yh_maintenance_plan'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		WarnConfig list = new WarnConfig();
		if(query.list()!=null && query.list().size()>0 ){
			list = (WarnConfig) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select t from WarnConfig t where t.limit_name='yh_maintenance_plan'";
		Session session = null;
		List<WarnConfig> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list =query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public List<QualifiedmedcstoreRe> getQualifiedMdecByDate(String startDate,
			String endDate,String batchNumber, int first, int pagesize) {
		List<QualifiedmedcstoreRe> qulMedcList = null;
		Session session = null;
	/*	DetachedCriteria deCriteria = DetachedCriteria.forClass(Qualifiedmedcstore.class);
		if(startDae!=null && !"".equals(startDae)){
			deCriteria.add(Restrictions.ge("nextmaintaindate", startDae));
		}
		if(endDate!=null && !"".equals(endDate)){
			deCriteria.add(Restrictions.le("nextmaintaindate", endDate));
		}
		if(batchNumber!=null && !"".equals(batchNumber)){
			deCriteria.add(Restrictions.like("batchproduction", "%"+batchNumber+"%"));
		}
		deCriteria.add(Restrictions.gt("quantity", 0L));
		deCriteria.add(Restrictions.sqlRestriction("  qualityMidicine.medicinalNo not in (select medicNo from  QualifiedMedcJH)"));
		deCriteria.addOrder(Order.asc("nextmaintaindate"));*/
		StringBuffer hqlBuffer = new StringBuffer("select q from QualifiedmedcstoreRe q where 1=1 ");
		
		if(startDate!=null && !"".equals(startDate)){
			hqlBuffer.append(" and q.nextmaintaindate >= :startDate");
		}
		if(endDate!=null && !"".equals(endDate)){
			hqlBuffer.append(" and q.nextmaintaindate <= :endDate");
		}
		if(batchNumber!=null && !"".equals(batchNumber)){
			hqlBuffer.append(" and q.batchproduction like :batchNumber");
		}
		hqlBuffer.append(" and q.qualityMidicine.medicinalNo not in (select medicNo from  QualifiedMedcJH )");
		hqlBuffer.append(" and q.quantity > 0");
		hqlBuffer.append(" and len(q.batchproduction) > 7 ");
		hqlBuffer.append(" and q.re_flag = 0 ");//改为原本的一个批号只显示一个，若改为原来的表修改的地方较多，因此改为只显示未返厂的 2017-5-24 13:46:39
		hqlBuffer.append(" order by nextmaintaindate asc");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(startDate!=null && !"".equals(startDate)){
				query.setParameter("startDate", startDate);
			}
			if(endDate!=null && !"".equals(endDate)){
				query.setParameter("endDate", endDate);
			}
			if(batchNumber!=null && !"".equals(batchNumber)){
				query.setParameter("batchNumber", "%"+batchNumber+"%");
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			qulMedcList = query.list();
			//Criteria criteria = deCriteria.getExecutableCriteria(session);
			//criteria.setFirstResult(first);
			//criteria.setMaxResults(pagesize);
			//qulMedcList = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qulMedcList;
	}

	@Override
	public int countQualifiedMdeByCondition(String startDate, String endDate,
			String bathcNumber) {
		Session session = null;
		String count = "0";
		StringBuffer hqlbuBuffer = new StringBuffer("select count(*) from QualifiedmedcstoreRe t where 1=1 ");
		if(startDate != null && !"".equals(startDate)){
			hqlbuBuffer.append(" and t.nextmaintaindate >= :startDate ");
		}
		if(endDate != null && !"".equals(endDate)){
			hqlbuBuffer.append(" and t.nextmaintaindate <= :endDate ");
		}
		if(bathcNumber != null && !"".equals(bathcNumber)){
			hqlbuBuffer.append(" and t.batchproduction like :batchNumber ");
		}
		hqlbuBuffer.append("and t.qualityMidicine.medicinalNo not in (select medicNo from  QualifiedMedcJH )");
		hqlbuBuffer.append(" and t.quantity > 0 ");
		hqlbuBuffer.append(" and len(t.batchproduction) > 7 ");
		hqlbuBuffer.append(" and t.re_flag = 0 ");//改为原本的一个批号只显示一个，若改为原来的表修改的地方较多，因此改为只显示未返厂的 2017-5-24 13:46:39
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlbuBuffer.toString());
			if(startDate != null && !"".equals(startDate)){
				query.setParameter("startDate", startDate);
			}
			if(endDate != null && !"".equals(endDate)){
				query.setParameter("endDate", endDate);
			}
			if(bathcNumber != null && !"".equals(bathcNumber)){
				query.setParameter("batchNumber", "%"+bathcNumber+"%");
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.valueOf(count);
	}

}
