package com.sinosoft.qualityRecords.infoFeedback.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.infoFeedback.dao.InfoFeedbackDao;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemAndUserVO;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedbackItem;

@Repository("InfoFeedbackDao")
public class InfoFeedbackDaoImpl extends GenericDaoHibernate<InfoFeedback, Long> implements InfoFeedbackDao {
	public InfoFeedbackDaoImpl() {
		super(InfoFeedback.class);
	}
	
	@Override
	public int countFeedbackWaitingToDo(Long userId) {
		int count = 0;
		Session session = null;
		try{
			String sql = "select COUNT(*) from t_InfoFeedback_item where zhipaiId=:userId and content is null";
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query  = session.createSQLQuery(sql);
			query.setLong("userId", userId);
			count = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return count;
	}
	@Override
	public List<InfoFeedbackItem> findInfoFeedbackItemsByCondiction(
			Long infoFeedbackId, String userId) {
		// TODO Auto-generated method stub
		Session session = null;
		List<InfoFeedbackItem> itemList = null;
		DetachedCriteria deCriteria = DetachedCriteria.forClass(InfoFeedbackItem.class);
		if(infoFeedbackId != null && infoFeedbackId > 0){
			deCriteria.add(Restrictions.eq("infoFeedbackId", infoFeedbackId));
		}
		if(userId!=null && !"".equals(userId.trim())){
			deCriteria.add(Restrictions.eq("zhipaiId", userId));
		}
	//	StringBuffer buffer = new StringBuffer("select t from InfoFeedbackItem where 1=1 ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = deCriteria.getExecutableCriteria(session);
			itemList = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		
		return itemList;
	}
	@Override
	public InfoFeedback saveOrUpdateInfoFeedback(InfoFeedback infoFeedback) {
		Session session = null;
		InfoFeedback feedback = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
//			if(infoFeedback.getId()==null){
//				session.save(infoFeedback);
//			}else {
				feedback = (InfoFeedback)session.merge(infoFeedback);
		//	}
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
		return feedback;
	}
	@Override
	public InfoFeedbackItem saveOrUpdateInfoFeedbackItem(
			InfoFeedbackItem iFeedbackItem) {
		Session session = null;
		InfoFeedbackItem item  = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			item = (InfoFeedbackItem)session.merge(iFeedbackItem);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
		return item;
	}

	@Override
	public int countInfoFeedbacks(String hql,Map<String, Object> paraMap) {
		Session session = null;
		String count = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			Iterator<String> it = paraMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if("list".equals(key)){
					query.setParameterList(key, (List<Long>)paraMap.get(key));
				}else{
					query.setParameter(key, paraMap.get(key));
				}
			}
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.parseInt(count);
	}

