package com.sinosoft.drugState.purchaseNote.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

public interface PurchaseNoteMng {

	/**
	 * @param re 查询参数
	 * @param i
	 * @param pagesize
	 * @return 
	 */
	List<PurchaseOrder> getPage(PurchaseOrder re, int i, int pagesize);

	/**
	 * @param re
	 * @return 符合条件的条数
	 */
	int getTotalCount(PurchaseOrder re);

	/**
	 * 根据ID查询PurchaseOrder对象
	 * @param id 查询参数
	 * @return PurchaseOrder对象
	 */
	PurchaseOrder findById(String id);

	/**
	 * 根据ID查询所有明细
	 * @param id 查询参数
	 * @return PurchaseOrderItem对象集合
	 */
	List<PurchaseOrderItem> findYp(Long id);

	/**
	 * @param re
	 * @return 保存对象
	 */
	PurchaseOrder saveReceivingNote(PurchaseOrder re);
	/**
	 * 更新主单
	 * @param re
	 */
	void saveOrUpdateNote(PurchaseOrder re);

	/**
	 * @param id 删除的ID
	 */
	void del(String id);

	/**
	 * @param s 删除ID的集合
	 * @return
	 */
	List<?> findAllId(String s);

	/**
	 * 根据ID查询合格供应商
	 * @param qualifiedSupplierIdValue 查询参数
	 * @return QualifiedSuppliers对象
	 */
	QualifiedSuppliers findByIdSy(String qualifiedSupplierIdValue);

	/**
	 * 根据生产批号查询PurchaseOrderItem对象集合
	 * @param id 生产批号
	 * @return PurchaseOrderItem对象集合
	 */
	List<PurchaseOrderItem> findYPBybn(String id);
	
	/**
	 * @param batchNumber 生产批号
	 * @return
	 */
	public List<Map<String, Object>> findPurchaseOrderByBathcNumer(
			String batchNumber);
	
	//以下两个方法用于获取嘉和药品入库单数据
	List<Map<String, Object>> findPurchaseOrderJHByBathcNumer(
			String batchNumber);
	List<Map<String, Object>> findOpeatorNameJHByBatchNumber(String batchNumber);
	
	
	 /**
	 * @param batchNumber
	 * @return
	 */
	List<Map<String, Object>> findOpeatorNameByBatchNumber(
				String batchNumber);
	List<PurchaseOrderVO> findPurchaseOrderVOByCondition(String commonName,String batchNumber,int first,int pagesize);
	
	int countPurchaseOrderVOByCondition(String commoName,String batchNumber);
	/**
	 * 根据通用名称、批号和状态模糊查询 VO
	 * @param commonName
	 * @param batchNumber
	 * @param status
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<PurchaseOrderVO> findPurchseOrderVOByStatusNew(String commonName,  String orderNumber, String modityDate,String department,String isfood, String status, int first, int pagesize);
	/**
	 * 根据通用名称、批号和状态统计VO
	 * @param commonName
	 * @param batchNumber
	 * @param status
	 * @return
	 */
	public int countPurchaseOrderVOByStatusNew(String commonName, String orderNumber, String modityDate, String department, String isfood,String status);
	/**
	 * 根据订单号查询订单
	 * @param orderId
	 * @return
	 */
	public List<PurchaseOrderItemVO> findPurchaseOrderItemVOByOrderId(Long orderId);
	
	public List<PurchaseOrderVO> findPurchseOrderVOByStatus(String commonName,  String orderNumber, String modityDate,String department,String isfood,String useFlag, String status, int first, int pagesize);
	public int countPurchaseOrderVOByStatus(String commonName, String orderNumber, String modityDate, String department,String isfood,String useFlag, String status);
	/**
	 * 判断是否收货
	 * @param orderId
	 * @return
	 */
	public boolean isAlreadyReceiving(Long orderId );
	
	/**
	 * 根据批号查询此批号在采购订单中的药品数量之和
	 * @param batchNUmber
	 * @return
	 */
	public int countQuant(String batchNUmber);
	
	/**
	 * 根据通用名称、批号和经营公司分页查询已作废的采购单
	 * @param commonName
	 * @param batchNumber
	 * @param department
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<PurchaseOrderVO> findPurchseOrderVOByUseflag(String commonName, String orderNumber,String modityDate,String department, int first, int pagesize);
	/**
	 * 根据通用名称、批号和经营公司统计已作废的采购单
	 * @param commonName
	 * @param batchNumber
	 * @param department
	 * @return
	 */
	public int countPurchaseOrderVOByUseflag(String commonName, String orderNumber,String modityDate, String department);
	
	
	/**
	 * 查找采购计划药品最大允许创建数量
	 * @param medcList
	 * @param dpId
	 * @param year
	 * @return
	 */
	public List<Map<String,Object>> findMedcAllowBuyQuantity(List<Integer> medcList,List<Integer> itemList,String dpId,String year) throws Exception;

}
