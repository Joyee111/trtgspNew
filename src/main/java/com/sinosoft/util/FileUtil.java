package com.sinosoft.util;

import java.util.Random;

public class FileUtil {
private FileUtil(){
		
	}
	/**
	 * 获取随机文件名
	 * @return
	 */
	public static  String getFileName(){
		Random random = new Random();
		return System.currentTimeMillis()+random.nextInt(1000)+"";
	}
	/**
	 * 获取文件的拓展名
	 * @param fileName
	 * @return
	 */
	public static  String getFileExtension(String fileName){
		if(fileName!=null && fileName.length()>0){
			return fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
		}
		return ".error";
	}
}
