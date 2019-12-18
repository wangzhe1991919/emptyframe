package com.wz.emptyframe.service.system;

import com.wz.emptyframe.entity.system.User;
import com.wz.emptyframe.service.base.IBaseService;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
public interface UserService extends IBaseService<User> {


    User findByLoginName(String username);
}
