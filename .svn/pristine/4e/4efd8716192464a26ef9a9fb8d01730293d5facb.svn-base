package com.sinosoft.varietyManger.firstVarietyManger.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.varietyManger.firstVarietyManger.dao.FirstVarietyDao;
import com.sinosoft.varietyManger.firstVarietyManger.model.FirstVariety;
import com.sinosoft.varietyManger.firstVarietyManger.serivice.FirstVarietyService;

/**
 * @author lfl:
 * @version 创建时间：Jun 5, 2013 4:26:50 PM
 * 类说明
 */
@Service
public class FirstVarietyServiceImpl extends GenericManagerImpl<FirstVariety, Long>
		implements FirstVarietyService {
	
	private FirstVarietyDao firstVarietyDao;
	@Autowired
	public FirstVarietyServiceImpl(FirstVarietyDao firstVarietyDao){
		super(firstVarietyDao);
		this.firstVarietyDao = firstVarietyDao;
	}
	@Override
	public int countRecordByType(Integer type) {
		return firstVarietyDao.countRecordByType(type);
	}

	@Override
	public List<FirstVariety> findListByType(Integer type, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return firstVarietyDao.findListByType(type, first, pagesize);
	}
	@Override
	public List<FirstVariety> findListByType(String hql, Map map, int first,
			int pagesize) {
		
		return firstVarietyDao.getListByPage(hql, map, first, pagesize);
	}
	@Override
	public List<FirstVariety> findAllMedinceListByState(Integer state) {
		
		return firstVarietyDao.findAllMedinceListByState(state);
	}

}
