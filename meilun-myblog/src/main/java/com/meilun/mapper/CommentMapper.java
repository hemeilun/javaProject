package com.meilun.mapper;

import com.meilun.entiey.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Entity .entiey.Comment
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}




