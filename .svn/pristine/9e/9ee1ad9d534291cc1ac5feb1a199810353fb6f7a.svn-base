package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;

import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

public interface UnqualifiedmedcstoreMng {
	/**
     * 修改保存合格药品库
     * @param dr
     */
	void saveOrUpdataHg(Unqualifiedmedcstore unqualifiedmedcstore);
	/**
     * 添加保存合格药品库
     * @param dr
     */
	void saveUnqualifiedmedcstore(Unqualifiedmedcstore unqualifiedmedcstore);
	/**
	 * 根据药品批号 得到不合格model
	 * @param id
	 * @return
	 */
	Unqualifiedmedcstore findById(String pihao);
	
	List<QualityMidicine> findUnqualifiedMedcStore();
	List<Unqualifiedmedcstore> findUnqualifiedMedcStoreByMedcId(Long unQuMedcId);
	List<QualityMidicine> findQualifiedMedcStore();
}
