package com.sinosoft.qualityRecords.adverseReactionInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionDoubtItemDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionDoubtItemMng;
@Service
public class AdverseReactionDoubtItemMngImpl implements  AdverseReactionDoubtItemMng {
	@Autowired
	private  AdverseReactionDoubtItemDao adverseReactionDoubtItemDao;

	public void setAdverseReactionDoubtItemDao(
			AdverseReactionDoubtItemDao adverseReactionDoubtItemDao) {
		this.adverseReactionDoubtItemDao = adverseReactionDoubtItemDao;
	}

	@Override
	public void save(AdverseReactionDoubtItem ad) {
		adverseReactionDoubtItemDao.savech(ad);
	}
	@Override
	public void del(List<?> receItem) {
		
		for(int i=0;i<receItem.size();i++){
			adverseReactionDoubtItemDao.del(receItem.get(i).toString());
		}
		
	}
	@Override
	public AdverseReactionDoubtItem findById(String id) {
		return adverseReactionDoubtItemDao.findById(id);
	}

}
