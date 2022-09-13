package com.example.mybatis_plus.SpringTest;

import com.example.mybatis_plus.mapper.UserMapper;
import com.example.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test {

    @Autowired
    UserMapper userMapper;

    @Test
    public void querryUser(){
        List<User> users = userMapper.selectList(null);
        for (User user:users) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUser(){

        User user = new User();
        user.setName("zhangsan");
        user.setAge(19);
        user.setEmail("zhangsan@123.com");
        userMapper.insert(user);
        System.out.println(user.getUid());
    }
}
