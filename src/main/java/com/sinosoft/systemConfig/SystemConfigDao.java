package com.sinosoft.systemConfig;

import java.util.List;

import com.sinosoft.base.GenericDao;

public interface SystemConfigDao extends GenericDao<SystemConfig, Long> {

	List<SystemConfig> getSystemConfig();

	List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize,
			SystemConfig sysConfig);

	List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize);

	int getPageSize(String sql);

	SystemConfig getSysConfigById(Long configId);

	SystemConfig saveSystemConfig(SystemConfig sysConfig);

	void removeSystemConfig(long configId);
	
	/**
	 * 查询一条系统配置记录(用于查询首页最新产品)
	 * @author zhancheng
	 */
	SystemConfig getSystemConfigByKey(String key);
}
