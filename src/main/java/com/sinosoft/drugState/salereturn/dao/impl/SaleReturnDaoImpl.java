package com.sinosoft.drugState.salereturn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.salereturn.dao.SaleReturnDao;
import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

@Repository("SaleReturnDao")
public class SaleReturnDaoImpl extends GenericDaoHibernate<SaleReturnBill, Long> implements SaleReturnDao{

	public SaleReturnDaoImpl() {
		super(SaleReturnBill.class);
	}
	@Override
	public List<SaleReturnBill> getPage(SaleReturnBill mc, int i, int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from SaleReturnBill t where t.reviewStatus=0 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<SaleReturnBill> list = query.list();*/
		Session session = null;
		List<SaleReturnBill> list =null;
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
	public int getTotalCount(SaleReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=0 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from SaleReturnBill t where t.reviewStatus=0 ");
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
	public SaleReturnBill save(SaleReturnBill mc){
		SaleReturnBill mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public SaleReturnBill findById(String id) {
		/*String hql = "from SaleReturnBill t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		SaleReturnBill chn=(SaleReturnBill) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		SaleReturnBill chn = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chn = (SaleReturnBill) session.get(SaleReturnBill.class, Long.parseLong(id));
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
	public void update(SaleReturnBill mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<SaleReturnBill> getPagedsh(SaleReturnBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=1 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from SaleReturnBill t where t.reviewStatus=1 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<SaleReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<SaleReturnBill> list = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountdsh(SaleReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*)from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*)from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*)from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=1 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from SaleReturnBill t where t.reviewStatus=1 ");
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
	public List<SaleReturnBill> getPageysh(SaleReturnBill mc, int i,int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=2 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from SaleReturnBill t where t.reviewStatus=2 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<SaleReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<SaleReturnBill> list = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountysh(SaleReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=2 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from SaleReturnBill t where t.reviewStatus=2 ");
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
		String list ="0";
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
	public List<SaleReturnBill> getPageybh(SaleReturnBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select t from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=3 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "from SaleReturnBill t where t.reviewStatus=3 ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<SaleReturnBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<SaleReturnBill> list = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountybh(SaleReturnBill mc) {
		StringBuffer hql = new StringBuffer("");
		if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())&&mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q,QualityMidicine m where m.id=t.qualifiedMedicineId and q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else if(mc.getApplicationTime()!=null && !"".equals(mc.getApplicationTime())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 ");
			if(mc.getApplicationTime()==null && "".equals(mc.getApplicationTime())){
				hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			}
		}else if (mc.getNumber()!=null && !"".equals(mc.getNumber())){
			hql =new StringBuffer( "select count(*) from SaleReturnBill t,QualityMidicine m where m.id=t.qualifiedMedicineId  and t.reviewStatus=3 ");
			if(mc.getNumber()!=null && !"".equals(mc.getNumber())){
				hql.append(" and m.commonname like '%"+mc.getNumber()+"%'");
			}
		}else{
			hql =new StringBuffer( "select count(*) from SaleReturnBill t where t.reviewStatus=3 ");
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
		String list ="0";
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
		String hql = "select count(*) from ReturncheckItem t where t.returnCheckId="+id;
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		String list = query.list().get(0).toString();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		String list = "0";
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
		SaleReturnBill ch = findById(id);
		getHibernateTemplate().delete(ch);
	}
	@Override
	public QualifiedPurchaseUnits findghById(Long qualifiedPurchaseUnitsId) {
		/*String hql = "from QualifiedPurchaseUnits t where t.id="+qualifiedPurchaseUnitsId;
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		QualifiedPurchaseUnits list=new QualifiedPurchaseUnits();
		if(query.list().size()>0){
			list=(QualifiedPurchaseUnits) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		QualifiedPurchaseUnits qualifiedPurchaseUnits =null ;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
			qualifiedPurchaseUnits = (QualifiedPurchaseUnits)session.get(QualifiedPurchaseUnits.class, qualifiedPurchaseUnitsId);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		return qualifiedPurchaseUnits;
	}
}
