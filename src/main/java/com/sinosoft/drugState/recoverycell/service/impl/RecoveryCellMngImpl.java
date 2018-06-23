package com.sinosoft.drugState.recoverycell.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.recoverycell.dao.RecoveryCellDao;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBill;
import com.sinosoft.drugState.recoverycell.model.RecoverySaleBillVO;
import com.sinosoft.drugState.recoverycell.service.RecoveryCellMng;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.Unqualifiedmedcstore;

@Service
public class RecoveryCellMngImpl implements RecoveryCellMng{
	@Autowired
	private RecoveryCellDao recoveryCellDao;
	
	@Override
	public List<RecoverySaleBill> getPage(RecoverySaleBill mc, int i, int pagesize) {
		return recoveryCellDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount(RecoverySaleBill mc) {
		return recoveryCellDao.getTotalCount(mc);
	}

	@Override
	public RecoverySaleBill save(RecoverySaleBill mc) {
		return recoveryCellDao.save(mc);
	}

	@Override
	public RecoverySaleBill findById(String id) {
		return recoveryCellDao.findById(id);
	}

	@Override
	public void update(RecoverySaleBill mc) {
		recoveryCellDao.update(mc);
	}

	@Override
	public List<RecoverySaleBill> getPagedsh(RecoverySaleBill mc, int i,
			int pagesize) {
		return recoveryCellDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(RecoverySaleBill mc) {
		return recoveryCellDao.getTotalCountdsh(mc);
	}


	@Override
	public List<RecoverySaleBill> getPageysh(RecoverySaleBill mc, int i,
			int pagesize) {
		return recoveryCellDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(RecoverySaleBill mc) {
		return recoveryCellDao.getTotalCountysh(mc);
	}

	@Override
	public List<RecoverySaleBill> getPageybh(RecoverySaleBill mc, int i,
			int pagesize) {
		return recoveryCellDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(RecoverySaleBill mc) {
		return recoveryCellDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		recoveryCellDao.audit(id);
	}


	@Override
	public int findCount(Long id) {
		return recoveryCellDao.findCount(id);
	}

	@Override
	public void del(String id) {
		recoveryCellDao.del(id);
	}

	@Override
	public List<QualityMidicine> findypJsonqy() {
		return recoveryCellDao.findypJsonqy();
	}

	@Override
	public List<Unqualifiedmedcstore> findypJsonqyById(String id) {
		return recoveryCellDao.findypJsonqyById(id);
	}

	@Override
	public List<RecoverySaleBill> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return recoveryCellDao.getAllByState(hql, map);
	}

	@Override
	public int countRecoverCellByCondication(String commonName, String status) {
		// TODO Auto-generated method stub
		return recoveryCellDao.countRecoverCellByCondication(commonName, status);
	}

	@Override
	public List<RecoverySaleBillVO> getRecoverCellByCondication(
			String commonName, String status, int first, int pageseize) {
		// TODO Auto-generated method stub
		return recoveryCellDao.getRecoverCellByCondication(commonName, status, first, pageseize);
	}

}
