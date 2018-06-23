package com.sinosoft.drugState.price;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;
@Entity
@Table(name="t_medc_price")
@Transactional
public class MedcPrice implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -6716719267747541254L;
	private Long id;//
	private String medc_no;//药品号
	private BigDecimal trade_price;
	private BigDecimal tax_price;//含税价格
	private String pack_rate;//包装率
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="medc_no",length=20)
	public String getMedc_no() {
		return medc_no;
	}
	public void setMedc_no(String medcNo) {
		medc_no = medcNo;
	}
	@Column(name="trade_price")
	public BigDecimal getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(BigDecimal tradePrice) {
		trade_price = tradePrice;
	}
	@Column(name="tax_price")
	public BigDecimal getTax_price() {
		return tax_price;
	}
	public void setTax_price(BigDecimal taxPrice) {
		tax_price = taxPrice;
	}
	@Column(name="pack_rate",length=10)
	public String getPack_rate() {
		return pack_rate;
	}
	public void setPack_rate(String packRate) {
		pack_rate = packRate;
	}
	
}
