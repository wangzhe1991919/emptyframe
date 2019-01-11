package com.wz.emptyframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.emptyframe.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
