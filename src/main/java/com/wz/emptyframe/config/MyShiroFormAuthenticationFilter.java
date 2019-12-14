package com.wz.emptyframe.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wz.emptyframe.dto.WebDTO;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class MyShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(MyShiroFormAuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                return true;
            }
        } else {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;
            if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [{}]" ,this.getLoginUrl());
                }
                //在这里实现自己想返回的信息，其他地方和源码一样就可以了

                resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
                resp.setHeader("Access-Control-Allow-Credentials", "true");
                resp.setContentType("application/json; charset=utf-8");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                Object resultJson  = WebDTO.response(HttpStatus.FOUND.value(),"没有权限，请先登录!",request.getParameter("redirect_url"));
                //设置为空的字段也输出JSON，如果所有地方都需要，则要做全局配置
                out.print(JSON.toJSONString(resultJson, SerializerFeature.WriteMapNullValue));
                out.flush();
                out.close();
                return false;
            }
        }
    }
}
