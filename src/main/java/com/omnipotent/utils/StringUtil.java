package com.omnipotent.utils;

/**
 * 字符串处理工具类
 * 
 * @author zhangtb
 * @date 2016-7-17 17:00:38
 * @since 1.0.0
 */
public class StringUtil {
	
	/**
	 * @param obj
	 * @return
	 */
	public static int toInt(Object obj) {
		if (obj == null) {
			return 0;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return 0;
	}

	/**
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int toInt(Object obj, int defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		String s = obj.toString();
		if (s != null && !s.trim().equals("")) {
			if (s.matches("-?\\d+")) {
				return Integer.parseInt(s);
			}
		}
		return defaultValue;
	}
	
	public static void main(String[] args) {
		System.out.println("I love WangGuan forever.");
		System.out.println("I love WangGuan forever.");
		System.out.println("I love WangGuan forever.");
		
		System.out.println("--------------------------------------------------");
		System.out.println("aaa" == "aaa");// true
		System.out.println("aaa".equals("aaa"));// true
		System.out.println("--------------------------------------------------");
		System.out.println("aaa" == "aAa");// false
		System.out.println("aaa".equals("aAa"));// false
		System.out.println("--------------------------------------------------");
		System.out.println("aaa".toUpperCase());// AAA
		System.out.println("AAA" == "aaa".toUpperCase());// false
		System.out.println("AAA".equals("aaa".toUpperCase()));// true
		System.out.println("--------------------------------------------------");
		System.out.println("AAA".toLowerCase());// aaa
	}

}
