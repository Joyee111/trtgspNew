package com.sinosoft.enterpriseManage.firstEnterprise.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.enterpriseManage.firstEnterprise.dao.FirstEnterpriseDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.FirstEnterprise;
import com.sinosoft.enterpriseManage.firstEnterprise.service.FirstEnterpriseService;
@Service
public class FirstEnterpriseServiceImpl extends GenericManagerImpl<FirstEnterprise, Long>
		implements FirstEnterpriseService {
	
	private FirstEnterpriseDao firstEnterpriseDao;
	@Autowired
	public  FirstEnterpriseServiceImpl(FirstEnterpriseDao firstEnterpriseDao){
		super(firstEnterpriseDao);
		this.firstEnterpriseDao = firstEnterpriseDao;
	}
	@Override
	public List<FirstEnterprise> getFirstEnterpriseByPage(String hql, Map map,
			int first, int pagesize) {
		return firstEnterpriseDao.getFirstEnterpriseByPage(hql, map, first, pagesize);
	}

	@Override
	public int getOrderInfoCountByState(Integer state) {
		String sql = "select count(*) from t_FirstEnterprise where 1=1 and review_status="+state; 
		//String hql =  "from FirstEnterprise a where a.review_status="+state+" order by a.id DESC";
		int recordCount = firstEnterpriseDao.getRecordCount(sql);
		return recordCount;
	}
	@Override
	public List<FirstEnterprise> getFirstEnterprisesList(int first, int pageSize) {
		String hql = "from FirstEnterprise a order by a.id DESC";
		Map<String, Object> map = new HashMap<String, Object>();
		
		return firstEnterpriseDao.getFirstEnterpriseByPage(hql, map, first, pageSize);
	}
}
