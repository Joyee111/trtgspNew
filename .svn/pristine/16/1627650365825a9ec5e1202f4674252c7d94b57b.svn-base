package com.sinosoft.drugState.salereturn.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;


public interface SaleReturnDao {
	
	List<SaleReturnBill> getPage(SaleReturnBill mc, int i, int pagesize);

	int getTotalCount(SaleReturnBill mc);

	SaleReturnBill save(SaleReturnBill mc);

	SaleReturnBill findById(String id);

	void update(SaleReturnBill mc);

	List<SaleReturnBill> getPagedsh(SaleReturnBill mc, int i, int pagesize);

	int getTotalCountdsh(SaleReturnBill mc);


	List<SaleReturnBill> getPageysh(SaleReturnBill mc, int i, int pagesize);

	int getTotalCountysh(SaleReturnBill mc);

	int getTotalCountybh(SaleReturnBill mc);

	List<SaleReturnBill> getPageybh(SaleReturnBill mc, int i, int pagesize);

	void audit(String id);

	int findCount(Long id);

	void del(String id);

	QualifiedPurchaseUnits findghById(Long qualifiedPurchaseUnitsId);
	List<SaleReturnBill>  getAllByState(String hql ,Map map);

}
