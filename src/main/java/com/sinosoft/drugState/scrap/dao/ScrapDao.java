package com.sinosoft.drugState.scrap.dao;

import java.util.List;

import com.sinosoft.drugState.scrap.model.ScrapAndQualityMedicineVo;
import com.sinosoft.drugState.scrap.model.ScrapMedicine;

public interface ScrapDao {

	/**
	 * 分页查询报废药品，条件有药品名称和状态
	 * @param commonName
	 * @param status
	 * @param first
	 * @param pageSize
	 * @return
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
	void saveOrUpdateSM(ScrapMedicine sm);
	
	/**
	 * 保存报废药品
	 * @param sm
	 */
	void saveSM(ScrapMedicine sm);
	
	/**
	 * 根据id获取报废药品
	 * @param id
	 * @return
	 */
	ScrapMedicine findById(String id);
}
