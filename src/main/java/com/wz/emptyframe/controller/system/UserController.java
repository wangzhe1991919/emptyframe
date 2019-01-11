package com.wz.emptyframe.controller.system;

import com.wz.emptyframe.query.system.UserQuery;
import com.wz.emptyframe.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ta0546 wz
 * @time 2018/12/28
 */
@Controller
@RequestMapping("/system")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/getUserList",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object getUserList(UserQuery query) {
        Object data = userService.list();
        //Object data = userMapper.selectList(null);

        Map map = new HashMap();
        map.put("code",0);
        map.put("data",data);
        return map;
    }

}
