package com.meilun.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.entiey.Comment;
import com.meilun.service.CommentService;
import com.meilun.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




