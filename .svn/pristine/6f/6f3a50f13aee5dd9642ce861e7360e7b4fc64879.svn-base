package com.sinosoft.drugState.acceptance.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.acceptance.dao.AcceptanceDao;
import com.sinosoft.drugState.acceptance.model.CheckAcceptNote;
import com.sinosoft.drugState.acceptance.model.CheckAcceptVO;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
@Repository("AcceptanceDao")
public class AcceptanceDaoImpl extends GenericDaoHibernate<CheckAcceptNote, Long> implements AcceptanceDao{

	public AcceptanceDaoImpl() {
		super(CheckAcceptNote.class);
	}

	@Override
	public List<CheckAcceptVO> getPage(String date ,String customerName,String type, int i, int pagesize) {
		StringBuffer hql = new StringBuffer("select new com.sinosoft.drugState.acceptance.model.CheckAcceptVO(cn,ci,u) from CheckAcceptNote cn ,");
		hql.append(" CheckacceptItem ci,User u where 1=1 and cn.id = ci.receivingId  and  cn.proposerID = u.id " );
		if(date!=null && !"".equals(date)){
			hql.append(" and cn.checkAcceptDate =:checkAcceptDate ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hql.append(" and cn.qualifiedSupplierIds.customerName like :customerName ");
		}
		hql.append(" and cn.reviewStatus =:type ");
		hql.append(" order by cn.number DESC  ");
		Session session =  null;
		List<CheckAcceptVO> chList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("checkAcceptDate", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			query.setParameter("type", Integer.parseInt(type));
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			chList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return chList;
	}
	
	@Override
	public int getTotalCount(CheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=0 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select count(*) from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=0 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=0 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		String list = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null )
				session.close();
		}
		return Integer.parseInt(list);
	}
	@Override
	public CheckAcceptNote save(CheckAcceptNote mc){
		CheckAcceptNote mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public CheckAcceptNote findById(String id) {
//		String hql = "from CheckAcceptNote t where t.id="+Long.parseLong(id);
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		CheckAcceptNote chn = new CheckAcceptNote();
//		if(query.list()!=null){
//			chn=(CheckAcceptNote) query.list().get(0);
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		CheckAcceptNote  chAcceptNote = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			chAcceptNote = (CheckAcceptNote)session.get(CheckAcceptNote.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return chAcceptNote;
	}

	@Override
	public void update(CheckAcceptNote mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<CheckAcceptNote> getPagedsh(CheckAcceptNote mc, int i,
			int pagesize) {
		
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=1 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select t from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=1 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=1 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		query.setFirstResult(i);
//		query.setMaxResults(pagesize);
//		@SuppressWarnings("unchecked")
//		List<CheckAcceptNote> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<CheckAcceptNote> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountdsh(CheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=1 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select count(*) from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=1 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=1 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		String list = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			list = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}


		return Integer.parseInt(list);
	}

	@Override
	public List<CheckacceptItem> find(String id) {
		String hql = "from CheckacceptItem t where t.receivingId="+Long.parseLong(id);
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		@SuppressWarnings("unchecked")
//		List<CheckacceptItem> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
		Session session = null;
		List<CheckacceptItem> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public List<CheckAcceptNote> getPageysh(CheckAcceptNote mc, int i,int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=0 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select t from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=2 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=2 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		query.setFirstResult(i);
//		query.setMaxResults(pagesize);
//		@SuppressWarnings("unchecked")
//		List<CheckAcceptNote> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<CheckAcceptNote> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountysh(CheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=2 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select count(*) from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=2 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=2 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		String list = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			list  = query.list().get(0).toString();
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
	public List<CheckAcceptNote> getPageybh(CheckAcceptNote mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=3 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select t from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=3 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("from CheckAcceptNote t  where t.reviewStatus=3 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		query.setFirstResult(i);
//		query.setMaxResults(pagesize);
//		@SuppressWarnings("unchecked")
//		List<CheckAcceptNote> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<CheckAcceptNote> list =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountybh(CheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc!=null){
			if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
				hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=3 " );
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}else{
				hql=new StringBuffer("select count(*) from CheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedSupplierId and t.reviewStatus=3 " );
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
				if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
					hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
				}
			}
		}else{
			hql=new StringBuffer("select count(*) from CheckAcceptNote t  where t.reviewStatus=3 " );
		}
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql.toString());
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		String list = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
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
	public List<CheckacceptItem> findYp(Long id) {
		String hql = "select t from CheckacceptItem t where receivingId ="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<CheckacceptItem> list= query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<CheckacceptItem> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list= query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}

	@Override
	public List<?> findAllId(Long id) {
		String hql = "select t.id from CheckacceptItem t where receivingId ="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		List<?> list= query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		List<?> list =null;
		try{
			 session = this.getHibernateTemplate().getSessionFactory().openSession();
			 Query query = session.createQuery(hql);
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
	public List<CheckacceptItem> find(Long id, int i, int pagesize) {
		String hql = "from CheckacceptItem t where t.receivingId="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		query.setFirstResult(i);
//		query.setMaxResults(pagesize);
//		@SuppressWarnings("unchecked")
//		List<CheckacceptItem> list = query.list();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Session session = null;
		List<CheckacceptItem> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			 list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int findCount(Long id) {
		String hql = "select count(*) from CheckacceptItem t where t.receivingId="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		String list = query.list().get(0).toString();
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Session session = null;
		String list = "0";
		try{ 
			session =this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
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
	public void del(String id) {
		CheckAcceptNote ch = findById(id);
		getHibernateTemplate().delete(ch);
	}

	@Override
	public QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId) {
		
//		String hql = "from QualifiedPurchaseUnits t where t.id="+qualifiedSupplierId;
		Session session = null;
		QualifiedPurchaseUnits list= null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			list = (QualifiedPurchaseUnits)session.get(QualifiedPurchaseUnits.class, qualifiedSupplierId);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
	
		
//		try {
//			list = (QualifiedPurchaseUnits) query.list().get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return list;
	}

	@Override
	public QualifiedSuppliers findgonghuo(Long qualifiedSupplierId) {
//		String hql = "from QualifiedSuppliers t where t.id="+qualifiedSupplierId;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		QualifiedSuppliers list = new QualifiedSuppliers();
//		try {
//			list = (QualifiedSuppliers) query.list().get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Session session = null;
		QualifiedSuppliers list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			list = (QualifiedSuppliers)session.get(QualifiedSuppliers.class, qualifiedSupplierId);
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
	public int countTotalPage(String date, String customerName, String type) {
			StringBuffer hql = new StringBuffer("select count(*) from CheckAcceptNote cn ,");
			hql.append(" CheckacceptItem ci,User u where 1=1 and cn.id = ci.receivingId  and  cn.proposerID = u.id  " );
			if(date!=null && !"".equals(date)){
				hql.append(" and cn.checkAcceptDate =:checkAcceptDate ");
			}
			if(customerName!=null && !"".equals(customerName)){
				hql.append(" and cn.qualifiedSupplierIds.customerName like :customerName ");
			}
			hql.append(" and cn.reviewStatus =:type ");
			Session session =  null;
			String count = "0";
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createQuery(hql.toString());
				if(date!=null && !"".equals(date)){
					query.setParameter("checkAcceptDate", date);
				}
				if(customerName!=null && !"".equals(customerName)){
					query.setParameter("customerName", "%"+customerName+"%");
				}
				query.setParameter("type", Integer.parseInt(type));
				count = query.list().get(0).toString();
			}catch (RuntimeException e) {
				e.printStackTrace();
				throw e;
			}finally{
				if(session!=null)
					session.close();
			}
			return Integer.parseInt(count);
	
	}

	@Override
	public List<CheckAcceptVO> getPageByType3(String date ,String customerName,String type,String drugsType, int i, int pagesize) {
		StringBuffer hql = new StringBuffer("select new com.sinosoft.drugState.acceptance.model.CheckAcceptVO(cn,ci,u) from CheckAcceptNote cn ,");
		hql.append(" CheckacceptItem ci,User u where 1=1 and cn.id = ci.receivingId  and  cn.proposerID = u.id " );
		if(date!=null && !"".equals(date)){
			hql.append(" and cn.checkAcceptDate =:checkAcceptDate ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hql.append(" and cn.qualifiedSupplierIds.customerName like :customerName ");
		}
		hql.append(" and cn.reviewStatus =:type ");
		if(drugsType!=null && !drugsType.trim().equals("")){
			hql.append(" and ci.qualityMidicine.medicineManagement = :drugsType ");
		}
		//屏蔽单据号YP和T开头的以及数量为负数的数据
		hql.append(" and ci.quantity > 0 and cn.number not like 'YP%' and cn.number not like 'T%' ");
		hql.append(" and ci.qualityMidicine.id not in (select tqm.id from QualifiedMedcJH jh, QualityMidicine tqm where jh.medicNo = tqm.medicinalNo) ");
		hql.append(" and len(ci.batchProduction) > 7 ");
		hql.append(" order by cn.checkAcceptDate DESC  ");
		Session session =  null;
		List<CheckAcceptVO> chList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = null;
			query = session.createQuery(hql.toString());
			
			if(date!=null && !"".equals(date)){
				query.setParameter("checkAcceptDate", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			query.setParameter("type", Integer.parseInt(type));
			if(drugsType!=null && !"".equals(drugsType.trim())){
				query.setParameter("drugsType", drugsType.trim());
			}
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			chList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return chList;
	}
	
	
	@Override
	public int countTotalPageByType3(String date, String customerName, String type,String drugsType) {
			StringBuffer hql = new StringBuffer("select count(*) from CheckAcceptNote cn ,");
			hql.append(" CheckacceptItem ci,User u where 1=1 and cn.id = ci.receivingId  and  cn.proposerID = u.id  " );
			if(date!=null && !"".equals(date)){
				hql.append(" and cn.checkAcceptDate =:checkAcceptDate ");
			}
			if(customerName!=null && !"".equals(customerName)){
				hql.append(" and cn.qualifiedSupplierIds.customerName like :customerName ");
			}
			hql.append(" and cn.reviewStatus =:type ");
			if(drugsType!=null && !drugsType.trim().equals("")){
				hql.append(" and ci.qualityMidicine.medicineManagement = :drugsType");
			}
			hql.append(" and ci.quantity > 0 and cn.number not like 'YP%' and cn.number not like 'T%' ");
			hql.append(" and ci.qualityMidicine.id not in (select tqm.id from QualifiedMedcJH jh, QualityMidicine tqm where jh.medicNo = tqm.medicinalNo) ");
			hql.append(" and len(ci.batchProduction) > 7 ");
			Session session =  null;
			String count = "0";
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				Query query = session.createQuery(hql.toString());
				if(date!=null && !"".equals(date)){
					query.setParameter("checkAcceptDate", date);
				}
				if(customerName!=null && !"".equals(customerName)){
					query.setParameter("customerName", "%"+customerName+"%");
				}
				
				query.setParameter("type", Integer.parseInt(type));
				if(drugsType!=null && !"".equals(drugsType.trim())){
					query.setParameter("drugsType", drugsType.trim());
				}
				count = query.list().get(0).toString();
			}catch (RuntimeException e) {
				e.printStackTrace();
				throw e;
			}finally{
				if(session!=null)
					session.close();
			}
			return Integer.parseInt(count);
	
	}
	

}
