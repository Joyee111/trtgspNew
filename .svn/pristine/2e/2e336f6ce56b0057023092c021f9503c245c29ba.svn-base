package com.sinosoft.drugState.accepreturn.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNote;
import com.sinosoft.drugState.accepreturn.model.ReturnCheckAcceptNoteVO;
import com.sinosoft.drugState.accepreturn.model.ReturncheckItem;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNote;
import com.sinosoft.drugState.returnRecords.model.ReturnReceivingNoteItem;

public interface ReturnTaceDao {
	List<ReturnCheckAcceptNote> getPage(ReturnCheckAcceptNote mc, int i, int pagesize);

	int getTotalCount(ReturnCheckAcceptNote reNo);

	ReturnCheckAcceptNote save(ReturnCheckAcceptNote mc);

	ReturnCheckAcceptNote findById(String id);

	void update(ReturnCheckAcceptNote mc);

	List<ReturnCheckAcceptNote> getPagedsh(ReturnCheckAcceptNote mc, int i, int pagesize);

	int getTotalCountdsh(ReturnCheckAcceptNote mc);

	List<ReturncheckItem> find(String id);

	List<ReturnCheckAcceptNote> getPageysh(ReturnCheckAcceptNote mc, int i, int pagesize);

	int getTotalCountysh(ReturnCheckAcceptNote mc);

	int getTotalCountybh(ReturnCheckAcceptNote mc);

	List<ReturnCheckAcceptNote> getPageybh(ReturnCheckAcceptNote mc, int i, int pagesize);

	void audit(String id);

	List<ReturncheckItem> findYp(Long id);

	List<?> findAllId(Long id);

	List<ReturncheckItem> find(Long id, int i, int pagesize);

	int findCount(Long id);

	void del(String id);

	List<ReturnReceivingNote> findthdJson();

	List<ReturnReceivingNoteItem> findthd(String id);
	public List<ReturnCheckAcceptNote> getAllByState(String hql, Map map);
	/**
	 * 根据验收日期，客户名称状态查询退货验收单
	 * @param date
	 * @param customerName
	 * @param status
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<ReturnCheckAcceptNote> getReturnCheckAcceptNoteByCondition(
			String date, String customerName, String status, int first,
			int pagesize);
	public int countReturnCheckAcceptNoteByConiction(String date,
			String customerName, String status);
	/**
	 * 根据客户名称和日期查询销售退回验收记录及明细
	 * @param date
	 * @param customerName
	 * @param status
	 * @param first
	 * @param pagesize
	 * @return
	 */
	public List<ReturnCheckAcceptNoteVO> getReturnCheckAcceptNoteVOByCondition(String date ,String customerName,String status,int first,int pagesize);
	/**
	 * 根据客户名称和日期统计销售退回验收记录及明细
	 * @param date
	 * @param customerName
	 * @param status
	 * @return
	 */
	public int countReturnCheckAcceptNoteVOByConiction(String date,String customerName,String status);
}
	
