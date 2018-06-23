package com.sinosoft.qualityRecords.complantManager.service.impl;




import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.qualityRecords.complantManager.dao.DrugComInfoDao;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfo;
import com.sinosoft.qualityRecords.complantManager.model.DrugComInfoItem;
import com.sinosoft.qualityRecords.complantManager.service.DrugComInfoManger;
import com.sinosoft.varietyManger.firstVarietyManger.model.QualityMidicine;






@Service
public class DrugComInfoMangerImpl    implements DrugComInfoManger {
	 @Autowired
	private DrugComInfoDao drugComInfoDao;
	public void setDrugComInfoDao(DrugComInfoDao drugComInfoDao) {
		this.drugComInfoDao = drugComInfoDao;
	
	}
	
		@Override
		public List<DrugComInfoItem> getPage(DrugComInfoItem dr,String  userId, int pageSize,
				int resultSize) {
			List<DrugComInfoItem> list = new ArrayList<DrugComInfoItem>();
			if(userId!=null &&!"".equals(userId)){
				StringBuffer hql=new StringBuffer(" from DrugComInfoItem t where 1=1 and t.zhipaiId="+userId  );
				list = drugComInfoDao.getPage(dr,userId, pageSize,resultSize,hql.toString());	
			}
			
			
			
		
			return list;
		}





		@Override
		public DrugComInfo findById(String id) {
			return drugComInfoDao.findById(id);
		}


		@Override
		public void saveOrUpdata(DrugComInfo dr) {
			drugComInfoDao.saveOrUpdata(dr);
		}


		@Override
		public void saveDrugComInfo(DrugComInfo dr) {
			drugComInfoDao.saveDrugComInfo(dr);
		}


	
		@Override
		public Map<String,String> qmMap() {
			return drugComInfoDao.qmMap();
		}


		@Override
		public QualityMidicine findYpById(String quamap) {
			return drugComInfoDao.findYpById(quamap);
		}

	

		@Override
		public List<DrugComInfoItem> getDrugComInfoByPage(String hql, Map map,
				int first, int pagesize) {
			return drugComInfoDao.getDrugComInfoByPage(hql, map, first, pagesize);
		}

		@Override
		public int getQueryCount(String hql) {
			// TODO Auto-generated method stub
			return drugComInfoDao.getQueryCount(hql);
		}

		@Override
		public Map<String, String> jsMap() {
			return drugComInfoDao.jsMap();
		}

		@Override
		public int getTotalCount(String userId) {
			int i=0;
			
			StringBuffer hql=new StringBuffer(" select count(*) from DrugComInfo  d , DrugComInfoItem f where   d.id=f.drugComInfoId and f.zhipaiId="+userId );
		
			i=drugComInfoDao.getTotalCount(hql.toString());
		
		return i;
	}

		@Override
		public void save(DrugComInfoItem di) {
			drugComInfoDao.save(di);
			
		}

		@Override
		public void del(List<?> receItem) {
			
			for(int i=0;i<receItem.size();i++){
				drugComInfoDao.dels(receItem.get(i).toString());
			}
			
		} 
		@Override
		public List<?> findAllId(Long id) {
			return drugComInfoDao.findAllId(id);
		}

		@Override
		public void delss(String id) {
			drugComInfoDao.delss(id);
			
		}

		@Override
		public List<DrugComInfoItem> findYp(Long id) {
	
			return drugComInfoDao.findYp(id);
		}

		@Override
		public void update(DrugComInfoItem di) {
			drugComInfoDao.update(di);
			
		}

		@Override
		public List<?> findZhiPaiId(Long id) {
			// TODO Auto-generated method stub
			return drugComInfoDao.findZhiPaiId(id);
		}
		/**
		 *查询该用户有没有投诉代办事项
		 */
		@Override
		public int countWaitingToDo(Long userId) {
			// TODO Auto-generated method stub
			return drugComInfoDao.countWaitingToDo(userId);
		}


}
