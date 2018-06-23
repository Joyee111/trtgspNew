package com.sinosoft.qualityRecords.adverseReactionInfo.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionDoubtItem;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionInfo;
import com.sinosoft.qualityRecords.adverseReactionInfo.model.AdverseReactionUseItem;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;


public interface AdverseReactionInfoDao  { 
	/**
	 * 不良反应列表
	 * @param ar
	 * @param i
	 * @param pagesize
	 * @return
	 */
	List<AdverseReactionInfo> getPage(AdverseReactionInfo ar, int i, int pagesize);
	/**
	 * 不良反应列表条数
	 * @return
	 */
	int getTotalCount();
     /**
      * 保存
      * @param ar
      * @return
      */
	AdverseReactionInfo save(AdverseReactionInfo ar);
	/**
	 * 根据Id 找到model 
	 * @param id
	 * @return
	 */
	AdverseReactionInfo findById(String id);
	/**
	 * 修改不良反应
	 * @param ar
	 */
	void update(AdverseReactionInfo ar);
	/**
	 * 根据Id 找到怀疑用药
	 * @param id
	 * @return
	 */
	List<AdverseReactionDoubtItem> findYp(Long id);
	/**
	 * 怀疑用药
	 * @param id
	 * @return
	 */
	List<?> findAllId(Long id);
	void del(String id);
	QualityMidicine findYpById(String quamap);
	/**
	 * 根据Id 找到并用药
	 * @param id
	 * @return
	 */
	List<AdverseReactionUseItem> findBYYp(Long id);
	//并用药
	List<?> findAllIds(Long id);
	
	/**
	 * 根据HQL查询条件分页显示列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AdverseReactionInfo> getAdverseReactionInfoByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 根据查询条件查询的条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
	
	
	
	
	
	
	
	
}

