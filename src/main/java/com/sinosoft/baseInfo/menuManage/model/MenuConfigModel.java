package com.sinosoft.baseInfo.menuManage.model;

import javax.persistence.*;

import com.sinosoft.authoriy.Authoriy;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
@Entity
@Table(name = "MenuConfig")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class MenuConfigModel implements Serializable {

	private long id;
	private String menuName;
	private String uniqueKey;
	private String controlUrl;
    private Authoriy authoriy;
	/*private String permission;*/
	private long parentId;
	private String description;
	private long extInfotempId;
	
//--------------------------------------------------------------------------
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "menuName")
	@SearchableProperty
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "uniqueKey")
	@SearchableProperty
	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	@Column(name = "controlUrl")
	@SearchableProperty
	public String getControlUrl() {
		return controlUrl;
	}

	public void setControlUrl(String controlUrl) {
		this.controlUrl = controlUrl;
	}

	/*@Column(name = "permission")
	@SearchableProperty
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}*/
    @ManyToOne
    @JoinColumn(name = "authoriyId")
    public Authoriy getAuthoriy() {
        return authoriy;
    }

    public void setAuthoriy(Authoriy authoriy) {
        this.authoriy = authoriy;
    }

    @Column(name = "parentId")
	@SearchableProperty
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "description")
	@SearchableProperty
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "extInfotempId")
	@SearchableProperty
	public long getExtInfotempId() {
		return extInfotempId;
	}

	public void setExtInfotempId(long extInfotempId) {
		this.extInfotempId = extInfotempId;
	}

}