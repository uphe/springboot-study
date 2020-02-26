package com.hzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
/*
* 这里使用了模板引擎Thymeleaf
* 访问：http://localhost:8080/test，就可以得到model里的数据
* 模板引擎里进行遍历：<div th:each="lis : ${list}" th:text="${lis}"></div>
* */

@Controller
public class HelloController {
    @RequestMapping("/test")
    public String test(Model model) {
        List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("def");
        list.add("ghi");

        model.addAttribute("list",list);
        return "test";
    }
}
