package com.sinosoft.user;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UserCountView implements Serializable {
	
	private String company;
	private String territory;
	private String grade;
	private Date startime;
	private Date endtime;
	private String group;
	private String order;
	private String sc;
	private String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	private int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public UserCountView(){
		
	}
	
//	@Override
//	public String toString() {
//		return "UserCountView [company=" + company + ", endtime=" + endtime
//				+ ", grade=" + grade + ", group=" + group + ", order=" + order
//				+ ", sc=" + sc + ", startime=" + startime + ", territory="
//				+ territory + "]";
//	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getStartime() {
		return startime;
	}
	public void setStartime(Date startime) {
		this.startime = startime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
}
