package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;

public interface ProcurementStaffService extends GenericManager<ProcurementStaff, Long> {
	public  List<ProcurementStaff> findProcurementStaffByType(String type,int first ,int pagesize);
	public  List<ProcurementStaff> findProcurementStaffByParam(String type,String param, String personType, int first,int pagesize);
	public List<ProcurementStaff> fingProcurementStaffAllByType(String type,String personType);
	public List<ProcurementStaff> queryProcumentStaffByCondition(String queryName,String personType, int first, int pagesize);
	public int countProcumentStaffByCondition(String queryName, String personType);
}
