package com.sinosoft.drugState.inspectionRecords.dao;

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

public interface InspectionDao {

	List<ReveivingNoteVO> getPage(String date,String customerName, String checkResult,String isfood, int pageSize, int resultSize);

	int getTotalCount(String date ,String customerName, String checkConclusion,String isfood);

	ReceivingNote findById(String id);

	ReceivingNote saveOrUpdata(ReceivingNote re);

	ReceivingNote saveReceivingNote(ReceivingNote re);

	void del(String ids);

	Map<String, String> qmMap();

	QualityMidicine findYpById(String quamap);

	void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem);

	List<ReceivingNoteItem> findYp(Long id);

	List<?> findAllId(String id);

	Map<String, String> gonghuoMap();

	Map<String, String> gouhuoMap();

	QualityMidicine findHGYP(Long qualifiedMedicineId);

	PurchaseOrder findCGDById(String caigoudan);

	ReceivingNote findByNumber(String shouhuodan);

	QualifiedSuppliers findGYSById(Long qualifiedSupplierId);

	QualifiedPurchaseUnits findGHSById(Long qualifiedPurchaseUnitId);

	List<PurchaseOrder> findcgdJson();

	Map<String, String> qmMaps();

	List<ReceivingNote> findshdJson();

	List<QualityMidicine> findypJsonqy();

	List<QualityMidicine> findypJsonty();

	List<QualifiedPurchaseUnits> findList(String hql);

	DrugMaintenance findDrByNumber(String batchProduction);

	List<PurchaseOrderItem> findcgdITJson();

	List<ReceivingNoteItem> findshdItemJson();

	List<ReceivingNoteItem> findYpItemBy(String id);
	
	public MedicinePrice getMedicinePriceByNumber(String medic_no);
	/**
	 * 根据经营公司ID查询所有正在销售的药品
	 * @param departId
	 * @return
	 */
	public List<QualityMidicine> findMedicJsonByDepaetId(String departId);
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
	
	
	
	List<ReveivingNoteVO> getPageIsNotJh(String date,String customerName, String checkResult,String isfood, int pageSize, int resultSize);
	int getTotalCountIsNotJh(String date ,String customerName, String checkConclusion,String isfood);
	
}
