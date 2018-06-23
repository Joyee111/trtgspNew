package com.sinosoft.baseInfo.menuManage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.baseInfo.menuManage.dao.MenuManageDao;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigModel;
import com.sinosoft.baseInfo.menuManage.model.MenuConfigVo;
import com.sinosoft.baseInfo.menuManage.service.MenuManageService;

@Service
public class MenuManageSerImpl extends GenericManagerImpl<MenuConfigModel, Long> implements MenuManageService {
	@Autowired
	private MenuManageDao menuManageDao;
	@Autowired
	public MenuManageSerImpl(MenuManageDao menuManageDao){
		super(menuManageDao);
		this.menuManageDao = menuManageDao;
	}
	
	/**
	 * 
	 * @param mc：查询实体
	 * @param first
	 * @param pageSize：页面大小
	 * @return
	 */
	public List<MenuConfigModel> getListByPage(MenuConfigModel mc, int first, int pageSize){
		Map<String, Object> map = new HashMap<String, Object>();
    	StringBuffer hql = new StringBuffer("from MenuConfigModel where 1=1 ");
    	
    	String menuName = mc.getMenuName();
    	long parentId = mc.getParentId();
    	
    	if(null != menuName && !menuName.isEmpty()){
    		map.put("menuName", "%"+menuName+"%");
    		hql.append(" and menuName like:menuName");
    	}
		if(parentId > 0){
			map.put("parentId", parentId);
    		hql.append(" and parentId =:parentId");
		}
		
		hql.append(" order by id desc");
		return menuManageDao.getListByPage(hql.toString(), map, first, pageSize);
	}
	
	/**
	 * 获取菜单总数
	 * @return
	 */
	public int getRecordCountByMenuId(String menuId){
		String countSql = "select COUNT(*) from MenuConfig ";
		if(null != menuId){
			countSql += "where parentId = "+menuId;
		}
		return menuManageDao.getRecordCount(countSql);
	}
	
	/**
	 * 根据hql获取菜单列表
	 * @param hql
	 * @return
	 */
	public List<MenuConfigModel> getListByHql(String hql){
		return menuManageDao.getListByHql(hql);
	}
	
	/**
	 * 获取所有菜单，parentId=-1
	 */
	public List<MenuConfigVo> showMenuVoList(){
		List<MenuConfigVo> mVoList = new ArrayList<MenuConfigVo>();
		List<MenuConfigVo> voList = new ArrayList<MenuConfigVo>();
		
		List<MenuConfigModel> parentList = menuManageDao.getListByHql("from MenuConfigModel where parentId = -1");
		List<MenuConfigModel> childList = menuManageDao.getListByHql("from MenuConfigModel where parentId > -1");
		
		for(MenuConfigModel mc:childList){
			voList.add(new MenuConfigVo(mc));
		}
		
		for(int i=0; i<parentList.size(); i++){
			MenuConfigVo mVo = new MenuConfigVo(parentList.get(i));
			getChildren(mVo, voList);
			
			mVoList.add(mVo);
		}
		
		return mVoList;
	}
	
	/**
	 * 获取当前节点的所有子节点以及子节点下的子节点
	 * @param parent
	 * @param list
	 */
	public void getChildren(MenuConfigVo parent, List<MenuConfigVo> list){
		
		for(MenuConfigVo vo :list){
			if(vo.getParentId()==parent.getId()){
				parent.getChild().add(vo);
			}
		}
		
		List<MenuConfigVo> childList = parent.getChild();
		
		if(childList.size() > 0){
			for(MenuConfigVo vo : childList){
				getChildren(vo, list);
			}
		}
	}

}
