package com.sinosoft.ireportDTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.util.StringUtil;

/**
 * 
* @ClassName: EntryTicket 
* @author zyl
* @date 2013-8-10 下午05:47:53 
* @Description: 入库票
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_entry_ticket")
@Transactional
public class EntryTicket implements Serializable{
	
	private Long id;//主键ID
	private Long acceptanceId;//验收单ID
	private String ghdw;//供货单位
	private String ghrq;//供货日期或验收日期
	private String bh;//编号
	private String hh;//货号
	private String tymc;//通用名称
	private String jx;//剂型
	private String gg;//规格
	private String dw;//单位
	private String sl;//数量
	private String dj;//单价
	private String je;//金额
	private String pzwh;//标准依据
	private String scph;//生产批号
	private String yxqz;//有效期至
	private String nzsl;//内装数量
	private String js;//件数
	private String sccs;//生产厂商
	private String bz;//备注
	private String cgy;//采购员
	private String shy;//收货员
	private String ysy;//验收员
	private String ysy2;//验收员2
	private String bgy;//保管员
	private String fhy;//复核员
	private String zdr;//制单人
	private String flag;//标志位，0为非嘉和药品，1为嘉和药品
	private String jygs;//经营公司
	
	public EntryTicket(){
		
	}

	public EntryTicket(Long acceptanceId ,String ghdw, String ghrq, String bh, String hh,
			String tymc, String jx, String gg, String dw, String sl, String dj,
			String je, String pzwh, String scph, String yxqz, String nzsl,
			String js, String sccs, String bz, String cgy, String shy, String ysy,String ysy2,
			String bgy, String fhy, String zdr, String flag, String jygs) {
		this.acceptanceId = acceptanceId;
		this.ghdw = ghdw;
		this.ghrq = ghrq;
		this.bh = bh;
		this.hh = hh;
		this.tymc = tymc;
		this.jx = jx;
		this.gg = gg;
		this.dw = dw;
		this.sl = sl;
		this.dj = dj;
		this.je = je;
		this.pzwh = pzwh;
		this.scph = scph;
		if(yxqz!=null && !"".equals(yxqz)){
			this.yxqz = yxqz.substring(0,yxqz.lastIndexOf("-"));
		}else{
			this.yxqz = "";
		}
		
		this.nzsl = nzsl;
		this.js = js;
		this.sccs =sccs;
		this.bz = bz;
		this.cgy = cgy;
		this.shy = shy;
		this.ysy = ysy;
		this.ysy2 = ysy2;
		this.bgy = bgy;
		this.fhy =fhy;
		this.zdr =zdr;
		this.flag = flag;
		this.jygs = jygs;
		
	}
	public EntryTicket(String ghdw, String ghrq, String bh, String hh,
			String tymc, String jx, String gg, String dw, String sl, String dj,
			String je, String pzwh, String scph, String yxqz, String nzsl,
			String js, String sccs, String bz, String cgy, String shy, String ysy,String ysy2,
			String bgy, String fhy, String zdr, String flag, String jygs) {
		this.ghdw = ghdw;
		this.ghrq = ghrq;
		this.bh = bh;
		this.hh = hh;
		this.tymc = tymc;
		this.jx = jx;
		this.gg = gg;
		this.dw = dw;
		this.sl = sl;
		this.dj = dj;
		this.je = je;
		this.pzwh = pzwh;
		this.scph = scph;
		this.yxqz = yxqz;
		this.nzsl = nzsl;
		this.js = js;
		this.sccs =sccs;
		this.bz = bz;
		this.cgy = cgy;
		this.shy = shy;
		this.ysy = ysy;
		this.ysy2 = ysy2;
		this.bgy = bgy;
		this.fhy =fhy;
		this.zdr =zdr;
		this.flag = flag;
		this.jygs = jygs;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="entryTicket_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="acceptance_id")
	public Long getAcceptanceId() {
		return acceptanceId;
	}

	public void setAcceptanceId(Long acceptanceId) {
		this.acceptanceId = acceptanceId;
	}
	@Column(name="purchaseUnits_name",length=100)
	public String getGhdw() {
		return ghdw;
	}
	public void setGhdw(String ghdw) {
		this.ghdw = ghdw;
	}
	@Column(name="purchase_date",length=20)
	public String getGhrq() {
		return ghrq;
	}
	public void setGhrq(String ghrq) {
		this.ghrq = ghrq;
	}
	@Column(name="number",length=20)
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	@Column(name="medic_number",length=20)
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	@Column(name="common_name",length=50)
	public String getTymc() {
		return tymc;
	}
	public void setTymc(String tymc) {
		this.tymc = tymc;
	}
	@Column(name="dosage_forms",length=50)
	public String getJx() {
		return jx;
	}
	public void setJx(String jx) {
		this.jx = jx;
	}
	@Column(name="specifications",length=50)
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	@Column(name="units",length=20)
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	@Column(name="quantity",length=50)
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	@Column(name="unit_price",length=50)
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	@Column(name="sum_money",length=50)
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	@Column(name="approval_number",length=50)
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	@Column(name="production_batch",length=50)
	public String getScph() {
		return scph;
	}
	public void setScph(String scph) {
		this.scph = scph;
	}
	@Column(name="valid_to",length=20)
	public String getYxqz() {
		return yxqz;
	}
	public void setYxqz(String yxqz) {
		this.yxqz = yxqz;
	}
	@Column(name="built_quantity",length=50)
	public String getNzsl() {
		return nzsl;
	}
	public void setNzsl(String nzsl) {
		this.nzsl = nzsl;
	}
	@Column(name="pieces_quantity",length=50)
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	@Column(name="manufacturer",length=100)
	public String getSccs() {
		return sccs;
	}
	public void setSccs(String sccs) {
		this.sccs = sccs;
	}
	@Column(name="remark",length=655)
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	@Column(name="procurement_people",length=50)
	public String getCgy() {
		return cgy;
	}
	public void setCgy(String cgy) {
		this.cgy = cgy;
	}
	@Column(name="consignee",length=50)
	public String getShy() {
		return shy;
	}
	public void setShy(String shy) {
		this.shy = shy;
	}
	@Column(name="acceptance_people",length=50)
	public String getYsy() {
		return ysy;
	}
	public void setYsy(String ysy) {
		this.ysy = ysy;
	}
	@Column(name="acceptance_people2",length=50)
	public String getYsy2() {
		return ysy2;
	}
	public void setYsy2(String ysy2) {
		this.ysy2 = ysy2;
	}
	@Column(name="custodian",length=50)
	public String getBgy() {
		return bgy;
	}
	public void setBgy(String bgy) {
		this.bgy = bgy;
	}
	@Column(name="review_peoper",length=50)
	public String getFhy() {
		return fhy;
	}
	public void setFhy(String fhy) {
		this.fhy = fhy;
	}
	@Column(name="prepared_peoper",length=50)
	public String getZdr() {
		return zdr;
	}
	public void setZdr(String zdr) {
		this.zdr = zdr;
	}
	@Column(name="flag",length=2)
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Column(name="dp_id",length=20)
	public String getJygs() {
		return jygs;
	}

	public void setJygs(String jygs) {
		this.jygs = jygs;
	}
	
}
