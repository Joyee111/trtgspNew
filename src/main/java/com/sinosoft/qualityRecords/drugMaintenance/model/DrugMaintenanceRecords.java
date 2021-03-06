package com.sinosoft.qualityRecords.drugMaintenance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sinosoft.user.User;
@Entity
@Table(name="t_drugMaintenance_records")
public class DrugMaintenanceRecords implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -391629297600067385L;
	private Long id;//主键
	private Long drugMaintenanceId;
	private String projectName;//项目名称
	private String changeContent;//变更内容
	private User modityUser;//变更人
	private String changeReason;//变更原因
	private Date modityDate;//变更时间
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="drugMaintenance_id")
	public Long getDrugMaintenanceId() {
		return drugMaintenanceId;
	}
	public void setDrugMaintenanceId(Long drugMaintenanceId) {
		this.drugMaintenanceId = drugMaintenanceId;
	}
	@Column(name="project_name", length=200)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Column(name="change_content", length=200)
	public String getChangeContent() {
		return changeContent;
	}
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	@ManyToOne(cascade = CascadeType.REFRESH, targetEntity = User.class)
	@JoinColumn(name="modity_user_id")
	public User getModityUser() {
		return modityUser;
	}
	public void setModityUser(User modityUser) {
		this.modityUser = modityUser;
	}
	@Column(name="change_reason",length=200)
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}
	@Column(name = "modity_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getModityDate() {
		return modityDate;
	}
	public void setModityDate(Date modityDate) {
		this.modityDate = modityDate;
	}
}
