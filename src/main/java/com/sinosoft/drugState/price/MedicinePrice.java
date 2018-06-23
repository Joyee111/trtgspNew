package com.sinosoft.drugState.price;

import java.math.BigDecimal;

/**
 * 价格
* @ClassName: MedicinePrice 
* @author lfl
* @date 2013-9-17 下午03:51:14 
* @Description: TODO(商品价格VO 对应表（t_medc_price）)
 */
public class MedicinePrice  {
	private String medc_no;//货号
	private BigDecimal trade_price;//-- 批发价 
	private BigDecimal tax_price;// -- 含税单价
	private String pack_rate;//包装率
	public MedicinePrice (){
		
	}
	public MedicinePrice(String medc_no,BigDecimal trade_price,BigDecimal tax_price,String pack_rate){
		this.medc_no = medc_no;
		this.trade_price = trade_price;
		this.tax_price =tax_price;
		this.pack_rate = pack_rate;
	}
	public String getMedc_no() {
		return medc_no;
	}
	public void setMedc_no(String medcNo) {
		medc_no = medcNo;
	}
	public BigDecimal getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(BigDecimal tradePrice) {
		trade_price = tradePrice;
	}
	public BigDecimal getTax_price() {
		return tax_price;
	}
	public void setTax_price(BigDecimal taxPrice) {
		tax_price = taxPrice;
	}
	public String getPack_rate() {
		return pack_rate;
	}
	public void setPack_rate(String packRate) {
		pack_rate = packRate;
	}
	
}
