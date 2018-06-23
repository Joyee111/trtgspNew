package com.sinosoft.drugState.accepreturn.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.user.User;
/**
 * 申请回退记录
 * @author whn
 *
 */
@Entity
@Table(name="t_return_check_accept_rollback_records")
@Transactional
public class ReturnCheckAcceptRollBackRecords implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -391629297600067385L;
	private Long id;//主键
	private Long returnCheckAcceptNoteId;
	private User applicant;//申请人
	private String rollbackReason;//回退原因
	private Date applyDate;//申请时间
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="return_check_accept_noteId") 
	public Long getReturnCheckAcceptNoteId() {
		return returnCheckAcceptNoteId;
	}
	public void setReturnCheckAcceptNoteId(Long returnCheckAcceptNoteId) {
		this.returnCheckAcceptNoteId = returnCheckAcceptNoteId;
	}
	
	@ManyToOne(cascade = CascadeType.REFRESH, targetEntity = User.class)
	@JoinColumn(name="applicant_id")
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	
	@Column(name="rollback_reason",length=200)
	public String getRollbackReason() {
		return rollbackReason;
	}
	public void setRollbackReason(String rollbackReason) {
		this.rollbackReason = rollbackReason;
	}
	
	@Column(name = "apply_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	
	
}
