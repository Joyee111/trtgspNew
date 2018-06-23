package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.CommissionedStorageUnitQualificationAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.CommissionedStorageUnitQualificationAccessory;

@Repository("commissionedStorageUnitQualificationAccessoryDao")
public class CommissionedStorageUnitQualificationAccessoryHibernate extends GenericDaoHibernate<CommissionedStorageUnitQualificationAccessory, Long>
		implements CommissionedStorageUnitQualificationAccessoryDao {
	public CommissionedStorageUnitQualificationAccessoryHibernate(){
		super(CommissionedStorageUnitQualificationAccessory.class);
	}

	@Override
	public List<CommissionedStorageUnitQualificationAccessory> findAccessoriesListByPage(
			long csuqId, int first, int pagesize) {
		Session session = null;
		List<CommissionedStorageUnitQualificationAccessory> list = null;
		String hql = "from CommissionedStorageUnitQualificationAccessory a where a.csuqId =:csuqId order by a.modified_time DESC";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("csuqId", csuqId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
}
