package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;

import javax.crypto.Cipher;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.ProcurementStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
@Repository("procurementStaffDao")
public class ProcurementStaffHibernate extends GenericDaoHibernate<ProcurementStaff, Long>
		implements ProcurementStaffDao {
	
	public ProcurementStaffHibernate(){
		super(ProcurementStaff.class);
	}
	@Override
	public List<ProcurementStaff> findProcurementStaffByParam(String type,
			String param, String personType, int first, int pagesize) {
		List<ProcurementStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ProcurementStaff.class);
			if(type != null && !"".equals(type)){
				criteria.add(Restrictions.eq("reviewStatus", type));
			}
			if(param != null && !"".equals(param)){
				criteria.add(Restrictions.or(Restrictions.like("pinyinCode", "%"+param+"%"), Restrictions.like("procurementName",  "%"+param+"%")));
			}
			if(personType != null && !"".equals(personType)){
				criteria.add(Restrictions.eq("personType", personType));
			}
			criteria.addOrder(Order.asc("procurementName"));
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
	public List<ProcurementStaff> findProcurementStaffByType(String type,
			int first, int pagesize) {
		List<ProcurementStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ProcurementStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", type));
			criteria.addOrder(Order.asc("procurementName"));
			criteria.addOrder(Order.asc("personType"));
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
	public List<ProcurementStaff> fingProcurementStaffAllByType(String type,String personType) {
		List<ProcurementStaff>  list=null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ProcurementStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", type));
			criteria.add(Restrictions.eq("personType", personType));
			criteria.addOrder(Order.asc("procurementName"));
			if(personType.equals("0")){
				criteria.add(Restrictions.sqlRestriction("  id not in (select procurementStaff_id from t_purchase_units where procurementStaff_id is not null )"));
			}
			
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
	public int countProcumentStaffByCondition(String queryName,
			String personType) {
		Session session = null;
		String count = "0";
		StringBuffer sqlBuffer = new StringBuffer("select count(*) from t_procurement_staff where 1=1 and  id != 376 ");
		if(queryName != null && !"".equals(queryName)){
			sqlBuffer.append(" and (pinyinCode like '%"+queryName+"%' or procurement_name like '%"+queryName+"%') ");
		}
		if(personType != null && !"".equals(personType)){
			sqlBuffer.append(" and EXISTS  (select * from t_procurement_staff_exist where type = person_type and procument_Name = procurement_name and type = '"+personType+"')");
		}else{
			sqlBuffer.append(" and  EXISTS (select procument_Name from t_procurement_staff_exist where  type = person_type and procument_Name = procurement_name )");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query  query = session.createSQLQuery(sqlBuffer.toString());
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return Integer.parseInt(count);
	}
	@Override
	public List<ProcurementStaff> queryProcumentStaffByCondition(
			String queryName, String personType, int first, int pagesize) {
		Session session = null;
		List<ProcurementStaff>  list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(ProcurementStaff.class);
			criteria.add(Restrictions.eq("reviewStatus", "2"));
			criteria.add(Restrictions.not(Restrictions.eq("id", Long.valueOf(376))));
			if(queryName != null && !"".equals(queryName)){
				criteria.add(Restrictions.or(Restrictions.like("pinyinCode", "%"+queryName+"%"), Restrictions.like("procurementName",  "%"+queryName+"%")));
			}
			if(personType != null && !"".equals(personType)){
				criteria.add(Restrictions.eq("personType", personType));
				criteria.add(Restrictions.sqlRestriction(" procurement_name in ( select procument_Name from t_procurement_staff_exist where type = '"+personType+"' )"));
			}else{
				criteria.add(Restrictions.sqlRestriction("  EXISTS ( select procument_Name from t_procurement_staff_exist  where  type = person_type and procument_Name = procurement_name )"));
			}
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			criteria.addOrder(Order.desc("id"));
			criteria.addOrder(Order.asc("personType"));
			list = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return list;
	}
}
