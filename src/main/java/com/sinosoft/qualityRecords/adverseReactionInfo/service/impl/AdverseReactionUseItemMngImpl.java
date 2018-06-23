package com.sinosoft.qualityRecords.adverseReactionInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionUseItemDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionUseItemMng;
@Service
public class AdverseReactionUseItemMngImpl implements AdverseReactionUseItemMng {
	@Autowired
	private  AdverseReactionUseItemDao AdverseReactionUseItemDao;

	public void setAdverseReactionUseItemDao(
			AdverseReactionUseItemDao adverseReactionUseItemDao) {
		AdverseReactionUseItemDao = adverseReactionUseItemDao;
	}

	@Override
	public void del(List<?> receItem) {
		for(int i=0;i<receItem.size();i++){
			AdverseReactionUseItemDao.del(receItem.get(i).toString());
		}
		
	}

	@Override
	public AdverseReactionUseItem findById(String id) {

		return AdverseReactionUseItemDao.findById(id);
	}

	@Override
	public void save(AdverseReactionUseItem au) {
		AdverseReactionUseItemDao.savech(au);
		
	}

}
