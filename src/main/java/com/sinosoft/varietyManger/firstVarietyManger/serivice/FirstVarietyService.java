package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 4:25:39 PM
 * 类说明
 */
public interface FirstVarietyService extends GenericManager<FirstVariety, Long> {
	public List<FirstVariety> findListByType(Integer type,int first,int pagesize);
	public List<FirstVariety> findListByType(String hql ,Map map,int first,int pagesize);
	public int countRecordByType(Integer type);
	public List<FirstVariety> findAllMedinceListByState(Integer state);
}
