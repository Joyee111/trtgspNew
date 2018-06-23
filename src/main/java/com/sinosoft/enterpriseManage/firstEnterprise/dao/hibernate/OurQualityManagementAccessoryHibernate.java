package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.OurQualityManagementAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.OurQualityManagementAccessory;

@Repository("ourQualityManagementHibernateDao")
public class OurQualityManagementAccessoryHibernate extends GenericDaoHibernate<OurQualityManagementAccessory, Long>
		implements OurQualityManagementAccessoryDao {
	public OurQualityManagementAccessoryHibernate(){
		super(OurQualityManagementAccessory.class);
	}

	@Override
	public List<OurQualityManagementAccessory> findAccessoriesListByPage(
			long companyQualityManagementId, int first, int pagesize) {
		Session session = null;
		List<OurQualityManagementAccessory> list = null;
		String hql = "from OurQualityManagementAccessory a where a.company_quality_management_id =:companyQualityManagementId order by a.modified_time DESC";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("companyQualityManagementId", companyQualityManagementId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
}
