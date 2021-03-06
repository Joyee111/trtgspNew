package com.sinosoft.drugState.purreturn.dao;

import java.util.List;

import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.EntryTicket;


public interface PurReturnDao {
	
	List<PurchaseReturnBill> getPage(PurchaseReturnBill mc, int i, int pagesize);

	int getTotalCount(PurchaseReturnBill mc);
	
	int getCount(PurchaseReturnBill mc);
	
	PurchaseReturnBill save(PurchaseReturnBill mc);

	PurchaseReturnBill findById(String id);

	void update(PurchaseReturnBill mc);

	List<PurchaseReturnBill> getPagedsh(PurchaseReturnBill mc, int i, int pagesize);

	int getTotalCountdsh(PurchaseReturnBill mc);


	List<PurchaseReturnBill> getPageysh(PurchaseReturnBill mc, int i, int pagesize);

	int getTotalCountysh(PurchaseReturnBill mc);

	int getTotalCountybh(PurchaseReturnBill mc);

	List<PurchaseReturnBill> getPageybh(PurchaseReturnBill mc, int i, int pagesize);

	void audit(String id);

	int findCount(Long id);

	void del(String id);

	QualifiedSuppliers findghById(Long qualifiedSupplierId);
	/**
	 * 根据ID查询入库单
	 * @param purchaseReturnId
	 * @return
	 */
	public List<EntryTicket> findPurchaseReturnBillById(String purchaseReturnId);
}
