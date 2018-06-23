package com.sinosoft.util;

import java.io.ByteArrayOutputStream;

public class DataTransUtil {
	/**
	 * 十六进制字符集
	 */
	private static String hexString = "0123456789ABCDEF";

	/**
	 * 转化字符串为十六进制编码(不可用)
	 * @param s
	 * @return
	 */
	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 转化十六进制编码为字符串(不可用)
	 * 
	 * @param s
	 * @return
	 */
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			s = new String(baKeyword, "UTF-8");// UTF-6le:Not
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	/**
	 * 转化字符串为十六进制编码(可用)
	 * @param str
	 * @return
	 */
	public static String encode(String str) {
		// 根据默认编码获取字节数组
		byte[] bytes = str.getBytes();
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
			sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		}
		return sb.toString();
	}
	/**
	 * 转化十六进制编码为字符串（可用）
	 * @param bytes
	 * @return
	 */
	public static String decode(String bytes) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(
				bytes.length() / 2);
		for (int i = 0; i < bytes.length(); i += 2) {
			baos.write((hexString.indexOf(bytes.charAt(i))<<4|hexString.indexOf(bytes.charAt(i+1))));
		}

		return new String(baos.toByteArray());
	}
	
  	/**
	 * 二进制转换成字符串
	 * @param values
	 * @return
	 */
	public static String toStringImage(byte[] values) {
		return (new sun.misc.BASE64Encoder().encode(values));
	}
}
