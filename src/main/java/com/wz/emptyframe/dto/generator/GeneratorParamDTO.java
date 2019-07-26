package com.wz.emptyframe.dto.generator;

import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2019/7/25
 * 根据传入的参数生成Sql语句
 */
public class GeneratorParamDTO {

    //数据库类型，1-oracle，2-sqlserver,3-mysql
    private int dataBaseType;

    //数据库表名
    private String tableName;

    //字段名
    private List<GeneratorField> fields;

    //生成语句数量
    private int counts;

    public int getDataBaseType() {
        return dataBaseType;
    }

    public void setDataBaseType(int dataBaseType) {
        this.dataBaseType = dataBaseType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<GeneratorField> getFields() {
        return fields;
    }

    public void setFields(List<GeneratorField> fields) {
        this.fields = fields;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
