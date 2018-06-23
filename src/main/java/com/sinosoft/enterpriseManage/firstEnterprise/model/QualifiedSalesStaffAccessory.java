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
@Table(name="t_qualified_sales_staff_archives")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualifiedSalesStaffAccessory implements Serializable {
	private long id ;//主键
	private long qualified_sales_staff_id;//购货单位ID
	private String project_name ;//项目名称；
	private String changeContent;//修改内容
	private User modifier;//修改人ID
	private Date modified_time;//修改时间
	private String reason;//修改原因
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="qualified_sales_staff_id")
	public long getQualified_sales_staff_id() {
		return qualified_sales_staff_id;
	}
	public void setQualified_sales_staff_id(long qualified_sales_staff_id) {
		this.qualified_sales_staff_id = qualified_sales_staff_id;
	}
	@Column(name="project_name",length=655)
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String projectName) {
		project_name = projectName;
	}
	@Column(name="changeContent",length=655)
	public String getChangeContent() {
		return changeContent;
	}
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getModifier() {
		return modifier;
	}
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	@Column(name="modified_time")
	public Date getModified_time() {
		return modified_time;
	}
	public void setModified_time(Date modifiedTime) {
		modified_time = modifiedTime;
	}
	@Column(name="reason",length=655)
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
