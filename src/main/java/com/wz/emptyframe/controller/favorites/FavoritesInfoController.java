package com.wz.emptyframe.controller.favorites;


import org.springframework.web.bind.annotation.RequestMapping;
import com.wz.emptyframe.service.favorites.FavoritesInfoService;
import com.wz.emptyframe.dto.WebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wz.emptyframe.entity.favorites.FavoritesInfo;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-19
 */
@RestController
@RequestMapping("/favoritesInfo")
@Api(description = "favoritesInfo")
public class FavoritesInfoController {

    @Autowired
    @Qualifier("favoritesInfoServiceImpl")
    private FavoritesInfoService defaultService;

    @GetMapping("/get")
    @ApiOperation(value = "获取详情")
    private Object get(String id) {
        return WebDTO.success(defaultService.getById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Object add(@RequestBody FavoritesInfo favoritesInfo) {
        boolean b = defaultService.save(favoritesInfo);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Object delete(String id) {
        boolean b = defaultService.removeById(id);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改")
    public Object update(@RequestBody FavoritesInfo favoritesInfo) {
        boolean b = defaultService.updateById(favoritesInfo);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取列表")
    public Object list() {
        return WebDTO.success(defaultService.list());
    }
}
