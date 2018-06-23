package com.sinosoft.qualityRecords.adverseReactionInfo.service;

import java.util.List;

import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;

public interface AdverseReactionDoubtItemMng {	//AdverseReactionDoubtItem
	/*
	 * 保存怀疑药
	 */
	void save(AdverseReactionDoubtItem ad);
	/*
	 * 删除
	 */

	void del(List<?> receItem);
	
	AdverseReactionDoubtItem findById( String id);

}
