package com.meilun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.entiey.Tags;
import com.meilun.service.TagsService;
import com.meilun.mapper.TagsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags>
    implements TagsService{

    @Autowired
    TagsMapper tagsMapper;

    public IPage<Tags> selectAllTagsByUid(long uid){

        Page<Tags> page = new Page<>(1,2);
        IPage<Tags> result = tagsMapper.selectAllTagsByUid(page,uid);

        return result;
    }

}




