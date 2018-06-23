package com.sinosoft.qualityRecords.adverseReactionInfo.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionUseItemDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
@Repository("AdverseReactionUseItemDao")
public class AdverseReactionUseItemDaoimpl extends GenericDaoHibernate<AdverseReactionUseItem, Long> implements AdverseReactionUseItemDao {
	public AdverseReactionUseItemDaoimpl() {
		super(AdverseReactionUseItem.class);
	}
	@Override
	public void savech(AdverseReactionUseItem au) {
		this.getHibernateTemplate().save(au);
	}
	@Override
	public void del(String string) {
		AdverseReactionUseItem ch = findById(string);
		this.getHibernateTemplate().delete(ch);
	}
	
	@Override
	public AdverseReactionUseItem findById(String id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		AdverseReactionUseItem adverseReactionUseItem=new AdverseReactionUseItem();
		try{
			String hql="from AdverseReactionUseItem t where t.id="+Long.parseLong(id);
			
			Query query = session.createQuery(hql);
			adverseReactionUseItem=(AdverseReactionUseItem) query.list().get(0);	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return adverseReactionUseItem;
	}
	
	
	
	
	
}
