package com.sinosoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.base.BaseFormController;
import com.sinosoft.base.Constants;

public class PropertiesUtil extends BaseFormController{

	public static String[] getPropertiesValue(String key,HttpServletRequest request)
	{
		ResourceBundle messages;
		HttpSession session = request.getSession(false);
		Locale preferredLocale = null;
		if(session!=null)
			preferredLocale = (Locale) session.getAttribute(Constants.PREFERRED_LOCALE_KEY);
		if(preferredLocale==null)
		{
			preferredLocale = new Locale("zh_CN");
		}
		messages = ResourceBundle.getBundle("ApplicationResources",preferredLocale);
		String value = null;
		if(key!=null && !key.isEmpty())
			value = messages.getString(key);
		String[] values = null;
		if(value != null)
			values = value.split(",") ;
		return values;
	}
	
	public static String[] getPropertiesValueByFilename(String filename,String key)
	{
		String value = null;
		File f = new File(PropertiesUtil.class.getResource("/").getPath());
		f = new File(f.getPath() + "/" + filename);
		String propertyFilePath = f.getPath().replaceAll("%20", " ");
        Properties p = new Properties();
        try {
			FileInputStream fis = new FileInputStream(propertyFilePath);
			p.load(fis);
			fis.close();
			value = p.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		String[] values = null;
		if(value != null)
			values = value.split(",") ;
		return values;
	}
}
