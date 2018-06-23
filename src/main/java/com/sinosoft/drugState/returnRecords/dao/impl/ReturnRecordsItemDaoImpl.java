package com.sinosoft.drugState.returnRecords.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.drugState.returnRecords.dao.ReturnRecordsItemDao;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;

@Repository("ReturnRecordsItemDao")
public class ReturnRecordsItemDaoImpl extends GenericDaoHibernate<ReturnReceivingNoteItem, Long> implements ReturnRecordsItemDao {

		public ReturnRecordsItemDaoImpl() {
			super(ReturnReceivingNoteItem.class);
		}

		@Override
		public void saveReceivingNoteItem(ReturnReceivingNoteItem receivingNoteItem) {
			this.getHibernateTemplate().save(receivingNoteItem);
		}
		
		@Override
		public ReturnReceivingNoteItem findById(String id){
			/*String hql = "from ReturnReceivingNoteItem t where t.id="+Long.parseLong(id);
			Session session =getHibernateTemplate().getSessionFactory().openSession();
			Query query= session.createQuery(hql);
			List<ReturnReceivingNoteItem> list = null;
			ReturnReceivingNoteItem reIt= null;
			try {
				list = query.list();
				if(list.size()>0){
					reIt= list.get(0);
				}
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			Session session = null;
			ReturnReceivingNoteItem reNoteItem = null;
			try{
				session = getHibernateTemplate().getSessionFactory().openSession();
				reNoteItem = (ReturnReceivingNoteItem)session.get(ReturnReceivingNoteItem.class, Long.parseLong(id));
			}catch (RuntimeException e) {
				e.printStackTrace();
				throw e;
			}finally{
				if(session!=null)
					session.close();
			}
			return reNoteItem;
		}
		
		@Override
		public void delOne(String id) {
			ReturnReceivingNoteItem reIt=findById(id);
			getHibernateTemplate().delete(reIt);
		}
		
		

}
