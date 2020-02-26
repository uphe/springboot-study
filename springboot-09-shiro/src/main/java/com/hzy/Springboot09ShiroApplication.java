package com.hzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 项目启动后，访问：http://localhost:8080，可以看到登录的链接
* 点击登录后，账号：root，密码：root，可以访问update
* 账号：123，密码：123，可以访问add
* 账号：hzy，密码：hzy，不能访问add和update
* */
@SpringBootApplication
public class Springboot09ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09ShiroApplication.class, args);
    }

}
