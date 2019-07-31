package com.wz.emptyframe.controller.system;

import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.query.system.UserQuery;
import com.wz.emptyframe.serivce.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ta0546 wz
 * @time 2018/12/28
 */
@RestController
@RequestMapping("/sys")
@Api(description = "用户相关")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @RequestMapping(value = "/getUserList",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取用户信息")
    public Object getUserList(UserQuery query) {
        Object data = userService.list();
        return WebDTO.success(data);
    }

}
