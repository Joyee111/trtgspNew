package com.sinosoft.drugState.procurementProgram.serviece.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.procurementProgram.dao.ProcurementProgramDao;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlan;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanItem;
import com.sinosoft.drugState.procurementProgram.model.PurchasePlanStore;
import com.sinosoft.drugState.procurementProgram.serviece.ProcurementProgramMng;
@Service
public class ProcurementProgramMngImpl implements ProcurementProgramMng{
	
	@Autowired
	private ProcurementProgramDao procurementProgramDao;

	@Override
	public List<PurchasePlanItem> getPage(PurchasePlan rurIt, String types,int i, int pagesize) {
		return procurementProgramDao.getPage(rurIt, types,i, pagesize);
	}

	@Override
	public int getTotalCount(PurchasePlan rurIt,String types) {
		return procurementProgramDao.getTotalCount(rurIt,types);
	}

	@Override
	public PurchasePlan save(PurchasePlan pl) {
		return procurementProgramDao.savepl(pl);
	}

	@Override
	public PurchasePlan find(String departmentId,String season, String year, Long parseLong) {
		return procurementProgramDao.find(departmentId,season,year,parseLong);
	}

	@Override
	public PurchasePlanStore findps(String departmentId,String season, String year, Long parseLong) {
		return procurementProgramDao.findps(departmentId,season, year, parseLong);
	}

	@Override
	public String findAllNo(String year, String season, String whone) {
		return procurementProgramDao.findAllNo(year, season, whone);
	}

	@Override
	public List<PurchasePlanItem> getAllPurchasePlanIten(PurchasePlan plan,
			String types) {
		// TODO Auto-generated method stub
		return procurementProgramDao.getAllPurchasePlanIten(plan, types);
	}


}
