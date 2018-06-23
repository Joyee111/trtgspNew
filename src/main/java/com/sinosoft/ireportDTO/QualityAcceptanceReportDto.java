package com.sinosoft.ireportDTO;

import java.io.Serializable;

import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.util.StringUtil;

/**
 * 
* @ClassName: QualityAcceptanceReport 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 质量验收报告单dto
 */
public class QualityAcceptanceReportDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214542L;
	private String thdw;//退回单位
	private String dhrq;//到货日期
	private String bh;//编号
	private String ypbh;//药品编号
	private String ttmc;//通用名称
	private String ph;//批号
	private String gg;//规格
	private String dw;//单位
	private String sl;//数量
	private String js;//件数
	private String thdh;//退货单号
	private String ysjg;//验收结果
	private String fcjl;//复查结论
	private String bz;//备注
	private String ysy;//验收员
	private String ysy_tbrq;//验收员_填报日期
	private String fhry;//复核人员
	private String fhry_tbrq;//复核人员_填报日期
	public QualityAcceptanceReportDto(){
		 this.thdw = "";//退回单位
		 this.dhrq ="";//到货日期
		 this.bh = "";//编号
		 this.ypbh ="";//药品编号
		 this.ttmc = "";//通用名称
		 this.ph = "";//批号
		 this.gg = "";//规格
		 this.dw = "";//单位
		 this.sl = "";//数量
		 this.js = "";//件数
		 this.thdh = "";//退货单号
		 this.ysjg = "";//验收结果
		 this.fcjl = "";//复查结论
		 this.bz = "";//备注
		 this.ysy = "";//验收员
		 this.ysy_tbrq = "";//验收员_填报日期
		 this.fhry = "";//复核人员
		 this.fhry_tbrq = "";//复核人员_填报日期
	}
	public QualityAcceptanceReportDto(ReturnCheckAcceptNote reNote,ReturncheckItem reItem,String yanshouren,String fujianren,MedicinePrice mp){
		this.thdw = reNote.getQualifiedPurchaseUnits().getCustomerName();
		this.dhrq = reNote.getArrivalDate();
		this.bh = reNote.getReportNo();
		this.ypbh = reItem.getQualityMidicine().getMedicinalNo();
		this.ttmc = reItem.getQualityMidicine().getCommonname();
		this.ph = reItem.getBatchProduction();
		this.gg  = reItem.getQualityMidicine().getSpecifications();
		this.dw = reItem.getQualityMidicine().getUnit();
		this.sl = reItem.getQuantity().toString();
		if(reItem.getQuantity() != null && mp.getPack_rate()!=null && !"".equals(mp.getPack_rate())){
			String quantity = reItem.getQuantity().toString();
			String packRate = mp.getPack_rate();
			this.js = StringUtil.formatFloatString(String.valueOf((Float.valueOf(quantity)/Float.valueOf(packRate))));
		}
		//this.js = "";
		this.thdh = reNote.getReturnNo();
		this.ysjg = reNote.getResult();
		this.fcjl = reNote.getVisualExamination();
		this.bz = "";
		this.ysy = yanshouren;
		this.ysy_tbrq = reNote.getCheckAcceptDate();
		this.fhry = fujianren;
		this.fhry_tbrq = reNote.getReviewTime();
	}
	public String getThdw() {
		return thdw;
	}
	public void setThdw(String thdw) {
		this.thdw = thdw;
	}
	public String getDhrq() {
		return dhrq;
	}
	public void setDhrq(String dhrq) {
		this.dhrq = dhrq;
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
	public String getTtmc() {
		return ttmc;
	}
	public void setTtmc(String ttmc) {
		this.ttmc = ttmc;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
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
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getThdh() {
		return thdh;
	}
	public void setThdh(String thdh) {
		this.thdh = thdh;
	}
	public String getYsjg() {
		return ysjg;
	}
	public void setYsjg(String ysjg) {
		this.ysjg = ysjg;
	}
	public String getFcjl() {
		return fcjl;
	}
	public void setFcjl(String fcjl) {
		this.fcjl = fcjl;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getYsy() {
		return ysy;
	}
	public void setYsy(String ysy) {
		this.ysy = ysy;
	}
	public String getYsy_tbrq() {
		return ysy_tbrq;
	}
	public void setYsy_tbrq(String ysy_tbrq) {
		this.ysy_tbrq = ysy_tbrq;
	}
	public String getFhry() {
		return fhry;
	}
	public void setFhry(String fhry) {
		this.fhry = fhry;
	}
	public String getFhry_tbrq() {
		return fhry_tbrq;
	}
	public void setFhry_tbrq(String fhry_tbrq) {
		this.fhry_tbrq = fhry_tbrq;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
