package com.sinosoft.drugState.accepreturn.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.accepreturn.dao.ReturnTaceDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
@Repository("ReturnTaceDao")
public class ReturnTaceDaoImpl extends GenericDaoHibernate<ReturnCheckAcceptNote,Long> implements ReturnTaceDao{

	public ReturnTaceDaoImpl() {
		super(ReturnCheckAcceptNote.class);
	}
	@Override
	public List<ReturnCheckAcceptNote> getPage(ReturnCheckAcceptNote mc, int i, int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from ReturnCheckAcceptNote t  where t.reviewStatus=0 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select t from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		List<ReturnCheckAcceptNote> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCount(ReturnCheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t  where t.reviewStatus=0 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=0 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		String list = "0";
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
	public ReturnCheckAcceptNote save(ReturnCheckAcceptNote mc){
		ReturnCheckAcceptNote mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public ReturnCheckAcceptNote findById(String id) {
		Session session = null;
		ReturnCheckAcceptNote returnCheckAcceptNote = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			returnCheckAcceptNote = (ReturnCheckAcceptNote)session.get(ReturnCheckAcceptNote.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		return returnCheckAcceptNote;
	}

	@Override
	public void update(ReturnCheckAcceptNote mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<ReturnCheckAcceptNote> getPagedsh(ReturnCheckAcceptNote mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from ReturnCheckAcceptNote t  where t.reviewStatus=1 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select t from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		List<ReturnCheckAcceptNote> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountdsh(ReturnCheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t  where t.reviewStatus=1 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=1 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		String list = "0";
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
	public List<ReturncheckItem> find(String id) {
		String hql = "from ReturncheckItem t where t.returnCheckId="+Long.parseLong(id);
		Session session =  null;
		List<ReturncheckItem> list =null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		list  = query.list();
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
	public List<ReturnCheckAcceptNote> getPageysh(ReturnCheckAcceptNote mc, int i,int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from ReturnCheckAcceptNote t  where t.reviewStatus=2 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select t from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		List<ReturnCheckAcceptNote> list= null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountysh(ReturnCheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t  where t.reviewStatus=2 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=2 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		String list = "0";
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
	public List<ReturnCheckAcceptNote> getPageybh(ReturnCheckAcceptNote mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from ReturnCheckAcceptNote t  where t.reviewStatus=3 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select t from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		List<ReturnCheckAcceptNote> list = null;
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
	public int getTotalCountybh(ReturnCheckAcceptNote mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t  where t.reviewStatus=3 " );
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}else{
			hql=new StringBuffer("select count(*) from ReturnCheckAcceptNote t,QualifiedSuppliers q where q.id=t.qualifiedPurchaseUnitsId and t.reviewStatus=3 " );
			hql.append(" and q.customerName like '%"+mc.getApplicationTime()+"%' ");
			if(mc.getArrivalDate()!=null && !"".equals(mc.getArrivalDate())){
				hql.append(" and t.checkAcceptDate like '%"+mc.getArrivalDate()+"%'");
			}
		}
		Session session = null;
		String list = "0";
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
	public List<ReturncheckItem> findYp(Long id) {
		String hql = "select t from ReturncheckItem t where returnCheckId ="+id;
		Session session = null;
		List<ReturncheckItem> list = null;
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
		String hql = "select t.id from ReturncheckItem t where returnCheckId ="+id;
		Session session = null;
		List<?> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
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
	public List<ReturncheckItem> find(Long id, int i, int pagesize) {
		Session session = null;
		 List<ReturncheckItem> list = null;
		try{
			String hql = "from ReturncheckItem t where t.returnCheckId=:returnCheckId"; 
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("returnCheckId", id);
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
		Session session = null;
		int count = 0;
		try{
			String hql = "select count(*) from ReturncheckItem t where t.returnCheckId=:returnCheckId";
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("returnCheckId", id);
			if(query.list()!=null && query.list().size()>0)
				count  = Integer.parseInt(query.list().get(0).toString());
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return count;
	}

	@Override
	public void del(String id) {
		ReturnCheckAcceptNote ch = findById(id);
		getHibernateTemplate().delete(ch);
	}
	@Override
	public List<ReturnReceivingNote> findthdJson() {
		
		List<ReturnReceivingNote> list = null;
		Session session =  null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			String hql = "select a from ReturnReceivingNote a,ReturnReceivingNoteItem b where 1=1 " +
					" and a.id = b.receivingNoteId and a.returnNumber!='000000' and a.returnNumber not in (select b.returnNo from  ReturnCheckAcceptNote b ) " +
					" and len(b.batchProduction) > 7 "; 
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
	public List<ReturnReceivingNoteItem> findthd(String id) {
		String hql = "from ReturnReceivingNoteItem t where t.receivingNoteId="+Long.parseLong(id);
		Session session = null;
		List<ReturnReceivingNoteItem> list = null;
		try{
			session =  this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		
		return list;
	}
	@Override
	public List<ReturnCheckAcceptNote> getReturnCheckAcceptNoteByCondition(
			String date, String customerName, String status, int first,
			int pagesize) {
		List<ReturnCheckAcceptNote> checkAcceptNotes = null;
		Session session = null;
		DetachedCriteria deCriteria = DetachedCriteria.forClass(ReturnCheckAcceptNote.class);
		if(date!=null && !"".equals(date)){
			deCriteria.add(Restrictions.eq("checkAcceptDate", date));
		}
		if(customerName!=null && !"".equals(customerName)){
			deCriteria.add(Restrictions.like("qualifiedPurchaseUnits.customerName", "%"+customerName+"%"));
		}
		if(status!=null && !"".equals(status)){
			deCriteria.add(Restrictions.eq("reviewStatus", Long.parseLong(status)));
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = deCriteria.getExecutableCriteria(session);
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			checkAcceptNotes = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		// TODO Auto-generated method stub
		return checkAcceptNotes;
	}
	@Override
	public int countReturnCheckAcceptNoteByConiction(String date,
			String customerName, String status) {
		List<ReturnCheckAcceptNote> checkAcceptNotes = null;
		Session session = null;
		DetachedCriteria deCriteria = DetachedCriteria.forClass(ReturnCheckAcceptNote.class);
		if(date!=null && !"".equals(date)){
			deCriteria.add(Restrictions.eq("checkAcceptDate", date));
		}
		if(customerName!=null && !"".equals(customerName)){
			deCriteria.add(Restrictions.like("qualifiedPurchaseUnits.customerName", "%"+customerName+"%"));
		}
		if(status!=null && !"".equals(status)){
			deCriteria.add(Restrictions.eq("reviewStatus", Long.parseLong(status)));
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = deCriteria.getExecutableCriteria(session);
			checkAcceptNotes = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		// TODO Auto-generated method stub
		return (checkAcceptNotes!=null)?checkAcceptNotes.size():0;
	}
	@Override
	public int countReturnCheckAcceptNoteVOByConiction(String date,
			String customerName, String status) {
		Session session = null;
		String list = "0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from  ReturnCheckAcceptNote cn ,ReturncheckItem ci");
		hqlBuffer.append(" where ci.returnCheckId = cn.id  ");
		if(!"5".equals(status)){
			hqlBuffer.append(" and cn.reviewStatus=:status ");
		}
		if("5".equals(status)){
			hqlBuffer.append(" and cn.rollback = '1' ");
				
		}
		if(date!=null && !"".equals(date)){
			if("2".equals(status)){
				hqlBuffer.append(" and cn.reviewTime = :date ");
			}else{
				hqlBuffer.append(" and cn.checkAcceptDate = :date ");
			}
			
//			hqlBuffer.append(" and cn.checkAcceptDate =:date ");
		}
		if(customerName!=null && !"".equals(customerName)){
			hqlBuffer.append(" and  cn.qualifiedPurchaseUnits.customerName like :customerName ");
		}
		hqlBuffer.append(" and len(ci.batchProduction) > 7 ");
	//	hqlBuffer.append(" order by cn.id DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			
			if(!"5".equals(status)){
				query.setParameter("status", Long.parseLong(status));
			}
			list =query.list().get(0).toString();
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
	public List<ReturnCheckAcceptNoteVO> getReturnCheckAcceptNoteVOByCondition(
			String date, String customerName, String status, int first,
			int pagesize) {
		Session session = null;
		List<ReturnCheckAcceptNoteVO> list = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO(cn,ci) from  ReturnCheckAcceptNote cn ,ReturncheckItem ci");
		hqlBuffer.append(" where ci.returnCheckId = cn.id ");
		
		//if(!"5".equals(status)){
			hqlBuffer.append("   and cn.reviewStatus=:status  ");
		//}
		//if("5".equals(status)){
		//	hqlBuffer.append(" and cn.rollback = '1' ");
			
		//}
		if(date!=null && !"".equals(date)){
			//已复检  复检日期
			if("2".equals(status)){
				hqlBuffer.append(" and cn.reviewTime = :date ");
			}else{
				hqlBuffer.append(" and cn.checkAcceptDate = :date ");
			}
			
		}
		if(customerName!=null && !"".equals(customerName)){
			hqlBuffer.append(" and  cn.qualifiedPurchaseUnits.customerName like :customerName ");
		}
		hqlBuffer.append(" and len(ci.batchProduction) > 7 ");
		hqlBuffer.append(" order by cn.id DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(date!=null && !"".equals(date)){
				query.setParameter("date", date);
			}
			if(customerName!=null && !"".equals(customerName)){
				query.setParameter("customerName", "%"+customerName+"%");
			}
			if(status!=null && !"".equals(status.trim())){
				query.setParameter("status", Long.parseLong(status));
			}
			
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			list =query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	
	
}
