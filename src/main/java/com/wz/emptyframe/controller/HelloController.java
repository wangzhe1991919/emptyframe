package com.wz.emptyframe.controller;

import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String hellTest() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
        return "index";
    }

}
