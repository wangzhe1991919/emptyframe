package com.wz.emptyframe.dto.system;

import com.wz.emptyframe.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

public class SysNavigationVO extends BaseEntity {

    @ApiModelProperty(value = "分组ID")
    private String groupId;

    @ApiModelProperty(value = "分组名称")
    private String groupName;

    @ApiModelProperty(value = "导航名称")
    private String name;

    @ApiModelProperty(value = "导航跳转url")
    private String url;

    @ApiModelProperty(value = "导航图标url")
    private String icon;

    @ApiModelProperty(value = "导航排序")
    private Integer sort;

    @ApiModelProperty(value = "是否打开新窗口")
    private Integer opennew;

    @ApiModelProperty(value = "导航备注")
    private String remark;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getOpennew() {
        return opennew;
    }

    public void setOpennew(Integer opennew) {
        this.opennew = opennew;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
