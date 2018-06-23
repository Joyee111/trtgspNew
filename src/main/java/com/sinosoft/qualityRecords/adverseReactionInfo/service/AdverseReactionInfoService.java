package com.sinosoft.qualityRecords.adverseReactionInfo.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionInfo;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public interface AdverseReactionInfoService {// AdverseReactionInfo   AdverseReactionDoubtItem
	/*
	 * 不带条件查询
	 */
	List<AdverseReactionInfo> getPage(AdverseReactionInfo ar, int i, int pagesize);
/*
 * 得到条数
 */
	int getTotalCount();
	/*
	 * 保存
	 */
	AdverseReactionInfo save(AdverseReactionInfo ar);
	/*
	 * 根据Id 查询
	 */

	AdverseReactionInfo findById(String id);
	/*
	 * 修改
	 */

	void update(AdverseReactionInfo ar);

	/*
	 * 怀疑药品
	 */

	List<AdverseReactionDoubtItem> findYp(Long id);
	/*根据id查询所有
	 */
	List<?> findAllId(Long id);


	/*
	 * 删除
	 */

	void del(String string);
	

	/*
	 * 根据id 查询
	 */
	
	QualityMidicine findYpById(String quamap);
	List<AdverseReactionUseItem> findBYYp(Long id);
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<AdverseReactionInfo> getAdverseReactionInfoByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);

	/*根据id查询所有
	 */
	List<?> findAllIds(Long id);
}



