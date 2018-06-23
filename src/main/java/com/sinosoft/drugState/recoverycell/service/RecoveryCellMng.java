package com.sinosoft.drugState.recoverycell.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

public interface RecoveryCellMng {
	
	
	
	/**
	 * @param mc 查询参数
	 * @return 返回符合条件数量
	 */
	int getTotalCount(RecoverySaleBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 符合条件的对象集合
	 */
	List<RecoverySaleBill> getPage(RecoverySaleBill mc, int i, int pagesize);

	/**
	 * @param mc 保存对象
	 * @return 保存的对象
	 */
	RecoverySaleBill save(RecoverySaleBill mc);

	/**
	 * 根据ID查询RecoverySaleBill
	 * @param id 查询参数
	 * @return RecoverySaleBill
	 */
	RecoverySaleBill findById(String id);

	/**
	 * @param mc 更新的对象
	 */
	void update(RecoverySaleBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 返回符合条件的RecoverySaleBill对象集合
	 */
	List<RecoverySaleBill> getPagedsh(RecoverySaleBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的数量
	 */
	int getTotalCountDsh(RecoverySaleBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 返回符合条件的RecoverySaleBill对象集合
	 */
	List<RecoverySaleBill> getPageysh(RecoverySaleBill mc, int i, int pagesize);

	/**
	 * @param mc
	 * @return
	 */
	int getTotalCountysh(RecoverySaleBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 返回符合条件的RecoverySaleBill对象集合
	 */
	List<RecoverySaleBill> getPageybh(RecoverySaleBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的数量
	 */
	int getTotalCountybh(RecoverySaleBill mc);

	/**
	 * @param string 方法已停用
	 */
	void audit(String string);

	/**
	 * @param id 根据ID查询ReturncheckItem明细数量
	 * @return
	 */
	int findCount(Long id);

	/**
	 * @param string 删除对象的ID
	 */
	void del(String string);

	/**
	 * @return 所有不合格药品库的药品的对象集合
	 */
	List<QualityMidicine> findypJsonqy();

	/**
	 * @param id 查询参数
	 * @return 根据药品ID查询不合格药品库ReturnReceivingNote对象
	 */
	List<Unqualifiedmedcstore> findypJsonqyById(String id);
	List<RecoverySaleBill> getAllByState(String hql ,Map map);
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
