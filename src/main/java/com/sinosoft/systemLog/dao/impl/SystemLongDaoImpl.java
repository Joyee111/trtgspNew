package com.sinosoft.systemLog.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.sinosoft.base.GenericDaoHibernate;
import com.sinosoft.systemLog.dao.SystemLogDao;
import com.sinosoft.systemLog.model.SysLog;
@Repository("systemLog")
public class SystemLongDaoImpl extends GenericDaoHibernate<SysLog, Long> implements
		SystemLogDao {
		public SystemLongDaoImpl(){
			super(SysLog.class);
		}

		@Override
		public void addLog(String action, String actionPerson,
				String actionType, String module, String ip) {
			SysLog sysLog = new SysLog();
			sysLog.setAction(action);
			sysLog.setAction_person(actionPerson);
			sysLog.setAction_type(actionType);
			sysLog.setModule(module);
			sysLog.setIp(ip);
			sysLog.setLog_date(new Date());
			save(sysLog);
		}
}
