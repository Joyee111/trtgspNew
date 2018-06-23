package com.sinosoft.dictionary.mode;

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
 * @version 创建时间：Jun 6, 2013 2:10:48 PM
 * 类说明
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_dosage_form")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugFormDictionary implements Serializable {
	private Long id;//剂型ID
	private String formName;//剂型名称
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="form_name")
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	
}
