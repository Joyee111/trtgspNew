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
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedSalesStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;

@Repository("qualifiedSalesStaffDao")
public class QualifiedSalesStaffHibernate extends GenericDaoHibernate<SalesStaff, Long>
		implements QualifiedSalesStaffDao {
	
	public QualifiedSalesStaffHibernate(){
		super(SalesStaff.class);
	}
	@Override
	public int countRecordByCondition(String sql) {
		// TODO Auto-generated method stub
		return getRecordCount(sql);
	}
	
	@Override
	public List<SalesStaff> findListByPage(String hql, int first,
			int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByaPage(hql,map,first,pagesize);
	}

	@Override
	public List<SalesStaff> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<SalesStaff> qualifiedSalesStaffList = null;
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
			qualifiedSalesStaffList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return qualifiedSalesStaffList;
	}
	@Override
	public List<SalesStaff> findList(String hql) {
		List<SalesStaff> list = null;
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
	public SalesStaff findBySalesStaffId(Long id) {
		SalesStaff  salesStaff = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria   criteria = session.createCriteria(SalesStaff.class);
			     criteria.add(Restrictions.eq("purchaseUnitsId", id));
			 if(criteria.list()!=null && criteria.list().size()>0)
				 salesStaff = (SalesStaff)criteria.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return salesStaff;
	}
}
