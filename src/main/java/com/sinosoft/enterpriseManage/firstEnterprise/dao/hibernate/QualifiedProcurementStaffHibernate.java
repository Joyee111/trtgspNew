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
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedProcurementStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;

@Repository("qualifiedProcurementStaffDao")
public class QualifiedProcurementStaffHibernate extends GenericDaoHibernate<ProcurementStaff, Long>
		implements QualifiedProcurementStaffDao {
	
	public QualifiedProcurementStaffHibernate(){
		super(ProcurementStaff.class);
	}
	@Override
	public int countRecordByCondition(String sql) {
		// TODO Auto-generated method stub
		return getRecordCount(sql);
	}
	
	@Override
	public List<ProcurementStaff> findListByPage(String hql, int first,
			int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByaPage(hql,map,first,pagesize);
	}

	@Override
	public List<ProcurementStaff> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<ProcurementStaff> qualifiedProcurementStaffList = null;
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
			qualifiedProcurementStaffList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return qualifiedProcurementStaffList;
	}
	@Override
	public List<ProcurementStaff> findList(String hql) {
		List<ProcurementStaff> list = null;
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
	public ProcurementStaff findByProStaffId(Long id) {
		ProcurementStaff  procurementStaff = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria   criteria = session.createCriteria(ProcurementStaff.class);
			     criteria.add(Restrictions.eq("purchaseUnitsId", id));
			 if(criteria.list()!=null && criteria.list().size()>0)
				 procurementStaff = (ProcurementStaff)criteria.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return procurementStaff;
	}
}
