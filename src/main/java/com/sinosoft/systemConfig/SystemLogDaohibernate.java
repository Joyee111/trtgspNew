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
public class SystemLogDaohibernate extends GenericDaoHibernate<SystemLog, Long>
		implements SystemLogDao {

	public SystemLogDaohibernate() {
		super(SystemLog.class);
		// TODO Auto-generated constructor stub
	}

	// 列表展示
	@SuppressWarnings("unchecked")
	public List<SystemLog> getListLog(int pageFirst, int pageSize,
			SystemLog sysLog) {

		List<SystemLog> list = null;
		String btime = sysLog.getBtime();
		String etime = sysLog.getEtime();
		String type = sysLog.getLogType();
		Session session = null;
		Criteria c = null;
		try {
			session = this.getHibernateTemplate().getSessionFactory()
					.openSession();
			c = session.createCriteria(SystemLog.class);
			if (!"".equalsIgnoreCase(type)&&null!=type) {
				c.add(Restrictions.eq("logType", type));
			}

			if (!"".equalsIgnoreCase(btime)&&null!=btime) {
				c.add(Restrictions.ge("createTime", DateTimeUtils.StringToDate(
						btime + " 00:00:00 ", "yyyy-MM-dd hh:mm:ss")));
			}

			if (!"".equalsIgnoreCase(etime)&&null!=etime) {
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

	// 页数
	@SuppressWarnings("unchecked")
	public int getPageSize(String sql) {
		// TODO Auto-generated method stub
		String strsql = "select count(*) from trthr_log_message  " + sql;
//				+ " order by logid desc ";
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

	// 保存信息
	public SystemLog saveSystemLog(SystemLog sysLog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(sysLog);
		return null;
	}

}
