package com.sinosoft.drugState.accepreturn.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.accepreturn.dao.ReturnTaceItemDao;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;

@Repository("ReturnTaceItemDao")
public class ReturnTaceItemDaoImpl extends GenericDaoHibernate<ReturncheckItem,Long> implements ReturnTaceItemDao{

	public ReturnTaceItemDaoImpl() {
		super(ReturncheckItem.class);
	}
	
	@Override
	public void savech(ReturncheckItem ch) {
		this.getHibernateTemplate().save(ch);
	}

	@Override
	public void del(String string) {
		ReturncheckItem ch = findById(string);
		this.getHibernateTemplate().delete(ch);
	}

	@Override
	public ReturncheckItem findById(String id) {
//		String hql="from ReturncheckItem t where t.id="+Long.parseLong(id);
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		if(query.list().size()>0){
//			ReturncheckItem rete=(ReturncheckItem) query.list().get(0);
//			try {
//				session.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return rete;
//		}else{
//			return new ReturncheckItem();
//		}
		Session session = null;
		ReturncheckItem reItem = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			reItem =(ReturncheckItem) session.get(ReturncheckItem.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return reItem;
	}

}
