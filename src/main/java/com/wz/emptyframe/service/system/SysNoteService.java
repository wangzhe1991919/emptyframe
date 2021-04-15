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

    /**
     * 获取当前用户最新的一条笔记内容
     * @return
     */
    Object listNewCurrUser();

    /**
     * 保存当前用户最新一条笔记，然后复制并新建一条
     * @return
     */
    SysNote saveAndCreateNote(SysNote sysNote);
}
