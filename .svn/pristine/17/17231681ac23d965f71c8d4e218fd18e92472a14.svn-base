package com.sinosoft.drugState.inspectionRecords.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name = "t_ticket_samples")
@Transactional
public class TicketSamples implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 7126767982885957568L;
	private Long id;
	private String ticketSamplesName;
	private String ticketSamplesPath;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "ticket_samples_name",length=50)
	public String getTicketSamplesName() {
		return ticketSamplesName;
	}
	public void setTicketSamplesName(String ticketSamplesName) {
		this.ticketSamplesName = ticketSamplesName;
	}
	@Column(name = "ticket_samples_path",length=50)
	public String getTicketSamplesPath() {
		return ticketSamplesPath;
	}
	public void setTicketSamplesPath(String ticketSamplesPath) {
		this.ticketSamplesPath = ticketSamplesPath;
	}
	
}
