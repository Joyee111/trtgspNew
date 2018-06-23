package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.comQuery.returnReceivingRecords.model.ReturnReceivingRecords;

/**
 * 
* @ClassName: ReturnDrugsDto 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 退货药品记录dto
 */
public class ReturnDrugsDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214442L;
	private String thrq;//退货日期
	private String thdw;//退货单位
	private String hh;//货号
	private String tymc;//通用名称
	private String jx;//剂型
	private String gg;//规格
	private String sl;//数量
	private String ph;//批号
	private String yxqz;//有效期至
	private String sccs;//生产厂商
	private String thdh;//退货单号
	private String bgy;//保管员
	private String bz;//备注
	public ReturnDrugsDto(ReturnReceivingRecords record){
		this.thrq = record.getTuihuorq();
		this.thdw = record.getTuihuodw();
		this.hh = record.getHuohao();
		this.tymc = record.getMingcheng();
		this.jx = record.getJixing();
		this.gg = record.getGuige();
		this.sl = record.getShuliang().toString();
		this.ph = record.getPihao();
		this.yxqz = record.getYouxiaoqi();
		this.sccs = record.getShanghcan();
		this.thdh = record.getTuihuodh();
		this.bgy = record.getBaoguanyuan();
		this.bz = record.getBeizhu();
	}
	public String getThrq() {
		return thrq;
	}
	public void setThrq(String thrq) {
		this.thrq = thrq;
	}
	public String getThdw() {
		return thdw;
	}
	public void setThdw(String thdw) {
		this.thdw = thdw;
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
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getYxqz() {
		return yxqz;
	}
	public void setYxqz(String yxqz) {
		this.yxqz = yxqz;
	}
	public String getSccs() {
		return sccs;
	}
	public void setSccs(String sccs) {
		this.sccs = sccs;
	}
	public String getThdh() {
		return thdh;
	}
	public void setThdh(String thdh) {
		this.thdh = thdh;
	}
	public String getBgy() {
		return bgy;
	}
	public void setBgy(String bgy) {
		this.bgy = bgy;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
