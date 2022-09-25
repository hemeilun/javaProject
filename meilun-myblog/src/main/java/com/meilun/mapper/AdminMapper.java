package com.meilun.mapper;

import com.meilun.entiey.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity .entiey.Admin
 */
@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

}




