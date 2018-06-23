package com.sinosoft.dictionary.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.dictionary.dao.DrugFormDictionaryDao;
import com.sinosoft.dictionary.mode.DrugFormDictionary;
import com.sinosoft.dictionary.service.DrugFormDictionaryService;

/**
 * @author lfl:
 * @version 创建时间：Jun 6, 2013 2:43:54 PM
 * 类说明
 */
@Service
public class DrugFormDictionaryServiceImpl extends GenericManagerImpl<DrugFormDictionary, Long>
		implements DrugFormDictionaryService {
	private DrugFormDictionaryDao drugFormDictionaryDao;
	@Autowired
	public DrugFormDictionaryServiceImpl(DrugFormDictionaryDao drugFormDictionaryDao){
		super(drugFormDictionaryDao);
		this.drugFormDictionaryDao = drugFormDictionaryDao;
	}
	@Override
	public List<DrugFormDictionary> getDrugFromDictionnaryOrderByName() {
		// TODO Auto-generated method stub
		return drugFormDictionaryDao.getDrugFromDictionnaryOrderByName();
	}
	
}
