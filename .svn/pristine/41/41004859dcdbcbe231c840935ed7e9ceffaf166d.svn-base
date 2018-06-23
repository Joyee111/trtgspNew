package com.sinosoft.varietyManger.firstVarietyManger.dao;

import java.util.List;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

public interface UnqualifiedmedcstoreDao {
	/**
     * 修改保存不合格药品库
     * @param dr
     */
	void saveOrUpdataHg(Unqualifiedmedcstore unqualifiedmedcstore);
	/**
     * 添加保存不合格药品库
     * @param dr
     */
	void saveUnqualifiedmedcstore(Unqualifiedmedcstore unqualifiedmedcstore);
	/**
	 * 根据药品批号 得到不合格model
	 * @param id
	 * @return
	 */
	Unqualifiedmedcstore findById(String pihao);
	/**
	 * 查询不合格不合格药品
	 * @return
	 */
	List<QualityMidicine> findUnqualifiedMedcStore();
	/**
	 * 查询根据药品ID查询不合格药品
	 * @return
	 */
	List<Unqualifiedmedcstore> findUnqualifiedMedcStoreByMedcId(Long unQuMedcId);
	/**
	 * 查询所有药品
	 * @return
	 */
	List<QualityMidicine> findQualifiedMedcStore();
}
