package com.sinosoft.drugState.purchaseNote.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItemVO;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderVO;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseNoteDao;
import com.sinosoft.drugState.purchaseNote.service.PurchaseNoteMng;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

@Service
public class PurchaseNoteMngImpl implements PurchaseNoteMng{
	
	@Autowired
	private PurchaseNoteDao purchaseNotedao;
	
	@Override
	public List<PurchaseOrder> getPage(PurchaseOrder re, int i, int pagesize) {
		return purchaseNotedao.getPage(re,i,pagesize);
	}

	@Override
	public int getTotalCount(PurchaseOrder re) {
		return purchaseNotedao.getTotalCount(re);
	}

	@Override
	public PurchaseOrder findById(String id) {
		return purchaseNotedao.findById(id);
	}

	@Override
	public List<PurchaseOrderItem> findYp(Long id) {
		return purchaseNotedao.findYp(id);
	}

	@Override
	public PurchaseOrder saveReceivingNote(PurchaseOrder re) {
		return purchaseNotedao.saveReceivingNote(re);
	}
	@Override
	public void saveOrUpdateNote(PurchaseOrder re) {
		purchaseNotedao.saveOrUpdateNote(re);
	}
	
	@Override
	public void del(String id) {
		purchaseNotedao.del(id);
	}

	@Override
	public List<?> findAllId(String s) {
		return purchaseNotedao.findAllId(s);
	}

	@Override
	public QualifiedSuppliers findByIdSy(String purchaseNoteMng) {
		return purchaseNotedao.findByIdSy(purchaseNoteMng);
	}

	@Override
	public List<PurchaseOrderItem> findYPBybn(String id) {
		return purchaseNotedao.findYPBybn(id);
	}

	@Override
	public List<Map<String, Object>> findPurchaseOrderByBathcNumer(
			String batchNumber) {
		// TODO Auto-generated method stub
		return purchaseNotedao.findPurchaseOrderByBathcNumer(batchNumber);
	}

	@Override
	public List<Map<String, Object>> findOpeatorNameByBatchNumber(
			String batchNumber) {
		// TODO Auto-generated method stub
		return purchaseNotedao.findOpeatorNameByBatchNumber(batchNumber);
	}

	@Override
	public List<PurchaseOrderVO> findPurchaseOrderVOByCondition(
			String commonName, String batchNumber, int first, int pagesize) {
		
		return purchaseNotedao.findPurchaseOrderVOByCondition(commonName, batchNumber, first, pagesize);
	}

	@Override
	public int countPurchaseOrderVOByCondition(String commoName,
			String batchNumber) {
		// TODO Auto-generated method stub
		return purchaseNotedao.countPurchaseOrderVOByCondition(commoName, batchNumber);
	}

