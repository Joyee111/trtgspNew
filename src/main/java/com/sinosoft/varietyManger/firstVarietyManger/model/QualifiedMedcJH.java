package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="t_medc_jh")
@Transactional
public class QualifiedMedcJH implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6114115979065726731L;
	private Long id;//主键
	private String medicNo;//药品号码
	private String medcNamePy;//
	private Long medc_id;
	private String flag;//区分是否是真正的嘉和品种
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="medc_no",length=20)
	public String getMedicNo() {
		return medicNo;
	}
	public void setMedicNo(String medicNo) {
		this.medicNo = medicNo;
	}
	@Column(name="medc_name_py")
	public String getMedcNamePy() {
		return medcNamePy;
	}
	public void setMedcNamePy(String medcNamePy) {
		this.medcNamePy = medcNamePy;
	}
	@Column(name="medc_id")
	public Long getMedc_id() {
		return medc_id;
	}
	public void setMedc_id(Long medcId) {
		medc_id = medcId;
	}
	@Column(name="flag",length=2)
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
