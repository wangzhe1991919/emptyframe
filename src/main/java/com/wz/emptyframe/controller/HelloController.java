package com.wz.emptyframe.controller;

import com.wz.emptyframe.entity.User;
import com.wz.emptyframe.mapper.UserMapper;
import com.wz.emptyframe.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
@Controller
public class HelloController {


    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/hello")
    public String hellTest() {
        List<User> list = userMapper.selectList(null);
        String s = "d";

        list.forEach(System.out::println);
        Function<Integer, Integer> func = p -> p * 10;
        func.apply(1);

        //Consumer printStrConsumer = HelloController::toUpper;

        list.forEach((User user) ->{
            if (user != null) {
                System.out.println("===>" + user.getEmail());
            }
        });
        FileFilter java = (File f) -> f.getName().endsWith("*.java");

        return "index";
    }

    public static void toUpper(String str) {
        System.out.println("upper===>" + str.toUpperCase());
    }


}
