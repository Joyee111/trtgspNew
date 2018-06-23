package com.sinosoft.varietyManger.firstVarietyManger.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

public interface QualifiedmedcstoreDao {
	public Qualifiedmedcstore savequ(Qualifiedmedcstore qu);

	public Qualifiedmedcstore findqu(String batchproduction,
			Long qualifiedmedicineid);

	public Qualifiedmedcstore updatequ(Qualifiedmedcstore qu);

	public Qualifiedmedcstore findByBaNo(String no);
	
	public List<Qualifiedmedcstore> findQualifiedMedcStore(String hql,int first ,int pagesize);
	
	public List<Qualifiedmedcstore> getAllByState(String hql ,Map map);
	/**
	 * 根据日期查询近效期药品月预警
	 * @param date
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<Qualifiedmedcstore> getQualifiedMedicValidWarning(String date,int first ,int pagesize);
	public int countQualifiedMedicValidWarning(String date );

}
