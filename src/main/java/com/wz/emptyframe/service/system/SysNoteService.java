package com.wz.emptyframe.service.system;

import com.wz.emptyframe.entity.system.SysNote;
import com.wz.emptyframe.service.base.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
public interface SysNoteService extends IBaseService<SysNote> {

    Object listCurrUser();
}
