package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;
import java.util.Map;

import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

public interface QualifiedmedcstoreMng {
	
	public Qualifiedmedcstore savequ(Qualifiedmedcstore qu);
	public Qualifiedmedcstore updatequ(Qualifiedmedcstore qu);
	public Qualifiedmedcstore findByBaNo(String no);
	public List<Qualifiedmedcstore> findQualifiedMedcStore(String hql,int first ,int pagesize);
	public List<Qualifiedmedcstore> getAllByState(String hql,Map map);
	/**
	 * 根据日期查询近效期药品月预警
	 * @param date
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<Qualifiedmedcstore> getQualifiedMedicValidWarning(String date,int first ,int pagesize);
	public int countQualifiedMedicValidWarning(String date );
	
	/**
	 * 根据批号和药品id找到合格药品库数据
	 * @param batch
	 * @param id
	 * @return
	 * @author whn
	 * 2017-2-17 20:19:38
	 */
	public Qualifiedmedcstore findStoreByBaId(String batch,Long id);

}
