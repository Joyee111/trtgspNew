package com.sinosoft.qualityRecords.adverseReactionInfo.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionDoubtItemDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
@Repository("AdverseReactionDoubtItemDao")
public class AdverseReactionDoubtItemDaoImpl extends GenericDaoHibernate<AdverseReactionDoubtItem, Long> implements AdverseReactionDoubtItemDao {

	public AdverseReactionDoubtItemDaoImpl() {
		super(AdverseReactionDoubtItem.class);
	}
	@Override
	public void savech(AdverseReactionDoubtItem ad) {
		this.getHibernateTemplate().save(ad);
	}
	@Override
	public void del(String string) {
		AdverseReactionDoubtItem ch = findById(string);
		this.getHibernateTemplate().delete(ch);
	}
	@Override
	public AdverseReactionDoubtItem findById(String id) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		AdverseReactionDoubtItem adverseReactionDoubtItem=new AdverseReactionDoubtItem();
		try{
			String hql="from AdverseReactionDoubtItem t where t.id="+Long.parseLong(id);
			Query query = session.createQuery(hql);
			adverseReactionDoubtItem=(AdverseReactionDoubtItem) query.list().get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return adverseReactionDoubtItem;
	}
}
