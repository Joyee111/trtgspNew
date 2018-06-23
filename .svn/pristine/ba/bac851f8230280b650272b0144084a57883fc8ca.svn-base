package com.sinosoft.drugState.purreturn.service;

import java.util.List;

import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.EntryTicket;


public interface PurReturnMng {

	/**
	 * @param mc 
	 * @return 符合条件的数量
	 */
	int getTotalCount(PurchaseReturnBill mc);

	int getCount(PurchaseReturnBill mc);
	/**
	 * @param mc 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 返回符合条件的PurchaseReturnBill对象集合
	 */
	List<PurchaseReturnBill> getPage(PurchaseReturnBill mc, int i, int pagesize);

	/**
	 * @param mc保存的对象
	 * @return
	 */
	PurchaseReturnBill save(PurchaseReturnBill mc);

	/**
	 * 根据ID查询PurchaseReturnBill对象
	 * @param id 
	 * @return PurchaseReturnBill对象
	 */
	PurchaseReturnBill findById(String id);

	/**
	 * @param mc 更新对象
	 */
	void update(PurchaseReturnBill mc);

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return PurchaseReturnBill符合条件的list集合
	 */
	List<PurchaseReturnBill> getPagedsh(PurchaseReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 符合条件的数量
	 */
	int getTotalCountDsh(PurchaseReturnBill mc);

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return PurchaseReturnBill符合条件的list集合
	 */
	List<PurchaseReturnBill> getPageysh(PurchaseReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询参数
	 * @return 符合条件的数量
	 */
	int getTotalCountysh(PurchaseReturnBill mc);

	/**
	 * @param mc 查询条件
	 * @param i
	 * @param pagesize
	 * @return PurchaseReturnBill符合条件的list集合
	 */
	List<PurchaseReturnBill> getPageybh(PurchaseReturnBill mc, int i, int pagesize);

	/**
	 * @param mc 查询条件
	 * @return 符合条件的数量
	 */
	int getTotalCountybh(PurchaseReturnBill mc);

	/**
	 * @param string 方法已停用
	 */
	void audit(String string);

	/**
	 * 根据退货验收ID查询所有退货验收明细
	 * @param id 
	 * @return 根据ID查询ReturncheckItem明细
	 */
	int findCount(Long id);

	/**
	 * @param string 删除对象的ID
	 */
	void del(String string);

	/**
	 * @param qualifiedSupplierId 根据iD查询合格供应商对象
	 * @return 返回 QualifiedSuppliers
	 */
	QualifiedSuppliers findghById(Long qualifiedSupplierId);
	/**
	 * 根据ID查询入库单
	 * @param purchaseReturnId
	 * @return
	 */
	List<EntryTicket> findPurchaseReturnBillById(String purchaseReturnId);
}
