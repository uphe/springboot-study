package com.hzy;

import com.hzy.mapper.UserMapper;
import com.hzy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Springboot07MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() throws SQLException {
        List<User> users = userMapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
