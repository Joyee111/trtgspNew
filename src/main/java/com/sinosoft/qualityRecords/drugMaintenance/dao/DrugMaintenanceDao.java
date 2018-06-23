package com.sinosoft.qualityRecords.drugMaintenance.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.qualityRecords.drugMaintenance.model.DrugMaintenance;


public interface DrugMaintenanceDao {
	/**
	 * 药品养护列表
	 * @param dm
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
	 List<DrugMaintenance> getPage(DrugMaintenance dm, int pageSize, int resultSize, String string);
     /**
      * 药品养护列表条数
      * @param string
      * @return
      */
		int getTotalCount(String string);
		/**
		 * 根据id 得到model
		 * @param id
		 * @return
		 */
		DrugMaintenance findById(String id);
      /**
       * 修改保存
       * @param dm
       */
		void saveOrUpdata(DrugMaintenance dm);
         /**
          * 添加保存
          * @param dm
          */
		void saveDrugMaintenance(DrugMaintenance dm);
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
		public List<DrugMaintenance> getDrugMaintenanceByPage(String hql,Map map ,int first, int pageseiz);
		/**
		 * 条件查询条数
		 * @param hql
		 * @return
		 */
		int getQueryCount(String hql);

}
