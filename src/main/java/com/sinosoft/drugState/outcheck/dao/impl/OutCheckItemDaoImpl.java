package com.sinosoft.drugState.outcheck.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.outcheck.dao.OutCheckItemDao;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
@Repository("OutCheckItemDao")
public class OutCheckItemDaoImpl extends GenericDaoHibernate<OutboundCheckItem, Long> implements OutCheckItemDao{
	
	
	public OutCheckItemDaoImpl( ) {
		super(OutboundCheckItem.class);
	}

	@Override
	public void savech(OutboundCheckItem ch) {
		this.getHibernateTemplate().save(ch);
	}

	@Override
	public void del(String string) {
		OutboundCheckItem ch = findById(string);
		this.getHibernateTemplate().delete(ch);
	}

	@Override
	public OutboundCheckItem findById(String id) {
		/*String hql="from OutboundCheckItem t where t.id="+Long.parseLong(id);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		OutboundCheckItem ou = (OutboundCheckItem) query.list().get(0);
		try {
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Session session = null;
		OutboundCheckItem ou = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			ou = (OutboundCheckItem) session.get(OutboundCheckItem.class, Long.parseLong(id));
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return ou;
	}

}
