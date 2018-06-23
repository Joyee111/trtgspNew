package com.sinosoft.dictionary.dao.hibernate;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.dictionary.dao.DrugFormDictionaryDao;
import com.sinosoft.dictionary.mode.DrugFormDictionary;

/**
 * @author lfl:
 * @version 创建时间：Jun 6, 2013 2:41:27 PM
 * 类说明
 */
@Repository("drugFormDictionaryDao")
public class DrugFormDictionaryHibernate extends GenericDaoHibernate<DrugFormDictionary, Long>
		implements DrugFormDictionaryDao {
	public DrugFormDictionaryHibernate(){
		super(DrugFormDictionary.class);
	}

	@Override
	public List<DrugFormDictionary> getDrugFromDictionnaryOrderByName() {
		Session session = null;
		List<DrugFormDictionary> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DrugFormDictionary.class);
			criteria.addOrder(Order.asc("formName"));
			list= criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return list;
	}
}
