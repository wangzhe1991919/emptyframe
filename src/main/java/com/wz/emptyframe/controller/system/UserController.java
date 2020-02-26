package com.wz.emptyframe.controller.system;

import com.wz.emptyframe.dto.WebDTO;
import com.wz.emptyframe.query.system.UserQuery;
import com.wz.emptyframe.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public Object login(String username, String password) {
        String errMsg = null;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject currentUser = SecurityUtils.getSubject();
        //登录永不超时
        SecurityUtils.getSubject().getSession().setTimeout(-1000l);
        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            errMsg = "用户名和密码不匹配";
        } catch (IncorrectCredentialsException ice) {
            errMsg = "用户名和密码不匹配";
        } catch (LockedAccountException lae) {
            errMsg = "LockedAccountException";
        } catch (ExcessiveAttemptsException eae) {
            errMsg = "ExcessiveAttemptsException";
        } catch (AuthenticationException ae) {
            errMsg = "AuthenticationException";
        }
        if (errMsg == null) {
            return WebDTO.success();
        }
        return WebDTO.faliure(errMsg,null);
    }


    @RequestMapping(value = "/getUserList",method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取用户信息")
    public Object getUserList(UserQuery query) {
        Object data = userService.list();
        return WebDTO.success(data);
    }

}
