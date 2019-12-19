package com.wz.emptyframe.entity.favorites;

import java.io.Serializable;

import com.wz.emptyframe.entity.base.BaseEntity;
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
@ApiModel(value="FavoritesGroup对象", description="")
public class FavoritesGroup extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "分组是否显示")
    private String display;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "FavoritesGroup{" +
            "name=" + name +
            ", display=" + display +
        "}";
    }
}
