package com.sinosoft.baseInfo.menuManage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManager;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigVo;

@Service
public interface MenuManageService extends GenericManager<MenuConfigModel, Long> {
	
	/**
	 * 
	 * @param mc：查询实体
	 * @param first
	 * @param pageSize：页面大小
	 * @return
	 */
	public List<MenuConfigModel> getListByPage(MenuConfigModel mc, int first, int pageSize);
	
	/**
	 * 获取菜单总数
	 * @return
	 */
	public int getRecordCountByMenuId(String deptId);
	
	/**
	 * 根据hql获取菜单列表
	 * @param hql
	 * @return
	 */
	public List<MenuConfigModel> getListByHql(String hql);
	
	public List<MenuConfigVo> showMenuVoList();
	
}
