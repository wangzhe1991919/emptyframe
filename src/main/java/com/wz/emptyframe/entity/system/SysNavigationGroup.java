package com.wz.emptyframe.entity.system;

import com.wz.emptyframe.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
@ApiModel(value="SysNavigationGroup对象", description="")
public class SysNavigationGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SysNavigationGroup{" +
            "name=" + name +
            ", sort=" + sort +
        "}";
    }
}
