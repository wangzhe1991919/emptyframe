package com.wz.emptyframe.util.common;


import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils{

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
