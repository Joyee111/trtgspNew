package com.sinosoft.drugState.stopcell.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.stopcell.dao.StopCellDao;
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
@Repository("StopCellDao")
public class StopCellDaoImpl extends GenericDaoHibernate<StopSaleBill, Long> implements  StopCellDao{

	public StopCellDaoImpl() {
		super(StopSaleBill.class);
	}

	@Override
	public List<StopSaleBill> getPage(StopSaleBill mc, int i, int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from StopSaleBill t  where t.reviewStatus=0 " );
		}else{
			hql=new StringBuffer("select t from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=0 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<StopSaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<StopSaleBill> list = null;
		try{
			session=this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCount(StopSaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from StopSaleBill t  where t.reviewStatus=0 " );
		}else{
			hql=new StringBuffer("select count(*) from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=0 " );
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
	public StopSaleBill save(StopSaleBill mc){
		StopSaleBill mcs =getHibernateTemplate().merge(mc);
		return mcs;
		
	}

	@Override
	public StopSaleBill findById(String id) {
		/*String hql = "from StopSaleBill t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		StopSaleBill chn = new StopSaleBill();
		if(query.list()!=null){
			chn=(StopSaleBill) query.list().get(0);
		}
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session =  null;
		StopSaleBill chn = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
			chn = (StopSaleBill) session.get(StopSaleBill.class, Long.parseLong(id));
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
	public void update(StopSaleBill mc) {
		this.getHibernateTemplate().update(mc);
	}

	@Override
	public List<StopSaleBill> getPagedsh(StopSaleBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from StopSaleBill t  where t.reviewStatus=1 " );
		}else{
			hql=new StringBuffer("select t from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=1 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<StopSaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<StopSaleBill> list = null;
		try{
			session=this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int getTotalCountdsh(StopSaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from StopSaleBill t  where t.reviewStatus=1 " );
		}else{
			hql=new StringBuffer("select count(*) from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=1 " );
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
	public List<StopSaleBill> getPageysh(StopSaleBill mc, int i,int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from StopSaleBill t  where t.reviewStatus=2 " );
		}else{
			hql=new StringBuffer("select t from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=2 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<StopSaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<StopSaleBill> list = null;
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
	public int getTotalCountysh(StopSaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from StopSaleBill t  where t.reviewStatus=2 " );
		}else{
			hql=new StringBuffer("select count(*) from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=2 " );
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
	public List<StopSaleBill> getPageybh(StopSaleBill mc, int i,
			int pagesize) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("from StopSaleBill t  where t.reviewStatus=3 " );
		}else{
			hql=new StringBuffer("select t from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=3 " );
			hql.append(" and q.commonname like '%"+mc.getApplicationTime()+"%' ");
		}
		/*Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(i);
		query.setMaxResults(pagesize);
		@SuppressWarnings("unchecked")
		List<StopSaleBill> list = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		List<StopSaleBill> list = null;
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
	public int getTotalCountybh(StopSaleBill mc) {
		StringBuffer hql = new StringBuffer();
		if(mc.getApplicationTime()==null || "".equals(mc.getApplicationTime())){
			hql=new StringBuffer("select count(*) from StopSaleBill t  where t.reviewStatus=3 " );
		}else{
			hql=new StringBuffer("select count(*) from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.reviewStatus=3 " );
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
		StopSaleBill ch = findById(id);
		getHibernateTemplate().delete(ch);
	}

	@Override
	public List<QualityMidicine> findypJsonqy() {
		String sql ="select distinct m.id,m.medc_no,m.common_name,m.supplyUnit_id from t_qualified_medicine m where m.dp_id is not null  ";
		Session session = null;
		List<?> list = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
				if(obj[3]!=null && !"".equals(obj[3].toString())){
					QualifiedSuppliers qs = new QualifiedSuppliers();
					qs.setId(Long.parseLong(obj[3].toString()));
					mq.setSupplyUnit(qs);
				}
				mqs.add(mq);
			}
		}
		return mqs;
	}

	@Override
	public List<Qualifiedmedcstore> findypJsonqyById(String id) {
		/*String hql =" from Qualifiedmedcstore q where q.qualifiedmedicineid= "+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		List<Qualifiedmedcstore> listqm = query.list();
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		String hql =" from Qualifiedmedcstore q where q.qualifiedmedicineid= "+Long.parseLong(id) + " and q.quantity > 0" +
				" and len(q.batchproduction) > 7 ";
		Session session = null;
		List<Qualifiedmedcstore> listqm = null;
		try{
			session =this.getHibernateTemplate().getSessionFactory().openSession();
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
	public int  countStopSaleBillByStatus(String commonName,
			String status) {
		Session session = null;
		String  count = "";
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from StopSaleBill s ,QualityMidicine q where s.qualifiedMedicineId=q.id and s.reviewStatus=:status");   
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
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		// TODO Auto-generated method stub
		return Integer.parseInt(count);
	}

	@Override
	public List<StopSaleBillVO> getPage(String commonName, String status,
			int first, int pageSize) {
		Session session = null;
		List<StopSaleBillVO> list = null; 
		StringBuffer hqlBuffer = new StringBuffer("select new com.sinosoft.drugState.stopcell.model.StopSaleBillVO(s,q) from StopSaleBill s ,QualityMidicine q where s.qualifiedMedicineId=q.id and s.reviewStatus=:status");   
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.commonname like :commonName ");
		}
		hqlBuffer.append(" order by s.id DESC");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setParameter("status", Long.parseLong(status));
			query.setFirstResult(first);
			query.setMaxResults(pageSize);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public StopSaleBillVO getStopSaleBillVOById(String id) {
		Session session = null;
		List<StopSaleBillVO> list = null;
		String hql = "select new com.sinosoft.drugState.stopcell.model.StopSaleBillVO(t,q)  from StopSaleBill t,QualityMidicine q where q.id=t.qualifiedMedicineId and t.id =:id ";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setParameter("id", Long.parseLong(id));
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return (list!=null && list.size()>0)?list.get(0):null;
	}

	@Override
	public List<StopSaleBill> findStopSaleById(String id) {
		String hql =" from StopSaleBill q where q.qualifiedMedicineId= "+Long.parseLong(id)
					+" and q.batchProduction not in (SELECT batchno FROM UnqualifiedManager)";
		
		Session session = null;
		List<StopSaleBill> listqm = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			 listqm = query.list();
		}catch (RuntimeException e) {
			
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return listqm;
	}

	
	
}
