package com.sinosoft.drugState.acceptanceJH.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptItemJH;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptJHVO;
import com.sinosoft.drugState.acceptanceJH.model.CheckAcceptNoteJH;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedPurchaseUnits;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;

public interface AcceptanceJHMng {
	List<CheckAcceptJHVO> getPage(String date ,String customerName,String type, int i, int pagesize);
	int countTotalPage(String date ,String xustomerName,String type);

	int getTotalCount(CheckAcceptNoteJH mc);

	CheckAcceptNoteJH save(CheckAcceptNoteJH mc);

	CheckAcceptNoteJH findById(String id);

	void update(CheckAcceptNoteJH mc);

	List<CheckAcceptNoteJH> getPagedsh(CheckAcceptNoteJH mc, int i, int pagesize);

	int getTotalCountDsh(CheckAcceptNoteJH mc);

	List<CheckAcceptItemJH> find(String id);

	List<CheckAcceptNoteJH> getPageysh(CheckAcceptNoteJH mc, int i, int pagesize);

	int getTotalCountysh(CheckAcceptNoteJH mc);

	List<CheckAcceptNoteJH> getPageybh(CheckAcceptNoteJH mc, int i, int pagesize);

	int getTotalCountybh(CheckAcceptNoteJH mc);

	void audit(String string);

	List<CheckAcceptItemJH> findYp(Long id);

	List<?> findAllId(Long id);

	List<CheckAcceptItemJH> find(Long id, int i, int pagesize);

	int findCount(Long id);

	void del(String string);

	QualifiedPurchaseUnits findgouhuo(Long qualifiedSupplierId);
	
	QualifiedSuppliers findgonghuo(Long qualifiedSupplierId);
	List<CheckAcceptNoteJH> getAllByState(String hql , Map map);
	int getRecordCount(String sql);
	List<CheckAcceptJHVO> getPageByType3(String date ,String customerName,String type,String drugsType, int i, int pagesize);
	int countTotalPageByType3(String date, String customerName, String type,String drugsType);
}
