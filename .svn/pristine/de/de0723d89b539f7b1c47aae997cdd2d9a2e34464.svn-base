package com.sinosoft.varietyManger.firstVarietyManger.model;

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

/**
 * @author lfl:
 * @version 创建时间：Jun 8, 2013 10:55:15 AM
 * 类说明
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_qualified_medicine_archives")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualityMidicineRecords implements Serializable {
	private Long id;//主键
	private Long qulityMidicineId;//合格药品ID
	private String projectName;
	private String changeContent;
	private User modifyId;
	private Date modifyTime;
	private String modifyReason;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="qulityMidicineId")
	public Long getQulityMidicineId() {
		return qulityMidicineId;
	}
	public void setQulityMidicineId(Long qulityMidicineId) {
		this.qulityMidicineId = qulityMidicineId;
	}
	@Column(name="project_name",length=100)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Column(name="change_content",length=655)
	public String getChangeContent() {
		return changeContent;
	}
	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	public User getModifyId() {
		return modifyId;
	}
	public void setModifyId(User modifyId) {
		this.modifyId = modifyId;
	}
	@Column(name="modified_time")
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	@Column(name="modify_reason")
	public String getModifyReason() {
		return modifyReason;
	}
	public void setModifyReason(String modifyReason) {
		this.modifyReason = modifyReason;
	}
	
}
