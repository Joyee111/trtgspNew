package com.sinosoft.enterpriseManage.firstEnterprise.dao.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSupplyDrugFromsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QulifiedSupplyDrugFroms;

@Repository("QualSupplyDrugFromsDao")
public class QualSupplyDrugFromsHibernate extends GenericDaoHibernate<QulifiedSupplyDrugFroms, Long>
		implements QualSupplyDrugFromsDao {
	public QualSupplyDrugFromsHibernate(){
		super(QulifiedSupplyDrugFroms.class);
	}
		
	@Override
	public List<QulifiedSupplyDrugFroms> getListByQualSuppId(Long qualSuppId) {
		String hql ="from QulifiedSupplyDrugFroms a where a.qualifiedSuppliers_id=:supplierId ";
		List<QulifiedSupplyDrugFroms> quaSuppArchivesList = null;
		Session session =null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setLong("supplierId", qualSuppId);
			quaSuppArchivesList = query.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return quaSuppArchivesList;
	}

	@Override
	public void saveList(List<QulifiedSupplyDrugFroms> list) {
		List<QulifiedSupplyDrugFroms> archivesList = list;
		if(archivesList!=null){
			Iterator<QulifiedSupplyDrugFroms> it = archivesList.iterator();
			while(it.hasNext()){
				save(it.next());
			}
		}
		
	}

}
