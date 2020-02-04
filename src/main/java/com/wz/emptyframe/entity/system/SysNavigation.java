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
@ApiModel(value="SysNavigation对象", description="")
public class SysNavigation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组ID")
    private String groupId;

    @ApiModelProperty(value = "导航名称")
    private String name;

    @ApiModelProperty(value = "导航url")
    private String url;

    @ApiModelProperty(value = "导航图标")
    private String icon;

    @ApiModelProperty(value = "导航排序")
    private Integer sort;

    @ApiModelProperty(value = "是否打开新窗口")
    private Integer opennew;

    @ApiModelProperty(value = "导航备注")
    private String remark;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "SysNavigation{" +
            "name=" + name +
            ", url=" + url +
            ", icon=" + icon +
            ", sort=" + sort +
            ", opennew=" + opennew +
            ", remark=" + remark +
            ",groupId" + groupId +
        "}";
    }
}
