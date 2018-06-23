package com.sinosoft.drugState.acceptanceJH.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.acceptanceJH.dao.AcceptanceJHDao;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptJHVO;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptNoteJH;
import com.sinosoft.drugState.acceptanceJH.service.AcceptanceJHMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

@Service
public class AcceptanceJHMngImpl implements AcceptanceJHMng{
	@Autowired
	private AcceptanceJHDao acceptanceJHDao;

	@Override
	public List<CheckAcceptJHVO> getPage(String date,String customerName,String type, int i, int pagesize) {
		return acceptanceJHDao.getPage(date,customerName,type,i,pagesize);
	}

	@Override
	public int getTotalCount(CheckAcceptNoteJH mc) {
		return acceptanceJHDao.getTotalCount(mc);
	}

	@Override
	public CheckAcceptNoteJH save(CheckAcceptNoteJH mc) {
		return acceptanceJHDao.save(mc);
	}

	@Override
	public CheckAcceptNoteJH findById(String id) {
		return acceptanceJHDao.findById(id);
	}

	@Override
	public void update(CheckAcceptNoteJH mc) {
		acceptanceJHDao.update(mc);
	}

	@Override
	public List<CheckAcceptNoteJH> getPagedsh(CheckAcceptNoteJH mc, int i,
			int pagesize) {
		return acceptanceJHDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(CheckAcceptNoteJH mc) {
		return acceptanceJHDao.getTotalCountdsh(mc);
	}

	@Override
	public List<CheckAcceptItemJH> find(String id) {
		return acceptanceJHDao.find(id);
	}

	@Override
	public List<CheckAcceptNoteJH> getPageysh(CheckAcceptNoteJH mc, int i,
			int pagesize) {
		return acceptanceJHDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(CheckAcceptNoteJH mc) {
		return acceptanceJHDao.getTotalCountysh(mc);
	}

	@Override
	public List<CheckAcceptNoteJH> getPageybh(CheckAcceptNoteJH mc, int i,
			int pagesize) {
		return acceptanceJHDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(CheckAcceptNoteJH mc) {
		return acceptanceJHDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		acceptanceJHDao.audit(id);
	}

	@Override
	public List<CheckAcceptItemJH> findYp(Long id) {
		return acceptanceJHDao.findYp(id);
	}

	@Override
	public List<?> findAllId(Long id) {
		return acceptanceJHDao.findAllId(id);
	}

	@Override
	public List<CheckAcceptItemJH> find(Long id, int i, int pagesize) {
		return acceptanceJHDao.find(id,i,pagesize);
	}

	@Override
	public int findCount(Long id) {
		return acceptanceJHDao.findCount(id);
	}

	@Override
	public void del(String id) {
		acceptanceJHDao.del(id);
	}

	@Override
	public QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId) {
		return acceptanceJHDao.findgouhuo(qualifiedSupplierId);
	}

	@Override
	public QualifiedSuppliers findgonghuo(Long qualifiedSupplierId) {
		return acceptanceJHDao.findgonghuo(qualifiedSupplierId);
	}

	@Override
	public List<CheckAcceptNoteJH> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return acceptanceJHDao.getAllByState(hql, map);
	}

	@Override
	public int getRecordCount(String sql) {
		// TODO Auto-generated method stub
		return acceptanceJHDao.getRecordCount(sql);
	}

	@Override
	public int countTotalPage(String date, String xustomerName, String type) {
		// TODO Auto-generated method stub
		return acceptanceJHDao.countTotalPage(date, xustomerName, type);
	}

	@Override
	public List<CheckAcceptJHVO> getPageByType3(String date, String customerName,
			String type,String drugsType, int i, int pagesize) {
		// TODO Auto-generated method stub
		return acceptanceJHDao.getPageByType3(date, customerName, type,drugsType, i, pagesize);
	}

	@Override
	public int countTotalPageByType3(String date, String customerName,
			String type,String drugsType) {
		// TODO Auto-generated method stub
		return acceptanceJHDao.countTotalPageByType3(date, customerName, type,drugsType);
	}
}
