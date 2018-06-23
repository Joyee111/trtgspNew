package com.sinosoft.enterpriseManage.firstEnterprise.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.user.User;
@SuppressWarnings("serial")
@Entity
@Table(name="t_qualifiedSupplier_archives")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualifiedSupplierArchives implements Serializable {//合格供应商变更档案
	private long id;//主键ID
	private long supplierId;//供应商ID
	private String projectName;//项目名称
	private String changeContent;//变更内容
	private User modifierId;//变更人ID
	private Date modifiedTime;//变更时间
	private String reason;//变更原因
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="supplier_id")
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	@Column(name="project_name",length=100)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Column(name="change_content",length=500)
	public String getChangeContent() {
		return changeContent;
	}
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getModifierId() {
		return modifierId;
	}
	public void setModifierId(User modifierId) {
		this.modifierId = modifierId;
	}
	@Column(name="modified_time")
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Column(name="reason",length=655)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
