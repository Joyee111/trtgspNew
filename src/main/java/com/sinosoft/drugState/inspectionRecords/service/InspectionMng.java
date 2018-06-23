package com.sinosoft.drugState.inspectionRecords.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO;
import com.sinosoft.drugState.inspectionRecords.model.TicketSamples;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

/**
 * @author Administrator
 *
 */
public interface InspectionMng {

	/**
	 * @param re 查询参数
	 * @param i 开始数据位置
	 * @param pagesize2  显示数据条数
	 * @return  ReceivingNote集合
	 */
	List<ReveivingNoteVO> getPage(String date,String coustomerName,String checkResult,String isfood, int i, int pagesize2);

	/**
	 * @param re 查询参数
	 * @return 总条数
	 */
	int getTotalCount(String date,String customerName, String checkConclusion,String isfood);

	/**
	 * @param id 查询参数 ID
	 * @return ReceivingNote对象
	 */
	ReceivingNote findById(String id);

	/**
	 * @param re  保存对象
	 * @return  已保存的对象
	 */
	ReceivingNote saveOrUpdata(ReceivingNote re);


	/**
	 * @param re 更新对象
	 * @return  更新对象
	 */
	ReceivingNote saveReceivingNote(ReceivingNote re);

	/**
	 * @param ids  删除的IDS数组集合
	 */
	void del(String[] ids);

	/**
	 * @return 方法已经停用
	 */
	Map<String, String> qmMap();

	/**
	 * @param quamap 方法已经停用
	 * @return
	 */
	QualityMidicine findYpById(String quamap);

	/**
	 * @param receivingNoteItem 保存对象收货明细
	 */
	void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem);
	
	/**
	 * @param id  收货单ID
	 * @return 收货单明细对象集合
	 */
	List<ReceivingNoteItem> findYp(Long id);
	/**
	 * return  收货单明细ID集合
	 * **/
	List<?> findAllId(String string);
	//璐揣渚涜揣map
	/**
	 * @return 方法已停用
	 */
	Map<String, String> gonghuoMap();
	/**
	 * @return 方法已停用
	 */
	Map<String, String> gouhuoMap();
	/**
	 * 根据药品ID查找药品信息
	 * @param qualifiedMedicineId  查询参数
	 * @return QualityMidicine对象
	 */
	QualityMidicine findHGYP(Long qualifiedMedicineId);
	/**
	 * 根据采购单号查询PurchaseOrder
	 * @param caigoudan 采购单号，查询参数
	 * @return
	 */
	PurchaseOrder findCGDById(String caigoudan);
	/**
	 * 根据收货单号查询ReceivingNote
	 * @param shouhuodan 查询参数
	 * @return 
	 */
	ReceivingNote findByNumber(String shouhuodan);
	/**
	 * 根据ID查询合格供应商
	 * @param qualifiedSupplierId 查询参数
	 * @return QualifiedSuppliers对象
	 */
	QualifiedSuppliers findGYSById(Long qualifiedSupplierId);
	/**
	 * 根据ID查询合格购货商
	 * @param QualifiedPurchaseUnitId 查询参数
	 * @return QualifiedPurchaseUnits对象
	 */
	QualifiedPurchaseUnits findGHSById(Long QualifiedPurchaseUnitId);
	/**
	 * @return 所有PurchaseOrder对象集合
	 */
	List<PurchaseOrder> findcgdJson();
	/**
	 * @return 方法已经停用
	 */
	Map<String, String> qmMaps();
	/**
	 * @return  返回所有ReceivingNote对象集合
	 */
	List<ReceivingNote> findshdJson();
	/** 
	 * @return QualityMidicine所有停售药品对象集合
	 */
	List<QualityMidicine> findypJsonty();
	/**
	 * @return QualityMidicine所有正在销售药品对象集合
	 */
	List<QualityMidicine> findypJsonqy();
	/**
	 * 根据经营公司ID查询所有正在销售药品对象集合
	 * @param departId
	 * @return
	 */
	List<QualityMidicine> findMedicJsonByDepaetId(String departId);
	/**
	 * @param hql 查询hql
	 * @return 返回所有QualifiedPurchaseUnits集合 
	 */
	List<QualifiedPurchaseUnits> findList(String hql);
	/** 
	 * @param batchProduction 生产编号
	 * @return DrugMaintenance
	 */
	DrugMaintenance findDrByNumber(String batchProduction);

	/**
	 * @return 采购单所有PurchaseOrderItem对象集合
	 */
	List<PurchaseOrderItem> findcgdITJson();

	/** 
	 * 根据采购单明细ID查询采购单明细 PurchaseOrderItem
	 * @param caigoudan 采购单明细ID
	 * @return PurchaseOrderItem
	 */
	PurchaseOrderItem findcgdmxById(String caigoudan);

	/**
	 * @return 返回所有收货单明细
	 */
	List<ReceivingNoteItem> findshdItemJson();

	/**
	 * @param id 生产编号查询收货单明细
	 * @return
	 */
	List<ReceivingNoteItem> findYpItemBy(String id);
	public MedicinePrice getMedicPriceByNumber(String medic_no);
	/**
	 * 查询票样
	 * @param ticketSamplesName
	 * @return
	 */
	public TicketSamples getTicketSamplesByName(String ticketSamplesName);
	/**
	 * 跟新票样
	 * @param ticketSamples
	 */
	public void saveOrUpdateTicketSamples(TicketSamples ticketSamples);
	
	
	
	/**
	 * @param re 查询参数
	 * @param i 开始数据位置
	 * @param pagesize2  显示数据条数
	 * @return  ReceivingNote集合
	 */
	List<ReveivingNoteVO> getPageIsNotJh(String date,String coustomerName,String checkResult,String isfood, int i, int pagesize2);
	
	/**
	 * @param re 查询参数
	 * @return 总条数
	 */
	int getTotalCountIsNotJh(String date,String customerName, String checkConclusion,String isfood);
	
}
