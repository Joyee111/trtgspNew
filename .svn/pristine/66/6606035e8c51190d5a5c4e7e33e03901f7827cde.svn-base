package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.PurchaseUnitsDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TrtssProv;
import com.sinosoft.enterpriseManage.firstEnterprise.service.PurchaseUnitsService;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 2:52:15 PM
 * 类说明
 */
@Service
public class PurchaseUnitsServiceImpl extends GenericManagerImpl<PurchaseUnit, Long>
		implements PurchaseUnitsService {
	private PurchaseUnitsDao purchaseUnitsDao;
	@Autowired
	public PurchaseUnitsServiceImpl(PurchaseUnitsDao purchaseUnitsDao){
		super(purchaseUnitsDao);
		this.purchaseUnitsDao = purchaseUnitsDao;
	}
	@Override
	public int countRecordByState(int state) {
		return purchaseUnitsDao.countRecordByState(state);
	}

	@Override
	public List<PurchaseUnit> findListByPage(int state, int first, int pagesize) {
		String hql = "from PurchaseUnit a where 1=1 and  a.reviewStatus="+state+" and authorization_date <> '9999-12-31' order by a.id DESC";
		return purchaseUnitsDao.findListByPage(hql, first, pagesize);
	}

	@Override
	public List<PurchaseUnit> findListByPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		return purchaseUnitsDao.findListByPage(hql, paramMap, first, pagesize);
	}
	@Override
	public Map<String, String> qmMap() {
		return purchaseUnitsDao.qmMap();
	}
	@Override
	public String findNumberByPro(String number) {
		return purchaseUnitsDao.findNumberByPro(number);
	}
	@Override
	public TrtssProv findTrtssProvByNo(String substring) {
		return purchaseUnitsDao.findTrtssProvByNo(substring);
	}
	@Override
	public List<PurchaseUnit> findListByParam(String param) {
		
		return purchaseUnitsDao.findListByParam(param);
	}
	@Override
	public List<PurchaseUnit> findExceptPurchaseUnit(String companyOrcorporation, int first, int pagesize) {
		// TODO Auto-generated method stub
		return purchaseUnitsDao.findExceptPurchaseUnit(companyOrcorporation, first, pagesize);
	}
	@Override
	public Boolean checkName(String name) {
		
		return purchaseUnitsDao.checkName(name);
	}


}
