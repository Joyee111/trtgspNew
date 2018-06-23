package com.sinosoft.drugState.salereturn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.salereturn.dao.SaleReturnDao;
import com.sinosoft.drugState.salereturn.model.SaleReturnBill;
import com.sinosoft.drugState.salereturn.service.SaleReturnMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
@Service
public class SaleReturnMngImpl implements SaleReturnMng{
	@Autowired
	private SaleReturnDao saleReturnDao;
	
	
	@Override
	public List<SaleReturnBill> getPage(SaleReturnBill mc, int i, int pagesize) {
		return saleReturnDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount(SaleReturnBill mc) {
		return saleReturnDao.getTotalCount(mc);
	}

	@Override
	public SaleReturnBill save(SaleReturnBill mc) {
		return saleReturnDao.save(mc);
	}

	@Override
	public SaleReturnBill findById(String id) {
		return saleReturnDao.findById(id);
	}

	@Override
	public void update(SaleReturnBill mc) {
		saleReturnDao.update(mc);
	}

	@Override
	public List<SaleReturnBill> getPagedsh(SaleReturnBill mc, int i,
			int pagesize) {
		return saleReturnDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(SaleReturnBill mc) {
		return saleReturnDao.getTotalCountdsh(mc);
	}


	@Override
	public List<SaleReturnBill> getPageysh(SaleReturnBill mc, int i,
			int pagesize) {
		return saleReturnDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(SaleReturnBill mc) {
		return saleReturnDao.getTotalCountysh(mc);
	}

	@Override
	public List<SaleReturnBill> getPageybh(SaleReturnBill mc, int i,
			int pagesize) {
		return saleReturnDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(SaleReturnBill mc) {
		return saleReturnDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		saleReturnDao.audit(id);
	}


	@Override
	public int findCount(Long id) {
		return saleReturnDao.findCount(id);
	}

	@Override
	public void del(String id) {
		saleReturnDao.del(id);
	}

	@Override
	public QualifiedPurchaseUnits findghById(Long qualifiedPurchaseUnitsId) {
		return saleReturnDao.findghById(qualifiedPurchaseUnitsId);
	}

	@Override
	public List<SaleReturnBill> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return saleReturnDao.getAllByState(hql, map);
	}

}
