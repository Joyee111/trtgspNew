package com.sinosoft.ireportDTO;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 
* @ClassName: MedicineInfo 
* @author zyl
* @date 2014-4-4 下午05:47:53 
* @Description: 药品信息
 */
@SuppressWarnings("serial")
@Entity
public class MedicineInfo implements Serializable{
	
	private String tymc; //通用名称
	private String jx; //剂型
	private String hh; //货号
	private String pzwh; //批准文号
	private String scqy; //生产企业
	private String ghdw; //供货单位
	private String ypgg; //药品规格
	private String bzgg; //包装规格
	private String dw; //单位
	private String zlbzyj; //质量标准依据
	private String yplb; //药品类别
	private String cutj; //存储条件
	private String ypyxq; //药品有效期
	private String ypgn; //药品功能
	private String zczdqr;//注册证到期日
	
	
	public String getZczdqr() {
		return zczdqr;
	}
	public void setZczdqr(String zczdqr) {
		this.zczdqr = zczdqr;
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
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public String getScqy() {
		return scqy;
	}
	public void setScqy(String scqy) {
		this.scqy = scqy;
	}
	public String getGhdw() {
		return ghdw;
	}
	public void setGhdw(String ghdw) {
		this.ghdw = ghdw;
	}
	public String getYpgg() {
		return ypgg;
	}
	public void setYpgg(String ypgg) {
		this.ypgg = ypgg;
	}
	public String getBzgg() {
		return bzgg;
	}
	public void setBzgg(String bzgg) {
		this.bzgg = bzgg;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getZlbzyj() {
		return zlbzyj;
	}
	public void setZlbzyj(String zlbzyj) {
		this.zlbzyj = zlbzyj;
	}
	public String getYplb() {
		return yplb;
	}
	public void setYplb(String yplb) {
		this.yplb = yplb;
	}
	public String getCutj() {
		return cutj;
	}
	public void setCutj(String cutj) {
		this.cutj = cutj;
	}
	public String getYpyxq() {
		return ypyxq;
	}
	public void setYpyxq(String ypyxq) {
		this.ypyxq = ypyxq;
	}
	public String getYpgn() {
		return ypgn;
	}
	public void setYpgn(String ypgn) {
		this.ypgn = ypgn;
	}

}
