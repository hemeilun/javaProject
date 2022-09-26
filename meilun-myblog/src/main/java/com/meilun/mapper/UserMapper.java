package com.meilun.mapper;

import com.meilun.entiey.Tags;
import com.meilun.entiey.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.meilun.entiey.User
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {



}




