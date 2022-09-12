package com.boot.SpringBootTest;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


@Slf4j
@SpringBootTest
public class SpringTest {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from person", Long.class);
//        System.out.println(aLong);
        System.out.println(1);
    }
}
