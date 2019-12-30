package com.wz.emptyframe.service.infoboard;

import com.wz.emptyframe.entity.infoboard.Infoboard;
import com.wz.emptyframe.service.base.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzhe
 * @since 2019-12-30
 */
public interface InfoboardService extends IBaseService<Infoboard> {


    Object listConvert();
}
