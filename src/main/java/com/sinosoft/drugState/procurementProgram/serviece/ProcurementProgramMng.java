package com.sinosoft.drugState.procurementProgram.serviece;

import java.util.List;

import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;

public interface ProcurementProgramMng {

	/**
	 * @param rurIt
	 * @param types
	 * @param i
	 * @param pagesize
	 * @return list对象集合符合条件的所有对象集合
	 */
	List<PurchasePlanItem> getPage(PurchasePlan rurIt, String types, int i, int pagesize);
	/**
	 * 用于前台导出Excle
	 * @param plan
	 * @param types
	 * @return
	 */
	public List<PurchasePlanItem> getAllPurchasePlanIten(PurchasePlan plan, String types);

	/**
	 * @param rurIt
	 * @param types
	 * @return 符合条件的条数
	 */
	int getTotalCount(PurchasePlan rurIt, String types);

	/**
	 * @param pl 保存对象
	 * @return
	 */
	PurchasePlan save(PurchasePlan pl);

	/**
	 * 根据年份，季度，类型查询
	 * @param season
	 * @param year
	 * @param parseLong
	 * @return
	 */
	PurchasePlan find(String departmentId, String season, String year, Long parseLong);
	/**
	 * 
	 * 根据季度，年份，药品ID，是否已经已存在此种药品
	 * 
	 * **/
	PurchasePlanStore findps(String departmentId, String season, String year, Long parseLong);

	/**
	 * 根据年份，季度，类型查询所有符合的编号
	 * @param year 查询参数
	 * @param season 查询参数
	 * @param whone 查询参数
	 * @return
	 */
	String findAllNo(String year, String season, String whone);

}
