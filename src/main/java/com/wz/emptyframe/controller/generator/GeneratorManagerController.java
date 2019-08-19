package com.wz.emptyframe.controller.generator;


import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.dto.generator.GeneratorDataQuery;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.entity.generator.GenType;
import com.wz.emptyframe.serivce.generator.GenDataService;
import com.wz.emptyframe.serivce.generator.GenTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genManager")
@Api(description = "管理生成数据类型及数据")
public class GeneratorManagerController {

    @Autowired
    @Qualifier("genTypeServiceImpl")
    private GenTypeService genTypeService;


    @Autowired
    @Qualifier("genDataServiceImpl")
    private GenDataService genDataService;


    @PostMapping("/insertGenType")
    @ApiOperation(value = "添加生成数据的类型")
    public Object insertGenType(@RequestBody GenType genType) {
        List<GenType> genTypeList = genTypeService.list();
        //查看是否名称重复
        long count = genTypeList.stream().filter(o -> o.getName().equals(genType.getName())).count();
        //获取当前ID最大值
        if (genType == null || count > 0) {
            return WebDTO.response(500,"类型名重复",null);
        }
        genTypeService.save(genType);
        return WebDTO.success();
    }

    @PostMapping("/insertGenData")
    @ApiOperation(value = "添加要生成的数据")
    public Object insertGenData(int genTypeId,String content,String split) {
        if (content == null || genTypeId == 0|| split == null) {
            return WebDTO.response(500,"参数错误或不完整",null);
        }
        genDataService.saveMoreContents(genTypeId,content,split);
        return WebDTO.success();
    }

    @PostMapping("/getGenTypeList")
    @ApiOperation(value = "获取类型列表")
    public Object getGenTypeList() {
        return WebDTO.success(genTypeService.list());
    }

    @PostMapping("/getGenDataList")
    @ApiOperation(value = "获取数据列表")
    public Object getGenDataList(GeneratorDataQuery param) {
        return WebDTO.success(genDataService.listByParam(param));
    }

    @DeleteMapping("/deleteGenType")
    @ApiOperation("删除需要生成数据的数据类型")
    public Object deleteGenType(String id) {
        return WebDTO.success(genTypeService.removeById(id));
    }

    @DeleteMapping("/deleteGenData")
    @ApiOperation("删除数据")
    public Object deleteGenData(@RequestParam(value="ids[]")List<String> ids) {
        return WebDTO.success(genDataService.removeByIds(ids));
    }
}
