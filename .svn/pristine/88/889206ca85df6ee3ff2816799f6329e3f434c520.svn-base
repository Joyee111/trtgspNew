package com.sinosoft.qualityRecords.temRecords.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.temRecords.dao.TemRecordsDao;
import com.sinosoft.qualityRecords.temRecords.model.HumitureRecord;
import com.sinosoft.qualityRecords.temRecords.model.TemRecords;
@Repository("TemRecordsDao")
public class TemRecordsDaoImpl extends GenericDaoHibernate<TemRecords, Long>implements TemRecordsDao {
	public TemRecordsDaoImpl() {
		super(TemRecords.class);
	}

	@Override
	public int getQueryCount(String hql) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int a=0;
		try{
			Query query = session.createSQLQuery(hql);
			  a = Integer.parseInt(query.list().get(0).toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return a;
	}

	@Override
	public List<?> getTemRecordsByPage(String hql, Map map, int first,
			int pagesize) {
		Session session =null;
		List<TemRecords> temRecordsList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
				
			}
			temRecordsList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return temRecordsList;
	}

	

	@Override
	public List<?> getHumByPage(String hql) {
		Session session =null;
		List<HumitureRecord> humitureRecordList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql);
			
	
			humitureRecordList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return humitureRecordList;
	}

	@Override
	public List<?> getTemByPage(String hql) {
		Session session =null;
		List<HumitureRecord> humitureRecordList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(hql);
			
	
			humitureRecordList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return humitureRecordList;
	}

	@Override
	public List<HumitureRecord> findHumAndTemByCondition(String location,
			String startDate, String endDate, int first, int pagesize) {
		Session session  = null;
		List<HumitureRecord> recordList = null;
		StringBuffer sqlBuffer = new StringBuffer("select  dateAndSenorIp, datetime, sensorname, ");
		sqlBuffer.append("MAX(case t.type when 'max' then t.humidity else '0' end ) as max_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'avg' then t.humidity else '0' end ) as avg_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'min' then t.humidity else '0' end ) as min_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'max' then t.temperature else '0' end ) as max_temperature, ");
		sqlBuffer.append("MAX(case t.type when 'avg' then t.temperature else '0' end ) as avg_temperature, ");
		sqlBuffer.append("MAX(case t.type when 'min' then t.temperature else '0' end ) as min_temperature from (");
		sqlBuffer.append("select CONVERT(varchar(20), datetime, 0)+SUBSTRING(sensorIP, 1, LEN(sensorIP)-4) as dateAndSenorIp, ");
		sqlBuffer.append("SUBSTRING(sensorIP, LEN(sensorIP)-2, LEN(sensorIP) ) as type, ");
		sqlBuffer.append("SUBSTRING( CONVERT(varchar(20), datetime, 20), 0, LEN(CONVERT(varchar(20), datetime, 20))-2) as datetime, ");
		sqlBuffer.append("SUBSTRING(sensorname, 1, LEN(sensorname)-3) as sensorname, humidity, temperature from t_humiture where 1=1 ");
		if(location!=null && !"".equals(location)){
			sqlBuffer.append(" and sensorname like :location ");
		}
		if(startDate !=null && !"".equals(startDate)){
			sqlBuffer.append(" and datetime >= :startDate ");
		}
		if(endDate!=null && !"".equals(endDate)){
			sqlBuffer.append(" and datetime <= :endDate ");
		}
		sqlBuffer.append(" ) t  group by dateAndSenorIp,datetime,sensorname ");
		
		sqlBuffer.append(" order by datetime DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query =  session.createSQLQuery(sqlBuffer.toString());
			query.addScalar("datetime", Hibernate.STRING);
			query.addScalar("sensorname", Hibernate.STRING);
			query.addScalar("max_humidity", Hibernate.STRING);
			query.addScalar("avg_humidity", Hibernate.STRING);
			query.addScalar("min_humidity", Hibernate.STRING);
			query.addScalar("max_temperature", Hibernate.STRING);
			query.addScalar("avg_temperature", Hibernate.STRING);
			query.addScalar("min_temperature", Hibernate.STRING);
			if(location!=null && !"".equals(location)){
				query.setParameter("location", "%"+location+"%");
			}
			if(startDate !=null && !"".equals(startDate)){
				query.setParameter("startDate", startDate+" 00:00");
			}
			if(endDate!=null && !"".equals(endDate)){
				query.setParameter("endDate", endDate+" 23:59");
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			query.setResultTransformer(Transformers.aliasToBean(HumitureRecord.class));
			recordList = query.list();
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return recordList;
	}

	@Override
	public int countHumAndTemByCondition(String location, String startDate,
			String endDate) {
		Session session  = null;
		//List<HumitureRecord> recordList = null;
		String count = "0";
		StringBuffer sqlBuffer = new StringBuffer("select count(*)/3 from  t_humiture where 1=1 ");
		if(location!=null && !"".equals(location)){
			sqlBuffer.append(" and sensorname like :location ");
		}
		if(startDate !=null && !"".equals(startDate)){
			sqlBuffer.append(" and datetime >= :startDate ");
		}
		if(endDate!=null && !"".equals(endDate)){
			sqlBuffer.append(" and datetime <= :endDate ");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query =  session.createSQLQuery(sqlBuffer.toString());
			if(location!=null && !"".equals(location)){
				query.setParameter("location", "%"+location+"%");
			}
			if(startDate !=null && !"".equals(startDate)){
				query.setParameter("startDate", startDate+" 00:00");
			}
			if(endDate!=null && !"".equals(endDate)){
				query.setParameter("endDate", endDate+" 23:59");
			}
			count = query.list().get(0).toString();
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return Integer.parseInt(count);
	}
	
	
	
	
	
	@Override
	public List<HumitureRecord> findHumAndTemByTableName(String tableName,String location,
			String startDate, String endDate, int first, int pagesize) {
		Session session  = null;
		List<HumitureRecord> recordList = null;
		StringBuffer sqlBuffer = new StringBuffer("select  dateAndSenorIp, datetime, sensorname, ");
		sqlBuffer.append("MAX(case t.type when 'max' then t.humidity else '0' end ) as max_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'avg' then t.humidity else '0' end ) as avg_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'min' then t.humidity else '0' end ) as min_humidity, ");
		sqlBuffer.append("MAX(case t.type when 'max' then t.temperature else '0' end ) as max_temperature, ");
		sqlBuffer.append("MAX(case t.type when 'avg' then t.temperature else '0' end ) as avg_temperature, ");
		sqlBuffer.append("MAX(case t.type when 'min' then t.temperature else '0' end ) as min_temperature from (");
		sqlBuffer.append("select CONVERT(varchar(20), datetime, 0)+SUBSTRING(sensorIP, 1, LEN(sensorIP)-4) as dateAndSenorIp, ");
		sqlBuffer.append("SUBSTRING(sensorIP, LEN(sensorIP)-2, LEN(sensorIP) ) as type, ");
		sqlBuffer.append("SUBSTRING( CONVERT(varchar(20), datetime, 20), 0, LEN(CONVERT(varchar(20), datetime, 20))-2) as datetime, ");
		sqlBuffer.append("LEFT(sensorname, 4) AS sensorname, CAST(humidity AS FLOAT) AS humidity, CAST(temperature AS FLOAT) AS temperature from "+tableName+" where 1=1 ");
		if(location!=null && !"".equals(location)){
			sqlBuffer.append(" and sensorname like :location ");
		}
		if(startDate !=null && !"".equals(startDate)){
			sqlBuffer.append(" and datetime >= :startDate ");
		}
		if(endDate!=null && !"".equals(endDate)){
			sqlBuffer.append(" and datetime <= :endDate ");
		}
		sqlBuffer.append(" ) t  group by dateAndSenorIp,datetime,sensorname ");
		
		sqlBuffer.append(" order by datetime DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query =  session.createSQLQuery(sqlBuffer.toString());
			query.addScalar("datetime", Hibernate.STRING);
			query.addScalar("sensorname", Hibernate.STRING);
			query.addScalar("max_humidity", Hibernate.STRING);
			query.addScalar("avg_humidity", Hibernate.STRING);
			query.addScalar("min_humidity", Hibernate.STRING);
			query.addScalar("max_temperature", Hibernate.STRING);
			query.addScalar("avg_temperature", Hibernate.STRING);
			query.addScalar("min_temperature", Hibernate.STRING);
			if(location!=null && !"".equals(location)){
				query.setParameter("location", "%"+location+"%");
			}
			if(startDate !=null && !"".equals(startDate)){
				query.setParameter("startDate", startDate+" 00:00");
			}
			if(endDate!=null && !"".equals(endDate)){
				query.setParameter("endDate", endDate+" 23:59");
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			query.setResultTransformer(Transformers.aliasToBean(HumitureRecord.class));
			recordList = query.list();
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return recordList;
	}
	
	
	@Override
	public int countHumAndTemByTableName(String tableName,String location,String startDate,String endDate) {
		Session session  = null;
		//List<HumitureRecord> recordList = null;
		String count = "0";
		StringBuffer sqlBuffer = new StringBuffer("select count(*)/3 from  "+tableName+" where 1=1 ");
		if(location!=null && !"".equals(location)){
			sqlBuffer.append(" and sensorname like :location ");
		}
		if(startDate !=null && !"".equals(startDate)){
			sqlBuffer.append(" and datetime >= :startDate ");
		}
		if(endDate!=null && !"".equals(endDate)){
			sqlBuffer.append(" and datetime <= :endDate ");
		}
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query =  session.createSQLQuery(sqlBuffer.toString());
			if(location!=null && !"".equals(location)){
				query.setParameter("location", "%"+location+"%");
			}
			if(startDate !=null && !"".equals(startDate)){
				query.setParameter("startDate", startDate+" 00:00");
			}
			if(endDate!=null && !"".equals(endDate)){
				query.setParameter("endDate", endDate+" 23:59");
			}
			count = query.list().get(0).toString();
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return Integer.parseInt(count);
	}
	
	
	
}
