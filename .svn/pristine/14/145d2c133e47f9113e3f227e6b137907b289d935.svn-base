package com.sinosoft.qualityRecords.temRecords.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("serial")
@Entity
@Table(name=" t_humiture")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class TemRecords implements Serializable{
	private Long id; //int NOT NULL
	private String sensorIP;// varchar(50),    -- 传感器IP地址 
	private String sensorname;// varchar(100),    -- 传感器位置 
	 private Date  datetime;//,    -- 时间 
	private String temperature;// varchar(50),    -- 温度 
	private String humidity;// varchar(50)    -- 湿度 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="sensorIP",length=50)
	@SearchableProperty
	public String getSensorIP() {
		return sensorIP;
	}
	public void setSensorIP(String sensorIP) {
		this.sensorIP = sensorIP;
	}
	@Column(name="sensorname",length=100)
	@SearchableProperty
	public String getSensorname() {
		return sensorname;
	}
	public void setSensorname(String sensorname) {
		this.sensorname = sensorname;
	}
	@Column(name="datetime")
	@SearchableProperty
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Column(name="temperature",length=50)
	@SearchableProperty
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	@Column(name="humidity",length=50)
	@SearchableProperty
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

}
