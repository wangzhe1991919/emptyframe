package com.wz.emptyframe.dbmonitor;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 * 数据库基本信息
 */
public class DBBaseInfo {

    /**
     * 数据库IP地址
     */
    private String ip;
    /**
     * 数据库名称
     */
    private String dbname;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 数据库类型
     */
    private String type;
    /**
     * 是否做为基准表（对比表的基准表）
     */
    private boolean isbasic;
    /**
     * 实例名称（oracle使用）
     */
    private String instance;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public boolean getIsbasic() {
        return isbasic;
    }

    public void setIsbasic(boolean isbasic) {
        this.isbasic = isbasic;
    }
}
