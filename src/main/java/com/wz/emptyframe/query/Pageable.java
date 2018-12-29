package com.wz.emptyframe.query;

/**
 * @author ta0546 wz
 * @time 2018/12/28
 */
public class Pageable {
    /**
     * 当前页
     */
    private int curr;
    /**
     * 每页显示条数
     */
    private int limit;

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
