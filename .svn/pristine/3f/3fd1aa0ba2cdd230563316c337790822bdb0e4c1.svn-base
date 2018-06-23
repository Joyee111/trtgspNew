package com.sinosoft.qualityRecords.qualityQuery.dao;

import java.util.List;
import java.util.Map;
import com.sinosoft.qualityRecords.qualityQuery.model.QulityQuery;
public interface QualityQueryDao {
	/**
	 * 质量查询列表
	 * @param qq
	 * @param pageSize
	 * @param resultSize
	 * @param string
	 * @return
	 */
	 List<QulityQuery> getPage(QulityQuery qq, int pageSize, int resultSize, String string);
     /**
     * 质量查询类表条数
    * @param string
    * @return
    */
		int getTotalCount(String string);
		/**
		 * 根据id查询ｍｏｄｅｌ
		 * @param id
		 * @return
		 */
		QulityQuery findById(String id);
		/**
	     * 修改保存
	     * @param dr
	     */
		void saveOrUpdata(QulityQuery qq);
		/**
	     * 添加保存
	     * @param dr
	     */
		void saveQulityQuery(QulityQuery qq);
    /**
    * 删除
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
		public List<QulityQuery> getQulityQueryByPage(String hql,Map map ,int first, int pagesize);
		/**
		 * 根据查询条件查询得到的条数
		 * @param hql
		 * @return
		 */
		int getQueryCount(String hql);

}
