package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;


import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.TransporterQualificationRecordsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualificationRecords;
@Repository("tranQuaRecordsDao")
public class TransporterQualificationRecordsHibernate extends
		GenericDaoHibernate<TransporterQualificationRecords, Long> implements
		TransporterQualificationRecordsDao {
	public TransporterQualificationRecordsHibernate(){
		super(TransporterQualificationRecords.class);
	}

	@Override
	public List<TransporterQualificationRecords> getTransporterQualificationRecords(
			Long id, int firtst, int pagesize ) {
		String hql = "select a from TransporterQualificationRecords a  where a.tranQuaId = :id";
		List<TransporterQualificationRecords> list = null;
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.setFirstResult(firtst);
			query.setMaxResults(pagesize);
			list  = query.list();
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
