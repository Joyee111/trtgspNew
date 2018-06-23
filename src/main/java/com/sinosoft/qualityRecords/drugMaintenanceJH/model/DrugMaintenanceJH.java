package com.sinosoft.qualityRecords.drugMaintenanceJH.model;

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
/**
 * 嘉和药品的养护检查记录
 * @author 王海楠
 * @date 2016-7-5 14:51:22
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_maintain_info_JH ")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class DrugMaintenanceJH implements Serializable{
	private Long id;//NOT NULL
	private String customerId;//货主代码
	private String customerName;//货主名称
	private String medcCode;//商品编码
	private String medcName;//商品名称
	private String specifications;//规格
	private String unit;//计量单位
	private String dosageforms;//剂型
	private String supplier;//生产厂家
	private String licenseNumber;//批准文号
	private String trademark;//商标
	private Long quantity;//检查数量
	private String batchNumber;//批号
	private String endTime;//有效期至
	private String result;//包装外观及结论
	private String conclusion;//处理意见
	private String conserveType;//养护类型
	private String conservationStaff;//养护人
	private String maintainDate;//养护日期
	private String arrivalDate;//入库日期
	private String printFlag;//打印标志
	private String conservationStaff2;//第二养护人
	public DrugMaintenanceJH(){
		
	}
	public DrugMaintenanceJH(String customerId,String customerName,	String medcCode,String medcName,String specifications,
			String unit,String dosageforms,	String supplier,String licenseNumber,String trademark,
			Long quantity,String batchNumber,String endTime,String result,String conclusion,
			String conserveType,String conservationStaff,String maintainDate,String arrivalDate,String printFlag,
			String conservationStaff2
			){
		this.customerId = customerId;
		this.customerName = customerName;
		this.medcCode = medcCode;
		this.medcName = medcName;
		this.specifications = specifications;
		this.unit = unit;
		this.dosageforms = dosageforms;
		this.supplier = supplier;
		this.licenseNumber = licenseNumber;
		this.trademark = trademark;
		this.quantity = quantity;
		this.batchNumber = batchNumber;
		this.endTime = endTime;
		this.result = result;
		this.conclusion = conclusion;
		this.conserveType = conserveType;
		this.conservationStaff = conservationStaff;
		this.maintainDate = maintainDate;
		this.arrivalDate = arrivalDate;
		this.printFlag = printFlag;
		this.conservationStaff2 = conservationStaff2;
	}
	
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
	@Column(name="customer_id")
	@SearchableProperty
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Column(name="customer_name")
	@SearchableProperty
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(name="medc_code")
	@SearchableProperty
	public String getMedcCode() {
		return medcCode;
	}
	public void setMedcCode(String medcCode) {
		this.medcCode = medcCode;
	}
	@Column(name="medc_name")
	@SearchableProperty
	public String getMedcName() {
		return medcName;
	}
	public void setMedcName(String medcName) {
		this.medcName = medcName;
	}
	@Column(name="specifications")
	@SearchableProperty
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Column(name="unit")
	@SearchableProperty
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Column(name="dosageforms")
	@SearchableProperty
	public String getDosageforms() {
		return dosageforms;
	}
	public void setDosageforms(String dosageforms) {
		this.dosageforms = dosageforms;
	}
	@Column(name="supplier")
	@SearchableProperty
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	@Column(name="license_number")
	@SearchableProperty
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	@Column(name="trademark")
	@SearchableProperty
	public String getTrademark() {
		return trademark;
	}
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	@Column(name="quantity")
	@SearchableProperty
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	@Column(name="batch_number")
	@SearchableProperty
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	@Column(name="end_time")
	@SearchableProperty
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Column(name="result")
	@SearchableProperty
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Column(name="conclusion")
	@SearchableProperty
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	@Column(name="conserve_type")
	@SearchableProperty
	public String getConserveType() {
		return conserveType;
	}
	public void setConserveType(String conserveType) {
		this.conserveType = conserveType;
	}
	@Column(name="conservation_staff")
	@SearchableProperty
	public String getConservationStaff() {
		return conservationStaff;
	}
	public void setConservationStaff(String conservationStaff) {
		this.conservationStaff = conservationStaff;
	}
	@Column(name="maintain_date")
	@SearchableProperty
	public String getMaintainDate() {
		return maintainDate;
	}
	public void setMaintainDate(String maintainDate) {
		this.maintainDate = maintainDate;
	}
	@Column(name="arrivale_date")
	@SearchableProperty
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	@Column(name="print_flag")
	@SearchableProperty
	public String getPrintFlag() {
		return printFlag;
	}
	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}
	@Column(name="conservation_staff2")
	@SearchableProperty
	public String getConservationStaff2() {
		return conservationStaff2;
	}
	public void setConservationStaff2(String conservationStaff2) {
		this.conservationStaff2 = conservationStaff2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
