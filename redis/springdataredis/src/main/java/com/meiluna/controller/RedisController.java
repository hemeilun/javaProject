package com.meiluna.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meiluna.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @GetMapping("/stringtest")
    public String StringTest(){
        redisTemplate.opsForValue().set("name","wangwu");

        String name = (String) redisTemplate.opsForValue().get("name");
        return name;
    }

    @GetMapping("/stringUserTest")
    public User StringUserTest(){
        redisTemplate.opsForValue().set("user",new User("meilun",23));
        User user = (User) redisTemplate.opsForValue().get("user");
        return user;
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/stringredisTem")
    public User stringredisTem() throws JsonProcessingException {

        User user = new User("meiluna", 18);
        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入
        stringRedisTemplate.opsForValue().set("user",json);

        //获取数据
        String jsonUser = stringRedisTemplate.opsForValue().get("user");
        //反序列化
        User user1 = mapper.readValue(jsonUser, User.class);

        return user1;
    }

}
