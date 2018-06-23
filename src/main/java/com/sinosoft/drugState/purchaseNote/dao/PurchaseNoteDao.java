package com.sinosoft.drugState.purchaseNote.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

public interface PurchaseNoteDao {
	int getTotalCount(PurchaseOrder re);

	List<PurchaseOrder> getPage(PurchaseOrder re, int i,
			int pagesize);

	PurchaseOrder findById(String id);

	List<PurchaseOrderItem> findYp(Long id);

	PurchaseOrder saveReceivingNote(PurchaseOrder re);
	
	void saveOrUpdateNote(PurchaseOrder re);

	void del(String id);

	List<?> findAllId(String s);

	QualifiedSuppliers findByIdSy(String purchaseNoteMng);

	List<PurchaseOrderItem> findYPBybn(String id);
	List<Map<String, Object>> findPurchaseOrderByBathcNumer(String batchNumber);
	List<Map<String, Object>> findOpeatorNameByBatchNumber(String batchNumber);
	
	List<Map<String, Object>> findPurchaseOrderJHByBathcNumer(String batchNumber);
	List<Map<String, Object>> findOpeatorNameJHByBatchNumber(String batchNumber);
	
	List<PurchaseOrderVO> findPurchaseOrderVOByCondition(String commonName,String batchNumber,int first,int pagesize);
	int countPurchaseOrderVOByCondition(String commoName,String batchNumber);
	/**
	 * 根据通用名称、批号和状态分页查询采购单
	 * @param commonName
	 * @param batchNumber
	 * @param status
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<PurchaseOrderVO> findPurchseOrderVOByStatusNew(String commonName, String orderNumber, String modityDate,String department, String isfood,String status, int first, int pagesize);
	/**
	 * 根据通用名称、批号和状态统计采购单
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
	public List<PurchaseOrderVO> findPurchseOrderVOByStatus(String commonName, String orderNumber, String modityDate,String department,String isfood,String useFlag, String status, int first, int pagesize);
	public int countPurchaseOrderVOByStatus(String commonName, String orderNumber, String modityDate, String department,String isfood,String useFlag, String status);
	
	/**
	 * 判断是否收货
	 * @param orderId
	 * @return
	 */
	public boolean isAlreadyReceiving(Long orderId );
	
	/**
	 * 根据批号查询此批号在采购订单中的药品数量之和
	 * @param batch
	 * @return
	 */
	public int countQuant(String batchNumber);
	
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
	 * 根据SQL查询数据
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> findAllBySql(String sql,Map<String,Object> params) throws Exception;




}
