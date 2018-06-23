package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.DrugStandardsFilesDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.DrugStandardsFiles;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.DrugStandardFilesService;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 11:28:38 AM
 * 类说明
 */
@Service
public class DrugStandardFilesServiceImpl extends GenericManagerImpl<DrugStandardsFiles, Long>
		implements DrugStandardFilesService {
	private DrugStandardsFilesDao  drugStandardsFilesDao;
	@Autowired
	public DrugStandardFilesServiceImpl(DrugStandardsFilesDao drugStandardsFilesDao){
		super(drugStandardsFilesDao);
		this.drugStandardsFilesDao =drugStandardsFilesDao;
	}
	@Override
	public List<DrugStandardsFiles> findListByPage(String hql, int first,
			int pagesize) {
		
		return drugStandardsFilesDao.findByPage(hql, first, pagesize);
	}
	@Override
	public String getMaxNumber() {
		// TODO Auto-generated method stub
		return drugStandardsFilesDao.getMaxNumber();
	}

	

}
