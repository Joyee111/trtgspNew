package com.sinosoft.systemConfig;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface SystemConfigManager {

	List<SystemConfig> getSystemConfig();

	int getPagesize(SystemConfig sysconfig);
	
	/**
	 * 查询一条系统配置记录(用于查询首页最新产品)
	 * @author zhancheng
	 */
	SystemConfig getSystemConfigByKey(String key);

	List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize,
			SystemConfig sysConfig);

	@GET
	@Path("/{configId}")
	SystemConfig getSysConfigById(@PathParam("configId") Long configId);

	@POST
	@Path("/systemConfig")
	SystemConfig saveSystemConfig(SystemConfig sysConfig);

	@DELETE
	@Path("/systemConfig")
	void removeSystemConfig(Long configId);
}
