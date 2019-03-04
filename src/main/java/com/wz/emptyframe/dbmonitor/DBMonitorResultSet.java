package com.wz.emptyframe.dbmonitor;

import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 * 数据库查询后返回数据格式
 */
public class DBMonitorResultSet {

    /**
     * 数据库ip+数据库名称组成的key
     */
    private String ip_dbname;
    /**
     * 该数据库所有的表名
     */
    private List<String> tableList;
    /**
     * 是否做为基准表（对比表的基准表）
     */
    private boolean isbasic;
    /**
     * 每张表有哪些字段,key是表名
     */
    private Map<String,List<Field>> tableFields;

    public String getIp_dbname() {
        return ip_dbname;
    }

    public void setIp_dbname(String ip_dbname) {
        this.ip_dbname = ip_dbname;
    }

    public List<String> getTableList() {
        return tableList;
    }

    public void setTableList(List<String> tableList) {
        this.tableList = tableList;
    }

    public Map<String, List<Field>> getTableFields() {
        return tableFields;
    }

    public void setTableFields(Map<String, List<Field>> tableFields) {
        this.tableFields = tableFields;
    }

    public boolean getIsbasic() {
        return isbasic;
    }

    public void setIsbasic(boolean isbasic) {
        this.isbasic = isbasic;
    }
}
