package com.meilun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.common.CommonPage;
import com.meilun.entiey.Blog;
import com.meilun.entiey.Tags;
import com.meilun.service.BlogService;
import com.meilun.mapper.BlogMapper;
import com.meilun.entiey.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

    @Autowired
    BlogMapper blogMapper;

    //查询自己的所有文章
    public CommonPage<Blog> selectAllBlog(long uid,long pageId){

        CommonPage<Blog> page = new CommonPage<>();
        page.setSize(12);
        page.setCurrent(pageId);
        CommonPage<Blog> result = blogMapper.selectAllBlog(page,uid);

        result.DetailProcess();

        return result;
    }


    //查询所有用户公开的文章
    public CommonPage<Blog> selectAllBlogNotOnlyMe(long pageId){

        CommonPage<Blog> page = new CommonPage<>();
        page.setSize(12);
        page.setCurrent(pageId);
        CommonPage<Blog> result = blogMapper.selectAllBlogNotOnlyMe(page);

        result.DetailProcess();

        return result;
    }



}




