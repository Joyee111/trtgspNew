package com.sinosoft.drugState.scrap.service;

import java.util.List;

import com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo;
import com.sinosoft.drugState.scrap.model.ScrapMedicine;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public interface ScrapMng {

	/**
	 * 查询不合格药品数据
	 * @return
	 */
	List<UnqualifiedManager> findUnqualifiedManagerList();
	
	/**
	 * 分页查询报废药品数据，条件有药品名称和状态
	 * @param commonName
	 * @param status
	 * @param first
	 * @param pageSize
	 * @return
	 * @author whn
	 */
	List<ScrapAndQualityMedicineVo> getPage(String commonName,String status,int first,int pageSize);
	
	/**
	 * 统计报废药品数量，根据药品名称和状态
	 * @param commonName
	 * @param status
	 * @return
	 */
	int countScrapMedicineByStatus(String commonName,String status);
	/**
	 * 保存或更新报废药品
	 * @param sm
	 */
	void saveOrUpdate(ScrapMedicine sm);
	
	/**
	 * 保存或更新报废药品
	 * @param sm
	 */
	void save(ScrapMedicine sm);
	
	/**
	 * 根据id获取报废药品
	 * @param id
	 * @return
	 */
	ScrapMedicine findById(String id);
	
	
	public List<QualityMidicine> findqmJsonty();
}
