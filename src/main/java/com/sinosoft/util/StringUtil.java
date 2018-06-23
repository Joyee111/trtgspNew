package com.sinosoft.util;

import java.math.MathContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/**
 * @author lfl:
 * @version 创建时间：Jun 3, 2013 11:45:06 AM
 * 类说明
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		return str!=null && !str.trim().equals("");
	}
	public static String fileExtensions(String str){
		String extension = "";
		if(isNull(str))
			extension = str.substring(str.lastIndexOf("."));
		return extension;
	}
	public static boolean validateEngsh(String str){
		Pattern  parent =Pattern.compile("[a-zA-Z]");
		Matcher m =parent.matcher(str);
		return m.matches();
		
	}
	public static boolean validateDepartment(String str){
		Pattern  parent =Pattern.compile("[yxsYXS]");
		Matcher m =parent.matcher(str);
		return m.matches();
		
	}
	public static boolean validateInteger(String str){
		
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		
	}
	
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
	       String ip = request.getHeader("x-forwarded-for");
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getRemoteAddr();
	       }
	       return ip; 
	}
	/**
	 * 判断字符串是否为"" 或者 null, 如果是返回true
	 * @param str
	 */	 
	public static String trimNull(String str) {
		if(null == str || "null".equals(str)) {
			return "";
		}
		return str;
	}
	public static String  formatFloatString(String floatStr){
		String str = "";
		if(floatStr != null &&  !"null".equals(floatStr) && !"".equals(floatStr.trim())){
			float f = Float.parseFloat(floatStr);
			str = String.format("%1$.2f", f);
		}
		return str;
	}
	
}
