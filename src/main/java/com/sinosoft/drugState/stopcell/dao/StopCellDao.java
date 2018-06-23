package com.sinosoft.drugState.stopcell.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

public interface StopCellDao {

	List<StopSaleBill> getPage(StopSaleBill mc, int i, int pagesize);

	int getTotalCount(StopSaleBill mc);

	StopSaleBill save(StopSaleBill mc);

	StopSaleBill findById(String id);

	void update(StopSaleBill mc);

	List<StopSaleBill> getPagedsh(StopSaleBill mc, int i, int pagesize);

	int getTotalCountdsh(StopSaleBill mc);


	List<StopSaleBill> getPageysh(StopSaleBill mc, int i, int pagesize);

	int getTotalCountysh(StopSaleBill mc);

	int getTotalCountybh(StopSaleBill mc);

	List<StopSaleBill> getPageybh(StopSaleBill mc, int i, int pagesize);

	void audit(String id);

	int findCount(Long id);

	void del(String id);

	List<QualityMidicine> findypJsonqy();

	List<Qualifiedmedcstore> findypJsonqyById(String id);
	List<StopSaleBill> getAllByState(String hql ,Map map);
	/**
	 * 根据通用名称和审核状态查询停售药品
	 * @param commonName
	 * @param status
	 * @param first
	 * @param pageSize
	 * @return
	 */
	List<StopSaleBillVO> getPage(String commonName,String status,int first,int pageSize);
	/**
	 * 根据通用名称和审核状态统计停售药品
	 * @param commonName
	 * @param status
	 * @return
	 */
	int countStopSaleBillByStatus(String commonName,String status);
	public StopSaleBillVO getStopSaleBillVOById(String id);
	
	/**
	 * 根据药品id获取停售的药品，并且这些批号的药品并未建立不合格药品
	 */
	List<StopSaleBill> findStopSaleById(String id);

}
