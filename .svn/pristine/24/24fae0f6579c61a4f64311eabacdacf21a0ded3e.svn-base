package com.sinosoft.drugState.acceptanceJH.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptNoteJH;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptJHVO;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

public interface AcceptanceJHDao {
	List<CheckAcceptJHVO> getPage(String date,String customerName,String type, int i, int pagesize);
	public int countTotalPage(String date, String xustomerName, String type);

	int getTotalCount(CheckAcceptNoteJH mc);

	CheckAcceptNoteJH save(CheckAcceptNoteJH mc);

	CheckAcceptNoteJH findById(String id);

	void update(CheckAcceptNoteJH mc);

	List<CheckAcceptNoteJH> getPagedsh(CheckAcceptNoteJH mc, int i, int pagesize);

	int getTotalCountdsh(CheckAcceptNoteJH mc);

	List<CheckAcceptItemJH> find(String id);

	List<CheckAcceptNoteJH> getPageysh(CheckAcceptNoteJH mc, int i, int pagesize);

	int getTotalCountysh(CheckAcceptNoteJH mc);

	int getTotalCountybh(CheckAcceptNoteJH mc);

	List<CheckAcceptNoteJH> getPageybh(CheckAcceptNoteJH mc, int i, int pagesize);

	void audit(String id);

	List<CheckAcceptItemJH> findYp(Long id);

	List<?> findAllId(Long id);

	List<CheckAcceptItemJH> find(Long id, int i, int pagesize);

	int findCount(Long id);

	void del(String id);

	QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId);

	QualifiedSuppliers findgonghuo(Long qualifiedSupplierId);
	public List<CheckAcceptNoteJH> getAllByState(String hql, Map map);
	int getRecordCount(String sql);
	
	public List<CheckAcceptJHVO> getPageByType3(String date, String customerName,
			String type,String drugsType, int i, int pagesize);
	public int countTotalPageByType3(String date, String customerName, String type,String drugsType);
	
}
