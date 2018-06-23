package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.QualifiedmedcstoreReDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;
@Repository("QualifiedmedcstoreReDao")
public class QualifiedmedcstoreReDaoImpl extends GenericDaoHibernate<QualifiedmedcstoreRe,Long> implements QualifiedmedcstoreReDao{
	
	public QualifiedmedcstoreReDaoImpl(){
		super(QualifiedmedcstoreRe.class);
	}

	@Override
	public QualifiedmedcstoreRe updatequ(QualifiedmedcstoreRe qu) {
		getHibernateTemplate().saveOrUpdate(qu);
		return null;
	}

	@Override
	public QualifiedmedcstoreRe findReById(String id) {
		QualifiedmedcstoreRe  qualifiedmedcstoreRe = null;
		Session session = null;
		try{
			 session = getHibernateTemplate().getSessionFactory().openSession();
			 qualifiedmedcstoreRe = (QualifiedmedcstoreRe)session.get(QualifiedmedcstoreRe.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return qualifiedmedcstoreRe;
	}
	
	@Override
	public QualifiedmedcstoreRe save(QualifiedmedcstoreRe qu) {
		QualifiedmedcstoreRe qus=getHibernateTemplate().merge(qu);
		return qus;
	}
}
