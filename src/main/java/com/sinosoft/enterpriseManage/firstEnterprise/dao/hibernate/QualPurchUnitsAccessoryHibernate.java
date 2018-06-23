package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualPurchUnitsAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnitsAccessory;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 3:18:43 PM
 * 类说明
 */
@Repository("qualPurchUnitsAccessoryDao")
public class QualPurchUnitsAccessoryHibernate extends
		GenericDaoHibernate<QualifiedPurchaseUnitsAccessory, Long> implements QualPurchUnitsAccessoryDao {
	public QualPurchUnitsAccessoryHibernate(){
		super(QualifiedPurchaseUnitsAccessory.class);
	}
	@Override
	public List<QualifiedPurchaseUnitsAccessory> findAccessoriesListByPage(
			long qualUtisId, int first, int pagesize) {
		Session session = null;
		List<QualifiedPurchaseUnitsAccessory> list = null;
		String hql = "from QualifiedPurchaseUnitsAccessory a where a.qualified_purchase_units_id =:qualUtisId order by a.modified_time DESC";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("qualUtisId", qualUtisId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
