package com.hzy.mapper;

import com.hzy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper // 表示这是mybatis的一个mapper类
@Repository //相当于@Component
public interface UserMapper {
    List<User> queryAllUser();
    User queryUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
