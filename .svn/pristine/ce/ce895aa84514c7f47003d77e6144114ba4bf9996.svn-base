package com.sinosoft.comQuery.comQuery.serivice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.comQuery.comQuery.dao.ComQueryDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.QualifiedSuppliers;
import com.sinosoft.ireportDTO.CustomerInfo;


@Service
public class ComQueryMngImpl implements ComQueryMng {
	@Autowired
	private ComQueryDao comQueryDao;

	public void setComQueryDao(ComQueryDao comQueryDao) {
		this.comQueryDao = comQueryDao;
	}

	@Override
	public List<FirstEnterprise> getPage(FirstEnterprise fe, int pageSize,int resultSize) {
		
		StringBuffer hql=new StringBuffer(" from FirstEnterprise t where 1=1 and review_status !=0 " );
		return comQueryDao.getPage(fe, pageSize,resultSize,hql.toString());
	}


	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from FirstEnterprise t where 1=1 and review_status !=0");
		return comQueryDao.getTotalCount(hql.toString());
	}

	@Override
	public QualifiedSuppliers findById(String id) {

		return comQueryDao.findById(id);
	}

	@Override
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql, Map map,
			int first, int pagesize) {
		// TODO Auto-generated method stub
		return comQueryDao.getFirstEnterpriseByPage(hql, map, first, pagesize);
	}

	@Override
	public int getQueryCount(String hql) {
		// TODO Auto-generated method stub
		return comQueryDao.getQueryCount(hql);
	}

	@Override
	public List<PurchaseUnit> getPurchaseUnitByPage(String hql, Map map,
			int first, int pagesize) {

		return comQueryDao.getPurchaseUnitByPage(hql, map, first, pagesize);
	}

	@Override
	public int getPurchaseUnitCount(String hql) {
		// TODO Auto-generated method stub
		return comQueryDao.getPurchaseUnitCount(hql);
	}

	@Override
	public List<CustomerInfo> getCustomerInfoList(String hql,
			Map<String, String> map) {
		// TODO Auto-generated method stub
		return comQueryDao.getCustomerInfoList(hql, map);
	}

	

}
