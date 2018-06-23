package com.sinosoft.drugState.recoverycell.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

public interface RecoveryCellDao {
	List<RecoverySaleBill> getPage(RecoverySaleBill mc, int i, int pagesize);

	int getTotalCount(RecoverySaleBill mc);

	RecoverySaleBill save(RecoverySaleBill mc);

	RecoverySaleBill findById(String id);

	void update(RecoverySaleBill mc);

	List<RecoverySaleBill> getPagedsh(RecoverySaleBill mc, int i, int pagesize);

	int getTotalCountdsh(RecoverySaleBill mc);


	List<RecoverySaleBill> getPageysh(RecoverySaleBill mc, int i, int pagesize);

	int getTotalCountysh(RecoverySaleBill mc);

	int getTotalCountybh(RecoverySaleBill mc);

	List<RecoverySaleBill> getPageybh(RecoverySaleBill mc, int i, int pagesize);

	void audit(String id);

	int findCount(Long id);

	void del(String id);

	List<QualityMidicine> findypJsonqy();

	List<Unqualifiedmedcstore> findypJsonqyById(String id);
	public List<RecoverySaleBill> getAllByState(String hql, Map map);
	/**
	 * 根据通用名称和状态查询恢复销售单
	 * @param commonName
	 * @param status
	 * @param first
	 * @param pageseize
	 * @return
	 */
	List<RecoverySaleBillVO> getRecoverCellByCondication(String commonName,String status,int first,int pageseize);
	/**
	 * 根据通用名称和状态统计恢复销售单
	 * @param commonName
	 * @param status
	 * @return
	 */
	int countRecoverCellByCondication(String commonName,String status);
}
