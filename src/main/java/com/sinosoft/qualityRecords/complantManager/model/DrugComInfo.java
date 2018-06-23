package com.sinosoft.qualityRecords.complantManager.model;





import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.role.Role;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@SuppressWarnings("serial")
@Entity
@Table(name="t_complaint_info")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugComInfo implements Serializable {
	private Long id;
	private String bianhao ;//编号

	private String  quaMedicId ;//合格药品id
	private String  jixing  ;//剂型
	private String  guige  ;//规格
	private String  pihao  ;//批号

	private String complainant;//投诉人
	private String phone;//联系电话
	private String address;//联系地址
	private String quantity;//数量
	private String compcontent;//投诉内容
	private String handsuggestion;//调查与评估
	private String results;//处理措施
	private String infofree;//反馈与事后跟踪
	private Long modifierid;//修改人-id
	private Date modifiedtime ;//填写时间
	private String jieshoubumen;//接受部门
	private String tousufangshi;//投诉方式
	private String roleId;//角色id
	private Role role;
	
	private Long updateModifierid;//修改人-id
	private Date updateMdifiedtime ;//修改时间
	
	@Column(name="roleId",length =20)
	@SearchableProperty
	public String getRoleId() {
		return roleId;
	}
	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Transient
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Column(name="jieshoubumen",length=20)
	@SearchableProperty
	public String getJieshoubumen() {
		return jieshoubumen;
	}
	public void setJieshoubumen(String jieshoubumen) {
		this.jieshoubumen = jieshoubumen;
	}
	@Column(name="tousufangshi" ,length=50)
	@SearchableProperty
	public String getTousufangshi() {
		return tousufangshi;
	}
	public void setTousufangshi(String tousufangshi) {
		this.tousufangshi = tousufangshi;
	}
	private QualityMidicine qualityMidicine;
	
//	@ManyToOne(targetEntity=QualityMidicine.class,cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
//	@Fetch(FetchMode.JOIN)
//	@JoinColumn(name="quaMedicIds",updatable=false)
	@Transient
	public QualityMidicine getQualityMidicine() {
		return qualityMidicine;
	}
	public void setQualityMidicine(QualityMidicine qualityMidicine) {
		this.qualityMidicine = qualityMidicine;
	}


		@Column(name="modifier_id")
	@SearchableProperty
	public Long getModifierid() {
		return modifierid;
	}
	public void setModifierid(Long modifierid) {
		this.modifierid = modifierid;
	}
	@Column(name="bianhao",length=50)
    @SearchableProperty
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	@Column(name="modified_time")
	@SearchableProperty
	public Date getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	@Column(name="updateModifierid")
	@SearchableProperty
	public Long getUpdateModifierid() {
		return updateModifierid;
	}

	public void setUpdateModifierid(Long updateModifierid) {
		this.updateModifierid = updateModifierid;
	}
	@Column(name="updateMdifiedtime")
	@SearchableProperty
	public Date getUpdateMdifiedtime() {
		return updateMdifiedtime;
	}

	public void setUpdateMdifiedtime(Date updateMdifiedtime) {
		this.updateMdifiedtime = updateMdifiedtime;
	}
	
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
	@Column(name="qualified_medicine_id",length=50)
	@SearchableProperty
	public String getQuaMedicId() {
		return quaMedicId;
	}
	public void setQuaMedicId(String quaMedicId) {
		this.quaMedicId = quaMedicId;
	}

	@Column(name="complainant",length=20)
    @SearchableProperty
	public String getComplainant() {
		return complainant;
	}
	public void setComplainant(String complainant) {
		this.complainant = complainant;
	}
	@Column(name="phone",length=20)
    @SearchableProperty
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="address",length=50)
    @SearchableProperty
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="quantity",length=50)
    @SearchableProperty
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Column(name="complain_content",length=6555)
    @SearchableProperty
    public String getCompcontent() {
		return compcontent;
	}
	public void setCompcontent(String compcontent) {
		this.compcontent = compcontent;
	}
	
	@Column(name="handling_suggestion",length=6555)
    @SearchableProperty
	public String getHandsuggestion() {
		return handsuggestion;
	}
	
	public void setHandsuggestion(String handsuggestion) {
		this.handsuggestion = handsuggestion;
	}
	@Column(name="results",length=6555)
    @SearchableProperty
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	@Column(name="infofree",length=6555)
    @SearchableProperty
	public String getInfofree() {
		return infofree;
	}
	public void setInfofree(String infofree) {
		this.infofree = infofree;
	}
	@Column(name="jixing",length=100)
    @SearchableProperty
	public String getJixing() {
		return jixing;
	}

	public void setJixing(String jixing) {
		this.jixing = jixing;
	}
	@Column(name="guige",length=100)
    @SearchableProperty
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	@Column(name="pihao",length=100)
    @SearchableProperty
	public String getPihao() {
		return pihao;
	}

	public void setPihao(String pihao) {
		this.pihao = pihao;
	}

}
