package com.sinosoft.ireportDTO;

import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;

/**
 * 
* @ClassName: CustomerInfo 
* @author zyl
* @date 2013-8-19 下午05:47:53 
* @Description: 购货商信息
 */
public class CustomerInfo{
	private String khbm;//客户编码
	private String khmc;//客户名称
	private String sf;//省份
	private String dzjgm;//电子监管码
	private String qyjylx;//企业经营类型
	private String zcdz;//注册地址
	private String fr;//法人
	private String zlfzr;//质量负责人
	private String cgr;//采购人
	private String cgrdh;//采购人电话
	private String cz;//传真
	private String yb;//邮编
	private String spxxdz;//税票信息地址
	private String nsrdjh;//纳税人登记号
	private String spxxdh;//税票信息电话
	private String khyh;//开户银行
	private String khyhzh;//开户银行账号
	private String fhdz;//发货地址
	private String shr;//收货人
	private String shrdh;//收货人电话
	private String yyzzdqrq;//营业执照到期时间
	private String jyxkzdqrq;	//经营许可证到期时间
	private String GSPjzrq;//GSP截止日期
	private String zzjgdmdqrq;//组织机构代码到期时间
	private String zzjgdmnj;//组织机构代码年检
	private String frwtsdqrq;//法人委托书到期时间
	private String zlbzsdqrq;//质量保证书到期时间
	private String khrq;//开户日期
	private String khgs;//开户公司
	private String xslb;//销售类别
	private String beizhu;//备注
	private String tybs;//企业状态信息 （即停用标识：0启用 1停用 2暂时停用）
	public CustomerInfo(){
		
	}
	public CustomerInfo(QualifiedPurchaseUnits purcUnit,String shengfen){
		this.khbm = purcUnit.getCustomerNumber();
		this.khmc = purcUnit.getCustomerName();
		this.sf = shengfen;
		this.dzjgm  = purcUnit.getElectronicMonitoringCode();
	//	this.qyjylx = purcUnit.getEconomicNature();
		this.zcdz = purcUnit.getAddress();
		this.fr = purcUnit.getCorporation();
		this.zlfzr = purcUnit.getQualityPrincipal();//质量负责人
		if(purcUnit.getProcurementStaff()!=null){
			this.cgr = purcUnit.getProcurementStaff().getProcurementName();//采购人
		}else{
			this.cgr = "";
		}
		
		this.cgrdh = purcUnit.getPhone();//采购人电话
		this.cz = purcUnit.getPortraiture();//传真
		this.yb = purcUnit.getPostalCode();//邮编
		this.spxxdz = purcUnit.getTaxReceiptAddress();//税票信息地址
		this.nsrdjh =  purcUnit.getTaxpayeRegisterNo();//纳税人登记号
		this.spxxdh =  purcUnit.getTaxReceiptPhone();//税票信息电话
		this.khyh = purcUnit.getBankName();//开户银行
		this.khyhzh = purcUnit.getBankNumber();//开户银行账号
		this.fhdz = purcUnit.getShippingAddress();//发货地址
		this.shr = purcUnit.getConsigneeName();//收货人
		this.shrdh = purcUnit.getConsigneePhone();//收货人电话
		this.yyzzdqrq = purcUnit.getBusLiceExpiraDate();//营业执照到期时间
		this.beizhu = purcUnit.getRemark();//备注
		this.xslb = purcUnit.getSaleCompany();//销售公司
		this.jyxkzdqrq =  purcUnit.getLiceExpirationDate();	//经营许可证到期时间
		this.GSPjzrq = purcUnit.getGpsExpirationDate();//GSP截止日期
		this.zzjgdmdqrq = purcUnit.getOrganizationCodeDate();//组织机构代码到期时间
		this.zzjgdmnj = purcUnit.getOrganizationCodeInspectionDate();//组织机构代码年检
		this.frwtsdqrq = purcUnit.getAuthorizationDate();//法人委托书到期时间
		this.zlbzsdqrq = purcUnit.getQualityAssuranceDate();//质量保证书到期时间
		this.khrq = purcUnit.getAccountOpeningDate();//开户日期
		if(purcUnit.getEconomicNature()==null || purcUnit.getEconomicNature()==""){
			this.qyjylx="";
		}else if(purcUnit.getEconomicNature().trim().equals("1")){
			this.qyjylx="批发";
		}else if(purcUnit.getEconomicNature().trim().equals("2")){
			this.qyjylx="零售";
		}else if(purcUnit.getEconomicNature().trim().equals("3")){
			this.qyjylx="零售（连锁）";
		}else if(purcUnit.getEconomicNature().trim().equals("3")){
			this.qyjylx="医疗机构";
		}
		if(purcUnit == null || purcUnit.getOpenCompany()==null ||  purcUnit.getOpenCompany()=="" ){
			this.khgs="";
		}else if(purcUnit.getOpenCompany().trim().equals("0")){
			this.khgs="经营";
		}else if(purcUnit.getOpenCompany().trim().equals("1")){
			this.khgs="新品";
		}else if(purcUnit.getOpenCompany().trim().equals("2")){
			this.khgs="市场";
		}
		if(purcUnit == null || purcUnit.getUseFlag()==null ||  purcUnit.getUseFlag()=="" ){
			this.tybs="";
		}else if(purcUnit.getUseFlag().trim().equals("0")){
			this.tybs="启用";
		}else if(purcUnit.getUseFlag().trim().equals("1")){
			this.tybs="停用";
		}else if(purcUnit.getUseFlag().trim().equals("2")){
			this.tybs="暂时停用";
		}
	}
	public String getKhbm() {
		return khbm;
	}
	public void setKhbm(String khbm) {
		this.khbm = khbm;
	}
	public String getKhmc() {
		return khmc;
	}
	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}
	public String getSf() {
		return sf;
	}
	public void setSf(String sf) {
		this.sf = sf;
	}
	public String getDzjgm() {
		return dzjgm;
	}
	public void setDzjgm(String dzjgm) {
		this.dzjgm = dzjgm;
	}
	public String getQyjylx() {
		return qyjylx;
	}
	public void setQyjylx(String qyjylx) {
		this.qyjylx = qyjylx;
	}
	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}
	public String getFr() {
		return fr;
	}
	public void setFr(String fr) {
		this.fr = fr;
	}
	public String getZlfzr() {
		return zlfzr;
	}
	public void setZlfzr(String zlfzr) {
		this.zlfzr = zlfzr;
	}
	public String getCgr() {
		return cgr;
	}
	public void setCgr(String cgr) {
		this.cgr = cgr;
	}
	public String getCgrdh() {
		return cgrdh;
	}
	public void setCgrdh(String cgrdh) {
		this.cgrdh = cgrdh;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public String getSpxxdz() {
		return spxxdz;
	}
	public void setSpxxdz(String spxxdz) {
		this.spxxdz = spxxdz;
	}
	public String getNsrdjh() {
		return nsrdjh;
	}
	public void setNsrdjh(String nsrdjh) {
		this.nsrdjh = nsrdjh;
	}
	public String getSpxxdh() {
		return spxxdh;
	}
	public void setSpxxdh(String spxxdh) {
		this.spxxdh = spxxdh;
	}
	public String getKhyh() {
		return khyh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	public String getKhyhzh() {
		return khyhzh;
	}
	public void setKhyhzh(String khyhzh) {
		this.khyhzh = khyhzh;
	}
	public String getFhdz() {
		return fhdz;
	}
	public void setFhdz(String fhdz) {
		this.fhdz = fhdz;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public String getShrdh() {
		return shrdh;
	}
	public void setShrdh(String shrdh) {
		this.shrdh = shrdh;
	}
	public String getYyzzdqrq() {
		return yyzzdqrq;
	}
	public void setYyzzdqrq(String yyzzdqrq) {
		this.yyzzdqrq = yyzzdqrq;
	}
	public String getJyxkzdqrq() {
		return jyxkzdqrq;
	}
	public void setJyxkzdqrq(String jyxkzdqrq) {
		this.jyxkzdqrq = jyxkzdqrq;
	}
	public String getGSPjzrq() {
		return GSPjzrq;
	}
	public void setGSPjzrq(String gSPjzrq) {
		GSPjzrq = gSPjzrq;
	}
	public String getZzjgdmdqrq() {
		return zzjgdmdqrq;
	}
	public void setZzjgdmdqrq(String zzjgdmdqrq) {
		this.zzjgdmdqrq = zzjgdmdqrq;
	}
	public String getZzjgdmnj() {
		return zzjgdmnj;
	}
	public void setZzjgdmnj(String zzjgdmnj) {
		this.zzjgdmnj = zzjgdmnj;
	}
	public String getFrwtsdqrq() {
		return frwtsdqrq;
	}
	public void setFrwtsdqrq(String frwtsdqrq) {
		this.frwtsdqrq = frwtsdqrq;
	}
	public String getZlbzsdqrq() {
		return zlbzsdqrq;
	}
	public void setZlbzsdqrq(String zlbzsdqrq) {
		this.zlbzsdqrq = zlbzsdqrq;
	}
	public String getKhrq() {
		return khrq;
	}
	public void setKhrq(String khrq) {
		this.khrq = khrq;
	}
	public String getKhgs() {
		return khgs;
	}
	public void setKhgs(String khgs) {
		this.khgs = khgs;
	}
	public String getXslb() {
		return xslb;
	}
	public void setXslb(String xslb) {
		this.xslb = xslb;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public String getTybs() {
		return tybs;
	}
	public void setTybs(String tybs) {
		this.tybs = tybs;
	}
	
}
