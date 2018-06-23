package com.sinosoft.drugState.accepreturn.model;

public class ReturnCheckAcceptNoteVO {
	private Long id ;//退货验收单ID
	private String returnCheckAcceptNoteNumber;//退货验收单号
	private String commonName;//通用名称
	private String drugFrom;//剂型
	private String specification;//规格
	private String unit;//单位
	private String purchaseUnits;//退回单位
	private String arrivalDate;//到货日期
	private String acceptanceDate;//验收日期
	private String acceptanceDate2;//验收日期2
	private String inspectionResults;//验收结果
	private String inspectionResults2;//验收结果2
	private Long totalQuality;//数量
	private Long qualifiedQuality;//合格数量
	private String reviewTime;//复检日期
	private String visualExamination;//复检结论
	private Long invalidQuantity;//退回供应商数量
	private Long unqualifiedQuantity;//不合格品数量
	public ReturnCheckAcceptNoteVO(){
		
	}
	public ReturnCheckAcceptNoteVO(ReturnCheckAcceptNote acceptNote,ReturncheckItem checkItem){
		this.id = acceptNote.getId();
		this.returnCheckAcceptNoteNumber = acceptNote.getReturnNo();
		this.commonName = checkItem.getQualityMidicine().getCommonname();
		this.drugFrom = checkItem.getQualityMidicine().getDosageforms().getFormName();
		this.specification = checkItem.getQualityMidicine().getSpecifications();
		this.unit = checkItem.getQualityMidicine().getUnit();
		this.purchaseUnits = acceptNote.getQualifiedPurchaseUnits().getCustomerName();
		this.arrivalDate = acceptNote.getArrivalDate();
		this.acceptanceDate = acceptNote.getCheckAcceptDate();
		this.inspectionResults = acceptNote.getResult();
		this.totalQuality = checkItem.getQuantity();
		this.qualifiedQuality = checkItem.getQualifiedQuantity();
		this.reviewTime = acceptNote.getReviewTime();
		this.visualExamination = acceptNote.getVisualExamination();
		this.acceptanceDate2 = acceptNote.getCheckAcceptDate2();
		this.inspectionResults2 = acceptNote.getResult2();
		this.invalidQuantity=checkItem.getInvalidQuantity();
		this.unqualifiedQuantity=checkItem.getUnqualifiedQuantity();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReturnCheckAcceptNoteNumber() {
		return returnCheckAcceptNoteNumber;
	}
	public void setReturnCheckAcceptNoteNumber(String returnCheckAcceptNoteNumber) {
		this.returnCheckAcceptNoteNumber = returnCheckAcceptNoteNumber;
	}
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getDrugFrom() {
		return drugFrom;
	}
	public void setDrugFrom(String drugFrom) {
		this.drugFrom = drugFrom;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getPurchaseUnits() {
		return purchaseUnits;
	}
	public void setPurchaseUnits(String purchaseUnits) {
		this.purchaseUnits = purchaseUnits;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getAcceptanceDate() {
		return acceptanceDate;
	}
	public void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	public String getInspectionResults() {
		return inspectionResults;
	}
	public void setInspectionResults(String inspectionResults) {
		this.inspectionResults = inspectionResults;
	}
	public Long getTotalQuality() {
		return totalQuality;
	}
	public void setTotalQuality(Long totalQuality) {
		this.totalQuality = totalQuality;
	}
	
	public Long getInvalidQuantity() {
		return invalidQuantity;
	}
	public void setInvalidQuantity(Long invalidQuantity) {
		this.invalidQuantity = invalidQuantity;
	}
	
	public Long getUnqualifiedQuantity() {
		return unqualifiedQuantity;
	}
	public void setUnqualifiedQuantity(Long unqualifiedQuantity) {
		this.unqualifiedQuantity = unqualifiedQuantity;
	}
	
	public Long getQualifiedQuality() {
		return qualifiedQuality;
	}
	public void setQualifiedQuality(Long qualifiedQuality) {
		this.qualifiedQuality = qualifiedQuality;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	public String getVisualExamination() {
		return visualExamination;
	}
	public void setVisualExamination(String visualExamination) {
		this.visualExamination = visualExamination;
	}
	public void setAcceptanceDate2(String acceptanceDate2) {
		this.acceptanceDate2 = acceptanceDate2;
	}
	public String getAcceptanceDate2() {
		return acceptanceDate2;
	}
	public void setInspectionResults2(String inspectionResults2) {
		this.inspectionResults2 = inspectionResults2;
	}
	public String getInspectionResults2() {
		return inspectionResults2;
	}
	
}
