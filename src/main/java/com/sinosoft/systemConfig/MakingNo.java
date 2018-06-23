package com.sinosoft.systemConfig;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
@Entity
@Table(name = "t_making_no")
@Searchable
@XmlRootElement
public class MakingNo implements Serializable{
	/***
	id int NOT NULL,
	name varchar(50),
	no varchar(40)
	 * **/
	private Long id;
	private String name;
	private String no;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "name",length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "no",length=40)
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
}
