package com.sinosoft.drugState.inspectionRecords.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.inspectionRecords.dao.InspectItemDao;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;

@Repository("InspectItemDao")
public class InspectItemDaoImpl extends GenericDaoHibernate<ReceivingNoteItem, Long> implements InspectItemDao {

	public InspectItemDaoImpl() {
		super(ReceivingNoteItem.class);
	}
	
	@Override
	public void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem) {
		this.getHibernateTemplate().save(receivingNoteItem);
	}

	@Override
	public void del(String a) {
		ReceivingNoteItem re=findById(Long.parseLong(a));
		getHibernateTemplate().delete(re);
	}

	@Override
	public ReceivingNoteItem findById(Long id) {
//		String hql = "select t from ReceivingNoteItem t where id ="+id;
//		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		ReceivingNoteItem retu =(ReceivingNoteItem) query.list().get(0);
//		try {
//			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		ReceivingNoteItem retu = null;
		Session session = null;
		try{
			session = this.getHibernateTemplate().getSessionFactory().openSession();
			retu = (ReceivingNoteItem)session.get(ReceivingNoteItem.class, id);
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null)
				session.close();
		}
		return retu;
	}

	@Override
	public void delOne(String id) {
		Long i = Long.parseLong(id);
		ReceivingNoteItem re=findById(i);
		getHibernateTemplate().delete(re);
	}
	
}
