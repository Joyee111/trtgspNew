package com.sinosoft.util;

public class CheckEmpty {
	
	/**
	 * 验证字符串是否为空
	 * @param str待验证字符串
	 * @return Boolean
	 */
	public static Boolean isEmpty(String str){
    	if(null==str||"".equals(str)){
    		return true;
    	}
    	return false;
    }
}
