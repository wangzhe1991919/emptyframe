package com.wz.emptyframe.entity.favorites;

import com.wz.emptyframe.entity.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-19
 */
@ApiModel(value="FavoritesInfo对象", description="")
public class FavoritesInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组ID")
    @TableField("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "图片链接")
    @TableField("ICON_URL")
    private String iconUrl;

    @ApiModelProperty(value = "收藏名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "链接")
    @TableField("URL")
    private String url;

    @ApiModelProperty(value = "跳转方式（redirece, _target）")
    @TableField("JUMP_TYPE")
    private String jumpType;

    @ApiModelProperty(value = "排序， 小到大升序")
    @TableField("SORT")
    private String sort;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getJumpType() {
        return jumpType;
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType;
    }
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "FavoritesInfo{" +
            "groupId=" + groupId +
            ", iconUrl=" + iconUrl +
            ", name=" + name +
            ", description=" + description +
            ", url=" + url +
            ", jumpType=" + jumpType +
            ", sort=" + sort +
        "}";
    }
}
