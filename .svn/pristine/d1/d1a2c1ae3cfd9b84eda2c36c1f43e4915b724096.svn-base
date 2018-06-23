package com.sinosoft.qualityRecords.euqipmentOperation.model;

import java.io.Serializable;

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
@Table(name=" t_instrumenttation_info")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class EuqipmentOperation implements Serializable{
	private Long  id ;// NULL,
	private String handoverdate ;//   -- 交接日期 
	private String handperson;// varchar(20),    -- 交班人 
	private String receiveperson;// varchar(20),    -- 接班人 
	private String runtime;// varchar(20),    -- 运行时间 
	private String downtimehours;//  varchar(20),    -- 故障停机小时 
	private String intactstatus;// varchar(20),    -- 完好状态 
	private String faultrepairrecords;// varchar(200),    -- 故障维修记录 
	private String isreport ;//tinyint,    -- 是否上报 0 否 1 是 
	private String istroubleclear;// tinyint,    -- 故障是否排除 0 否 1 是 
	private String elserecord;// varchar(200)    -- 其他维修记录 
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
	@Column(name="handover_date",length=20)
	@SearchableProperty
	public String getHandoverdate() {
		return handoverdate;
	}
	public void setHandoverdate(String handoverdate) {
		this.handoverdate = handoverdate;
	}
	@Column(name="qualified_medicine_id")
	@SearchableProperty
	public String getHandperson() {
		return handperson;
	}
	public void setHandperson(String handperson) {
		this.handperson = handperson;
	}
	@Column(name="receive_person",length=20)
	@SearchableProperty
	public String getReceiveperson() {
		return receiveperson;
	}
	public void setReceiveperson(String receiveperson) {
		this.receiveperson = receiveperson;
	}
	@Column(name="runtime",length=20)
	@SearchableProperty
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	@Column(name="downtimehours",length=20)
	@SearchableProperty
	public String getDowntimehours() {
		return downtimehours;
	}
	public void setDowntimehours(String downtimehours) {
		this.downtimehours = downtimehours;
	}
	@Column(name="intact_status",length=20)
	@SearchableProperty
	public String getIntactstatus() {
		return intactstatus;
	}
	public void setIntactstatus(String intactstatus) {
		this.intactstatus = intactstatus;
	}
	@Column(name="fault_repair_records",length=200)
	@SearchableProperty
	public String getFaultrepairrecords() {
		return faultrepairrecords;
	}
	public void setFaultrepairrecords(String faultrepairrecords) {
		this.faultrepairrecords = faultrepairrecords;
	}
	@Column(name="is_report",length=20)
	@SearchableProperty
	public String getIsreport() {
		return isreport;
	}
	public void setIsreport(String isreport) {
		this.isreport = isreport;
	}
	@Column(name="is_troubleclear",length=20)
	@SearchableProperty
	public String getIstroubleclear() {
		return istroubleclear;
	}
	public void setIstroubleclear(String istroubleclear) {
		this.istroubleclear = istroubleclear;
	}
	@Column(name="else_record",length=200)
	@SearchableProperty
	public String getElserecord() {
		return elserecord;
	}
	public void setElserecord(String elserecord) {
		this.elserecord = elserecord;
	}


}
