package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.SalesStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.SalesStaff;
@Repository("salesStaffDao")
public class SalesStaffHibernate extends GenericDaoHibernate<SalesStaff,Long> implements
		SalesStaffDao {
	public SalesStaffHibernate(){
		super(SalesStaff.class);
	}
	@Override
	public List<SalesStaff> findSalesStaffList(String type, int first,
			int pagesize) {
		List<SalesStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(SalesStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", type));
			criteria.addOrder(Order.asc("saleName"));
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			list = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<SalesStaff> querySalesStaffList(String type, String param,
			int first, int pagesize) {
		List<SalesStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(SalesStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", type));
			criteria.add(Restrictions.or(Restrictions.like("pinyinCode", "%"+param+"%"), Restrictions.like("saleName",  "%"+param+"%")));
			criteria.addOrder(Order.asc("saleName"));
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			list = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	@Override
	public List<SalesStaff> findSalesStaffAllByType(String type) {
		List<SalesStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(SalesStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", type));
			criteria.addOrder(Order.asc("saleName"));
			list = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

}
