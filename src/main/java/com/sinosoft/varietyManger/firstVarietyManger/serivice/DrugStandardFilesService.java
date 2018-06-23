package com.sinosoft.varietyManger.firstVarietyManger.serivice;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.DrugStandardsFiles;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 11:26:41 AM
 * 类说明
 */
public interface DrugStandardFilesService extends GenericManager<DrugStandardsFiles, Long> {
	List<DrugStandardsFiles> findListByPage(String hql,int first,int pagesize);
	public String getMaxNumber();
}
