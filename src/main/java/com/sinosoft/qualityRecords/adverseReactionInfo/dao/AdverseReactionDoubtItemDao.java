package com.sinosoft.qualityRecords.adverseReactionInfo.dao;

import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;

public interface AdverseReactionDoubtItemDao {//AdverseReactionDoubtItem

	void savech(AdverseReactionDoubtItem ad);

	void del(String string);

	AdverseReactionDoubtItem findById(String id);



}
