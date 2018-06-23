package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualPurchUnitsAccessoryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnitsAccessory;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualPurchUnitsAccessoryService;

/**
 * @author lfl:
 * @version 创建时间：May 30, 2013 3:31:13 PM
 * 类说明
 */
@Service
public class QualPurchUnitsAccessoryServiceImpl extends
		GenericManagerImpl<QualifiedPurchaseUnitsAccessory, Long> implements QualPurchUnitsAccessoryService {
	private QualPurchUnitsAccessoryDao  qualPurchUnitsAccessoryDao;
	@Autowired
	public QualPurchUnitsAccessoryServiceImpl(QualPurchUnitsAccessoryDao qualPurchUnitsAccessoryDao){
		super(qualPurchUnitsAccessoryDao);
		this.qualPurchUnitsAccessoryDao =qualPurchUnitsAccessoryDao;
	}
	@Override
	public int countRecord(long qualUtilId) {
		String sql = "select count(*) from t_qualified_purchase_units_archives where qualified_purchase_units_id="+qualUtilId;
		return getRecordCount(sql);
	}

	@Override
	public List<QualifiedPurchaseUnitsAccessory> findAccessoriesListByPage(
			long qualUtilId, int first, int pagesize) {
		return qualPurchUnitsAccessoryDao.findAccessoriesListByPage(qualUtilId, first, pagesize);
	}
	@Override
	public void saveList(
			List<QualifiedPurchaseUnitsAccessory> quaPurcUnitsAccessoryList) {
		Iterator<QualifiedPurchaseUnitsAccessory>  its = quaPurcUnitsAccessoryList.iterator();
		while(its.hasNext()){
			save(its.next());
		}
	}
	

}
