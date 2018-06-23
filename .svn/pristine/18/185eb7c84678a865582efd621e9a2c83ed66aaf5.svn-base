package com.sinosoft.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.systemConfig.SystemLog;

public class SystemLogUtil {

	public static void saveError(String type,String message) {

		BaseFormController baseform = new BaseFormController();

		SystemLog syslog = new SystemLog();
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd = Calendar.getInstance().getTime();
		syslog.setDescription(message);
		syslog.setCreateTime(DateTimeUtils.StringToDate(sdf.format(dd),
				"yyyy-MM-dd HH:mm:ss"));
		syslog.setLogType(type);

		baseform.getSysLogMgr().saveSystemLog(syslog);

	}
	


}
