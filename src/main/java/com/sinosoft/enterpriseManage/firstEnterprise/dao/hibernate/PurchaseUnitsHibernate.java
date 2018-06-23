package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.PurchaseUnitsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TrtssProv;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 2:36:48 PM
 * 类说明
 */
@Repository("purchaseUnitsDao")
public class PurchaseUnitsHibernate extends GenericDaoHibernate<PurchaseUnit, Long>
		implements PurchaseUnitsDao {
	public PurchaseUnitsHibernate(){
		super(PurchaseUnit.class);
	}
	@Override
	public int countRecordByState(int state) {
		String sql = "select count(*) from t_purchase_units where review_status="+state;
		return getRecordCount(sql);
	}

	@Override
	public List<PurchaseUnit> findListByPage(String hql, int first, int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByPage(hql,map,first,pagesize);
	}

	@Override
	public List<PurchaseUnit> findListByPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<PurchaseUnit> purchaseUnitList = null;
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
			purchaseUnitList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return purchaseUnitList;
	}
	@Override
	public Map<String, String> qmMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		String hql =" select q from TrtssProv q  order by q.provId asc";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		if(query.list().size()>0){
			List<TrtssProv> listMq=query.list();
			for(int i=0 ;i<listMq.size();i++){
				TrtssProv qm=listMq.get(i);
				if(qm!=null){
					map.put(String.valueOf(qm.getProvId()), qm.getProvName());
				}
			}
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public String findNumberByPro(String number) {
		String sql = " select t.customer_number from t_purchase_units t where SUBSTRING(t.customer_number,1,2)= '"+number.trim()+"'  AND LEN(t.customer_number) = 9  order by t.customer_number DESC";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		List<?> list = sqlQuery.list();
		String a = "";
		if(list.size()>0){
			a=list.get(0).toString().trim();
			Long b = Long.parseLong(a);
			Long c =b+1L;
			String d = c.toString();
			if(d.length()==8){
				a="0"+d;
			}else if(d.length()==9){
				a=d;
			}else{
				a=number.trim()+"0000001";
			}
		}else{
			a=number.trim()+"0000001";
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public TrtssProv findTrtssProvByNo(String substring) {
		String hql =" select q from TrtssProv q where q.provId='"+substring.trim()+"'";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		TrtssProv tp = null;
		if(query.list()!=null && query.list().size()>0){
			tp = (TrtssProv) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tp;
	}
	@Override
	public List<PurchaseUnit> findListByParam(String param) {
		Session session = null;
		List<PurchaseUnit> purchaseUnits= null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(PurchaseUnit.class);
			criteria.add(Restrictions.like("companyName", "%"+param+"%"));
			purchaseUnits = criteria.list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return purchaseUnits;
	}
	@Override
	public List<PurchaseUnit> findExceptPurchaseUnit(String companyOrcorporation, int first, int pagesize) {
		Session session =  null;
		List<PurchaseUnit> unitList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(PurchaseUnit.class);
			criteria.add(Restrictions.eq("reviewStatus", 2));
			if(companyOrcorporation != null && !"".equals(companyOrcorporation)){
				criteria.add(Restrictions.or(Restrictions.like("companyName", "%"+companyOrcorporation+"%"), Restrictions.like("corporation", companyOrcorporation,MatchMode.ANYWHERE)));
			}
			criteria.add(Restrictions.ne("authorizationDate", "9999-12-31"));
			criteria.add(Restrictions.sqlRestriction(" customer_number in (select customer_number  from t_purchase_units_except )"));
			criteria.addOrder(Order.desc("id"));
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			unitList = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return unitList;
	}
	@Override
	public Boolean checkName(String name) {
		Boolean flag=true;
		Session session = null;
		List<PurchaseUnit> purchaseUnits= null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(PurchaseUnit.class);
			criteria.add(Restrictions.eq("companyName", name));
			purchaseUnits = criteria.list();
			if(purchaseUnits.size() > 0){
				flag=false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return flag;
	}

}
