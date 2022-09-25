package com.meilun.mapper;

import com.meilun.entiey.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meilun.entiey.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity .entiey.Blog
 */
@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

}




