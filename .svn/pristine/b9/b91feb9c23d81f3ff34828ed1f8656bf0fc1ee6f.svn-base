package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.CommissionedStorageUnitQualificationDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualification;

/**
 * @author cbl:
 * @version 创建时间：Dec 1, 2014 11:13:57 AM
 * 类说明
 * CommissionedStorageUnitQualification类的Dao包
 */
@Repository("commissionedStorageUnitQualificationDao")
public class CommissionedStorageUnitQualificationHibernate extends GenericDaoHibernate<CommissionedStorageUnitQualification, Long>
		implements CommissionedStorageUnitQualificationDao {

	
	public CommissionedStorageUnitQualificationHibernate(){
		super(CommissionedStorageUnitQualification.class);
	}

	@Override
	public int countRecordByCondition(String sql) {
		// TODO Auto-generated method stub
		return getRecordCount(sql);
	}

	

	@Override
	public List<CommissionedStorageUnitQualification> findListByPage(String hql, int first,
			int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		return findListByaPage(hql,map,first,pagesize);
	}

	@Override
	public List<CommissionedStorageUnitQualification> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		Session session =null;
		List<CommissionedStorageUnitQualification> csuqList = null;
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
			csuqList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return csuqList;
	}

	@Override
	public List<CommissionedStorageUnitQualification> findList(String hql) {
		List<CommissionedStorageUnitQualification> list = null;
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
	
	
	
	
}