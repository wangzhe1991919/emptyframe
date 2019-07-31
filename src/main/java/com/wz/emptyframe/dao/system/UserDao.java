package com.wz.emptyframe.dao.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wz.emptyframe.entity.system.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {

}
