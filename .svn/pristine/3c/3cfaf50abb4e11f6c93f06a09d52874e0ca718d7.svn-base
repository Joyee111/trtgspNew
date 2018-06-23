package com.sinosoft.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;
import com.sinosoft.systemConfig.SystemConfig;

public class SystemConfigUtil extends BaseFormController {

	/**
	 * 从数据字典中取得相关key的值 传入的参数String,ServletContext 用法如下:
	 * 在controll中用需要继承BaseFormController String[] str =
	 * SystemConfigUtil.getSystemValue(KEY,getServletContext());
	 **/
	@SuppressWarnings("unchecked")
	public static String[] getSystemValue(String key,
			ServletContext servletContext) {

		List systemConfig = (List) servletContext
				.getAttribute(Constants.SYSTEM_CONFIG);

		StringBuffer str = new StringBuffer();
		String[] value = null;

		for (int i = 0; i < systemConfig.size(); i++) {
			SystemConfig sysConfig = (SystemConfig) systemConfig.get(i);

			if (sysConfig.getConfigKey().equalsIgnoreCase(key)) {
				str.append(sysConfig.getConfigValue());
			} else {
				str.append("");
			}
		}

		value = str.toString().split(",");

		return value;

	}

	@SuppressWarnings("unchecked")
	public static String getSystemSql(String key, ServletContext servletContext) {

		List systemConfig = (List) servletContext
				.getAttribute(Constants.SYSTEM_CONFIG);

		StringBuffer str = new StringBuffer();

		for (int i = 0; i < systemConfig.size(); i++) {
			SystemConfig sysConfig = (SystemConfig) systemConfig.get(i);

			if (sysConfig.getConfigKey().equalsIgnoreCase(key)) {
				str.append(sysConfig.getConfigValue());
			} else {
				str.append("");
			}
		}

		return str.toString();

	}

	public static String getIpArr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
//		System.out.println(request.getRemoteAddr());
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}
}
