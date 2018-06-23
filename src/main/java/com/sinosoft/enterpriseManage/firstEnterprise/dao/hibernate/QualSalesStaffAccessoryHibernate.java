package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSalesStaffAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSalesStaffAccessory;

@Repository("qualSalesStaffAccessoryDao")
public class QualSalesStaffAccessoryHibernate extends
		GenericDaoHibernate<QualifiedSalesStaffAccessory, Long> implements QualSalesStaffAccessoryDao {
	public QualSalesStaffAccessoryHibernate(){
		super(QualifiedSalesStaffAccessory.class);
	}
	@Override
	public List<QualifiedSalesStaffAccessory> findAccessoriesListByPage(
			long salesStaffId, int first, int pagesize) {
		Session session = null;
		List<QualifiedSalesStaffAccessory> list = null;
		String hql = "from QualifiedSalesStaffAccessory a where a.qualified_sales_staff_id =:salesStaffId order by a.modified_time DESC";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("salesStaffId", salesStaffId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
