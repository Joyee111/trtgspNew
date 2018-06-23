package com.sinosoft.baseInfo.menuManage.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;

public interface MenuManageDao extends GenericDao<MenuConfigModel, Long> {

	/**
	 * 根据hql获取菜单列表
	 * @param hql
	 * @return
	 */
	public List<MenuConfigModel> getListByHql(String hql);
}