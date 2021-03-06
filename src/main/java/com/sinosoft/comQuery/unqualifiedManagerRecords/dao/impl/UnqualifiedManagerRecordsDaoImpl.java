package com.sinosoft.comQuery.unqualifiedManagerRecords.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.comQuery.unqualifiedManagerRecords.dao.UnqualifiedManagerRecordsDao;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.user.User;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

@Repository("UnqualifiedManagerRecordsDao")
public class UnqualifiedManagerRecordsDaoImpl extends
		GenericDaoHibernate<DrugMaintenance, Long> implements
		UnqualifiedManagerRecordsDao {
	public UnqualifiedManagerRecordsDaoImpl() {
		super(DrugMaintenance.class);
	}

	@Override
	public List<DrugFormDictionary> findList(String hql) {
		List<DrugFormDictionary> list = null;

		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	@Override
	public List<UnqualifiedManager> getPage(UnqualifiedManager um, String isfood,int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		//hql = new StringBuffer(
		//		"select t from UnqualifiedManager t ,Qualifiedmedcstore q ,QualityMidicine m  where t.batchno=q.batchproduction and t.qualifiedmedicineid = m.id  ");
		hql = new StringBuffer(
		        "select t from UnqualifiedManager t ,QualityMidicine m  where t.qualifiedmedicineid = m.id  ");
		if (um.getProcessingDate() != null
				&& !"".equals(um.getProcessingDate())) {
			// hql =new StringBuffer(
			// "select t from UnqualifiedManager t where 1=1 ");
			hql.append(" and t.shipmentdate = '" + um.getProcessingDate()
							+ "'");

		} else if (um.getQualifiedmedicineid() != null
				&& !"".equals(um.getQualifiedmedicineid())) {
			// hql =new StringBuffer(
			// "select t from UnqualifiedManager t where 1=1 ");

			hql.append(" and t.qualifiedmedicineid= "
					+ (um.getQualifiedmedicineid()));

		} else if (um.getBatchno() != null
				&& !"".equals(um.getBatchno())) {

			hql.append(" and t.batchno = '" + um.getBatchno()
					+ "'");

		}else if (isfood != null
				&& !"".equals(isfood)) {

			hql.append(" and m.isfood = '" + isfood
					+ "'");

		}

		else {
			hql = new StringBuffer("from UnqualifiedManager t where 1=1 ");
		}
		hql.append(" and len(t.batchno) >= 7 order by shipment_date desc ");
		Session session = null;
		List<UnqualifiedManager> list = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();

			for (int j = 0; j < list.size(); j++) {
				Long Qualifiedmedicineid = list.get(j).getQualifiedmedicineid();
				String batchno = list.get(j).getBatchno();
				String sql = "select t from Qualifiedmedcstore t where qualifiedmedicineid ="
						+ Qualifiedmedicineid;
				Query queryFiedmedcstore = session.createQuery(sql);

				if (queryFiedmedcstore.list() != null
						&& queryFiedmedcstore.list().size() > 0) {
					list.get(j).setQualifiedmedcstore(
							(Qualifiedmedcstore) queryFiedmedcstore.list().get(
									0));
				}

				Long userId = list.get(j).getModifierid();

				String sql3 = "select t from User t where t.id =" + userId;
				Query userlist = session.createQuery(sql3);
				// Query queryMedicine = session.createQuery(sql);
				if(userlist.list() != null && userlist.list().size()>0){
					list.get(j).setUser((User) userlist.list().get(0));
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCount(UnqualifiedManager um,String isfood) {
		StringBuffer hql = new StringBuffer("");
		//hql = new StringBuffer(
		//		"select count(*) from UnqualifiedManager t ,Qualifiedmedcstore q ,QualityMidicine m where t.batchno=q.batchproduction and t.qualifiedmedicineid = m.id ");
		hql = new StringBuffer(
		    "select count(*) from UnqualifiedManager t ,QualityMidicine m where t.qualifiedmedicineid = m.id ");
		if (um.getProcessingDate() != null
				&& !"".equals(um.getProcessingDate())) {

			hql
					.append(" and t.shipmentdate = '" + um.getProcessingDate()
							+ "'");

		} else if (um.getQualifiedmedicineid() != null
				&& !"".equals(um.getQualifiedmedicineid())) {

			hql.append(" and t.qualifiedmedicineid= "
					+ (um.getQualifiedmedicineid()));

		} else if (um.getBatchno()!= null
				&& !"".equals(um.getBatchno())) {

			hql.append(" and t.batchno = '" + um.getBatchno()
					+ "'");

		}else if (isfood != null
				&& !"".equals(isfood)) {

			hql.append(" and m.isfood = '" + isfood
					+ "'");

		}else {
			hql = new StringBuffer(
					"select count(*) from UnqualifiedManager t where 1=1 ");
		}
		hql.append(" and len(t.batchno) >= 7 ");
		Session session = null;
		String list = "0";
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.createQuery(hql.toString());
			list = query.list().get(0).toString();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return Integer.parseInt(list);
	}
}
