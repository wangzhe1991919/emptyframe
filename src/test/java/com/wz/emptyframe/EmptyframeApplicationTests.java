package com.wz.emptyframe;

import com.wz.emptyframe.dao.UserDao;
import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmptyframeApplicationTests {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        //List<User> userList = userDao.selectList(null);

        List<User> userList = userService.list();
        userList.forEach(System.out::println);
    }

}
