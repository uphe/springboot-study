package com.hzy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/*
* 在yaml中配置好数据库相关信息之后
* 只需要用@Autowired注解自动装配数据源
* 就可以通过getConnection()方法获得连接
* */
@SpringBootTest
class Springboot06JdbcApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        // 我测的输出：HikariProxyConnection@2025198278 wrapping com.mysql.cj.jdbc.ConnectionImpl@257e0827
        System.out.println(connection);
        connection.close();
    }
}
