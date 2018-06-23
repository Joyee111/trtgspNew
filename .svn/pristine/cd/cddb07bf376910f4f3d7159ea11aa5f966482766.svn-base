package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.QualSuppArchivesDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSupplierArchives;
import com.sinosoft.enterpriseManage.firstEnterprise.service.QualSuppArchivesService;
@Service
public class QualSuppArchivesServiceImpl extends GenericManagerImpl<QualifiedSupplierArchives, Long>
		implements QualSuppArchivesService {
	private QualSuppArchivesDao qualSuppArchivesDao;
	@Autowired
	public QualSuppArchivesServiceImpl(QualSuppArchivesDao qualSuppArchivesDao){
		super(qualSuppArchivesDao);
		this.qualSuppArchivesDao = qualSuppArchivesDao;
	}
	@Override
	public List<QualifiedSupplierArchives> getQualifiedSuppliersByPage(Long id,
			int first, int pagesize) {
		
		return qualSuppArchivesDao.getQuaSuppArchivesList(id, first, pagesize);
	}
	@Override
	public void saveList(List<QualifiedSupplierArchives> archivesList) {
		
		qualSuppArchivesDao.saveList(archivesList);
	}


}
