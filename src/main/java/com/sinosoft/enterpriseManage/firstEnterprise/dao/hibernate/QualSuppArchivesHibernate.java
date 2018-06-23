package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSuppArchivesDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSupplierArchives;
@Repository("qualSuppArchivesDao")
public class QualSuppArchivesHibernate extends GenericDaoHibernate<QualifiedSupplierArchives, Long>
		implements QualSuppArchivesDao {
	public QualSuppArchivesHibernate(){
		super(QualifiedSupplierArchives.class);
	}
		
	@Override
	public List<QualifiedSupplierArchives> getQuaSuppArchivesList(
			Long qualSuppId, int first, int pagesize) {
		String hql ="from QualifiedSupplierArchives a where a.supplierId=:supplierId order by a.modifiedTime DESC";
		List<QualifiedSupplierArchives> quaSuppArchivesList = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("supplierId", qualSuppId);
			query.setFirstResult(first);
			query.setMaxResults(pagesize);
			quaSuppArchivesList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return quaSuppArchivesList;
	}

	@Override
	public void saveList(List<QualifiedSupplierArchives> list) {
		List<QualifiedSupplierArchives> archivesList = list;
		if(archivesList!=null){
			Iterator<QualifiedSupplierArchives> it = archivesList.iterator();
			while(it.hasNext()){
				save(it.next());
			}
		}
		
	}

}
