package com.wz.emptyframe.controller;

import com.wz.emptyframe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
@Controller
public class HelloController {


    @Autowired
    private com.wz.emptyframe.dao.UserDao UserDao;

    @RequestMapping(value = "/hello")
    public String hellTest() {
        /*List<User> list = userMapper.selectList(null);
        list.forEach((User user) ->{
            if (user != null) {
                user = null;
            }
        });
        list.forEach(System.out::println);*/
        return "index";
    }

    @RequestMapping(value = "/getData")
    @ResponseBody
    public Object getData() {
        List<User> list = UserDao.selectList(null);
        Map map = new HashMap();
        map.put("code",0);
        map.put("data",list);
        return map;
    }

    public static void toUpper(String str) {
        System.out.println("upper===>" + str.toUpperCase());
    }


}
