package com.sinosoft.enterpriseManage.firstEnterprise.dao;

import java.util.List;
import java.util.Map;

import com.sinosoft.base.GenericDao;
import com.sinosoft.enterpriseManage.firstEnterprise.model.PurchaseUnit;
import com.sinosoft.enterpriseManage.firstEnterprise.model.TrtssProv;

/**
 * @author lfl:
 * @version 创建时间：May 29, 2013 2:18:54 PM
 * 类说明
 */
public interface PurchaseUnitsDao extends GenericDao<PurchaseUnit, Long> {
	public List<PurchaseUnit> findListByPage(String hql , int first ,int pagesize);
	public List<PurchaseUnit> findListByPage(String hql,Map<String, Object> paramMap,int first,int pagesize);
	public int countRecordByState(int state);
	public Map<String, String> qmMap();
	public String findNumberByPro(String number);
	public TrtssProv findTrtssProvByNo(String substring);
	public List<PurchaseUnit> findListByParam(String param);
	/**
	 * 根据条件查询合格品种（查询保留的44个客户）
	 * @return
	 */
	List<PurchaseUnit> findExceptPurchaseUnit(String companyOrcorporation,int first, int pagesize);
	/**
	 * 检查客户名称是否重复
	 * @param name
	 * @return
	 */
	public Boolean checkName(String name);
}
