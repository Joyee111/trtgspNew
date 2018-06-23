package com.sinosoft.drugState.outcheck.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.drugState.outcheck.dao.OutCheckDao;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBill;
import com.sinosoft.drugState.outcheck.model.OutboundCheckBillVO;
import com.sinosoft.drugState.outcheck.model.OutboundCheckItem;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfo;
import com.sinosoft.drugState.outcheck.model.TrtssSalesFormInfoVO;
import com.sinosoft.drugState.outcheck.model.TrtssSalesItemsInfo;
import com.sinosoft.drugState.outcheck.service.OutCheckMng;

@Service
public class OutCheckMngImpl implements OutCheckMng{
	@Autowired
	private OutCheckDao outCheckDao;
	
	@Override
	public List<OutboundCheckBill> getPage(OutboundCheckBill mc, int i, int pagesize) {
		return outCheckDao.getPage(mc,i,pagesize);
	}

	@Override
	public int getTotalCount() {
		return outCheckDao.getTotalCount();
	}

	@Override
	public OutboundCheckBill save(OutboundCheckBill mc) {
		return outCheckDao.save(mc);
	}

	@Override
	public OutboundCheckBill findById(String id) {
		return outCheckDao.findById(id);
	}

	@Override
	public void update(OutboundCheckBill mc) {
		outCheckDao.update(mc);
	}

	@Override
	public List<OutboundCheckBill> getPagedsh(OutboundCheckBill mc, int i,
			int pagesize) {
		return outCheckDao.getPagedsh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountDsh() {
		return outCheckDao.getTotalCountdsh();
	}

	@Override
	public List<OutboundCheckItem> find(String id) {
		return outCheckDao.find(id);
	}

	@Override
	public List<OutboundCheckBill> getPageysh(OutboundCheckBill mc, int i,
			int pagesize) {
		return outCheckDao.getPageysh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountysh() {
		return outCheckDao.getTotalCountysh();
	}

	@Override
	public List<OutboundCheckBill> getPageybh(OutboundCheckBill mc, int i,
			int pagesize) {
		return outCheckDao.getPageybh(mc,i,pagesize);
	}

	@Override
	public int getTotalCountybh() {
		return outCheckDao.getTotalCountybh();
	}

	@Override
	public void audit(String id) {
		outCheckDao.audit(id);
	}

	@Override
	public List<OutboundCheckItem> findYp(Long id) {
		return outCheckDao.findYp(id);
	}

	@Override
	public List<?> findAllId(Long id) {
		return outCheckDao.findAllId(id);
	}

	@Override
	public List<OutboundCheckItem> find(Long id, int i, int pagesize) {
		return outCheckDao.find(id,i,pagesize);
	}

	@Override
	public int findCount(Long id) {
		return outCheckDao.findCount(id);
	}

	@Override
	public void del(String id) {
		outCheckDao.del(id);
	}

	@Override
	public List<TrtssSalesFormInfo> findxsJson() {
		return outCheckDao.findxsJson();
	}

	@Override
	public List<TrtssSalesItemsInfo> findxsItem(String id) {
		
		return outCheckDao.findxsItem(id);
	}
	@Override
	public TrtssSalesFormInfo findxsBy(String salesNumber) {
		return outCheckDao.findxsBy(salesNumber);
	}

	@Override
	public TrtssSalesFormInfo findTFById(String id) {
		return outCheckDao.findTFById(id);
	}

	@Override
	public TrtssSalesFormInfo findxsById(String salesNumber) {
		return outCheckDao.findxsById(salesNumber);
	}

	@Override
	public List<TrtssSalesFormInfo> findSaleNo(String contractNumber, String saleNumber, int i,
			int pagesize) {
		return outCheckDao.findSaleNo(contractNumber,saleNumber, i,pagesize);
	}

	@Override
	public int getTotalCountSaleNodlr(String contractNumber,String saleNumber) {
		return outCheckDao.getTotalCountSaleNodlr(contractNumber,saleNumber);
	}

	@Override
	public List<OutboundCheckBill> getAllByState(String hql, Map map) {
		// TODO Auto-generated method stub
		return outCheckDao.getAllByState(hql, map);
	}

	@Override
	public List<String[]> findSaleDetailNO(String requestName) {
		// TODO Auto-generated method stub
		return outCheckDao.findSaleDetailNO(requestName);
	}

	@Override
	public List<?> findRetturnRecordSaleDetailNO(String requestName) {
		// TODO Auto-generated method stub
		return outCheckDao.findRetturnRecordSaleDetailNO(requestName);
	}

	@Override
	public TrtssSalesFormInfo findSalesFromInfoBySalesItemId(String id) {
		// TODO Auto-generated method stub
		return outCheckDao.findSalesFromInfoBySalesItemId(id);
	}

	@Override
	public int countOutboundCheckBillByStatus(String status) {
		// TODO Auto-generated method stub
		return outCheckDao.countOutboundCheckBillByStatus(status);
	}

	@Override
	public List<OutboundCheckBillVO> findOutboundCheckBillByStatus(
			String statuas,int first ,int pagesize) {
		// TODO Auto-generated method stub
		return outCheckDao.findOutboundCheckBillByStatus(statuas,first,pagesize);
	}

	@Override
	public int countSalesFromInfoVO(String salesNumber, String contractNumber) {
		// TODO Auto-generated method stub
		return outCheckDao.countSalesFromInfoVO(salesNumber, contractNumber);
	}

	@Override
	public List<TrtssSalesFormInfoVO> findSalesFromInfoVO(String salesNumber,
			String contractNumber, int first, int pagesize) {
		// TODO Auto-generated method stub
		return outCheckDao.findSalesFromInfoVO(salesNumber, contractNumber, first, pagesize);
	}

}
