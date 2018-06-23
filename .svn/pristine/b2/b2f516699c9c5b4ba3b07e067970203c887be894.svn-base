package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;

/**
 * 
* @ClassName: PurchasePlanDto 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 采购计划dto
 */
public class PurchasePlanDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1212312L;
	private String nd;//年度
	private String jd;//季度
	private String jhlb;//计划类别
	private String hh;//货号
	private String tymc;//通用名称
	private String gg;//规格
	private String pfdw;//批发单位
	private String sl;//数量
	private String je;//金额
	private String bz;//备注
	public PurchasePlanDto(PurchasePlanItem planItem){
			this.nd = planItem.getPurchasePlan().getYear();
			this.jd = planItem.getPurchasePlan().getSeason();
			this.jhlb = planItem.getPlanType();
			this.hh = planItem.getQualityMidicine().getMedicinalNo();
			this.tymc = planItem.getQualityMidicine().getCommonname();
			this.gg = planItem.getQualityMidicine().getDosageforms().getFormName();
			this.pfdw = planItem.getPurchasePlan().getQualifiedSupplier().getCustomerName();
			this.sl = planItem.getQuantity();
			this.je= planItem.getTaxPrice();
			this.bz = planItem.getRemark();
	}
	public String getNd() {
		return nd;
	}
	public void setNd(String nd) {
		this.nd = nd;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getJhlb() {
		return jhlb;
	}
	public void setJhlb(String jhlb) {
		this.jhlb = jhlb;
	}
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getTymc() {
		return tymc;
	}
	public void setTymc(String tymc) {
		this.tymc = tymc;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getPfdw() {
		return pfdw;
	}
	public void setPfdw(String pfdw) {
		this.pfdw = pfdw;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
}
