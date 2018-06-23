package com.sinosoft.drugState.mackNo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.mackNo.dao.MakeNoDao;
import com.sinosoft.drugState.mackNo.service.MakeNoMng;
import com.sinosoft.systemConfig.MakingNo;
@Service
public class MakeNoMngImpl implements MakeNoMng{
	@Autowired
	private MakeNoDao makeNoDao;

	@Override
	public String mackNo(String desc) {
		return makeNoDao.mackNo(desc);
	}

	@Override
	public String findNo(String purchasenoteact) {
		return makeNoDao.findNo(purchasenoteact);
	}

	@Override
	public String makeNo(String desc) {
		
		return makeNoDao.makeNo(desc);
	}

	@Override
	public List<MakingNo> getBillType(Map<String, Object> queryParams) {
		return makeNoDao.getBillType(queryParams);
		
	}

	@Override
	public MakingNo save(MakingNo mn) {
	
		return makeNoDao.save(mn);
	}

	@Override
	public void update(MakingNo mn) {
		makeNoDao.update(mn);
		
	}

	@Override
	public MakingNo findMNById(Long MakingNoId) {
		
		return makeNoDao.findMNById(MakingNoId);
	}




}
