package com.hzy;

import com.hzy.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

    // 运行可得如下
    // Person{name='hzy', age=20, happy=true, birth=Wed Nov 25 00:00:00 CST 2020,
    // map={Java=A, MySQL=B, Linux=C}, list=[music, code], dog=Dog{name='旺财', age=3}}


}
