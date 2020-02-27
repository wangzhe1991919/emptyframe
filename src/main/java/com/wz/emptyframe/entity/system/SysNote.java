package com.wz.emptyframe.entity.system;


import com.wz.emptyframe.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;

@ApiModel(value="便签", description="")
public class SysNote extends BaseEntity {

    /**
     * 便签富文本内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
