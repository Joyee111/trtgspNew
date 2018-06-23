package com.sinosoft.drugState.acceptanceJH.dao;

import java.util.List;

import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.ireportDTO.EntryTicket;

public interface AcceptanceItemJHDao {
	CheckAcceptItemJH savech(CheckAcceptItemJH ch);

	void del(String string);

	CheckAcceptItemJH findById(String id);
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
