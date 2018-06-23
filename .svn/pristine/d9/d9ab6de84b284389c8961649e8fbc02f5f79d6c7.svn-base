package com.sinosoft.systemLog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;
import com.sinosoft.systemLog.dao.SystemLogDao;
import com.sinosoft.systemLog.model.SysLog;
import com.sinosoft.systemLog.service.SystemLogService;
@Service
public class SystemLogServiceImpl extends GenericManagerImpl<SysLog, Long> implements
		SystemLogService {
		private SystemLogDao systemLogDao;
		@Autowired
		public SystemLogServiceImpl(SystemLogDao systemLogDao){
			super(systemLogDao);
			this.systemLogDao = systemLogDao;
		}
		@Override
		public void addLog(String action, String actionPerson,
				String actionType, String module, String ip) {
			systemLogDao.addLog(action, actionPerson, actionType, module, ip);
			
		}

}