	@Override
	public void deleteInfoFeedbacks(Long id) {
		//Session session = null;
		Connection conn = null;
		Statement stm = null;
		try{
			conn = getHibernateTemplate().getSessionFactory().openSession().connection();
			stm = conn.createStatement();
			stm.executeUpdate("delete from t_InfoFeedback_item where infoFeedback_Id = "+id);
			stm.executeUpdate("delete from t_feedback_info where id = " + id);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				if(conn !=null ){
					conn.close();
				}
				if(stm != null){
					stm.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public InfoFeedback getInfoFeedback(Long id) {
		Session session = null;
		InfoFeedback inFeedback = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			inFeedback = (InfoFeedback)session.get(InfoFeedback.class, id);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return inFeedback;
	}

	@Override
	public List<InfoFeedback> findInfoFeedbacks(String hql,
			Map<String, Object> paraMap, int first, int pagesize) {
		Session session = null;
		List<InfoFeedback> iFeedbackList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
		//	Transaction  tr = session.beginTransaction();
			Query query =  session.createQuery(hql);
			Iterator<String> it = paraMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if("list".equals(key)){
					query.setParameterList(key, (List<Long>)paraMap.get(key));
				}else{
					query.setParameter(key, paraMap.get(key));
				}
				
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			iFeedbackList = query.list();
		//	tr.commit();
			//iFeedbackList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.flush();
				session.close();
			}
		}
		return iFeedbackList;
	}

	@Override
	public List<String> findAlreadyAssignWork(Long infoFeedbackId) {
		Session session = null;
		List<String> list = null;
		StringBuffer buffer = new StringBuffer("select type from  InfoFeedbackItem  where infoFeedbackId = :infoFeedbackId group by type ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(buffer.toString());
			query.setParameter("infoFeedbackId", infoFeedbackId );
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<String> findWaitToDoWort(Long infoFeedbackId, String userId) {
		Session  session = null;
		List<String> list = null;
		StringBuffer buffer = new StringBuffer("select type from InfoFeedbackItem where 1=1 ");
		buffer.append(" and infoFeedbackId = :infoFeedbackId ");
		buffer.append(" and zhipaiId = :userId");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(buffer.toString());
			query.setParameter("infoFeedbackId", infoFeedbackId);
			query.setParameter("userId", userId);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<InfoFeedBackItemAndUserVO> findInfoFeedBackItemAndUserVO(
			Long infoFeedbackId) {
		List<InfoFeedBackItemAndUserVO> list = null;
		Session session = null;
		StringBuffer buffer = new StringBuffer("select new com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemAndUserVO(t ,u.realname) from InfoFeedbackItem t ,User u  ") ;
		buffer.append(" where  cast(t.zhipaiId as long ) =  u.id and t.infoFeedbackId = :infoFeedbackId " );
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(buffer.toString());
			query.setParameter("infoFeedbackId", infoFeedbackId);
			list = query.list();
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

	@Override
	public List<InfoFeedback> findInfoFeedBackByCondition(Long userId,String feedDepement,
			String commonName, String startDate, String endDate, int first,
			int pagesize) {
		Session session = null;
		List<InfoFeedback> infoFeedbackList = null;
		StringBuffer sqlbuffer =  new StringBuffer("SELECT id, feedbackdepartment, commonName, drugForm, specification, batchproduction, unit, quantity, manufacturer, returnUnit,createDate,type FROM (");
		
		StringBuffer appointBuffer = new StringBuffer("SELECT t.id AS id, t.feedbackdepartment as feedbackdepartment,t.common_name AS commonName,t.drug_form AS drugForm,t.specification AS specification,");
		appointBuffer.append("t.batch_production AS batchproduction,t.unit AS unit,t.quantity AS quantity,t.manufacturer AS manufacturer,t.return_unit AS returnUnit,t.create_date AS createDate,'0' AS type ");
		appointBuffer.append("FROM t_feedback_info t WHERE createPerson_Id = "+userId+" AND EXISTS (SELECT * FROM t_InfoFeedback_item ti WHERE (ti.infoFeedback_Id = t.id OR t.id NOT IN (SELECT infoFeedback_Id ");
		appointBuffer.append("FROM t_InfoFeedback_item)) GROUP BY ti.type HAVING ISNULL(COUNT(*), 0) < 4)");
		
		StringBuffer assignedBuffer = new StringBuffer("SELECT t.id AS id,t.feedbackdepartment as feedbackdepartment,t.common_name AS commonName,t.drug_form AS drugForm,t.specification AS specification,");
		assignedBuffer.append("t.batch_production AS batchproduction,t.unit AS unit,t.quantity AS quantity,t.manufacturer AS manufacturer,t.return_unit AS returnUnit,t.create_date AS createDate,'1' AS type ");
		assignedBuffer.append("FROM t_feedback_info t WHERE 1 = 1 AND t.id IN (SELECT infoFeedback_Id FROM t_InfoFeedback_item WHERE CAST(zhipaiId AS numeric) = "+userId+" AND content IS NULL GROUP BY infoFeedback_Id)");
		
		StringBuffer conditionBuffer = new StringBuffer();
		if(feedDepement != null && !"".equals(feedDepement.trim())){
			conditionBuffer.append(" AND t.feedbackdepartment LIKE '%"+feedDepement+"%'");
		}
		if(commonName != null && !"".equals(commonName.trim())){
			conditionBuffer.append(" AND t.common_name LIKE '%"+commonName+"%' ");
		}
		if(startDate != null && !"".equals(startDate.trim())){
			conditionBuffer.append(" AND  CONVERT(varchar(50), t.create_date, 20) >='"+startDate+" 00:00:00"+"'");
		}
		if(endDate != null && !"".equals(endDate.trim())){
			conditionBuffer.append(" AND  CONVERT(varchar(50), t.create_date, 20) <='"+endDate+" 23:59:59"+"'");
		}
		
		appointBuffer = appointBuffer.append(conditionBuffer);
		assignedBuffer = assignedBuffer.append(conditionBuffer);
		sqlbuffer.append(appointBuffer).append("  UNION ALL ").append(assignedBuffer).append(" ) x ORDER BY x.type DESC  , x.id DESC ");
		
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(sqlbuffer.toString());
			query.addScalar("id", Hibernate.LONG);
			query.addScalar("feedbackdepartment", Hibernate.STRING);
			query.addScalar("commonName", Hibernate.STRING);
			query.addScalar("drugForm", Hibernate.STRING);
			query.addScalar("specification", Hibernate.STRING);
			query.addScalar("batchproduction", Hibernate.STRING);
			query.addScalar("unit", Hibernate.STRING);
			query.addScalar("quantity", Hibernate.STRING);
			query.addScalar("manufacturer", Hibernate.STRING);
			query.addScalar("returnUnit", Hibernate.STRING);
			query.addScalar("createDate", Hibernate.DATE);
			query.addScalar("type", Hibernate.STRING);
			query.setResultTransformer(Transformers.aliasToBean(InfoFeedback.class));
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			infoFeedbackList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return infoFeedbackList;
	}

	@Override
	public int countInfoFeedBackByCondition(Long userId,String feedDepement,
			String commonName, String startDate, String endDate) {
		Session session = null;
		String count = "0";
		StringBuffer sqlbuffer =  new StringBuffer("SELECT  count(*) FROM (");
		
		StringBuffer appointBuffer = new StringBuffer("SELECT t.id AS id, t.feedbackdepartment as feedbackdepartment,t.common_name AS commonName,t.drug_form AS drugForm,t.specification AS specification,");
		appointBuffer.append("t.batch_production AS batchproduction,t.unit AS unit,t.quantity AS quantity,t.manufacturer AS manufacturer,t.return_unit AS returnUnit,t.create_date AS createDate,'0' AS type ");
		appointBuffer.append("FROM t_feedback_info t WHERE createPerson_Id = "+userId+" AND EXISTS (SELECT * FROM t_InfoFeedback_item ti WHERE (ti.infoFeedback_Id = t.id OR t.id NOT IN (SELECT infoFeedback_Id ");
		appointBuffer.append("FROM t_InfoFeedback_item)) GROUP BY ti.type HAVING ISNULL(COUNT(*), 0) < 4)");
		
		StringBuffer assignedBuffer = new StringBuffer("SELECT t.id AS id,t.feedbackdepartment as feedbackdepartment,t.common_name AS commonName,t.drug_form AS drugForm,t.specification AS specification,");
		assignedBuffer.append("t.batch_production AS batchproduction,t.unit AS unit,t.quantity AS quantity,t.manufacturer AS manufacturer,t.return_unit AS returnUnit,t.create_date AS createDate,'1' AS type ");
		assignedBuffer.append("FROM t_feedback_info t WHERE 1 = 1 AND t.id IN (SELECT infoFeedback_Id FROM t_InfoFeedback_item WHERE CAST(zhipaiId AS numeric) = "+userId+" AND content IS NULL GROUP BY infoFeedback_Id)");
		
		StringBuffer conditionBuffer = new StringBuffer();
		if(feedDepement != null && !"".equals(feedDepement.trim())){
			conditionBuffer.append(" AND t.feedbackdepartment LIKE '%"+feedDepement+"%'");
		}
		if(commonName != null && !"".equals(commonName.trim())){
			conditionBuffer.append(" AND t.common_name LIKE '%"+commonName+"%' ");
		}
		if(startDate != null && !"".equals(startDate.trim())){
			conditionBuffer.append(" AND  CONVERT(varchar(50), t.create_date, 20) >='"+startDate+" 00:00:00"+"'");
		}
		if(endDate != null && !"".equals(endDate.trim())){
			conditionBuffer.append(" AND  CONVERT(varchar(50), t.create_date, 20) <='"+endDate+" 23:59:59"+"'");
		}
		
		appointBuffer = appointBuffer.append(conditionBuffer);
		assignedBuffer = assignedBuffer.append(conditionBuffer);
		sqlbuffer.append(appointBuffer).append("  UNION ALL ").append(assignedBuffer).append(" ) x ");
		
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(sqlbuffer.toString());
			
			count = query.list().get(0).toString();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return Integer.parseInt(count);
	}

	@Override
	public List<String> findBackId(String sql) {
		Session  session = null;
		List<String> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			list = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e ;
		}finally{
			if(session != null){
				session.close();
			}
		}
		return list;
	}
}
