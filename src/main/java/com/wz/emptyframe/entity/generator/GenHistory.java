package com.wz.emptyframe.entity.generator;

/**
 * 生成数据历史记录
 * @author ta0546 wz
 * @time 2019/8/5
 */
public class GenHistory {

    private String id;

    private String contentJson;

    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
