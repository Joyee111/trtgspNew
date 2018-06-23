package com.sinosoft.drugState.maintenancePlan.service;

import java.util.List;

import com.sinosoft.systemConfig.WarnConfig;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreRe;

/**
 * 养护计划
 * 养护计划的合格药品库改为QualifiedmedcstoreRe，原有的合格药品库不再用于生成养护计划
 * 2016-6-7 13:12:11
 * @author 王海楠
 *
 */
public interface MaintenancePlanMng {

	/**
	 * @param qm 查询参数
	 * @param i
	 * @param pagesize
	 * @return 符合条件的Qualifiedmedcstore集合
	 */
	List<QualifiedmedcstoreRe> getPage(QualifiedmedcstoreRe qm, int i, int pagesize);

	/**
	 * @param qm
	 * @return
	 */
	int getTotalCount(QualifiedmedcstoreRe qm);

	/**根据药品库ID查询根据药品库ID
	 * @param id 根据药品库ID
	 * @return QualifiedmedcstoreRe
	 */
	QualifiedmedcstoreRe findById(String id);

	/**
	 * @return 返回预警对象 查询养护周期
	 */
	WarnConfig findWanrn();
	
	List<QualifiedmedcstoreRe> getQualifiedMdecByDate(String startDae,String endDate,String batchNumber,int first,int pagesize);
	/**
	 * 根据条件统计出库复核记录
	 * @param startDate
	 * @param endDate
	 * @param bathcNumber
	 * @return
	 */
	public int countQualifiedMdeByCondition(String startDate, String endDate, String bathcNumber);

}
