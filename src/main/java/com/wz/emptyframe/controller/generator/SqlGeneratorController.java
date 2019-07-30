package com.wz.emptyframe.controller.generator;

import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.dto.generator.GeneratorField;
import com.wz.emptyframe.dto.generator.GeneratorParamDTO;
import com.wz.emptyframe.util.common.BeanUtil;
import com.wz.emptyframe.util.generator.SqlGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ta0546 wz
 * @time 2019/7/25
 * 自动生成Sql语句
 */
@RestController
@RequestMapping("/generator")
@Api(description = "Sql生成器")
public class SqlGeneratorController {

    private static final String NO_PARAM = "参数不正确！";

    /**
     * 生成插入语句
     * @return
     */
    @PostMapping("/genInsertSql")
    @ApiOperation(value = "生成插入Sql语句")
    public Object genInsertSql(@RequestBody GeneratorParamDTO param) {
        if (param == null) {
            return WebDTO.faliure(NO_PARAM,null);
        }
        StringBuffer data = new StringBuffer();

        for (int i = 0; i < param.getCounts(); i++) {
            List<GeneratorField> fields =  BeanUtil.mapList(param.getFields(),GeneratorField.class);
            data.append(SqlGenerator.genSql(fields,param.getDataBaseType(),param.getTableName()));
            data.append("<br/>");
        }
        return WebDTO.success(data);
    }


}
