package com.sinosoft.systemConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.base.GenericManagerImpl;

/**
 * @author lfl:
 * @version 创建时间：Jun 13, 2013 4:16:19 PM
 * 类说明
 */
@Service
public class WarnConfigServiceImpl extends GenericManagerImpl<WarnConfig, Long> implements
		WarnConfigService {
	private WarnConfigDao warnConfigDao;
	@Autowired
	public WarnConfigServiceImpl(WarnConfigDao warnConfigDao){
		super(warnConfigDao);
		this.warnConfigDao = warnConfigDao;
	}
	@Override
	public List<WarnConfig> findList(String hql) {
		
		return warnConfigDao.findList(hql);
	}
	@Override
	public WarnConfig getWarnConfigByName(String configName) {
		// TODO Auto-generated method stub
		return warnConfigDao.getWarnConfigByName(configName);
	}

}
