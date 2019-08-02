package com.wz.emptyframe.controller.generator;


import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.entity.generator.GenType;
import com.wz.emptyframe.serivce.generator.GenDataService;
import com.wz.emptyframe.serivce.generator.GenTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //IntSummaryStatistics ids = genTypeList.stream().mapToInt((x) -> x.getId()).summaryStatistics();
        if (count > 0) {
            return WebDTO.response(500,"类型名重复",null);
        }
        genTypeService.save(genType);
        return WebDTO.success();
    }

    @PostMapping("insertGenData")
    @ApiOperation(value = "添加要生成的数据")
    public Object insertGenData(@RequestBody GenData genData) {
        if (genData.getContent() == null || genData.getGenTypeId() == 0) {
            return WebDTO.response(500,"参数错误或不完整",null);
        }
        genDataService.saveMoreContents(genData);
        return WebDTO.success();
    }

}
