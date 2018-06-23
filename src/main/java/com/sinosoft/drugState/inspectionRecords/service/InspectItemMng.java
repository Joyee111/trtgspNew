package com.sinosoft.drugState.inspectionRecords.service;

import java.util.List;

import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;

public interface InspectItemMng {

	/**
	 * @param receivingNoteItem 保存对象
	 */
	void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem);

	/**
	 * @param list 删除ID集合
	 */
	void del(List<?> list);
	
	/**
	 * @param id 单个删除的ID
	 */
	void delOne(String id);
	
	/**
	 * 根据ID查询对象
	 * @param id 查询参数
	 * @return 对象
	 */
	ReceivingNoteItem findById(Long id);
}
