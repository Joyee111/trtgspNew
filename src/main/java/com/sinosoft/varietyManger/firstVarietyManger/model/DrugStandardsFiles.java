package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;
import java.util.Date;

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
 * @version 创建时间：Jun 5, 2013 11:03:47 AM
 * 类说明
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_quality_standard")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugStandardsFiles implements Serializable {
	private Long id;//主键
	private String number;//编号
	private String commonName;//通用名称
	private String formsName;//剂型
	private String standardAccord;//标准依据
	private Date createDate;//建档日期
	private String createUserName;//建档人
	private String remark;//备注
	private String attachmentPath;//附件路径
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="common_name",length=100)
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	@Column(name="forms_name",length=100)
	public String getFormsName() {
		return formsName;
	}
	public void setFormsName(String formsName) {
		this.formsName = formsName;
	}
	@Column(name="number",length=50)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	/*@Column(name="common_name",length=50)
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}*/
	@Column(name="standard_according")
	public String getStandardAccord() {
		return standardAccord;
	}
	public void setStandardAccord(String standardAccord) {
		this.standardAccord = standardAccord;
	}
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name="create_username")
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="attachment_path")
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	
}
