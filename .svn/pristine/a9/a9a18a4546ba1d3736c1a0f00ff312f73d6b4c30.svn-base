package com.sinosoft.varietyManger.firstVarietyManger.dao;


import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;

public interface QualityMidicineDao extends GenericDao<QualityMidicine, Long>{
	QualityMidicine findById(String id);

	void updata(QualityMidicine qm);
	
	public List<QualityMidicine>  getAll(String hql);
	
	public  List<PurchaseOrderMidicineVO> getPurchaseOrderMidicineVo(final String hql,final int first,int pagesize);
	public  List<ChectAcceptMidicineVO> getChectAcceptMidicineVO(final String hql, final int first,int pagesize);
	public List<ReceiveMidicineVO> getReceiveMidicineVO(final String hql,final int first,int pagesize);
	public List<MaintenanceMidicineVO> getMaintenanceMidicineVO(final String hql ,final int first ,int pagesize);
	public List<QualifiedmedcstoreVO> getQualifiedmedcstoreVO(final String hql ,final int first,int pagesize);
	public List<MidicineOutCheckVO> getMidicineOutCheckVO(final String hql ,final int first,int pagesize);
	public List<TrtssSalesFormMidicineVO> getTrtssSalesFormMidicineVO(final String hql ,final int first,int pagesize);
	public QualityMidicine findByFirstVarietyId(Long id);
}
