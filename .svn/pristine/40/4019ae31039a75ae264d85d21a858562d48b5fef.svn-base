package com.sinosoft.drugState.inspectionRecords.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.inspectionRecords.dao.InspectionDao;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrder;
import com.sinosoft.drugState.inspectionRecords.model.PurchaseOrderItem;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNote;
import com.sinosoft.drugState.inspectionRecords.model.ReceivingNoteItem;
import com.sinosoft.drugState.inspectionRecords.model.ReveivingNoteVO;
import com.sinosoft.drugState.inspectionRecords.model.TicketSamples;
import com.sinosoft.drugState.inspectionRecords.service.InspectionMng;
import com.sinosoft.drugState.price.MedicinePrice;
import com.sinosoft.drugState.purchaseNote.dao.PurchaseNoteItemDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;

@Service
public class InspectionMngImpl implements InspectionMng{
	
	@Autowired
	private InspectionDao inspectionDao;
	@Autowired
	private PurchaseNoteItemDao purchaseNoteItemDao;

	public void setInspectionDao(InspectionDao inspectionDao) {
		this.inspectionDao = inspectionDao;
	}


	@Override
	public List<ReveivingNoteVO> getPage(String date,String customerName,String checkResult,String isfood, int pageSize,
			int resultSize) {
	
		return inspectionDao.getPage(date, customerName, checkResult,isfood, pageSize,resultSize);
	}


	@Override
	public int getTotalCount(String date,String customerName, String checkConclusion,String isfood) {
		
		return inspectionDao.getTotalCount(date,customerName,checkConclusion,isfood);
	}


	@Override
	public ReceivingNote findById(String id) {
		return inspectionDao.findById(id);
	}


	@Override
	public ReceivingNote saveOrUpdata(ReceivingNote re) {
		return inspectionDao.saveOrUpdata(re);
	}


	@Override
	public ReceivingNote saveReceivingNote(ReceivingNote re) {
		return inspectionDao.saveReceivingNote(re);
	}


	@Override
	public void del(String[] ids) {
		if(ids!=null && !"".equals(ids)){
			for(int i = 0;i<ids.length;i++){
				inspectionDao.del(ids[i]);
			}
		}
		
	}


	@Override
	public Map<String,String> qmMap() {
		return inspectionDao.qmMap();
	}


	@Override
	public QualityMidicine findYpById(String quamap) {
		return inspectionDao.findYpById(quamap);
	}


	@Override
	public void saveReceivingNoteItem(ReceivingNoteItem receivingNoteItem) {
		inspectionDao.saveReceivingNoteItem(receivingNoteItem);
	}


	@Override
	public List<ReceivingNoteItem> findYp(Long id) {
		return inspectionDao.findYp(id);
	}


	@Override
	public List<?> findAllId(String id) {
		return inspectionDao.findAllId(id);
	}


	@Override
	public Map<String, String> gonghuoMap() {
		return inspectionDao.gonghuoMap();
	}


	@Override
	public Map<String, String> gouhuoMap() {
		return inspectionDao.gouhuoMap();
	}


	@Override
	public QualityMidicine findHGYP(Long qualifiedMedicineId) {
		return inspectionDao.findHGYP(qualifiedMedicineId);
	}


	@Override
	public PurchaseOrder findCGDById(String caigoudan) {
		return  inspectionDao.findCGDById(caigoudan);
	}


	@Override
	public ReceivingNote findByNumber(String shouhuodan) {
		return inspectionDao.findByNumber(shouhuodan);
	}


	@Override
	public QualifiedSuppliers findGYSById(Long qualifiedSupplierId) {
		return inspectionDao.findGYSById(qualifiedSupplierId);
	}


	@Override
	public QualifiedPurchaseUnits findGHSById(Long QualifiedPurchaseUnitId) {
		return inspectionDao.findGHSById(QualifiedPurchaseUnitId);
	}


	@Override
	public List<PurchaseOrder> findcgdJson() {
		return inspectionDao.findcgdJson();
	}

	/**
	 * 閲囪喘鍗昪omboxox
	 */
	@Override
	public Map<String, String> qmMaps() {
		return inspectionDao.qmMaps();
	}

	/**
	 * 鏀惰揣鍗昪omboxox
	 */
	@Override
	public List<ReceivingNote> findshdJson() {
		return inspectionDao.findshdJson();
	}

	/**
	 * 鍚姩鑽搧comboxox
	 */
	@Override
	public List<QualityMidicine> findypJsonqy() {
		return inspectionDao.findypJsonqy();
	}
	
	/**
	 * 鍋滅敤鑽搧comboxox
	 */
	@Override
	public List<QualityMidicine> findypJsonty() {
		return inspectionDao.findypJsonty();
	}


	@Override
	public List<QualifiedPurchaseUnits> findList(String hql) {
		return inspectionDao.findList(hql);
	}


	@Override
	public DrugMaintenance findDrByNumber(String batchProduction) {
		return inspectionDao.findDrByNumber(batchProduction);
	}


	@Override
	public List<PurchaseOrderItem> findcgdITJson() {
		return inspectionDao.findcgdITJson();
	}


	@Override
	public PurchaseOrderItem findcgdmxById(String caigoudan) {
		return purchaseNoteItemDao.findById(caigoudan);
	}


	@Override
	public List<ReceivingNoteItem> findshdItemJson() {
		return inspectionDao.findshdItemJson();
	}


	@Override
	public List<ReceivingNoteItem> findYpItemBy(String id) {
		return inspectionDao.findYpItemBy(id);
	}


	@Override
	public MedicinePrice getMedicPriceByNumber(String medicNo) {
		// TODO Auto-generated method stub
		return inspectionDao.getMedicinePriceByNumber(medicNo);
	}


	@Override
	public List<QualityMidicine> findMedicJsonByDepaetId(String departId) {
		// TODO Auto-generated method stub
		return inspectionDao.findMedicJsonByDepaetId(departId);
	}


	@Override
	public TicketSamples getTicketSamplesByName(String ticketSamplesName) {
		// TODO Auto-generated method stub
		return inspectionDao.getTicketSamplesByName(ticketSamplesName);
	}


	@Override
	public void saveOrUpdateTicketSamples(TicketSamples ticketSamples) {
		inspectionDao.saveOrUpdateTicketSamples(ticketSamples);
		
	}


	
	@Override
	public List<ReveivingNoteVO> getPageIsNotJh(String date,String customerName,String checkResult,String isfood, int pageSize,
			int resultSize) {
	
		return inspectionDao.getPageIsNotJh(date, customerName, checkResult,isfood, pageSize,resultSize);
	}
	
	@Override
	public int getTotalCountIsNotJh(String date,String customerName, String checkConclusion,String isfood) {
		
		return inspectionDao.getTotalCountIsNotJh(date,customerName,checkConclusion,isfood);
	}
	
}
