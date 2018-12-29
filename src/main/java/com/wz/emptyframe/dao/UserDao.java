package com.wz.emptyframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.emptyframe.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends BaseMapper<User> {

}
