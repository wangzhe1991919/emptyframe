package com.wz.emptyframe;

import com.wz.emptyframe.mapper.UserMapper;
import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import com.wz.emptyframe.serivce.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyframeApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        //List<User> userList = userMapper.selectList(null);

        List<User> userList = userService.list();
        userList.forEach(System.out::println);
    }

}
