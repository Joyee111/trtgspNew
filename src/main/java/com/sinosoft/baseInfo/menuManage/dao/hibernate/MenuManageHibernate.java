package com.sinosoft.baseInfo.menuManage.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.baseInfo.menuManage.dao.MenuManageDao;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;

@Repository("menuManageDao")
public class MenuManageHibernate extends GenericDaoHibernate<MenuConfigModel, Long> implements MenuManageDao {
	
	public MenuManageHibernate() {
		super(MenuConfigModel.class);
	}

	/**
	 * 根据hql获取菜单列表
	 * @param hql
	 * @return
	 */
	public List<MenuConfigModel> getListByHql(String hql){
		return getHibernateTemplate().find(hql);
	}
}
