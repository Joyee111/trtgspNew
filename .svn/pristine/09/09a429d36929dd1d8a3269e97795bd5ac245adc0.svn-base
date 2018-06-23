package com.sinosoft.varietyManger.firstVarietyManger.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.varietyManger.firstVarietyManger.dao.FirstVarietyDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 4:16:31 PM
 * 类说明
 */
@Repository("firstVarietyDao")
public class FirstVarietyHibernate extends GenericDaoHibernate<FirstVariety,Long> implements
		FirstVarietyDao {
	public FirstVarietyHibernate(){
		super(FirstVariety.class);
	}
	
	@Override
	public List<FirstVariety> findListByType(Integer type, int first,
			int pagesize) {
		/*迎检暂时修改String hql ="from FirstVariety a where a.reviewStatus="+type+"  order by a.id";
		/return getListByPage(hql, new HashMap(), first, pagesize);*/
		String hql ="from FirstVariety a where a.reviewStatus= :type and a.id >296 and departmentId is not NULL order by a.id DESC";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("type", type);
		return getListByPage(hql, paraMap, first, pagesize);
		
	}

	@Override
	public int countRecordByType(Integer type) {
		/*String sql ="select count(*) from  t_first_medicine where review_status="+type;
		return getRecordCount(sql);*/
		String sql ="select count(*) from  t_first_medicine where review_status="+type+" and id > 296 and dp_id is not null";
		return getRecordCount(sql);
	}

	@Override
	public List<FirstVariety> findAllMedinceListByState(Integer state) {
		Session session = null;
		List<FirstVariety> list = null;
		try{
			session = getHibernateTemplate().getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(FirstVariety.class);
			criteria.add(Restrictions.eq("reviewStatus", state));
			list = criteria.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
