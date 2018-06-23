package com.sinosoft.drugState.stopcell.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.stopcell.dao.StopCellDao;
import com.sinosoft.drugState.stopcell.model.StopSaleBill;
import com.sinosoft.drugState.stopcell.model.StopSaleBillVO;
import com.sinosoft.drugState.stopcell.service.StopCellMng;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Service
public class StopCellMngImpl implements StopCellMng {
	@Autowired
	private StopCellDao stopCellDao;

	@Override
	public List<StopSaleBill> getPage(StopSaleBill mc, int i, int pagesize) {
		return stopCellDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount(StopSaleBill mc) {
		return stopCellDao.getTotalCount(mc);
	}

	@Override
	public StopSaleBill save(StopSaleBill mc) {
		return stopCellDao.save(mc);
	}

	@Override
	public StopSaleBill findById(String id) {
		return stopCellDao.findById(id);
	}

	@Override
	public void update(StopSaleBill mc) {
		stopCellDao.update(mc);
	}

	@Override
	public List<StopSaleBill> getPagedsh(StopSaleBill mc, int i,
			int pagesize) {
		return stopCellDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(StopSaleBill mc) {
		return stopCellDao.getTotalCountdsh(mc);
	}


	@Override
	public List<StopSaleBill> getPageysh(StopSaleBill mc, int i,
			int pagesize) {
		return stopCellDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(StopSaleBill mc) {
		return stopCellDao.getTotalCountysh(mc);
	}

	@Override
	public List<StopSaleBill> getPageybh(StopSaleBill mc, int i,
			int pagesize) {
		return stopCellDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(StopSaleBill mc) {
		return stopCellDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		stopCellDao.audit(id);
	}


	@Override
	public int findCount(Long id) {
		return stopCellDao.findCount(id);
	}

	@Override
	public void del(String id) {
		stopCellDao.del(id);
	}

	@Override
	public List<QualityMidicine> findypJsonqy() {
		return stopCellDao.findypJsonqy();
	}

	@Override
	public List<Qualifiedmedcstore> findypJsonqyById(String id) {
		return stopCellDao.findypJsonqyById(id);
	}

	@Override
	public List<StopSaleBill> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return stopCellDao.getAllByState(hql, map);
	}

	@Override
	public int countStopSaleBillByStatus(String commonName,
			String status) {
		// TODO Auto-generated method stub
		return stopCellDao.countStopSaleBillByStatus(commonName, status);
	}

	@Override
	public List<StopSaleBillVO> getPage(String commonName, String status,
			int first, int pageSize) {
		// TODO Auto-generated method stub
		return stopCellDao.getPage(commonName, status, first, pageSize);
	}

	@Override
	public StopSaleBillVO getStopSaleBillVOById(String id) {
		// TODO Auto-generated method stub
		return stopCellDao.getStopSaleBillVOById(id);
	}

	@Override
	public List<StopSaleBill> findStopSaleById(String id) {
		
		return stopCellDao.findStopSaleById(id);
	}

}
