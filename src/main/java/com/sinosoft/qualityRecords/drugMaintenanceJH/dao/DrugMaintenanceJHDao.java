package com.sinosoft.qualityRecords.drugMaintenanceJH.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;


import com.sinosoft.base.GenericDao;
import com.sinosoft.qualityRecords.drugMaintenanceJH.model.DrugMaintenanceJH;

public interface DrugMaintenanceJHDao extends GenericDao<DrugMaintenanceJH, Long> {
	/**
	 * 药品养护列表
	 * @param dm
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
	 List<DrugMaintenanceJH> getPage(DrugMaintenanceJH dm, int pageSize, int resultSize, String hql);
     /**
      * 药品养护列表条数
      * @param string
      * @return
      */
		int getTotalCount(String hql);
		/**
		 * 根据id 得到model
		 * @param id
		 * @return
		 */
		DrugMaintenanceJH findById(String id);
      /**
       * 修改保存
       * @param dm
       */
		void saveOrUpdata(DrugMaintenanceJH dm);
         /**
          * 添加保存
          * @param dm
          */
		void saveDrugMaintenanceJH(DrugMaintenanceJH dm);
    /**
     * s删除
     * @param ids
     */
		void del(String ids);

		/**
		 * 根据HQL查询条件分页显示首营企业列表
		 * @param hql
		 * @param map
		 * @param first
		 * @param pageseiz
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<DrugMaintenanceJH> getDrugMaintenanceJHByPage(String hql,Map map ,int first, int pagesize);
		/**
		 * 条件查询条数
		 * @param hql
		 * @return
		 */
		int getQueryCount(String hql);
		
		Session getSession();
}
