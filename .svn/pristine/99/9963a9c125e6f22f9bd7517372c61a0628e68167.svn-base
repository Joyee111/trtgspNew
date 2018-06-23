package com.sinosoft.varietyManger.firstVarietyManger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="t_quality_track_record")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class QualityTrackRecord implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 3191418178547243749L;
	
	private Long id ;//主键ID
	//private Long qualifiedMedicineId;//合格药品ID
	private QualityFiles qualityFiles;
	private String projectName;//项目名称
	private String changContent;//变更内容
	private Long modifierId;//修改人
	private Date modifiedTime;//修改时间
	private String accessoryPath;//附件
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,targetEntity=QualityFiles.class)
	@JoinColumn(name="qualityFiles_id")
	public QualityFiles getQualityFiles() {
		return qualityFiles;
	}
	public void setQualityFiles(QualityFiles qualityFiles) {
		this.qualityFiles = qualityFiles;
	}
	@Column(name="project_name",length=655)
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Column(name="change_content",length=655)
	public String getChangContent() {
		return changContent;
	}
	public void setChangContent(String changContent) {
		this.changContent = changContent;
	}
	@Column(name="modifier_id")
	public Long getModifierId() {
		return modifierId;
	}
	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	@Column(name="modified_time")
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Column(name="accessory_path",length=100)
	public String getAccessoryPath() {
		return accessoryPath;
	}
	public void setAccessoryPath(String accessoryPath) {
		this.accessoryPath = accessoryPath;
	}
	
	
	
}
