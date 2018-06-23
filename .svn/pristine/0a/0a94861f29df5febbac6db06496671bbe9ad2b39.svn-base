package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.util.SystemLogUtil;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualityTrackRecordDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityFiles;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityTrackRecord;
@Repository("qualityTrackRecordDao")
public class QualityTrackRecordHibernate extends GenericDaoHibernate<QualityTrackRecord,Long> implements QualityTrackRecordDao {
	public QualityTrackRecordHibernate(){
		super(QualityTrackRecord.class);
	}

	@Override
	public List<QualityTrackRecord> getTrackRecordList(Long qualityMidicineId,
			int first, int pagesize) {
		Session session = null;
		List<QualityTrackRecord> recordList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(QualityTrackRecord.class);
			criteria.add(Restrictions.eq("qualityFiles.id", qualityMidicineId));
			criteria.setFirstResult(first);
			criteria.setMaxResults(pagesize);
			recordList = criteria.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return recordList;
	}

	@Override
	public int countTrackRecordList(Long qualityFilesId) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		String count = "";
		String sql = "select count(*) from t_quality_track_record where qualityFiles_id =:qualityFilesId";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			query.setParameter("qualityFilesId", qualityFilesId);
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
	public List<QualityFiles> getQualityFiles(String medicNo,
			String commonName, int first, int pagesize) {
		Session session = null;
		List<QualityFiles> qualityFilesList = null;
		StringBuffer hqlBuffer = new StringBuffer("select q from QualityFiles q where 1=1 ");
		if(medicNo!=null &&!"".equals(medicNo)){
			hqlBuffer.append(" and q.qualityMidicine.medicinalNo like :medicNo ");
		}
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.qualityMidicine.commonname like :commonName");
		}
		hqlBuffer.append(" order by q.id DESC ");
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(medicNo!=null && !"".equals(medicNo)){
				query.setParameter("medicNo", "%"+medicNo+"%");
			}
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
			}
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			qualityFilesList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qualityFilesList;
	}

	@Override
	public int countQualityFiles(String medicNo, String commonName) {
		Session session = null;
		StringBuffer hqlBuffer = new StringBuffer("select count(*) from QualityFiles q where 1=1 ");
		if(medicNo!=null &&!"".equals(medicNo)){
			hqlBuffer.append(" and q.qualityMidicine.medicinalNo like :medicNo ");
		}
		if(commonName!=null && !"".equals(commonName)){
			hqlBuffer.append(" and q.qualityMidicine.commonname like :commonName");
		}
		String count = "0";
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hqlBuffer.toString());
			if(medicNo!=null && !"".equals(medicNo)){
				query.setParameter("medicNo", "%"+medicNo+"%");
			}
			if(commonName!=null && !"".equals(commonName)){
				query.setParameter("commonName", "%"+commonName+"%");
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

	@Override
	public void deleteQualified(Long id) {
		Connection con = null;
		Statement  statement = null;
		try{ 
			con = getHibernateTemplate().getSessionFactory().openSession().connection();
			statement = con.createStatement();
			statement.executeUpdate("delte from t_quality_track_record where qualityFiles_id="+id);
			statement.executeUpdate("delte from t_quality_files where id="+id);
		}catch (SQLException e) {
			e.printStackTrace();
			SystemLogUtil.saveError(Constants.LOG_ERROR, "QualityTrackRecordHibernate.deleteQualified======="+e.getMessage());
		}finally{
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public QualityFiles getQualified(Long id) {
		Session session = null;
		QualityFiles qualityFiles = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			qualityFiles  =  (QualityFiles) session.get(QualityFiles.class, id);
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return qualityFiles;
	}

	@Override
	public void saveQaulified(QualityFiles qualityFiles) {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			session.saveOrUpdate(qualityFiles);
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
	}

	@Override
	public List<QualityMidicine> findQualityMedic() {
		Session session = null;
		List<QualityMidicine> midicineList = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			String hql = "select q from QualityMidicine q where q.departmentId is not null and q.id not in (select qualityMidicine.id from QualityFiles )" ;
			Query query = session.createQuery(hql);
			midicineList = query.list();
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return midicineList;
	}
}
