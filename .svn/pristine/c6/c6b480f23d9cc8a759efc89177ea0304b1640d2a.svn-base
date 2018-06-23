package com.sinosoft.drugState.outcheck.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfoVO;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;
import com.sinosoft.varietyManger.firstVarietyManger.model.TrtssSalesFormMidicineVO;


public interface OutCheckDao {
	List<OutboundCheckBill> getPage(OutboundCheckBill mc, int i, int pagesize);

	int getTotalCount();

	OutboundCheckBill save(OutboundCheckBill mc);

	OutboundCheckBill findById(String id);

	void update(OutboundCheckBill mc);

	List<OutboundCheckBill> getPagedsh(OutboundCheckBill mc, int i, int pagesize);

	int getTotalCountdsh();

	List<OutboundCheckItem> find(String id);

	List<OutboundCheckBill> getPageysh(OutboundCheckBill mc, int i, int pagesize);

	int getTotalCountysh();

	int getTotalCountybh();

	List<OutboundCheckBill> getPageybh(OutboundCheckBill mc, int i, int pagesize);

	void audit(String id);

	List<OutboundCheckItem> findYp(Long id);

	List<?> findAllId(Long id);

	List<OutboundCheckItem> find(Long id, int i, int pagesize);

	int findCount(Long id);

	void del(String id);

	List<TrtssSalesFormInfo> findxsJson();

	List<TrtssSalesItemsInfo> findxsItem(String id);

	TrtssSalesFormInfo findxsBy(String salesNumber);

	TrtssSalesFormInfo findTFById(String id);

	TrtssSalesFormInfo findxsById(String salesNumber);

	List<TrtssSalesFormInfo> findSaleNo(String contractNumber, String saleNumber, int i, int pagesize);

	int getTotalCountSaleNodlr(String contractNumber, String saleNumber);
	List<OutboundCheckBill> getAllByState(String hql ,Map map);
	/**
	 * 查询销售明细单号
	 * @return
	 */
	public List<String[]> findSaleDetailNO(String requestName);
	/**
	 * 查询退货收获销售明细单号
	 * @return
	 */
	public List<?> findRetturnRecordSaleDetailNO(String requestName);
	/**
	 * 根据销售明细单号查询销售单
	 * @param id
	 * @return
	 */
	public TrtssSalesFormInfo findSalesFromInfoBySalesItemId(String id);
	
	List<OutboundCheckBillVO> findOutboundCheckBillByStatus(String statuas,int first,int pagesize);
	int countOutboundCheckBillByStatus(String status);
	List<TrtssSalesFormInfoVO> findSalesFromInfoVO(String salesNumber,String contractNumber,int first,int pagesize);
	int countSalesFromInfoVO(String salesNumber,String contractNumber); 
}
