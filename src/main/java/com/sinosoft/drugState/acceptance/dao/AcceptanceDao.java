package com.sinosoft.drugState.acceptance.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.acceptance.model.CheckAcceptNote;
import com.sinosoft.drugState.acceptance.model.CheckAcceptVO;
import com.sinosoft.drugState.acceptance.model.CheckacceptItem;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

public interface AcceptanceDao {

	List<CheckAcceptVO> getPage(String date,String customerName,String type, int i, int pagesize);
	public int countTotalPage(String date, String xustomerName, String type);

	int getTotalCount(CheckAcceptNote mc);

	CheckAcceptNote save(CheckAcceptNote mc);

	CheckAcceptNote findById(String id);

	void update(CheckAcceptNote mc);

	List<CheckAcceptNote> getPagedsh(CheckAcceptNote mc, int i, int pagesize);

	int getTotalCountdsh(CheckAcceptNote mc);

	List<CheckacceptItem> find(String id);

	List<CheckAcceptNote> getPageysh(CheckAcceptNote mc, int i, int pagesize);

	int getTotalCountysh(CheckAcceptNote mc);

	int getTotalCountybh(CheckAcceptNote mc);

	List<CheckAcceptNote> getPageybh(CheckAcceptNote mc, int i, int pagesize);

	void audit(String id);

	List<CheckacceptItem> findYp(Long id);

	List<?> findAllId(Long id);

	List<CheckacceptItem> find(Long id, int i, int pagesize);

	int findCount(Long id);

	void del(String id);

	QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId);

	QualifiedSuppliers findgonghuo(Long qualifiedSupplierId);
	public List<CheckAcceptNote> getAllByState(String hql, Map map);
	int getRecordCount(String sql);
	
	public List<CheckAcceptVO> getPageByType3(String date, String customerName,
			String type,String drugsType, int i, int pagesize);
	public int countTotalPageByType3(String date, String customerName, String type,String drugsType);
}
