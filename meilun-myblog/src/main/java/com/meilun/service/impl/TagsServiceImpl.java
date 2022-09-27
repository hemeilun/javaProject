package com.meilun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meilun.common.CommonPage;
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

    public CommonPage<Tags> selectAllTagsByUid(long uid,long pageId){

        CommonPage<Tags> page = new CommonPage<>();
        page.setSize(10);
        page.setCurrent(pageId);
        CommonPage<Tags> result = tagsMapper.selectAllTagsByUid(page,uid);

        result.DetailProcess();
//        System.out.println(result);
//        System.out.println("curret: " + result.getCurrent());
        return result;
    }

}




