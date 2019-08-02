package com.wz.emptyframe.serivce.generator;

import com.wz.emptyframe.entity.generator.GenData;
import com.wz.emptyframe.serivce.base.IBaseService;

public interface GenDataService extends IBaseService<GenData> {

    /**
     * 生成多条数据
     * @param genData
     */
    void saveMoreContents(GenData genData);
}
