package com.sinosoft.drugState.acceptance.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.acceptance.dao.AcceptanceDao;
import com.sinosoft.drugState.acceptance.model.CheckAcceptNote;
import com.sinosoft.drugState.acceptance.model.CheckAcceptVO;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.drugState.acceptance.service.AcceptanceMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
@Service
public class AcceptanceMngImpl implements AcceptanceMng{
	@Autowired
	private AcceptanceDao acceptanceDao;

	@Override
	public List<CheckAcceptVO> getPage(String date,String customerName,String type, int i, int pagesize) {
		return acceptanceDao.getPage(date,customerName,type,i,pagesize);
	}

	@Override
	public int getTotalCount(CheckAcceptNote mc) {
		return acceptanceDao.getTotalCount(mc);
	}

	@Override
	public CheckAcceptNote save(CheckAcceptNote mc) {
		return acceptanceDao.save(mc);
	}

	@Override
	public CheckAcceptNote findById(String id) {
		return acceptanceDao.findById(id);
	}

	@Override
	public void update(CheckAcceptNote mc) {
		acceptanceDao.update(mc);
	}

	@Override
	public List<CheckAcceptNote> getPagedsh(CheckAcceptNote mc, int i,
			int pagesize) {
		return acceptanceDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh(CheckAcceptNote mc) {
		return acceptanceDao.getTotalCountdsh(mc);
	}

	@Override
	public List<CheckacceptItem> find(String id) {
		return acceptanceDao.find(id);
	}

	@Override
	public List<CheckAcceptNote> getPageysh(CheckAcceptNote mc, int i,
			int pagesize) {
		return acceptanceDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh(CheckAcceptNote mc) {
		return acceptanceDao.getTotalCountysh(mc);
	}

	@Override
	public List<CheckAcceptNote> getPageybh(CheckAcceptNote mc, int i,
			int pagesize) {
		return acceptanceDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh(CheckAcceptNote mc) {
		return acceptanceDao.getTotalCountybh(mc);
	}

	@Override
	public void audit(String id) {
		acceptanceDao.audit(id);
	}

	@Override
	public List<CheckacceptItem> findYp(Long id) {
		return acceptanceDao.findYp(id);
	}

	@Override
	public List<?> findAllId(Long id) {
		return acceptanceDao.findAllId(id);
	}

	@Override
	public List<CheckacceptItem> find(Long id, int i, int pagesize) {
		return acceptanceDao.find(id,i,pagesize);
	}

	@Override
	public int findCount(Long id) {
		return acceptanceDao.findCount(id);
	}

	@Override
	public void del(String id) {
		acceptanceDao.del(id);
	}

	@Override
	public QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId) {
		return acceptanceDao.findgouhuo(qualifiedSupplierId);
	}

	@Override
	public QualifiedSuppliers findgonghuo(Long qualifiedSupplierId) {
		return acceptanceDao.findgonghuo(qualifiedSupplierId);
	}

	@Override
	public List<CheckAcceptNote> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return acceptanceDao.getAllByState(hql, map);
	}

	@Override
	public int getRecordCount(String sql) {
		// TODO Auto-generated method stub
		return acceptanceDao.getRecordCount(sql);
	}

	@Override
	public int countTotalPage(String date, String xustomerName, String type) {
		// TODO Auto-generated method stub
		return acceptanceDao.countTotalPage(date, xustomerName, type);
	}

	@Override
	public List<CheckAcceptVO> getPageByType3(String date, String customerName,
			String type,String drugsType, int i, int pagesize) {
		// TODO Auto-generated method stub
		return acceptanceDao.getPageByType3(date, customerName, type,drugsType, i, pagesize);
	}

	@Override
	public int countTotalPageByType3(String date, String customerName,
			String type,String drugsType) {
		// TODO Auto-generated method stub
		return acceptanceDao.countTotalPageByType3(date, customerName, type,drugsType);
	}
	
	
	
}
