package com.sinosoft.qualityRecords.adverseReactionInfo.service;

import java.util.List;

import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;

public interface AdverseReactionUseItemMng {
	/*
	 * 保存怀疑药
	 */
	void save(AdverseReactionUseItem au);
	/*
	 * 删除
	 */

	void del(List<?> receItem);
	
	AdverseReactionUseItem findById( String id);

}
