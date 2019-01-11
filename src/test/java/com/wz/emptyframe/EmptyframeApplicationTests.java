package com.wz.emptyframe;

import com.wz.emptyframe.dao.UserDao;
import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyframeApplicationTests {


    @Autowired
    private UserDao userMapper;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        //List<User> userList = userMapper.selectList(null);

        List<User> userList = userService.list();
        userList.forEach(System.out::println);

        userList.forEach(item -> { System.out.println(item.getAge()); });

        String[] s = {"1","2"};

        Arrays.sort(s,(String s1,String s2) -> (s1.compareTo(s2)));
    }

}
