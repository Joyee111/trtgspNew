package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedPurchaseUnitsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 2:06:15 PM
 * 类说明
 */
@Repository("qualifiedPurchaseUnitsDao")
public class QualifiedPurchaseUnitsHibernate extends GenericDaoHibernate<QualifiedPurchaseUnits, Long>
		implements QualifiedPurchaseUnitsDao {
	
	public QualifiedPurchaseUnitsHibernate(){
		super(QualifiedPurchaseUnits.class);
	}
	@Override
	public int countRecordByCondition(String sql) {
		// TODO Auto-generated method stub
		return getRecordCount(sql);
	}
	
	@Override
	public List<QualifiedPurchaseUnits> findListByPage(String hql, int first,
			int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByaPage(hql,map,first,pagesize);
	}

	@Override
	public List<QualifiedPurchaseUnits> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<QualifiedPurchaseUnits> qualiPurUnitsList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = paramMap.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), paramMap.get(key));
				
			}
			qualiPurUnitsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return qualiPurUnitsList;
	}
	@Override
	public List<QualifiedPurchaseUnits> findList(String hql) {
		List<QualifiedPurchaseUnits> list = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	@Override
	public QualifiedPurchaseUnits findByPurchaseUtilsId(Long id) {
		QualifiedPurchaseUnits  qualifiedPurchaseUnits = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria   criteria = session.createCriteria(QualifiedPurchaseUnits.class);
			     criteria.add(Restrictions.eq("purchaseUnitsId", id));
			 if(criteria.list()!=null && criteria.list().size()>0)
				 qualifiedPurchaseUnits = (QualifiedPurchaseUnits)criteria.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return qualifiedPurchaseUnits;
	}
}
