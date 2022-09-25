package com.meilun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.entiey.Blog;
import com.meilun.service.BlogService;
import com.meilun.mapper.BlogMapper;
import com.meilun.entiey.Blog;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

}




