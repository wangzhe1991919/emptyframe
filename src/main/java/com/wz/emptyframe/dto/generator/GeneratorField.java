package com.wz.emptyframe.dto.generator;

/**
 * @author ta0546 wz
 * @time 2019/7/25
 */
public class GeneratorField {

    //字段名
    private String name;
    //字段类型
    private int type;
    //字段值
    private String value;
    //字符串长度
    private int length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
