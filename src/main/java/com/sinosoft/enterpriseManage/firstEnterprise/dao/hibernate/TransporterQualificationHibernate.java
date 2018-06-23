package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.TransporterQualificationDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
@Repository("transportterQualificationDao")
public class TransporterQualificationHibernate extends
		GenericDaoHibernate<TransporterQualification,Long> implements TransporterQualificationDao {
	public TransporterQualificationHibernate(){
		super(TransporterQualification.class);
	}
	@Override
	public List<TransporterQualification> findTransporterQualificationList(
			int first, int pagesize) {
		Session session = null;
		List<TransporterQualification> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TransporterQualification.class);
//			criteria.add(Restrictions.eq("deleteFlag", "1"));  //为显示启用停用
			criteria.add(Restrictions.isNotNull("businessLicense"));
			criteria.addOrder(Order.desc("id"));
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
	public List<TransporterQualification> queryTransporterQualificationList(String query_cysmc,String query_htmc,int first,int pagesize) {
		Session session = null;
		List<TransporterQualification> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(TransporterQualification.class);
//			if(query_cysmc!=null && query_htmc!=null &&!"".equals(query_cysmc.trim())&&!"".equals(query_htmc.trim())  ){
//				criteria.add(Restrictions.or(Restrictions.like("transporterName", "%"+query_cysmc+"%"),Restrictions.like("contractName", "%"+query_htmc+"%")));
//			}else if(query_cysmc!=null && (query_htmc==null||"".equals(query_htmc))){
//				criteria.add(Restrictions.eq("transporterName", query_cysmc));
//			}else if(query_htmc!=null &&( query_cysmc==null||"".equals(query_cysmc.trim()))){
//				criteria.add(Restrictions.eq("contractName", query_htmc));
//			}
			if(query_cysmc != null && !"".equals(query_cysmc)){
				criteria.add(Restrictions.like("transporterName", "%"+query_cysmc+"%"));
			}
			if(query_htmc!=null && !"".equals(query_htmc)){
				criteria.add(Restrictions.like("contractName", "%"+query_htmc+"%"));
			}
//			criteria.add(Restrictions.eq("deleteFlag", "1"));
			criteria.add(Restrictions.isNotNull("businessLicense"));
			criteria.addOrder(Order.desc("id"));
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

}
