package com.sinosoft.drugState.purreturn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.purreturn.dao.PurReturnDao;
import com.sinosoft.drugState.purreturn.model.PurchaseReturnBill;
import com.sinosoft.drugState.purreturn.service.PurReturnMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.EntryTicket;

@Service
public class PurReturnMngImpl implements PurReturnMng {
	
	@Autowired
	private PurReturnDao purReturnDao;
	
	@Override
	public List<PurchaseReturnBill> getPage(PurchaseReturnBill mc, int i, int pagesize) {
		return purReturnDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount(PurchaseReturnBill mc) {
		return purReturnDao.getTotalCount(mc);
	}
	public int getCount(PurchaseReturnBill mc) {
		return purReturnDao.getCount(mc);
	}
	@Override
	public PurchaseReturnBill save(PurchaseReturnBill mc) {
		return purReturnDao.save(mc);
	}

	@Override
	public PurchaseReturnBill findById(String id) {
		return purReturnDao.findById(id);
	}

	@Override
	public void update(PurchaseReturnBill mc) {
		purReturnDao.update(mc);
	}

	@Override
	public List<PurchaseReturnBill> getPagedsh(PurchaseReturnBill mc, int i,
			int pagesize) {
		return purReturnDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(PurchaseReturnBill mc) {
		return purReturnDao.getTotalCountdsh(mc);
	}


	@Override
	public List<PurchaseReturnBill> getPageysh(PurchaseReturnBill mc, int i,
			int pagesize) {
		return purReturnDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(PurchaseReturnBill mc) {
		return purReturnDao.getTotalCountysh(mc);
	}

	@Override
	public List<PurchaseReturnBill> getPageybh(PurchaseReturnBill mc, int i,
			int pagesize) {
		return purReturnDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(PurchaseReturnBill mc) {
		return purReturnDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		purReturnDao.audit(id);
	}


	@Override
	public int findCount(Long id) {
		return purReturnDao.findCount(id);
	}

	@Override
	public void del(String id) {
		purReturnDao.del(id);
	}

	@Override
	public QualifiedSuppliers findghById(Long qualifiedSupplierId) {
		return purReturnDao.findghById(qualifiedSupplierId);
	}

	@Override
	public List<EntryTicket> findPurchaseReturnBillById(String purchaseReturnId) {
		// TODO Auto-generated method stub
		return purReturnDao.findPurchaseReturnBillById(purchaseReturnId);
	}

}
