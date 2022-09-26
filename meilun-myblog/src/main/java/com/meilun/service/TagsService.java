package com.meilun.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meilun.entiey.Tags;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface TagsService extends IService<Tags> {

    IPage<Tags> selectAllTagsByUid(long uid);
//      public IPage<Tags> selectAllTagsByUid(QueryWrapper<Tags> queryWrapper);
}

