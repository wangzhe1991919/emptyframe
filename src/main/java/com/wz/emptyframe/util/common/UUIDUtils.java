package com.wz.emptyframe.util.common;

import java.util.UUID;


public class UUIDUtils {
	
	private UUIDUtils() {
		
	}

	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
