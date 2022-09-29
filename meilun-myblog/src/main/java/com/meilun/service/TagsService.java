package com.meilun.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meilun.common.CommonPage;
import com.meilun.entiey.Tags;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface TagsService extends IService<Tags> {

    CommonPage<Tags> selectAllTagsByUid(long uid,long pageId);
//      public IPage<Tags> selectAllTagsByUid(QueryWrapper<Tags> queryWrapper);

    List<Tags> selectAllTagsByUidNotPage(long uid);

    CommonPage<Tags> selectAllTags(long pageId);
}

