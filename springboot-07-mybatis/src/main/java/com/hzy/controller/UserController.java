package com.hzy.controller;

import com.hzy.mapper.UserMapper;
import com.hzy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryAllUser")
    public List<User> queryAllUser() {
        List<User> users = userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
