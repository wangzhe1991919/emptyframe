package com.wz.emptyframe.controller.system;


import org.springframework.web.bind.annotation.RequestMapping;
import com.wz.emptyframe.service.system.SysNavigationService;
import com.wz.emptyframe.dto.WebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wz.emptyframe.entity.system.SysNavigation;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhe
 * @since 2020-01-21
 */
@RestController
@RequestMapping("/sysNavigation")
@Api(description = "sysNavigation")
public class SysNavigationController {

    @Autowired
    @Qualifier("sysNavigationServiceImpl")
    private SysNavigationService defaultService;

    @GetMapping("/get")
    @ApiOperation(value = "获取详情")
    private Object get(String id) {
        return WebDTO.success(defaultService.getById(id));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Object add(@RequestBody SysNavigation sysNavigation) {
        return defaultService.insert(sysNavigation);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public Object delete(String id) {
        boolean b = defaultService.removeById(id);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改")
    public Object update(@RequestBody SysNavigation sysNavigation) {
        boolean b = defaultService.updateById(sysNavigation);
        return b?WebDTO.success():WebDTO.faliure(null,null);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取列表")
    public Object list() {
        return WebDTO.success(defaultService.listDetail());
    }
}
