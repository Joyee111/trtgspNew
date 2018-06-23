package com.sinosoft.comQuery.purReturnRecord.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;

import com.sinosoft.comQuery.purReturnRecord.dao.PurReturnRecordDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;


@Repository("PurReturnRecordDao")
public class PurReturnRecordDaoImpl extends GenericDaoHibernate<PurchaseReturnBill, Long>implements PurReturnRecordDao{
	public PurReturnRecordDaoImpl() {
		super(PurchaseReturnBill.class);
	}

	@Override
	public List<PurchaseReturnBill> getPage(PurchaseReturnBill mc,String isfood, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if (mc != null
				&& !"".equals(mc.getApplicationTime())) {
			hql = new StringBuffer(
					"select t from PurchaseReturnBill t where t.reviewStatus=0 ");
			if (mc.getApplicationTime() != null
					&& !"".equals(mc.getApplicationTime())) {
				hql.append(" and t.qualityMidicine.id  ='"+ mc.getApplicationTime() + "' ");
			}
			if(mc.getPrintFlag()!=null && mc.getPrintFlag().equals("1")){
				hql.append(" and t.printFlag ='1' ");
			}else if(mc.getPrintFlag()!=null && mc.getPrintFlag().equals("0")){
				hql.append(" and t.printFlag is null ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){//此处为了简单将经用公司查询条件设置为number
				hql.append(" and t.qualityMidicine.departmentId ='"+mc.getNumber()+"'");
			}
			if(isfood!=null && !"".equals(isfood)){//此处为了简单将经用公司查询条件设置为number
				hql.append(" and t.qualityMidicine.isfood ='"+isfood+"'");
			}
		} else {
			hql = new StringBuffer(
					"from PurchaseReturnBill t where t.reviewStatus=0 ");
			
		}
		hql.append(" and len(t.batchNumber) > 7 ");
		hql.append(" order by application_time desc ");
		List<PurchaseReturnBill> list = null;
		Session session = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();
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
	public int getTotalCount(PurchaseReturnBill mc,String isfood) {
		StringBuffer hql = new StringBuffer("");
	 if(mc != null){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=0 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and t.qualityMidicine.id= '"+mc.getApplicationTime()+" ' ");
			}
			if(mc.getPrintFlag()!=null && mc.getPrintFlag().equals("1")){
				hql.append(" and t.printFlag ='1' ");
			}else  if(mc.getPrintFlag()!=null && mc.getPrintFlag().equals("0")){
				hql.append(" and t.printFlag is null ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){//此处为了简单将经用公司查询条件设置为number
				hql.append(" and t.qualityMidicine.departmentId ='"+mc.getNumber()+"'");
			}
			if(isfood!=null && !"".equals(isfood)){//此处为了简单将经用公司查询条件设置为number
				hql.append(" and t.qualityMidicine.isfood ='"+isfood+"'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=0 ");
		}
	 	hql.append(" and len(t.batchNumber) > 7 ");
	 	String list = "0";
		Session session =  null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public List<PurchaseReturnBill> getAll(String qualifiedMedicId,String department, int i,
			int pagesize) {
		List<PurchaseReturnBill> list =null;
		Session session = null;
		StringBuffer hqlBuffer = new StringBuffer("select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=0");
//		hqlBuffer.append(" and len(t.batchNumber) > 7 ");
		if(qualifiedMedicId!=null && !qualifiedMedicId.equals("")){
			hqlBuffer.append(" and t.qualityMidicine.id = :qualifiedMedicId");
		}
		if(department != null && !"".equals(department)){
			hqlBuffer.append("and t.qualityMidicine.departmentId = :department");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(qualifiedMedicId!=null && !qualifiedMedicId.equals("")){
				query.setParameter("qualifiedMedicId", qualifiedMedicId);
			}
			
			if(department != null && !"".equals(department)){
				query.setParameter("department", department);
			}
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

}
