package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;

/**
 * 
* @ClassName: PurchaseRetrunDto 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 药品购进退出dto
 */
public class PurchaseReturnDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214441L;
	private String thrq;//退货日期
	private String ypbh;//药品编号
	private String tymc;//通用名称
	private String jx;//剂型
	private String gg;//规格
	private String dw;//单位
	private String gjjg;//购进价格
	private String tcsl;//退出数量
	private String tcje;//退出金额
	private String ph;//批号
	private String sccs;//生产厂商
	private String yxqz;//有效期至
	private String cgy;//采购员
	public  PurchaseReturnDto(PurchaseReturnBill returnBill){
		this.thrq = returnBill.getReturnTime();
		this.ypbh = returnBill.getQualityMidicine().getMedicinalNo();
		this.tymc = returnBill.getQualityMidicine().getCommonname();
		this.jx = returnBill.getQualityMidicine().getDosageforms().getFormName();
		this.gg  = returnBill.getQualityMidicine().getSpecifications();
		this.dw = returnBill.getQualityMidicine().getUnit();
		this.gjjg = returnBill.getPuMoney();
		this.tcsl = returnBill.getQuantity().toString();
		this.tcje  = returnBill.getMoney();
		this.ph = returnBill.getBatchNumber();
		this.sccs = returnBill.getQualifiedSuppliers().getCustomerName();
		this.yxqz = returnBill.getEndTime();
		this.cgy = returnBill.getUser().getRealname();
		
	}
	public String getThrq() {
		return thrq;
	}
	public void setThrq(String thrq) {
		this.thrq = thrq;
	}
	public String getYpbh() {
		return ypbh;
	}
	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}
	public String getTymc() {
		return tymc;
	}
	public void setTymc(String tymc) {
		this.tymc = tymc;
	}
	public String getJx() {
		return jx;
	}
	public void setJx(String jx) {
		this.jx = jx;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getGjjg() {
		return gjjg;
	}
	public void setGjjg(String gjjg) {
		this.gjjg = gjjg;
	}
	public String getTcsl() {
		return tcsl;
	}
	public void setTcsl(String tcsl) {
		this.tcsl = tcsl;
	}
	public String getTcje() {
		return tcje;
	}
	public void setTcje(String tcje) {
		this.tcje = tcje;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getSccs() {
		return sccs;
	}
	public void setSccs(String sccs) {
		this.sccs = sccs;
	}
	public String getYxqz() {
		return yxqz;
	}
	public void setYxqz(String yxqz) {
		this.yxqz = yxqz;
	}
	public String getCgy() {
		return cgy;
	}
	public void setCgy(String cgy) {
		this.cgy = cgy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
