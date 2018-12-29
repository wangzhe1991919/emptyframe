package com.wz.emptyframe.query.system;

import com.wz.emptyframe.query.Pageable;

/**
 * @author ta0546 wz
 * @time 2018/12/28
 */
public class UserQuery extends Pageable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
