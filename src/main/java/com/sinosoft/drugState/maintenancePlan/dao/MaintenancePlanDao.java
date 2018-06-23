package com.sinosoft.drugState.maintenancePlan.dao;

import java.util.List;

import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;

/**
 * 养护计划dao层
 * 合格药品库替换为新的合格药品库，包括了返厂数据
 * 修改人：王海楠	时间：2016-6-7 14:28:10
 * @author Administrator
 *
 */
public interface MaintenancePlanDao {

	List<QualifiedmedcstoreRe> getPage(QualifiedmedcstoreRe qm, int i, int pagesize);

	int getTotalCount(QualifiedmedcstoreRe qm);

	QualifiedmedcstoreRe findById(String id);

	WarnConfig findWanrn();
	/**
	 * 根据下一个养护计划日期查询药品
	 * @param startDae
	 * @param endDate
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<QualifiedmedcstoreRe> getQualifiedMdecByDate(String startDae,String endDate,String batchNumber, int first, int pagesize);
	/**
	 * 根据条件查询养护计划
	 * @param startDate
	 * @param endDate
	 * @param bathcNumber
	 * @return
	 */
	public int countQualifiedMdeByCondition(String startDate, String endDate, String bathcNumber);

}
