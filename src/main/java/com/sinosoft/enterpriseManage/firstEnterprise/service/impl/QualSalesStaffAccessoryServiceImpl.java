package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSalesStaffAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSalesStaffAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSalesStaffAccessoryService;

@Service
public class QualSalesStaffAccessoryServiceImpl extends
		GenericManagerImpl<QualifiedSalesStaffAccessory, Long> implements QualSalesStaffAccessoryService {
	private QualSalesStaffAccessoryDao  qualSalesStaffAccessoryDao;
	@Autowired
	public QualSalesStaffAccessoryServiceImpl(QualSalesStaffAccessoryDao qualSalesStaffAccessoryDao){
		super(qualSalesStaffAccessoryDao);
		this.qualSalesStaffAccessoryDao =qualSalesStaffAccessoryDao;
	}
	@Override
	public int countRecord(long salesStaffId) {
		String sql = "select count(*) from t_qualified_sales_staff_archives where qualified_sales_staff_id="+salesStaffId;
		return getRecordCount(sql);
	}

	@Override
	public List<QualifiedSalesStaffAccessory> findAccessoriesListByPage(
			long qualUtilId, int first, int pagesize) {
		return qualSalesStaffAccessoryDao.findAccessoriesListByPage(qualUtilId, first, pagesize);
	}
	@Override
	public void saveList(List<QualifiedSalesStaffAccessory> quaPurcUnitsAccessoryList) {
		Iterator<QualifiedSalesStaffAccessory>  its = quaPurcUnitsAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}
	

}
