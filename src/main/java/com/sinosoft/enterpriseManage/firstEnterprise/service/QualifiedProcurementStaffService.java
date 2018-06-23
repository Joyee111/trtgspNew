package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;
import java.util.Map;
import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;

public interface QualifiedProcurementStaffService extends GenericManager<ProcurementStaff, Long> {
	public List<ProcurementStaff> findListByPage(String hql ,int first ,int pagesize);
	public List<ProcurementStaff> findListByaPage(String hql,Map<String, Object> paramMap,int first ,int pagesize);
	
	public int countRecordByCondition(String sql);
	public List<ProcurementStaff> findList(String hql);
	public ProcurementStaff findByProcurementStaffId(Long id);
}
