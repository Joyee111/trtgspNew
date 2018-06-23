package com.sinosoft.qualityRecords.infoFeedback.serivice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.infoFeedback.dao.InfoFeedbackDao;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemAndUserVO;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedbackItem;
import com.sinosoft.qualityRecords.infoFeedback.serivice.InfoFeedbackMng;

@Service
public class InfoFeedbackMngImpl implements InfoFeedbackMng {
	@Autowired
	private InfoFeedbackDao infoFeedbackDao;
	
	@Override
	public int countFeedbackWaitingToDo(Long userId) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.countFeedbackWaitingToDo(userId);
	}
	@Override
	public int countInfoFeedbacks(String hql,Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.countInfoFeedbacks(hql,paramMap);
	}
	@Override
	public void deleteInfoFeedbacks(Long id) {
		// TODO Auto-generated method stub
		infoFeedbackDao.deleteInfoFeedbacks(id);
		
	}
	@Override
	public List<InfoFeedbackItem> findInfoFeedbackItemsByCondiction(
			Long infoFeedbackId, String userId) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findInfoFeedbackItemsByCondiction(infoFeedbackId, userId);
	}
	@Override
	public InfoFeedback getInfoFeedback(Long id) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.getInfoFeedback(id);
	}
	@Override
	public InfoFeedback saveOrUpdateInfoFeedback(InfoFeedback infoFeedback) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.saveOrUpdateInfoFeedback(infoFeedback);
	}
	@Override
	public InfoFeedbackItem saveOrUpdateInfoFeedbackItem(
			InfoFeedbackItem iFeedbackItem) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.saveOrUpdateInfoFeedbackItem(iFeedbackItem);
	}
	@Override
	public List<InfoFeedback> findInfoFeedbacks(String hql,
			Map<String, Object> paraMap, int first, int pagesize) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findInfoFeedbacks(hql, paraMap, first, pagesize);
	}
	@Override
	public List<String> findAlreadyAssignWork(Long infoFeedbackId) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findAlreadyAssignWork(infoFeedbackId);
	}
	@Override
	public List<String> findWaitToDoWort(Long infoFeedbackId, String userId) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findWaitToDoWort(infoFeedbackId, userId);
	}
	@Override
	public List<InfoFeedBackItemAndUserVO> findInfoFeedBackItemAndUserVO(
			Long infoFeedbackId) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findInfoFeedBackItemAndUserVO(infoFeedbackId);
	}
	@Override
	public List<InfoFeedback> findInfoFeedBackByCondition(Long userId,String feedDepement,
			String commonName, String startDate, String endDate, int first,
			int pagesize) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findInfoFeedBackByCondition(userId, feedDepement, commonName, startDate, endDate, first, pagesize);
	}
	@Override
	public int countInfoFeedBackByCondition(Long userId,String feedDepement,
			String commonName, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.countInfoFeedBackByCondition(userId, feedDepement, commonName, startDate, endDate);
	}
	@Override
	public List<String> findBackId(String sql) {
		// TODO Auto-generated method stub
		return infoFeedbackDao.findBackId(sql);
	}
	
}
