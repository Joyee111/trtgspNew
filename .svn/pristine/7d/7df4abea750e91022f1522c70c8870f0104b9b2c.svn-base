package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualProcurementStaffAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedProcurementStaffAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualProcurementStaffAccessoryService;

@Service
public class QualProStaffAccessoryServiceImpl extends
		GenericManagerImpl<QualifiedProcurementStaffAccessory, Long> implements QualProcurementStaffAccessoryService {
	private QualProcurementStaffAccessoryDao  qualProcurementStaffAccessoryDao;
	@Autowired
	public QualProStaffAccessoryServiceImpl(QualProcurementStaffAccessoryDao qualProcurementStaffAccessoryDao){
		super(qualProcurementStaffAccessoryDao);
		this.qualProcurementStaffAccessoryDao =qualProcurementStaffAccessoryDao;
	}
	@Override
	public int countRecord(long salesStaffId) {
		String sql = "select count(*) from t_qualified_sales_staff_archives where qualified_sales_staff_id="+salesStaffId;
		return getRecordCount(sql);
	}

	@Override
	public List<QualifiedProcurementStaffAccessory> findAccessoriesListByPage(
			long qualUtilId, int first, int pagesize) {
		return qualProcurementStaffAccessoryDao.findAccessoriesListByPage(qualUtilId, first, pagesize);
	}
	@Override
	public void saveList(List<QualifiedProcurementStaffAccessory> quaPurcUnitsAccessoryList) {
		Iterator<QualifiedProcurementStaffAccessory>  its = quaPurcUnitsAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}
	

}
