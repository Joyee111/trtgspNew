package com.sinosoft.authoriy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@SuppressWarnings("serial")
@Entity
@Table(name="TRTHR_AUTHORIY")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Searchable
public class Authoriy implements Serializable{
	private Long authoriyid;
	private String authoriyname;
	private String description;
	private Date createtime;
	private Long parentid;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AUTHORIYID")
    @SearchableId
	public Long getAuthoriyid() {
		return authoriyid;
	}
	public void setAuthoriyid(Long authoriyid) {
		this.authoriyid = authoriyid;
	}
	
    @Column(name="AUTHORIYNAME",length=40)
    @SearchableProperty
	public String getAuthoriyname() {
		return authoriyname;
	}
	public void setAuthoriyname(String authoriyname) {
		this.authoriyname = authoriyname;
	}
	
	@Column(name="DESCRIPTION",length=100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="CREATETIME")
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Column(name="PARENTID")
	@SearchableProperty
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
}
