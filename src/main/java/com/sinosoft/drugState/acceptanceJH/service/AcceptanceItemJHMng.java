package com.sinosoft.drugState.acceptanceJH.service;

import java.util.List;

import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.ireportDTO.EntryTicket;

public interface AcceptanceItemJHMng {
	CheckAcceptItemJH save(CheckAcceptItemJH ch);

	void del(List<?> receItem);
	
	CheckAcceptItemJH findById( String id);
	public List<EntryTicket> findCheckAndAcceptByBatchNumber(String batchNumber);
	/**
	 * 获取验收细单
	 * @return
	 */
	List<CheckAcceptItemJH> findysdItemJHJson();
	/**
	 * 批号位数大于3后开始查询细单
	 * @return
	 */
	List<CheckAcceptItemJH> findysdItemJsonByBatchSize(String batch);
}
