package com.wz.emptyframe.serivce.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.system.UserDao;
import com.wz.emptyframe.entity.system.User;
import com.wz.emptyframe.serivce.system.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService{

}
