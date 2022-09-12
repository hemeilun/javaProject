package com.boot.controller;


import com.boot.mapper.testMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SqlSession sqlSession;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/hello/{id}")
    public String handle1(@PathVariable("id") Integer id){
        return id+"hello SpringBoot2";
    }

    @GetMapping("/hello/jdbc")
    public String contextLoads() {

//        jdbcTemplate.queryForObject("select * from account_tbl")
//        jdbcTemplate.queryForList("select * from account_tbl",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from person", Long.class);
        return aLong+"";
    }

    @RequestMapping("/hello/mybatis")
    public String mybatisquerry(){
        testMapper mapper = sqlSession.getMapper(testMapper.class);
        return ""+mapper.select();
    }

    @RequestMapping("/hello/redis")
    public String redistest(){

        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        stringStringValueOperations.set("hello","hello redis");
        String hello = stringStringValueOperations.get("hello");
        return hello;
    }
}
