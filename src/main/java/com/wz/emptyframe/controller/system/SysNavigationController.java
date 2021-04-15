package com.wz.emptyframe.controller.system;


import com.wz.emptyframe.entity.system.SysNote;
import com.wz.emptyframe.service.system.SysNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wz.emptyframe.service.system.SysNavigationService;
import com.wz.emptyframe.dto.WebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wz.emptyframe.entity.system.SysNavigation;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Autowired
    @Qualifier("sysNoteServiceImpl")
    private SysNoteService sysNoteService;

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

    @PostMapping("/listIndex")
    @ApiOperation(value = "导航页获取列表")
    public Object listIndex() {
        return WebDTO.success(defaultService.listDetailIndex());
    }

    @PostMapping("/addNote")
    @ApiOperation(value = "添加或修改笔记")
    public Object addNote(@RequestBody SysNote sysNote) {
        Object result = sysNoteService.saveOrUpdate(sysNote)?WebDTO.success(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))):WebDTO.faliure();
        return result;
    }

    @GetMapping("/getNote")
    @ApiOperation(value = "获取当前用户笔记")
    public Object getNote() {
        return sysNoteService.listNewCurrUser();
    }

    @PostMapping("/saveAndCreateNote")
    @ApiOperation(value = "保存并创建新的笔记")
    public Object saveAndCreateNote(@RequestBody SysNote sysNote) {
        return WebDTO.success(sysNoteService.saveAndCreateNote(sysNote));
    }
}
