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
@Table(name = "TRTHR_SYS_CONFIG")
@Searchable
@XmlRootElement
public class SystemConfig implements Serializable {

	private Long configId;
	private String configKey;
	private String configValue;
	private String configDes;
	private Date createTime;

	private String btime;
	private String etime;
	private String key;

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

	@Transient
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	@Column(name = "CONFIGID")
	public Long getConfigId() {
		return configId;
	}

	@Column(name = "CONFIGKEY", length = 20)
	@SearchableProperty
	public String getConfigKey() {
		return configKey;
	}

	@Column(name = "CONFIGVALUE", length = 50)
	@SearchableProperty
	public String getConfigValue() {
		return configValue;
	}

	@Column(name = "CONFIGDES", length = 100)
	@SearchableProperty
	public String getConfigDes() {
		return configDes;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public void setConfigDes(String configDes) {
		this.configDes = configDes;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}

}
