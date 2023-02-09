package com.meiluna.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meiluna.commonutils.R;
import com.meiluna.eduservice.entity.EduTeacher;
import com.meiluna.eduservice.entity.vo.TeacherQuery;
import com.meiluna.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-11-06
 */

@Api("讲师相关操作")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;


    @ApiOperation("添加讲师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        eduTeacherService.save(eduTeacher);
        return R.ok();
    }

    @ApiOperation("修改讲师")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        eduTeacherService.updateById(eduTeacher);
        return R.ok();
    }


    @GetMapping("/")
    @ApiOperation(value = "查询所有讲师")
    public R getAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("list",list);
    }


    @PostMapping("/getTeacherPage/{current}/{limit}")
    @ApiOperation(value = "带条件分页查询讲师")
    public R getTeacherPageVo(@PathVariable Long current,
                              @PathVariable Long limit,
                              @RequestBody TeacherQuery teacherQuery){

        //@RequestBody把json转化为实体类
        //1、取出查询条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        //不为空，则拼接
        QueryWrapper<EduTeacher> eduTeacherQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            eduTeacherQueryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            eduTeacherQueryWrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            eduTeacherQueryWrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)){
            eduTeacherQueryWrapper.le("gmt_create",end);
        }


        Page<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page,eduTeacherQueryWrapper);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();

        Map<String , Object> map = new HashMap<>();
        map.put("list",records);
        map.put("total",total);

        return R.ok().data(map);
    }



    @DeleteMapping("/del/{id}")
    @ApiOperation("删除讲师")
    public R deleteTeacher(@PathVariable String id){
        eduTeacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("/getTeacherById/{id}")
    public R getTeacherById(@PathVariable String id){
        EduTeacher byId = eduTeacherService.getById(id);
        return R.ok().data("eduTeacher",byId);
    }

}

