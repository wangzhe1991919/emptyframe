package com.wz.emptyframe.entity.base;

import java.util.Date;

/**
 * @author ta0546 wz
 * @time 2019/12/19
 */
public class BaseEntity {

    private String id;

    private String createUser;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
