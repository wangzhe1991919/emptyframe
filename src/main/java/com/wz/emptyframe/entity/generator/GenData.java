package com.wz.emptyframe.entity.generator;

/**
 * 要生成的随机数据
 */
public class GenData {

    private String id;

    private int genTypeId;

    private String content;

    //切割符，传参数时使用
    private String split;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGenTypeId() {
        return genTypeId;
    }

    public void setGenTypeId(int genTypeId) {
        this.genTypeId = genTypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GenData(String id,int genTypeId,String content) {
        this.id = id;
        this.genTypeId = genTypeId;
        this.content = content;
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public GenData(){}
}
