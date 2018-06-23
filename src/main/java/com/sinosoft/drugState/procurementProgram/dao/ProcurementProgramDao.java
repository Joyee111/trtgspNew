package com.sinosoft.drugState.procurementProgram.dao;

import java.util.List;

import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;

public interface ProcurementProgramDao {

	List<PurchasePlanItem> getPage(PurchasePlan rurIt, String types, int i, int pagesize);
	List<PurchasePlanItem> getAllPurchasePlanIten(PurchasePlan rurIt, String types);

	int getTotalCount(PurchasePlan rurIt, String types);


	PurchasePlan savepl(PurchasePlan pl);

	PurchasePlan find(String departmentId,String season, String year, Long parseLong);

	PurchasePlanStore findps(String departmentId, String season, String year, Long parseLong);

	String findAllNo(String year, String season, String whone);

}
