package com.sinosoft.systemConfig;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemConfigManager")
public class SystemConfigManagerImpl implements SystemConfigManager {

	@Autowired
	SystemConfigDao dao;

	public List<SystemConfig> getSystemConfig() {
		// TODO Auto-generated method stub
		return dao.getSystemConfig();
	}

	public List<SystemConfig> getSystemConfigList(int pageFirst, int pageSize,
			SystemConfig sysConfig) {
		// TODO Auto-generated method stub
		if (null == sysConfig.getBtime() && null == sysConfig.getEtime()
				&& null == sysConfig.getKey()) {
			return dao.getSystemConfigList(pageFirst, pageSize);
		} else {
			return dao.getSystemConfigList(pageFirst, pageSize, sysConfig);
		}
	}

	public SystemConfig getSysConfigById(Long configId) {
		// TODO Auto-generated method stub
		return dao.getSysConfigById(configId);
	}

	public void removeSystemConfig(Long configId) {
		// TODO Auto-generated method stub
		dao.removeSystemConfig(new Long(configId));
	}

	public SystemConfig saveSystemConfig(SystemConfig sysConfig) {
		// TODO Auto-generated method stub
		return dao.saveSystemConfig(sysConfig);
	}

	public int getPagesize(SystemConfig sysConfig) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("where 1=1 ");
		String btime = sysConfig.getBtime();
		String etime = sysConfig.getEtime();
		String key = sysConfig.getConfigKey();
		if (null == btime && null == etime && null == key) {

		} else {
			if (!"".equalsIgnoreCase(key)) {
				sql.append(" and configkey like " + "'%" + key + "%'");
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
	
	/**
	 * 查询一条系统配置记录(用于查询首页最新产品)
	 * @author zhancheng
	 */
	public SystemConfig getSystemConfigByKey(String key)
	{
		SystemConfig sysconfig = dao.getSystemConfigByKey(key);
		return sysconfig;
	}
}
