package com.hzy.controller;

import com.hzy.annotation.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hzy
 * @Date: 2020/12/29
 */
@RestController
public class MyTest {
    @MyLog(value = "aaaaaaaaaaaaaaa")
    @GetMapping("/test")
    public String sourceC(){
        return "hello";
    }
}
