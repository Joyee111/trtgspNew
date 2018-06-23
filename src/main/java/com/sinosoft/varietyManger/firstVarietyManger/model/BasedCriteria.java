package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
* @ClassName: BasedCriteria 
* @author lfl
* @date 2013-7-10 下午05:47:53 
* @Description: TODO(质量标准依据依据依据依据)
 */
@Entity
@Table(name="t_based_criteria")
public class BasedCriteria implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -8114547914918093658L;
	private long basedCriteriaId;//主键ID
	private String basedCriteriaName;//标准依据名称
	private String basedCriteriaType;//标准依据类型
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="basedCriteriaId")
	public long getBasedCriteriaId() {
		return basedCriteriaId;
	}
	public void setBasedCriteriaId(long basedCriteriaId) {
		this.basedCriteriaId = basedCriteriaId;
	}
	@Column(name="basedCriteriaName",length=100)
	public String getBasedCriteriaName() {
		return basedCriteriaName;
	}
	public void setBasedCriteriaName(String basedCriteriaName) {
		this.basedCriteriaName = basedCriteriaName;
	}
	@Column(name="basedCriteriaType",length=20)
	public String getBasedCriteriaType() {
		return basedCriteriaType;
	}
	public void setBasedCriteriaType(String basedCriteriaType) {
		this.basedCriteriaType = basedCriteriaType;
	}
	

}
