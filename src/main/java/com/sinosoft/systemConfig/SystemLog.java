package com.sinosoft.systemConfig;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;


@Entity
@Table(name = "TRTHR_LOG_MESSAGE")
@Searchable
@XmlRootElement
public class SystemLog implements Serializable {
	private Long logId;
	private String logType;
	private String description;
	private Date createTime;
	private String logLevel;
	private String btime;
	private String etime;
	@Transient
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	
	@Transient
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	@Column(name = "LOGID")
	public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	
	@Column(name = "LOGTPYE", length = 10)
	@SearchableProperty
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	@Column(name = "DESCRIPTION", length = 200)
	@SearchableProperty
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "CREATETIME")
	@SearchableProperty
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "LOGLEVEL", length = 10)
	@SearchableProperty
	public String getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}
	

}
