package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.ProcurementStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.ProcurementStaffService;
@Service
public class ProcurementStaffServiceImpl extends GenericManagerImpl<ProcurementStaff, Long>
		implements ProcurementStaffService {
	private ProcurementStaffDao procurementStaffDao;
	@Autowired
	public ProcurementStaffServiceImpl(ProcurementStaffDao procurementStaffDao){
		super(procurementStaffDao);
		this.procurementStaffDao =procurementStaffDao;
	}
	@Override
	public List<ProcurementStaff> findProcurementStaffByParam(String type,
			String param, String personType, int first, int pagesize) {
		return procurementStaffDao.findProcurementStaffByParam(type, param, personType, first, pagesize);
	}

	@Override
	public List<ProcurementStaff> findProcurementStaffByType(String type,
			int first, int pagesize) {
		return procurementStaffDao.findProcurementStaffByType(type, first, pagesize);
	}

	@Override
	public List<ProcurementStaff> fingProcurementStaffAllByType(String type,String personType) {
		// TODO Auto-generated method stub
		return procurementStaffDao.fingProcurementStaffAllByType(type,personType);
	}
	@Override
	public int countProcumentStaffByCondition(String queryName,
			String personType) {
		// TODO Auto-generated method stub
		return procurementStaffDao.countProcumentStaffByCondition(queryName, personType);
	}
	@Override
	public List<ProcurementStaff> queryProcumentStaffByCondition(
			String queryName, String personType, int first, int pagesize) {
		// TODO Auto-generated method stub
		return procurementStaffDao.queryProcumentStaffByCondition(queryName, personType, first, pagesize);
	}

}
