package com.sinosoft.qualityRecords.infoFeedback.model;

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
@Table(name="t_InfoFeedback_item")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class InfoFeedbackItem implements Serializable {
	
	private Long id;
	private Long infoFeedbackId;//投诉信息id
	private String zhipaiId;//指派人的id 
//	private InfoFeedback infoFeedback;
	private String type;//指派类型0表示所在部门意见、1表示经营质量办意见、2表示有关部门意见、3表示处理结果结果
	private String content;//意见内容
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@SearchableProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="infoFeedback_Id")
	@SearchableProperty
	public Long getInfoFeedbackId() {
		return infoFeedbackId;
	}
	public void setInfoFeedbackId(Long infoFeedbackId) {
		this.infoFeedbackId = infoFeedbackId;
	}
	@Column(name="zhipaiId")
	@SearchableProperty
	public String getZhipaiId() {
		return zhipaiId;
	}
	public void setZhipaiId(String zhipaiId) {
		this.zhipaiId = zhipaiId;
	}
	@Column(name="type",length=2)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="content",columnDefinition="text")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
