package com.sinosoft.drugState.salereturn.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;


public interface SaleReturnMng {
	
	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的数量
	 */
	int getTotalCount(SaleReturnBill mc);

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return 返回符合条件的SaleReturnBill对象集合
	 */
	List<SaleReturnBill> getPage(SaleReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 保存对象
	 * @return
	 */
	SaleReturnBill save(SaleReturnBill mc);

	/**
	 * 根据ID查询SaleReturnBill对象
	 * @param id 查询参数
	 * @return SaleReturnBill对象
	 */
	SaleReturnBill findById(String id);

	/**
	 * @param mc 更新对象
	 */
	void update(SaleReturnBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 符合条件的SaleReturnBill对象集合
	 */
	List<SaleReturnBill> getPagedsh(SaleReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的SaleReturnBill对象数量
	 */
	int getTotalCountDsh(SaleReturnBill mc);

	/**
	* @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 符合条件的SaleReturnBill对象集合
	 */
	List<SaleReturnBill> getPageysh(SaleReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的SaleReturnBill对象数量
	 */
	int getTotalCountysh(SaleReturnBill mc);

	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 符合条件的SaleReturnBill对象集合
	 */
	List<SaleReturnBill> getPageybh(SaleReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 返回符合条件的SaleReturnBill对象数量
	 */
	int getTotalCountybh(SaleReturnBill mc);

	/**
	 * @param string方法已停用
	 */
	void audit(String string);

	/**
	 * 根据退货验收的ID查询明细对象ReturncheckItem
	 * @param id  
	 * @return
	 */
	int findCount(Long id);

	/**
	 * @param string 删除对象的ID
	 */
	void del(String string);

	/**
	 * 根据ID 查询QualifiedPurchaseUnits
	 * @param qualifiedPurchaseUnitsId
	 * @return
	 */
	QualifiedPurchaseUnits findghById(Long qualifiedPurchaseUnitsId);
	List<SaleReturnBill> getAllByState(String hql,Map map);

}
