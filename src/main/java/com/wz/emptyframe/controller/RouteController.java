package com.wz.emptyframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ta0546 wz
 * @time 2018/12/7
 */
@Controller
public class RouteController {


    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/sqlGenerator")
    public String sqlGenerator() {
        return "generator/sqlGenerator";
    }

}
