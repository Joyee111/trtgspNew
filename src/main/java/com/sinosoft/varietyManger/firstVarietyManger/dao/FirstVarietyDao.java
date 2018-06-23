package com.sinosoft.varietyManger.firstVarietyManger.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 4:14:12 PM
 * 类说明
 */
public interface FirstVarietyDao extends GenericDao<FirstVariety,Long> {
	public List<FirstVariety> findListByType(Integer type,int first,int pagesize);
	public int countRecordByType(Integer type);
	public List<FirstVariety> findAllMedinceListByState(Integer state );
}
