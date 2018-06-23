package com.sinosoft.systemConfig;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sinosoft.base.Constants;
import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.util.DateTimeUtils;
import com.sinosoft.util.SystemLogUtil;

@Repository
public class SystemConfigDaoHibernate extends
		GenericDaoHibernate<SystemConfig, Long> implements SystemConfigDao {
	public SystemConfigDaoHibernate() {
		super(SystemConfig.class);
	}

	@SuppressWarnings("unchecked")
	public List<SystemConfig> getSystemConfig() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from SystemConfig t ");
	}

	@SuppressWarnings("unchecked")
	public int getPageSize(String sql) {
		// TODO Auto-generated method stub
		String strsql = "select count(*) from trthr_sys_config  " + sql;
//				+ " order by configid desc ";
		int pageCount = 0;
		Session session = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			Query query = session.createSQLQuery(strsql);
			List list = query.list();

			pageCount = Integer.valueOf(list.get(0).toString());
		} catch (Exception e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		} finally {
			session.close();
		}
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	public List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize) {
		// TODO Auto-generated method stub
		List<SystemConfig> list = null;
		Session session = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			Criteria c = session.createCriteria(SystemConfig.class);
			c.addOrder(Order.desc("createTime"));
			c.setFirstResult(pageFirst);
			c.setMaxResults(pageSize);
			list = c.list();

		} catch (Exception e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		} finally {
			session.close();

		}
		return list;

	}

	// 查询
	@SuppressWarnings("unchecked")
	public List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize,
			SystemConfig sysConfig) {
		// TODO Auto-generated method stub
		List<SystemConfig> list = null;
		String btime = sysConfig.getBtime();
		String etime = sysConfig.getEtime();
		String key = sysConfig.getConfigKey();
		Session session = null;
		Criteria c = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			c = session.createCriteria(SystemConfig.class);
			if (!"".equalsIgnoreCase(key)) {
				c.add(Restrictions.like("configKey", "%" + key + "%"));
			}

			if (!"".equalsIgnoreCase(btime)) {
				c.add(Restrictions.ge("createTime", DateTimeUtils.StringToDate(
						btime + " 00:00:00 ", "yyyy-MM-dd hh:mm:ss")));
			}

			if (!"".equalsIgnoreCase(etime)) {
				c.add(Restrictions.le("createTime", DateTimeUtils.StringToDate(
						etime + " 00:00:00 ", "yyyy-MM-dd hh:mm:ss")));
			}
			c.addOrder(Order.desc("createTime"));
			c.setFirstResult(pageFirst);
			c.setMaxResults(pageSize);
			list = c.list();

		} catch (Exception e) {
			SystemLogUtil.saveError(Constants.LOG_ERROR, e.getMessage());
		} finally {
			session.close();

		}

		return list;

	}

	@SuppressWarnings("unchecked")
	public SystemConfig getSysConfigById(Long configId) {
		// TODO Auto-generated method stub
		List sysConfig = getHibernateTemplate().find(
				"from SystemConfig where id=?", configId);
		if (sysConfig == null || sysConfig.isEmpty()) {
			return null;
		} else {
			return (SystemConfig) sysConfig.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public void removeSystemConfig(long configId) {
		// TODO Auto-generated method stub
		SystemConfig sysCon = new SystemConfig();
		List sysConfig = getHibernateTemplate().find(
				"from SystemConfig where id=?", configId);
		if (sysConfig == null || sysConfig.isEmpty()) {

		} else {
			sysCon = (SystemConfig) sysConfig.get(0);
		}

		getHibernateTemplate().delete(sysCon);
		getHibernateTemplate().flush();

	}

	public SystemConfig saveSystemConfig(SystemConfig sysConfig) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(sysConfig);
		getHibernateTemplate().flush();
		return sysConfig;
	}

	/**
	 * 查询一条系统配置记录(用于查询首页最新产品)
	 * @author zhancheng
	 */
	@SuppressWarnings("unchecked")
	public SystemConfig getSystemConfigByKey(String key)
	{
		String hqls = "from SystemConfig where configkey='"+key+"'";
		List<SystemConfig> sysconfiglist = this.getHibernateTemplate().find(hqls);
		return sysconfiglist!=null&&sysconfiglist.size()>0?sysconfiglist.get(0):null;
	}
}
