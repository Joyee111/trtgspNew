package com.sinosoft.qualityRecords.transportRecords.serivice;

import java.util.List;
import java.util.Map;

import com.sinosoft.enterpriseManage.firstEnterprise.model.TransporterQualification;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecords;
import com.sinosoft.qualityRecords.transportRecords.model.TransportRecordsResource;
import com.sinosoft.user.User;

public interface TransportRecordsMng {

	List<TransportRecords> getPage(TransportRecords tr, int i, int pagesize2);

	int getTotalCount();
	TransportRecords findById(String id);

	void saveOrUpdata(TransportRecords tr);


	void saveTransportRecords(TransportRecords tr);

	void del(String[] ids);

	/**
	 * 
	 * @param hql 查询语句
	 * @param map 查询条件
	 * @param first
	 * @param pagesize 页面大小
	 * @return
	 */
	public List<TransportRecords> getTransportRecordsByPage(String hql ,Map map , int first ,int pagesize);
	
	int getQueryCount(String hql);

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
	 * 查询所有记录用于导出Excel
	 * @param hql
	 * @param paramMap
	 * @return
	 */
	public List<TransportRecords> getAllTransportRecords(String hql,Map<String, Object> paramMap);
}
