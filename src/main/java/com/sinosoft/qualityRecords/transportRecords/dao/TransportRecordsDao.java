package com.sinosoft.qualityRecords.transportRecords.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecords;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecordsResource;
import com.sinosoft.user.User;

public interface TransportRecordsDao {

	/**
	 * 设备运行列表
	 * @param eo
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
    List<TransportRecords> getPage(TransportRecords tr, int pageSize, int resultSize, String string);
 /**
  * 设备运行类表条数
  * @param string
  * @return
  */
	int getTotalCount(String string);
	/**
	 * 根据iｄ得到ｍｏｄｅｌ　
	 * @param id
	 * @return
	 */
	TransportRecords findById(String id);
	/**
	 * 修改保存
	 * @param eo
	 */

	void saveOrUpdata(TransportRecords tr);
/**
 * 添加保存
 * @param eo
 */
	void saveTransportRecords(TransportRecords tr);
/**
 * 删除
 * @param ids
 */
	void del(String ids);

	/**
	 * 根据HQL查询条件分页显示首营企业列表
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TransportRecords> getTransportRecordsByPage(String hql,Map map ,int first, int pageseiz);
	/**
	 * 根据HQL查询条件分页显示首营企业列表条数
	 * @param hql
	 * @param map
	 * @param first
	 * @param pageseiz
	 * @return
	 */
	int getQueryCount(String hql);
/*
 * 承运单位
 */
	Map<String, String> qsMap();
	/**
	 * 根据货单号查询得到model
	 * @param no
	 * @return
	 */
	public TransportRecordsResource findByOrderno(String no);
	/**
	 * 根据id 找用户
	 * @param no
	 * @return
	 */
	public User findByUserId(String id);
	/**
	 * 根据id 找承运单位
	 * @param id
	 * @return
	 */
	public TransporterQualification findByCarrierunit(String id);
	public List<TransportRecordsResource> findtrJsonty();
	/**
	 * 根据货id查询得到model
	 * @param no
	 * @return
	 */
	public TransportRecordsResource findByIds(String id);
	/**
	 * 根据HQL语句查询所有运输记录用于导出Excel
	 * @param hql
	 * @param paramMap
	 * @return
	 */
	public List<TransportRecords> getAllTransportRecords(String hql,Map<String, Object> paramMap);
}
