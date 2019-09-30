package com.wz.emptyframe.util.file;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public enum SfptEnum {

    PATH("PATH"),
    LOGINNAME("LOGINNAME"),
    PASSWORD("PASSWORD"),
    HOST("HOST"),
    SAVEPATH("SAVEPATH"),
    PORT("PORT");
	
	private String key;
	private String name;
	private static final Logger logger = LoggerFactory.getLogger(SfptEnum.class);
	private static final String ERROR_INFO = "无法读取文件服务器配置文件application-sftp.yml";

	/**
	 * 调用构造器方法时使用init方法为name属性赋值
	 * 
	 * @param key
	 */
	SfptEnum(String key) {
		this.key = key;
		this.name = init(key);
	}

	private String init(String key) {
		try {
			// 获取属性文件输入流
			InputStream inputStream = SfptEnum.class.getClassLoader().getResourceAsStream("application-sftp.yml");
			Properties properties = new Properties();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			// 加载属性文件
			properties.load(reader);
			// 将返回值赋值给name属性
			return properties.getProperty(key);
		} catch (Exception e) {
			logger.error(ERROR_INFO + e.getMessage());
			return StringUtils.EMPTY;
		}
	};

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getName(String key) {
		for (SfptEnum e : SfptEnum.values()) {
			if (e.getKey() == key) {
				return e.name;
			}
		}
		return StringUtils.EMPTY;
	}

}
