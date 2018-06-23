package com.sinosoft.init;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sinosoft.base.Constants;
import com.sinosoft.systemConfig.SystemConfigManager;


public class SystemListener implements ServletContextListener {
	private static final Log log = LogFactory.getLog(SystemListener.class);

	/**
     * 启动服务器的时候启动
     * 
     * 参数ServletContextEvent
     */
    public void contextInitialized(ServletContextEvent event) {
    	
        log.debug("Initializing context...");
        ServletContext sysConfig = event.getServletContext();
        systemConfig(sysConfig);
        
    }

    /**
     * 此方法用于将数据放入ServletContext中
     *
     * 参数是ServletContext
     */
    public static void systemConfig(ServletContext sysConfig){
    	
    	ApplicationContext ctx = WebApplicationContextUtils.
    	                                  getRequiredWebApplicationContext(sysConfig);
    	SystemConfigManager mgr  = 
    				(SystemConfigManager) ctx.
    		            getBean("systemConfigManager");
    	
    	sysConfig.setAttribute(Constants.SYSTEM_CONFIG,mgr.getSystemConfig() );
    	
    }

    /**
     * Shutdown servlet context (currently a no-op method).
     *
     * @param servletContextEvent The servlet context event
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //LogFactory.release(Thread.currentThread().getContextClassLoader());
        //Commented out the above call to avoid warning when SLF4J in classpath.
        //WARN: The method class org.apache.commons.logging.impl.SLF4JLogFactory#release() was invoked.
        //WARN: Please see http://www.slf4j.org/codes.html for an explanation.
    }

}

