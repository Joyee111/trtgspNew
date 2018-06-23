package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.DrugStandardsFilesDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.DrugStandardsFiles;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 11:20:39 AM
 * 类说明
 */
@Repository("drugStandardsFilesDao")
public class DrugStandardsFilesHibernate extends GenericDaoHibernate<DrugStandardsFiles, Long>
		implements DrugStandardsFilesDao {
	public DrugStandardsFilesHibernate(){
		super(DrugStandardsFiles.class);
	}
	@Override
	public List<DrugStandardsFiles> findByPage(String hql, int first,
			int pagesize) {
		return getListByPage(hql, new HashMap(), first, pagesize);
	}
	@Override
	public String getMaxNumber() {
		Session session = null;
		String maxNumber = "";
		String sql = "select MAX(number)  from t_quality_standard";
		List<?> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Query query = session.createSQLQuery(sql);
			list = query.list();
			if(list!=null && list.size()>0 && list.get(0)!=null){
				maxNumber = list.get(0).toString();
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return maxNumber;
	}
	
}
