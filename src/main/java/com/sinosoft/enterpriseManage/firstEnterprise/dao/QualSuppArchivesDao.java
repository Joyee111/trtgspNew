package com.sinosoft.enterpriseManage.firstEnterprise.dao;


import java.util.List;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSupplierArchives;

public interface QualSuppArchivesDao extends GenericDao<QualifiedSupplierArchives, Long> {
	public List<QualifiedSupplierArchives> getQuaSuppArchivesList(Long qualSuppId,int first,int pagesize);
	public  void saveList(List<QualifiedSupplierArchives> list);
	
}
