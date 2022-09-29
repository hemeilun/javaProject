package com.meilun.service;

import com.meilun.common.CommonPage;
import com.meilun.entiey.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meilun.entiey.Blog;

/**
 *
 */
public interface BlogService extends IService<Blog> {

    public CommonPage<Blog> selectAllBlog(long uid,long pageId);

    public CommonPage<Blog> selectAllBlogNotOnlyMe(long pageId);

    CommonPage<Blog> selectAllBlogByTagsId(long tid, long pageId);
}
