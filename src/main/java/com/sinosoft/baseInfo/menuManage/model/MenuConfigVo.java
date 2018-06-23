package com.sinosoft.baseInfo.menuManage.model;

import com.sinosoft.authoriy.Authoriy;

import java.util.ArrayList;
import java.util.List;

public class MenuConfigVo {
	private long id;
	private String menuName;
	private String uniqueKey;
	private String controlUrl;
    private Authoriy authoriy;
	/*private String permission;*/
	private long parentId;
	private String description;
	private List<MenuConfigVo> child;

	public MenuConfigVo(MenuConfigModel menu){
		this.id = menu.getId();
		this.menuName = menu.getMenuName();
		this.uniqueKey = menu.getUniqueKey();
		this.controlUrl = menu.getControlUrl();
        this.authoriy = menu.getAuthoriy();
		/*this.permission = menu.getPermission()*/;
		this.parentId = menu.getParentId();
		this.description = menu.getDescription();
		this.child = new ArrayList<MenuConfigVo>();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getControlUrl() {
		return controlUrl;
	}

	public void setControlUrl(String controlUrl) {
		this.controlUrl = controlUrl;
	}

    public Authoriy getAuthoriy() {
        return authoriy;
    }

    public void setAuthoriy(Authoriy authoriy) {
        this.authoriy = authoriy;
    }
/*public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}*/

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MenuConfigVo> getChild() {
		return child;
	}

	public void setChild(List<MenuConfigVo> child) {
		this.child = child;
	}
	
}
