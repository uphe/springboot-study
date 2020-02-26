package com.hzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot03WebApplication {

    // 启动之后，默认访问static下的index页面
    public static void main(String[] args) {
        SpringApplication.run(Springboot03WebApplication.class, args);
    }

}
