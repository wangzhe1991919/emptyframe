package com.wz.emptyframe.service.system;

import com.wz.emptyframe.entity.system.SysNavigation;
import com.wz.emptyframe.service.base.IBaseService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangzhe
 * @since 2020-01-21
 */
public interface SysNavigationService extends IBaseService<SysNavigation> {

    /**
     * 添加
     * @param sysNavigation
     * @return
     */
    Object insert(SysNavigation sysNavigation);
}
