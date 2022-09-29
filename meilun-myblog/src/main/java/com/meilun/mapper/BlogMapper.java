package com.meilun.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meilun.common.CommonPage;
import com.meilun.entiey.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meilun.entiey.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Entity .entiey.Blog
 */
@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {

    public CommonPage<Blog> selectAllBlog(CommonPage<Blog> page, @Param("uid") long uid);

    public CommonPage<Blog> selectAllBlogNotOnlyMe(CommonPage<Blog> page);

    CommonPage<Blog> selectAllBlogByTagsId(CommonPage<Blog> page, @Param("tid") long tid);
}




