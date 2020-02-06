package com.wz.emptyframe.dto.system;

import com.wz.emptyframe.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class SysNavigationIndexVO extends BaseEntity {

    @ApiModelProperty(value = "分组ID")
    private String groupId;

    @ApiModelProperty(value = "分组名称")
    private String groupName;

    private List<SysNavigationVO> navigationVOList;

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

    public List<SysNavigationVO> getNavigationVOList() {
        return navigationVOList;
    }

    public void setNavigationVOList(List<SysNavigationVO> navigationVOList) {
        this.navigationVOList = navigationVOList;
    }
}
