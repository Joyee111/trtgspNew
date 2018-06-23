package com.sinosoft.systemLog.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="t_system_log")
@Transactional
public class SysLog implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -8950488281654140607L;
	private Long id;//主键
	private Date log_date;//日志操作时间
	private String action_person;//操作人员
	private String action;//动作
	private String module;//模块
	private String action_type;//动作类型
	private String ip;//IP地址
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="log_id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="log_date", length=20)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date logDate) {
		log_date = logDate;
	}
	@Column(name="action_person",length=50)
	public String getAction_person() {
		return action_person;
	}
	public void setAction_person(String actionPerson) {
		action_person = actionPerson;
	}
	@Column(name="action",length=500)
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Column(name="module",length=50)
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	@Column(name="action_type",length=50)
	public String getAction_type() {
		return action_type;
	}
	public void setAction_type(String actionType) {
		action_type = actionType;
	}
	@Column(name="ip",length=100)
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
