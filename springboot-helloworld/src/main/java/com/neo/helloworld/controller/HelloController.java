package com.neo.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/10/27 16:26
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "home")
public class HelloController {

    @RequestMapping(value = "/hi")
    public String sayHi(){
        return "Hello SpringBoot.";
    }

    @RequestMapping(value = "/yes")
    public String sayYes(){
        return "SpringBoot YES";
    }

    @RequestMapping(value = "/good")
    public String sayGood(){
        return "SpringBoot is good";
    }

}
