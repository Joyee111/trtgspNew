package com.sinosoft.drugState.accepreturn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.accepreturn.dao.ReturnTaceDao;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.accepreturn.service.ReturnTaceMng;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;

@Service
public class ReturnTaceMngImpl implements ReturnTaceMng {
	
	@Autowired
	private ReturnTaceDao returnTaceDao;
	
	@Override
	public List<ReturnCheckAcceptNote> getPage(ReturnCheckAcceptNote mc, int i, int pagesize) {
		return returnTaceDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount(ReturnCheckAcceptNote reNo) {
		return returnTaceDao.getTotalCount(reNo);
	}

	@Override
	public ReturnCheckAcceptNote save(ReturnCheckAcceptNote mc) {
		return returnTaceDao.save(mc);
	}

	@Override
	public ReturnCheckAcceptNote findById(String id) {
		return returnTaceDao.findById(id);
	}

	@Override
	public void update(ReturnCheckAcceptNote mc) {
		returnTaceDao.update(mc);
	}

	@Override
	public List<ReturnCheckAcceptNote> getPagedsh(ReturnCheckAcceptNote mc, int i,
			int pagesize) {
		return returnTaceDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(ReturnCheckAcceptNote mc) {
		return returnTaceDao.getTotalCountdsh(mc);
	}

	@Override
	public List<ReturncheckItem> find(String id) {
		return returnTaceDao.find(id);
	}

	@Override
	public List<ReturnCheckAcceptNote> getPageysh(ReturnCheckAcceptNote mc, int i,
			int pagesize) {
		return returnTaceDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(ReturnCheckAcceptNote mc) {
		return returnTaceDao.getTotalCountysh(mc);
	}

	@Override
	public List<ReturnCheckAcceptNote> getPageybh(ReturnCheckAcceptNote mc, int i,
			int pagesize) {
		return returnTaceDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(ReturnCheckAcceptNote mc) {
		return returnTaceDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		returnTaceDao.audit(id);
	}

	@Override
	public List<ReturncheckItem> findYp(Long id) {
		return returnTaceDao.findYp(id);
	}

	@Override
	public List<?> findAllId(Long id) {
		return returnTaceDao.findAllId(id);
	}

	@Override
	public List<ReturncheckItem> find(Long id, int i, int pagesize) {
		return returnTaceDao.find(id,i,pagesize);
	}

	@Override
	public int findCount(Long id) {
		return returnTaceDao.findCount(id);
	}

	@Override
	public void del(String id) {
		returnTaceDao.del(id);
	}

	@Override
	public List<ReturnReceivingNote> findthdJson() {
		return returnTaceDao.findthdJson();
	}

	@Override
	public List<ReturnReceivingNoteItem> findthd(String id) {
		return returnTaceDao.findthd(id);
	}

	@Override
	public List<ReturnCheckAcceptNote> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return returnTaceDao.getAllByState(hql, map);
	}

	@Override
	public List<ReturnCheckAcceptNote> getReturnCheckAcceptNoteByCondition(
			String date, String customerName, String status, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return returnTaceDao.getReturnCheckAcceptNoteByCondition(date, customerName, status, first, pagesize);
	}

	@Override
	public int countReturnCheckAcceptNoteByConiction(String date,
			String customerName, String status) {
		// TODO Auto-generated method stub
		return returnTaceDao.countReturnCheckAcceptNoteByConiction(date, customerName, status);
	}

	@Override
	public int countReturnCheckAcceptNoteVOByConiction(String date,
			String customerName, String status) {
		// TODO Auto-generated method stub
		return returnTaceDao.countReturnCheckAcceptNoteVOByConiction(date, customerName, status);
	}

	@Override
	public List<ReturnCheckAcceptNoteVO> getReturnCheckAcceptNoteVOByCondition(
			String date, String customerName, String status, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return returnTaceDao.getReturnCheckAcceptNoteVOByCondition(date, customerName, status, first, pagesize);
	}

}
