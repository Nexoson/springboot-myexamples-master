package com.neo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName UserController
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/10/27 16:33
 * @Version 1.0
 **/

@Controller
public class UserController {


    @RequestMapping(value = "home")
    public String goHome(Map<String,Object> paramMap){

        paramMap.put("name","张三");
        paramMap.put("age",35);
        return "index";
    }
}
