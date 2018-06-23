package com.sinosoft.dictionary.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.dictionary.mode.DrugFormDictionary;

/**
 * @author lfl:
 * @version 创建时间：Jun 6, 2013 2:42:50 PM
 * 类说明
 */
public interface DrugFormDictionaryService extends GenericManager<DrugFormDictionary, Long> {
	public List<DrugFormDictionary> getDrugFromDictionnaryOrderByName();
}
