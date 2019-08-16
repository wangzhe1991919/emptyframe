package com.wz.emptyframe.dto.generator;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wz.emptyframe.entity.generator.GenData;

/**
 * @author ta0546 wz
 * @time 2019/8/16
 */
public class GeneratorDataQuery {

    private String id;

    private String genTypeId;

    private String content;

    public QueryWrapper<GenData> getCondition() {
        QueryWrapper qw = new QueryWrapper();
        if (this.id != null) {
            qw.eq("id",this.id);
        }
        if (this.genTypeId != null) {
            qw.eq("gen_type_id",this.genTypeId);
        }
        if (this.content != null) {
            qw.like("content",this.content);
        }
        return qw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenTypeId() {
        return genTypeId;
    }

    public void setGenTypeId(String genTypeId) {
        this.genTypeId = genTypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
