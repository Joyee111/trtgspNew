package com.sinosoft.systemConfig;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface SystemLogManager {
	
	List<SystemLog> getListLog(int pageFirst, int pageSize,
			SystemLog sysLog);
	
	int getPagesize(SystemLog sysLog);
	
	@DELETE
	@Path("/systemConfig")
	void removeSystemLog(Long logId);
	
	@POST
	@Path("/systemConfig")
	SystemLog saveSystemLog(SystemLog sysLog);

}
