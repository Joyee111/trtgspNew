package com.sinosoft.dictionary.dao;

import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.dictionary.mode.DrugFormDictionary;

/**
 * @author lfl:
 * @version 创建时间：Jun 6, 2013 2:40:09 PM
 * 类说明
 */
public interface DrugFormDictionaryDao extends GenericDao<DrugFormDictionary, Long> {
	public List<DrugFormDictionary> getDrugFromDictionnaryOrderByName();
}
