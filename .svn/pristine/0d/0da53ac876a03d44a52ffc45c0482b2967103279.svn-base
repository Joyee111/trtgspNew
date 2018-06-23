package com.sinosoft.systemConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemLogManager")
public class SystemLogManagerImpl implements SystemLogManager {

	@Autowired
	SystemLogDao dao;

	//
	public List<SystemLog> getListLog(int pageFirst, int pageSize,
			SystemLog sysLog) {
		return dao.getListLog(pageFirst, pageSize, sysLog);
	}

	public int getPagesize(SystemLog sysLog) {
		StringBuffer sql = new StringBuffer();
		sql.append("where 1=1 ");
		String btime = sysLog.getBtime();
		String etime = sysLog.getEtime();
		String tpye = sysLog.getLogType();
		if (null == btime && null == etime && null == tpye) {

		} else {
			if (!"".equalsIgnoreCase(tpye)) {
				sql.append(" and logTpye = " + "'" + tpye + "'");
			}
			if (!"".equalsIgnoreCase(btime)) {
				sql.append(" and createtime > = to_date('" + btime
						+ "','yyyy-MM-dd HH24:mi:ss')");
			}
			if (!"".equalsIgnoreCase(etime)) {
				sql.append(" and createtime < = to_date('" + etime
						+ "','yyyy-MM-dd HH24:mi:ss')");
			}

		}

		return dao.getPageSize(sql.toString());
	}

	public void removeSystemLog(Long logId) {
		// TODO Auto-generated method stub

	}

	public SystemLog saveSystemLog(SystemLog sysLog) {
		// TODO Auto-generated method stub
		dao.saveSystemLog(sysLog);
		return null;
	}

}
