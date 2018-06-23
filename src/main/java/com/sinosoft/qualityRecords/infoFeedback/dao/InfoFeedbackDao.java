package com.sinosoft.qualityRecords.infoFeedback.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedBackItemAndUserVO;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedback;
import com.sinosoft.qualityRecords.infoFeedback.model.InfoFeedbackItem;
public interface InfoFeedbackDao  {
		
	/**
	 * 根据userId 查询该用户的信息反馈代办事项
	 * @param userId
	 * @return
	 */
	public int countFeedbackWaitingToDo(Long userId);
	/**
	 * 保存信息反馈信息
	 * @param infoFeedback
	 * @return
	 */
	public InfoFeedback saveOrUpdateInfoFeedback(InfoFeedback infoFeedback);
	/**
	 * 保存指派信息
	 * @param iFeedbackItem
	 * @return
	 */
	public InfoFeedbackItem saveOrUpdateInfoFeedbackItem(InfoFeedbackItem iFeedbackItem);
	/**
	 * 根据信息反馈ID和指派人查询反馈信息情况
	 * @param infoFeedbackId
	 * @param userId
	 * @return
	 */
	public List<InfoFeedbackItem> findInfoFeedbackItemsByCondiction(Long infoFeedbackId ,String userId);
	/**
	 * 根据ID查询信息反馈信息
	 * @param id
	 * @return
	 */
	public InfoFeedback getInfoFeedback(Long id );
	/**
	 * 统计信息反馈数量
	 * @param hql
	 * @return
	 */
	public int countInfoFeedbacks(String hql,Map<String, Object> paraMap);
	/**
	 * 根据ID删除信息反馈
	 * @param id
	 */
	public void deleteInfoFeedbacks(Long id );
	/**
	 * 查询信息反馈信息
	 * @param hql
	 * @param paraMap
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<InfoFeedback> findInfoFeedbacks(String hql, Map<String, Object> paraMap, int first, int pagesize);
	
	
	/**
	 * 查看已经指派的工作
	 * @param infoFeedbackId
	 * @return
	 */
	public List<String> findAlreadyAssignWork(Long infoFeedbackId);
	/**
	 * 查看待做工作
	 * @param infoFeedbackId
	 * @param userId
	 * @return
	 */
	public List<String> findWaitToDoWort(Long infoFeedbackId,String userId);
	
	public List<InfoFeedBackItemAndUserVO> findInfoFeedBackItemAndUserVO(Long infoFeedbackId);
	
	public List<InfoFeedback> findInfoFeedBackByCondition(Long userId,String feedDepement, String commonName, String startDate, String endDate, int first, int pagesize);
	public int  countInfoFeedBackByCondition(Long userId,String feedDepement, String commonName, String startDate, String endDate);
	

	/**
	 * 获取完成或未完成的质量查询记录的id
	 * @param sql
	 * @return
	 */
	public List<String> findBackId(String sql);
}
