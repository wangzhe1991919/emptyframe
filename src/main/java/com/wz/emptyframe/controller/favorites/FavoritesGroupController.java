package com.wz.emptyframe.controller.favorites;


import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.entity.favorites.FavoritesGroup;
import com.wz.emptyframe.service.favorites.FavoritesGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/favorites-group")
@Api(description = "收藏夹分组")
public class FavoritesGroupController {

    @Autowired
    @Qualifier("favoritesGroupServiceImpl")
    private FavoritesGroupService favoritesGroupService;

    @GetMapping("/get")
    @ApiOperation(value = "获取详情")
    private Object get(String id) {
        return WebDTO.success(favoritesGroupService.getById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Object add(@RequestBody FavoritesGroup favoritesGroup) {
        boolean b = favoritesGroupService.save(favoritesGroup);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Object delete(String id) {
        boolean b = favoritesGroupService.removeById(id);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改")
    public Object update(@RequestBody FavoritesGroup favoritesGroup) {
        boolean b = favoritesGroupService.updateById(favoritesGroup);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取列表")
    public Object list() {
        return WebDTO.success(favoritesGroupService.list());
    }

}
