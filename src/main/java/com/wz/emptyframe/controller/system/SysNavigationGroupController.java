package com.wz.emptyframe.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wz.emptyframe.entity.system.User;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wz.emptyframe.service.system.SysNavigationGroupService;
import com.wz.emptyframe.dto.WebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wz.emptyframe.entity.system.SysNavigationGroup;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
@RestController
@RequestMapping("/sysNavigationGroup")
@Api(description = "sysNavigationGroup")
public class SysNavigationGroupController {

    @Resource
    @Qualifier("sysNavigationGroupServiceImpl")
    private SysNavigationGroupService defaultService;

    @GetMapping("/get")
    @ApiOperation(value = "获取详情")
    private Object get(String id) {
        return WebDTO.success(defaultService.getById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Object add(@RequestBody SysNavigationGroup sysNavigationGroup) {
        boolean b = defaultService.save(sysNavigationGroup);
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
    public Object update(@RequestBody SysNavigationGroup sysNavigationGroup) {
        boolean b = defaultService.updateById(sysNavigationGroup);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取列表")
    public Object list() {
        return WebDTO.success(defaultService.list());
    }
}
