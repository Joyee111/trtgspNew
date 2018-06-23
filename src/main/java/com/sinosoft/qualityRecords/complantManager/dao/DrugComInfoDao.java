package com.sinosoft.qualityRecords.complantManager.dao;



import java.util.List;
import java.util.Map;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
public interface DrugComInfoDao  {

    /**
     * 投诉管理列表
     * @param dr
     * @param pageSize
     * @param resultSize
     * @param string
     * @return
     */
    List<DrugComInfoItem> getPage(DrugComInfoItem dr,String userId,int pageSize, int resultSize, String string);
     /**
      * 投诉管理列表查询的条数
      * @param string
      * @return
      */
	int getTotalCount(String string);
	/**
	 * 根据id查询ｍｏｄｅｌ
	 * @param id
	 * @return
	 */
	DrugComInfo findById(String id);
    /**
     * 修改保存
     * @param dr
     */
	void saveOrUpdata(DrugComInfo dr);
    /**
     * 添加保存
     * @param dr
     */
	void saveDrugComInfo(DrugComInfo dr);
   /**
    * 删除
    * @param ids
    */
	void delss(String id);
	Map<String, String> qmMap();
/**
 * 根据药品的ｉｄ找药品的Ｍｏｄｅｌ
 * @param quamap
 * @return
 */
	QualityMidicine findYpById(String quamap);
	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DrugComInfoItem> getDrugComInfoByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 根据查询条件查询得到的条数
	 * @param hql
	 * @return
	 */
	int getQueryCount(String hql);
	
	/**
	 * 角色List
	 * @return
	 */
	Map<String, String> jsMap();
    
	/*
	 * 保存指派人
	 */
	void save(DrugComInfoItem di);
	/*
	 * 修改指派人
	 */
	void update(DrugComInfoItem di);
	/**
	 * 删除投诉信息下所有的指派的信息
	 * @param string
	 */
	void dels(String string);
	DrugComInfoItem findByIda(String id);
	/**
	 * 根据投诉的Ｉｄ找到所有的投诉指派的id
	 * @param id
	 * @return
	 */
	List<?> findAllId(Long id);
	List<DrugComInfoItem> findYp(Long id);
	/*根据id查询所有指派id
	 */
	List<?> findZhiPaiId(Long id);
	int countWaitingToDo(Long userId);
}
