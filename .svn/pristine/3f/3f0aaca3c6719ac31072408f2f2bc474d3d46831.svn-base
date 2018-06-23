package com.sinosoft.drugState.mackNo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.systemConfig.MakingNo;

public interface MakeNoMng {
	/***
	 * desc 编码类型
	 * 返回下一个编号
	 * */
	@Autowired
	public String mackNo(String desc);

	/**
	 * @param purchasenoteact编码类型
	 * @return 最新编号
	 */
	public String findNo(String purchasenoteact);
	
	/**
	 * 购进退出编码
	 * @param desc
	 * @return
	 */
	public String makeNo(String desc);
	
	/**
	 * 获取票据类型
	 */
	public List<MakingNo> getBillType(Map<String,Object> queryParams);
	
	public MakingNo save(MakingNo mn);
	
	public void update(MakingNo mn);
	
	public MakingNo findMNById(Long MakingNoId);
}
