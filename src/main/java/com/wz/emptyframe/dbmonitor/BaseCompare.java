package com.wz.emptyframe.dbmonitor;

/**
 * @author ta0546 wz
 * @time 2019/2/27
 */
public class BaseCompare {

    private String name;

    /**
     * -1 从库没有（缺少），0（相同）， 1 主库无、从库有（新增）,2 类型或者长度或者描述不同
     */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
