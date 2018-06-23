package com.sinosoft.qualityRecords.adverseReactionInfo.dao;


import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;

public interface AdverseReactionUseItemDao {
	void savech(AdverseReactionUseItem au);

	void del(String string);

	AdverseReactionUseItem findById(String id);

}
