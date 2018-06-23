package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualifiedProcurementStaffDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.ProcurementStaff;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualifiedProcurementStaffService;

@Service
public class QualifiedProcurementStaffServiceImpl extends
		GenericManagerImpl<ProcurementStaff, Long> implements QualifiedProcurementStaffService {
	private QualifiedProcurementStaffDao qualifiedProcurementStaffDao;
	@Autowired
	public QualifiedProcurementStaffServiceImpl(QualifiedProcurementStaffDao qualifiedProcurementStaffDao){
		super(qualifiedProcurementStaffDao);
		this.qualifiedProcurementStaffDao = qualifiedProcurementStaffDao;
	}
	@Override
	public int countRecordByCondition(String sql) {
		return qualifiedProcurementStaffDao.countRecordByCondition(sql);
	}

	@Override
	public List<ProcurementStaff> findListByPage(String hql, int first,
			int pagesize) {
		return qualifiedProcurementStaffDao.findListByPage(hql, first, pagesize);
	}

	@Override
	public List<ProcurementStaff> findListByaPage(String hql,
			Map<String, Object> paramMap, int first, int pagesize) {
		return qualifiedProcurementStaffDao.findListByaPage(hql, paramMap, first, pagesize);
	}
	@Override
	public List<ProcurementStaff> findList(String hql) {
		// TODO Auto-generated method stub
		return qualifiedProcurementStaffDao.findList(hql);
	}
	@Override
	public ProcurementStaff findByProcurementStaffId(Long id) {
		// TODO Auto-generated method stub
		return qualifiedProcurementStaffDao.findByProStaffId(id);
	}
}
