package com.sinosoft.systemConfig;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lfl:
 * @version 创建时间：Jun 13, 2013 3:40:59 PM
 * 类说明  预警设置
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_warnConfig")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class WarnConfig implements Serializable {
	private long id;//主键ID
	private String  limit_name;//预警名称 
	private String  limit_day;// 预警天数 
	private String  use_flag;//使用标志 
	private String  description;//描述
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="limit_name",length=50)
	public String getLimit_name() {
		return limit_name;
	}
	public void setLimit_name(String limitName) {
		limit_name = limitName;
	}
	@Column(name="limit_day",length=5)
	public String getLimit_day() {
		return limit_day;
	}
	public void setLimit_day(String limitDay) {
		limit_day = limitDay;
	}
	@Column(name="use_flag",length=2)
	public String getUse_flag() {
		return use_flag;
	}
	public void setUse_flag(String useFlag) {
		use_flag = useFlag;
	}
	@Column(name="description",length=655)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
