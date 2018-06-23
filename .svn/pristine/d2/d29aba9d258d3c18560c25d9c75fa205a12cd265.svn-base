package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualProcurementStaffAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedProcurementStaffAccessory;

@Repository("qualProcurementStaffAccessoryDao")
public class QualProcurementStaffAccessoryHibernate extends
		GenericDaoHibernate<QualifiedProcurementStaffAccessory, Long> implements QualProcurementStaffAccessoryDao {
	public QualProcurementStaffAccessoryHibernate(){
		super(QualifiedProcurementStaffAccessory.class);
	}
	@Override
	public List<QualifiedProcurementStaffAccessory> findAccessoriesListByPage(
			long proStaffId, int first, int pagesize) {
		Session session = null;
		List<QualifiedProcurementStaffAccessory> list = null;
		String hql = "from QualifiedProcurementStaffAccessory a where a.qualified_procurement_staff_id =:proStaffId order by a.modified_time DESC";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("proStaffId", proStaffId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
