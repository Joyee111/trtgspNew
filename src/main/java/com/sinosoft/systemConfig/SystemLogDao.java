package com.sinosoft.systemConfig;

import java.util.List;

import com.sinosoft.base.GenericDao;

public interface SystemLogDao extends GenericDao<SystemLog, Long> {
	List<SystemLog> getListLog(int pageFirst, int pageSize, SystemLog sysLog);
	
	int getPageSize(String sql);
	
	SystemLog saveSystemLog(SystemLog sysLog);
}
