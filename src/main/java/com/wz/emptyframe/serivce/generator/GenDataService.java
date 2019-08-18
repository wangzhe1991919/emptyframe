package com.wz.emptyframe.serivce.generator;

import com.wz.emptyframe.dto.generator.GeneratorDataQuery;
import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.base.IBaseService;

import java.util.List;

public interface GenDataService extends IBaseService<GenData> {

    /**
     * 生成多条数据
     * @param genTypeId
     * @param content
     * @param split
     */
    void saveMoreContents(int genTypeId,String content,String split);

    /**
     * 根据条件查询
     * @return
     */
    List<GenData> listByParam(GeneratorDataQuery param);
}
