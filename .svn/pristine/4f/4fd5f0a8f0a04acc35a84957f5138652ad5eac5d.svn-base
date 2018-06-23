package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.ChectAcceptMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MaintenanceMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.MidicineOutCheckVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.PurchaseOrderMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualifiedmedcstoreVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;
import com.sinosoft.varietyManger.firstVarietyManger.model.ReceiveMidicineVO;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;

public interface QualityMidicineMng  extends GenericManager<QualityMidicine, Long>{
	QualityMidicine findById(String id);
	
	void updata(QualityMidicine qm);
	List<QualityMidicine>  getListByPage(String hql,Map map,int first,int pagesize);
	List<QualityMidicine> getAll(String hql);
	List<QualityMidicine> findList(String hql ,int first,int pagesize);
	
	List<PurchaseOrderMidicineVO> getPurchaseOrderMidicineVo(final String hql, final int first,final int pagesize );
	List<ChectAcceptMidicineVO> getChectAcceptMidicineVO(final String hql, final int first,int pagesize);
	public List<ReceiveMidicineVO> getReceiveMidicineVO(String hql, int first,int pagesize);
	public List<MaintenanceMidicineVO> getMaintenanceMidicineVO(String hql ,int firsr,int pagesize);
	public List<QualifiedmedcstoreVO> getQualifiedmedcstoreVO(final String hql ,final int first,int pagesize);
	public List<MidicineOutCheckVO> getMidicineOutCheckVO(final String hql ,final int first,int pagesize);
	public List<TrtssSalesFormMidicineVO> getTrtssSalesFormMidicineVO(final String hql ,final int first,int pagesize);
	public QualityMidicine findByFirstVarietyId(Long id);
}
