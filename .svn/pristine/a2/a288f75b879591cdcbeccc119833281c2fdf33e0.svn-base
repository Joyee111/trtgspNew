package com.sinosoft.drugState.stopcell.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public interface StopCellMng {


	int getTotalCount(StopSaleBill mc);

	List<StopSaleBill> getPage(StopSaleBill mc, int i, int pagesize);

	StopSaleBill save(StopSaleBill mc);

	StopSaleBill findById(String id);

	void update(StopSaleBill mc);

	List<StopSaleBill> getPagedsh(StopSaleBill mc, int i, int pagesize);

	int getTotalCountDsh(StopSaleBill mc);

	List<StopSaleBill> getPageysh(StopSaleBill mc, int i, int pagesize);

	int getTotalCountysh(StopSaleBill mc);

	List<StopSaleBill> getPageybh(StopSaleBill mc, int i, int pagesize);

	int getTotalCountybh(StopSaleBill mc);

	void audit(String string);

	int findCount(Long id);

	void del(String string);

	List<QualityMidicine> findypJsonqy();

	List<Qualifiedmedcstore> findypJsonqyById(String id);
	List<StopSaleBill> getAllByState(String hql ,Map map);
	List<StopSaleBillVO> getPage(String commonName,String status,int first,int pageSize);
	int countStopSaleBillByStatus(String commonName,String status);
	public StopSaleBillVO getStopSaleBillVOById(String id);
	
	/**
	 * 根据药品id获取停售的药品，并且这些批号的药品并未建立不合格药品
	 */
	List<StopSaleBill> findStopSaleById(String id);

}
