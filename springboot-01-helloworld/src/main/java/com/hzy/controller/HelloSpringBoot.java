package com.hzy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {
    // 访问：http://localhost:8080/hello
    @RequestMapping("/hello")
    public String show() {
        return "HelloSpringBoot";
    }
}
