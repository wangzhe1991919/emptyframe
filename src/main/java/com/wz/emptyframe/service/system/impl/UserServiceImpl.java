package com.wz.emptyframe.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.system.UserDao;
import com.wz.emptyframe.entity.system.User;
import com.wz.emptyframe.service.system.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService{


    @Override
    public User findByLoginName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_id",username);
        User user = getOne(queryWrapper);
        return user;
    }
}
