package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.util.DateTimeUtils;

/**
 * 
* @ClassName: StopSellingOrderDto 
* @author zyl
* @date 2013-10-18 下午05:47:53 
* @Description: 退货停售dto
 */
public class StopSellingOrderDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12144412L;
	private String bh;//编号
	private String ypbh;//药品编号
	private String gg;//规格
	private String tymc;//通用名称
	private String ph;//批号
	private String sccs;//生产厂商
	private String dw;//单位
	private String sl;//数量
	private String cfdd;//存放地点
	private String tzrq;//通知日期
	private String jcqk;//检查情况
	private String clyj;//处理意见
	public StopSellingOrderDto(){
		
	}
	public StopSellingOrderDto(StopSaleBillVO stopSale){
		this.bh = "";
		this.ypbh = stopSale.getMidicNo();
		this.gg = stopSale.getSpecification();
		this.tymc = stopSale.getCommonName();
		this.ph = stopSale.getBatchProduction();
		this.sccs = stopSale.getPurchaseUnit();
		this.dw = stopSale.getUnit();
		this.sl = ""+stopSale.getQuantity();
		this.cfdd = stopSale.getLocation();
		this.jcqk = stopSale.getCheckSituation();
		this.tzrq = DateTimeUtils.getNowStrDate();
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getYpbh() {
		return ypbh;
	}
	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getTymc() {
		return tymc;
	}
	public void setTymc(String tymc) {
		this.tymc = tymc;
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
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getCfdd() {
		return cfdd;
	}
	public void setCfdd(String cfdd) {
		this.cfdd = cfdd;
	}
	public String getTzrq() {
		return tzrq;
	}
	public void setTzrq(String tzrq) {
		this.tzrq = tzrq;
	}
	public String getJcqk() {
		return jcqk;
	}
	public void setJcqk(String jcqk) {
		this.jcqk = jcqk;
	}
	public String getClyj() {
		return clyj;
	}
	public void setClyj(String clyj) {
		this.clyj = clyj;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