	@Override
	public int countPurchaseOrderVOByStatusNew(String commonName,
			String orderNumber, String modityDate, String department, String isfood,String status) {
		// TODO Auto-generated method stub
		return purchaseNotedao.countPurchaseOrderVOByStatusNew(commonName, orderNumber,modityDate,department,isfood,status);
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByStatusNew(String commonName,
			String orderNumber, String modityDate,String department, String isfood,String status, int first, int pagesize) {
		// TODO Auto-generated method stub
		return purchaseNotedao.findPurchseOrderVOByStatusNew(commonName, orderNumber,modityDate,department,isfood, status, first, pagesize);
	}

	@Override
	public List<PurchaseOrderItemVO> findPurchaseOrderItemVOByOrderId(
			Long orderId) {
		// TODO Auto-generated method stub
		return purchaseNotedao.findPurchaseOrderItemVOByOrderId(orderId);
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByStatus(String commonName,
			String orderNumber, String modityDate, String department,String isfood, String useFlag,
			String status, int first, int pagesize) {
		// TODO Auto-generated method stub
		return purchaseNotedao.findPurchseOrderVOByStatus(commonName, orderNumber,modityDate, department, isfood,useFlag, status, first, pagesize);
	}

	@Override
	public int countPurchaseOrderVOByStatus(String commonName,
			String orderNumber, String modityDate, String department,String isfood, String useFlag, String status) {
		// TODO Auto-generated method stub
		return purchaseNotedao.countPurchaseOrderVOByStatus(commonName,orderNumber,modityDate, department,isfood, useFlag, status);
	}

	@Override
	public boolean isAlreadyReceiving(Long orderId) {
		// TODO Auto-generated method stub
		return purchaseNotedao.isAlreadyReceiving(orderId);
	}

	@Override
	public int countQuant(String batchNumber) {
		
		return purchaseNotedao.countQuant(batchNumber);
	}

	@Override
	public List<Map<String, Object>> findOpeatorNameJHByBatchNumber(
			String batchNumber) {
		return purchaseNotedao.findOpeatorNameJHByBatchNumber(batchNumber);
	}

	@Override
	public List<Map<String, Object>> findPurchaseOrderJHByBathcNumer(
			String batchNumber) {
		return purchaseNotedao.findPurchaseOrderJHByBathcNumer(batchNumber);
	}

	@Override
	public int countPurchaseOrderVOByUseflag(String commonName,
			String orderNumber,String modityDate, String department) {
		return purchaseNotedao.countPurchaseOrderVOByUseflag(commonName, orderNumber,modityDate, department);
	}

	@Override
	public List<PurchaseOrderVO> findPurchseOrderVOByUseflag(String commonName,
			String orderNumber,String modityDate, String department, int first, int pagesize) {
		return purchaseNotedao.findPurchseOrderVOByUseflag(commonName, orderNumber,modityDate, department, first, pagesize);
	}
	
	
	public List<Map<String,Object>> findMedcAllowBuyQuantity(final List<Integer> medcList,final List<Integer> itemList,final String dpId,final String year) throws Exception{
		String queryMedcQuantitySql = " SELECT "
				+"     O.department_id,O.year,I.qualified_medicine_id,( "
				+"     SUM(CAST(I.quantity AS NUMERIC(19, 2))) * 10000 - (SELECT "
				+"                                                         ISNULL(SUM(CAST(I1.quantity AS NUMERIC(19, 2))),0) * 10000 "
				+"                                                        FROM "
				+"                                                         dbo.t_purchase_plan_order O1 "
				+"                                                         LEFT JOIN t_purchase_plan_item I1 ON O1.id = I1.purchasePlan_id "
				+"                                                        WHERE "
				+"                                                         O1.department_id = O.department_id "
				+"                                                         AND O1.year = O.year "
				+"                                                         AND I1.qualified_medicine_id = I.qualified_medicine_id "
				+"                                                         AND I1.plan_type = '3' "
				+"                                                       )) maxBuyQuantity "
				+"     ,ISNULL((select SUM(POI.quantity) from t_purchase_order PO LEFT JOIN t_purchase_order_item POI ON PO.department_id = O.department_id AND POI.purchase_order_id = PO.id AND POI.qualified_medicine_id = I.qualified_medicine_id AND year(PO.modify_date) = O.year WHERE 1=1"
				+"     ),0) buyQuantity";//包含预购买的数量
				if(itemList != null && itemList.size() > 0){
					queryMedcQuantitySql += "     ,ISNULL((select SUM(POI.quantity) from t_purchase_order PO LEFT JOIN t_purchase_order_item POI ON PO.department_id = O.department_id AND POI.purchase_order_id = PO.id AND POI.qualified_medicine_id = I.qualified_medicine_id AND year(PO.modify_date) = O.year WHERE 1=1 "
											+"     AND POI.id in (:itemIds) "
											+"     ),0) thatQuantity ";//本次明细的数量
				}else{
					queryMedcQuantitySql += " ,thatQuantity=0 ";//本次明细的数量
				}
				queryMedcQuantitySql += " FROM "
				+"     dbo.t_purchase_plan_order O "
				+"     LEFT JOIN t_purchase_plan_item I ON O.id = I.purchasePlan_id "
				+" WHERE "
				+"     1 = 1 "
				+"     AND O.department_id = :dpId "
				+"     AND O.year = :year "
				+"     AND I.qualified_medicine_id in (:medcIds) "
				+"     AND I.plan_type IN ('1', '2') "
				+" GROUP BY O.department_id,O.year,I.qualified_medicine_id ";
		
		return purchaseNotedao.findAllBySql(queryMedcQuantitySql, new HashMap(){{
			put("dpId", dpId);
			put("medcIds", medcList);
			put("year", year);
			put("itemIds", itemList);
		}});
	}
	
}
