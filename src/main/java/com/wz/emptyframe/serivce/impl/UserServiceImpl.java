package com.wz.emptyframe.serivce.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.emptyframe.dao.UserDao;
import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService{

}