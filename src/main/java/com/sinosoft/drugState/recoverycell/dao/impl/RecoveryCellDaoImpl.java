package com.sinosoft.drugState.recoverycell.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.recoverycell.dao.RecoveryCellDao;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;
@Repository("RecoveryCellDao")
public class RecoveryCellDaoImpl extends GenericDaoHibernate<RecoverySaleBill, Long> implements RecoveryCellDao{

	public RecoveryCellDaoImpl() {
		super(RecoverySaleBill.class);
	}
	
	@Override
	public List<RecoverySaleBill> getPage(RecoverySaleBill mc, int i, int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from RecoverySaleBill t  where t.reviewStatus=0 " );
		}else{
			hql=new StringBuffer("select t from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=0 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<RecoverySaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<RecoverySaleBill> list = null;
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
	public int getTotalCount(RecoverySaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from RecoverySaleBill t  where t.reviewStatus=0 " );
		}else{
			hql=new StringBuffer("select count(*) from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=0 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
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
	public RecoverySaleBill save(RecoverySaleBill mc){
		RecoverySaleBill mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public RecoverySaleBill findById(String id) {
		/*String hql = "from RecoverySaleBill t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		RecoverySaleBill chn=(RecoverySaleBill) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//String hql = "from RecoverySaleBill t where t.id="+Long.parseLong(id);
		Session session = null;
		RecoverySaleBill chn = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			chn = (RecoverySaleBill) session.get(RecoverySaleBill.class, Long.parseLong(id));
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
	public void update(RecoverySaleBill mc) {
		this.getHibernateTemplate().saveOrUpdate(mc);
	}

	@Override
	public List<RecoverySaleBill> getPagedsh(RecoverySaleBill mc, int i,
			int pagesize) {
		
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from RecoverySaleBill t  where t.reviewStatus=1 " );
		}else{
			hql=new StringBuffer("select t from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=1 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<RecoverySaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<RecoverySaleBill> list = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql.toString());
			query.setFirstResult(i);
			query.setMaxResults(pagesize);
			 list = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}

	@Override
	public int getTotalCountdsh(RecoverySaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from RecoverySaleBill t  where t.reviewStatus=1 " );
		}else{
			hql=new StringBuffer("select count(*) from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=1 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
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
	public List<RecoverySaleBill> getPageysh(RecoverySaleBill mc, int i,int pagesize) {
		
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from RecoverySaleBill t  where t.reviewStatus=2 " );
		}else{
			hql=new StringBuffer("select t from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=2 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<RecoverySaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<RecoverySaleBill> list = null;
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
	public int getTotalCountysh(RecoverySaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from RecoverySaleBill t  where t.reviewStatus=2 " );
		}else{
			hql=new StringBuffer("select count(*) from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=2 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
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
	public List<RecoverySaleBill> getPageybh(RecoverySaleBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from RecoverySaleBill t  where t.reviewStatus=3 " );
		}else{
			hql=new StringBuffer("select t from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=3 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<RecoverySaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<RecoverySaleBill> list = null;
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
	public int getTotalCountybh(RecoverySaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from RecoverySaleBill t  where t.reviewStatus=3 " );
		}else{
			hql=new StringBuffer("select count(*) from RecoverySaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=3 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
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
		String hql = "select count(*) from ReturncheckItem t where t.returnCheckId=:id";
		Session session = null;
		String list ="0";
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
		RecoverySaleBill ch = findById(id);
		getHibernateTemplate().delete(ch);
	}

	@Override
	public List<QualityMidicine> findypJsonqy() {
		String sql ="select distinct m.id,m.medc_no,m.common_name from t_unqualified_medc_store s left join t_qualified_medicine m on s.qualified_medicine_id=m.id and s.quantity>0";
		Session session = null;
		List<?> list = null;;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			 list = sqlQuery.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		List<QualityMidicine> mqs = new ArrayList<QualityMidicine>();
		
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				QualityMidicine mq = new QualityMidicine();
				Object[] obj = (Object[]) list.get(i);
				if(obj[0]!=null && !"".equals(obj[0].toString())){
					mq.setId(Long.parseLong(obj[0].toString()));
				}
				if(obj[1]!=null && !"".equals(obj[1].toString())){
					mq.setMedicinalNo(obj[1].toString());
				}
				if(obj[2]!=null && !"".equals(obj[2].toString())){
					mq.setCommonname(obj[2].toString());
				}
				mqs.add(mq);
			}
		}
		return mqs;
	}

	@Override
	public List<Unqualifiedmedcstore> findypJsonqyById(String id) {
		String hql =" from Unqualifiedmedcstore q where q.qualifiedmedicineid= "+Long.parseLong(id);
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<Unqualifiedmedcstore> listqm = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<Unqualifiedmedcstore> listqm = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			 listqm = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return listqm;
	}

	@Override
	public int countRecoverCellByCondication(String commonName, String status) {
		Session session = null;
		String count ="0";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from RecoverySaleBill r,QualityMidicine q where r.qualifiedMedicineId = q.id and r.reviewStatus=:status "); 
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.commonname like :commonName ");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setParameter("status", Long.parseLong(status));
			
			count  = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return Integer.parseInt(count);
	}

	@Override
	public List<RecoverySaleBillVO> getRecoverCellByCondication(
			String commonName, String status, int first, int pageseize) {
		Session session = null;
		List<RecoverySaleBillVO>  recoverySaleBillVOList = null;
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO(r,q) from RecoverySaleBill r,QualityMidicine q where r.qualifiedMedicineId = q.id and r.reviewStatus=:status "); 
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.commonname like :commonName ");
		}
		hqlBuffer.append(" order by r.id DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setParameter("status", Long.parseLong(status));
			query.setFirstResult(first);
			query.setMaxResults(pageseize);
			recoverySaleBillVOList = query.list();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return recoverySaleBillVOList;
	}
}
