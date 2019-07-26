package com.wz.emptyframe.constant;

/**
 * @author ta0546 wz
 * @time 2019/7/25
 * 字典常量类
 */
public class DictConstant {

    //数据库类型
    public static final int DATATYPE_ORACLE = 1;
    public static final int DATATYPE_SQLSERVER = 2;
    public static final int DATATYPE_MYSQL = 3;


    //字段类型
    public static final int FIELD_PK = 0;
    public static final int FIELD_USERNAME = 1;
    public static final int FIELD_INTEGER = 2;
    public static final int FIELD_DATETIME = 3;
    public static final int FIELD_DATE = 4;
    public static final int FIELD_EMAIL = 6;
    public static final int FIELD_ADDRESS = 7;
    public static final int FIELD_MOBILE = 8;
    public static final int FIELD_IDCARD = 9;
    public static final int FIELD_STRING_EN = 10;

    //java字符串所需日期格式
    public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    //oracle函数所需日期格式
    public static final String ORACLE_DATE = "SYYYY-MM-DD";
    public static final String ORACLE_DATETIME = "SYYYY-MM-DD HH24:MI:SS";


}
