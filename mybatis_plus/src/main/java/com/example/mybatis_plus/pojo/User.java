package com.example.mybatis_plus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data //lombok注解
public class User {

    @TableId(type = IdType.AUTO)
    private Long uid;

    //此处注释内必须与数据库中名称相同
    //mybatisplus可以自动将驼峰转化为_的形式
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
}

