package com.sinosoft.drugState.purreturn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.purreturn.dao.PurReturnDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.EntryTicket;
import com.sinosoft.util.SystemLogUtil;

@Repository("PurReturnDao")
public class PurReturnDaoImpl extends GenericDaoHibernate<PurchaseReturnBill, Long> implements PurReturnDao{
	
	
	public PurReturnDaoImpl() {
		super(PurchaseReturnBill.class);
	}

	@Override
	public List<PurchaseReturnBill> getPage(PurchaseReturnBill mc, int i, int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber()) && mc.getDepartment()!=null && !"".equals(mc.getDepartment())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
			//屏蔽批号是7位的数据
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
			if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
				hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getDepartment() != null &&!"".equals(mc.getDepartment())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
				hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
			}
		
		}else if(mc.getBatchNumber() != null &&!"".equals(mc.getBatchNumber())){
			hql = new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getBatchNumber() != null && !"".equals(mc.getBatchNumber())){
				hql.append(" and t.batchNumber ='"+mc.getBatchNumber()+"' ");
			}
		}else if(mc.getReturnTime() != null &&!"".equals(mc.getReturnTime())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getReturnTime() != null && !"".equals(mc.getReturnTime())){
				hql.append(" and t.returnTime ='"+mc.getReturnTime()+"' ");
			}
		}else{
			hql =new StringBuffer( "from PurchaseReturnBill t where t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
		}
		hql.append(" order by t.returnTime desc ");
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<PurchaseReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		List<PurchaseReturnBill> list = null;
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			 list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	public int getCount(PurchaseReturnBill mc) {
		StringBuffer hql = new StringBuffer("select count(*) from PurchaseReturnBill where number='");
		hql.append(mc.getNumber().trim());
		hql.append("'");
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}
	@Override
	public int getTotalCount(PurchaseReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber()) && mc.getDepartment()!=null && !"".equals(mc.getDepartment())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
			if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
				hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getDepartment() != null && !"".equals(mc.getDepartment())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			hql.append(" and m.departmentId ='"+mc.getDepartment()+"' ");
		
		
		}else if (mc.getBatchNumber()!=null && !"".equals(mc.getBatchNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getBatchNumber()!=null && !"".equals(mc.getBatchNumber())){
				hql.append(" and t.batchNumber = '"+mc.getBatchNumber()+"'");
			}
		}else if (mc.getReturnTime()!=null && !"".equals(mc.getReturnTime())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
			if(mc.getReturnTime()!=null && !"".equals(mc.getReturnTime())){
				hql.append(" and t.returnTime = '"+mc.getReturnTime()+"'");
			}
		
		
		}else{
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=0 ");
			hql.append(" and LEN(t.batchNumber) > 7 ");
		}
		
		
		
		
		
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}
	@Override
	public PurchaseReturnBill save(PurchaseReturnBill mc){
		PurchaseReturnBill mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public PurchaseReturnBill findById(String id) {
		/*String hql = "from PurchaseReturnBill t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		PurchaseReturnBill chn=(PurchaseReturnBill) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		PurchaseReturnBill  chn = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chn = (PurchaseReturnBill) session.get(PurchaseReturnBill.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return chn;
	}

	@Override
	public void update(PurchaseReturnBill mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<PurchaseReturnBill> getPagedsh(PurchaseReturnBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=1 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from PurchaseReturnBill t where t.reviewStatus=1 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<PurchaseReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<PurchaseReturnBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountdsh(PurchaseReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=1 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=1 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public List<PurchaseReturnBill> getPageysh(PurchaseReturnBill mc, int i,int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()!=null&& !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=2 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from PurchaseReturnBill t where t.reviewStatus=2 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<PurchaseReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<PurchaseReturnBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			 list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountysh(PurchaseReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=2 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=2 ");
		}
		
		if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}
	
	@Override
	public List<PurchaseReturnBill> getPageybh(PurchaseReturnBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=3 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from PurchaseReturnBill t where t.reviewStatus=3 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<PurchaseReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;*/
		Session session = null;
		List<PurchaseReturnBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			 list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountybh(PurchaseReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedSupplierId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()!=null&& !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualifiedPurchaseUnits q where q.id=t.qualifiedSupplierId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=3 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from PurchaseReturnBill t where t.reviewStatus=3 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public void audit(String id) {
		String sql = " update t_check_accept_note t set t.review_status=2 where id="+Long.parseLong(id);
		Connection conn=this.getHibernateTemplate().getSessionFactory().openSession().connection();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null != conn)
				conn.close();
			if(null != stm)
				stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public int findCount(Long id) {
		/*String hql = "select count(*) from ReturncheckItem t where t.returnCheckId="+id;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql = "select count(*) from ReturncheckItem t where t.returnCheckId="+id;
		Session session = null;
		String list = "0";
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			 list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(list);
	}

	@Override
	public void del(String id) {
		PurchaseReturnBill ch = findById(id);
		getHibernateTemplate().delete(ch);
	}

	@Override
	public QualifiedSuppliers findghById(Long qualifiedSupplierId) {
		/*String hql = "from QualifiedSuppliers t where t.id="+qualifiedSupplierId;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		QualifiedSuppliers list=new QualifiedSuppliers();
		if(query.list().size()>0){
			list=(QualifiedSuppliers) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		QualifiedSuppliers  qualifiedSuppliers = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			qualifiedSuppliers = (QualifiedSuppliers)session.get(QualifiedSuppliers.class, qualifiedSupplierId);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qualifiedSuppliers;
	}
	/**
	 * 根据购进退出ID查询入库单
	 */
	public List<EntryTicket> findPurchaseReturnBillById(String purchaseReturnId) {
		Session session = null;
		List<EntryTicket> list = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.ireportDTO.EntryTicket(qm.supplyUnit.customerName,pb.returnTime,cast(pb.number as string),qm.medicinalNo,qm.commonname,qm.dosageforms.formName,qm.specifications,qm.unit,cast(pb.quantity as string),pb.puMoney,pb.money,qm.licensenumber,pb.batchNumber,pb.endTime,mp.pack_rate,cast(round(cast(pb.quantity as float)/cast(mp.pack_rate as float),2) as string),qm.produceno.customerName,'',us.realname,'','','','','',us.realname,'','')");
		hqlBuffer.append(" from  PurchaseReturnBill pb ,QualityMidicine qm,User us, MedcPrice mp where 1=1 ");
		hqlBuffer.append(" and  pb.qualifiedMedicineId=qm.id and pb.user.id = us.id and  qm.medicinalNo = mp.medc_no");
		hqlBuffer.append(" and pb.id=:purchaseReturnId");
		try{
			session  = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			query.setLong("purchaseReturnId", Long.parseLong(purchaseReturnId));
			list = query.list();
		}catch (Exception e) {
			e.printStackTrace();
			SystemLogUtil.saveError(Constants.LOG_ERROR, "PurReturnDaoImpl.findPurchaseReturnBillById======="+e.getMessage());
		}
		return list;
	}

}
