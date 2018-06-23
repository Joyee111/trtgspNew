package com.sinosoft.drugState.returnRecords.service;

import java.util.List;

import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteVO;

public interface ReturnRecordsMng {

	/**
	 * @param re 查询参数
	 * @param i 查询参数
	 * @param pagesize 查询参数
	 * @return 符合条件的ReturnReceivingNote对象集合
	 */
	List<ReturnReceivingNote> getPage(ReturnReceivingNote re, int i, int pagesize);

	/**
	 * @param re 查询参数
	 * @return 符合条件的对象数量
	 */
	int getTotalCount(ReturnReceivingNote re);

	/**
	 * 根据ID查询根据ID查询对象
	 * @param id 查询参数ID
	 * @return  ReturnReceivingNote对象
	 */
	ReturnReceivingNote findById(String id);

	/**
	 * 根据收货单ID查询收货单明细
	 * @param id 收货单ID
	 * @return 收货明细对象集合
	 */
	List<ReturnReceivingNoteItem> findYp(Long id);

	/**
	 * @param re 保存对象
	 * @return 已经保存的对象
	 */
	ReturnReceivingNote saveReceivingNote(ReturnReceivingNote re);

	/**
	 * @param id 删除对象的id
	 */
	void del(String id);

	/**
	 * @param s 查询参数收货单的id 
	 * @return 所有收货单明细ID集合
	 */
	List<?> findAllId(String s);

	/**
	 * @param saleNumber 根据ID查询所有OutboundCheckBill对象
	 * @return OutboundCheckBill对象集合
	 */
	List<OutboundCheckBill> findItemById(String saleNumber);

	/**
	 * @param id查询参数
	 * @return 根据出库复核ID查询出库复核明细对象集合
	 */
	List<OutboundCheckItem> findOutItem(Long id);
	
	List<OutboundCheckBill> findOutboundCheckBill(String salesItemId);
	List<ReturnReceivingNoteVO> findReturnReceivingNoteByCondiction(String date,String customerName,String status, String xiaoshoudanhao,String tuihuodanhao,String isfood,int first,int pagesize);
	int countReturnReceivingNoteByCondiction(String date,String customerName,String status,String xiaoshoudanhao,String tuihuodanhao,String isfood);
	
	/**
	 * 取退货药品的数量
	 * @param oci
	 * @return
	 */
	Integer getSumQuantity(String saleNumber,String batchNo,String qualifiedMedicineId);
	
	
	
}
