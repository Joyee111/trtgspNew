package com.sinosoft.enterpriseManage.firstEnterprise.service;

import java.util.List;

import com.sinosoft.base.GenericManager;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSupplierArchives;

public interface QualSuppArchivesService extends GenericManager<QualifiedSupplierArchives, Long> {
	public List<QualifiedSupplierArchives> getQualifiedSuppliersByPage(Long id, int first,int pagesize);
	public void saveList(List<QualifiedSupplierArchives> archivesList);
}
