package com.sinosoft.qualityRecords.complantManager.service;


import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;


import java.util.List;
import java.util.Map;

public interface DrugComInfoManger{
	/*
	 * 保存指派人
	 */
	void save(DrugComInfoItem di);

	/*
	 * 修改指派人
	 */
	void update(DrugComInfoItem di);
	
	
	int getTotalCount(String userId);
	DrugComInfo findById(String id);

	void saveOrUpdata(DrugComInfo dr);


	void saveDrugComInfo(DrugComInfo dr);

	/*
	 * 删除
	 */

	void delss(String string);
	Map<String, String> qmMap();

	QualityMidicine findYpById(String quamap);
	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<DrugComInfoItem> getDrugComInfoByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);
	
	/**
	 * 角色List
	 * @return
	 */
	Map<String, String> jsMap();
	List<DrugComInfoItem> getPage(DrugComInfoItem dr,
			String userId, int i, int pagesize);
	
	/*
	 * 删除
	 */

	void del(List<?> receItem);
	
	/*根据id查询所有
	 */
	List<?> findAllId(Long id);

	List<DrugComInfoItem> findYp(Long id);
	
	/*根据id查询所有指派id
	 */
	List<?> findZhiPaiId(Long id);
	public int countWaitingToDo(Long userId);
}
