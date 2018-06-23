package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.comQuery.ReturnCheckRecords.model.ReturnCheckRecords;

/**
 * 
* @ClassName: SalesReturnCheckDto 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 销售退回验收dto
 */
public class SalesReturnCheckDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214542L;
	private String thdw;//退回单位
	private String thrq;//退货日期
	private String tymc;//通用名称
	private String gg;//规格
	private String pzwh;//批准文号
	private String ph;//批号
	private String sccs;//生产厂商
	private String yxq;//有效期
	private String sl;//数量
	private String ysrq;//验收日期
	private String thyy;//退货原因
	private String ysjg;//验收结果
	private String ysy;//验收员
	private String fyjl;//复验结论
	private String fyry;//复验人员
	//20140305新增
	private String bgdh;//报告单号
	private String thdh;//退货单号
	private String dw;//单位
	private String js;//件数
	private String hh;//货号
	private String fjrq;//复检日期
	
	public SalesReturnCheckDto(ReturnCheckRecords record){
		this.hh = record.getHuohao();
		this.js = record.getJianshu();
		this.dw = record.getUnit();
		this.thdh = record.getTuihuodanhao();
		this.bgdh = record.getBaogaodanhao();
		this.thdw = record.getTuihuidw();
		this.thrq  = record.getTuihuiriqi();
		this.tymc = record.getPinming();
		this.gg = record.getGuige();
		this.pzwh = record.getPizhunwh();
		this.ph = record.getPihao();
		this.sccs = record.getShengchancj();
		this.yxq = record.getYouxiaoqi();
		this.sl = record.getShuliang().toString();
		this.ysrq = record.getYanshourq();
		this.thyy = record.getJianchajl();
		this.ysjg = record.getYanshoujg();
		this.ysy = record.getYanshouyuan();
		this.fyjl  = record.getFuchajielun();
		this.fyry = record.getFuyanry();
		this.fjrq = record.getFujianriqi();
	}
	public String getThdw() {
		return thdw;
	}
	public void setThdw(String thdw) {
		this.thdw = thdw;
	}
	public String getThrq() {
		return thrq;
	}
	public void setThrq(String thrq) {
		this.thrq = thrq;
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
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
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
	public String getYxq() {
		return yxq;
	}
	public void setYxq(String yxq) {
		this.yxq = yxq;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getYsrq() {
		return ysrq;
	}
	public void setYsrq(String ysrq) {
		this.ysrq = ysrq;
	}
	public String getThyy() {
		return thyy;
	}
	public void setThyy(String thyy) {
		this.thyy = thyy;
	}
	public String getYsjg() {
		return ysjg;
	}
	public void setYsjg(String ysjg) {
		this.ysjg = ysjg;
	}
	public String getYsy() {
		return ysy;
	}
	public void setYsy(String ysy) {
		this.ysy = ysy;
	}
	public String getFyjl() {
		return fyjl;
	}
	public void setFyjl(String fyjl) {
		this.fyjl = fyjl;
	}
	public String getFyry() {
		return fyry;
	}
	public void setFyry(String fyry) {
		this.fyry = fyry;
	}
	
	public String getBgdh() {
		return bgdh;
	}
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	public String getThdh() {
		return thdh;
	}
	public void setThdh(String thdh) {
		this.thdh = thdh;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getFjrq() {
		return fjrq;
	}
	public void setFjrq(String fjrq) {
		this.fjrq = fjrq;
	}
	
	
}
