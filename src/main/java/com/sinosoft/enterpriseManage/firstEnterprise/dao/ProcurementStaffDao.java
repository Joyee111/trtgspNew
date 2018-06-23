package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;

public interface ProcurementStaffDao extends GenericDao<ProcurementStaff, Long> {
	public  List<ProcurementStaff> findProcurementStaffByType(String type,int first ,int pagesize);
	public  List<ProcurementStaff> findProcurementStaffByParam(String type,String param,String personType,int first,int pagesize);
	public List<ProcurementStaff> fingProcurementStaffAllByType(String type,String personType);
	
	public List<ProcurementStaff> queryProcumentStaffByCondition(String queryName,String personType, int first, int pagesize);
	public int countProcumentStaffByCondition(String queryName, String personType);
}
