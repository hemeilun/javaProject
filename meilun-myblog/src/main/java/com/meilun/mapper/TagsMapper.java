package com.meilun.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.meilun.entiey.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity .entiey.Tags
 */
@Mapper
@Repository
public interface TagsMapper extends BaseMapper<Tags> {

    //根据用户id查询所有tags
    IPage<Tags> selectAllTagsByUid( IPage<Tags> page,@Param("uid") long uid );

}




