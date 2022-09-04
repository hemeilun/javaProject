package com.mybatis.mapper;

import com.mybatis.bean.User;

import java.util.List;

public interface UserMapper {

    /**
     * 添加数据
     */
    int insertUser();

    /**
     * 删除数据
     */
    int deleteUser();

    /**
     * 修改数据
     */
    int updateUser();

    /**
     * 查询数据
     */
    List<User> selectUser();
}
