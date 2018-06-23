package com.sinosoft.qualityRecords.adverseReactionInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.adverseReactionInfo.dao.AdverseReactionInfoDao;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionInfo;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.service.AdverseReactionInfoService;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Service
public class AdverseReactionInfoServiceImpl implements AdverseReactionInfoService {//AdverseReactionInfo  AdverseReactionDoubtItem
	 @Autowired
	private AdverseReactionInfoDao adverseReactionInfoDao;

	public void setAdverseReactionInfoDao(AdverseReactionInfoDao adverseReactionInfoDao) {
		this.adverseReactionInfoDao = adverseReactionInfoDao;
	}
	@Override
	public List<AdverseReactionInfo> getPage(AdverseReactionInfo ar, int i, int pagesize) {
		return adverseReactionInfoDao.getPage(ar,i,pagesize);
	}
	@Override
	public int getTotalCount() {
		return adverseReactionInfoDao.getTotalCount();
	}
	@Override
	public AdverseReactionInfo save(AdverseReactionInfo ar) {
		return adverseReactionInfoDao.save(ar);
	}

	@Override
	public AdverseReactionInfo findById(String id) {
		return adverseReactionInfoDao.findById(id);
	}
	
	@Override
	public void update(AdverseReactionInfo ar) {
		adverseReactionInfoDao.update(ar);
	}
	@Override
	public List<AdverseReactionDoubtItem> findYp(Long id) {
		return adverseReactionInfoDao.findYp(id);
	}
	@Override
	public List<?> findAllId(Long id) {
		return adverseReactionInfoDao.findAllId(id);
	}
	@Override
	public void del(String id) {
		adverseReactionInfoDao.del(id);
	}	
	@Override
	public QualityMidicine findYpById(String quamap) {
		return adverseReactionInfoDao.findYpById(quamap);
	}
	@Override
	public List<AdverseReactionUseItem> findBYYp(Long id) {
		return adverseReactionInfoDao.findBYYp(id);
	}
	@Override
	public List<AdverseReactionInfo> getAdverseReactionInfoByPage(String hql, Map map,
			int first, int pagesize) {
		return adverseReactionInfoDao.getAdverseReactionInfoByPage(hql, map, first, pagesize);
	}
	@Override
	public int getQueryCount(String hql) {

		return adverseReactionInfoDao.getQueryCount(hql);
	}
	@Override
	public List<?> findAllIds(Long id) {

		return adverseReactionInfoDao.findAllIds(id);
	}
}