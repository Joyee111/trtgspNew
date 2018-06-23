package com.sinosoft.drugState.acceptance.model;

import com.sinosoft.user.User;

public class CheckAcceptVO {
	private Long checkAcceptId;//验收单ID
	private String checkAcceptNumbe;//单据号
	private String commonName;//品名
	private String batchNumber;//批号
	private String quality;//数量
	private String qualityQuality;//合格数量
	private String arrivalDate;//到货日期
	private String checkAcceptDate;//验收日期
	private String checkAcceptDate2;//验收日期2
	private String checkIsQualified;//验收状态
	private String checkIsQualified2;//验收状态2
	private String checkConclusion;//检查结论
	private String checkConclusion2;//检查结论2
	private String checkUser;//验收人员
	private Long accepterID;//验收人员2ID
	private String checkUser2;//验收人员2
	public CheckAcceptVO(){
		
	}
	public CheckAcceptVO(CheckAcceptNote cn , CheckacceptItem ci,User user){
		this.checkAcceptId = cn.getId();
		this.checkAcceptNumbe = cn.getNumber();
		this.commonName = ci.getQualityMidicine().getCommonname();
		this.batchNumber = ci.getBatchProduction();
		this.quality = ci.getQuantity().toString();
		this.qualityQuality = ci.getQualifiedQuantity().toString();
		this.arrivalDate = cn.getArrivalDate();
		this.checkAcceptDate = cn.getCheckAcceptDate();
		this.checkIsQualified = cn.getCheckIsQualified();
		this.checkConclusion = cn.getCheckConclusion();
		this.checkUser = user.getRealname();
		this.setCheckAcceptDate2(cn.getCheckAcceptDate2());
		this.setCheckIsQualified2(cn.getCheckIsQualified2());
		this.setCheckConclusion2(cn.getCheckConclusion2());
		this.setAccepterID(cn.getAccepterID());
	}
	public Long getCheckAcceptId() {
		return checkAcceptId;
	}
	public void setCheckAcceptId(Long checkAcceptId) {
		this.checkAcceptId = checkAcceptId;
	}
	
	public String getCheckAcceptNumbe() {
		return checkAcceptNumbe;
	}
	public void setCheckAcceptNumbe(String checkAcceptNumbe) {
		this.checkAcceptNumbe = checkAcceptNumbe;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	public String getQualityQuality() {
		return qualityQuality;
	}
	public void setQualityQuality(String qualityQuality) {
		this.qualityQuality = qualityQuality;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getCheckAcceptDate() {
		return checkAcceptDate;
	}
	public void setCheckAcceptDate(String checkAcceptDate) {
		this.checkAcceptDate = checkAcceptDate;
	}
	public String getCheckIsQualified() {
		return checkIsQualified;
	}
	public void setCheckIsQualified(String checkIsQualified) {
		this.checkIsQualified = checkIsQualified;
	}
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}
	public String getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}
	public void setCheckAcceptDate2(String checkAcceptDate2) {
		this.checkAcceptDate2 = checkAcceptDate2;
	}
	public String getCheckAcceptDate2() {
		return checkAcceptDate2;
	}
	public void setCheckIsQualified2(String checkIsQualified2) {
		this.checkIsQualified2 = checkIsQualified2;
	}
	public String getCheckIsQualified2() {
		return checkIsQualified2;
	}
	public void setCheckConclusion2(String checkConclusion2) {
		this.checkConclusion2 = checkConclusion2;
	}
	public String getCheckConclusion2() {
		return checkConclusion2;
	}
	public void setAccepterID(Long accepterID) {
		this.accepterID = accepterID;
	}
	public Long getAccepterID() {
		return accepterID;
	}
	public void setCheckUser2(String checkUser2) {
		this.checkUser2 = checkUser2;
	}
	public String getCheckUser2() {
		return checkUser2;
	}

	
}
