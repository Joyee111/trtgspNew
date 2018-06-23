package com.sinosoft.drugState.outcheck.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfoVO;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;

/**
 * @author Administrator
 *
 */
public interface OutCheckMng {

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return
	 */
	List<OutboundCheckBill> getPage(OutboundCheckBill mc, int i, int pagesize);

	/**
	 * @return 符合条件的条数
	 */
	int getTotalCount();

	/**
	 * @param mc 保存对象
	 * @return 保存对象
	 */
	OutboundCheckBill save(OutboundCheckBill mc);

	/**
	 * @param id 根据ID查询OutboundCheckBill
	 * @return 返回对象OutboundCheckBill
	 */
	OutboundCheckBill findById(String id);

	/**
	 * @param mc 更新对象
	 */
	void update(OutboundCheckBill mc);

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return 符合条件的OutboundCheckBill集合
	 */
	List<OutboundCheckBill> getPagedsh(OutboundCheckBill mc, int i, int pagesize);

	/**
	 * @return 返回符合条件的个数
	 */
	int getTotalCountDsh();

	/**
	 * 根据出库复核单ID查询OutboundCheckItem
	 * @param id 
	 * @return
	 */
	List<OutboundCheckItem> find(String id);

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return 符合条件的OutboundCheckBill集合
	 */
	List<OutboundCheckBill> getPageysh(OutboundCheckBill mc, int i, int pagesize);

	/**
	 * @return 符合条件条数
	 */
	int getTotalCountysh();

	/**
	 * @param mc 查询参数
	 * @param i
	 * @param pagesize
	 * @return 符合条件的OutboundCheckBill集合
	 */
	List<OutboundCheckBill> getPageybh(OutboundCheckBill mc, int i, int pagesize);

	/**
	 * @return 符合条件条数
	 */
	int getTotalCountybh();

	/**
	 * 方法停用
	 */
	void audit(String string);

	/**
	 * 根据出库ID查询出库单明细集合
	 * @param id 查询参数
	 * @return 出库单明细集合
	 */
	List<OutboundCheckItem> findYp(Long id);

	/**
	 * 根据出库ID查询出库单明细ID集合
	 * @param id 查询参数
	 * @return
	 */
	List<?> findAllId(Long id);

	/**
	 * 根据出库复核ID查询出库复核明细集合
	 * @param id 查询参数
	 * @param i
	 * @param pagesize
	 * @return  出库复核明细集合
	 */
	List<OutboundCheckItem> find(Long id, int i, int pagesize);

	/**.
	 * 根据出库复核ID查询出库复核明细条数
	 * @param id 查询参数
	 * @return 出库复核明细条数
	 */
	int findCount(Long id);

	/**
	 * @param string 删除对象的ID
	 */
	void del(String string);

	/**
	 * @return 返回所有TrtssSalesFormInfo对象集合
	 */
	List<TrtssSalesFormInfo> findxsJson();

	/**
	 * 根据销售单ID查询TrtssSalesFormInfo对象集合
	 * @param id  查询参数
	 * @return TrtssSalesFormInfo对象集合
	 */
	List<TrtssSalesItemsInfo> findxsItem(String id);

	/**
	 * 根据销售单号查询 TrtssSalesFormInfo对象
	 * @param salesNumber 销售单号
	 * @return
	 */
	TrtssSalesFormInfo findxsBy(String salesNumber);

	/**
	 * 根据销售单号查询 TrtssSalesFormInfo对象
	 * @param id 查询参数
	 * @return
	 */
	TrtssSalesFormInfo findTFById(String id);

	/**
	 * 
	 * @param salesNumber查询参数
	 * @return
	 */
	TrtssSalesFormInfo findxsById(String salesNumber);

	/**
	 * @param saleNumber 查询参数
	 * @param i 
	 * @param pagesize
	 * @return
	 */
	List<TrtssSalesFormInfo> findSaleNo(String contractNumber ,String saleNumber, int i, int pagesize);

	/**
	 * @param saleNumber
	 * @return
	 */
	int getTotalCountSaleNodlr(String contractNumber,String saleNumber);
	
	List<OutboundCheckBill> getAllByState(String hql,Map map);
	/**
	 * 查询销售明细单号
	 * @return
	 */
	List<String[]> findSaleDetailNO(String requestName);
	List<?> findRetturnRecordSaleDetailNO(String requestName);
	TrtssSalesFormInfo findSalesFromInfoBySalesItemId(String id );
	List<OutboundCheckBillVO> findOutboundCheckBillByStatus(String statuas,int first,int pagesize);
	int countOutboundCheckBillByStatus(String status);
	List<TrtssSalesFormInfoVO> findSalesFromInfoVO(String salesNumber,String contractNumber,int first,int pagesize);
	int countSalesFromInfoVO(String salesNumber,String contractNumber); 

}
