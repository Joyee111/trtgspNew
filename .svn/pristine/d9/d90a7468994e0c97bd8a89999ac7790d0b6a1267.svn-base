package com.sinosoft.qualityRecords.unqualifiedManger.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sinosoft.qualityRecords.unqualifiedManger.dao.UnqualifiedManagerDao;
import com.sinosoft.qualityRecords.unqualifiedManger.model.UnqualifiedManager;
import com.sinosoft.varietyManger.firstVarietyManger.model.Qualifiedmedcstore;

@Service
public class UnqualifiedManagerMngImpl implements UnqualifiedManagerMng {
	@Autowired
	private UnqualifiedManagerDao unqualifiedManagerDao;

	public void setUnqualifiedManagerDao(UnqualifiedManagerDao unqualifiedManagerDao) {
		this.unqualifiedManagerDao = unqualifiedManagerDao;
	}
	@Override
	public List<UnqualifiedManager> getPage(UnqualifiedManager um, int pageSize,
			int resultSize) {
		StringBuffer hql=new StringBuffer("from UnqualifiedManager t where 1=1");
		return unqualifiedManagerDao.getPage(um, pageSize,resultSize,hql.toString());
	}
	@Override
	public int getTotalCount() {
		StringBuffer hql=new StringBuffer("select count(*) from UnqualifiedManager t where 1=1");
		return unqualifiedManagerDao.getTotalCount(hql.toString());
	}
	@Override
	public UnqualifiedManager findById(String id) {
		return unqualifiedManagerDao.findById(id);
	}


	@Override
	public void saveOrUpdata(UnqualifiedManager um) {
		unqualifiedManagerDao.saveOrUpdata(um);
	}
	@Override
	public void saveUnqualifiedManager(UnqualifiedManager um) {
		unqualifiedManagerDao.saveUnqualifiedManager(um);
	}


	@Override
	public void del(String[] ids) {
		
		for(int i = 0;i<ids.length;i++){
			unqualifiedManagerDao.del(ids[i]);
		}
		
	}
	@Override
	public Map<String, String> qsMap() {
		return unqualifiedManagerDao.qsMap();
	}
	@Override
	public List<UnqualifiedManager> getUnqualifiedManagerByPage(String hql, Map map,
			int first, int pagesize) {

		return unqualifiedManagerDao.getUnqualifiedManagerByPage(hql, map, first, pagesize);
	}
	@Override
	public int getQueryCount(String hql) {
		
		return unqualifiedManagerDao.getQueryCount(hql);
	}
	@Override
	public Qualifiedmedcstore findYpkcById(String id) {
	
		return unqualifiedManagerDao.findYpkcById(id);
	}
	@Override
	public List<Qualifiedmedcstore> findypJsonqy() {

		return unqualifiedManagerDao.findypJsonty();
	}

}
